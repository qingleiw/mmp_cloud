<template>
  <div class="app-container">
    <!-- 页面标题 -->
    <div class="page-header mb-4">
      <h2 class="page-title">
        <i-ep-user class="title-icon"></i-ep-user>
        手术团队管理
      </h2>
      <p class="page-description">管理系统手术团队成员信息，包括医生角色、资格验证等</p>
    </div>

    <!-- 动态搜索表单 -->
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover" class="search-card">
          <template #header>
            <div class="search-header">
              <span class="search-title">
                <i-ep-search class="search-icon"></i-ep-search>
                搜索条件
              </span>
            </div>
            <div class="search-actions">
              <el-button text type="primary" @click="toggleSearchConfig" class="config-btn">
                <i-ep-setting class="btn-icon"></i-ep-setting>
                搜索配置
              </el-button>
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

    <el-card shadow="never" class="table-card">
      <template #header>
        <div class="table-header">
          <div class="table-title">
            <i-ep-list class="table-icon"></i-ep-list>
            手术团队列表
            <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
          </div>
          <div class="table-actions">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['surgery:surgeryTeam:add']">新增</el-button>
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['surgery:surgeryTeam:edit']"
              >修改</el-button
            >
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['surgery:surgeryTeam:remove']"
              >删除</el-button
            >
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['surgery:surgeryTeam:export']">导出</el-button>
            <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
              <i-ep-setting class="btn-icon"></i-ep-setting>
              字段配置
            </el-button>
            <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
          </div>
        </div>
      </template>

      <el-table v-loading="loading" border :data="surgeryTeamList" @selection-change="handleSelectionChange" class="surgery-team-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="医生姓名" align="center" prop="doctorName" min-width="120">
          <template #default="scope">
            <div class="doctor-cell">
              <i-ep-user class="doctor-icon"></i-ep-user>
              <span class="doctor-name">{{ scope.row.doctorName }}</span>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="角色类型" align="center" prop="roleType" width="120">
          <template #default="scope">
            <el-tag :type="getRoleTypeTagType(scope.row.roleType)">
              {{ scope.row.roleType }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="资格验证" align="center" prop="qualificationVerify" width="100">
          <template #default="scope">
            <el-tag :type="scope.row.qualificationVerify === '1' ? 'success' : 'warning'">
              {{ scope.row.qualificationVerify === '1' ? '已验证' : '未验证' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="状态" align="center" prop="delFlag" width="80">
          <template #default="scope">
            <el-tag :type="scope.row.delFlag === '0' ? 'success' : 'danger'">
              {{ scope.row.delFlag === '0' ? '正常' : '已删除' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" fixed="right" width="120" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" @click="handleUpdate(scope.row)" v-hasPermi="['surgery:surgeryTeam:edit']">
                <i-ep-edit class="btn-icon"></i-ep-edit>
              </el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="danger" @click="handleDelete(scope.row)" v-hasPermi="['surgery:surgeryTeam:remove']">
                <i-ep-delete class="btn-icon"></i-ep-delete>
              </el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改手术团队对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="surgeryTeamFormRef" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="医生" prop="doctorId">
          <el-select v-model="form.doctorId" placeholder="请选择医生" filterable clearable style="width: 100%">
            <el-option v-for="doctor in doctorOptions" :key="doctor.doctorId" :label="doctor.doctorName" :value="doctor.doctorId" />
          </el-select>
        </el-form-item>
        <el-form-item label="角色类型" prop="roleType">
          <el-select v-model="form.roleType" placeholder="请选择角色类型" style="width: 100%">
            <el-option label="主刀" value="主刀" />
            <el-option label="一助" value="一助" />
            <el-option label="二助" value="二助" />
            <el-option label="巡回护士" value="巡回护士" />
            <el-option label="器械护士" value="器械护士" />
            <el-option label="麻醉师" value="麻醉师" />
          </el-select>
        </el-form-item>
        <el-form-item label="资格验证" prop="qualificationVerify">
          <el-select v-model="form.qualificationVerify" placeholder="请选择资格验证状态" style="width: 100%">
            <el-option label="已验证" value="1" />
            <el-option label="未验证" value="0" />
          </el-select>
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-select v-model="form.delFlag" placeholder="请选择删除标志" style="width: 100%">
            <el-option label="正常" value="0" />
            <el-option label="已删除" value="1" />
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>

  <!-- 字段配置对话框 -->
  <FieldConfigDialog :visible="showFieldConfig" :field-config-manager="fieldConfigManager" @update:visible="showFieldConfig = $event" />
  <!-- 搜索配置对话框 -->
  <SearchConfigDialog v-model="showSearchConfig" :search-config-manager="searchConfigManager" />
</template>

<script setup name="SurgeryTeam" lang="ts">
import { listSurgeryTeam, getSurgeryTeam, delSurgeryTeam, addSurgeryTeam, updateSurgeryTeam } from '@/api/surgery/surgeryTeam';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { SurgeryTeamVO, SurgeryTeamQuery, SurgeryTeamForm } from '@/api/surgery/surgeryTeam/types';
import { createSurgeryTeamFieldConfig } from '@/utils/fieldConfig';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import { createSurgeryTeamSearchConfig } from '@/utils/mmpSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const surgeryTeamList = ref<SurgeryTeamVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const showSearchConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const doctorOptions = ref<any[]>([]);

// 字段配置管理器
const fieldConfigManager = createSurgeryTeamFieldConfig();
// 搜索配置管理器
const searchConfigManager = createSurgeryTeamSearchConfig();
// 可见搜索字段
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const queryFormRef = ref<ElFormInstance>();
const surgeryTeamFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SurgeryTeamForm = {
  id: undefined,
  surgeryRecordId: undefined,
  doctorId: undefined,
  doctorName: undefined,
  roleType: undefined,
  qualificationVerify: undefined,
  delFlag: undefined
};
const data = reactive<PageData<SurgeryTeamForm, SurgeryTeamQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorName: undefined,
    roleType: undefined,
    qualificationVerify: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    doctorId: [{ required: true, message: '医生不能为空', trigger: 'change' }],
    roleType: [{ required: true, message: '角色类型不能为空', trigger: 'change' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询手术团队列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSurgeryTeam(queryParams.value);
  surgeryTeamList.value = res.rows;
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
  form.value = { ...initFormData };
  surgeryTeamFormRef.value?.resetFields();
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
/** 切换搜索配置 */
const toggleSearchConfig = () => {
  showSearchConfig.value = true;
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: SurgeryTeamVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加手术团队';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SurgeryTeamVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSurgeryTeam(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改手术团队';
};

/** 提交按钮 */
const submitForm = () => {
  surgeryTeamFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSurgeryTeam(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSurgeryTeam(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SurgeryTeamVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除手术团队编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSurgeryTeam(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'surgery/surgeryTeam/export',
    {
      ...queryParams.value
    },
    `surgeryTeam_${new Date().getTime()}.xlsx`
  );
};

/** 获取角色类型标签类型 */
const getRoleTypeTagType = (roleType: string): 'success' | 'info' | 'warning' | 'primary' | 'danger' => {
  const roleMap: Record<string, 'success' | 'info' | 'warning' | 'primary' | 'danger'> = {
    '主刀': 'danger',
    '一助': 'warning',
    '二助': 'info',
    '巡回护士': 'success',
    '器械护士': 'primary',
    '麻醉师': 'info'
  };
  return roleMap[roleType] || 'info';
};

/** 加载医师选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorInfo({ pageNum: 1, pageSize: 1000 });
    doctorOptions.value = res.rows || [];
  } catch (error) {
    console.error('加载医师选项失败:', error);
  }
};

onMounted(() => {
  getList();
  loadDoctorOptions();
});
</script>

<style scoped lang="scss">
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: calc(100vh - 84px);
}

.page-header {
  margin-bottom: 20px;

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #303133;
    margin-bottom: 8px;
    display: flex;
    align-items: center;
    gap: 8px;

    .title-icon {
      color: #409eff;
      font-size: 28px;
    }
  }

  .page-description {
    color: #606266;
    font-size: 14px;
    line-height: 1.5;
  }
}

.search-container {
  margin-bottom: 20px;

  .search-card {
    .search-header {
      display: flex;
      align-items: center;
      gap: 8px;

      .search-title {
        font-weight: 500;
        color: #303133;
        display: flex;
        align-items: center;
        gap: 6px;

        .search-icon {
          color: #67c23a;
          font-size: 16px;
        }
      }
    }
  }
}

.table-card {
  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 16px;

    .table-title {
      font-weight: 500;
      color: #303133;
      display: flex;
      align-items: center;
      gap: 8px;

      .table-icon {
        color: #e6a23c;
        font-size: 18px;
      }

      .record-count {
        color: #909399;
        font-size: 14px;
        font-weight: normal;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      flex-wrap: wrap;

      .btn-icon {
        font-size: 14px;
      }
    }
  }
}

.surgery-team-table {
  .doctor-cell {
    display: flex;
    align-items: center;
    gap: 6px;

    .doctor-icon {
      color: #409eff;
      font-size: 16px;
    }

    .doctor-name {
      font-weight: 500;
      color: #303133;
    }
  }

  .btn-icon {
    font-size: 14px;
  }
}

.btn-icon {
  font-size: 14px;
}

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 15px;
  }

  .page-header {
    .page-title {
      font-size: 20px;

      .title-icon {
        font-size: 24px;
      }
    }
  }

  .table-header {
    flex-direction: column;
    align-items: stretch;

    .table-title {
      justify-content: center;
    }

    .table-actions {
      justify-content: center;
    }
  }
}

@media (max-width: 480px) {
  .search-container {
    .el-col {
      margin-bottom: 16px;
    }
  }
}
</style>
