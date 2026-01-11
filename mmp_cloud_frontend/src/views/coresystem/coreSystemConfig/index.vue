<template>
  <div class="p-2">
    <el-row :gutter="20">
      <!-- 左侧：核心制度目录树 -->
      <el-col :span="8">
        <el-card shadow="never" class="tree-card">
          <template #header>
            <div class="flex justify-between items-center">
              <span>核心制度目录</span>
              <el-button type="primary" size="small" @click="getTreeData">刷新</el-button>
            </div>
          </template>

          <div class="tree-container">
            <el-tree
              ref="treeRef"
              :data="treeData"
              :props="treeProps"
              :expand-on-click-node="false"
              :highlight-current="true"
              node-key="id"
              @node-click="handleNodeClick"
            >
              <template #default="{ node, data }">
                <div class="tree-node">
                  <span>{{ node.label }}</span>
                  <el-tag size="small" :type="getNodeTypeColor(data.type)" class="ml-2">
                    {{ data.type }}
                  </el-tag>
                  <el-tag v-if="data.type !== '分类'" size="small" :type="isEnabled(data.isEnabled) ? 'success' : 'danger'" class="ml-1">
                    {{ isEnabled(data.isEnabled) ? '启用' : '禁用' }}
                  </el-tag>
                </div>
              </template>
            </el-tree>
          </div>
        </el-card>
      </el-col>

      <!-- 右侧：选中节点详细信息 -->
      <el-col :span="16">
        <el-card v-if="selectedNode" shadow="never" class="detail-card">
          <template #header>
            <div class="flex justify-between items-center">
              <span>{{ selectedNode.type }}详情</span>
              <!-- 暂时隐藏编辑功能按钮
              <el-space>
                <el-button type="primary" size="small" @click="handleEdit(selectedNode)">编辑</el-button>
                <el-button type="success" size="small" @click="handleAddChild(selectedNode)">添加子项</el-button>
                <el-button type="danger" size="small" @click="handleDelete(selectedNode)">删除</el-button>
              </el-space>
              -->
            </div>
          </template>

          <el-descriptions :column="2" border>
            <template v-if="selectedNode.type === '制度'">
              <el-descriptions-item label="制度编码" :span="2">
                {{ selectedNode.systemCode }}
              </el-descriptions-item>
              <el-descriptions-item label="制度名称" :span="2">
                {{ selectedNode.systemName }}
              </el-descriptions-item>
              <el-descriptions-item label="制度类型">
                {{ selectedNode.systemType }}
              </el-descriptions-item>
              <el-descriptions-item label="制度总分">
                {{ selectedNode.totalScore }}
              </el-descriptions-item>
              <el-descriptions-item label="权重">
                {{ selectedNode.weight }}
              </el-descriptions-item>
              <el-descriptions-item label="是否自定义">
                <el-tag :type="selectedNode.isCustom === '1' ? 'warning' : 'info'">
                  {{ selectedNode.isCustom === '1' ? '是' : '否' }}
                </el-tag>
              </el-descriptions-item>
              <el-descriptions-item label="是否启用">
                <el-tag :type="isEnabled(selectedNode.isEnabled) ? 'success' : 'danger'">
                  {{ isEnabled(selectedNode.isEnabled) ? '启用' : '禁用' }}
                </el-tag>
              </el-descriptions-item>
              <el-descriptions-item label="制度描述" :span="2">
                {{ selectedNode.systemDescription }}
              </el-descriptions-item>
            </template>

            <template v-else-if="selectedNode.type === '指标'">
              <el-descriptions-item label="指标编码" :span="2">
                {{ selectedNode.indicatorCode }}
              </el-descriptions-item>
              <el-descriptions-item label="指标名称" :span="2">
                {{ selectedNode.indicatorName }}
              </el-descriptions-item>
              <el-descriptions-item label="指标类型">
                {{ selectedNode.indicatorType }}
              </el-descriptions-item>
              <el-descriptions-item label="计算周期">
                {{ selectedNode.calculationCycle }}
              </el-descriptions-item>
              <el-descriptions-item label="目标值">
                {{ selectedNode.targetValue }}
              </el-descriptions-item>
              <el-descriptions-item label="指标分数"> {{ selectedNode.indicatorScore }}% </el-descriptions-item>
              <el-descriptions-item label="是否反向指标">
                {{ selectedNode.isReverse ? '是' : '否' }}
              </el-descriptions-item>
              <el-descriptions-item label="预警阈值">
                {{ selectedNode.alertThreshold }}
              </el-descriptions-item>
              <el-descriptions-item label="数据来源" :span="2">
                {{ selectedNode.dataSource }}
              </el-descriptions-item>
              <el-descriptions-item label="计算公式" :span="2">
                {{ selectedNode.calculationFormula }}
              </el-descriptions-item>
              <el-descriptions-item label="状态">
                <el-tag :type="isEnabled(selectedNode.isEnabled) ? 'success' : 'danger'">
                  {{ isEnabled(selectedNode.isEnabled) ? '启用' : '禁用' }}
                </el-tag>
              </el-descriptions-item>
              <el-descriptions-item label="创建时间">
                {{ selectedNode.createTime }}
              </el-descriptions-item>
            </template>
          </el-descriptions>

          <!-- 子项列表 -->
          <el-divider v-if="selectedNode.children && selectedNode.children.length > 0">子项列表</el-divider>
          <el-table
            v-if="selectedNode.children && selectedNode.children.length > 0"
            :data="selectedNode.children"
            style="width: 100%"
            size="small"
            border
          >
            <el-table-column prop="name" label="名称" width="200"></el-table-column>
            <el-table-column prop="type" label="类型" width="80"></el-table-column>
            <el-table-column prop="isEnabled" label="状态" width="80">
              <template #default="scope">
                <el-tag :type="isEnabled(scope.row.isEnabled) ? 'success' : 'danger'" size="small">
                  {{ isEnabled(scope.row.isEnabled) ? '启用' : '禁用' }}
                </el-tag>
              </template>
            </el-table-column>
            <el-table-column label="操作" width="120">
              <template #default="scope">
                <el-button link size="small" @click="handleViewChildDetail(scope.row)">查看</el-button>
                <!-- 暂时隐藏编辑功能
                <el-button link size="small" @click="handleEditChild(scope.row)">编辑</el-button>
                -->
              </template>
            </el-table-column>
          </el-table>
        </el-card>

        <!-- 默认提示 -->
        <el-card v-else shadow="never" class="detail-card">
          <el-empty description="请在左侧选择要查看的制度或指标">
            <!-- 暂时隐藏添加功能
            <el-button type="primary" @click="handleAddRoot">添加根目录</el-button>
            -->
          </el-empty>
        </el-card>
      </el-col>
    </el-row>

    <!-- 添加或修改核心制度配置对话框 - 暂时隐藏 -->
    <!--
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="coreSystemConfigFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="制度编码" prop="systemCode">
          <el-input v-model="form.systemCode" placeholder="请输入制度编码" />
        </el-form-item>
        <el-form-item label="制度名称" prop="systemName">
          <el-input v-model="form.systemName" placeholder="请输入制度名称" />
        </el-form-item>
        <el-form-item label="制度描述" prop="systemDescription">
          <el-input v-model="form.systemDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="制度总分" prop="totalScore">
          <el-input v-model="form.totalScore" placeholder="请输入制度总分" />
        </el-form-item>
        <el-form-item label="权重" prop="weight">
          <el-input v-model="form.weight" placeholder="请输入权重" />
        </el-form-item>
        <el-form-item label="是否启用" prop="isEnabled">
          <el-input v-model="form.isEnabled" placeholder="请输入是否启用" />
        </el-form-item>
        <el-form-item label="是否自定义 1-是 0-否" prop="isCustom">
          <el-input v-model="form.isCustom" placeholder="请输入是否自定义 1-是 0-否" />
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
    -->
  </div>
</template>

<script setup name="CoreSystemConfig" lang="ts">
import {
  listCoreSystemConfig,
  getCoreSystemConfig,
  delCoreSystemConfig,
  addCoreSystemConfig,
  updateCoreSystemConfig
} from '@/api/system/coreSystemConfig';
import { listCoreSystemIndicator, getCoreSystemIndicator } from '@/api/system/coreSystemIndicator';
import { CoreSystemConfigVO, CoreSystemConfigQuery, CoreSystemConfigForm } from '@/api/system/coreSystemConfig/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const coreSystemConfigList = ref<CoreSystemConfigVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

// 树形数据相关
const treeData = ref<any[]>([]);
const selectedNode = ref<any>(null);
const treeRef = ref();

const coreSystemConfigFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: CoreSystemConfigForm = {
  id: undefined,
  systemCode: undefined,
  systemName: undefined,
  systemType: undefined,
  systemDescription: undefined,
  totalScore: undefined,
  weight: undefined,
  isEnabled: 1,
  isCustom: 0,
  delFlag: '0'
};
const data = reactive<PageData<CoreSystemConfigForm, CoreSystemConfigQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    systemCode: undefined,
    systemName: undefined,
    systemType: undefined,
    systemDescription: undefined,
    totalScore: undefined,
    weight: undefined,
    isEnabled: undefined,
    isCustom: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    systemCode: [{ required: true, message: '制度编码不能为空', trigger: 'blur' }],
    systemName: [{ required: true, message: '制度名称不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 树形配置
const treeProps = {
  children: 'children',
  label: 'name'
};

/** 查询核心制度配置列表 */
const getList = async () => {
  loading.value = true;
  const res = await listCoreSystemConfig(queryParams.value);
  coreSystemConfigList.value = res.rows;
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
  coreSystemConfigFormRef.value?.resetFields();
};

/** 编辑节点 */
const handleEdit = (node: any) => {
  reset();
  if (node.type === '制度') {
    dialog.title = '编辑核心制度配置';
    // 获取完整数据
    getCoreSystemConfig(node.id.split('_')[1]).then((res) => {
      Object.assign(form.value, res.data);
      dialog.visible = true;
    });
  } else {
    proxy?.$modal.msgWarning('指标编辑功能开发中...');
  }
};

/** 添加子项 */
const handleAddChild = (node: any) => {
  reset();
  dialog.title = '添加核心制度配置';
  dialog.visible = true;
};

/** 添加根目录 */
const handleAddRoot = () => {
  reset();
  dialog.title = '添加核心制度配置';
  dialog.visible = true;
};

/** 查看子项详情 */
const handleViewChildDetail = (childNode: any) => {
  selectedNode.value = childNode;
};

/** 编辑子项 */
const handleEditChild = (childNode: any) => {
  handleEdit(childNode);
};

/** 提交按钮 */
const submitForm = () => {
  coreSystemConfigFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateCoreSystemConfig(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addCoreSystemConfig(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除节点 */
const handleDelete = async (node: any) => {
  if (node.type === '制度') {
    const _id = node.id.split('_')[1];
    await proxy?.$modal.confirm('是否确认删除核心制度配置编号为"' + _id + '"的数据项？');
    await delCoreSystemConfig(_id);
    proxy?.$modal.msgSuccess('删除成功');
    await getTreeData();
  } else {
    proxy?.$modal.msgWarning('指标删除功能开发中...');
  }
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/coreSystemConfig/export',
    {
      ...queryParams.value
    },
    `coreSystemConfig_${new Date().getTime()}.xlsx`
  );
};

/** 检查是否启用状态 */
const isEnabled = (value: any): boolean => {
  if (value === null || value === undefined) return false;
  if (typeof value === 'boolean') return value;
  if (typeof value === 'string') return value === '1' || value.toLowerCase() === 'true';
  if (typeof value === 'number') return value === 1;
  return false;
};

/** 获取节点类型对应的颜色 */
const getNodeTypeColor = (type: string): "warning" | "primary" | "success" | "info" => {
  switch (type) {
    case '分类':
      return 'warning';
    case '制度':
      return 'primary';
    case '指标':
      return 'success';
    default:
      return 'info';
  }
};

/** 获取树形数据 */
const getTreeData = async () => {
  try {
    // 获取所有核心制度配置
    const configRes = await listCoreSystemConfig({ pageNum: 1, pageSize: 1000 });
    const configs = configRes.rows || [];

    // 获取所有核心制度指标
    const indicatorRes = await listCoreSystemIndicator({ pageNum: 1, pageSize: 1000 });
    const indicators = indicatorRes.rows || [];

    // 构建树形结构：制度作为根节点，指标作为子节点
    const tree: any[] = configs.map((config) => {
      // 获取该制度下的指标
      const configIndicators = indicators.filter((indicator) => indicator.systemId === config.id);

      // 使用parentId构建指标树形结构
      const buildIndicatorTree = (indicators: any[], parentId: string | number | null = 0): any[] => {
        return indicators
          .filter((indicator) => indicator.parentId == parentId) // 使用==来处理null和0
          .map((indicator) => ({
            id: `indicator_${indicator.id}`,
            name: `${indicator.indicatorName} (${indicator.indicatorScore}%)`,
            type: '指标',
            systemId: indicator.systemId,
            parentId: indicator.parentId,
            calculationCycle: indicator.calculationCycle,
            targetValue: indicator.targetValue,
            indicatorScore: indicator.indicatorScore,
            isEnabled: indicator.isEnabled,
            isReverse: indicator.isReverse,
            alertThreshold: indicator.alertThreshold,
            dataSource: indicator.dataSource,
            calculationFormula: indicator.calculationFormula,
            children: buildIndicatorTree(indicators, indicator.id) // 递归构建子指标
          }));
      };

      // 构建该制度的指标树
      const indicatorTree = buildIndicatorTree(configIndicators);

      return {
        id: `config_${config.id}`,
        name: config.systemName,
        type: '制度',
        isEnabled: config.isEnabled,
        systemCode: config.systemCode,
        systemType: config.systemType,
        systemDescription: config.systemDescription,
        totalScore: config.totalScore,
        weight: config.weight,
        isCustom: config.isCustom,
        children: indicatorTree
      };
    });

    treeData.value = tree;
  } catch (error) {
    console.error('获取树形数据失败:', error);
    proxy?.$modal.msgError('获取树形数据失败');
  }
};

/** 树节点点击处理 */
const handleNodeClick = (data: any) => {
  selectedNode.value = data;

  // 如果是制度节点，获取完整的制度信息
  if (data.type === '制度') {
    getSystemConfigDetail(data.id.split('_')[1]);
  }
  // 如果是指标节点，获取完整的指标信息
  else if (data.type === '指标') {
    getSystemIndicatorDetail(data.id.split('_')[1]);
  }
};

/** 获取制度配置详情 */
const getSystemConfigDetail = async (configId: number) => {
  try {
    const res = await getCoreSystemConfig(configId);
    // 合并详细信息到selectedNode
    Object.assign(selectedNode.value, res.data);
  } catch (error) {
    console.error('获取制度详情失败:', error);
  }
};

/** 获取指标详情 */
const getSystemIndicatorDetail = async (indicatorId: number) => {
  try {
    const res = await getCoreSystemIndicator(indicatorId);
    // 合并详细信息到selectedNode
    Object.assign(selectedNode.value, res.data);
  } catch (error) {
    console.error('获取指标详情失败:', error);
  }
};

onMounted(() => {
  getTreeData();
});
</script>

<style scoped>
.tree-card {
  height: calc(100vh - 140px);
}

.detail-card {
  height: calc(100vh - 140px);
  overflow-y: auto;
}

.tree-container {
  height: calc(100vh - 200px);
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
