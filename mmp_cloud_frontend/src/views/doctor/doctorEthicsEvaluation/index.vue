<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
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

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['doctor:doctorEthicsEvaluation:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['doctor:doctorEthicsEvaluation:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              plain
              icon="Delete"
              :disabled="multiple"
              @click="handleDelete()"
              v-hasPermi="['doctor:doctorEthicsEvaluation:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorEthicsEvaluation:export']"
              >导出</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="showFieldConfig = true">字段配置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="info" plain icon="Setting" @click="handleSearchConfig">搜索项配置</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="doctorEthicsEvaluationList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column
          v-for="field in visibleColumns"
          :key="field.prop"
          :label="field.label"
          align="center"
          :prop="field.prop"
          :width="field.width || undefined"
        >
          <template #default="scope">
            <span v-if="field.prop === 'doctorId'">
              {{ getDoctorName(scope.row[field.prop]) }}
            </span>
            <span v-else>
              {{ scope.row[field.prop] }}
            </span>
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
                v-hasPermi="['doctor:doctorEthicsEvaluation:edit']"
              ></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button
                link
                type="primary"
                icon="Delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['doctor:doctorEthicsEvaluation:remove']"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改医德医风考评对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="doctorEthicsEvaluationFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生ID" prop="doctorId">
          <el-input v-model="form.doctorId" placeholder="请输入医生ID" />
        </el-form-item>
        <el-form-item label="考评年度" prop="evaluationYear">
          <el-input v-model="form.evaluationYear" placeholder="请输入考评年度" />
        </el-form-item>
        <el-form-item label="考评周期" prop="evaluationCycle">
          <el-input v-model="form.evaluationCycle" placeholder="请输入考评周期" />
        </el-form-item>
        <el-form-item label="自评得分" prop="selfScore">
          <el-input v-model="form.selfScore" placeholder="请输入自评得分" />
        </el-form-item>
        <el-form-item label="同行评议得分" prop="peerScore">
          <el-input v-model="form.peerScore" placeholder="请输入同行评议得分" />
        </el-form-item>
        <el-form-item label="患者评价得分" prop="patientScore">
          <el-input v-model="form.patientScore" placeholder="请输入患者评价得分" />
        </el-form-item>
        <el-form-item label="科室评价得分" prop="departmentScore">
          <el-input v-model="form.departmentScore" placeholder="请输入科室评价得分" />
        </el-form-item>
        <el-form-item label="医院评价得分" prop="hospitalScore">
          <el-input v-model="form.hospitalScore" placeholder="请输入医院评价得分" />
        </el-form-item>
        <el-form-item label="总分" prop="totalScore">
          <el-input v-model="form.totalScore" placeholder="请输入总分" />
        </el-form-item>
        <el-form-item label="考评结果 优秀/良好/合格/不合格" prop="evaluationResult">
          <el-input v-model="form.evaluationResult" placeholder="请输入考评结果 优秀/良好/合格/不合格" />
        </el-form-item>
        <el-form-item label="奖惩情况" prop="rewardPunishment">
          <el-input v-model="form.rewardPunishment" placeholder="请输入奖惩情况" />
        </el-form-item>
        <el-form-item label="考评意见" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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

    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorEthicsEvaluation" lang="ts">
import {
  listDoctorEthicsEvaluation,
  getDoctorEthicsEvaluation,
  delDoctorEthicsEvaluation,
  addDoctorEthicsEvaluation,
  updateDoctorEthicsEvaluation
} from '@/api/doctor/doctorEthicsEvaluation';
import { DoctorEthicsEvaluationVO, DoctorEthicsEvaluationQuery, DoctorEthicsEvaluationForm } from '@/api/doctor/doctorEthicsEvaluation/types';
import { listDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO } from '@/api/doctor/doctorBasicInfo/types';
import { createDoctorEthicsEvaluationFieldConfig } from '@/utils/fieldConfig';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorEthicsEvaluationSearchConfig } from '@/utils/mmpSearchConfigs';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorEthicsEvaluationList = ref<DoctorEthicsEvaluationVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const showFieldConfig = ref(false);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const doctorOptions = ref<DoctorBasicInfoVO[]>([]);

const queryFormRef = ref<ElFormInstance>();
const doctorEthicsEvaluationFormRef = ref<ElFormInstance>();

// 字段配置相关变量
const fieldConfigManager = createDoctorEthicsEvaluationFieldConfig();
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());
const searchConfigManager = createDoctorEthicsEvaluationSearchConfig();
const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: DoctorEthicsEvaluationForm = {
  id: undefined,
  doctorId: undefined,
  evaluationYear: undefined,
  evaluationCycle: undefined,
  selfScore: undefined,
  peerScore: undefined,
  patientScore: undefined,
  departmentScore: undefined,
  hospitalScore: undefined,
  totalScore: undefined,
  evaluationResult: undefined,
  rewardPunishment: undefined,
  remark: undefined,
  delFlag: undefined
};
const data = reactive<PageData<DoctorEthicsEvaluationForm, DoctorEthicsEvaluationQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorId: undefined,
    evaluationYear: undefined,
    evaluationCycle: undefined,
    selfScore: undefined,
    peerScore: undefined,
    patientScore: undefined,
    departmentScore: undefined,
    hospitalScore: undefined,
    totalScore: undefined,
    evaluationResult: undefined,
    rewardPunishment: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorId: [{ required: true, message: '医生ID不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 加载医生选项 */
const loadDoctorOptions = async () => {
  try {
    const res = await listDoctorBasicInfo({});
    doctorOptions.value = res.rows;
  } catch (error) {
    console.error('加载医生选项失败:', error);
  }
};

/** 获取医生姓名 */
const getDoctorName = (doctorId: number | string | undefined): string => {
  if (!doctorId) return '';
  const doctor = doctorOptions.value.find((d) => d.id === doctorId);
  return doctor ? doctor.doctorName : `医生ID: ${doctorId}`;
};

/** 查询医德医风考评列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listDoctorEthicsEvaluation(queryParams.value);
    let evaluations = res.rows;

    // 获取所有医生信息来映射医生姓名
    if (evaluations.length > 0) {
      const doctorRes = await listDoctorBasicInfo({ pageSize: 1000 }); // 获取所有医生数据
      const doctorMap = new Map();
      doctorRes.rows.forEach((doctor: DoctorBasicInfoVO) => {
        doctorMap.set(doctor.id, doctor.doctorName);
      });

      // 为每个考评记录添加医生姓名
      evaluations = evaluations.map((evaluation: DoctorEthicsEvaluationVO) => ({
        ...evaluation,
        doctorName: doctorMap.get(evaluation.doctorId) || '未知医生'
      }));
    }

    doctorEthicsEvaluationList.value = evaluations;
    total.value = res.total;
  } catch (error) {
    console.error('获取医德医风考评列表失败:', error);
    doctorEthicsEvaluationList.value = [];
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
  doctorEthicsEvaluationFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: DoctorEthicsEvaluationVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医德医风考评';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorEthicsEvaluationVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorEthicsEvaluation(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医德医风考评';
};

/** 提交按钮 */
const submitForm = () => {
  doctorEthicsEvaluationFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorEthicsEvaluation(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorEthicsEvaluation(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorEthicsEvaluationVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医德医风考评编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorEthicsEvaluation(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorEthicsEvaluation/export',
    {
      ...queryParams.value
    },
    `doctorEthicsEvaluation_${new Date().getTime()}.xlsx`
  );
};

/** 字段配置确认 */
const handleFieldConfigConfirm = () => {
  // 字段配置更新后刷新列表
  getList();
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

onMounted(() => {
  loadDoctorOptions();
  getList();
});
</script>
