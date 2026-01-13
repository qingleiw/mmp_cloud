<template>
  <div class="app-container">
    <!-- 页面头部 -->
    <div class="page-header">
      <h1>死亡病例讨论管理</h1>
      <p>管理系统中的死亡病例讨论记录，包括讨论过程、结论和参与人员等功能</p>
      <div class="flex gap-2">
        <el-button type="primary" icon="i-ep:Plus" @click="handleAdd" v-hasPermi="['system:deathCaseDiscussion:add']">新增</el-button>
        <el-button type="success" icon="i-ep:Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:deathCaseDiscussion:edit']"
          >修改</el-button
        >
        <el-button type="danger" icon="i-ep:Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:deathCaseDiscussion:remove']"
          >删除</el-button
        >
        <el-button type="warning" icon="i-ep:Download" @click="handleExport" v-hasPermi="['system:deathCaseDiscussion:export']">导出</el-button>
        <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
      </div>
    </div>

    <!-- 搜索区域 -->
    <div class="search-card" v-show="showSearch">
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="68px">
        <el-form-item label="患者姓名" prop="patientName">
          <el-input v-model="queryParams.patientName" placeholder="请输入患者姓名" clearable style="width: 200px" @keyup.enter="handleQuery" />
        </el-form-item>
        <el-form-item label="讨论日期" prop="discussionDate">
          <el-date-picker
            v-model="queryParams.discussionDate"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            value-format="YYYY-MM-DD"
            :default-time="[new Date(2000, 1, 1, 0, 0, 0), new Date(2000, 1, 1, 23, 59, 59)]"
          />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="i-ep:Search" @click="handleQuery">搜索</el-button>
          <el-button icon="i-ep:Refresh" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>
    </div>

    <!-- 表格区域 -->
    <div class="table-card">
      <el-table v-loading="loading" :data="deathCaseList" @selection-change="handleSelectionChange" class="modern-table">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="讨论ID" align="center" prop="id" v-if="false" />
        <el-table-column label="租户ID" align="center" prop="tenantId" v-if="false" />
        <el-table-column label="患者姓名" align="center" prop="patientName" />
        <el-table-column label="年龄" align="center" prop="patientAge" width="80" />
        <el-table-column label="性别" align="center" prop="patientGender" width="80">
          <template #default="scope">
            <span>{{ scope.row.patientGender === '1' ? '男' : '女' }}</span>
          </template>
        </el-table-column>
        <el-table-column label="死亡日期" align="center" prop="deathDate" width="120" />
        <el-table-column label="死亡原因" align="center" prop="deathReason" show-overflow-tooltip />
        <el-table-column label="主持人ID" align="center" prop="moderatorId" v-if="false" />
        <el-table-column label="讨论主持人" align="center" prop="moderatorName" />
        <el-table-column label="讨论日期" align="center" prop="discussionDate" width="120" />
        <el-table-column label="参与人数" align="center" prop="participantCount" width="100" />
        <el-table-column label="讨论参与人" align="center" prop="discussionParticipants" v-if="false" />
        <el-table-column label="讨论过程" align="center" prop="discussionProcess" v-if="false" />
        <el-table-column label="讨论结论" align="center" prop="discussionConclusion" v-if="false" />
        <el-table-column label="改进措施" align="center" prop="improvementMeasures" v-if="false" />
        <el-table-column label="状态" align="center" prop="status" width="100">
          <template #default="scope">
            <el-tag :type="scope.row.status === '1' ? 'success' : 'info'">
              {{ scope.row.status === '1' ? '已完成' : '进行中' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="删除标志" align="center" prop="delFlag" v-if="false" />
        <el-table-column label="创建时间" align="center" prop="createTime" width="180" v-if="false">
          <template #default="scope">
            <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="创建人" align="center" prop="createBy" v-if="false" />
        <el-table-column label="创建部门" align="center" prop="createDept" v-if="false" />
        <el-table-column label="更新时间" align="center" prop="updateTime" width="180" v-if="false">
          <template #default="scope">
            <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d} {h}:{i}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="更新人" align="center" prop="updateBy" v-if="false" />
        <el-table-column label="备注" align="center" prop="remark" v-if="false" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="120">
          <template #default="scope">
            <div class="flex items-center justify-center space-x-1">
              <el-tooltip content="查看" placement="top">
                <el-button link type="primary" icon="i-ep:View" @click="handleView(scope.row)" size="small">查看</el-button>
              </el-tooltip>
              <el-tooltip content="修改" placement="top">
                <el-button link type="primary" icon="i-ep:Edit" @click="handleUpdate(scope.row)" size="small">修改</el-button>
              </el-tooltip>
              <el-tooltip content="删除" placement="top">
                <el-button link type="danger" icon="i-ep:Delete" @click="handleDelete(scope.row)" size="small">删除</el-button>
              </el-tooltip>
            </div>
          </template>
        </el-table-column>
      </el-table>

      <!-- 分页组件 -->
      <div class="pagination-container mt-4">
        <el-pagination
          v-show="total > 0"
          v-model:current-page="queryParams.pageNum"
          v-model:page-size="queryParams.pageSize"
          :page-sizes="[10, 20, 50, 100]"
          :total="total"
          background
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        />
      </div>
    </div>

    <!-- 讨论详情对话框 -->
    <el-dialog :title="title" v-model="open" width="800px" append-to-body>
      <el-form :model="form" :rules="rules" ref="deathCaseForm" label-width="100px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="患者姓名" prop="patientName">
              <el-input v-model="form.patientName" placeholder="请输入患者姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="年龄" prop="patientAge">
              <el-input-number v-model="form.patientAge" :min="0" :max="150" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="性别" prop="patientGender">
              <el-select v-model="form.patientGender" placeholder="请选择性别">
                <el-option label="男" value="1" />
                <el-option label="女" value="2" />
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="死亡日期" prop="deathDate">
              <el-date-picker v-model="form.deathDate" type="date" placeholder="选择死亡日期" value-format="YYYY-MM-DD" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="死亡原因" prop="deathReason">
          <el-input v-model="form.deathReason" type="textarea" :rows="3" placeholder="请输入死亡原因" />
        </el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item label="主持人" prop="moderatorName">
              <el-input v-model="form.moderatorName" placeholder="请输入主持人姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="讨论日期" prop="discussionDate">
              <el-date-picker v-model="form.discussionDate" type="date" placeholder="选择讨论日期" value-format="YYYY-MM-DD" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="讨论内容" prop="discussionContent">
          <el-input v-model="form.discussionContent" type="textarea" :rows="6" placeholder="请输入讨论内容和结论" />
        </el-form-item>
        <el-form-item label="参与人员" prop="participants">
          <el-input v-model="form.participants" type="textarea" :rows="2" placeholder="请输入参与讨论的人员名单" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio label="0">进行中</el-radio>
            <el-radio label="1">已完成</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="cancel">取 消</el-button>
          <el-button type="primary" @click="submitForm">确 定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="DeathCaseDiscussion" lang="ts">
import { listDeathCase, getDeathCase, delDeathCase, addDeathCase, updateDeathCase } from '@/api/system/deathCaseDiscussion';
import { DeathCaseDiscussionForm } from '@/api/system/deathCaseDiscussion/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

// 搜索参数
const queryParams = reactive({
  pageNum: 1,
  pageSize: 10,
  patientName: '',
  discussionDate: []
});

// 表单参数
const form = reactive<DeathCaseDiscussionForm>({});
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref('');
const deathCaseList = ref([]);
const deathCaseForm = ref();

// 表单校验
const rules = {
  patientName: [{ required: true, message: '患者姓名不能为空', trigger: 'blur' }],
  patientAge: [{ required: true, message: '年龄不能为空', trigger: 'blur' }],
  patientGender: [{ required: true, message: '性别不能为空', trigger: 'change' }],
  deathDate: [{ required: true, message: '死亡日期不能为空', trigger: 'change' }],
  deathReason: [{ required: true, message: '死亡原因不能为空', trigger: 'blur' }],
  moderatorName: [{ required: true, message: '主持人不能为空', trigger: 'blur' }],
  discussionDate: [{ required: true, message: '讨论日期不能为空', trigger: 'change' }],
  discussionContent: [{ required: true, message: '讨论内容不能为空', trigger: 'blur' }]
};

/** 查询死亡病例讨论列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listDeathCase(queryParams);
    deathCaseList.value = res.rows.map((item: any) => ({
      ...item,
      participantCount: item.participants ? item.participants.split(',').length : 0
    }));
    total.value = res.total;
  } catch (error) {
    console.error('获取死亡病例讨论列表失败:', error);
    deathCaseList.value = [];
    total.value = 0;
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  open.value = false;
  reset();
};

/** 表单重置 */
const reset = () => {
  Object.assign(form, {
    id: null,
    patientName: '',
    patientAge: null,
    patientGender: '1',
    deathDate: '',
    deathReason: '',
    moderatorName: '',
    discussionDate: '',
    discussionContent: '',
    participants: '',
    status: '0'
  });
  deathCaseForm.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  (proxy?.$refs.queryForm as ElFormInstance)?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: any) => {
  ids.value = selection.map((item: any) => item.id);
  single.value = selection.length !== 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  open.value = true;
  title.value = '添加死亡病例讨论';
};

/** 修改按钮操作 */
const handleUpdate = (row?: any) => {
  reset();
  const id = row?.id || ids.value[0];
  getDeathCase(id)
    .then((response: any) => {
      Object.assign(form, response.data);
      open.value = true;
      title.value = '修改死亡病例讨论';
    })
    .catch((error: any) => {
      console.error('获取死亡病例讨论详情失败:', error);
      proxy?.$modal.msgError('获取数据失败');
    });
};

/** 查看按钮操作 */
const handleView = (row: any) => {
  const id = row.id || ids.value[0];
  getDeathCase(id)
    .then((response: any) => {
      Object.assign(form, response.data);
      open.value = true;
      title.value = '查看死亡病例讨论';
    })
    .catch((error: any) => {
      console.error('获取死亡病例讨论详情失败:', error);
      proxy?.$modal.msgError('获取数据失败');
    });
};

/** 提交按钮 */
const submitForm = () => {
  deathCaseForm.value?.validate((valid: boolean) => {
    if (valid) {
      // 计算参与人数
      const formData = { ...form } as any;
      if (formData.participants) {
        formData.participantCount = formData.participants.split(',').length;
      } else {
        formData.participantCount = 0;
      }

      if (formData.id != null) {
        updateDeathCase(formData)
          .then((response: any) => {
            proxy?.$modal.msgSuccess('修改成功');
            open.value = false;
            getList();
          })
          .catch((error: any) => {
            console.error('修改死亡病例讨论失败:', error);
            proxy?.$modal.msgError('修改失败');
          });
      } else {
        addDeathCase(formData)
          .then((response: any) => {
            proxy?.$modal.msgSuccess('新增成功');
            open.value = false;
            getList();
          })
          .catch((error: any) => {
            console.error('新增死亡病例讨论失败:', error);
            proxy?.$modal.msgError('新增失败');
          });
      }
    }
  });
};

/** 删除按钮操作 */
const handleDelete = (row?: any) => {
  const _ids = row?.id || ids.value;
  proxy?.$modal
    .confirm('是否确认删除死亡病例讨论编号为"' + _ids + '"的数据项？')
    .then(() => {
      return delDeathCase(_ids);
    })
    .then(() => {
      getList();
      proxy?.$modal.msgSuccess('删除成功');
    })
    .catch((error: any) => {
      console.error('删除死亡病例讨论失败:', error);
      proxy?.$modal.msgError('删除失败');
    });
};

/** 分页大小改变 */
const handleSizeChange = (val: number) => {
  queryParams.pageSize = val;
  getList();
};

/** 分页页码改变 */
const handleCurrentChange = (val: number) => {
  queryParams.pageNum = val;
  getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/deathCaseDiscussion/export',
    {
      ...queryParams
    },
    `deathCaseDiscussion_${new Date().getTime()}.xlsx`
  );
};
</script>

<style scoped>
.app-container {
  background-color: #f5f5f5;
  min-height: 100vh;
  padding: 20px;
}

.page-header {
  margin-bottom: 20px;
}

.page-header h1 {
  color: #1d2129;
  font-size: 1.5rem;
  font-weight: 600;
  margin-bottom: 8px;
}

.page-header p {
  color: #666;
  margin: 0;
}

.search-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
  margin-bottom: 20px;
  transition: box-shadow 0.3s ease;
}

.search-card:hover {
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.table-card {
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.modern-table {
  border-radius: 8px;
  overflow: hidden;
}

.modern-table .el-table__header {
  background-color: #fafafa;
}

.modern-table .el-table__row {
  transition: background-color 0.3s ease;
}

.modern-table .el-table__row:hover {
  background-color: #f5f5f5;
}

.pagination-container {
  display: flex;
  justify-content: center;
  padding: 20px 0;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header {
    text-align: center;
  }

  .page-header .flex {
    flex-direction: column;
    align-items: center;
    gap: 16px;
  }

  .search-form {
    flex-direction: column;
  }

  .search-form .el-form-item {
    width: 100%;
  }
}

@media (max-width: 480px) {
  .app-container {
    padding: 5px;
  }

  .page-header h1 {
    font-size: 1.25rem;
  }
}
</style>
