import { SearchConfigManager, SearchFieldGroup } from '../searchConfigManager';

// ExamArrangement搜索配置
export function createExamArrangementSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'examCode', label: '考试编号', type: 'input', visible: true, placeholder: '请输入考试编号' },
        { prop: 'examName', label: '考试名称', type: 'input', visible: true, placeholder: '请输入考试名称' },
        { prop: 'paperId', label: '试卷ID', type: 'number', visible: true, placeholder: '请输入试卷ID' },
        { prop: 'qualificationId', label: '资质ID', type: 'number', visible: false, placeholder: '请输入资质ID' },
        { prop: 'examineeIds', label: '考生ID列表', type: 'input', visible: false, placeholder: '请输入考生ID列表' },
        { prop: 'examStatus', label: '考试状态 未开始/进行中/已结束', type: 'input', visible: false, placeholder: '请输入考试状态 未开始/进行中/已结束' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'examStartTime', label: '考试开始时间', type: 'daterange', visible: false, placeholder: '请输入考试开始时间', startProp: 'examStartTimeStart', endProp: 'examStartTimeEnd' },
        { prop: 'examEndTime', label: '考试结束时间', type: 'daterange', visible: false, placeholder: '请输入考试结束时间', startProp: 'examEndTimeStart', endProp: 'examEndTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('ExamArrangement', searchFieldGroups);
}


// ExamPaper搜索配置
export function createExamPaperSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'paperCode', label: '试卷编号', type: 'input', visible: true, placeholder: '请输入试卷编号' },
        { prop: 'paperName', label: '试卷名称', type: 'input', visible: true, placeholder: '请输入试卷名称' },
        { prop: 'qualificationId', label: '关联资质ID', type: 'number', visible: true, placeholder: '请输入关联资质ID' },
        { prop: 'questionIds', label: '题目ID列表JSON', type: 'input', visible: false, placeholder: '请输入题目ID列表JSON' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'totalScore', label: '总分', type: 'number', visible: false, placeholder: '请输入总分' },
        { prop: 'passScore', label: '及格分', type: 'number', visible: false, placeholder: '请输入及格分' },
        { prop: 'examDuration', label: '考试时长', type: 'number', visible: false, placeholder: '请输入考试时长' },
        { prop: 'isRandom', label: '是否随机抽题 1-是 0-否', type: 'number', visible: false, placeholder: '请输入是否随机抽题 1-是 0-否' },
        { prop: 'randomRule', label: '随机规则JSON', type: 'input', visible: false, placeholder: '请输入随机规则JSON' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('ExamPaper', searchFieldGroups);
}


// ExamQuestion搜索配置
export function createExamQuestionSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'questionCode', label: '题目编号', type: 'input', visible: true, placeholder: '请输入题目编号' },
        { prop: 'qualificationId', label: '关联资质ID', type: 'number', visible: true, placeholder: '请输入关联资质ID' },
        { prop: 'questionType', label: '题型 单选/多选/判断/简答', type: 'input', visible: true, placeholder: '请输入题型 单选/多选/判断/简答' },
        { prop: 'difficultyLevel', label: '难度级别 1-易 2-中 3-难', type: 'number', visible: false, placeholder: '请输入难度级别 1-易 2-中 3-难' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'questionContent', label: '题目内容', type: 'input', visible: false, placeholder: '请输入题目内容' },
        { prop: 'optionA', label: '选项A', type: 'input', visible: false, placeholder: '请输入选项A' },
        { prop: 'optionB', label: '选项B', type: 'input', visible: false, placeholder: '请输入选项B' },
        { prop: 'optionC', label: '选项C', type: 'input', visible: false, placeholder: '请输入选项C' },
        { prop: 'optionD', label: '选项D', type: 'input', visible: false, placeholder: '请输入选项D' },
        { prop: 'optionE', label: '选项E', type: 'input', visible: false, placeholder: '请输入选项E' },
        { prop: 'correctAnswer', label: '正确答案', type: 'input', visible: false, placeholder: '请输入正确答案' },
        { prop: 'answerAnalysis', label: '答案解析', type: 'input', visible: false, placeholder: '请输入答案解析' },
        { prop: 'score', label: '分值', type: 'number', visible: false, placeholder: '请输入分值' },
        { prop: 'isEnabled', label: '是否启用', type: 'number', visible: false, placeholder: '请输入是否启用' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('ExamQuestion', searchFieldGroups);
}


// ExamRecord搜索配置
export function createExamRecordSearchConfig() {
  const searchFieldGroups: SearchFieldGroup[] = [
    {
      name: 'basic',
      label: '基础信息',
      fields: [
        { prop: 'id', label: '主键ID', type: 'number', visible: true, placeholder: '请输入主键ID' },
        { prop: 'tenantId', label: '租户编号', type: 'input', visible: true, placeholder: '请输入租户编号' },
        { prop: 'examId', label: '考试安排ID', type: 'number', visible: true, placeholder: '请输入考试安排ID' },
        { prop: 'examineeId', label: '考生ID', type: 'number', visible: true, placeholder: '请输入考生ID' },
        { prop: 'examineeName', label: '考生姓名', type: 'input', visible: true, placeholder: '请输入考生姓名' },
        { prop: 'paperId', label: '试卷ID', type: 'number', visible: false, placeholder: '请输入试卷ID' },
        { prop: 'markingStatus', label: '阅卷状态', type: 'input', visible: false, placeholder: '请输入阅卷状态' }
      ]
    },
    {
      name: 'detail',
      label: '详细信息',
      fields: [
        { prop: 'startTime', label: '开始时间', type: 'daterange', visible: false, placeholder: '请输入开始时间', startProp: 'startTimeStart', endProp: 'startTimeEnd' },
        { prop: 'submitTime', label: '提交时间', type: 'daterange', visible: false, placeholder: '请输入提交时间', startProp: 'submitTimeStart', endProp: 'submitTimeEnd' },
        { prop: 'answerSheet', label: '答题卡JSON', type: 'input', visible: false, placeholder: '请输入答题卡JSON' },
        { prop: 'objectiveScore', label: '客观题得分', type: 'number', visible: false, placeholder: '请输入客观题得分' },
        { prop: 'subjectiveScore', label: '主观题得分', type: 'number', visible: false, placeholder: '请输入主观题得分' },
        { prop: 'totalScore', label: '总分', type: 'number', visible: false, placeholder: '请输入总分' },
        { prop: 'examResult', label: '考试结果 及格/不及格', type: 'input', visible: false, placeholder: '请输入考试结果 及格/不及格' },
        { prop: 'marker', label: '阅卷人', type: 'input', visible: false, placeholder: '请输入阅卷人' },
        { prop: 'markingTime', label: '阅卷时间', type: 'daterange', visible: false, placeholder: '请输入阅卷时间', startProp: 'markingTimeStart', endProp: 'markingTimeEnd' }
      ]
    },
    {
      name: 'system',
      label: '系统字段',
      fields: [
        { prop: 'delFlag', label: '是否删除', type: 'select', visible: false, placeholder: '请输入是否删除' },
        { prop: 'createTime', label: '创建时间', type: 'daterange', visible: false, placeholder: '请输入创建时间', startProp: 'createTimeStart', endProp: 'createTimeEnd' },
        { prop: 'createBy', label: '创建人', type: 'number', visible: false, placeholder: '请输入创建人' },
        { prop: 'createDept', label: '创建部门', type: 'number', visible: false, placeholder: '请输入创建部门' },
        { prop: 'updateTime', label: '更新时间', type: 'daterange', visible: false, placeholder: '请输入更新时间', startProp: 'updateTimeStart', endProp: 'updateTimeEnd' },
        { prop: 'updateBy', label: '更新人', type: 'number', visible: false, placeholder: '请输入更新人' },
        { prop: 'remark', label: '备注', type: 'input', visible: false, placeholder: '请输入备注' }
      ]
    }
  ];

  return new SearchConfigManager('ExamRecord', searchFieldGroups);
}