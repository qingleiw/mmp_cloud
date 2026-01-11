<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!-- 左侧目录树 -->
      <el-col :span="8">
        <el-card class="tree-card">
          <template #header>
            <span>核心系统目录</span>
          </template>
          <el-tree
            ref="treeRef"
            :data="treeData"
            :props="treeProps"
            :expand-on-click-node="false"
            :highlight-current="true"
            @node-click="handleNodeClick"
            @node-expand="handleNodeExpand"
            @node-collapse="handleNodeCollapse"
          >
            <template #default="{ node, data }">
              <span class="custom-tree-node">
                <span>{{ node.label }}</span>
                <span v-if="data.count" class="count-badge">({{ data.count }})</span>
              </span>
            </template>
          </el-tree>
        </el-card>
      </el-col>

      <!-- 右侧详细信息 -->
      <el-col :span="16">
        <el-card v-if="selectedNode" class="detail-card">
          <template #header>
            <span>{{ selectedNode.label }} - 详细信息</span>
          </template>

          <!-- 基本信息 -->
          <el-descriptions :column="2" border>
            <el-descriptions-item label="名称">{{ selectedNode.label }}</el-descriptions-item>
            <el-descriptions-item label="类型">{{ selectedNode.type || '目录' }}</el-descriptions-item>
            <el-descriptions-item label="编码" v-if="selectedNode.code">{{ selectedNode.code }}</el-descriptions-item>
            <el-descriptions-item label="级别" v-if="selectedNode.level">{{ selectedNode.level }}</el-descriptions-item>
            <el-descriptions-item label="状态" v-if="selectedNode.status">
              <el-tag :type="selectedNode.status === '正常' ? 'success' : 'danger'">
                {{ selectedNode.status }}
              </el-tag>
            </el-descriptions-item>
            <el-descriptions-item label="创建时间" v-if="selectedNode.createTime">{{ selectedNode.createTime }}</el-descriptions-item>
          </el-descriptions>

          <!-- 子项列表 -->
          <el-divider v-if="selectedNode.children && selectedNode.children.length > 0">子项列表</el-divider>
          <el-table v-if="selectedNode.children && selectedNode.children.length > 0" :data="selectedNode.children" style="width: 100%" size="small">
            <el-table-column prop="label" label="名称" width="200"></el-table-column>
            <el-table-column prop="code" label="编码" width="150"></el-table-column>
            <el-table-column prop="type" label="类型" width="100"></el-table-column>
            <el-table-column prop="status" label="状态" width="80">
              <template #default="scope">
                <el-tag :type="scope.row.status === '正常' ? 'success' : 'danger'" size="small">
                  {{ scope.row.status }}
                </el-tag>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="120">
              <template #default="scope">
                <el-button link size="small" @click="handleViewDetail(scope.row)">查看</el-button>
              </template>
            </el-table-column>
          </el-table>

          <!-- 详细信息内容 -->
          <el-divider v-if="selectedNode.description">详细信息</el-divider>
          <div v-if="selectedNode.description" class="detail-content">
            <div v-html="selectedNode.description"></div>
          </div>

          <!-- 相关操作 -->
          <el-divider>操作</el-divider>
          <el-space>
            <el-button type="primary" @click="handleEdit(selectedNode)">编辑</el-button>
            <el-button type="success" @click="handleAddChild(selectedNode)">添加子项</el-button>
            <el-button type="warning" @click="handleMove(selectedNode)">移动</el-button>
            <el-button type="danger" @click="handleDelete(selectedNode)">删除</el-button>
          </el-space>
        </el-card>

        <!-- 默认提示 -->
        <el-card v-else class="detail-card">
          <el-empty description="请在左侧选择一个目录节点查看详细信息">
            <el-button type="primary" @click="handleAddRoot">添加根目录</el-button>
          </el-empty>
        </el-card>
      </el-col>
    </el-row>

    <!-- 编辑对话框 -->
    <el-dialog v-model="editDialogVisible" :title="editMode === 'add' ? '添加目录' : '编辑目录'" width="600px">
      <el-form ref="editFormRef" :model="editForm" :rules="editRules" label-width="100px">
        <el-form-item label="名称" prop="label">
          <el-input v-model="editForm.label" placeholder="请输入目录名称" />
        </el-form-item>
        <el-form-item label="编码" prop="code">
          <el-input v-model="editForm.code" placeholder="请输入目录编码" />
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="editForm.type" placeholder="请选择类型">
            <el-option label="目录" value="目录" />
            <el-option label="指标" value="指标" />
            <el-option label="配置" value="配置" />
            <el-option label="模板" value="模板" />
          </el-select>
        </el-form-item>
        <el-form-item label="级别" prop="level">
          <el-input-number v-model="editForm.level" :min="1" :max="10" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="editForm.status">
            <el-option label="正常" value="正常" />
            <el-option label="禁用" value="禁用" />
          </el-select>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="editForm.description" type="textarea" :rows="4" placeholder="请输入描述信息" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="editDialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleSaveEdit">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts" name="CoreSystemCatalog">
import { ref, reactive, onMounted } from 'vue';
import { ElMessage, ElMessageBox } from 'element-plus';

// 树形数据
const treeData = ref([
  {
    id: 1,
    label: '核心系统',
    code: 'CORE_SYSTEM',
    type: '目录',
    level: 1,
    status: '正常',
    createTime: '2024-01-01',
    description: '医院核心系统目录结构',
    children: [
      {
        id: 2,
        label: '医疗质量管理',
        code: 'QUALITY_MGMT',
        type: '目录',
        level: 2,
        status: '正常',
        createTime: '2024-01-01',
        description: '医疗质量管理相关指标和配置',
        children: [
          {
            id: 3,
            label: '手术质量指标',
            code: 'SURGERY_QUALITY',
            type: '指标',
            level: 3,
            status: '正常',
            createTime: '2024-01-01',
            description: '手术质量相关指标配置'
          },
          {
            id: 4,
            label: '医疗安全指标',
            code: 'SAFETY_INDICATORS',
            type: '指标',
            level: 3,
            status: '正常',
            createTime: '2024-01-01',
            description: '医疗安全相关指标配置'
          }
        ]
      },
      {
        id: 5,
        label: '诊疗流程管理',
        code: 'TREATMENT_PROCESS',
        type: '目录',
        level: 2,
        status: '正常',
        createTime: '2024-01-01',
        description: '诊疗流程管理相关配置',
        children: [
          {
            id: 6,
            label: '手术审批流程',
            code: 'SURGERY_APPROVAL',
            type: '流程',
            level: 3,
            status: '正常',
            createTime: '2024-01-01',
            description: '重大手术审批流程配置'
          },
          {
            id: 7,
            label: '会诊流程',
            code: 'CONSULTATION_PROCESS',
            type: '流程',
            level: 3,
            status: '正常',
            createTime: '2024-01-01',
            description: '多学科会诊流程配置'
          }
        ]
      },
      {
        id: 8,
        label: '系统配置',
        code: 'SYSTEM_CONFIG',
        type: '目录',
        level: 2,
        status: '正常',
        createTime: '2024-01-01',
        description: '系统基础配置',
        children: [
          {
            id: 9,
            label: '用户权限配置',
            code: 'USER_PERMISSIONS',
            type: '配置',
            level: 3,
            status: '正常',
            createTime: '2024-01-01',
            description: '用户角色和权限配置'
          },
          {
            id: 10,
            label: '数据字典',
            code: 'DATA_DICTIONARY',
            type: '配置',
            level: 3,
            status: '正常',
            createTime: '2024-01-01',
            description: '系统数据字典配置'
          }
        ]
      }
    ]
  }
]);

// 树形配置
const treeProps = {
  children: 'children',
  label: 'label'
};

// 选中的节点
const selectedNode = ref(null);
const treeRef = ref();

// 编辑相关
const editDialogVisible = ref(false);
const editMode = ref('add');
const editForm = reactive({
  id: null,
  label: '',
  code: '',
  type: '目录',
  level: 1,
  status: '正常',
  description: ''
});

const editRules = {
  label: [{ required: true, message: '请输入名称', trigger: 'blur' }],
  code: [{ required: true, message: '请输入编码', trigger: 'blur' }],
  type: [{ required: true, message: '请选择类型', trigger: 'change' }],
  level: [{ required: true, message: '请输入级别', trigger: 'blur' }],
  status: [{ required: true, message: '请选择状态', trigger: 'change' }]
};

const editFormRef = ref();

// 节点点击处理
const handleNodeClick = (data) => {
  selectedNode.value = data;
};

// 节点展开处理
const handleNodeExpand = (data) => {
  console.log('展开节点:', data);
};

// 节点折叠处理
const handleNodeCollapse = (data) => {
  console.log('折叠节点:', data);
};

// 查看详情
const handleViewDetail = (row) => {
  selectedNode.value = row;
};

// 编辑
const handleEdit = (node) => {
  editMode.value = 'edit';
  Object.assign(editForm, node);
  editDialogVisible.value = true;
};

// 添加子项
const handleAddChild = (node) => {
  editMode.value = 'add';
  editForm.id = null;
  editForm.label = '';
  editForm.code = '';
  editForm.type = '目录';
  editForm.level = (node.level || 1) + 1;
  editForm.status = '正常';
  editForm.description = '';
  editDialogVisible.value = true;
};

// 添加根目录
const handleAddRoot = () => {
  editMode.value = 'add';
  editForm.id = null;
  editForm.label = '';
  editForm.code = '';
  editForm.type = '目录';
  editForm.level = 1;
  editForm.status = '正常';
  editForm.description = '';
  editDialogVisible.value = true;
};

// 移动
const handleMove = (node) => {
  ElMessage.info('移动功能开发中...');
};

// 删除
const handleDelete = (node) => {
  ElMessageBox.confirm(`确定删除 "${node.label}" 吗？`, '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  })
    .then(() => {
      // 这里应该调用删除API
      ElMessage.success('删除成功');
      // 刷新树形数据
      loadTreeData();
    })
    .catch(() => {
      ElMessage.info('已取消删除');
    });
};

// 保存编辑
const handleSaveEdit = async () => {
  if (!editFormRef.value) return;

  await editFormRef.value.validate((valid) => {
    if (valid) {
      // 这里应该调用保存API
      ElMessage.success(editMode.value === 'add' ? '添加成功' : '编辑成功');
      editDialogVisible.value = false;
      // 刷新树形数据
      loadTreeData();
    } else {
      ElMessage.error('请填写完整信息');
      return false;
    }
  });
};

// 加载树形数据
const loadTreeData = () => {
  // 这里应该调用API获取树形数据
  // 暂时使用静态数据
};

// 初始化
onMounted(() => {
  loadTreeData();
});
</script>

<style scoped>
.app-container {
  padding: 20px;
}

.tree-card {
  height: calc(100vh - 140px);
  overflow-y: auto;
}

.detail-card {
  height: calc(100vh - 140px);
  overflow-y: auto;
}

.custom-tree-node {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
}

.count-badge {
  color: #909399;
  font-size: 12px;
}

.detail-content {
  line-height: 1.6;
  color: #606266;
}

.detail-content :deep(p) {
  margin-bottom: 10px;
}

.detail-content :deep(ul) {
  padding-left: 20px;
}

.detail-content :deep(li) {
  margin-bottom: 5px;
}
</style>
