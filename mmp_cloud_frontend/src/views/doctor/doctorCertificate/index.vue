<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-document-checked class="title-icon"></i-ep-document-checked>
        医师证书管理
      </h2>
      <p class="page-description">管理医师各类资格证书、执业证书、职称证书等资质信息</p>
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
            <span>证书信息列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorCertificate:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['doctor:doctorCertificate:edit']"
              size="small"
            >修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorCertificate:remove']"
              size="small"
            >删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorCertificate:export']" size="small">导出</el-button>
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
        :data="doctorCertificateList"
        @selection-change="handleSelectionChange"
        class="doctor-certificate-table"
      >
        <el-table-column type="selection" width="55" align="center" />
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
            <span v-if="field.prop === 'issueDate' || field.prop === 'validDate'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <!-- 删除标志字段 -->
            <el-tag v-else-if="field.prop === 'delFlag'" :type="scope.row.delFlag === '0' ? 'success' : 'danger'" size="small">
              {{ scope.row.delFlag === '0' ? '未删除' : '已删除' }}
            </el-tag>
            <!-- 是否长期有效字段 -->
            <el-tag v-else-if="field.prop === 'isPermanent'" :type="scope.row.isPermanent === '1' ? 'success' : 'info'" size="small">
              {{ scope.row.isPermanent === '1' ? '是' : '否' }}
            </el-tag>
            <!-- 时间字段格式化 -->
            <span v-else-if="field.prop === 'createTime' || field.prop === 'updateTime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>
            <!-- 证书URL字段 -->
            <span v-else-if="field.prop === 'certificateUrl'">
              <el-link v-if="scope.row.certificateUrl" :href="scope.row.certificateUrl" target="_blank" type="primary">查看证书</el-link>
              <span v-else>无</span>
            </span>
            <!-- 默认显示 -->
            <span v-else>{{ scope.row[field.prop] }}</span>
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
                v-hasPermi="['doctor:doctorCertificate:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorCertificate:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加或修改资质证书对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="700px" append-to-body>
      <el-form ref="doctorCertificateFormRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="医生ID" prop="doctorId">
              <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证书类型" prop="certificateType">
              <el-input v-model="form.certificateType" placeholder="请输入证书类型" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="证书名称" prop="certificateName">
              <el-input v-model="form.certificateName" placeholder="请输入证书名称" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="证书编号" prop="certificateNo">
              <el-input v-model="form.certificateNo" placeholder="请输入证书编号" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="发证单位" prop="issueUnit">
              <el-input v-model="form.issueUnit" placeholder="请输入发证单位" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="发证日期" prop="issueDate">
              <el-date-picker
                clearable
                v-model="form.issueDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择发证日期"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="有效期至" prop="validDate">
              <el-date-picker
                clearable
                v-model="form.validDate"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择有效期至"
                style="width: 100%"
              />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否长期有效" prop="isPermanent">
              <el-select v-model="form.isPermanent" placeholder="请选择是否长期有效" clearable style="width: 100%">
                <el-option label="是" value="1" />
                <el-option label="否" value="0" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="证书URL" prop="certificateUrl">
              <el-input v-model="form.certificateUrl" placeholder="请输入证书URL" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态" prop="status">
              <el-input v-model="form.status" placeholder="请输入状态" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="提醒天数" prop="remindDays">
              <el-input-number v-model="form.remindDays" :min="0" :max="365" controls-position="right" style="width: 100%" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="是否删除" prop="delFlag">
              <el-select v-model="form.delFlag" placeholder="请选择状态" clearable style="width: 100%">
                <el-option label="未删除" value="0" />
                <el-option label="已删除" value="1" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="20">
          <el-col :span="24">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" type="textarea" :rows="3" placeholder="请输入备注" />
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
    <!-- 搜索项配置对话框 -->
    <SearchConfigDialog v-model:visible="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorCertificate" lang="ts">
import { listDoctorCertificate, getDoctorCertificate, delDoctorCertificate, addDoctorCertificate, updateDoctorCertificate } from '@/api/doctor/doctorCertificate';
import { DoctorCertificateVO, DoctorCertificateQuery, DoctorCertificateForm } from '@/api/doctor/doctorCertificate/types';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';
import { createDoctorCertificateFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { createDoctorCertificateSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import type { FormInstance } from 'element-plus';
import type { DialogOption } from '@/types/global';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorCertificateList = ref<DoctorCertificateVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const doctorCertificateFormRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 配置管理器
const fieldConfigManager = createDoctorCertificateFieldConfig();
const searchConfigManager = createDoctorCertificateSearchConfig();
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 配置对话框状态
const fieldConfigVisible = ref(false);
const searchConfigVisible = ref(false);

const queryParams = reactive<DoctorCertificateQuery>({
  pageNum: 1,
  pageSize: 10,
  doctorId: undefined,
  certificateType: undefined,
  certificateName: undefined,
  certificateNo: undefined,
  issueUnit: undefined,
  issueDate: undefined,
  issueDateStart: undefined,
  issueDateEnd: undefined,
  validDate: undefined,
  validDateStart: undefined,
  validDateEnd: undefined,
  isPermanent: undefined,
  certificateUrl: undefined,
  status: undefined,
  remindDays: undefined,
  delFlag: undefined,
  params: {}
});

const form = reactive<DoctorCertificateForm>({
  id: undefined,
  doctorId: undefined,
  certificateType: undefined,
  certificateName: undefined,
  certificateNo: undefined,
  issueUnit: undefined,
  issueDate: undefined,
  validDate: undefined,
  isPermanent: undefined,
  certificateUrl: undefined,
  status: undefined,
  remindDays: undefined,
  remark: undefined,
  delFlag: undefined
});

const rules = {
  id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
  doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
};

const { queryParams: queryParamsRef, form: formRef } = toRefs(reactive({ queryParams, form }));
const rulesRef = rules;

/** 查询资质证书列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorCertificate(queryParams);
  doctorCertificateList.value = res.rows;
  total.value = res.total;
  loading.value = false;
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  formRef.value = { ...form };
  doctorCertificateFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  // 处理daterange字段，将数组转换为start/end字段
  if (queryParams.issueDate && Array.isArray(queryParams.issueDate)) {
    queryParams.issueDateStart = queryParams.issueDate[0];
    queryParams.issueDateEnd = queryParams.issueDate[1];
  } else {
    queryParams.issueDateStart = undefined;
    queryParams.issueDateEnd = undefined;
  }

  if (queryParams.validDate && Array.isArray(queryParams.validDate)) {
    queryParams.validDateStart = queryParams.validDate[0];
    queryParams.validDateEnd = queryParams.validDate[1];
  } else {
    queryParams.validDateStart = undefined;
    queryParams.validDateEnd = undefined;
  }

  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: DoctorCertificateVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加资质证书';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorCertificateVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorCertificate(_id);
  Object.assign(formRef.value, res.data);
  dialog.visible = true;
  dialog.title = '修改资质证书';
};

/** 提交按钮 */
const submitForm = () => {
  doctorCertificateFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (formRef.value.id) {
        await updateDoctorCertificate(formRef.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorCertificate(formRef.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorCertificateVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除资质证书编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorCertificate(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorCertificate/export',
    {
      ...queryParams
    },
    `doctorCertificate_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 搜索配置按钮操作 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  getList();
});
</script>

<style scoped>
.app-container {
  background-color: #f5f5f5;
  min-height: 100vh;
  padding: 20px;
}

.page-header {
  background: white;
  padding: 20px;
  border-radius: 8px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .page-title {
    display: flex;
    align-items: center;
    gap: 8px;
    margin: 0 0 8px 0;
    color: #1d2129;
    font-size: 18px;
    font-weight: 600;

    .title-icon {
      color: #409eff;
      font-size: 20px;
    }
  }

  .page-description {
    margin: 0;
    color: #86909c;
    font-size: 14px;
  }
}

.search-card {
  background: white;
  border-radius: 8px;
  margin-bottom: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .search-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 16px;

    .search-title {
      font-weight: 600;
      color: #1d2129;
      display: flex;
      align-items: center;
      gap: 6px;

      .search-icon {
        color: #409eff;
      }
    }

    .search-actions {
      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
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
    margin-bottom: 16px;

    .table-title {
      font-weight: 600;
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
      align-items: center;

      .config-btn {
        color: #409eff;

        .btn-icon {
          margin-right: 4px;
        }
      }
    }
  }
}

.doctor-certificate-table {
  :deep(.el-table__header) {
    th {
      background-color: #fafafa;
      font-weight: 600;
      color: #1d2129;
    }
  }

  :deep(.el-table__row) {
    &:hover {
      background-color: #f5f7fa;
    }
  }
}

@media (max-width: 768px) {
  .app-container {
    padding: 12px;
  }

  .page-header {
    .page-title {
      font-size: 20px;
    }
  }

  .table-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 12px;

    .table-actions {
      width: 100%;
      justify-content: flex-end;
    }
  }
}
</style>