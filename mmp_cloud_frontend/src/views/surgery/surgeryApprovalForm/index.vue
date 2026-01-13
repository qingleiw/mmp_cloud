<template>
  <div class="app-container">
    <el-form ref="formRef" :model="formData" :rules="rules" label-width="120px" size="default">
      <h2 class="form-title">北京大学人民医院重大手术审批报告单</h2>

      <!-- 申报信息 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="申报科室" prop="deptId">
            <el-tree-select
              v-model="formData.deptId"
              :data="deptTree"
              placeholder="请选择申报科室"
              filterable
              check-strictly
              :render-after-expand="false"
              @change="handleDeptChange"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="申报日期" prop="reportDate">
            <el-date-picker
              v-model="formData.reportDate"
              type="date"
              placeholder="选择申报日期"
              format="YYYY 年 MM 月 DD 日"
              value-format="YYYY-MM-DD"
            />
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 患者信息 -->
      <el-row :gutter="20">
        <el-col :span="8">
          <el-form-item label="患者姓名" prop="patientName">
            <el-input v-model="formData.patientName" placeholder="请输入患者姓名" />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="性别" prop="gender">
            <el-select v-model="formData.gender" placeholder="请选择性别">
              <el-option label="男" value="男" />
              <el-option label="女" value="女" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="年龄" prop="age">
            <el-input-number v-model="formData.age" :min="0" :max="150" />
          </el-form-item>
        </el-col>
      </el-row>

      <el-form-item label="住院号" prop="hospitalNumber">
        <el-input v-model="formData.hospitalNumber" placeholder="请输入住院号" />
      </el-form-item>

      <!-- 手术信息 -->
      <el-form-item label="术前诊断" prop="preoperativeDiagnosis">
        <el-input v-model="formData.preoperativeDiagnosis" type="textarea" :rows="3" placeholder="请输入术前诊断" />
      </el-form-item>

      <el-form-item label="手术名称" prop="surgeryName">
        <el-input v-model="formData.surgeryName" placeholder="请输入手术名称" />
      </el-form-item>

      <el-form-item label="手术级别" prop="surgeryLevel">
        <el-radio-group v-model="formData.surgeryLevel">
          <el-radio label="一级">一级</el-radio>
          <el-radio label="二级">二级</el-radio>
          <el-radio label="三级">三级</el-radio>
          <el-radio label="四级">四级</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="麻醉方式" prop="anesthesiaMethod">
        <el-select v-model="formData.anesthesiaMethod" placeholder="请选择麻醉方式" style="width: 100%">
          <el-option label="全身麻醉" value="全身麻醉" />
          <el-option label="局部麻醉" value="局部麻醉" />
          <el-option label="椎管内麻醉" value="椎管内麻醉" />
          <el-option label="神经阻滞" value="神经阻滞" />
          <el-option label="其他" value="其他" />
        </el-select>
      </el-form-item>

      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="术者及职称" prop="surgeon">
            <el-input v-model="formData.surgeon" placeholder="请输入术者及职称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="助手及职称" prop="assistant">
            <el-input v-model="formData.assistant" placeholder="请输入助手及职称" />
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 术前讨论结果 -->
      <el-form-item label="术前讨论结果" prop="discussionResult">
        <el-input
          v-model="formData.discussionResult"
          type="textarea"
          :rows="8"
          placeholder="请输入术前讨论结果（包括针对特殊情况的处理、患者对手术耐受性的评估、术中可能预见情况及处理预案）"
        />
      </el-form-item>

      <!-- 报告医师 -->
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label="报告医师" prop="reportingPhysician">
            <el-input v-model="formData.reportingPhysician" placeholder="请输入报告医师姓名" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="报告日期" prop="reportingDate">
            <el-date-picker
              v-model="formData.reportingDate"
              type="date"
              placeholder="选择报告日期"
              format="YYYY 年 MM 月 DD 日"
              value-format="YYYY-MM-DD"
            />
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 知情同意情况 -->
      <el-form-item label="患者或授权委托人知情同意情况" prop="informedConsent">
        <el-input v-model="formData.informedConsent" type="textarea" :rows="6" placeholder="请输入知情同意情况" />
      </el-form-item>

      <!-- 科室意见 -->
      <el-card class="opinion-card">
        <template #header>
          <span>科室意见</span>
        </template>
        <el-row :gutter="20">
          <el-col :span="12">
            <el-form-item label="科室主任签字" prop="departmentDirector">
              <el-input v-model="formData.departmentDirector" placeholder="请输入科室主任姓名" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="签字日期" prop="departmentDate">
              <el-date-picker
                v-model="formData.departmentDate"
                type="date"
                placeholder="选择签字日期"
                format="YYYY 年 MM 月 DD 日"
                value-format="YYYY-MM-DD"
              />
            </el-form-item>
          </el-col>
        </el-row>
      </el-card>

      <!-- 医务部意见 -->
      <el-card class="opinion-card">
        <template #header>
          <span>医务部意见</span>
        </template>
        <el-form-item label="医务部主任签字" prop="medicalDirector">
          <el-input v-model="formData.medicalDirector" placeholder="请输入医务部主任姓名" />
        </el-form-item>
      </el-card>

      <!-- 备注 -->
      <el-alert title="注：本表一式两份，一份科室存档，一份医务部存档。" type="info" :closable="false" class="note" />

      <!-- 操作按钮 -->
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交审批</el-button>
        <el-button @click="resetForm">重置</el-button>
        <el-button @click="printForm">打印</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup lang="ts" name="SurgeryApprovalForm">
import { ref, reactive, onMounted } from 'vue';
import { ElMessage, ElMessageBox } from 'element-plus';
import type { FormInstance, FormRules } from 'element-plus';
import { submitApproval } from '@/api/system/surgeryApprovalForm';
import { SurgeryApprovalFormForm } from '@/api/system/surgeryApprovalForm/types';
import { useUserStore } from '@/store/modules/user';
import { deptTreeSelect } from '@/api/system/user';

// 表单数据
const formData = reactive<SurgeryApprovalFormForm>({});

// 部门树数据
const deptTree = ref([]);

// 表单验证规则
const rules: FormRules = {
  deptId: [{ required: true, message: '请选择申报科室', trigger: 'change' }],
  reportDate: [{ required: true, message: '请选择申报日期', trigger: 'change' }],
  patientName: [{ required: true, message: '请输入患者姓名', trigger: 'blur' }],
  gender: [{ required: true, message: '请选择性别', trigger: 'change' }],
  age: [{ required: true, message: '请输入年龄', trigger: 'blur' }],
  hospitalNumber: [{ required: true, message: '请输入住院号', trigger: 'blur' }],
  preoperativeDiagnosis: [{ required: true, message: '请输入术前诊断', trigger: 'blur' }],
  surgeryName: [{ required: true, message: '请输入手术名称', trigger: 'blur' }],
  surgeryLevel: [{ required: true, message: '请选择手术级别', trigger: 'change' }],
  anesthesiaMethod: [{ required: true, message: '请输入麻醉方式', trigger: 'blur' }],
  surgeon: [{ required: true, message: '请输入术者及职称', trigger: 'blur' }],
  assistant: [{ required: true, message: '请输入助手及职称', trigger: 'blur' }],
  discussionResult: [{ required: true, message: '请输入术前讨论结果', trigger: 'blur' }],
  reportingPhysician: [{ required: true, message: '请输入报告医师', trigger: 'blur' }],
  reportingDate: [{ required: true, message: '请选择报告日期', trigger: 'change' }],
  informedConsent: [{ required: true, message: '请输入知情同意情况', trigger: 'blur' }],
  departmentDirector: [{ required: true, message: '请输入科室主任签字', trigger: 'blur' }],
  departmentDate: [{ required: true, message: '请选择签字日期', trigger: 'change' }],
  medicalDirector: [{ required: true, message: '请输入医务部主任签字', trigger: 'blur' }]
};

const formRef = ref<FormInstance>();

// 处理部门选择变化
const handleDeptChange = (value: number | string) => {
  const findDeptName = (tree: any[], deptId: number | string): string => {
    for (const node of tree) {
      if (node.id === deptId) {
        return node.label;
      }
      if (node.children && node.children.length > 0) {
        const found = findDeptName(node.children, deptId);
        if (found) return found;
      }
    }
    return '';
  };
  formData.deptName = findDeptName(deptTree.value, value);
};

// 初始化表单数据
onMounted(async () => {
  const userStore = useUserStore();

  // 获取部门树
  try {
    const res = await deptTreeSelect();
    deptTree.value = res.data;
  } catch (error) {
    console.error('获取部门树失败:', error);
  }

  // 如果用户信息还没有加载，获取用户信息
  if (!userStore.deptName) {
    await userStore.getInfo();
  }

  // 自动填充申报科室为当前用户的部门
  formData.deptName = userStore.deptName;
  // 找到当前用户的部门ID并设置
  const findDeptId = (tree: any[], deptName: string): number | string | null => {
    for (const node of tree) {
      if (node.label === deptName) {
        return node.id;
      }
      if (node.children && node.children.length > 0) {
        const found = findDeptId(node.children, deptName);
        if (found) return found;
      }
    }
    return null;
  };
  formData.deptId = findDeptId(deptTree.value, userStore.deptName);
});

// 提交表单
const submitForm = async () => {
  if (!formRef.value) return;

  await formRef.value.validate((valid) => {
    if (valid) {
      ElMessageBox.confirm('确认提交重大手术审批报告单？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(async () => {
          try {
            await submitApproval(formData);
            ElMessage.success('提交成功！');
            // 可以重定向到列表页或清空表单
            resetForm();
          } catch (error) {
            ElMessage.error('提交失败，请重试');
            console.error('提交失败:', error);
          }
        })
        .catch(() => {
          ElMessage.info('已取消提交');
        });
    } else {
      ElMessage.error('请填写完整的表单信息');
      return false;
    }
  });
};

// 重置表单
const resetForm = () => {
  formRef.value?.resetFields();
  ElMessage.info('表单已重置');
};

// 打印表单
const printForm = () => {
  window.print();
};
</script>

<style scoped>
.app-container {
  padding: 20px;
  background: #f5f5f5;
  min-height: 100vh;
}

.form-title {
  text-align: center;
  margin-bottom: 30px;
  color: #333;
  font-size: 24px;
  font-weight: bold;
}

.opinion-card {
  margin-bottom: 20px;
}

.opinion-card :deep(.el-card__header) {
  background: #f8f9fa;
  font-weight: bold;
}

.note {
  margin-bottom: 20px;
}

:deep(.el-form-item__label) {
  font-weight: 500;
}

:deep(.el-input__inner),
:deep(.el-textarea__inner),
:deep(.el-select__input) {
  border-radius: 4px;
}

@media print {
  .app-container {
    padding: 0;
    background: white;
  }

  .el-button {
    display: none;
  }
}
</style>
