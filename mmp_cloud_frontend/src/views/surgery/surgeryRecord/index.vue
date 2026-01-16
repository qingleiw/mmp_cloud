<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-first-aid-kit class="title-icon"></i-ep-first-aid-kit>
        手术记录管理
      </h2>
      <p class="page-description">管理系统手术记录信息，包括手术基本信息、手术过程、术后情况和并发症等</p>
    </div>

    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="search-container mb-4">
        <el-card shadow="hover" class="search-card">
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
              <div class="search-actions">
                <el-button text type="primary" @click="toggleSearchConfig" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  搜索配置
                </el-button>
              </div>
            </div>
          </template>
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>
      </div>
    </transition>

    <!-- 数据表格 -->
    <el-card shadow="hover" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-data-analysis class="table-icon"></i-ep-data-analysis>
            手术记录列表
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain @click="handleAdd" v-hasPermi="['surgery:surgeryRecord:add']">
              <i-ep-plus class="btn-icon"></i-ep-plus>
              新增
            </el-button>
            <el-button type="success" plain :disabled="single" @click="handleUpdate()" v-hasPermi="['surgery:surgeryRecord:edit']">
              <i-ep-edit class="btn-icon"></i-ep-edit>
              修改
            </el-button>
            <el-button type="danger" plain :disabled="multiple" @click="handleDelete()" v-hasPermi="['surgery:surgeryRecord:remove']">
              <i-ep-delete class="btn-icon"></i-ep-delete>
              删除
            </el-button>
            <el-button type="warning" plain @click="handleExport" v-hasPermi="['surgery:surgeryRecord:export']">
              <i-ep-download class="btn-icon"></i-ep-download>
              导出
            </el-button>
            <el-button type="info" plain @click="handleImport" v-hasPermi="['surgery:surgeryRecord:import']">
              <i-ep-upload class="btn-icon"></i-ep-upload>
              导入
            </el-button>
            <el-button text type="primary" @click="toggleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="surgeryRecordList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column
          v-for="field in fieldConfigManager.getVisibleFields()"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width"
          :min-width="field.minWidth || 120"
          resizable
        >
          <template #default="scope">
            <!-- 日期字段格式化 -->
            <span v-if="field.prop === 'surgeryStartTime' || field.prop === 'surgeryEndTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <!-- 并发症标志字段 -->
            <el-tag v-else-if="field.prop === 'complicationFlag'" :type="getComplicationTagType(scope.row[field.prop])">
              {{ getComplicationLabel(scope.row[field.prop]) }}
            </el-tag>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="getStatusTagType(scope.row[field.prop])">
              {{ getStatusLabel(scope.row[field.prop]) }}
            </el-tag>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['surgery:surgeryRecord:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['surgery:surgeryRecord:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改手术记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="surgeryRecordFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="患者姓名" prop="patientName">
              <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="主刀医生" prop="doctorId">
              <el-select v-model="form.doctorId" placeholder="请选择主刀医生" filterable clearable style="width: 100%">
                <el-option v-for="doctor in doctorOptions" :key="doctor.doctorId" :label="doctor.doctorName" :value="doctor.doctorId" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="手术科室名称" prop="departmentName">
              <el-input v-model="form.departmentName" placeholder="请输入手术科室名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手术编码" prop="surgeryCode">
              <el-input v-model="form.surgeryCode" placeholder="请输入手术编码" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="手术名称" prop="surgeryName">
              <el-input v-model="form.surgeryName" placeholder="请输入手术名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手术等级" prop="surgeryLevel">
              <el-select v-model="form.surgeryLevel" placeholder="请选择手术等级" style="width: 100%">
                <el-option label="一级" value="一级" />
                <el-option label="二级" value="二级" />
                <el-option label="三级" value="三级" />
                <el-option label="四级" value="四级" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="麻醉方式" prop="anesthesiaMethod">
              <el-select v-model="form.anesthesiaMethod" placeholder="请选择麻醉方式" style="width: 100%">
                <el-option label="全身麻醉" value="全身麻醉" />
                <el-option label="局部麻醉" value="局部麻醉" />
                <el-option label="椎管内麻醉" value="椎管内麻醉" />
                <el-option label="神经阻滞" value="神经阻滞" />
                <el-option label="其他" value="其他" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="ASA分级" prop="asaGrade">
              <el-select v-model="form.asaGrade" placeholder="请选择ASA分级" style="width: 100%">
                <el-option label="ASA I" value="ASA I" />
                <el-option label="ASA II" value="ASA II" />
                <el-option label="ASA III" value="ASA III" />
                <el-option label="ASA IV" value="ASA IV" />
                <el-option label="ASA V" value="ASA V" />
                <el-option label="ASA VI" value="ASA VI" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="手术开始时间" prop="surgeryStartTime">
              <el-date-picker
                clearable
                v-model="form.surgeryStartTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择手术开始时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="手术结束时间" prop="surgeryEndTime">
              <el-date-picker
                clearable
                v-model="form.surgeryEndTime"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择手术结束时间"
                style="width: 100%"
              >
              </el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="手术时长(分钟)" prop="surgeryDuration">
              <el-input-number v-model="form.surgeryDuration" :min="0" placeholder="请输入手术时长" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="失血量(ml)" prop="bloodLoss">
              <el-input-number v-model="form.bloodLoss" :min="0" placeholder="请输入失血量" style="width: 100%" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="是否有并发症" prop="complicationFlag">
              <el-select v-model="form.complicationFlag" placeholder="请选择" style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="删除标志" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
                <el-option label="正常" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>

  <!-- 搜索配置对话框 -->
  <SearchConfigDialog v-model="showSearchConfig" :search-config-manager="searchConfigManager" />

  <!-- 字段配置对话框 -->
  <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
</template>

<script setup name="SurgeryRecord" lang="ts">
import { ref, reactive, computed, onMounted, getCurrentInstance, type ComponentInternalInstance } from 'vue';
import { listSurgeryRecord, getSurgeryRecord, delSurgeryRecord, addSurgeryRecord, updateSurgeryRecord } from '@/api/surgery/surgeryRecord';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { SurgeryRecordVO, SurgeryRecordQuery, SurgeryRecordForm } from '@/api/surgery/surgeryRecord/types';
import { createSurgeryRecordFieldConfig } from '@/utils/configs/surgery/surgeryFieldConfigs';
import { createSurgeryRecordSearchConfig } from '@/utils/configs/surgery/surgerySearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import type { ElFormInstance } from 'element-plus';
import type { DialogOption, PageData } from '@/types/global';
import { parseTime } from '@/utils/ruoyi';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const surgeryRecordList = ref<SurgeryRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showSearchConfig = ref(false);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const doctorOptions = ref<any[]>([]);

// 字段配置管理器
const fieldConfigManager = createSurgeryRecordFieldConfig();

// 搜索配置管理器
const searchConfigManager = createSurgeryRecordSearchConfig();

// 可见搜索字段
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const queryFormRef = ref<ElFormInstance>();
const surgeryRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SurgeryRecordForm = {
  id: undefined,
  surgeryRecordId: undefined,
  applicationId: undefined,
  patientId: undefined,
  patientName: undefined,
  doctorId: undefined,
  doctorName: undefined,
  departmentId: undefined,
  departmentName: undefined,
  surgeryCode: undefined,
  surgeryName: undefined,
  surgeryLevel: undefined,
  surgeryType: undefined,
  anesthesiaMethod: undefined,
  surgeryStartTime: undefined,
  surgeryEndTime: undefined,
  surgeryDuration: undefined,
  asaGrade: undefined,
  bloodLoss: undefined,
  surgeryStatus: undefined,
  complicationFlag: undefined,
  delFlag: undefined
};
const data = reactive<PageData<SurgeryRecordForm, SurgeryRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    patientName: undefined,
    doctorName: undefined,
    departmentName: undefined,
    surgeryCode: undefined,
    surgeryName: undefined,
    surgeryLevel: undefined,
    surgeryType: undefined,
    anesthesiaMethod: undefined,
    surgeryStartTime: undefined,
    surgeryEndTime: undefined,
    surgeryDuration: undefined,
    asaGrade: undefined,
    bloodLoss: undefined,
    surgeryStatus: undefined,
    complicationFlag: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    patientName: [{ required: true, message: '患者姓名不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '主刀医生不能为空', trigger: 'change' }],
    departmentName: [{ required: true, message: '手术科室名称不能为空', trigger: 'blur' }],
    surgeryCode: [{ required: true, message: '手术编码不能为空', trigger: 'blur' }],
    surgeryName: [{ required: true, message: '手术名称不能为空', trigger: 'blur' }],
    surgeryStartTime: [{ required: true, message: '手术开始时间不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询手术记录列表 */
const getList = async () => {
  try {
    loading.value = true;
    const res = await listSurgeryRecord(queryParams.value);
    surgeryRecordList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取手术记录列表失败:', error);
    surgeryRecordList.value = [];
    total.value = 0;
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  surgeryRecordFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: SurgeryRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加手术记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SurgeryRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSurgeryRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改手术记录';
};

/** 提交按钮 */
const submitForm = () => {
  surgeryRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSurgeryRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSurgeryRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SurgeryRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除手术记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSurgeryRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy.$modal.upload({
    url: '/dev-api/surgery/surgeryRecord/importData',
    success: () => {
      proxy.$modal.msgSuccess('导入成功');
      getList();
    }
  });
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'surgery/surgeryRecord/export',
    {
      ...queryParams.value
    },
    `surgeryRecord_${new Date().getTime()}.xlsx`
  );
};

/** 加载医师选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorBasicInfo({ pageNum: 1, pageSize: 1000 });
    doctorOptions.value = res.rows || [];
  } catch (error) {
    console.error('加载医师选项失败:', error);
    doctorOptions.value = [];
  }
};

/** 切换搜索配置 */
const toggleSearchConfig = () => {
  showSearchConfig.value = true;
};

/** 切换字段配置 */
const toggleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
  // 配置更新后可以在这里添加额外的逻辑，比如重新获取数据等
};

/** 获取并发症状态标签类型 */
const getComplicationTagType = (flag: string | number) => {
  return flag === '1' || flag === 1 ? 'danger' : 'success';
};

/** 获取并发症状态标签文本 */
const getComplicationLabel = (flag: string | number) => {
  return flag === '1' || flag === 1 ? '有并发症' : '无并发症';
};

/** 获取状态标签类型 */
const getStatusTagType = (status: string | number) => {
  return status === '1' || status === 1 ? 'danger' : 'success';
};

/** 获取状态标签文本 */
const getStatusLabel = (status: string | number) => {
  return status === '1' || status === 1 ? '已删除' : '正常';
};

onMounted(() => {
  getList();
  loadDoctorOptions();
});
</script>

<style scoped>
.page-header .page-description {
  font-size: 13px;
  color: #86909c;
  line-height: 1.6;
}
.search-card .search-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  min-height: 44px;
}
.search-card .search-title {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}
.table-card {
  background: #fff;
  border-radius: 8px;
  padding: 12px;
}
.table-header {
  display: flex;
  align-items: center;
  gap: 12px;
  min-height: 44px;
  padding: 6px 8px;
}
.table-title {
  display: inline-flex;
  align-items: center;
  gap: 8px;
}
.table-actions {
  margin-left: auto;
  display: inline-flex;
  align-items: center;
  gap: 8px;
  flex-wrap: nowrap;
}
</style>
