import { reactive } from 'vue';

export type SearchFieldType = 'input' | 'number' | 'select' | 'date' | 'datetime' | 'numberrange' | 'daterange';

export interface SearchFieldDefinition {
  prop: string;
  label: string;
  type: SearchFieldType;
  visible: boolean;
  placeholder?: string;
  startProp?: string;
  endProp?: string;
  group?: string;
  required?: boolean;
  options?: Array<{ label: string; value: any }>;
  componentProps?: Record<string, any>;
}

export interface SearchFieldGroup {
  name: string;
  label: string;
  fields: SearchFieldDefinition[];
}

export class SearchConfigManager {
  private pageKey: string;
  private fieldGroups: SearchFieldGroup[];
  private fieldVisibility: Record<string, boolean>;

  constructor(pageKey: string, fieldGroups: SearchFieldGroup[]) {
    this.pageKey = pageKey;
    this.fieldGroups = fieldGroups;
    this.fieldVisibility = reactive(this.getDefaultVisibility());
    this.loadConfig();
  }

  private getDefaultVisibility(): Record<string, boolean> {
    const visibility: Record<string, boolean> = {};
    this.fieldGroups.forEach((group) => {
      group.fields.forEach((field) => {
        visibility[field.prop] = field.visible;
      });
    });
    return visibility;
  }

  private loadConfig() {
    const saved = localStorage.getItem(`${this.pageKey}_search_config`);
    if (saved) {
      try {
        const config = JSON.parse(saved);
        Object.assign(this.fieldVisibility, config);
      } catch {}
    }
  }

  saveConfig() {
    localStorage.setItem(`${this.pageKey}_search_config`, JSON.stringify(this.fieldVisibility));
  }

  resetToDefault() {
    Object.assign(this.fieldVisibility, this.getDefaultVisibility());
    this.saveConfig();
  }

  clearConfig() {
    localStorage.removeItem(`${this.pageKey}_search_config`);
    this.resetToDefault();
  }

  getVisibleFields(): SearchFieldDefinition[] {
    const allFields = this.fieldGroups.flatMap((g) => g.fields);
    const visible = allFields.filter((f) => this.fieldVisibility[f.prop]);
    if (visible.length === 0) {
      this.resetToDefault();
      return allFields.filter((f) => this.fieldVisibility[f.prop]);
    }
    return visible;
  }

  getFieldGroups(): SearchFieldGroup[] {
    return this.fieldGroups;
  }

  getFieldVisibility(): Record<string, boolean> {
    return this.fieldVisibility;
  }

  updateConfig(config: Record<string, boolean>) {
    Object.assign(this.fieldVisibility, config);
    this.saveConfig();
  }
}