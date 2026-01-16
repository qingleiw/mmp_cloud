<template>
  <el-dialog title="搜索项配置" v-model="visible" width="600px" append-to-body>
    <div class="search-config">
      <div class="config-header">
        <el-alert title="勾选要显示的搜索项，未勾选的将隐藏" type="info" :closable="false" show-icon />
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
import type { SearchConfigManager } from '@/utils/configs/searchConfigManager';

const props = defineProps<{
  visible?: boolean;
  modelValue?: boolean;
  searchConfigManager: SearchConfigManager;
}>();

const emit = defineEmits<{
  'update:visible': [value: boolean];
  'update:modelValue': [value: boolean];
  'confirm': [];
}>();

const visible = ref(false);

watch(
  () => props.visible ?? props.modelValue,
  (newVal) => {
    if (newVal !== undefined) {
      visible.value = newVal;
    }
  },
  { immediate: true }
);

watch(visible, (newVal) => {
  emit('update:visible', newVal);
  emit('update:modelValue', newVal);
});

const fieldGroups = computed(() => props.searchConfigManager.getFieldGroups());
const fieldVisibility = computed(() => props.searchConfigManager.getFieldVisibility());

const resetToDefault = () => {
  props.searchConfigManager.resetToDefault();
};

const applyConfig = () => {
  props.searchConfigManager.saveConfig();
  emit('confirm');
  visible.value = false;
};
</script>

<style scoped>
:deep(.el-dialog__body) {
  max-height: 70vh;
  overflow-y: auto;
}
.search-config {
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
