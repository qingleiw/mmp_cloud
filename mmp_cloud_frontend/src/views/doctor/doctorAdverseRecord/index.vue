<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-warning class="title-icon"></i-ep-warning>
        医师不良记录管理
      </h2>
      <p class="page-description">管理医师的不良行为记录、违规事件、处罚情况等信息</p>
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
                <el-button text type="primary" @click="handleSearchConfig" class="config-btn">
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
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>不良记录信息列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorAdverseRecord:add']" size="small"
              >新增</el-button
            >
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorAdverseRecord:edit']"
              size="small"
              >修改</el-button
            >
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorAdverseRecord:remove']"
              size="small"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorAdverseRecord:export']" size="small"
              >导出</el-button
            >
            <el-button type="primary" plain icon="Upload" @click="handleImport" v-hasPermi="['doctor:doctorAdverseRecord:import']" size="small"
              >导入</el-button
            >
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table
        v-loading="loading"
        border
        :data="doctorAdverseRecordList"
        @selection-change="handleSelectionChange"
        class="doctor-adverse-record-table"
      >
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width"
        >
          <template #default="scope" v-if="field.prop === 'occurDate' || field.prop === 'createTime' || field.prop === 'updateTime'">
            <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
          </template>
          <template #default="scope" v-else-if="field.prop === 'delFlag'">
            <el-tag :type="scope.row[field.prop] === 0 ? 'success' : 'danger'">
              {{ scope.row[field.prop] === 0 ? '否' : '是' }}
            </el-tag>
          </template>
          <template #default="scope" v-else-if="field.prop === 'doctorId'">
            <span>{{ getDoctorName(scope.row.doctorId) }}</span>
          </template>
          <template #default="scope" v-else>
            {{ scope.row[field.prop] }}
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button
                link
                type="primary"
                icon="Edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['doctor:doctorAdverseRecord:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorAdverseRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改不良行为记录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="600px" append-to-body>
      <el-form ref="doctorAdverseRecordFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col v-for="field in visibleColumns" :key="field.prop" :span="field.formSpan || 24">
            <el-form-item :label="field.label" :prop="field.prop" v-if="field.prop !== 'createTime' && field.prop !== 'updateTime'">
              <el-input v-if="field.type === 'input' || !field.type" v-model="form[field.prop]" :placeholder="`请输入${field.label}`" />
              <el-input v-else-if="field.type === 'textarea'" v-model="form[field.prop]" type="textarea" :placeholder="`请输入${field.label}`" />
              <el-date-picker
                v-else-if="field.type === 'datetime'"
                clearable
                v-model="form[field.prop]"
                type="datetime"
                value-format="YYYY-MM-DD HH:mm:ss"
                :placeholder="`请选择${field.label}`"
              />
              <el-date-picker
                v-else-if="field.type === 'date'"
                clearable
                v-model="form[field.prop]"
                type="date"
                value-format="YYYY-MM-DD"
                :placeholder="`请选择${field.label}`"
              />
              <el-select v-else-if="field.type === 'select'" v-model="form[field.prop]" :placeholder="`请选择${field.label}`">
                <el-option v-for="option in field.options" :key="option.value" :label="option.label" :value="option.value" />
              </el-select>
              <el-switch v-else-if="field.type === 'switch'" v-model="form[field.prop]" active-text="是" inactive-text="否" />
              <span v-else>{{ form[field.prop] }}</span>
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
    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="fieldConfigVisible" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorAdverseRecord" lang="ts">
import {
  listDoctorAdverseRecord,
  getDoctorAdverseRecord,
  delDoctorAdverseRecord,
  addDoctorAdverseRecord,
  updateDoctorAdverseRecord
} from '@/api/doctor/doctorAdverseRecord';
import { DoctorAdverseRecordVO, DoctorAdverseRecordQuery, DoctorAdverseRecordForm } from '@/api/doctor/doctorAdverseRecord/types';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import { createDoctorAdverseRecordFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorAdverseRecordSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorAdverseRecordList = ref<DoctorAdverseRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorAdverseRecordFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorAdverseRecordForm = {
  id: undefined,
  doctorId: undefined,
  recordType: undefined,
  recordTitle: undefined,
  occurDate: undefined,
  description: undefined,
  consequence: undefined,
  handlingMeasure: undefined,
  punishment: undefined,
  recordStatus: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorAdverseRecordForm, DoctorAdverseRecordQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    recordType: undefined,
    recordTitle: undefined,
    occurDate: undefined,
    description: undefined,
    consequence: undefined,
    handlingMeasure: undefined,
    punishment: undefined,
    recordStatus: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);
const searchConfigManager = createDoctorAdverseRecordSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 字段配置相关
const fieldConfigManager = createDoctorAdverseRecordFieldConfig();
const fieldConfigVisible = ref(false);
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());

/** 查询不良行为记录列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listDoctorAdverseRecord(queryParams.value);
    let records = res.rows;

    // 获取所有医生信息来映射医生姓名
    if (records.length > 0) {
      const doctorRes = await listDoctorBasicInfo({ pageSize: 1000 }); // 获取所有医生数据
      const doctorMap = new Map();
      doctorRes.rows.forEach((doctor: DoctorBasicInfoVO) => {
        doctorMap.set(doctor.id, doctor.doctorName);
      });

      // 为每个不良记录添加医生姓名
      records = records.map((record: DoctorAdverseRecordVO) => ({
        ...record,
        doctorName: doctorMap.get(record.doctorId) || '未知医生'
      }));
    }

    doctorAdverseRecordList.value = records;
    total.value = res.total;
  } catch (error) {
    console.error('获取不良行为记录列表失败:', error);
    doctorAdverseRecordList.value = [];
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
  doctorAdverseRecordFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorAdverseRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加不良行为记录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorAdverseRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorAdverseRecord(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改不良行为记录';
};

/** 提交按钮 */
const submitForm = () => {
  doctorAdverseRecordFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorAdverseRecord(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorAdverseRecord(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorAdverseRecordVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除不良行为记录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorAdverseRecord(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorAdverseRecord/export',
    {
      ...queryParams.value
    },
    `doctorAdverseRecord_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
  // 配置更新后可以在这里添加额外的逻辑，比如重新获取数据等
};

onMounted(() => {
  getList();
});
</script>

<style lang="scss" scoped>
.app-container {
  background-color: #f5f5f5;
  min-height: 100vh;
  padding: 20px;
}

.page-header {
  background: white;
  padding: 24px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin: 0 0 8px 0;
    display: flex;
    align-items: center;
    gap: 12px;

    .title-icon {
      color: #409eff;
      font-size: 28px;
    }
  }

  .page-description {
    color: #86909c;
    font-size: 14px;
    margin: 0;
  }
}

.search-container {
  .search-card {
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

    .search-header {
      display: flex;
      justify-content: space-between;
      align-items: center;

      .search-title {
        font-size: 16px;
        font-weight: 500;
        color: #1d2129;
        display: flex;
        align-items: center;
        gap: 8px;

        .search-icon {
          color: #409eff;
        }
      }

      .search-actions {
        display: flex;
        gap: 8px;

        .config-btn {
          color: #409eff;

          .btn-icon {
            margin-right: 4px;
          }
        }
      }
    }
  }
}

.table-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;

    .table-title {
      font-size: 16px;
      font-weight: 500;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 8px;

      .table-icon {
        color: #409eff;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      flex-wrap: wrap;

      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.doctor-adverse-record-table {
  .el-table {
    border-radius: 6px;
  }

  .el-table th {
    background-color: #fafafa;
    color: #1d2129;
    font-weight: 600;
  }

  .el-table td {
    color: #1d2129;
  }

  .el-table--border {
    border-radius: 6px;
  }
}

.dialog-footer {
  text-align: right;
}

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header {
    padding: 16px;

    .page-title {
      font-size: 20px;

      .title-icon {
        font-size: 24px;
      }
    }
  }

  .table-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;

    .table-actions {
      width: 100%;
      justify-content: flex-start;
    }
  }

  .search-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;

    .search-actions {
      width: 100%;
      justify-content: flex-start;
    }
  }
}
</style>
