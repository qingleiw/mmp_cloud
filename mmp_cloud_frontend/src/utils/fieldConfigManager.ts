import { reactive, computed } from 'vue';

export interface FieldDefinition {
  prop: string;
  label: string;
  visible: boolean;
  required?: boolean;
  width?: string | number;
  minWidth?: string | number;
  group?: string;
  sortable?: boolean;
  align?: string;
  showOverflowTooltip?: boolean;
  formSpan?: number;
  type?: string;
  options?: any[];
}

export interface FieldGroup {
  name: string;
  label: string;
  fields: FieldDefinition[];
}

/**
 * 字段配置管理器
 */
export class FieldConfigManager {
  private pageKey: string;
  private fieldGroups: FieldGroup[];
  private fieldVisibility: Record<string, boolean>;

  constructor(pageKey: string, fieldGroups: FieldGroup[]) {
    this.pageKey = pageKey;
    this.fieldGroups = fieldGroups;
    this.fieldVisibility = reactive(this.getDefaultVisibility());
    this.loadConfig();
  }

  /**
   * 获取默认字段可见性
   */
  private getDefaultVisibility(): Record<string, boolean> {
    const visibility: Record<string, boolean> = {};
    this.fieldGroups.forEach((group) => {
      group.fields.forEach((field) => {
        visibility[field.prop] = field.visible;
      });
    });
    return visibility;
  }

  /**
   * 从本地存储加载配置
   */
  private loadConfig() {
    const saved = localStorage.getItem(`${this.pageKey}_field_config`);
    if (saved) {
      try {
        const config = JSON.parse(saved);
        // 检查配置是否有效，至少有一个true
        const hasVisible = Object.values(config).some((v: any) => v === true);
        if (hasVisible) {
          Object.assign(this.fieldVisibility, config);
        } else {
          // 如果配置无效，清除
          localStorage.removeItem(`${this.pageKey}_field_config`);
        }
      } catch (error) {
        console.warn('Failed to load field config:', error);
        localStorage.removeItem(`${this.pageKey}_field_config`);
      }
    }

    // 对于doctorInfo和doctorEducation页面，确保系统字段始终可见
    if (this.pageKey === 'doctorInfo' || this.pageKey === 'doctorEducation') {
      this.fieldVisibility['createTime'] = true;
      this.fieldVisibility['updateTime'] = true;
    }
  }

  /**
   * 保存配置到本地存储
   */
  saveConfig() {
    localStorage.setItem(`${this.pageKey}_field_config`, JSON.stringify(this.fieldVisibility));
  }

  /**
   * 重置为默认配置
   */
  resetToDefault() {
    Object.assign(this.fieldVisibility, this.getDefaultVisibility());
    this.saveConfig();
  }

  /**
   * 清除本地存储配置
   */
  clearConfig() {
    localStorage.removeItem(`${this.pageKey}_field_config`);
    this.resetToDefault();
  }

  /**
   * 获取可见字段列表
   */
  getVisibleFields(): FieldDefinition[] {
    const allFields = this.fieldGroups.flatMap((group) => group.fields);
    return allFields.filter((field) => field && field.prop && this.fieldVisibility[field.prop]);
  }

  /**
   * 可见字段列表（用于模板绑定）
   */
  get visibleFields(): FieldDefinition[] {
    return this.getVisibleFields();
  }

  /**
   * 获取字段组
   */
  getFieldGroups(): FieldGroup[] {
    return this.fieldGroups;
  }

  /**
   * 获取字段可见性对象（用于响应式绑定）
   */
  getFieldVisibility(): Record<string, boolean> {
    return this.fieldVisibility;
  }

  /**
   * 获取字段配置信息
   */
  getFieldConfig(prop: string): { visible: boolean; label: string; width?: string | number } {
    const field = this.fieldGroups.flatMap((group) => group.fields).find((f) => f.prop === prop);
    if (!field) {
      console.warn(`Field ${prop} not found in configuration`);
      return { visible: false, label: prop };
    }
    return {
      visible: this.fieldVisibility[prop] ?? field.visible,
      label: field.label,
      width: field.width || field.minWidth
    };
  }

  /**
   * 更新字段配置
   */
  updateConfig(config: Record<string, boolean>) {
    Object.assign(this.fieldVisibility, config);
    this.saveConfig();
  }
}
