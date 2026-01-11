-- ----------------------------
-- 监督管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建监督管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('23500', '监督管理', '0', '100', 'supervision', NULL, '', 1, 0, 'M', '0', '0', '', 'eye', 100, 1, sysdate(), NULL, NULL, '监督管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('23510', '监督专家组', '23500', '10', 'supervisionExpertGroup', 'supervision/supervisionExpertGroup/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionExpertGroup:list', 'users-cog', 100, 1, sysdate(), NULL, NULL, '监督专家组');
INSERT INTO sys_menu VALUES ('23520', '监督检查', '23500', '20', 'supervisionInspection', 'supervision/supervisionInspection/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionInspection:list', 'search', 100, 1, sysdate(), NULL, NULL, '监督检查');
INSERT INTO sys_menu VALUES ('23530', '监督检查记录', '23500', '30', 'supervisionInspectionRecord', 'supervision/supervisionInspectionRecord/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionInspectionRecord:list', 'file-alt', 100, 1, sysdate(), NULL, NULL, '监督检查记录');
INSERT INTO sys_menu VALUES ('23540', '监督计划', '23500', '40', 'supervisionPlan', 'supervision/supervisionPlan/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionPlan:list', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '监督计划');
INSERT INTO sys_menu VALUES ('23550', '监督报告', '23500', '50', 'supervisionReport', 'supervision/supervisionReport/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionReport:list', 'file-chart-line', 100, 1, sysdate(), NULL, NULL, '监督报告');
INSERT INTO sys_menu VALUES ('23560', '监督任务', '23500', '60', 'supervisionTask', 'supervision/supervisionTask/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionTask:list', 'tasks', 100, 1, sysdate(), NULL, NULL, '监督任务');
INSERT INTO sys_menu VALUES ('23570', '监督任务执行', '23500', '70', 'supervisionTaskExecution', 'supervision/supervisionTaskExecution/index', '', 1, 0, 'C', '0', '0', 'supervision:supervisionTaskExecution:list', 'play-circle', 100, 1, sysdate(), NULL, NULL, '监督任务执行');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 监督专家组按钮
INSERT INTO sys_menu VALUES ('23511', '监督专家组查询', '23510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23512', '监督专家组新增', '23510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23513', '监督专家组修改', '23510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23514', '监督专家组删除', '23510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23515', '监督专家组导入', '23510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23516', '监督专家组导出', '23510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionExpertGroup:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 监督检查按钮
INSERT INTO sys_menu VALUES ('23521', '监督检查查询', '23520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspection:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23522', '监督检查新增', '23520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspection:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23523', '监督检查修改', '23520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspection:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23524', '监督检查删除', '23520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspection:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23525', '监督检查导入', '23520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspection:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23526', '监督检查导出', '23520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspection:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 监督检查记录按钮
INSERT INTO sys_menu VALUES ('23531', '监督检查记录查询', '23530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspectionRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23532', '监督检查记录新增', '23530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspectionRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23533', '监督检查记录修改', '23530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspectionRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23534', '监督检查记录删除', '23530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspectionRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23535', '监督检查记录导入', '23530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspectionRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23536', '监督检查记录导出', '23530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionInspectionRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 监督计划按钮
INSERT INTO sys_menu VALUES ('23541', '监督计划查询', '23540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23542', '监督计划新增', '23540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23543', '监督计划修改', '23540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23544', '监督计划删除', '23540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23545', '监督计划导入', '23540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23546', '监督计划导出', '23540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 监督报告按钮
INSERT INTO sys_menu VALUES ('23551', '监督报告查询', '23550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReport:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23552', '监督报告新增', '23550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReport:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23553', '监督报告修改', '23550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReport:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23554', '监督报告删除', '23550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReport:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23555', '监督报告导入', '23550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReport:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23556', '监督报告导出', '23550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionReport:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 监督任务按钮
INSERT INTO sys_menu VALUES ('23561', '监督任务查询', '23560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTask:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23562', '监督任务新增', '23560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTask:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23563', '监督任务修改', '23560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTask:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23564', '监督任务删除', '23560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTask:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23565', '监督任务导入', '23560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTask:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23566', '监督任务导出', '23560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTask:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 监督任务执行按钮
INSERT INTO sys_menu VALUES ('23571', '监督任务执行查询', '23570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTaskExecution:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23572', '监督任务执行新增', '23570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTaskExecution:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23573', '监督任务执行修改', '23570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTaskExecution:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23574', '监督任务执行删除', '23570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTaskExecution:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23575', '监督任务执行导入', '23570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTaskExecution:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23576', '监督任务执行导出', '23570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'supervision:supervisionTaskExecution:export', '#', 100, 1, sysdate(), NULL, NULL, '');