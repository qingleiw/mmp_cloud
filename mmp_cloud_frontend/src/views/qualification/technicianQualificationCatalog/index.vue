<template>
  <div class="p-2">
    <el-row :gutter="20">
      <!-- 左侧树形目录 -->
      <el-col :span="6">
        <el-card shadow="never" class="tree-card">
          <template #header>
            <div class="flex items-center justify-between">
              <span>医技资质目录树</span>
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
      <el-col :span="18">
        <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
          <div v-show="showSearch" class="mb-[10px]">
            <el-card shadow="hover">
              <template #header>
                <div class="flex items-center justify-between">
                  <div class="flex items-center gap-2">
                    <i-ep-search class="search-icon"></i-ep-search>
                    <span>搜索条件</span>
                  </div>
                  <el-button type="info" text icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
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
            <div class="mb8 flex items-center gap-2 flex-nowrap">
              <i-ep-list class="table-icon"></i-ep-list>
              <span class="table-title-text" title="医技资质目录列表">医技资质目录列表</span>
              <el-tag type="info" size="small" class="ml-2">{{ total }} 条记录</el-tag>
              <div class="ml-auto flex items-center gap-2">
                <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['qualification:technicianQualificationCatalog:add']"
                  >新增</el-button
                >
                <el-button
                  type="success"
                  plain
                  icon="Edit"
                  :disabled="single"
                  @click="handleUpdate()"
                  v-hasPermi="['qualification:technicianQualificationCatalog:edit']"
                  >修改</el-button
                >
                <el-button
                  type="danger"
                  plain
                  icon="Delete"
                  :disabled="multiple"
                  @click="handleDelete()"
                  v-hasPermi="['qualification:technicianQualificationCatalog:remove']"
                  >删除</el-button
                >
                <el-button
                  type="warning"
                  plain
                  icon="Download"
                  @click="handleExport"
                  v-hasPermi="['qualification:technicianQualificationCatalog:export']"
                  >导出</el-button
                >
                <el-button type="warning" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
                <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
              </div>
            </div>
          </template>

          <el-table v-loading="loading" border :data="technicianQualificationCatalogList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column
              v-for="field in fieldConfigManager.visibleFields"
              :key="field.prop"
              :label="field.label"
              :prop="field.prop"
              :width="field.width"
              align="center"
            >
              <template #default="scope">
                <span>{{ scope.row[field.prop] }}</span>
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
                    v-hasPermi="['qualification:technicianQualificationCatalog:edit']"
                  ></el-button>
                </el-tooltip>
                <el-tooltip content="删除" placement="top">
                  <el-button
                    link
                    type="primary"
                    icon="Delete"
                    @click="handleDelete(scope.row)"
                    v-hasPermi="['qualification:technicianQualificationCatalog:remove']"
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
    <!-- 添加或修改医技资质目录对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="technicianQualificationCatalogFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资质编码" prop="catalogCode">
          <el-input v-model="form.catalogCode" placeholder="请输入资质编码" />
        </el-form-item>
        <el-form-item label="资质名称" prop="catalogName">
          <el-input v-model="form.catalogName" placeholder="请输入资质名称" />
        </el-form-item>
        <el-form-item label="父级ID" prop="parentId">
          <el-input v-model="form.parentId" placeholder="请输入父级ID" />
        </el-form-item>
        <el-form-item label="目录层级" prop="catalogLevel">
          <el-input v-model="form.catalogLevel" placeholder="请输入目录层级" />
        </el-form-item>
        <el-form-item label="资质描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="排序" prop="sortOrder">
          <el-input v-model="form.sortOrder" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="是否启用" prop="isEnabled">
          <el-input v-model="form.isEnabled" placeholder="请输入是否启用" />
        </el-form-item>
        <el-form-item label="是否删除" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入是否删除" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<style scoped>
.table-card {
  background: #fff;
  border-radius: 8px;
  padding: 12px;
}
.table-card .mb8 {
  min-height: 44px;
  padding: 6px 8px;
  display: flex;
  align-items: center;
}
.table-title-text {
  display: inline-block;
  max-width: 10em;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.table-card .mb8 .ml-auto {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  flex-wrap: nowrap;
}
.table-card .mb8 :deep(.right-toolbar) {
  display: inline-flex;
  align-items: center;
}
.tree-card {
  height: calc(100vh - 140px);
  overflow: hidden;
}

.tree-card :deep(.el-card__body) {
  height: calc(100% - 60px);
  overflow-y: auto;
}

.tree-node {
  display: flex;
  align-items: center;
  width: 100%;
}

.tree-node .el-tag {
  flex-shrink: 0;
}
</style>

<script setup name="TechnicianQualificationCatalog" lang="ts">
import {
  listTechnicianQualificationCatalog,
  getTechnicianQualificationCatalog,
  delTechnicianQualificationCatalog,
  addTechnicianQualificationCatalog,
  updateTechnicianQualificationCatalog
} from '@/api/qualification/technicianQualificationCatalog';
import {
  TechnicianQualificationCatalogVO,
  TechnicianQualificationCatalogQuery,
  TechnicianQualificationCatalogForm
} from '@/api/qualification/technicianQualificationCatalog/types';
import { createTechnicianQualificationCatalogFieldConfig } from '@/utils/fieldConfig';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createTechnicianQualificationCatalogSearchConfig } from '@/utils/configs/qualification/SearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const technicianQualificationCatalogList = ref<TechnicianQualificationCatalogVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const fieldConfigManager = createTechnicianQualificationCatalogFieldConfig();
const searchConfigManager = createTechnicianQualificationCatalogSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const queryFormRef = ref<ElFormInstance>();
const technicianQualificationCatalogFormRef = ref<ElFormInstance>();
const treeRef = ref();

// 树形数据相关状态
const treeData = ref<any[]>([]);
const treeProps = {
  children: 'children',
  label: 'catalogName'
};

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: TechnicianQualificationCatalogForm = {
  id: undefined,
  catalogCode: undefined,
  catalogName: undefined,
  parentId: undefined,
  catalogLevel: undefined,
  catalogType: undefined,
  description: undefined,
  sortOrder: undefined,
  isEnabled: undefined,
  delFlag: undefined
};
const data = reactive<PageData<TechnicianQualificationCatalogForm, TechnicianQualificationCatalogQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    catalogCode: undefined,
    catalogName: undefined,
    parentId: undefined,
    catalogLevel: undefined,
    catalogType: undefined,
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

/** 查询医技资质目录列表 */
const getList = async () => {
  loading.value = true;
  const res = await listTechnicianQualificationCatalog(queryParams.value);
  technicianQualificationCatalogList.value = res.rows;
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
  technicianQualificationCatalogFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: TechnicianQualificationCatalogVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医技资质目录';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: TechnicianQualificationCatalogVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getTechnicianQualificationCatalog(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医技资质目录';
};

/** 提交按钮 */
const submitForm = () => {
  technicianQualificationCatalogFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateTechnicianQualificationCatalog(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addTechnicianQualificationCatalog(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: TechnicianQualificationCatalogVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医技资质目录编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delTechnicianQualificationCatalog(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/technicianQualificationCatalog/export',
    {
      ...queryParams.value
    },
    `technicianQualificationCatalog_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 获取树形数据 */
const getTreeData = async () => {
  try {
    // 获取所有数据用于构建树形结构
    const res = await listTechnicianQualificationCatalog({ pageSize: 1000, pageNum: 1 });
    console.log('医技资质API返回数据:', res);
    const allData = res.rows || [];
    console.log('医技资质所有数据:', allData);

    // 构建树形结构
    const buildTree = (data: any[], parentId: any = 0): any[] => {
      // 改为默认值 0
      return data
        .filter((item) => item.parentId == parentId || item.parentId === null || item.parentId === undefined || item.parentId === '') // 处理各种可能的情况
        .map((item) => ({
          ...item,
          children: buildTree(data, item.id)
        }))
        .sort((a, b) => (a.sortOrder || 0) - (b.sortOrder || 0));
    };

    const treeResult = buildTree(allData);
    console.log('医技资质构建的树形数据:', treeResult);
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
  // 不允许拖拽到其他节点内部，只允许排序
  if (type !== 'next' && type !== 'prev') {
    return false;
  }
  // 只允许在同一父节点下的兄弟节点之间拖拽
  return draggingNode.parent === dropNode.parent;
};

/** 节点拖拽完成处理 */
const handleNodeDrop = (draggingNode: any, dropNode: any, dropType: string, ev: Event) => {
  console.log('拖拽完成:', draggingNode, dropNode, dropType);

  // 获取拖拽节点的兄弟节点列表
  const siblings = draggingNode.parent ? draggingNode.parent.children : treeData.value;

  // 重新计算排序
  siblings.forEach((node: any, index: number) => {
    node.data.sortOrder = index + 1;
  });

  // 调用API更新排序
  updateSortOrder(
    siblings.map((node: any) => ({
      id: node.data.id,
      sortOrder: node.data.sortOrder
    }))
  );
};

/** 更新排序 */
const updateSortOrder = async (sortData: any[]) => {
  try {
    // 这里可以调用后端API来保存新的排序
    console.log('更新排序数据:', sortData);
    // 暂时使用批量更新API，如果没有专门的排序API
    for (const item of sortData) {
      await updateTechnicianQualificationCatalog(item);
    }
    ElMessage.success('排序更新成功');
    // 刷新树数据
    getTreeData();
  } catch (error) {
    console.error('更新排序失败:', error);
    ElMessage.error('排序更新失败');
  }
};

onMounted(() => {
  getList();
  getTreeData();
});
</script>
