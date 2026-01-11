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

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '23500');

INSERT INTO sys_role_menu VALUES ('5', '23510');
INSERT INTO sys_role_menu VALUES ('5', '23511');
INSERT INTO sys_role_menu VALUES ('5', '23512');
INSERT INTO sys_role_menu VALUES ('5', '23513');
INSERT INTO sys_role_menu VALUES ('5', '23514');
INSERT INTO sys_role_menu VALUES ('5', '23515');
INSERT INTO sys_role_menu VALUES ('5', '23516');

INSERT INTO sys_role_menu VALUES ('5', '23520');
INSERT INTO sys_role_menu VALUES ('5', '23521');
INSERT INTO sys_role_menu VALUES ('5', '23522');
INSERT INTO sys_role_menu VALUES ('5', '23523');
INSERT INTO sys_role_menu VALUES ('5', '23524');
INSERT INTO sys_role_menu VALUES ('5', '23525');
INSERT INTO sys_role_menu VALUES ('5', '23526');

INSERT INTO sys_role_menu VALUES ('5', '23530');
INSERT INTO sys_role_menu VALUES ('5', '23531');
INSERT INTO sys_role_menu VALUES ('5', '23532');
INSERT INTO sys_role_menu VALUES ('5', '23533');
INSERT INTO sys_role_menu VALUES ('5', '23534');
INSERT INTO sys_role_menu VALUES ('5', '23535');
INSERT INTO sys_role_menu VALUES ('5', '23536');

INSERT INTO sys_role_menu VALUES ('5', '23540');
INSERT INTO sys_role_menu VALUES ('5', '23541');
INSERT INTO sys_role_menu VALUES ('5', '23542');
INSERT INTO sys_role_menu VALUES ('5', '23543');
INSERT INTO sys_role_menu VALUES ('5', '23544');
INSERT INTO sys_role_menu VALUES ('5', '23545');
INSERT INTO sys_role_menu VALUES ('5', '23546');

INSERT INTO sys_role_menu VALUES ('5', '23550');
INSERT INTO sys_role_menu VALUES ('5', '23551');
INSERT INTO sys_role_menu VALUES ('5', '23552');
INSERT INTO sys_role_menu VALUES ('5', '23553');
INSERT INTO sys_role_menu VALUES ('5', '23554');
INSERT INTO sys_role_menu VALUES ('5', '23555');
INSERT INTO sys_role_menu VALUES ('5', '23556');

INSERT INTO sys_role_menu VALUES ('5', '23560');
INSERT INTO sys_role_menu VALUES ('5', '23561');
INSERT INTO sys_role_menu VALUES ('5', '23562');
INSERT INTO sys_role_menu VALUES ('5', '23563');
INSERT INTO sys_role_menu VALUES ('5', '23564');
INSERT INTO sys_role_menu VALUES ('5', '23565');
INSERT INTO sys_role_menu VALUES ('5', '23566');

INSERT INTO sys_role_menu VALUES ('5', '23570');
INSERT INTO sys_role_menu VALUES ('5', '23571');
INSERT INTO sys_role_menu VALUES ('5', '23572');
INSERT INTO sys_role_menu VALUES ('5', '23573');
INSERT INTO sys_role_menu VALUES ('5', '23574');
INSERT INTO sys_role_menu VALUES ('5', '23575');
INSERT INTO sys_role_menu VALUES ('5', '23576');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '23500');

INSERT INTO sys_role_menu VALUES ('6', '23510');
INSERT INTO sys_role_menu VALUES ('6', '23511');
INSERT INTO sys_role_menu VALUES ('6', '23512');
INSERT INTO sys_role_menu VALUES ('6', '23513');
INSERT INTO sys_role_menu VALUES ('6', '23514');
INSERT INTO sys_role_menu VALUES ('6', '23515');
INSERT INTO sys_role_menu VALUES ('6', '23516');

INSERT INTO sys_role_menu VALUES ('6', '23520');
INSERT INTO sys_role_menu VALUES ('6', '23521');
INSERT INTO sys_role_menu VALUES ('6', '23522');
INSERT INTO sys_role_menu VALUES ('6', '23523');
INSERT INTO sys_role_menu VALUES ('6', '23524');
INSERT INTO sys_role_menu VALUES ('6', '23525');
INSERT INTO sys_role_menu VALUES ('6', '23526');

INSERT INTO sys_role_menu VALUES ('6', '23530');
INSERT INTO sys_role_menu VALUES ('6', '23531');
INSERT INTO sys_role_menu VALUES ('6', '23532');
INSERT INTO sys_role_menu VALUES ('6', '23533');
INSERT INTO sys_role_menu VALUES ('6', '23534');
INSERT INTO sys_role_menu VALUES ('6', '23535');
INSERT INTO sys_role_menu VALUES ('6', '23536');

INSERT INTO sys_role_menu VALUES ('6', '23540');
INSERT INTO sys_role_menu VALUES ('6', '23541');
INSERT INTO sys_role_menu VALUES ('6', '23542');
INSERT INTO sys_role_menu VALUES ('6', '23543');
INSERT INTO sys_role_menu VALUES ('6', '23544');
INSERT INTO sys_role_menu VALUES ('6', '23545');
INSERT INTO sys_role_menu VALUES ('6', '23546');

INSERT INTO sys_role_menu VALUES ('6', '23550');
INSERT INTO sys_role_menu VALUES ('6', '23551');
INSERT INTO sys_role_menu VALUES ('6', '23552');
INSERT INTO sys_role_menu VALUES ('6', '23553');
INSERT INTO sys_role_menu VALUES ('6', '23554');
INSERT INTO sys_role_menu VALUES ('6', '23555');
INSERT INTO sys_role_menu VALUES ('6', '23556');

INSERT INTO sys_role_menu VALUES ('6', '23560');
INSERT INTO sys_role_menu VALUES ('6', '23561');
INSERT INTO sys_role_menu VALUES ('6', '23562');
INSERT INTO sys_role_menu VALUES ('6', '23563');
INSERT INTO sys_role_menu VALUES ('6', '23564');
INSERT INTO sys_role_menu VALUES ('6', '23565');
INSERT INTO sys_role_menu VALUES ('6', '23566');

INSERT INTO sys_role_menu VALUES ('6', '23570');
INSERT INTO sys_role_menu VALUES ('6', '23571');
INSERT INTO sys_role_menu VALUES ('6', '23572');
INSERT INTO sys_role_menu VALUES ('6', '23573');
INSERT INTO sys_role_menu VALUES ('6', '23574');
INSERT INTO sys_role_menu VALUES ('6', '23575');
INSERT INTO sys_role_menu VALUES ('6', '23576');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '23500');

INSERT INTO sys_role_menu VALUES ('7', '23510');
INSERT INTO sys_role_menu VALUES ('7', '23511');
INSERT INTO sys_role_menu VALUES ('7', '23512');
INSERT INTO sys_role_menu VALUES ('7', '23513');
INSERT INTO sys_role_menu VALUES ('7', '23514');
INSERT INTO sys_role_menu VALUES ('7', '23515');
INSERT INTO sys_role_menu VALUES ('7', '23516');

INSERT INTO sys_role_menu VALUES ('7', '23520');
INSERT INTO sys_role_menu VALUES ('7', '23521');
INSERT INTO sys_role_menu VALUES ('7', '23522');
INSERT INTO sys_role_menu VALUES ('7', '23523');
INSERT INTO sys_role_menu VALUES ('7', '23524');
INSERT INTO sys_role_menu VALUES ('7', '23525');
INSERT INTO sys_role_menu VALUES ('7', '23526');

INSERT INTO sys_role_menu VALUES ('7', '23530');
INSERT INTO sys_role_menu VALUES ('7', '23531');
INSERT INTO sys_role_menu VALUES ('7', '23532');
INSERT INTO sys_role_menu VALUES ('7', '23533');
INSERT INTO sys_role_menu VALUES ('7', '23534');
INSERT INTO sys_role_menu VALUES ('7', '23535');
INSERT INTO sys_role_menu VALUES ('7', '23536');

INSERT INTO sys_role_menu VALUES ('7', '23540');
INSERT INTO sys_role_menu VALUES ('7', '23541');
INSERT INTO sys_role_menu VALUES ('7', '23542');
INSERT INTO sys_role_menu VALUES ('7', '23543');
INSERT INTO sys_role_menu VALUES ('7', '23544');
INSERT INTO sys_role_menu VALUES ('7', '23545');
INSERT INTO sys_role_menu VALUES ('7', '23546');

INSERT INTO sys_role_menu VALUES ('7', '23550');
INSERT INTO sys_role_menu VALUES ('7', '23551');
INSERT INTO sys_role_menu VALUES ('7', '23552');
INSERT INTO sys_role_menu VALUES ('7', '23553');
INSERT INTO sys_role_menu VALUES ('7', '23554');
INSERT INTO sys_role_menu VALUES ('7', '23555');
INSERT INTO sys_role_menu VALUES ('7', '23556');

INSERT INTO sys_role_menu VALUES ('7', '23560');
INSERT INTO sys_role_menu VALUES ('7', '23561');
INSERT INTO sys_role_menu VALUES ('7', '23562');
INSERT INTO sys_role_menu VALUES ('7', '23563');
INSERT INTO sys_role_menu VALUES ('7', '23564');
INSERT INTO sys_role_menu VALUES ('7', '23565');
INSERT INTO sys_role_menu VALUES ('7', '23566');

INSERT INTO sys_role_menu VALUES ('7', '23570');
INSERT INTO sys_role_menu VALUES ('7', '23571');
INSERT INTO sys_role_menu VALUES ('7', '23572');
INSERT INTO sys_role_menu VALUES ('7', '23573');
INSERT INTO sys_role_menu VALUES ('7', '23574');
INSERT INTO sys_role_menu VALUES ('7', '23575');
INSERT INTO sys_role_menu VALUES ('7', '23576');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '23500');

INSERT INTO sys_role_menu VALUES ('8', '23510');
INSERT INTO sys_role_menu VALUES ('8', '23511');
INSERT INTO sys_role_menu VALUES ('8', '23512');
INSERT INTO sys_role_menu VALUES ('8', '23513');
INSERT INTO sys_role_menu VALUES ('8', '23514');
INSERT INTO sys_role_menu VALUES ('8', '23515');
INSERT INTO sys_role_menu VALUES ('8', '23516');

INSERT INTO sys_role_menu VALUES ('8', '23520');
INSERT INTO sys_role_menu VALUES ('8', '23521');
INSERT INTO sys_role_menu VALUES ('8', '23522');
INSERT INTO sys_role_menu VALUES ('8', '23523');
INSERT INTO sys_role_menu VALUES ('8', '23524');
INSERT INTO sys_role_menu VALUES ('8', '23525');
INSERT INTO sys_role_menu VALUES ('8', '23526');

INSERT INTO sys_role_menu VALUES ('8', '23530');
INSERT INTO sys_role_menu VALUES ('8', '23531');
INSERT INTO sys_role_menu VALUES ('8', '23532');
INSERT INTO sys_role_menu VALUES ('8', '23533');
INSERT INTO sys_role_menu VALUES ('8', '23534');
INSERT INTO sys_role_menu VALUES ('8', '23535');
INSERT INTO sys_role_menu VALUES ('8', '23536');

INSERT INTO sys_role_menu VALUES ('8', '23540');
INSERT INTO sys_role_menu VALUES ('8', '23541');
INSERT INTO sys_role_menu VALUES ('8', '23542');
INSERT INTO sys_role_menu VALUES ('8', '23543');
INSERT INTO sys_role_menu VALUES ('8', '23544');
INSERT INTO sys_role_menu VALUES ('8', '23545');
INSERT INTO sys_role_menu VALUES ('8', '23546');

INSERT INTO sys_role_menu VALUES ('8', '23550');
INSERT INTO sys_role_menu VALUES ('8', '23551');
INSERT INTO sys_role_menu VALUES ('8', '23552');
INSERT INTO sys_role_menu VALUES ('8', '23553');
INSERT INTO sys_role_menu VALUES ('8', '23554');
INSERT INTO sys_role_menu VALUES ('8', '23555');
INSERT INTO sys_role_menu VALUES ('8', '23556');

INSERT INTO sys_role_menu VALUES ('8', '23560');
INSERT INTO sys_role_menu VALUES ('8', '23561');
INSERT INTO sys_role_menu VALUES ('8', '23562');
INSERT INTO sys_role_menu VALUES ('8', '23563');
INSERT INTO sys_role_menu VALUES ('8', '23564');
INSERT INTO sys_role_menu VALUES ('8', '23565');
INSERT INTO sys_role_menu VALUES ('8', '23566');

INSERT INTO sys_role_menu VALUES ('8', '23570');
INSERT INTO sys_role_menu VALUES ('8', '23571');
INSERT INTO sys_role_menu VALUES ('8', '23572');
INSERT INTO sys_role_menu VALUES ('8', '23573');
INSERT INTO sys_role_menu VALUES ('8', '23574');
INSERT INTO sys_role_menu VALUES ('8', '23575');
INSERT INTO sys_role_menu VALUES ('8', '23576');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '23500');

INSERT INTO sys_role_menu VALUES ('9', '23510');
INSERT INTO sys_role_menu VALUES ('9', '23511');
INSERT INTO sys_role_menu VALUES ('9', '23512');
INSERT INTO sys_role_menu VALUES ('9', '23513');
INSERT INTO sys_role_menu VALUES ('9', '23514');
INSERT INTO sys_role_menu VALUES ('9', '23515');
INSERT INTO sys_role_menu VALUES ('9', '23516');

INSERT INTO sys_role_menu VALUES ('9', '23520');
INSERT INTO sys_role_menu VALUES ('9', '23521');
INSERT INTO sys_role_menu VALUES ('9', '23522');
INSERT INTO sys_role_menu VALUES ('9', '23523');
INSERT INTO sys_role_menu VALUES ('9', '23524');
INSERT INTO sys_role_menu VALUES ('9', '23525');
INSERT INTO sys_role_menu VALUES ('9', '23526');

INSERT INTO sys_role_menu VALUES ('9', '23530');
INSERT INTO sys_role_menu VALUES ('9', '23531');
INSERT INTO sys_role_menu VALUES ('9', '23532');
INSERT INTO sys_role_menu VALUES ('9', '23533');
INSERT INTO sys_role_menu VALUES ('9', '23534');
INSERT INTO sys_role_menu VALUES ('9', '23535');
INSERT INTO sys_role_menu VALUES ('9', '23536');

INSERT INTO sys_role_menu VALUES ('9', '23540');
INSERT INTO sys_role_menu VALUES ('9', '23541');
INSERT INTO sys_role_menu VALUES ('9', '23542');
INSERT INTO sys_role_menu VALUES ('9', '23543');
INSERT INTO sys_role_menu VALUES ('9', '23544');
INSERT INTO sys_role_menu VALUES ('9', '23545');
INSERT INTO sys_role_menu VALUES ('9', '23546');

INSERT INTO sys_role_menu VALUES ('9', '23550');
INSERT INTO sys_role_menu VALUES ('9', '23551');
INSERT INTO sys_role_menu VALUES ('9', '23552');
INSERT INTO sys_role_menu VALUES ('9', '23553');
INSERT INTO sys_role_menu VALUES ('9', '23554');
INSERT INTO sys_role_menu VALUES ('9', '23555');
INSERT INTO sys_role_menu VALUES ('9', '23556');

INSERT INTO sys_role_menu VALUES ('9', '23560');
INSERT INTO sys_role_menu VALUES ('9', '23561');
INSERT INTO sys_role_menu VALUES ('9', '23562');
INSERT INTO sys_role_menu VALUES ('9', '23563');
INSERT INTO sys_role_menu VALUES ('9', '23564');
INSERT INTO sys_role_menu VALUES ('9', '23565');
INSERT INTO sys_role_menu VALUES ('9', '23566');

INSERT INTO sys_role_menu VALUES ('9', '23570');
INSERT INTO sys_role_menu VALUES ('9', '23571');
INSERT INTO sys_role_menu VALUES ('9', '23572');
INSERT INTO sys_role_menu VALUES ('9', '23573');
INSERT INTO sys_role_menu VALUES ('9', '23574');
INSERT INTO sys_role_menu VALUES ('9', '23575');
INSERT INTO sys_role_menu VALUES ('9', '23576');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '23500');

INSERT INTO sys_role_menu VALUES ('10', '23510');
INSERT INTO sys_role_menu VALUES ('10', '23511');
INSERT INTO sys_role_menu VALUES ('10', '23512');
INSERT INTO sys_role_menu VALUES ('10', '23513');
INSERT INTO sys_role_menu VALUES ('10', '23514');
INSERT INTO sys_role_menu VALUES ('10', '23515');
INSERT INTO sys_role_menu VALUES ('10', '23516');

INSERT INTO sys_role_menu VALUES ('10', '23520');
INSERT INTO sys_role_menu VALUES ('10', '23521');
INSERT INTO sys_role_menu VALUES ('10', '23522');
INSERT INTO sys_role_menu VALUES ('10', '23523');
INSERT INTO sys_role_menu VALUES ('10', '23524');
INSERT INTO sys_role_menu VALUES ('10', '23525');
INSERT INTO sys_role_menu VALUES ('10', '23526');

INSERT INTO sys_role_menu VALUES ('10', '23530');
INSERT INTO sys_role_menu VALUES ('10', '23531');
INSERT INTO sys_role_menu VALUES ('10', '23532');
INSERT INTO sys_role_menu VALUES ('10', '23533');
INSERT INTO sys_role_menu VALUES ('10', '23534');
INSERT INTO sys_role_menu VALUES ('10', '23535');
INSERT INTO sys_role_menu VALUES ('10', '23536');

INSERT INTO sys_role_menu VALUES ('10', '23540');
INSERT INTO sys_role_menu VALUES ('10', '23541');
INSERT INTO sys_role_menu VALUES ('10', '23542');
INSERT INTO sys_role_menu VALUES ('10', '23543');
INSERT INTO sys_role_menu VALUES ('10', '23544');
INSERT INTO sys_role_menu VALUES ('10', '23545');
INSERT INTO sys_role_menu VALUES ('10', '23546');

INSERT INTO sys_role_menu VALUES ('10', '23550');
INSERT INTO sys_role_menu VALUES ('10', '23551');
INSERT INTO sys_role_menu VALUES ('10', '23552');
INSERT INTO sys_role_menu VALUES ('10', '23553');
INSERT INTO sys_role_menu VALUES ('10', '23554');
INSERT INTO sys_role_menu VALUES ('10', '23555');
INSERT INTO sys_role_menu VALUES ('10', '23556');

INSERT INTO sys_role_menu VALUES ('10', '23560');
INSERT INTO sys_role_menu VALUES ('10', '23561');
INSERT INTO sys_role_menu VALUES ('10', '23562');
INSERT INTO sys_role_menu VALUES ('10', '23563');
INSERT INTO sys_role_menu VALUES ('10', '23564');
INSERT INTO sys_role_menu VALUES ('10', '23565');
INSERT INTO sys_role_menu VALUES ('10', '23566');

INSERT INTO sys_role_menu VALUES ('10', '23570');
INSERT INTO sys_role_menu VALUES ('10', '23571');
INSERT INTO sys_role_menu VALUES ('10', '23572');
INSERT INTO sys_role_menu VALUES ('10', '23573');
INSERT INTO sys_role_menu VALUES ('10', '23574');
INSERT INTO sys_role_menu VALUES ('10', '23575');
INSERT INTO sys_role_menu VALUES ('10', '23576');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '23500');

INSERT INTO sys_role_menu VALUES ('11', '23510');
INSERT INTO sys_role_menu VALUES ('11', '23511');
INSERT INTO sys_role_menu VALUES ('11', '23512');
INSERT INTO sys_role_menu VALUES ('11', '23513');
INSERT INTO sys_role_menu VALUES ('11', '23514');
INSERT INTO sys_role_menu VALUES ('11', '23515');
INSERT INTO sys_role_menu VALUES ('11', '23516');

INSERT INTO sys_role_menu VALUES ('11', '23520');
INSERT INTO sys_role_menu VALUES ('11', '23521');
INSERT INTO sys_role_menu VALUES ('11', '23522');
INSERT INTO sys_role_menu VALUES ('11', '23523');
INSERT INTO sys_role_menu VALUES ('11', '23524');
INSERT INTO sys_role_menu VALUES ('11', '23525');
INSERT INTO sys_role_menu VALUES ('11', '23526');

INSERT INTO sys_role_menu VALUES ('11', '23530');
INSERT INTO sys_role_menu VALUES ('11', '23531');
INSERT INTO sys_role_menu VALUES ('11', '23532');
INSERT INTO sys_role_menu VALUES ('11', '23533');
INSERT INTO sys_role_menu VALUES ('11', '23534');
INSERT INTO sys_role_menu VALUES ('11', '23535');
INSERT INTO sys_role_menu VALUES ('11', '23536');

INSERT INTO sys_role_menu VALUES ('11', '23540');
INSERT INTO sys_role_menu VALUES ('11', '23541');
INSERT INTO sys_role_menu VALUES ('11', '23542');
INSERT INTO sys_role_menu VALUES ('11', '23543');
INSERT INTO sys_role_menu VALUES ('11', '23544');
INSERT INTO sys_role_menu VALUES ('11', '23545');
INSERT INTO sys_role_menu VALUES ('11', '23546');

INSERT INTO sys_role_menu VALUES ('11', '23550');
INSERT INTO sys_role_menu VALUES ('11', '23551');
INSERT INTO sys_role_menu VALUES ('11', '23552');
INSERT INTO sys_role_menu VALUES ('11', '23553');
INSERT INTO sys_role_menu VALUES ('11', '23554');
INSERT INTO sys_role_menu VALUES ('11', '23555');
INSERT INTO sys_role_menu VALUES ('11', '23556');

INSERT INTO sys_role_menu VALUES ('11', '23560');
INSERT INTO sys_role_menu VALUES ('11', '23561');
INSERT INTO sys_role_menu VALUES ('11', '23562');
INSERT INTO sys_role_menu VALUES ('11', '23563');
INSERT INTO sys_role_menu VALUES ('11', '23564');
INSERT INTO sys_role_menu VALUES ('11', '23565');
INSERT INTO sys_role_menu VALUES ('11', '23566');

INSERT INTO sys_role_menu VALUES ('11', '23570');
INSERT INTO sys_role_menu VALUES ('11', '23571');
INSERT INTO sys_role_menu VALUES ('11', '23572');
INSERT INTO sys_role_menu VALUES ('11', '23573');
INSERT INTO sys_role_menu VALUES ('11', '23574');
INSERT INTO sys_role_menu VALUES ('11', '23575');
INSERT INTO sys_role_menu VALUES ('11', '23576');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '23500');

INSERT INTO sys_role_menu VALUES ('1', '23510');
INSERT INTO sys_role_menu VALUES ('1', '23511');
INSERT INTO sys_role_menu VALUES ('1', '23512');
INSERT INTO sys_role_menu VALUES ('1', '23513');
INSERT INTO sys_role_menu VALUES ('1', '23514');
INSERT INTO sys_role_menu VALUES ('1', '23515');
INSERT INTO sys_role_menu VALUES ('1', '23516');

INSERT INTO sys_role_menu VALUES ('1', '23520');
INSERT INTO sys_role_menu VALUES ('1', '23521');
INSERT INTO sys_role_menu VALUES ('1', '23522');
INSERT INTO sys_role_menu VALUES ('1', '23523');
INSERT INTO sys_role_menu VALUES ('1', '23524');
INSERT INTO sys_role_menu VALUES ('1', '23525');
INSERT INTO sys_role_menu VALUES ('1', '23526');

INSERT INTO sys_role_menu VALUES ('1', '23530');
INSERT INTO sys_role_menu VALUES ('1', '23531');
INSERT INTO sys_role_menu VALUES ('1', '23532');
INSERT INTO sys_role_menu VALUES ('1', '23533');
INSERT INTO sys_role_menu VALUES ('1', '23534');
INSERT INTO sys_role_menu VALUES ('1', '23535');
INSERT INTO sys_role_menu VALUES ('1', '23536');

INSERT INTO sys_role_menu VALUES ('1', '23540');
INSERT INTO sys_role_menu VALUES ('1', '23541');
INSERT INTO sys_role_menu VALUES ('1', '23542');
INSERT INTO sys_role_menu VALUES ('1', '23543');
INSERT INTO sys_role_menu VALUES ('1', '23544');
INSERT INTO sys_role_menu VALUES ('1', '23545');
INSERT INTO sys_role_menu VALUES ('1', '23546');

INSERT INTO sys_role_menu VALUES ('1', '23550');
INSERT INTO sys_role_menu VALUES ('1', '23551');
INSERT INTO sys_role_menu VALUES ('1', '23552');
INSERT INTO sys_role_menu VALUES ('1', '23553');
INSERT INTO sys_role_menu VALUES ('1', '23554');
INSERT INTO sys_role_menu VALUES ('1', '23555');
INSERT INTO sys_role_menu VALUES ('1', '23556');

INSERT INTO sys_role_menu VALUES ('1', '23560');
INSERT INTO sys_role_menu VALUES ('1', '23561');
INSERT INTO sys_role_menu VALUES ('1', '23562');
INSERT INTO sys_role_menu VALUES ('1', '23563');
INSERT INTO sys_role_menu VALUES ('1', '23564');
INSERT INTO sys_role_menu VALUES ('1', '23565');
INSERT INTO sys_role_menu VALUES ('1', '23566');

INSERT INTO sys_role_menu VALUES ('1', '23570');
INSERT INTO sys_role_menu VALUES ('1', '23571');
INSERT INTO sys_role_menu VALUES ('1', '23572');
INSERT INTO sys_role_menu VALUES ('1', '23573');
INSERT INTO sys_role_menu VALUES ('1', '23574');
INSERT INTO sys_role_menu VALUES ('1', '23575');
INSERT INTO sys_role_menu VALUES ('1', '23576');