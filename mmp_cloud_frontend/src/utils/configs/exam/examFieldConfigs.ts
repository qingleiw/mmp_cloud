import { FieldConfigManager, FieldGroup } from '../fieldConfigManager';

// ExamArrangement字段配置
export function createExamArrangementFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'examCode', label: '考试编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'examName', label: '考试名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperId', label: '试卷ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'qualificationId', label: '资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'examineeIds', label: '考生ID列表', visible: true, type: 'textarea', group: 'basic' },
        { prop: 'examStatus', label: '考试状态 未开始/进行中/已结束', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examStartTime', label: '考试开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'examEndTime', label: '考试结束时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('ExamArrangement', fieldGroups);
}


// ExamPaper字段配置
export function createExamPaperFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperCode', label: '试卷编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperName', label: '试卷名称', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: '关联资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'questionIds', label: '题目ID列表JSON', visible: true, type: 'textarea', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'totalScore', label: '总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'passScore', label: '及格分', visible: true, type: 'number', group: 'detail' },
        { prop: 'examDuration', label: '考试时长', visible: true, type: 'number', group: 'detail' },
        { prop: 'isRandom', label: '是否随机抽题 1-是 0-否', visible: true, type: 'number', group: 'detail' },
        { prop: 'randomRule', label: '随机规则JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('ExamPaper', fieldGroups);
}


// ExamQuestion字段配置
export function createExamQuestionFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'questionCode', label: '题目编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'qualificationId', label: '关联资质ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'questionType', label: '题型 单选/多选/判断/简答', visible: true, type: 'input', group: 'basic' },
        { prop: 'difficultyLevel', label: '难度级别 1-易 2-中 3-难', visible: true, type: 'number', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'questionContent', label: '题目内容', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionA', label: '选项A', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionB', label: '选项B', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionC', label: '选项C', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionD', label: '选项D', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'optionE', label: '选项E', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'correctAnswer', label: '正确答案', visible: true, type: 'input', group: 'detail' },
        { prop: 'answerAnalysis', label: '答案解析', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'score', label: '分值', visible: true, type: 'number', group: 'detail' },
        { prop: 'isEnabled', label: '是否启用', visible: true, type: 'number', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('ExamQuestion', fieldGroups);
}


// ExamRecord字段配置
export function createExamRecordFieldConfig() {
  const fieldGroups: FieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'tenantId', label: '租户编号', visible: true, type: 'input', group: 'basic' },
        { prop: 'examId', label: '考试安排ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'examineeId', label: '考生ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'examineeName', label: '考生姓名', visible: true, type: 'input', group: 'basic' },
        { prop: 'paperId', label: '试卷ID', visible: true, type: 'number', group: 'basic' },
        { prop: 'markingStatus', label: '阅卷状态', visible: true, type: 'input', group: 'basic' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'startTime', label: '开始时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'submitTime', label: '提交时间', visible: true, type: 'datetime', group: 'detail' },
        { prop: 'answerSheet', label: '答题卡JSON', visible: true, type: 'textarea', group: 'detail' },
        { prop: 'objectiveScore', label: '客观题得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'subjectiveScore', label: '主观题得分', visible: true, type: 'number', group: 'detail' },
        { prop: 'totalScore', label: '总分', visible: true, type: 'number', group: 'detail' },
        { prop: 'examResult', label: '考试结果 及格/不及格', visible: true, type: 'input', group: 'detail' },
        { prop: 'marker', label: '阅卷人', visible: true, type: 'input', group: 'detail' },
        { prop: 'markingTime', label: '阅卷时间', visible: true, type: 'datetime', group: 'detail' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', visible: true, type: 'select', group: 'system' },
        { prop: 'createTime', label: '创建时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'createBy', label: '创建人', visible: true, type: 'number', group: 'system' },
        { prop: 'createDept', label: '创建部门', visible: true, type: 'number', group: 'system' },
        { prop: 'updateTime', label: '更新时间', visible: true, type: 'datetime', group: 'system' },
        { prop: 'updateBy', label: '更新人', visible: true, type: 'number', group: 'system' },
        { prop: 'remark', label: '备注', visible: true, type: 'input', group: 'system' }
      ]
    }
  ];

  return new FieldConfigManager('ExamRecord', fieldGroups);
}