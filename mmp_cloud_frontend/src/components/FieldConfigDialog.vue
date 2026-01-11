<template>
  <el-dialog title="字段显示配置" v-model="visible" width="600px" append-to-body>
    <div class="field-config">
      <div class="config-header">
        <el-alert title="勾选要显示的字段，未勾选的字段将隐藏" type="info" :closable="false" show-icon />
      </div>

      <div class="field-list">
        <div v-for="group in fieldGroups" :key="group.name" class="field-group">
          <h4>{{ group.label }}</h4>
          <div class="field-items">
            <el-checkbox v-for="field in group.fields" :key="field.prop" v-model="fieldVisibility[field.prop]" :disabled="field.required">
              {{ field.label }}
              <el-tag v-if="field.required" size="small" type="warning">必选</el-tag>
            </el-checkbox>
          </div>
        </div>
      </div>

      <div class="config-actions">
        <el-button @click="resetToDefault">恢复默认</el-button>
        <el-button type="primary" @click="applyConfig">应用配置</el-button>
      </div>
    </div>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref, computed, watch } from 'vue';
import type { FieldConfigManager } from '@/utils/fieldConfig';

const props = defineProps<{
  visible: boolean;
  fieldConfigManager: FieldConfigManager;
}>();

const emit = defineEmits<{
  'update:visible': [value: boolean];
  'confirm': [];
}>();

const visible = computed({
  get: () => props.visible,
  set: (value) => emit('update:visible', value)
});

watch(
  () => props.visible,
  (newVal) => {
    // Update field visibility when dialog opens
    if (newVal) {
      updateFieldVisibility();
    }
  }
);

watch(visible, (newVal) => {
  emit('update:visible', newVal);
});

// 计算属性：获取字段组和可见性
const fieldGroups = computed(() => props.fieldConfigManager.getFieldGroups());
const fieldVisibility = computed(() => props.fieldConfigManager.getFieldVisibility());

// 同步最新可见性（占位，computed 已自动更新）
const updateFieldVisibility = () => {};

// 恢复默认配置
const resetToDefault = () => {
  props.fieldConfigManager.resetToDefault();
};

// 应用配置
const applyConfig = () => {
  props.fieldConfigManager.saveConfig();
  emit('confirm', fieldVisibility.value);
  visible.value = false;
};
</script>

<style scoped>
:deep(.el-dialog__body) {
  max-height: 70vh;
  overflow-y: auto;
}
.field-config {
  max-height: none;
  overflow: visible;
}

.config-header {
  margin-bottom: 20px;
}

.field-group {
  margin-bottom: 20px;
}

.field-group h4 {
  margin: 0 0 10px 0;
  color: #303133;
  font-size: 14px;
  font-weight: 500;
  border-bottom: 1px solid #e4e7ed;
  padding-bottom: 5px;
}

.field-items {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 10px;
}

.field-items .el-checkbox {
  margin: 0;
}

.config-actions {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
  padding-top: 15px;
  border-top: 1px solid #e4e7ed;
}
</style>
