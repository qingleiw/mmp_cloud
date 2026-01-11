-- ----------------------------
-- 质量控制菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建质量控制主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('22000', '质量控制', '0', '100', 'qc', NULL, '', 1, 0, 'M', '0', '0', '', 'check-circle', 100, 1, sysdate(), NULL, NULL, '质量控制目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('22010', '质量数据采集', '22000', '10', 'qcDataCollection', 'qc/qcDataCollection/index', '', 1, 0, 'C', '0', '0', 'qc:qcDataCollection:list', 'database', 100, 1, sysdate(), NULL, NULL, '质量数据采集');
INSERT INTO sys_menu VALUES ('22020', '质量指标配置', '22000', '20', 'qcIndicatorConfig', 'qc/qcIndicatorConfig/index', '', 1, 0, 'C', '0', '0', 'qc:qcIndicatorConfig:list', 'cogs', 100, 1, sysdate(), NULL, NULL, '质量指标配置');
INSERT INTO sys_menu VALUES ('22030', '质量指标数据', '22000', '30', 'qcIndicatorData', 'qc/qcIndicatorData/index', '', 1, 0, 'C', '0', '0', 'qc:qcIndicatorData:list', 'chart-line', 100, 1, sysdate(), NULL, NULL, '质量指标数据');
INSERT INTO sys_menu VALUES ('22040', '质量指标报告', '22000', '40', 'qcIndicatorReport', 'qc/qcIndicatorReport/index', '', 1, 0, 'C', '0', '0', 'qc:qcIndicatorReport:list', 'file-chart-line', 100, 1, sysdate(), NULL, NULL, '质量指标报告');
INSERT INTO sys_menu VALUES ('22050', '质量计划', '22000', '50', 'qcPlan', 'qc/qcPlan/index', '', 1, 0, 'C', '0', '0', 'qc:qcPlan:list', 'clipboard-check', 100, 1, sysdate(), NULL, NULL, '质量计划');
INSERT INTO sys_menu VALUES ('22060', '质量计划执行', '22000', '60', 'qcPlanExecution', 'qc/qcPlanExecution/index', '', 1, 0, 'C', '0', '0', 'qc:qcPlanExecution:list', 'play-circle', 100, 1, sysdate(), NULL, NULL, '质量计划执行');
INSERT INTO sys_menu VALUES ('22070', '质量计划模板', '22000', '70', 'qcPlanTemplate', 'qc/qcPlanTemplate/index', '', 1, 0, 'C', '0', '0', 'qc:qcPlanTemplate:list', 'file-contract', 100, 1, sysdate(), NULL, NULL, '质量计划模板');
INSERT INTO sys_menu VALUES ('22080', '质量规则', '22000', '80', 'qcRule', 'qc/qcRule/index', '', 1, 0, 'C', '0', '0', 'qc:qcRule:list', 'gavel', 100, 1, sysdate(), NULL, NULL, '质量规则');
INSERT INTO sys_menu VALUES ('22090', '质量规则执行', '22000', '90', 'qcRuleExecution', 'qc/qcRuleExecution/index', '', 1, 0, 'C', '0', '0', 'qc:qcRuleExecution:list', 'bolt', 100, 1, sysdate(), NULL, NULL, '质量规则执行');
INSERT INTO sys_menu VALUES ('22100', '质量标准', '22000', '100', 'qcStandard', 'qc/qcStandard/index', '', 1, 0, 'C', '0', '0', 'qc:qcStandard:list', 'award', 100, 1, sysdate(), NULL, NULL, '质量标准');
INSERT INTO sys_menu VALUES ('22110', '质量任务', '22000', '110', 'qcTask', 'qc/qcTask/index', '', 1, 0, 'C', '0', '0', 'qc:qcTask:list', 'tasks', 100, 1, sysdate(), NULL, NULL, '质量任务');
INSERT INTO sys_menu VALUES ('22120', '质量任务执行', '22000', '120', 'qcTaskExecution', 'qc/qcTaskExecution/index', '', 1, 0, 'C', '0', '0', 'qc:qcTaskExecution:list', 'running', 100, 1, sysdate(), NULL, NULL, '质量任务执行');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 质量数据采集按钮
INSERT INTO sys_menu VALUES ('22011', '质量数据采集查询', '22010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22012', '质量数据采集新增', '22010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22013', '质量数据采集修改', '22010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22014', '质量数据采集删除', '22010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22015', '质量数据采集导入', '22010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22016', '质量数据采集导出', '22010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量指标配置按钮
INSERT INTO sys_menu VALUES ('22021', '质量指标配置查询', '22020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorConfig:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22022', '质量指标配置新增', '22020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorConfig:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22023', '质量指标配置修改', '22020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorConfig:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22024', '质量指标配置删除', '22020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorConfig:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22025', '质量指标配置导入', '22020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorConfig:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22026', '质量指标配置导出', '22020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorConfig:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量指标数据按钮
INSERT INTO sys_menu VALUES ('22031', '质量指标数据查询', '22030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorData:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22032', '质量指标数据新增', '22030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorData:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22033', '质量指标数据修改', '22030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorData:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22034', '质量指标数据删除', '22030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorData:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22035', '质量指标数据导入', '22030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorData:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22036', '质量指标数据导出', '22030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorData:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量指标报告按钮
INSERT INTO sys_menu VALUES ('22041', '质量指标报告查询', '22040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorReport:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22042', '质量指标报告新增', '22040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorReport:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22043', '质量指标报告修改', '22040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorReport:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22044', '质量指标报告删除', '22040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorReport:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22045', '质量指标报告导入', '22040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorReport:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22046', '质量指标报告导出', '22040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorReport:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量计划按钮
INSERT INTO sys_menu VALUES ('22051', '质量计划查询', '22050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22052', '质量计划新增', '22050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22053', '质量计划修改', '22050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22054', '质量计划删除', '22050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22055', '质量计划导入', '22050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22056', '质量计划导出', '22050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量计划执行按钮
INSERT INTO sys_menu VALUES ('22061', '质量计划执行查询', '22060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanExecution:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22062', '质量计划执行新增', '22060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanExecution:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22063', '质量计划执行修改', '22060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanExecution:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22064', '质量计划执行删除', '22060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanExecution:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22065', '质量计划执行导入', '22060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanExecution:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22066', '质量计划执行导出', '22060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanExecution:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量计划模板按钮
INSERT INTO sys_menu VALUES ('22071', '质量计划模板查询', '22070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanTemplate:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22072', '质量计划模板新增', '22070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanTemplate:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22073', '质量计划模板修改', '22070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanTemplate:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22074', '质量计划模板删除', '22070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanTemplate:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22075', '质量计划模板导入', '22070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanTemplate:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22076', '质量计划模板导出', '22070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcPlanTemplate:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量规则按钮
INSERT INTO sys_menu VALUES ('22081', '质量规则查询', '22080', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRule:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22082', '质量规则新增', '22080', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRule:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22083', '质量规则修改', '22080', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRule:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22084', '质量规则删除', '22080', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRule:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22085', '质量规则导入', '22080', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRule:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22086', '质量规则导出', '22080', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRule:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量规则执行按钮
INSERT INTO sys_menu VALUES ('22091', '质量规则执行查询', '22090', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRuleExecution:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22092', '质量规则执行新增', '22090', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRuleExecution:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22093', '质量规则执行修改', '22090', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRuleExecution:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22094', '质量规则执行删除', '22090', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRuleExecution:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22095', '质量规则执行导入', '22090', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRuleExecution:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22096', '质量规则执行导出', '22090', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcRuleExecution:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量标准按钮
INSERT INTO sys_menu VALUES ('22101', '质量标准查询', '22100', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcStandard:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22102', '质量标准新增', '22100', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcStandard:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22103', '质量标准修改', '22100', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcStandard:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22104', '质量标准删除', '22100', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcStandard:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22105', '质量标准导入', '22100', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcStandard:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22106', '质量标准导出', '22100', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcStandard:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量任务按钮
INSERT INTO sys_menu VALUES ('22111', '质量任务查询', '22110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTask:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22112', '质量任务新增', '22110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTask:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22113', '质量任务修改', '22110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTask:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22114', '质量任务删除', '22110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTask:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22115', '质量任务导入', '22110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTask:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22116', '质量任务导出', '22110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTask:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量任务执行按钮
INSERT INTO sys_menu VALUES ('22121', '质量任务执行查询', '22120', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTaskExecution:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22122', '质量任务执行新增', '22120', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTaskExecution:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22123', '质量任务执行修改', '22120', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTaskExecution:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22124', '质量任务执行删除', '22120', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTaskExecution:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22125', '质量任务执行导入', '22120', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTaskExecution:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22126', '质量任务执行导出', '22120', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcTaskExecution:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '22000');

INSERT INTO sys_role_menu VALUES ('5', '22010');
INSERT INTO sys_role_menu VALUES ('5', '22011');
INSERT INTO sys_role_menu VALUES ('5', '22012');
INSERT INTO sys_role_menu VALUES ('5', '22013');
INSERT INTO sys_role_menu VALUES ('5', '22014');
INSERT INTO sys_role_menu VALUES ('5', '22015');
INSERT INTO sys_role_menu VALUES ('5', '22016');

INSERT INTO sys_role_menu VALUES ('5', '22020');
INSERT INTO sys_role_menu VALUES ('5', '22021');
INSERT INTO sys_role_menu VALUES ('5', '22022');
INSERT INTO sys_role_menu VALUES ('5', '22023');
INSERT INTO sys_role_menu VALUES ('5', '22024');
INSERT INTO sys_role_menu VALUES ('5', '22025');
INSERT INTO sys_role_menu VALUES ('5', '22026');

INSERT INTO sys_role_menu VALUES ('5', '22030');
INSERT INTO sys_role_menu VALUES ('5', '22031');
INSERT INTO sys_role_menu VALUES ('5', '22032');
INSERT INTO sys_role_menu VALUES ('5', '22033');
INSERT INTO sys_role_menu VALUES ('5', '22034');
INSERT INTO sys_role_menu VALUES ('5', '22035');
INSERT INTO sys_role_menu VALUES ('5', '22036');

INSERT INTO sys_role_menu VALUES ('5', '22040');
INSERT INTO sys_role_menu VALUES ('5', '22041');
INSERT INTO sys_role_menu VALUES ('5', '22042');
INSERT INTO sys_role_menu VALUES ('5', '22043');
INSERT INTO sys_role_menu VALUES ('5', '22044');
INSERT INTO sys_role_menu VALUES ('5', '22045');
INSERT INTO sys_role_menu VALUES ('5', '22046');

INSERT INTO sys_role_menu VALUES ('5', '22050');
INSERT INTO sys_role_menu VALUES ('5', '22051');
INSERT INTO sys_role_menu VALUES ('5', '22052');
INSERT INTO sys_role_menu VALUES ('5', '22053');
INSERT INTO sys_role_menu VALUES ('5', '22054');
INSERT INTO sys_role_menu VALUES ('5', '22055');
INSERT INTO sys_role_menu VALUES ('5', '22056');

INSERT INTO sys_role_menu VALUES ('5', '22060');
INSERT INTO sys_role_menu VALUES ('5', '22061');
INSERT INTO sys_role_menu VALUES ('5', '22062');
INSERT INTO sys_role_menu VALUES ('5', '22063');
INSERT INTO sys_role_menu VALUES ('5', '22064');
INSERT INTO sys_role_menu VALUES ('5', '22065');
INSERT INTO sys_role_menu VALUES ('5', '22066');

INSERT INTO sys_role_menu VALUES ('5', '22070');
INSERT INTO sys_role_menu VALUES ('5', '22071');
INSERT INTO sys_role_menu VALUES ('5', '22072');
INSERT INTO sys_role_menu VALUES ('5', '22073');
INSERT INTO sys_role_menu VALUES ('5', '22074');
INSERT INTO sys_role_menu VALUES ('5', '22075');
INSERT INTO sys_role_menu VALUES ('5', '22076');

INSERT INTO sys_role_menu VALUES ('5', '22080');
INSERT INTO sys_role_menu VALUES ('5', '22081');
INSERT INTO sys_role_menu VALUES ('5', '22082');
INSERT INTO sys_role_menu VALUES ('5', '22083');
INSERT INTO sys_role_menu VALUES ('5', '22084');
INSERT INTO sys_role_menu VALUES ('5', '22085');
INSERT INTO sys_role_menu VALUES ('5', '22086');

INSERT INTO sys_role_menu VALUES ('5', '22090');
INSERT INTO sys_role_menu VALUES ('5', '22091');
INSERT INTO sys_role_menu VALUES ('5', '22092');
INSERT INTO sys_role_menu VALUES ('5', '22093');
INSERT INTO sys_role_menu VALUES ('5', '22094');
INSERT INTO sys_role_menu VALUES ('5', '22095');
INSERT INTO sys_role_menu VALUES ('5', '22096');

INSERT INTO sys_role_menu VALUES ('5', '22100');
INSERT INTO sys_role_menu VALUES ('5', '22101');
INSERT INTO sys_role_menu VALUES ('5', '22102');
INSERT INTO sys_role_menu VALUES ('5', '22103');
INSERT INTO sys_role_menu VALUES ('5', '22104');
INSERT INTO sys_role_menu VALUES ('5', '22105');
INSERT INTO sys_role_menu VALUES ('5', '22106');

INSERT INTO sys_role_menu VALUES ('5', '22110');
INSERT INTO sys_role_menu VALUES ('5', '22111');
INSERT INTO sys_role_menu VALUES ('5', '22112');
INSERT INTO sys_role_menu VALUES ('5', '22113');
INSERT INTO sys_role_menu VALUES ('5', '22114');
INSERT INTO sys_role_menu VALUES ('5', '22115');
INSERT INTO sys_role_menu VALUES ('5', '22116');

INSERT INTO sys_role_menu VALUES ('5', '22120');
INSERT INTO sys_role_menu VALUES ('5', '22121');
INSERT INTO sys_role_menu VALUES ('5', '22122');
INSERT INTO sys_role_menu VALUES ('5', '22123');
INSERT INTO sys_role_menu VALUES ('5', '22124');
INSERT INTO sys_role_menu VALUES ('5', '22125');
INSERT INTO sys_role_menu VALUES ('5', '22126');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '22000');

INSERT INTO sys_role_menu VALUES ('6', '22010');
INSERT INTO sys_role_menu VALUES ('6', '22011');
INSERT INTO sys_role_menu VALUES ('6', '22012');
INSERT INTO sys_role_menu VALUES ('6', '22013');
INSERT INTO sys_role_menu VALUES ('6', '22014');
INSERT INTO sys_role_menu VALUES ('6', '22015');
INSERT INTO sys_role_menu VALUES ('6', '22016');

INSERT INTO sys_role_menu VALUES ('6', '22020');
INSERT INTO sys_role_menu VALUES ('6', '22021');
INSERT INTO sys_role_menu VALUES ('6', '22022');
INSERT INTO sys_role_menu VALUES ('6', '22023');
INSERT INTO sys_role_menu VALUES ('6', '22024');
INSERT INTO sys_role_menu VALUES ('6', '22025');
INSERT INTO sys_role_menu VALUES ('6', '22026');

INSERT INTO sys_role_menu VALUES ('6', '22030');
INSERT INTO sys_role_menu VALUES ('6', '22031');
INSERT INTO sys_role_menu VALUES ('6', '22032');
INSERT INTO sys_role_menu VALUES ('6', '22033');
INSERT INTO sys_role_menu VALUES ('6', '22034');
INSERT INTO sys_role_menu VALUES ('6', '22035');
INSERT INTO sys_role_menu VALUES ('6', '22036');

INSERT INTO sys_role_menu VALUES ('6', '22040');
INSERT INTO sys_role_menu VALUES ('6', '22041');
INSERT INTO sys_role_menu VALUES ('6', '22042');
INSERT INTO sys_role_menu VALUES ('6', '22043');
INSERT INTO sys_role_menu VALUES ('6', '22044');
INSERT INTO sys_role_menu VALUES ('6', '22045');
INSERT INTO sys_role_menu VALUES ('6', '22046');

INSERT INTO sys_role_menu VALUES ('6', '22050');
INSERT INTO sys_role_menu VALUES ('6', '22051');
INSERT INTO sys_role_menu VALUES ('6', '22052');
INSERT INTO sys_role_menu VALUES ('6', '22053');
INSERT INTO sys_role_menu VALUES ('6', '22054');
INSERT INTO sys_role_menu VALUES ('6', '22055');
INSERT INTO sys_role_menu VALUES ('6', '22056');

INSERT INTO sys_role_menu VALUES ('6', '22060');
INSERT INTO sys_role_menu VALUES ('6', '22061');
INSERT INTO sys_role_menu VALUES ('6', '22062');
INSERT INTO sys_role_menu VALUES ('6', '22063');
INSERT INTO sys_role_menu VALUES ('6', '22064');
INSERT INTO sys_role_menu VALUES ('6', '22065');
INSERT INTO sys_role_menu VALUES ('6', '22066');

INSERT INTO sys_role_menu VALUES ('6', '22070');
INSERT INTO sys_role_menu VALUES ('6', '22071');
INSERT INTO sys_role_menu VALUES ('6', '22072');
INSERT INTO sys_role_menu VALUES ('6', '22073');
INSERT INTO sys_role_menu VALUES ('6', '22074');
INSERT INTO sys_role_menu VALUES ('6', '22075');
INSERT INTO sys_role_menu VALUES ('6', '22076');

INSERT INTO sys_role_menu VALUES ('6', '22080');
INSERT INTO sys_role_menu VALUES ('6', '22081');
INSERT INTO sys_role_menu VALUES ('6', '22082');
INSERT INTO sys_role_menu VALUES ('6', '22083');
INSERT INTO sys_role_menu VALUES ('6', '22084');
INSERT INTO sys_role_menu VALUES ('6', '22085');
INSERT INTO sys_role_menu VALUES ('6', '22086');

INSERT INTO sys_role_menu VALUES ('6', '22090');
INSERT INTO sys_role_menu VALUES ('6', '22091');
INSERT INTO sys_role_menu VALUES ('6', '22092');
INSERT INTO sys_role_menu VALUES ('6', '22093');
INSERT INTO sys_role_menu VALUES ('6', '22094');
INSERT INTO sys_role_menu VALUES ('6', '22095');
INSERT INTO sys_role_menu VALUES ('6', '22096');

INSERT INTO sys_role_menu VALUES ('6', '22100');
INSERT INTO sys_role_menu VALUES ('6', '22101');
INSERT INTO sys_role_menu VALUES ('6', '22102');
INSERT INTO sys_role_menu VALUES ('6', '22103');
INSERT INTO sys_role_menu VALUES ('6', '22104');
INSERT INTO sys_role_menu VALUES ('6', '22105');
INSERT INTO sys_role_menu VALUES ('6', '22106');

INSERT INTO sys_role_menu VALUES ('6', '22110');
INSERT INTO sys_role_menu VALUES ('6', '22111');
INSERT INTO sys_role_menu VALUES ('6', '22112');
INSERT INTO sys_role_menu VALUES ('6', '22113');
INSERT INTO sys_role_menu VALUES ('6', '22114');
INSERT INTO sys_role_menu VALUES ('6', '22115');
INSERT INTO sys_role_menu VALUES ('6', '22116');

INSERT INTO sys_role_menu VALUES ('6', '22120');
INSERT INTO sys_role_menu VALUES ('6', '22121');
INSERT INTO sys_role_menu VALUES ('6', '22122');
INSERT INTO sys_role_menu VALUES ('6', '22123');
INSERT INTO sys_role_menu VALUES ('6', '22124');
INSERT INTO sys_role_menu VALUES ('6', '22125');
INSERT INTO sys_role_menu VALUES ('6', '22126');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '22000');

INSERT INTO sys_role_menu VALUES ('7', '22010');
INSERT INTO sys_role_menu VALUES ('7', '22011');
INSERT INTO sys_role_menu VALUES ('7', '22012');
INSERT INTO sys_role_menu VALUES ('7', '22013');
INSERT INTO sys_role_menu VALUES ('7', '22014');
INSERT INTO sys_role_menu VALUES ('7', '22015');
INSERT INTO sys_role_menu VALUES ('7', '22016');

INSERT INTO sys_role_menu VALUES ('7', '22020');
INSERT INTO sys_role_menu VALUES ('7', '22021');
INSERT INTO sys_role_menu VALUES ('7', '22022');
INSERT INTO sys_role_menu VALUES ('7', '22023');
INSERT INTO sys_role_menu VALUES ('7', '22024');
INSERT INTO sys_role_menu VALUES ('7', '22025');
INSERT INTO sys_role_menu VALUES ('7', '22026');

INSERT INTO sys_role_menu VALUES ('7', '22030');
INSERT INTO sys_role_menu VALUES ('7', '22031');
INSERT INTO sys_role_menu VALUES ('7', '22032');
INSERT INTO sys_role_menu VALUES ('7', '22033');
INSERT INTO sys_role_menu VALUES ('7', '22034');
INSERT INTO sys_role_menu VALUES ('7', '22035');
INSERT INTO sys_role_menu VALUES ('7', '22036');

INSERT INTO sys_role_menu VALUES ('7', '22040');
INSERT INTO sys_role_menu VALUES ('7', '22041');
INSERT INTO sys_role_menu VALUES ('7', '22042');
INSERT INTO sys_role_menu VALUES ('7', '22043');
INSERT INTO sys_role_menu VALUES ('7', '22044');
INSERT INTO sys_role_menu VALUES ('7', '22045');
INSERT INTO sys_role_menu VALUES ('7', '22046');

INSERT INTO sys_role_menu VALUES ('7', '22050');
INSERT INTO sys_role_menu VALUES ('7', '22051');
INSERT INTO sys_role_menu VALUES ('7', '22052');
INSERT INTO sys_role_menu VALUES ('7', '22053');
INSERT INTO sys_role_menu VALUES ('7', '22054');
INSERT INTO sys_role_menu VALUES ('7', '22055');
INSERT INTO sys_role_menu VALUES ('7', '22056');

INSERT INTO sys_role_menu VALUES ('7', '22060');
INSERT INTO sys_role_menu VALUES ('7', '22061');
INSERT INTO sys_role_menu VALUES ('7', '22062');
INSERT INTO sys_role_menu VALUES ('7', '22063');
INSERT INTO sys_role_menu VALUES ('7', '22064');
INSERT INTO sys_role_menu VALUES ('7', '22065');
INSERT INTO sys_role_menu VALUES ('7', '22066');

INSERT INTO sys_role_menu VALUES ('7', '22070');
INSERT INTO sys_role_menu VALUES ('7', '22071');
INSERT INTO sys_role_menu VALUES ('7', '22072');
INSERT INTO sys_role_menu VALUES ('7', '22073');
INSERT INTO sys_role_menu VALUES ('7', '22074');
INSERT INTO sys_role_menu VALUES ('7', '22075');
INSERT INTO sys_role_menu VALUES ('7', '22076');

INSERT INTO sys_role_menu VALUES ('7', '22080');
INSERT INTO sys_role_menu VALUES ('7', '22081');
INSERT INTO sys_role_menu VALUES ('7', '22082');
INSERT INTO sys_role_menu VALUES ('7', '22083');
INSERT INTO sys_role_menu VALUES ('7', '22084');
INSERT INTO sys_role_menu VALUES ('7', '22085');
INSERT INTO sys_role_menu VALUES ('7', '22086');

INSERT INTO sys_role_menu VALUES ('7', '22090');
INSERT INTO sys_role_menu VALUES ('7', '22091');
INSERT INTO sys_role_menu VALUES ('7', '22092');
INSERT INTO sys_role_menu VALUES ('7', '22093');
INSERT INTO sys_role_menu VALUES ('7', '22094');
INSERT INTO sys_role_menu VALUES ('7', '22095');
INSERT INTO sys_role_menu VALUES ('7', '22096');

INSERT INTO sys_role_menu VALUES ('7', '22100');
INSERT INTO sys_role_menu VALUES ('7', '22101');
INSERT INTO sys_role_menu VALUES ('7', '22102');
INSERT INTO sys_role_menu VALUES ('7', '22103');
INSERT INTO sys_role_menu VALUES ('7', '22104');
INSERT INTO sys_role_menu VALUES ('7', '22105');
INSERT INTO sys_role_menu VALUES ('7', '22106');

INSERT INTO sys_role_menu VALUES ('7', '22110');
INSERT INTO sys_role_menu VALUES ('7', '22111');
INSERT INTO sys_role_menu VALUES ('7', '22112');
INSERT INTO sys_role_menu VALUES ('7', '22113');
INSERT INTO sys_role_menu VALUES ('7', '22114');
INSERT INTO sys_role_menu VALUES ('7', '22115');
INSERT INTO sys_role_menu VALUES ('7', '22116');

INSERT INTO sys_role_menu VALUES ('7', '22120');
INSERT INTO sys_role_menu VALUES ('7', '22121');
INSERT INTO sys_role_menu VALUES ('7', '22122');
INSERT INTO sys_role_menu VALUES ('7', '22123');
INSERT INTO sys_role_menu VALUES ('7', '22124');
INSERT INTO sys_role_menu VALUES ('7', '22125');
INSERT INTO sys_role_menu VALUES ('7', '22126');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '22000');

INSERT INTO sys_role_menu VALUES ('8', '22010');
INSERT INTO sys_role_menu VALUES ('8', '22011');
INSERT INTO sys_role_menu VALUES ('8', '22012');
INSERT INTO sys_role_menu VALUES ('8', '22013');
INSERT INTO sys_role_menu VALUES ('8', '22014');
INSERT INTO sys_role_menu VALUES ('8', '22015');
INSERT INTO sys_role_menu VALUES ('8', '22016');

INSERT INTO sys_role_menu VALUES ('8', '22020');
INSERT INTO sys_role_menu VALUES ('8', '22021');
INSERT INTO sys_role_menu VALUES ('8', '22022');
INSERT INTO sys_role_menu VALUES ('8', '22023');
INSERT INTO sys_role_menu VALUES ('8', '22024');
INSERT INTO sys_role_menu VALUES ('8', '22025');
INSERT INTO sys_role_menu VALUES ('8', '22026');

INSERT INTO sys_role_menu VALUES ('8', '22030');
INSERT INTO sys_role_menu VALUES ('8', '22031');
INSERT INTO sys_role_menu VALUES ('8', '22032');
INSERT INTO sys_role_menu VALUES ('8', '22033');
INSERT INTO sys_role_menu VALUES ('8', '22034');
INSERT INTO sys_role_menu VALUES ('8', '22035');
INSERT INTO sys_role_menu VALUES ('8', '22036');

INSERT INTO sys_role_menu VALUES ('8', '22040');
INSERT INTO sys_role_menu VALUES ('8', '22041');
INSERT INTO sys_role_menu VALUES ('8', '22042');
INSERT INTO sys_role_menu VALUES ('8', '22043');
INSERT INTO sys_role_menu VALUES ('8', '22044');
INSERT INTO sys_role_menu VALUES ('8', '22045');
INSERT INTO sys_role_menu VALUES ('8', '22046');

INSERT INTO sys_role_menu VALUES ('8', '22050');
INSERT INTO sys_role_menu VALUES ('8', '22051');
INSERT INTO sys_role_menu VALUES ('8', '22052');
INSERT INTO sys_role_menu VALUES ('8', '22053');
INSERT INTO sys_role_menu VALUES ('8', '22054');
INSERT INTO sys_role_menu VALUES ('8', '22055');
INSERT INTO sys_role_menu VALUES ('8', '22056');

INSERT INTO sys_role_menu VALUES ('8', '22060');
INSERT INTO sys_role_menu VALUES ('8', '22061');
INSERT INTO sys_role_menu VALUES ('8', '22062');
INSERT INTO sys_role_menu VALUES ('8', '22063');
INSERT INTO sys_role_menu VALUES ('8', '22064');
INSERT INTO sys_role_menu VALUES ('8', '22065');
INSERT INTO sys_role_menu VALUES ('8', '22066');

INSERT INTO sys_role_menu VALUES ('8', '22070');
INSERT INTO sys_role_menu VALUES ('8', '22071');
INSERT INTO sys_role_menu VALUES ('8', '22072');
INSERT INTO sys_role_menu VALUES ('8', '22073');
INSERT INTO sys_role_menu VALUES ('8', '22074');
INSERT INTO sys_role_menu VALUES ('8', '22075');
INSERT INTO sys_role_menu VALUES ('8', '22076');

INSERT INTO sys_role_menu VALUES ('8', '22080');
INSERT INTO sys_role_menu VALUES ('8', '22081');
INSERT INTO sys_role_menu VALUES ('8', '22082');
INSERT INTO sys_role_menu VALUES ('8', '22083');
INSERT INTO sys_role_menu VALUES ('8', '22084');
INSERT INTO sys_role_menu VALUES ('8', '22085');
INSERT INTO sys_role_menu VALUES ('8', '22086');

INSERT INTO sys_role_menu VALUES ('8', '22090');
INSERT INTO sys_role_menu VALUES ('8', '22091');
INSERT INTO sys_role_menu VALUES ('8', '22092');
INSERT INTO sys_role_menu VALUES ('8', '22093');
INSERT INTO sys_role_menu VALUES ('8', '22094');
INSERT INTO sys_role_menu VALUES ('8', '22095');
INSERT INTO sys_role_menu VALUES ('8', '22096');

INSERT INTO sys_role_menu VALUES ('8', '22100');
INSERT INTO sys_role_menu VALUES ('8', '22101');
INSERT INTO sys_role_menu VALUES ('8', '22102');
INSERT INTO sys_role_menu VALUES ('8', '22103');
INSERT INTO sys_role_menu VALUES ('8', '22104');
INSERT INTO sys_role_menu VALUES ('8', '22105');
INSERT INTO sys_role_menu VALUES ('8', '22106');

INSERT INTO sys_role_menu VALUES ('8', '22110');
INSERT INTO sys_role_menu VALUES ('8', '22111');
INSERT INTO sys_role_menu VALUES ('8', '22112');
INSERT INTO sys_role_menu VALUES ('8', '22113');
INSERT INTO sys_role_menu VALUES ('8', '22114');
INSERT INTO sys_role_menu VALUES ('8', '22115');
INSERT INTO sys_role_menu VALUES ('8', '22116');

INSERT INTO sys_role_menu VALUES ('8', '22120');
INSERT INTO sys_role_menu VALUES ('8', '22121');
INSERT INTO sys_role_menu VALUES ('8', '22122');
INSERT INTO sys_role_menu VALUES ('8', '22123');
INSERT INTO sys_role_menu VALUES ('8', '22124');
INSERT INTO sys_role_menu VALUES ('8', '22125');
INSERT INTO sys_role_menu VALUES ('8', '22126');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '22000');

INSERT INTO sys_role_menu VALUES ('9', '22010');
INSERT INTO sys_role_menu VALUES ('9', '22011');
INSERT INTO sys_role_menu VALUES ('9', '22012');
INSERT INTO sys_role_menu VALUES ('9', '22013');
INSERT INTO sys_role_menu VALUES ('9', '22014');
INSERT INTO sys_role_menu VALUES ('9', '22015');
INSERT INTO sys_role_menu VALUES ('9', '22016');

INSERT INTO sys_role_menu VALUES ('9', '22020');
INSERT INTO sys_role_menu VALUES ('9', '22021');
INSERT INTO sys_role_menu VALUES ('9', '22022');
INSERT INTO sys_role_menu VALUES ('9', '22023');
INSERT INTO sys_role_menu VALUES ('9', '22024');
INSERT INTO sys_role_menu VALUES ('9', '22025');
INSERT INTO sys_role_menu VALUES ('9', '22026');

INSERT INTO sys_role_menu VALUES ('9', '22030');
INSERT INTO sys_role_menu VALUES ('9', '22031');
INSERT INTO sys_role_menu VALUES ('9', '22032');
INSERT INTO sys_role_menu VALUES ('9', '22033');
INSERT INTO sys_role_menu VALUES ('9', '22034');
INSERT INTO sys_role_menu VALUES ('9', '22035');
INSERT INTO sys_role_menu VALUES ('9', '22036');

INSERT INTO sys_role_menu VALUES ('9', '22040');
INSERT INTO sys_role_menu VALUES ('9', '22041');
INSERT INTO sys_role_menu VALUES ('9', '22042');
INSERT INTO sys_role_menu VALUES ('9', '22043');
INSERT INTO sys_role_menu VALUES ('9', '22044');
INSERT INTO sys_role_menu VALUES ('9', '22045');
INSERT INTO sys_role_menu VALUES ('9', '22046');

INSERT INTO sys_role_menu VALUES ('9', '22050');
INSERT INTO sys_role_menu VALUES ('9', '22051');
INSERT INTO sys_role_menu VALUES ('9', '22052');
INSERT INTO sys_role_menu VALUES ('9', '22053');
INSERT INTO sys_role_menu VALUES ('9', '22054');
INSERT INTO sys_role_menu VALUES ('9', '22055');
INSERT INTO sys_role_menu VALUES ('9', '22056');

INSERT INTO sys_role_menu VALUES ('9', '22060');
INSERT INTO sys_role_menu VALUES ('9', '22061');
INSERT INTO sys_role_menu VALUES ('9', '22062');
INSERT INTO sys_role_menu VALUES ('9', '22063');
INSERT INTO sys_role_menu VALUES ('9', '22064');
INSERT INTO sys_role_menu VALUES ('9', '22065');
INSERT INTO sys_role_menu VALUES ('9', '22066');

INSERT INTO sys_role_menu VALUES ('9', '22070');
INSERT INTO sys_role_menu VALUES ('9', '22071');
INSERT INTO sys_role_menu VALUES ('9', '22072');
INSERT INTO sys_role_menu VALUES ('9', '22073');
INSERT INTO sys_role_menu VALUES ('9', '22074');
INSERT INTO sys_role_menu VALUES ('9', '22075');
INSERT INTO sys_role_menu VALUES ('9', '22076');

INSERT INTO sys_role_menu VALUES ('9', '22080');
INSERT INTO sys_role_menu VALUES ('9', '22081');
INSERT INTO sys_role_menu VALUES ('9', '22082');
INSERT INTO sys_role_menu VALUES ('9', '22083');
INSERT INTO sys_role_menu VALUES ('9', '22084');
INSERT INTO sys_role_menu VALUES ('9', '22085');
INSERT INTO sys_role_menu VALUES ('9', '22086');

INSERT INTO sys_role_menu VALUES ('9', '22090');
INSERT INTO sys_role_menu VALUES ('9', '22091');
INSERT INTO sys_role_menu VALUES ('9', '22092');
INSERT INTO sys_role_menu VALUES ('9', '22093');
INSERT INTO sys_role_menu VALUES ('9', '22094');
INSERT INTO sys_role_menu VALUES ('9', '22095');
INSERT INTO sys_role_menu VALUES ('9', '22096');

INSERT INTO sys_role_menu VALUES ('9', '22100');
INSERT INTO sys_role_menu VALUES ('9', '22101');
INSERT INTO sys_role_menu VALUES ('9', '22102');
INSERT INTO sys_role_menu VALUES ('9', '22103');
INSERT INTO sys_role_menu VALUES ('9', '22104');
INSERT INTO sys_role_menu VALUES ('9', '22105');
INSERT INTO sys_role_menu VALUES ('9', '22106');

INSERT INTO sys_role_menu VALUES ('9', '22110');
INSERT INTO sys_role_menu VALUES ('9', '22111');
INSERT INTO sys_role_menu VALUES ('9', '22112');
INSERT INTO sys_role_menu VALUES ('9', '22113');
INSERT INTO sys_role_menu VALUES ('9', '22114');
INSERT INTO sys_role_menu VALUES ('9', '22115');
INSERT INTO sys_role_menu VALUES ('9', '22116');

INSERT INTO sys_role_menu VALUES ('9', '22120');
INSERT INTO sys_role_menu VALUES ('9', '22121');
INSERT INTO sys_role_menu VALUES ('9', '22122');
INSERT INTO sys_role_menu VALUES ('9', '22123');
INSERT INTO sys_role_menu VALUES ('9', '22124');
INSERT INTO sys_role_menu VALUES ('9', '22125');
INSERT INTO sys_role_menu VALUES ('9', '22126');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '22000');

INSERT INTO sys_role_menu VALUES ('10', '22010');
INSERT INTO sys_role_menu VALUES ('10', '22011');
INSERT INTO sys_role_menu VALUES ('10', '22012');
INSERT INTO sys_role_menu VALUES ('10', '22013');
INSERT INTO sys_role_menu VALUES ('10', '22014');
INSERT INTO sys_role_menu VALUES ('10', '22015');
INSERT INTO sys_role_menu VALUES ('10', '22016');

INSERT INTO sys_role_menu VALUES ('10', '22020');
INSERT INTO sys_role_menu VALUES ('10', '22021');
INSERT INTO sys_role_menu VALUES ('10', '22022');
INSERT INTO sys_role_menu VALUES ('10', '22023');
INSERT INTO sys_role_menu VALUES ('10', '22024');
INSERT INTO sys_role_menu VALUES ('10', '22025');
INSERT INTO sys_role_menu VALUES ('10', '22026');

INSERT INTO sys_role_menu VALUES ('10', '22030');
INSERT INTO sys_role_menu VALUES ('10', '22031');
INSERT INTO sys_role_menu VALUES ('10', '22032');
INSERT INTO sys_role_menu VALUES ('10', '22033');
INSERT INTO sys_role_menu VALUES ('10', '22034');
INSERT INTO sys_role_menu VALUES ('10', '22035');
INSERT INTO sys_role_menu VALUES ('10', '22036');

INSERT INTO sys_role_menu VALUES ('10', '22040');
INSERT INTO sys_role_menu VALUES ('10', '22041');
INSERT INTO sys_role_menu VALUES ('10', '22042');
INSERT INTO sys_role_menu VALUES ('10', '22043');
INSERT INTO sys_role_menu VALUES ('10', '22044');
INSERT INTO sys_role_menu VALUES ('10', '22045');
INSERT INTO sys_role_menu VALUES ('10', '22046');

INSERT INTO sys_role_menu VALUES ('10', '22050');
INSERT INTO sys_role_menu VALUES ('10', '22051');
INSERT INTO sys_role_menu VALUES ('10', '22052');
INSERT INTO sys_role_menu VALUES ('10', '22053');
INSERT INTO sys_role_menu VALUES ('10', '22054');
INSERT INTO sys_role_menu VALUES ('10', '22055');
INSERT INTO sys_role_menu VALUES ('10', '22056');

INSERT INTO sys_role_menu VALUES ('10', '22060');
INSERT INTO sys_role_menu VALUES ('10', '22061');
INSERT INTO sys_role_menu VALUES ('10', '22062');
INSERT INTO sys_role_menu VALUES ('10', '22063');
INSERT INTO sys_role_menu VALUES ('10', '22064');
INSERT INTO sys_role_menu VALUES ('10', '22065');
INSERT INTO sys_role_menu VALUES ('10', '22066');

INSERT INTO sys_role_menu VALUES ('10', '22070');
INSERT INTO sys_role_menu VALUES ('10', '22071');
INSERT INTO sys_role_menu VALUES ('10', '22072');
INSERT INTO sys_role_menu VALUES ('10', '22073');
INSERT INTO sys_role_menu VALUES ('10', '22074');
INSERT INTO sys_role_menu VALUES ('10', '22075');
INSERT INTO sys_role_menu VALUES ('10', '22076');

INSERT INTO sys_role_menu VALUES ('10', '22080');
INSERT INTO sys_role_menu VALUES ('10', '22081');
INSERT INTO sys_role_menu VALUES ('10', '22082');
INSERT INTO sys_role_menu VALUES ('10', '22083');
INSERT INTO sys_role_menu VALUES ('10', '22084');
INSERT INTO sys_role_menu VALUES ('10', '22085');
INSERT INTO sys_role_menu VALUES ('10', '22086');

INSERT INTO sys_role_menu VALUES ('10', '22090');
INSERT INTO sys_role_menu VALUES ('10', '22091');
INSERT INTO sys_role_menu VALUES ('10', '22092');
INSERT INTO sys_role_menu VALUES ('10', '22093');
INSERT INTO sys_role_menu VALUES ('10', '22094');
INSERT INTO sys_role_menu VALUES ('10', '22095');
INSERT INTO sys_role_menu VALUES ('10', '22096');

INSERT INTO sys_role_menu VALUES ('10', '22100');
INSERT INTO sys_role_menu VALUES ('10', '22101');
INSERT INTO sys_role_menu VALUES ('10', '22102');
INSERT INTO sys_role_menu VALUES ('10', '22103');
INSERT INTO sys_role_menu VALUES ('10', '22104');
INSERT INTO sys_role_menu VALUES ('10', '22105');
INSERT INTO sys_role_menu VALUES ('10', '22106');

INSERT INTO sys_role_menu VALUES ('10', '22110');
INSERT INTO sys_role_menu VALUES ('10', '22111');
INSERT INTO sys_role_menu VALUES ('10', '22112');
INSERT INTO sys_role_menu VALUES ('10', '22113');
INSERT INTO sys_role_menu VALUES ('10', '22114');
INSERT INTO sys_role_menu VALUES ('10', '22115');
INSERT INTO sys_role_menu VALUES ('10', '22116');

INSERT INTO sys_role_menu VALUES ('10', '22120');
INSERT INTO sys_role_menu VALUES ('10', '22121');
INSERT INTO sys_role_menu VALUES ('10', '22122');
INSERT INTO sys_role_menu VALUES ('10', '22123');
INSERT INTO sys_role_menu VALUES ('10', '22124');
INSERT INTO sys_role_menu VALUES ('10', '22125');
INSERT INTO sys_role_menu VALUES ('10', '22126');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '22000');

INSERT INTO sys_role_menu VALUES ('11', '22010');
INSERT INTO sys_role_menu VALUES ('11', '22011');
INSERT INTO sys_role_menu VALUES ('11', '22012');
INSERT INTO sys_role_menu VALUES ('11', '22013');
INSERT INTO sys_role_menu VALUES ('11', '22014');
INSERT INTO sys_role_menu VALUES ('11', '22015');
INSERT INTO sys_role_menu VALUES ('11', '22016');

INSERT INTO sys_role_menu VALUES ('11', '22020');
INSERT INTO sys_role_menu VALUES ('11', '22021');
INSERT INTO sys_role_menu VALUES ('11', '22022');
INSERT INTO sys_role_menu VALUES ('11', '22023');
INSERT INTO sys_role_menu VALUES ('11', '22024');
INSERT INTO sys_role_menu VALUES ('11', '22025');
INSERT INTO sys_role_menu VALUES ('11', '22026');

INSERT INTO sys_role_menu VALUES ('11', '22030');
INSERT INTO sys_role_menu VALUES ('11', '22031');
INSERT INTO sys_role_menu VALUES ('11', '22032');
INSERT INTO sys_role_menu VALUES ('11', '22033');
INSERT INTO sys_role_menu VALUES ('11', '22034');
INSERT INTO sys_role_menu VALUES ('11', '22035');
INSERT INTO sys_role_menu VALUES ('11', '22036');

INSERT INTO sys_role_menu VALUES ('11', '22040');
INSERT INTO sys_role_menu VALUES ('11', '22041');
INSERT INTO sys_role_menu VALUES ('11', '22042');
INSERT INTO sys_role_menu VALUES ('11', '22043');
INSERT INTO sys_role_menu VALUES ('11', '22044');
INSERT INTO sys_role_menu VALUES ('11', '22045');
INSERT INTO sys_role_menu VALUES ('11', '22046');

INSERT INTO sys_role_menu VALUES ('11', '22050');
INSERT INTO sys_role_menu VALUES ('11', '22051');
INSERT INTO sys_role_menu VALUES ('11', '22052');
INSERT INTO sys_role_menu VALUES ('11', '22053');
INSERT INTO sys_role_menu VALUES ('11', '22054');
INSERT INTO sys_role_menu VALUES ('11', '22055');
INSERT INTO sys_role_menu VALUES ('11', '22056');

INSERT INTO sys_role_menu VALUES ('11', '22060');
INSERT INTO sys_role_menu VALUES ('11', '22061');
INSERT INTO sys_role_menu VALUES ('11', '22062');
INSERT INTO sys_role_menu VALUES ('11', '22063');
INSERT INTO sys_role_menu VALUES ('11', '22064');
INSERT INTO sys_role_menu VALUES ('11', '22065');
INSERT INTO sys_role_menu VALUES ('11', '22066');

INSERT INTO sys_role_menu VALUES ('11', '22070');
INSERT INTO sys_role_menu VALUES ('11', '22071');
INSERT INTO sys_role_menu VALUES ('11', '22072');
INSERT INTO sys_role_menu VALUES ('11', '22073');
INSERT INTO sys_role_menu VALUES ('11', '22074');
INSERT INTO sys_role_menu VALUES ('11', '22075');
INSERT INTO sys_role_menu VALUES ('11', '22076');

INSERT INTO sys_role_menu VALUES ('11', '22080');
INSERT INTO sys_role_menu VALUES ('11', '22081');
INSERT INTO sys_role_menu VALUES ('11', '22082');
INSERT INTO sys_role_menu VALUES ('11', '22083');
INSERT INTO sys_role_menu VALUES ('11', '22084');
INSERT INTO sys_role_menu VALUES ('11', '22085');
INSERT INTO sys_role_menu VALUES ('11', '22086');

INSERT INTO sys_role_menu VALUES ('11', '22090');
INSERT INTO sys_role_menu VALUES ('11', '22091');
INSERT INTO sys_role_menu VALUES ('11', '22092');
INSERT INTO sys_role_menu VALUES ('11', '22093');
INSERT INTO sys_role_menu VALUES ('11', '22094');
INSERT INTO sys_role_menu VALUES ('11', '22095');
INSERT INTO sys_role_menu VALUES ('11', '22096');

INSERT INTO sys_role_menu VALUES ('11', '22100');
INSERT INTO sys_role_menu VALUES ('11', '22101');
INSERT INTO sys_role_menu VALUES ('11', '22102');
INSERT INTO sys_role_menu VALUES ('11', '22103');
INSERT INTO sys_role_menu VALUES ('11', '22104');
INSERT INTO sys_role_menu VALUES ('11', '22105');
INSERT INTO sys_role_menu VALUES ('11', '22106');

INSERT INTO sys_role_menu VALUES ('11', '22110');
INSERT INTO sys_role_menu VALUES ('11', '22111');
INSERT INTO sys_role_menu VALUES ('11', '22112');
INSERT INTO sys_role_menu VALUES ('11', '22113');
INSERT INTO sys_role_menu VALUES ('11', '22114');
INSERT INTO sys_role_menu VALUES ('11', '22115');
INSERT INTO sys_role_menu VALUES ('11', '22116');

INSERT INTO sys_role_menu VALUES ('11', '22120');
INSERT INTO sys_role_menu VALUES ('11', '22121');
INSERT INTO sys_role_menu VALUES ('11', '22122');
INSERT INTO sys_role_menu VALUES ('11', '22123');
INSERT INTO sys_role_menu VALUES ('11', '22124');
INSERT INTO sys_role_menu VALUES ('11', '22125');
INSERT INTO sys_role_menu VALUES ('11', '22126');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '22000');

INSERT INTO sys_role_menu VALUES ('1', '22010');
INSERT INTO sys_role_menu VALUES ('1', '22011');
INSERT INTO sys_role_menu VALUES ('1', '22012');
INSERT INTO sys_role_menu VALUES ('1', '22013');
INSERT INTO sys_role_menu VALUES ('1', '22014');
INSERT INTO sys_role_menu VALUES ('1', '22015');
INSERT INTO sys_role_menu VALUES ('1', '22016');

INSERT INTO sys_role_menu VALUES ('1', '22020');
INSERT INTO sys_role_menu VALUES ('1', '22021');
INSERT INTO sys_role_menu VALUES ('1', '22022');
INSERT INTO sys_role_menu VALUES ('1', '22023');
INSERT INTO sys_role_menu VALUES ('1', '22024');
INSERT INTO sys_role_menu VALUES ('1', '22025');
INSERT INTO sys_role_menu VALUES ('1', '22026');

INSERT INTO sys_role_menu VALUES ('1', '22030');
INSERT INTO sys_role_menu VALUES ('1', '22031');
INSERT INTO sys_role_menu VALUES ('1', '22032');
INSERT INTO sys_role_menu VALUES ('1', '22033');
INSERT INTO sys_role_menu VALUES ('1', '22034');
INSERT INTO sys_role_menu VALUES ('1', '22035');
INSERT INTO sys_role_menu VALUES ('1', '22036');

INSERT INTO sys_role_menu VALUES ('1', '22040');
INSERT INTO sys_role_menu VALUES ('1', '22041');
INSERT INTO sys_role_menu VALUES ('1', '22042');
INSERT INTO sys_role_menu VALUES ('1', '22043');
INSERT INTO sys_role_menu VALUES ('1', '22044');
INSERT INTO sys_role_menu VALUES ('1', '22045');
INSERT INTO sys_role_menu VALUES ('1', '22046');

INSERT INTO sys_role_menu VALUES ('1', '22050');
INSERT INTO sys_role_menu VALUES ('1', '22051');
INSERT INTO sys_role_menu VALUES ('1', '22052');
INSERT INTO sys_role_menu VALUES ('1', '22053');
INSERT INTO sys_role_menu VALUES ('1', '22054');
INSERT INTO sys_role_menu VALUES ('1', '22055');
INSERT INTO sys_role_menu VALUES ('1', '22056');

INSERT INTO sys_role_menu VALUES ('1', '22060');
INSERT INTO sys_role_menu VALUES ('1', '22061');
INSERT INTO sys_role_menu VALUES ('1', '22062');
INSERT INTO sys_role_menu VALUES ('1', '22063');
INSERT INTO sys_role_menu VALUES ('1', '22064');
INSERT INTO sys_role_menu VALUES ('1', '22065');
INSERT INTO sys_role_menu VALUES ('1', '22066');

INSERT INTO sys_role_menu VALUES ('1', '22070');
INSERT INTO sys_role_menu VALUES ('1', '22071');
INSERT INTO sys_role_menu VALUES ('1', '22072');
INSERT INTO sys_role_menu VALUES ('1', '22073');
INSERT INTO sys_role_menu VALUES ('1', '22074');
INSERT INTO sys_role_menu VALUES ('1', '22075');
INSERT INTO sys_role_menu VALUES ('1', '22076');

INSERT INTO sys_role_menu VALUES ('1', '22080');
INSERT INTO sys_role_menu VALUES ('1', '22081');
INSERT INTO sys_role_menu VALUES ('1', '22082');
INSERT INTO sys_role_menu VALUES ('1', '22083');
INSERT INTO sys_role_menu VALUES ('1', '22084');
INSERT INTO sys_role_menu VALUES ('1', '22085');
INSERT INTO sys_role_menu VALUES ('1', '22086');

INSERT INTO sys_role_menu VALUES ('1', '22090');
INSERT INTO sys_role_menu VALUES ('1', '22091');
INSERT INTO sys_role_menu VALUES ('1', '22092');
INSERT INTO sys_role_menu VALUES ('1', '22093');
INSERT INTO sys_role_menu VALUES ('1', '22094');
INSERT INTO sys_role_menu VALUES ('1', '22095');
INSERT INTO sys_role_menu VALUES ('1', '22096');

INSERT INTO sys_role_menu VALUES ('1', '22100');
INSERT INTO sys_role_menu VALUES ('1', '22101');
INSERT INTO sys_role_menu VALUES ('1', '22102');
INSERT INTO sys_role_menu VALUES ('1', '22103');
INSERT INTO sys_role_menu VALUES ('1', '22104');
INSERT INTO sys_role_menu VALUES ('1', '22105');
INSERT INTO sys_role_menu VALUES ('1', '22106');

INSERT INTO sys_role_menu VALUES ('1', '22110');
INSERT INTO sys_role_menu VALUES ('1', '22111');
INSERT INTO sys_role_menu VALUES ('1', '22112');
INSERT INTO sys_role_menu VALUES ('1', '22113');
INSERT INTO sys_role_menu VALUES ('1', '22114');
INSERT INTO sys_role_menu VALUES ('1', '22115');
INSERT INTO sys_role_menu VALUES ('1', '22116');

INSERT INTO sys_role_menu VALUES ('1', '22120');
INSERT INTO sys_role_menu VALUES ('1', '22121');
INSERT INTO sys_role_menu VALUES ('1', '22122');
INSERT INTO sys_role_menu VALUES ('1', '22123');
INSERT INTO sys_role_menu VALUES ('1', '22124');
INSERT INTO sys_role_menu VALUES ('1', '22125');
INSERT INTO sys_role_menu VALUES ('1', '22126');