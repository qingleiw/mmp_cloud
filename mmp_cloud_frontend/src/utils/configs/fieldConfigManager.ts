export type FieldType = 'input' | 'number' | 'select' | 'date' | 'datetime' | 'textarea' | 'switch';

export interface FieldDefinition {
  prop: string;
  label: string;
  visible: boolean;
  formVisible?: boolean;
  searchable?: boolean;
  group: string;
  type?: FieldType;
  required?: boolean;
  width?: string | number;
  minWidth?: number;
  rows?: number;
  options?: Array<{ label: string; value: any }>;
  componentProps?: Record<string, any>;
}

export interface FieldGroup {
  name: string;
  label: string;
  fields: FieldDefinition[];
}

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
    const saved = localStorage.getItem(`${this.pageKey}_field_config`);
    if (saved) {
      try {
        const config = JSON.parse(saved);
        Object.assign(this.fieldVisibility, config);
      } catch {}
    }
  }

  public getFieldGroups(): FieldGroup[] {
    return this.fieldGroups;
  }

  public getFieldVisibility(): Record<string, boolean> {
    return this.fieldVisibility;
  }

  public resetToDefault() {
    Object.assign(this.fieldVisibility, this.getDefaultVisibility());
  }

  public saveConfig() {
    localStorage.setItem(`${this.pageKey}_field_config`, JSON.stringify(this.fieldVisibility));
  }

  public clearConfig() {
    localStorage.removeItem(`${this.pageKey}_field_config`);
    Object.assign(this.fieldVisibility, this.getDefaultVisibility());
  }

  public getVisibleFields(): FieldDefinition[] {
    const visibleFields: FieldDefinition[] = [];
    this.fieldGroups.forEach((group) => {
      group.fields.forEach((field) => {
        if (this.fieldVisibility[field.prop]) {
          visibleFields.push(field);
        }
      });
    });
    return visibleFields;
  }

  public get visibleFields(): FieldDefinition[] {
    return this.getVisibleFields();
  }

  public getFieldConfig(prop: string): FieldDefinition | undefined {
    for (const group of this.fieldGroups) {
      const field = group.fields.find(f => f.prop === prop);
      if (field) {
        return field;
      }
    }
    return undefined;
  }
}