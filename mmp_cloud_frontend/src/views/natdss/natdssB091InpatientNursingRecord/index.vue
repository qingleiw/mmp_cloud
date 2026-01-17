<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-notebook class="title-icon"></i-ep-notebook>
        住院护理记录管理
      </h2>
      <p class="page-description">管理住院患者的护理记录</p>
    </div>

    <!-- 搜索区域 -->
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

    <!-- 表格区域 -->
    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            <span>住院护理记录列表</span>
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:add']" size="small">新增</el-button>
            <el-button
              type="success"
              plain
              icon="Edit"
              :disabled="single"
              @click="handleUpdate()"
              v-hasPermi="['natdss:natdssB091InpatientNursingRecord:edit']"
              size="small"
            >修改</el-button>
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['natdss:natdssB091InpatientNursingRecord:remove']"
              size="small"
            >删除</el-button>
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:export']" size="small">导出</el-button>
            <el-button text type="primary" @click="handleFieldConfig" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <!-- 动态表格 -->
      <el-table
        v-loading="loading"
        border
        :data="natdssB091InpatientNursingRecordList"
        @selection-change="handleSelectionChange"
        class="dynamic-table"
      >
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleTableFields"
          :key="field.prop"
          :label="field.label"
          :prop="field.prop"
          :width="field.width"
          align="center"
          :show-overflow-tooltip="true"
        >
          <template #default="scope">
            <span v-if="field.type === 'datetime'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}') }}
            </span>
            <span v-else-if="field.type === 'date'">
              {{ parseTime(scope.row[field.prop], '{y}-{m}-{d}') }}
            </span>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB091InpatientNursingRecord:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['natdss:natdssB091InpatientNursingRecord:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>

    <!-- 添加/修改对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="800px" append-to-body>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="120px">
        <el-row :gutter="20">
          <el-col :span="12" v-for="field in visibleFormFields" :key="field.prop">
            <el-form-item :label="field.label" :prop="field.prop">
              <el-input v-if="!field.type || field.type === 'text'" v-model="form[field.prop]" :placeholder="'请输入' + field.label" />
              <el-date-picker
                v-else-if="field.type === 'date'"
                v-model="form[field.prop]"
                type="date"
                :placeholder="'选择' + field.label"
                style="width: 100%"
              />
              <el-date-picker
                v-else-if="field.type === 'datetime'"
                v-model="form[field.prop]"
                type="datetime"
                :placeholder="'选择' + field.label"
                style="width: 100%"
              />
              <el-input v-else-if="field.type === 'textarea'" v-model="form[field.prop]" type="textarea" :placeholder="'请输入' + field.label" />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 搜索配置对话框 -->
    <SearchConfigDialog
      v-model:visible="searchConfigVisible"
      :searchConfigManager="searchConfigManager"
      @confirm="handleSearchConfigConfirm"
    />

    <!-- 字段配置对话框 -->
    <FieldConfigDialog
      v-model:visible="fieldConfigVisible"
      :fieldConfigManager="fieldConfigManager"
      @confirm="handleFieldConfigConfirm"
    />
  </div>
</template>

<script setup name="NatdssB091InpatientNursingRecord" lang="ts">
import {
  listNatdssB091InpatientNursingRecord,
  getNatdssB091InpatientNursingRecord,
  delNatdssB091InpatientNursingRecord,
  addNatdssB091InpatientNursingRecord,
  updateNatdssB091InpatientNursingRecord
} from '@/api/natdss/natdssB091InpatientNursingRecord';
import { NatdssB091InpatientNursingRecordVO, NatdssB091InpatientNursingRecordQuery, NatdssB091InpatientNursingRecordForm } from '@/api/natdss/natdssB091InpatientNursingRecord/types';
import { createNatdssB091InpatientNursingRecordFieldConfig } from '@/utils/configs/natdss/natdssFieldConfigs';
import { createNatdssB091InpatientNursingRecordSearchConfig } from '@/utils/configs/natdss/natdssSearchConfigs';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import type { FormInstance } from 'element-plus';
import type { DialogOption } from '@/types/global';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB091InpatientNursingRecordList = ref<NatdssB091InpatientNursingRecordVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const formRef = ref<FormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 字段配置相关变量
const fieldConfigManager = createNatdssB091InpatientNursingRecordFieldConfig();
const fieldConfigVisible = ref(false);
const searchConfigManager = createNatdssB091InpatientNursingRecordSearchConfig();
const searchConfigVisible = ref(false);

// 计算属性：获取可见的搜索字段
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 计算属性：获取可见的表格字段
const visibleTableFields = computed(() => fieldConfigManager.getVisibleFields());

// 计算属性：获取可见的表单字段
const visibleFormFields = computed(() => fieldConfigManager.getVisibleFields());

const initFormData: NatdssB091InpatientNursingRecordForm = {
  id: undefined,
  planCode: undefined,
  planName: undefined,
  drillType: undefined,
  drillScenario: undefined,
  plannedDate: undefined,
  actualDate: undefined,
  location: undefined,
  organizer: undefined,
  participants: undefined,
  objectives: undefined,
  procedures: undefined,
  evaluationCriteria: undefined,
  status: undefined,
  drillResult: undefined,
  lessonsLearned: undefined,
  remark: undefined
};

const queryParams = reactive<NatdssB091InpatientNursingRecordQuery>({
  pageNum: 1,
  pageSize: 10,
  planCode: undefined,
  planName: undefined,
  drillType: undefined,
  drillScenario: undefined,
  plannedDate: undefined,
  actualDate: undefined,
  location: undefined,
  organizer: undefined,
  participants: undefined,
  objectives: undefined,
  procedures: undefined,
  evaluationCriteria: undefined,
  status: undefined,
  lessonsLearned: undefined,
  params: {}
});

const form = reactive<NatdssB091InpatientNursingRecordForm>({ ...initFormData });

const rules = {
  planCode: [{ required: true, message: 'planCode不能为空', trigger: 'blur' }],
  planName: [{ required: true, message: 'planName不能为空', trigger: 'blur' }]
};

/** 查询住院护理记录列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listNatdssB091InpatientNursingRecord(queryParams);
    natdssB091InpatientNursingRecordList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取住院护理记录列表失败:', error);
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
  Object.assign(form, initFormData);
  formRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  // 重置查询参数
  Object.keys(queryParams).forEach(key => {
    if (key !== 'pageNum' && key !== 'pageSize' && key !== 'params') {
      (queryParams as any)[key] = undefined;
    }
  });
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: NatdssB091InpatientNursingRecordVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加应急演练计划';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB091InpatientNursingRecordVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  if (_id) {
    try {
      const res = await getNatdssB091InpatientNursingRecord(_id);
      Object.assign(form, res.data);
      dialog.visible = true;
      dialog.title = '修改应急演练计划';
    } catch (error) {
      console.error('获取应急演练计划详情失败:', error);
      proxy?.$modal.msgError('获取数据失败');
    }
  }
};

/** 提交按钮 */
const submitForm = async () => {
  try {
    buttonLoading.value = true;
    if (form.id) {
      await updateNatdssB091InpatientNursingRecord(form);
      proxy?.$modal.msgSuccess('修改成功');
    } else {
      await addNatdssB091InpatientNursingRecord(form);
      proxy?.$modal.msgSuccess('新增成功');
    }
    dialog.visible = false;
    await getList();
  } catch (error) {
    console.error('提交表单失败:', error);
  } finally {
    buttonLoading.value = false;
  }
};

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB091InpatientNursingRecordVO) => {
  const _ids = row?.id || ids.value;
  try {
    await proxy?.$modal.confirm('是否确认删除应急演练计划编号为"' + _ids + '"的数据项？');
    await delNatdssB091InpatientNursingRecord(_ids);
    proxy?.$modal.msgSuccess('删除成功');
    await getList();
  } catch (error) {
    if (error !== 'cancel') {
      console.error('删除失败:', error);
    }
  }
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/natdssB091InpatientNursingRecord/export',
    {
      ...queryParams
    },
    `natdssB091InpatientNursingRecord_${new Date().getTime()}.xlsx`
  );
};

/** 搜索配置 */
const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};

/** 字段配置 */
const handleFieldConfig = () => {
  fieldConfigVisible.value = true;
};

/** 搜索配置确认 */
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigVisible.value = false;
};

onMounted(() => {
  getList();
});
</script>

<style scoped lang="scss">
.app-container {
  padding: 20px;

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

  .search-container {
    margin-bottom: 16px;

    .search-card {
      border-radius: 8px;
      overflow: hidden;

      .search-header {
        display: flex;
        align-items: center;
        justify-content: space-between;

        .search-title {
          display: flex;
          align-items: center;
          font-size: 14px;
          font-weight: 600;
          color: #303133;

          .search-icon {
            margin-right: 6px;
            font-size: 16px;
          }
        }

        .search-actions {
          .config-btn {
            padding: 4px 8px;

            .btn-icon {
              margin-right: 4px;
            }
          }
        }
      }

      :deep(.el-card__body) {
        padding: 16px;
      }
    }
  }

  .table-card {
    border-radius: 8px;

    .table-header {
      display: flex;
      align-items: center;
      justify-content: space-between;
      flex-wrap: wrap;
      gap: 12px;

      .table-title {
        display: flex;
        align-items: center;
        font-size: 16px;
        font-weight: 600;
        color: #303133;

        .table-icon {
          margin-right: 8px;
          font-size: 18px;
          color: #409eff;
        }
      }

      .table-actions {
        display: flex;
        align-items: center;
        gap: 8px;
        flex-wrap: wrap;

        .action-btn {
          display: flex;
          align-items: center;
          gap: 4px;
        }

        .config-btn {
          padding: 8px 12px;

          .btn-icon {
            margin-right: 4px;
          }
        }
      }
    }

    :deep(.el-table) {
      margin-top: 16px;

      .el-table__header {
        th {
          background-color: #f5f7fa;
          color: #606266;
          font-weight: 600;
        }
      }
    }
  }
}

// 响应式布局
@media (max-width: 768px) {
  .app-container {
    padding: 12px;

    .page-header {
      padding: 12px 16px;

      .page-title {
        font-size: 18px;
      }

      .page-description {
        font-size: 12px;
      }
    }

    .table-card {
      .table-header {
        flex-direction: column;
        align-items: flex-start;

        .table-actions {
          width: 100%;
          justify-content: flex-start;
        }
      }
    }
  }
}
</style>
