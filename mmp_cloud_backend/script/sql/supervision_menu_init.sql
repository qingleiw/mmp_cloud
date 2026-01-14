-- ----------------------------
-- 监督管理完整菜单SQL脚本（正确版本）
-- 生成时间：2026-01-14
-- 包含15个子模块
-- ----------------------------

-- 清理旧数据
DELETE FROM sys_role_menu WHERE menu_id >= 23500 AND menu_id < 24000;
DELETE FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- ----------------------------
-- 1. 创建监督管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('23500', '监督管理', '0', '100', 'supervision', NULL, '', 1, 0, 'M', '0', '0', '', 'eye', 100, 1, sysdate(), NULL, NULL, '监督管理目录');

-- ----------------------------
-- 2. 创建子菜单(15个模块)
-- ----------------------------
INSERT INTO sys_menu VALUES ('23510', '监督专家组', '23500', '10', 'supervisionExpertGroup', 'supervision/supervisionExpertGroup/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionExpertGroup:list', 'users-cog', 100, 1, sysdate(), NULL, NULL, '监督专家组');
INSERT INTO sys_menu VALUES ('23520', '监督专家成员', '23500', '20', 'supervisionExpertMember', 'supervision/supervisionExpertMember/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionExpertMember:list', 'user-tie', 100, 1, sysdate(), NULL, NULL, '监督专家成员');
INSERT INTO sys_menu VALUES ('23530', '监督表单', '23500', '30', 'supervisionForm', 'supervision/supervisionForm/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionForm:list', 'file-alt', 100, 1, sysdate(), NULL, NULL, '监督表单');
INSERT INTO sys_menu VALUES ('23540', '监督表单字段', '23500', '40', 'supervisionFormField', 'supervision/supervisionFormField/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionFormField:list', 'list', 100, 1, sysdate(), NULL, NULL, '监督表单字段');
INSERT INTO sys_menu VALUES ('23550', '监督问题', '23500', '50', 'supervisionIssue', 'supervision/supervisionIssue/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionIssue:list', 'exclamation-circle', 100, 1, sysdate(), NULL, NULL, '监督问题');
INSERT INTO sys_menu VALUES ('23560', '监督计划', '23500', '60', 'supervisionPlan', 'supervision/supervisionPlan/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionPlan:list', 'calendar-alt', 100, 1, sysdate(), NULL, NULL, '监督计划');
INSERT INTO sys_menu VALUES ('23570', '监督计划科室', '23500', '70', 'supervisionPlanDept', 'supervision/supervisionPlanDept/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionPlanDept:list', 'building', 100, 1, sysdate(), NULL, NULL, '监督计划科室');
INSERT INTO sys_menu VALUES ('23580', '监督计划表单', '23500', '80', 'supervisionPlanForm', 'supervision/supervisionPlanForm/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionPlanForm:list', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '监督计划表单');
INSERT INTO sys_menu VALUES ('23590', '监督项目', '23500', '90', 'supervisionProject', 'supervision/supervisionProject/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionProject:list', 'project-diagram', 100, 1, sysdate(), NULL, NULL, '监督项目');
INSERT INTO sys_menu VALUES ('23600', '监督项目指标', '23500', '100', 'supervisionProjectIndicator', 'supervision/supervisionProjectIndicator/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionProjectIndicator:list', 'chart-bar', 100, 1, sysdate(), NULL, NULL, '监督项目指标');
INSERT INTO sys_menu VALUES ('23610', '监督整改进度', '23500', '110', 'supervisionRectificationProgress', 'supervision/supervisionRectificationProgress/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionRectificationProgress:list', 'tasks', 100, 1, sysdate(), NULL, NULL, '监督整改进度');
INSERT INTO sys_menu VALUES ('23620', '监督整改任务', '23500', '120', 'supervisionRectificationTask', 'supervision/supervisionRectificationTask/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionRectificationTask:list', 'clipboard-check', 100, 1, sysdate(), NULL, NULL, '监督整改任务');
INSERT INTO sys_menu VALUES ('23630', '监督结果', '23500', '130', 'supervisionResult', 'supervision/supervisionResult/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionResult:list', 'poll', 100, 1, sysdate(), NULL, NULL, '监督结果');
INSERT INTO sys_menu VALUES ('23640', '监督结果明细', '23500', '140', 'supervisionResultDetail', 'supervision/supervisionResultDetail/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionResultDetail:list', 'list-alt', 100, 1, sysdate(), NULL, NULL, '监督结果明细');
INSERT INTO sys_menu VALUES ('23650', '监督复核', '23500', '150', 'supervisionReview', 'supervision/supervisionReview/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionReview:list', 'redo', 100, 1, sysdate(), NULL, NULL, '监督复核');

-- ----------------------------
-- 3. 定义按钮权限(每个模块6个按钮，共90个按钮)
-- 由于内容较多，这里生成所有按钮
-- ----------------------------

-- 3.1 监督专家组按钮
INSERT INTO sys_menu VALUES ('23511', '监督专家组查询', '23510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23512', '监督专家组新增', '23510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23513', '监督专家组修改', '23510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23514', '监督专家组删除', '23510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23515', '监督专家组导入', '23510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23516', '监督专家组导出', '23510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.2 监督专家成员按钮
INSERT INTO sys_menu VALUES ('23521', '监督专家成员查询', '23520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertMember:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23522', '监督专家成员新增', '23520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertMember:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23523', '监督专家成员修改', '23520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertMember:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23524', '监督专家成员删除', '23520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertMember:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23525', '监督专家成员导入', '23520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertMember:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23526', '监督专家成员导出', '23520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertMember:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.3 监督表单按钮
INSERT INTO sys_menu VALUES ('23531', '监督表单查询', '23530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionForm:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23532', '监督表单新增', '23530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionForm:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23533', '监督表单修改', '23530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionForm:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23534', '监督表单删除', '23530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionForm:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23535', '监督表单导入', '23530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionForm:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23536', '监督表单导出', '23530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionForm:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.4 监督表单字段按钮
INSERT INTO sys_menu VALUES ('23541', '监督表单字段查询', '23540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionFormField:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23542', '监督表单字段新增', '23540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionFormField:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23543', '监督表单字段修改', '23540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionFormField:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23544', '监督表单字段删除', '23540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionFormField:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23545', '监督表单字段导入', '23540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionFormField:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23546', '监督表单字段导出', '23540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionFormField:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.5 监督问题按钮
INSERT INTO sys_menu VALUES ('23551', '监督问题查询', '23550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionIssue:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23552', '监督问题新增', '23550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionIssue:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23553', '监督问题修改', '23550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionIssue:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23554', '监督问题删除', '23550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionIssue:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23555', '监督问题导入', '23550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionIssue:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23556', '监督问题导出', '23550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionIssue:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.6 监督计划按钮
INSERT INTO sys_menu VALUES ('23561', '监督计划查询', '23560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23562', '监督计划新增', '23560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23563', '监督计划修改', '23560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23564', '监督计划删除', '23560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23565', '监督计划导入', '23560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23566', '监督计划导出', '23560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.7 监督计划科室按钮
INSERT INTO sys_menu VALUES ('23571', '监督计划科室查询', '23570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanDept:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23572', '监督计划科室新增', '23570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanDept:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23573', '监督计划科室修改', '23570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanDept:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23574', '监督计划科室删除', '23570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanDept:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23575', '监督计划科室导入', '23570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanDept:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23576', '监督计划科室导出', '23570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanDept:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.8 监督计划表单按钮
INSERT INTO sys_menu VALUES ('23581', '监督计划表单查询', '23580', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanForm:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23582', '监督计划表单新增', '23580', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanForm:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23583', '监督计划表单修改', '23580', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanForm:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23584', '监督计划表单删除', '23580', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanForm:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23585', '监督计划表单导入', '23580', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanForm:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23586', '监督计划表单导出', '23580', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlanForm:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.9 监督项目按钮
INSERT INTO sys_menu VALUES ('23591', '监督项目查询', '23590', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProject:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23592', '监督项目新增', '23590', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProject:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23593', '监督项目修改', '23590', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProject:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23594', '监督项目删除', '23590', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProject:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23595', '监督项目导入', '23590', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProject:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23596', '监督项目导出', '23590', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProject:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.10 监督项目指标按钮
INSERT INTO sys_menu VALUES ('23601', '监督项目指标查询', '23600', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProjectIndicator:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23602', '监督项目指标新增', '23600', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProjectIndicator:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23603', '监督项目指标修改', '23600', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProjectIndicator:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23604', '监督项目指标删除', '23600', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProjectIndicator:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23605', '监督项目指标导入', '23600', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProjectIndicator:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23606', '监督项目指标导出', '23600', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionProjectIndicator:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.11 监督整改进度按钮
INSERT INTO sys_menu VALUES ('23611', '监督整改进度查询', '23610', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationProgress:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23612', '监督整改进度新增', '23610', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationProgress:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23613', '监督整改进度修改', '23610', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationProgress:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23614', '监督整改进度删除', '23610', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationProgress:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23615', '监督整改进度导入', '23610', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationProgress:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23616', '监督整改进度导出', '23610', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationProgress:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.12 监督整改任务按钮
INSERT INTO sys_menu VALUES ('23621', '监督整改任务查询', '23620', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationTask:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23622', '监督整改任务新增', '23620', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationTask:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23623', '监督整改任务修改', '23620', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationTask:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23624', '监督整改任务删除', '23620', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationTask:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23625', '监督整改任务导入', '23620', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationTask:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23626', '监督整改任务导出', '23620', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionRectificationTask:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.13 监督结果按钮
INSERT INTO sys_menu VALUES ('23631', '监督结果查询', '23630', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResult:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23632', '监督结果新增', '23630', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResult:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23633', '监督结果修改', '23630', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResult:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23634', '监督结果删除', '23630', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResult:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23635', '监督结果导入', '23630', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResult:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23636', '监督结果导出', '23630', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResult:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 3.14 监督结果明细按钮
-- ----------------------------
INSERT INTO sys_menu VALUES ('23641', '监督结果明细查询', '23640', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResultDetail:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23642', '监督结果明细新增', '23640', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResultDetail:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23643', '监督结果明细修改', '23640', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResultDetail:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23644', '监督结果明细删除', '23640', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResultDetail:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23645', '监督结果明细导入', '23640', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResultDetail:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23646', '监督结果明细导出', '23640', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionResultDetail:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 3.15 监督复核按钮
-- ----------------------------
INSERT INTO sys_menu VALUES ('23651', '监督复核查询', '23650', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReview:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23652', '监督复核新增', '23650', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReview:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23653', '监督复核修改', '23650', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReview:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23654', '监督复核删除', '23650', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReview:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23655', '监督复核导入', '23650', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReview:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23656', '监督复核导出', '23650', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReview:export', '#', 100, 1, sysdate(), NULL, NULL, '');


-- ----------------------------
-- 监督管理模块 - 角色权限分配
-- ----------------------------

-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 23500 AND menu_id < 24000;

COMMIT;