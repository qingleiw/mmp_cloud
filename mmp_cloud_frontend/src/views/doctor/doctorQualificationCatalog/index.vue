<template>
  <div class="p-2">
    <el-row :gutter="20">
      <!-- 左侧树形目录 -->
      <el-col :span="8">
        <el-card shadow="never" class="tree-card">
          <template #header>
            <div class="flex items-center justify-between">
              <span>资质目录树</span>
              <el-button type="primary" size="small" icon="Refresh" @click="getTreeData">刷新</el-button>
            </div>
          </template>
          <el-tree
            :data="treeData"
            :props="treeProps"
            :expand-on-click-node="false"
            :highlight-current="true"
            :draggable="true"
            :allow-drop="allowDrop"
            @node-click="handleNodeClick"
            @node-drop="handleNodeDrop"
            ref="treeRef"
            node-key="id"
            default-expand-all
          >
            <template #default="{ node, data }">
              <span class="tree-node">
                <span>{{ node.label }}</span>
                <el-tag v-if="data.catalogLevel" size="small" type="info" class="ml-2">
                  {{ getLevelText(data.catalogLevel) }}
                </el-tag>
              </span>
            </template>
          </el-tree>
        </el-card>
      </el-col>

      <!-- 右侧内容区域 -->
      <el-col :span="16">
        <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
          <div v-show="showSearch" class="mb-[10px]">
            <el-card shadow="hover">
              <template #header>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2">
                    <el-icon><Search /></el-icon>
                    <span>搜索条件</span>
                  </div>
                  <el-button type="info" text icon="i-ep-setting" @click="handleSearchConfig">搜索项配置</el-button>
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
                医师资质目录列表
                <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
              </div>
              <div class="table-actions">
                <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorQualificationCatalog:add']">新增</el-button>
                <el-button
                  type="success"
                  plain
                  icon="Edit"
                  :disabled="single"
                  @click="handleUpdate()"
                  v-hasPermi="['doctor:doctorQualificationCatalog:edit']"
                  >修改</el-button
                >
                <el-button
                  type="danger"
                  plain
                  icon="Delete"
                  :disabled="multiple"
                  @click="handleDelete()"
                  v-hasPermi="['doctor:doctorQualificationCatalog:remove']"
                  >删除</el-button
                >
                <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorQualificationCatalog:export']"
                  >导出</el-button
                >
                <el-button text type="primary" @click="showFieldConfig = true" class="config-btn">
                  <i-ep-setting class="btn-icon"></i-ep-setting>
                  字段配置
                </el-button>
                <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
              </div>
            </div>
          </template>

          <el-table v-loading="loading" border :data="doctorQualificationCatalogList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column
              v-for="column in visibleColumns"
              :key="column.prop"
              :label="column.label"
              align="center"
              :prop="column.prop"
              :width="column.width"
            >
              <template #default="scope" v-if="column.prop === 'isEnabled' || column.prop === 'delFlag'">
                <el-tag :type="scope.row[column.prop] === '1' ? 'success' : 'danger'">
                  {{ scope.row[column.prop] === '1' ? '是' : '否' }}
                </el-tag>
              </template>
              <template #default="scope" v-else>
                {{ scope.row[column.prop] }}
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
                    v-hasPermi="['doctor:doctorQualificationCatalog:edit']"
                  ></el-button>
                </el-tooltip>
                <el-tooltip content="删除" placement="top">
                  <el-button
                    link
                    type="primary"
                    icon="Delete"
                    @click="handleDelete(scope.row)"
                    v-hasPermi="['doctor:doctorQualificationCatalog:remove']"
                  ></el-button>
                </el-tooltip>
              </template>
            </el-table-column>
          </el-table>

          <pagination
            v-show="total > 0"
            :total="total"
            v-model:page="queryParams.pageNum"
            v-model:limit="queryParams.pageSize"
            @pagination="getList"
          />
        </el-card>
      </el-col>
    </el-row>

    <!-- 添加或修改医师资质目录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="800px" append-to-body>
      <DynamicForm ref="formRef" :form-data="form" :field-config="formFieldConfig" :rules="rules" @submit="submitForm" />
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorQualificationCatalog" lang="ts">
import {
  listDoctorQualificationCatalog,
  getDoctorQualificationCatalog,
  delDoctorQualificationCatalog,
  addDoctorQualificationCatalog,
  updateDoctorQualificationCatalog
} from '@/api/doctor/doctorQualificationCatalog';
import {
  DoctorQualificationCatalogVO,
  DoctorQualificationCatalogQuery,
  DoctorQualificationCatalogForm
} from '@/api/doctor/doctorQualificationCatalog/types';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import RightToolbar from '@/components/RightToolbar/index.vue';
import Pagination from '@/components/Pagination/index.vue';
import { createDoctorQualificationCatalogFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { createDoctorQualificationCatalogSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';
import { parseTime } from '@/utils/ruoyi';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorQualificationCatalogList = ref<DoctorQualificationCatalogVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const doctorQualificationCatalogFormRef = ref<ElFormInstance>();
const treeRef = ref();

// 树形数据相关状态
const treeData = ref<any[]>([]);
const treeProps = {
  children: 'children',
  label: 'catalogName'
};

// 存储原始完整数据，用于更新操作
const allCatalogData = ref<any[]>([]);

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorQualificationCatalogForm = {
  id: undefined,
  catalogCode: undefined,
  catalogName: undefined,
  parentId: undefined,
  catalogLevel: undefined,
  catalogType: undefined,
  subType: undefined,
  description: undefined,
  sortOrder: undefined,
  isEnabled: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorQualificationCatalogForm, DoctorQualificationCatalogQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    catalogCode: undefined,
    catalogName: undefined,
    parentId: undefined,
    catalogLevel: undefined,
    catalogType: undefined,
    subType: undefined,
    description: undefined,
    sortOrder: undefined,
    isEnabled: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    catalogCode: [{ required: true, message: '资质编码不能为空', trigger: 'blur' }],
    catalogName: [{ required: true, message: '资质名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 字段配置管理器
const fieldConfigManager = createDoctorQualificationCatalogFieldConfig();

// 初始化时清除之前的字段配置和localStorage缓存，确保新配置生效
fieldConfigManager.clearConfig();
localStorage.removeItem('doctorQualificationCatalog_field_config');

// 计算可见列
const visibleColumns = computed(() => {
  return fieldConfigManager.getVisibleFields();
});
const searchConfigManager = createDoctorQualificationCatalogSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 表单字段配置
const formFieldConfig = computed(() => fieldConfigManager.getFieldGroups().flatMap((group) => group.fields));

/** 获取树形数据 */
const getTreeData = async () => {
  try {
    // 获取所有数据用于构建树形结构
    const res = await listDoctorQualificationCatalog({ pageSize: 1000, pageNum: 1 });
    console.log('API返回数据:', res);
    const allData = res.rows || [];
    console.log('所有数据:', allData);

    // 保存原始完整数据
    allCatalogData.value = allData;

    // 构建树形结构 - 使用更安全的方法
    const buildTree = (data: any[]): any[] => {
      if (!data || data.length === 0) {
        return [];
      }

      // 创建一个映射表，方便查找
      const dataMap = new Map();
      const rootNodes: any[] = [];

      // 首先，将所有数据放入映射表
      data.forEach((item) => {
        dataMap.set(item.id, { ...item, children: [] });
      });

      // 然后，构建树结构
      data.forEach((item) => {
        const node = dataMap.get(item.id);
        const parentId = item.parentId;

        // 处理 parentId 的类型转换，确保比较正确
        const normalizedParentId = parentId === null || parentId === undefined || parentId === '' ? null : parentId;

        if (normalizedParentId === null || !dataMap.has(normalizedParentId)) {
          // 根节点
          rootNodes.push(node);
        } else {
          // 子节点
          const parent = dataMap.get(normalizedParentId);
          if (parent) {
            parent.children.push(node);
          } else {
            // 父节点不存在，当作根节点处理
            rootNodes.push(node);
          }
        }
      });

      // 对每个层级的子节点进行排序
      const sortChildren = (nodes: any[]) => {
        nodes.forEach((node) => {
          if (node.children && node.children.length > 0) {
            node.children.sort((a, b) => (a.sortOrder || 0) - (b.sortOrder || 0));
            sortChildren(node.children);
          }
        });
      };

      rootNodes.sort((a, b) => (a.sortOrder || 0) - (b.sortOrder || 0));
      sortChildren(rootNodes);

      console.log('构建的树形数据:', rootNodes);
      return rootNodes;
    };

    const treeResult = buildTree(allData);
    console.log('构建的树形数据:', treeResult);
    treeData.value = treeResult;
  } catch (error) {
    console.error('获取树形数据失败:', error);
    proxy?.$modal.msgError('获取树形数据失败');
  }
};

/** 树节点点击处理 */
const handleNodeClick = (data: any) => {
  // 根据点击的节点过滤右侧表格数据
  if (data.catalogLevel === '1') {
    // 点击一级目录，显示该目录下的所有子项
    queryParams.value.parentId = data.id;
  } else {
    // 点击其他层级，显示该项的详细信息
    queryParams.value.parentId = data.parentId;
  }
  getList();
};

/** 获取层级文本 */
const getLevelText = (level: string | number): string => {
  const levelMap: Record<string, string> = {
    '1': '一级',
    '2': '二级',
    '3': '三级',
    '4': '四级'
  };
  return levelMap[String(level)] || '';
};

/** 拖拽时判断是否允许放置 */
const allowDrop = (draggingNode: any, dropNode: any, type: string) => {
  // 获取拖拽节点和目标节点的数据
  const draggingData = draggingNode.data;
  const dropData = dropNode.data;

  // 不允许拖拽到自己内部
  if (draggingData.id === dropData.id) {
    return false;
  }

  // 如果拖拽到节点内部，检查层级关系
  if (type === 'inner') {
    // 只能拖拽到比当前节点层级更高的节点内部
    // 例如：二级节点可以拖拽到一级节点内部，但不能拖拽到三级节点内部
    return dropData.catalogLevel < draggingData.catalogLevel;
  }

  // 如果是拖拽到节点前后，允许在同一父节点下排序
  if (type === 'prev' || type === 'next') {
    return draggingNode.parent === dropNode.parent;
  }

  return false;
};

/** 节点拖拽完成处理 */
const handleNodeDrop = (draggingNode: any, dropNode: any, dropType: string, ev: Event) => {
  console.log('拖拽完成:', draggingNode, dropNode, dropType);

  const draggingData = draggingNode.data;
  const dropData = dropNode.data;

  let newParentId = null;
  let newSortOrder = 1;

  if (dropType === 'inner') {
    // 拖拽到节点内部，成为子节点
    newParentId = dropData.id;
    // 设置为该父节点下的第一个子节点
    newSortOrder = 1;
  } else if (dropType === 'prev' || dropType === 'next') {
    // 在同一父节点下重新排序
    newParentId = dropNode.parent ? dropNode.parent.data.id : null;

    // 获取兄弟节点列表
    const siblings = dropNode.parent ? dropNode.parent.children : treeData.value;

    // 计算新的排序位置
    const dropIndex = siblings.indexOf(dropNode);
    const draggingIndex = siblings.indexOf(draggingNode);

    if (dropType === 'prev') {
      newSortOrder = dropIndex + 1;
    } else {
      newSortOrder = dropIndex + 2;
    }

    // 重新排序兄弟节点
    siblings.forEach((node: any, index: number) => {
      if (node !== draggingNode) {
        if (dropType === 'prev' && index >= dropIndex && node !== dropNode) {
          node.data.sortOrder = index + 2;
        } else if (dropType === 'next' && index > dropIndex) {
          node.data.sortOrder = index + 1;
        } else {
          node.data.sortOrder = index + 1;
        }
      }
    });
  }

  // 更新拖拽节点的父节点和排序
  draggingData.parentId = newParentId;
  draggingData.sortOrder = newSortOrder;

  // 如果改变了父节点，需要重新计算层级
  if (newParentId !== (draggingNode.parent ? draggingNode.parent.data.id : null)) {
    if (newParentId) {
      draggingData.catalogLevel = dropData.catalogLevel + 1;
    } else {
      draggingData.catalogLevel = 1;
    }
  }

  // 调用API更新数据
  updateNodeData(draggingData);
};

/** 更新节点数据 */
const updateNodeData = async (nodeData: any) => {
  try {
    console.log('准备更新节点数据:', nodeData);

    // 从存储的原始数据中获取完整信息，确保所有字段都存在
    const fullNodeData = allCatalogData.value.find((item) => item.id === nodeData.id);
    if (!fullNodeData) {
      console.error('未找到完整的节点数据:', nodeData.id);
      ElMessage.error('节点数据不存在，无法更新');
      return;
    }

    // 使用完整数据，但更新我们修改的字段
    const updateData = {
      id: fullNodeData.id,
      catalogCode: fullNodeData.catalogCode,
      catalogName: fullNodeData.catalogName,
      parentId: nodeData.parentId, // 使用更新后的值
      catalogLevel: nodeData.catalogLevel, // 使用更新后的值
      catalogType: fullNodeData.catalogType || '',
      subType: fullNodeData.subType || '',
      description: fullNodeData.description || '',
      sortOrder: nodeData.sortOrder, // 使用更新后的值
      isEnabled: fullNodeData.isEnabled !== undefined ? fullNodeData.isEnabled : '1',
      delFlag: fullNodeData.delFlag !== undefined ? fullNodeData.delFlag : '0'
    };

    console.log('发送更新数据:', updateData);
    await updateDoctorQualificationCatalog(updateData);
    ElMessage.success('节点更新成功');
    // 刷新树数据
    getTreeData();
  } catch (error) {
    console.error('更新节点失败:', error);
    ElMessage.error('更新节点失败');
    // 失败时刷新数据恢复原始状态
    getTreeData();
  }
};

/** 更新排序 */
const updateSortOrder = async (sortData: any[]) => {
  try {
    console.log('更新排序数据:', sortData);
    // 使用存储的原始数据来获取完整信息
    for (const item of sortData) {
      const fullNodeData = allCatalogData.value.find((node) => node.id === item.id);
      if (fullNodeData) {
        const updateData = {
          id: fullNodeData.id,
          catalogCode: fullNodeData.catalogCode,
          catalogName: fullNodeData.catalogName,
          parentId: fullNodeData.parentId,
          catalogLevel: fullNodeData.catalogLevel,
          catalogType: fullNodeData.catalogType || '',
          subType: fullNodeData.subType || '',
          description: fullNodeData.description || '',
          sortOrder: item.sortOrder,
          isEnabled: fullNodeData.isEnabled !== undefined ? fullNodeData.isEnabled : '1',
          delFlag: fullNodeData.delFlag !== undefined ? fullNodeData.delFlag : '0'
        };
        await updateDoctorQualificationCatalog(updateData);
      }
    }
    ElMessage.success('排序更新成功');
    // 刷新树数据
    getTreeData();
  } catch (error) {
    console.error('更新排序失败:', error);
    ElMessage.error('排序更新失败');
    // 失败时刷新数据恢复原始状态
    getTreeData();
  }
};

/** 查询医师资质目录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listDoctorQualificationCatalog(queryParams.value);
  doctorQualificationCatalogList.value = res.rows;
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
  doctorQualificationCatalogFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorQualificationCatalogVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师资质目录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorQualificationCatalogVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorQualificationCatalog(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医师资质目录';
};

/** 提交按钮 */
const submitForm = async () => {
  buttonLoading.value = true;
  try {
    if (form.value.id) {
      await updateDoctorQualificationCatalog(form.value);
    } else {
      await addDoctorQualificationCatalog(form.value);
    }
    proxy?.$modal.msgSuccess('操作成功');
    dialog.visible = false;
    await getList();
    await getTreeData();
  } catch (error) {
    console.error('提交失败:', error);
  } finally {
    buttonLoading.value = false;
  }
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorQualificationCatalogVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师资质目录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorQualificationCatalog(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorQualificationCatalog/export',
    {
      ...queryParams.value
    },
    `doctorQualificationCatalog_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  fieldConfigManager.saveConfig();
  showFieldConfig.value = false;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 导入按钮操作 */
const handleImport = () => {
  proxy?.$modal.msgSuccess('导入功能开发中...');
};

onMounted(() => {
  getList();
  getTreeData();
});
</script>

<style lang="scss" scoped>
.app-container {
  padding: 20px;
  background-color: #f5f5f5;
  min-height: calc(100vh - 84px);
}

// 页面标题样式
.page-header {
  margin-bottom: 24px;

  .page-title {
    font-size: 24px;
    font-weight: 600;
    color: #1d2129;
    margin-bottom: 8px;
    display: flex;
    align-items: center;
    gap: 8px;

    .title-icon {
      color: #409eff;
    }
  }

  .page-description {
    color: #86909c;
    font-size: 14px;
  }
}

// 搜索卡片样式
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
      color: #303133;
      display: flex;
      align-items: center;
      gap: 6px;

      .search-icon {
        color: #409eff;
        font-size: 18px;
      }
    }

    .search-actions {
      .el-button {
        font-size: 12px;
        padding: 4px 8px;
        height: auto;
        border: none;
        color: #86909c;

        &:hover {
          color: #409eff;
          background-color: #ecf5ff;
        }
      }
    }
  }

  :deep(.el-card__header) {
    background-color: #fafafa;
    border-bottom: 1px solid #ebeef5;
    padding: 16px 20px;
  }

  :deep(.el-card__body) {
    padding: 20px;
  }
}

// 表格卡片样式
.table-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);

  .table-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 16px 20px;
    background-color: #fafafa;
    border-bottom: 1px solid #ebeef5;

    .table-title {
      display: flex;
      align-items: center;
      gap: 8px;
      font-size: 16px;
      font-weight: 500;
      color: #303133;

      .table-icon {
        color: #67c23a;
        font-size: 18px;
      }

      .ml-2 {
        margin-left: 8px;
      }
    }

    .table-actions {
      display: flex;
      gap: 8px;
      align-items: center;
    }
  }

  :deep(.el-card__body) {
    padding: 0;
  }
}

// 树形卡片样式
.tree-card {
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  height: calc(100vh - 140px);
  overflow: hidden;

  :deep(.el-card__body) {
    height: calc(100% - 60px);
    overflow-y: auto;
  }

  :deep(.el-card__header) {
    background-color: #fafafa;
    border-bottom: 1px solid #ebeef5;
  }
}

// 表格样式
:deep(.el-table) {
  .el-table__header th {
    background-color: #fafafa;
    font-weight: 600;
    color: #1d2129;
  }

  .el-table__row {
    &:hover {
      background-color: #f5f7fa;
    }
  }
}

// 按钮样式
:deep(.el-button) {
  border-radius: 4px;
}

// 表单样式
:deep(.el-form-item) {
  margin-bottom: 20px;

  .el-form-item__label {
    font-weight: 500;
    color: #606266;
  }
}

// 响应式设计
@media (max-width: 768px) {
  .app-container {
    padding: 10px;
  }

  .page-header {
    .page-title {
      font-size: 20px;
    }
  }

  .table-header {
    flex-direction: column;
    gap: 12px;
    align-items: flex-start !important;

    .table-actions {
      flex-wrap: wrap;
      width: 100%;

      .el-button {
        flex: 1;
        min-width: 80px;
      }
    }
  }
}
</style>
