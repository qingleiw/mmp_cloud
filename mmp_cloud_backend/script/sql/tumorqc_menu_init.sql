-- ----------------------------
-- 肿瘤质控菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建肿瘤质控主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('24500', '肿瘤质控', '0', '100', 'tumorqc', NULL, '', 1, 0, 'M', '0', '0', '', 'microscope', 100, 1, sysdate(), NULL, NULL, '肿瘤质控目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('24510', '肿瘤质控指标配置', '24500', '10', 'tumorQcIndicatorConfig', 'tumorqc/tumorQcIndicatorConfig/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcIndicatorConfig:list', 'cogs', 100, 1, sysdate(), NULL, NULL, '肿瘤质控指标配置');
INSERT INTO sys_menu VALUES ('24520', '肿瘤质控指标数据', '24500', '20', 'tumorQcIndicatorData', 'tumorqc/tumorQcIndicatorData/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcIndicatorData:list', 'chart-line', 100, 1, sysdate(), NULL, NULL, '肿瘤质控指标数据');
INSERT INTO sys_menu VALUES ('24530', '肿瘤质控指标报告', '24500', '30', 'tumorQcIndicatorReport', 'tumorqc/tumorQcIndicatorReport/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcIndicatorReport:list', 'file-chart-line', 100, 1, sysdate(), NULL, NULL, '肿瘤质控指标报告');
INSERT INTO sys_menu VALUES ('24540', '肿瘤质控计划', '24500', '40', 'tumorQcPlan', 'tumorqc/tumorQcPlan/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcPlan:list', 'clipboard-check', 100, 1, sysdate(), NULL, NULL, '肿瘤质控计划');
INSERT INTO sys_menu VALUES ('24550', '肿瘤质控计划执行', '24500', '50', 'tumorQcPlanExecution', 'tumorqc/tumorQcPlanExecution/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcPlanExecution:list', 'play-circle', 100, 1, sysdate(), NULL, NULL, '肿瘤质控计划执行');
INSERT INTO sys_menu VALUES ('24560', '肿瘤质控规则', '24500', '60', 'tumorQcRule', 'tumorqc/tumorQcRule/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcRule:list', 'gavel', 100, 1, sysdate(), NULL, NULL, '肿瘤质控规则');
INSERT INTO sys_menu VALUES ('24570', '肿瘤质控规则执行', '24500', '70', 'tumorQcRuleExecution', 'tumorqc/tumorQcRuleExecution/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcRuleExecution:list', 'bolt', 100, 1, sysdate(), NULL, NULL, '肿瘤质控规则执行');
INSERT INTO sys_menu VALUES ('24580', '肿瘤质控标准', '24500', '80', 'tumorQcStandard', 'tumorqc/tumorQcStandard/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcStandard:list', 'award', 100, 1, sysdate(), NULL, NULL, '肿瘤质控标准');
INSERT INTO sys_menu VALUES ('24590', '肿瘤质控任务', '24500', '90', 'tumorQcTask', 'tumorqc/tumorQcTask/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcTask:list', 'tasks', 100, 1, sysdate(), NULL, NULL, '肿瘤质控任务');
INSERT INTO sys_menu VALUES ('24600', '肿瘤质控任务执行', '24500', '100', 'tumorQcTaskExecution', 'tumorqc/tumorQcTaskExecution/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcTaskExecution:list', 'running', 100, 1, sysdate(), NULL, NULL, '肿瘤质控任务执行');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 肿瘤质控指标配置按钮
INSERT INTO sys_menu VALUES ('24511', '肿瘤质控指标配置查询', '24510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24512', '肿瘤质控指标配置新增', '24510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24513', '肿瘤质控指标配置修改', '24510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24514', '肿瘤质控指标配置删除', '24510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24515', '肿瘤质控指标配置导入', '24510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24516', '肿瘤质控指标配置导出', '24510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控指标数据按钮
INSERT INTO sys_menu VALUES ('24521', '肿瘤质控指标数据查询', '24520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorData:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24522', '肿瘤质控指标数据新增', '24520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorData:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24523', '肿瘤质控指标数据修改', '24520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorData:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24524', '肿瘤质控指标数据删除', '24520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorData:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24525', '肿瘤质控指标数据导入', '24520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorData:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24526', '肿瘤质控指标数据导出', '24520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorData:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控指标报告按钮
INSERT INTO sys_menu VALUES ('24531', '肿瘤质控指标报告查询', '24530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorReport:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24532', '肿瘤质控指标报告新增', '24530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorReport:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24533', '肿瘤质控指标报告修改', '24530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorReport:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24534', '肿瘤质控指标报告删除', '24530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorReport:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24535', '肿瘤质控指标报告导入', '24530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorReport:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24536', '肿瘤质控指标报告导出', '24530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorReport:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控计划按钮
INSERT INTO sys_menu VALUES ('24541', '肿瘤质控计划查询', '24540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24542', '肿瘤质控计划新增', '24540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24543', '肿瘤质控计划修改', '24540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24544', '肿瘤质控计划删除', '24540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24545', '肿瘤质控计划导入', '24540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24546', '肿瘤质控计划导出', '24540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控计划执行按钮
INSERT INTO sys_menu VALUES ('24551', '肿瘤质控计划执行查询', '24550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlanExecution:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24552', '肿瘤质控计划执行新增', '24550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlanExecution:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24553', '肿瘤质控计划执行修改', '24550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlanExecution:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24554', '肿瘤质控计划执行删除', '24550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlanExecution:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24555', '肿瘤质控计划执行导入', '24550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlanExecution:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24556', '肿瘤质控计划执行导出', '24550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlanExecution:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控规则按钮
INSERT INTO sys_menu VALUES ('24561', '肿瘤质控规则查询', '24560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRule:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24562', '肿瘤质控规则新增', '24560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRule:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24563', '肿瘤质控规则修改', '24560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRule:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24564', '肿瘤质控规则删除', '24560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRule:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24565', '肿瘤质控规则导入', '24560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRule:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24566', '肿瘤质控规则导出', '24560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRule:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控规则执行按钮
INSERT INTO sys_menu VALUES ('24571', '肿瘤质控规则执行查询', '24570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRuleExecution:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24572', '肿瘤质控规则执行新增', '24570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRuleExecution:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24573', '肿瘤质控规则执行修改', '24570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRuleExecution:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24574', '肿瘤质控规则执行删除', '24570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRuleExecution:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24575', '肿瘤质控规则执行导入', '24570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRuleExecution:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24576', '肿瘤质控规则执行导出', '24570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRuleExecution:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控标准按钮
INSERT INTO sys_menu VALUES ('24581', '肿瘤质控标准查询', '24580', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcStandard:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24582', '肿瘤质控标准新增', '24580', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcStandard:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24583', '肿瘤质控标准修改', '24580', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcStandard:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24584', '肿瘤质控标准删除', '24580', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcStandard:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24585', '肿瘤质控标准导入', '24580', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcStandard:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24586', '肿瘤质控标准导出', '24580', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcStandard:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控任务按钮
INSERT INTO sys_menu VALUES ('24591', '肿瘤质控任务查询', '24590', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTask:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24592', '肿瘤质控任务新增', '24590', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTask:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24593', '肿瘤质控任务修改', '24590', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTask:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24594', '肿瘤质控任务删除', '24590', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTask:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24595', '肿瘤质控任务导入', '24590', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTask:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24596', '肿瘤质控任务导出', '24590', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTask:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控任务执行按钮
INSERT INTO sys_menu VALUES ('24601', '肿瘤质控任务执行查询', '24600', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTaskExecution:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24602', '肿瘤质控任务执行新增', '24600', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTaskExecution:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24603', '肿瘤质控任务执行修改', '24600', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTaskExecution:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24604', '肿瘤质控任务执行删除', '24600', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTaskExecution:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24605', '肿瘤质控任务执行导入', '24600', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTaskExecution:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24606', '肿瘤质控任务执行导出', '24600', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcTaskExecution:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '24500');

INSERT INTO sys_role_menu VALUES ('5', '24510');
INSERT INTO sys_role_menu VALUES ('5', '24511');
INSERT INTO sys_role_menu VALUES ('5', '24512');
INSERT INTO sys_role_menu VALUES ('5', '24513');
INSERT INTO sys_role_menu VALUES ('5', '24514');
INSERT INTO sys_role_menu VALUES ('5', '24515');
INSERT INTO sys_role_menu VALUES ('5', '24516');

INSERT INTO sys_role_menu VALUES ('5', '24520');
INSERT INTO sys_role_menu VALUES ('5', '24521');
INSERT INTO sys_role_menu VALUES ('5', '24522');
INSERT INTO sys_role_menu VALUES ('5', '24523');
INSERT INTO sys_role_menu VALUES ('5', '24524');
INSERT INTO sys_role_menu VALUES ('5', '24525');
INSERT INTO sys_role_menu VALUES ('5', '24526');

INSERT INTO sys_role_menu VALUES ('5', '24530');
INSERT INTO sys_role_menu VALUES ('5', '24531');
INSERT INTO sys_role_menu VALUES ('5', '24532');
INSERT INTO sys_role_menu VALUES ('5', '24533');
INSERT INTO sys_role_menu VALUES ('5', '24534');
INSERT INTO sys_role_menu VALUES ('5', '24535');
INSERT INTO sys_role_menu VALUES ('5', '24536');

INSERT INTO sys_role_menu VALUES ('5', '24540');
INSERT INTO sys_role_menu VALUES ('5', '24541');
INSERT INTO sys_role_menu VALUES ('5', '24542');
INSERT INTO sys_role_menu VALUES ('5', '24543');
INSERT INTO sys_role_menu VALUES ('5', '24544');
INSERT INTO sys_role_menu VALUES ('5', '24545');
INSERT INTO sys_role_menu VALUES ('5', '24546');

INSERT INTO sys_role_menu VALUES ('5', '24550');
INSERT INTO sys_role_menu VALUES ('5', '24551');
INSERT INTO sys_role_menu VALUES ('5', '24552');
INSERT INTO sys_role_menu VALUES ('5', '24553');
INSERT INTO sys_role_menu VALUES ('5', '24554');
INSERT INTO sys_role_menu VALUES ('5', '24555');
INSERT INTO sys_role_menu VALUES ('5', '24556');

INSERT INTO sys_role_menu VALUES ('5', '24560');
INSERT INTO sys_role_menu VALUES ('5', '24561');
INSERT INTO sys_role_menu VALUES ('5', '24562');
INSERT INTO sys_role_menu VALUES ('5', '24563');
INSERT INTO sys_role_menu VALUES ('5', '24564');
INSERT INTO sys_role_menu VALUES ('5', '24565');
INSERT INTO sys_role_menu VALUES ('5', '24566');

INSERT INTO sys_role_menu VALUES ('5', '24570');
INSERT INTO sys_role_menu VALUES ('5', '24571');
INSERT INTO sys_role_menu VALUES ('5', '24572');
INSERT INTO sys_role_menu VALUES ('5', '24573');
INSERT INTO sys_role_menu VALUES ('5', '24574');
INSERT INTO sys_role_menu VALUES ('5', '24575');
INSERT INTO sys_role_menu VALUES ('5', '24576');

INSERT INTO sys_role_menu VALUES ('5', '24580');
INSERT INTO sys_role_menu VALUES ('5', '24581');
INSERT INTO sys_role_menu VALUES ('5', '24582');
INSERT INTO sys_role_menu VALUES ('5', '24583');
INSERT INTO sys_role_menu VALUES ('5', '24584');
INSERT INTO sys_role_menu VALUES ('5', '24585');
INSERT INTO sys_role_menu VALUES ('5', '24586');

INSERT INTO sys_role_menu VALUES ('5', '24590');
INSERT INTO sys_role_menu VALUES ('5', '24591');
INSERT INTO sys_role_menu VALUES ('5', '24592');
INSERT INTO sys_role_menu VALUES ('5', '24593');
INSERT INTO sys_role_menu VALUES ('5', '24594');
INSERT INTO sys_role_menu VALUES ('5', '24595');
INSERT INTO sys_role_menu VALUES ('5', '24596');

INSERT INTO sys_role_menu VALUES ('5', '24600');
INSERT INTO sys_role_menu VALUES ('5', '24601');
INSERT INTO sys_role_menu VALUES ('5', '24602');
INSERT INTO sys_role_menu VALUES ('5', '24603');
INSERT INTO sys_role_menu VALUES ('5', '24604');
INSERT INTO sys_role_menu VALUES ('5', '24605');
INSERT INTO sys_role_menu VALUES ('5', '24606');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '24500');

INSERT INTO sys_role_menu VALUES ('6', '24510');
INSERT INTO sys_role_menu VALUES ('6', '24511');
INSERT INTO sys_role_menu VALUES ('6', '24512');
INSERT INTO sys_role_menu VALUES ('6', '24513');
INSERT INTO sys_role_menu VALUES ('6', '24514');
INSERT INTO sys_role_menu VALUES ('6', '24515');
INSERT INTO sys_role_menu VALUES ('6', '24516');

INSERT INTO sys_role_menu VALUES ('6', '24520');
INSERT INTO sys_role_menu VALUES ('6', '24521');
INSERT INTO sys_role_menu VALUES ('6', '24522');
INSERT INTO sys_role_menu VALUES ('6', '24523');
INSERT INTO sys_role_menu VALUES ('6', '24524');
INSERT INTO sys_role_menu VALUES ('6', '24525');
INSERT INTO sys_role_menu VALUES ('6', '24526');

INSERT INTO sys_role_menu VALUES ('6', '24530');
INSERT INTO sys_role_menu VALUES ('6', '24531');
INSERT INTO sys_role_menu VALUES ('6', '24532');
INSERT INTO sys_role_menu VALUES ('6', '24533');
INSERT INTO sys_role_menu VALUES ('6', '24534');
INSERT INTO sys_role_menu VALUES ('6', '24535');
INSERT INTO sys_role_menu VALUES ('6', '24536');

INSERT INTO sys_role_menu VALUES ('6', '24540');
INSERT INTO sys_role_menu VALUES ('6', '24541');
INSERT INTO sys_role_menu VALUES ('6', '24542');
INSERT INTO sys_role_menu VALUES ('6', '24543');
INSERT INTO sys_role_menu VALUES ('6', '24544');
INSERT INTO sys_role_menu VALUES ('6', '24545');
INSERT INTO sys_role_menu VALUES ('6', '24546');

INSERT INTO sys_role_menu VALUES ('6', '24550');
INSERT INTO sys_role_menu VALUES ('6', '24551');
INSERT INTO sys_role_menu VALUES ('6', '24552');
INSERT INTO sys_role_menu VALUES ('6', '24553');
INSERT INTO sys_role_menu VALUES ('6', '24554');
INSERT INTO sys_role_menu VALUES ('6', '24555');
INSERT INTO sys_role_menu VALUES ('6', '24556');

INSERT INTO sys_role_menu VALUES ('6', '24560');
INSERT INTO sys_role_menu VALUES ('6', '24561');
INSERT INTO sys_role_menu VALUES ('6', '24562');
INSERT INTO sys_role_menu VALUES ('6', '24563');
INSERT INTO sys_role_menu VALUES ('6', '24564');
INSERT INTO sys_role_menu VALUES ('6', '24565');
INSERT INTO sys_role_menu VALUES ('6', '24566');

INSERT INTO sys_role_menu VALUES ('6', '24570');
INSERT INTO sys_role_menu VALUES ('6', '24571');
INSERT INTO sys_role_menu VALUES ('6', '24572');
INSERT INTO sys_role_menu VALUES ('6', '24573');
INSERT INTO sys_role_menu VALUES ('6', '24574');
INSERT INTO sys_role_menu VALUES ('6', '24575');
INSERT INTO sys_role_menu VALUES ('6', '24576');

INSERT INTO sys_role_menu VALUES ('6', '24580');
INSERT INTO sys_role_menu VALUES ('6', '24581');
INSERT INTO sys_role_menu VALUES ('6', '24582');
INSERT INTO sys_role_menu VALUES ('6', '24583');
INSERT INTO sys_role_menu VALUES ('6', '24584');
INSERT INTO sys_role_menu VALUES ('6', '24585');
INSERT INTO sys_role_menu VALUES ('6', '24586');

INSERT INTO sys_role_menu VALUES ('6', '24590');
INSERT INTO sys_role_menu VALUES ('6', '24591');
INSERT INTO sys_role_menu VALUES ('6', '24592');
INSERT INTO sys_role_menu VALUES ('6', '24593');
INSERT INTO sys_role_menu VALUES ('6', '24594');
INSERT INTO sys_role_menu VALUES ('6', '24595');
INSERT INTO sys_role_menu VALUES ('6', '24596');

INSERT INTO sys_role_menu VALUES ('6', '24600');
INSERT INTO sys_role_menu VALUES ('6', '24601');
INSERT INTO sys_role_menu VALUES ('6', '24602');
INSERT INTO sys_role_menu VALUES ('6', '24603');
INSERT INTO sys_role_menu VALUES ('6', '24604');
INSERT INTO sys_role_menu VALUES ('6', '24605');
INSERT INTO sys_role_menu VALUES ('6', '24606');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '24500');

INSERT INTO sys_role_menu VALUES ('7', '24510');
INSERT INTO sys_role_menu VALUES ('7', '24511');
INSERT INTO sys_role_menu VALUES ('7', '24512');
INSERT INTO sys_role_menu VALUES ('7', '24513');
INSERT INTO sys_role_menu VALUES ('7', '24514');
INSERT INTO sys_role_menu VALUES ('7', '24515');
INSERT INTO sys_role_menu VALUES ('7', '24516');

INSERT INTO sys_role_menu VALUES ('7', '24520');
INSERT INTO sys_role_menu VALUES ('7', '24521');
INSERT INTO sys_role_menu VALUES ('7', '24522');
INSERT INTO sys_role_menu VALUES ('7', '24523');
INSERT INTO sys_role_menu VALUES ('7', '24524');
INSERT INTO sys_role_menu VALUES ('7', '24525');
INSERT INTO sys_role_menu VALUES ('7', '24526');

INSERT INTO sys_role_menu VALUES ('7', '24530');
INSERT INTO sys_role_menu VALUES ('7', '24531');
INSERT INTO sys_role_menu VALUES ('7', '24532');
INSERT INTO sys_role_menu VALUES ('7', '24533');
INSERT INTO sys_role_menu VALUES ('7', '24534');
INSERT INTO sys_role_menu VALUES ('7', '24535');
INSERT INTO sys_role_menu VALUES ('7', '24536');

INSERT INTO sys_role_menu VALUES ('7', '24540');
INSERT INTO sys_role_menu VALUES ('7', '24541');
INSERT INTO sys_role_menu VALUES ('7', '24542');
INSERT INTO sys_role_menu VALUES ('7', '24543');
INSERT INTO sys_role_menu VALUES ('7', '24544');
INSERT INTO sys_role_menu VALUES ('7', '24545');
INSERT INTO sys_role_menu VALUES ('7', '24546');

INSERT INTO sys_role_menu VALUES ('7', '24550');
INSERT INTO sys_role_menu VALUES ('7', '24551');
INSERT INTO sys_role_menu VALUES ('7', '24552');
INSERT INTO sys_role_menu VALUES ('7', '24553');
INSERT INTO sys_role_menu VALUES ('7', '24554');
INSERT INTO sys_role_menu VALUES ('7', '24555');
INSERT INTO sys_role_menu VALUES ('7', '24556');

INSERT INTO sys_role_menu VALUES ('7', '24560');
INSERT INTO sys_role_menu VALUES ('7', '24561');
INSERT INTO sys_role_menu VALUES ('7', '24562');
INSERT INTO sys_role_menu VALUES ('7', '24563');
INSERT INTO sys_role_menu VALUES ('7', '24564');
INSERT INTO sys_role_menu VALUES ('7', '24565');
INSERT INTO sys_role_menu VALUES ('7', '24566');

INSERT INTO sys_role_menu VALUES ('7', '24570');
INSERT INTO sys_role_menu VALUES ('7', '24571');
INSERT INTO sys_role_menu VALUES ('7', '24572');
INSERT INTO sys_role_menu VALUES ('7', '24573');
INSERT INTO sys_role_menu VALUES ('7', '24574');
INSERT INTO sys_role_menu VALUES ('7', '24575');
INSERT INTO sys_role_menu VALUES ('7', '24576');

INSERT INTO sys_role_menu VALUES ('7', '24580');
INSERT INTO sys_role_menu VALUES ('7', '24581');
INSERT INTO sys_role_menu VALUES ('7', '24582');
INSERT INTO sys_role_menu VALUES ('7', '24583');
INSERT INTO sys_role_menu VALUES ('7', '24584');
INSERT INTO sys_role_menu VALUES ('7', '24585');
INSERT INTO sys_role_menu VALUES ('7', '24586');

INSERT INTO sys_role_menu VALUES ('7', '24590');
INSERT INTO sys_role_menu VALUES ('7', '24591');
INSERT INTO sys_role_menu VALUES ('7', '24592');
INSERT INTO sys_role_menu VALUES ('7', '24593');
INSERT INTO sys_role_menu VALUES ('7', '24594');
INSERT INTO sys_role_menu VALUES ('7', '24595');
INSERT INTO sys_role_menu VALUES ('7', '24596');

INSERT INTO sys_role_menu VALUES ('7', '24600');
INSERT INTO sys_role_menu VALUES ('7', '24601');
INSERT INTO sys_role_menu VALUES ('7', '24602');
INSERT INTO sys_role_menu VALUES ('7', '24603');
INSERT INTO sys_role_menu VALUES ('7', '24604');
INSERT INTO sys_role_menu VALUES ('7', '24605');
INSERT INTO sys_role_menu VALUES ('7', '24606');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '24500');

INSERT INTO sys_role_menu VALUES ('8', '24510');
INSERT INTO sys_role_menu VALUES ('8', '24511');
INSERT INTO sys_role_menu VALUES ('8', '24512');
INSERT INTO sys_role_menu VALUES ('8', '24513');
INSERT INTO sys_role_menu VALUES ('8', '24514');
INSERT INTO sys_role_menu VALUES ('8', '24515');
INSERT INTO sys_role_menu VALUES ('8', '24516');

INSERT INTO sys_role_menu VALUES ('8', '24520');
INSERT INTO sys_role_menu VALUES ('8', '24521');
INSERT INTO sys_role_menu VALUES ('8', '24522');
INSERT INTO sys_role_menu VALUES ('8', '24523');
INSERT INTO sys_role_menu VALUES ('8', '24524');
INSERT INTO sys_role_menu VALUES ('8', '24525');
INSERT INTO sys_role_menu VALUES ('8', '24526');

INSERT INTO sys_role_menu VALUES ('8', '24530');
INSERT INTO sys_role_menu VALUES ('8', '24531');
INSERT INTO sys_role_menu VALUES ('8', '24532');
INSERT INTO sys_role_menu VALUES ('8', '24533');
INSERT INTO sys_role_menu VALUES ('8', '24534');
INSERT INTO sys_role_menu VALUES ('8', '24535');
INSERT INTO sys_role_menu VALUES ('8', '24536');

INSERT INTO sys_role_menu VALUES ('8', '24540');
INSERT INTO sys_role_menu VALUES ('8', '24541');
INSERT INTO sys_role_menu VALUES ('8', '24542');
INSERT INTO sys_role_menu VALUES ('8', '24543');
INSERT INTO sys_role_menu VALUES ('8', '24544');
INSERT INTO sys_role_menu VALUES ('8', '24545');
INSERT INTO sys_role_menu VALUES ('8', '24546');

INSERT INTO sys_role_menu VALUES ('8', '24550');
INSERT INTO sys_role_menu VALUES ('8', '24551');
INSERT INTO sys_role_menu VALUES ('8', '24552');
INSERT INTO sys_role_menu VALUES ('8', '24553');
INSERT INTO sys_role_menu VALUES ('8', '24554');
INSERT INTO sys_role_menu VALUES ('8', '24555');
INSERT INTO sys_role_menu VALUES ('8', '24556');

INSERT INTO sys_role_menu VALUES ('8', '24560');
INSERT INTO sys_role_menu VALUES ('8', '24561');
INSERT INTO sys_role_menu VALUES ('8', '24562');
INSERT INTO sys_role_menu VALUES ('8', '24563');
INSERT INTO sys_role_menu VALUES ('8', '24564');
INSERT INTO sys_role_menu VALUES ('8', '24565');
INSERT INTO sys_role_menu VALUES ('8', '24566');

INSERT INTO sys_role_menu VALUES ('8', '24570');
INSERT INTO sys_role_menu VALUES ('8', '24571');
INSERT INTO sys_role_menu VALUES ('8', '24572');
INSERT INTO sys_role_menu VALUES ('8', '24573');
INSERT INTO sys_role_menu VALUES ('8', '24574');
INSERT INTO sys_role_menu VALUES ('8', '24575');
INSERT INTO sys_role_menu VALUES ('8', '24576');

INSERT INTO sys_role_menu VALUES ('8', '24580');
INSERT INTO sys_role_menu VALUES ('8', '24581');
INSERT INTO sys_role_menu VALUES ('8', '24582');
INSERT INTO sys_role_menu VALUES ('8', '24583');
INSERT INTO sys_role_menu VALUES ('8', '24584');
INSERT INTO sys_role_menu VALUES ('8', '24585');
INSERT INTO sys_role_menu VALUES ('8', '24586');

INSERT INTO sys_role_menu VALUES ('8', '24590');
INSERT INTO sys_role_menu VALUES ('8', '24591');
INSERT INTO sys_role_menu VALUES ('8', '24592');
INSERT INTO sys_role_menu VALUES ('8', '24593');
INSERT INTO sys_role_menu VALUES ('8', '24594');
INSERT INTO sys_role_menu VALUES ('8', '24595');
INSERT INTO sys_role_menu VALUES ('8', '24596');

INSERT INTO sys_role_menu VALUES ('8', '24600');
INSERT INTO sys_role_menu VALUES ('8', '24601');
INSERT INTO sys_role_menu VALUES ('8', '24602');
INSERT INTO sys_role_menu VALUES ('8', '24603');
INSERT INTO sys_role_menu VALUES ('8', '24604');
INSERT INTO sys_role_menu VALUES ('8', '24605');
INSERT INTO sys_role_menu VALUES ('8', '24606');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '24500');

INSERT INTO sys_role_menu VALUES ('9', '24510');
INSERT INTO sys_role_menu VALUES ('9', '24511');
INSERT INTO sys_role_menu VALUES ('9', '24512');
INSERT INTO sys_role_menu VALUES ('9', '24513');
INSERT INTO sys_role_menu VALUES ('9', '24514');
INSERT INTO sys_role_menu VALUES ('9', '24515');
INSERT INTO sys_role_menu VALUES ('9', '24516');

INSERT INTO sys_role_menu VALUES ('9', '24520');
INSERT INTO sys_role_menu VALUES ('9', '24521');
INSERT INTO sys_role_menu VALUES ('9', '24522');
INSERT INTO sys_role_menu VALUES ('9', '24523');
INSERT INTO sys_role_menu VALUES ('9', '24524');
INSERT INTO sys_role_menu VALUES ('9', '24525');
INSERT INTO sys_role_menu VALUES ('9', '24526');

INSERT INTO sys_role_menu VALUES ('9', '24530');
INSERT INTO sys_role_menu VALUES ('9', '24531');
INSERT INTO sys_role_menu VALUES ('9', '24532');
INSERT INTO sys_role_menu VALUES ('9', '24533');
INSERT INTO sys_role_menu VALUES ('9', '24534');
INSERT INTO sys_role_menu VALUES ('9', '24535');
INSERT INTO sys_role_menu VALUES ('9', '24536');

INSERT INTO sys_role_menu VALUES ('9', '24540');
INSERT INTO sys_role_menu VALUES ('9', '24541');
INSERT INTO sys_role_menu VALUES ('9', '24542');
INSERT INTO sys_role_menu VALUES ('9', '24543');
INSERT INTO sys_role_menu VALUES ('9', '24544');
INSERT INTO sys_role_menu VALUES ('9', '24545');
INSERT INTO sys_role_menu VALUES ('9', '24546');

INSERT INTO sys_role_menu VALUES ('9', '24550');
INSERT INTO sys_role_menu VALUES ('9', '24551');
INSERT INTO sys_role_menu VALUES ('9', '24552');
INSERT INTO sys_role_menu VALUES ('9', '24553');
INSERT INTO sys_role_menu VALUES ('9', '24554');
INSERT INTO sys_role_menu VALUES ('9', '24555');
INSERT INTO sys_role_menu VALUES ('9', '24556');

INSERT INTO sys_role_menu VALUES ('9', '24560');
INSERT INTO sys_role_menu VALUES ('9', '24561');
INSERT INTO sys_role_menu VALUES ('9', '24562');
INSERT INTO sys_role_menu VALUES ('9', '24563');
INSERT INTO sys_role_menu VALUES ('9', '24564');
INSERT INTO sys_role_menu VALUES ('9', '24565');
INSERT INTO sys_role_menu VALUES ('9', '24566');

INSERT INTO sys_role_menu VALUES ('9', '24570');
INSERT INTO sys_role_menu VALUES ('9', '24571');
INSERT INTO sys_role_menu VALUES ('9', '24572');
INSERT INTO sys_role_menu VALUES ('9', '24573');
INSERT INTO sys_role_menu VALUES ('9', '24574');
INSERT INTO sys_role_menu VALUES ('9', '24575');
INSERT INTO sys_role_menu VALUES ('9', '24576');

INSERT INTO sys_role_menu VALUES ('9', '24580');
INSERT INTO sys_role_menu VALUES ('9', '24581');
INSERT INTO sys_role_menu VALUES ('9', '24582');
INSERT INTO sys_role_menu VALUES ('9', '24583');
INSERT INTO sys_role_menu VALUES ('9', '24584');
INSERT INTO sys_role_menu VALUES ('9', '24585');
INSERT INTO sys_role_menu VALUES ('9', '24586');

INSERT INTO sys_role_menu VALUES ('9', '24590');
INSERT INTO sys_role_menu VALUES ('9', '24591');
INSERT INTO sys_role_menu VALUES ('9', '24592');
INSERT INTO sys_role_menu VALUES ('9', '24593');
INSERT INTO sys_role_menu VALUES ('9', '24594');
INSERT INTO sys_role_menu VALUES ('9', '24595');
INSERT INTO sys_role_menu VALUES ('9', '24596');

INSERT INTO sys_role_menu VALUES ('9', '24600');
INSERT INTO sys_role_menu VALUES ('9', '24601');
INSERT INTO sys_role_menu VALUES ('9', '24602');
INSERT INTO sys_role_menu VALUES ('9', '24603');
INSERT INTO sys_role_menu VALUES ('9', '24604');
INSERT INTO sys_role_menu VALUES ('9', '24605');
INSERT INTO sys_role_menu VALUES ('9', '24606');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '24500');

INSERT INTO sys_role_menu VALUES ('10', '24510');
INSERT INTO sys_role_menu VALUES ('10', '24511');
INSERT INTO sys_role_menu VALUES ('10', '24512');
INSERT INTO sys_role_menu VALUES ('10', '24513');
INSERT INTO sys_role_menu VALUES ('10', '24514');
INSERT INTO sys_role_menu VALUES ('10', '24515');
INSERT INTO sys_role_menu VALUES ('10', '24516');

INSERT INTO sys_role_menu VALUES ('10', '24520');
INSERT INTO sys_role_menu VALUES ('10', '24521');
INSERT INTO sys_role_menu VALUES ('10', '24522');
INSERT INTO sys_role_menu VALUES ('10', '24523');
INSERT INTO sys_role_menu VALUES ('10', '24524');
INSERT INTO sys_role_menu VALUES ('10', '24525');
INSERT INTO sys_role_menu VALUES ('10', '24526');

INSERT INTO sys_role_menu VALUES ('10', '24530');
INSERT INTO sys_role_menu VALUES ('10', '24531');
INSERT INTO sys_role_menu VALUES ('10', '24532');
INSERT INTO sys_role_menu VALUES ('10', '24533');
INSERT INTO sys_role_menu VALUES ('10', '24534');
INSERT INTO sys_role_menu VALUES ('10', '24535');
INSERT INTO sys_role_menu VALUES ('10', '24536');

INSERT INTO sys_role_menu VALUES ('10', '24540');
INSERT INTO sys_role_menu VALUES ('10', '24541');
INSERT INTO sys_role_menu VALUES ('10', '24542');
INSERT INTO sys_role_menu VALUES ('10', '24543');
INSERT INTO sys_role_menu VALUES ('10', '24544');
INSERT INTO sys_role_menu VALUES ('10', '24545');
INSERT INTO sys_role_menu VALUES ('10', '24546');

INSERT INTO sys_role_menu VALUES ('10', '24550');
INSERT INTO sys_role_menu VALUES ('10', '24551');
INSERT INTO sys_role_menu VALUES ('10', '24552');
INSERT INTO sys_role_menu VALUES ('10', '24553');
INSERT INTO sys_role_menu VALUES ('10', '24554');
INSERT INTO sys_role_menu VALUES ('10', '24555');
INSERT INTO sys_role_menu VALUES ('10', '24556');

INSERT INTO sys_role_menu VALUES ('10', '24560');
INSERT INTO sys_role_menu VALUES ('10', '24561');
INSERT INTO sys_role_menu VALUES ('10', '24562');
INSERT INTO sys_role_menu VALUES ('10', '24563');
INSERT INTO sys_role_menu VALUES ('10', '24564');
INSERT INTO sys_role_menu VALUES ('10', '24565');
INSERT INTO sys_role_menu VALUES ('10', '24566');

INSERT INTO sys_role_menu VALUES ('10', '24570');
INSERT INTO sys_role_menu VALUES ('10', '24571');
INSERT INTO sys_role_menu VALUES ('10', '24572');
INSERT INTO sys_role_menu VALUES ('10', '24573');
INSERT INTO sys_role_menu VALUES ('10', '24574');
INSERT INTO sys_role_menu VALUES ('10', '24575');
INSERT INTO sys_role_menu VALUES ('10', '24576');

INSERT INTO sys_role_menu VALUES ('10', '24580');
INSERT INTO sys_role_menu VALUES ('10', '24581');
INSERT INTO sys_role_menu VALUES ('10', '24582');
INSERT INTO sys_role_menu VALUES ('10', '24583');
INSERT INTO sys_role_menu VALUES ('10', '24584');
INSERT INTO sys_role_menu VALUES ('10', '24585');
INSERT INTO sys_role_menu VALUES ('10', '24586');

INSERT INTO sys_role_menu VALUES ('10', '24590');
INSERT INTO sys_role_menu VALUES ('10', '24591');
INSERT INTO sys_role_menu VALUES ('10', '24592');
INSERT INTO sys_role_menu VALUES ('10', '24593');
INSERT INTO sys_role_menu VALUES ('10', '24594');
INSERT INTO sys_role_menu VALUES ('10', '24595');
INSERT INTO sys_role_menu VALUES ('10', '24596');

INSERT INTO sys_role_menu VALUES ('10', '24600');
INSERT INTO sys_role_menu VALUES ('10', '24601');
INSERT INTO sys_role_menu VALUES ('10', '24602');
INSERT INTO sys_role_menu VALUES ('10', '24603');
INSERT INTO sys_role_menu VALUES ('10', '24604');
INSERT INTO sys_role_menu VALUES ('10', '24605');
INSERT INTO sys_role_menu VALUES ('10', '24606');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '24500');

INSERT INTO sys_role_menu VALUES ('11', '24510');
INSERT INTO sys_role_menu VALUES ('11', '24511');
INSERT INTO sys_role_menu VALUES ('11', '24512');
INSERT INTO sys_role_menu VALUES ('11', '24513');
INSERT INTO sys_role_menu VALUES ('11', '24514');
INSERT INTO sys_role_menu VALUES ('11', '24515');
INSERT INTO sys_role_menu VALUES ('11', '24516');

INSERT INTO sys_role_menu VALUES ('11', '24520');
INSERT INTO sys_role_menu VALUES ('11', '24521');
INSERT INTO sys_role_menu VALUES ('11', '24522');
INSERT INTO sys_role_menu VALUES ('11', '24523');
INSERT INTO sys_role_menu VALUES ('11', '24524');
INSERT INTO sys_role_menu VALUES ('11', '24525');
INSERT INTO sys_role_menu VALUES ('11', '24526');

INSERT INTO sys_role_menu VALUES ('11', '24530');
INSERT INTO sys_role_menu VALUES ('11', '24531');
INSERT INTO sys_role_menu VALUES ('11', '24532');
INSERT INTO sys_role_menu VALUES ('11', '24533');
INSERT INTO sys_role_menu VALUES ('11', '24534');
INSERT INTO sys_role_menu VALUES ('11', '24535');
INSERT INTO sys_role_menu VALUES ('11', '24536');

INSERT INTO sys_role_menu VALUES ('11', '24540');
INSERT INTO sys_role_menu VALUES ('11', '24541');
INSERT INTO sys_role_menu VALUES ('11', '24542');
INSERT INTO sys_role_menu VALUES ('11', '24543');
INSERT INTO sys_role_menu VALUES ('11', '24544');
INSERT INTO sys_role_menu VALUES ('11', '24545');
INSERT INTO sys_role_menu VALUES ('11', '24546');

INSERT INTO sys_role_menu VALUES ('11', '24550');
INSERT INTO sys_role_menu VALUES ('11', '24551');
INSERT INTO sys_role_menu VALUES ('11', '24552');
INSERT INTO sys_role_menu VALUES ('11', '24553');
INSERT INTO sys_role_menu VALUES ('11', '24554');
INSERT INTO sys_role_menu VALUES ('11', '24555');
INSERT INTO sys_role_menu VALUES ('11', '24556');

INSERT INTO sys_role_menu VALUES ('11', '24560');
INSERT INTO sys_role_menu VALUES ('11', '24561');
INSERT INTO sys_role_menu VALUES ('11', '24562');
INSERT INTO sys_role_menu VALUES ('11', '24563');
INSERT INTO sys_role_menu VALUES ('11', '24564');
INSERT INTO sys_role_menu VALUES ('11', '24565');
INSERT INTO sys_role_menu VALUES ('11', '24566');

INSERT INTO sys_role_menu VALUES ('11', '24570');
INSERT INTO sys_role_menu VALUES ('11', '24571');
INSERT INTO sys_role_menu VALUES ('11', '24572');
INSERT INTO sys_role_menu VALUES ('11', '24573');
INSERT INTO sys_role_menu VALUES ('11', '24574');
INSERT INTO sys_role_menu VALUES ('11', '24575');
INSERT INTO sys_role_menu VALUES ('11', '24576');

INSERT INTO sys_role_menu VALUES ('11', '24580');
INSERT INTO sys_role_menu VALUES ('11', '24581');
INSERT INTO sys_role_menu VALUES ('11', '24582');
INSERT INTO sys_role_menu VALUES ('11', '24583');
INSERT INTO sys_role_menu VALUES ('11', '24584');
INSERT INTO sys_role_menu VALUES ('11', '24585');
INSERT INTO sys_role_menu VALUES ('11', '24586');

INSERT INTO sys_role_menu VALUES ('11', '24590');
INSERT INTO sys_role_menu VALUES ('11', '24591');
INSERT INTO sys_role_menu VALUES ('11', '24592');
INSERT INTO sys_role_menu VALUES ('11', '24593');
INSERT INTO sys_role_menu VALUES ('11', '24594');
INSERT INTO sys_role_menu VALUES ('11', '24595');
INSERT INTO sys_role_menu VALUES ('11', '24596');

INSERT INTO sys_role_menu VALUES ('11', '24600');
INSERT INTO sys_role_menu VALUES ('11', '24601');
INSERT INTO sys_role_menu VALUES ('11', '24602');
INSERT INTO sys_role_menu VALUES ('11', '24603');
INSERT INTO sys_role_menu VALUES ('11', '24604');
INSERT INTO sys_role_menu VALUES ('11', '24605');
INSERT INTO sys_role_menu VALUES ('11', '24606');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '24500');

INSERT INTO sys_role_menu VALUES ('1', '24510');
INSERT INTO sys_role_menu VALUES ('1', '24511');
INSERT INTO sys_role_menu VALUES ('1', '24512');
INSERT INTO sys_role_menu VALUES ('1', '24513');
INSERT INTO sys_role_menu VALUES ('1', '24514');
INSERT INTO sys_role_menu VALUES ('1', '24515');
INSERT INTO sys_role_menu VALUES ('1', '24516');

INSERT INTO sys_role_menu VALUES ('1', '24520');
INSERT INTO sys_role_menu VALUES ('1', '24521');
INSERT INTO sys_role_menu VALUES ('1', '24522');
INSERT INTO sys_role_menu VALUES ('1', '24523');
INSERT INTO sys_role_menu VALUES ('1', '24524');
INSERT INTO sys_role_menu VALUES ('1', '24525');
INSERT INTO sys_role_menu VALUES ('1', '24526');

INSERT INTO sys_role_menu VALUES ('1', '24530');
INSERT INTO sys_role_menu VALUES ('1', '24531');
INSERT INTO sys_role_menu VALUES ('1', '24532');
INSERT INTO sys_role_menu VALUES ('1', '24533');
INSERT INTO sys_role_menu VALUES ('1', '24534');
INSERT INTO sys_role_menu VALUES ('1', '24535');
INSERT INTO sys_role_menu VALUES ('1', '24536');

INSERT INTO sys_role_menu VALUES ('1', '24540');
INSERT INTO sys_role_menu VALUES ('1', '24541');
INSERT INTO sys_role_menu VALUES ('1', '24542');
INSERT INTO sys_role_menu VALUES ('1', '24543');
INSERT INTO sys_role_menu VALUES ('1', '24544');
INSERT INTO sys_role_menu VALUES ('1', '24545');
INSERT INTO sys_role_menu VALUES ('1', '24546');

INSERT INTO sys_role_menu VALUES ('1', '24550');
INSERT INTO sys_role_menu VALUES ('1', '24551');
INSERT INTO sys_role_menu VALUES ('1', '24552');
INSERT INTO sys_role_menu VALUES ('1', '24553');
INSERT INTO sys_role_menu VALUES ('1', '24554');
INSERT INTO sys_role_menu VALUES ('1', '24555');
INSERT INTO sys_role_menu VALUES ('1', '24556');

INSERT INTO sys_role_menu VALUES ('1', '24560');
INSERT INTO sys_role_menu VALUES ('1', '24561');
INSERT INTO sys_role_menu VALUES ('1', '24562');
INSERT INTO sys_role_menu VALUES ('1', '24563');
INSERT INTO sys_role_menu VALUES ('1', '24564');
INSERT INTO sys_role_menu VALUES ('1', '24565');
INSERT INTO sys_role_menu VALUES ('1', '24566');

INSERT INTO sys_role_menu VALUES ('1', '24570');
INSERT INTO sys_role_menu VALUES ('1', '24571');
INSERT INTO sys_role_menu VALUES ('1', '24572');
INSERT INTO sys_role_menu VALUES ('1', '24573');
INSERT INTO sys_role_menu VALUES ('1', '24574');
INSERT INTO sys_role_menu VALUES ('1', '24575');
INSERT INTO sys_role_menu VALUES ('1', '24576');

INSERT INTO sys_role_menu VALUES ('1', '24580');
INSERT INTO sys_role_menu VALUES ('1', '24581');
INSERT INTO sys_role_menu VALUES ('1', '24582');
INSERT INTO sys_role_menu VALUES ('1', '24583');
INSERT INTO sys_role_menu VALUES ('1', '24584');
INSERT INTO sys_role_menu VALUES ('1', '24585');
INSERT INTO sys_role_menu VALUES ('1', '24586');

INSERT INTO sys_role_menu VALUES ('1', '24590');
INSERT INTO sys_role_menu VALUES ('1', '24591');
INSERT INTO sys_role_menu VALUES ('1', '24592');
INSERT INTO sys_role_menu VALUES ('1', '24593');
INSERT INTO sys_role_menu VALUES ('1', '24594');
INSERT INTO sys_role_menu VALUES ('1', '24595');
INSERT INTO sys_role_menu VALUES ('1', '24596');

INSERT INTO sys_role_menu VALUES ('1', '24600');
INSERT INTO sys_role_menu VALUES ('1', '24601');
INSERT INTO sys_role_menu VALUES ('1', '24602');
INSERT INTO sys_role_menu VALUES ('1', '24603');
INSERT INTO sys_role_menu VALUES ('1', '24604');
INSERT INTO sys_role_menu VALUES ('1', '24605');
INSERT INTO sys_role_menu VALUES ('1', '24606');