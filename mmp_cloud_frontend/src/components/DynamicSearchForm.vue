<template>
  <el-form :model="query" :inline="true" ref="formRef">
    <el-form-item v-for="field in visibleFields" :key="field.prop" :prop="field.prop">
      <template #label>
        <el-tooltip :content="field.label" placement="top">
          <span class="search-label">{{ getTruncatedLabel(field.label) }}</span>
        </el-tooltip>
      </template>
      <el-date-picker
        v-if="field.type === 'date' || field.type === 'datetime'"
        v-model="query[field.prop]"
        :type="field.componentProps?.type || (field.type === 'datetime' ? 'datetime' : 'date')"
        :value-format="field.componentProps?.valueFormat"
        :placeholder="field.componentProps?.placeholder"
        clearable
      />
      <el-select
        v-else-if="field.type === 'select'"
        v-model="query[field.prop]"
        clearable
        :placeholder="field.componentProps?.placeholder"
        style="min-width: 180px"
      >
        <el-option v-for="opt in field.options || []" :key="opt.value" :label="opt.label" :value="opt.value" />
      </el-select>
      <el-input
        v-else
        v-model="query[field.prop]"
        clearable
        :placeholder="field.componentProps?.placeholder || `请输入${field.label}`"
        @keyup.enter="onSearch"
      />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" icon="Search" @click="onSearch">搜索</el-button>
      <el-button icon="Refresh" @click="onReset">重置</el-button>
    </el-form-item>
  </el-form>
  <slot />
</template>

<script setup lang="ts">
import { ref } from 'vue';
import type { SearchFieldDefinition } from '@/utils/searchConfig';

const props = defineProps<{
  query: Record<string, any>;
  visibleFields: SearchFieldDefinition[];
}>();

const emit = defineEmits<{
  search: [];
  reset: [];
}>();

const formRef = ref();

const onSearch = () => {
  emit('search');
};

const onReset = () => {
  formRef.value?.resetFields();
  emit('reset');
};

defineExpose({
  resetFields: () => formRef.value?.resetFields()
});

const getTruncatedLabel = (label: string) => {
  const chars = Array.from(label || '');
  if (chars.length > 4) return chars.slice(0, 4).join('') + '...';
  return label;
};
</script>

<style scoped>
.search-label {
  display: inline-block;
  max-width: 4em;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
