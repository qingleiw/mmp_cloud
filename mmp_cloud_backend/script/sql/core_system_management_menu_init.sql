-- ----------------------------
-- 核心制度管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建核心制度管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('20500', '核心制度管理', '0', '100', 'coresystem', NULL, '', 1, 0, 'M', '0', '0', '', 'cogs', 100, 1, sysdate(), NULL, NULL, '核心制度管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('20510', '核心制度评估记录', '20500', '10', 'coreSystemAssessmentRecord', 'coresystem/coreSystemAssessmentRecord', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemAssessmentRecord:list', 'clipboard-check', 100, 1, sysdate(), NULL, NULL, '核心制度评估记录');
INSERT INTO sys_menu VALUES ('20520', '核心制度目录', '20500', '20', 'coreSystemCatalog', 'coresystem/coreSystemCatalog', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemCatalog:list', 'list', 100, 1, sysdate(), NULL, NULL, '核心制度目录');
INSERT INTO sys_menu VALUES ('20530', '核心制度配置', '20500', '30', 'coreSystemConfig', 'coresystem/coreSystemConfig', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemConfig:list', 'cog', 100, 1, sysdate(), NULL, NULL, '核心制度配置');
INSERT INTO sys_menu VALUES ('20540', '核心制度执行记录', '20500', '40', 'coreSystemExecutionRecord', 'coresystem/coreSystemExecutionRecord', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemExecutionRecord:list', 'play-circle', 100, 1, sysdate(), NULL, NULL, '核心制度执行记录');
INSERT INTO sys_menu VALUES ('20550', '核心制度指标', '20500', '50', 'coreSystemIndicator', 'coresystem/coreSystemIndicator', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemIndicator:list', 'chart-bar', 100, 1, sysdate(), NULL, NULL, '核心制度指标');
INSERT INTO sys_menu VALUES ('20560', '核心制度检查记录', '20500', '60', 'coreSystemInspectionRecord', 'coresystem/coreSystemInspectionRecord', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemInspectionRecord:list', 'search', 100, 1, sysdate(), NULL, NULL, '核心制度检查记录');
INSERT INTO sys_menu VALUES ('20570', '核心制度整改记录', '20500', '70', 'coreSystemRectificationRecord', 'coresystem/coreSystemRectificationRecord', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemRectificationRecord:list', 'wrench', 100, 1, sysdate(), NULL, NULL, '核心制度整改记录');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 核心制度评估记录按钮
INSERT INTO sys_menu VALUES ('20511', '核心制度评估记录查询', '20510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemAssessmentRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20512', '核心制度评估记录新增', '20510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemAssessmentRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20513', '核心制度评估记录修改', '20510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemAssessmentRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20514', '核心制度评估记录删除', '20510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemAssessmentRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20515', '核心制度评估记录导入', '20510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemAssessmentRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20516', '核心制度评估记录导出', '20510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemAssessmentRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 核心制度目录按钮
INSERT INTO sys_menu VALUES ('20521', '核心制度目录查询', '20520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemCatalog:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20522', '核心制度目录新增', '20520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemCatalog:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20523', '核心制度目录修改', '20520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemCatalog:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20524', '核心制度目录删除', '20520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemCatalog:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20525', '核心制度目录导入', '20520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemCatalog:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20526', '核心制度目录导出', '20520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemCatalog:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 核心制度配置按钮
INSERT INTO sys_menu VALUES ('20531', '核心制度配置查询', '20530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemConfig:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20532', '核心制度配置新增', '20530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemConfig:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20533', '核心制度配置修改', '20530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemConfig:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20534', '核心制度配置删除', '20530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemConfig:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20535', '核心制度配置导入', '20530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemConfig:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20536', '核心制度配置导出', '20530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemConfig:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 核心制度执行记录按钮
INSERT INTO sys_menu VALUES ('20541', '核心制度执行记录查询', '20540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemExecutionRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20542', '核心制度执行记录新增', '20540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemExecutionRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20543', '核心制度执行记录修改', '20540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemExecutionRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20544', '核心制度执行记录删除', '20540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemExecutionRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20545', '核心制度执行记录导入', '20540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemExecutionRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20546', '核心制度执行记录导出', '20540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemExecutionRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 核心制度指标按钮
INSERT INTO sys_menu VALUES ('20551', '核心制度指标查询', '20550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemIndicator:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20552', '核心制度指标新增', '20550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemIndicator:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20553', '核心制度指标修改', '20550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemIndicator:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20554', '核心制度指标删除', '20550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemIndicator:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20555', '核心制度指标导入', '20550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemIndicator:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20556', '核心制度指标导出', '20550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemIndicator:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 核心制度检查记录按钮
INSERT INTO sys_menu VALUES ('20561', '核心制度检查记录查询', '20560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemInspectionRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20562', '核心制度检查记录新增', '20560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemInspectionRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20563', '核心制度检查记录修改', '20560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemInspectionRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20564', '核心制度检查记录删除', '20560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemInspectionRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20565', '核心制度检查记录导入', '20560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemInspectionRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20566', '核心制度检查记录导出', '20560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemInspectionRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 核心制度整改记录按钮
INSERT INTO sys_menu VALUES ('20571', '核心制度整改记录查询', '20570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemRectificationRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20572', '核心制度整改记录新增', '20570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemRectificationRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20573', '核心制度整改记录修改', '20570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemRectificationRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20574', '核心制度整改记录删除', '20570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemRectificationRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20575', '核心制度整改记录导入', '20570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemRectificationRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20576', '核心制度整改记录导出', '20570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:coreSystemRectificationRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '20500');

INSERT INTO sys_role_menu VALUES ('5', '20510');
INSERT INTO sys_role_menu VALUES ('5', '20511');
INSERT INTO sys_role_menu VALUES ('5', '20512');
INSERT INTO sys_role_menu VALUES ('5', '20513');
INSERT INTO sys_role_menu VALUES ('5', '20514');
INSERT INTO sys_role_menu VALUES ('5', '20515');
INSERT INTO sys_role_menu VALUES ('5', '20516');

INSERT INTO sys_role_menu VALUES ('5', '20520');
INSERT INTO sys_role_menu VALUES ('5', '20521');
INSERT INTO sys_role_menu VALUES ('5', '20522');
INSERT INTO sys_role_menu VALUES ('5', '20523');
INSERT INTO sys_role_menu VALUES ('5', '20524');
INSERT INTO sys_role_menu VALUES ('5', '20525');
INSERT INTO sys_role_menu VALUES ('5', '20526');

INSERT INTO sys_role_menu VALUES ('5', '20530');
INSERT INTO sys_role_menu VALUES ('5', '20531');
INSERT INTO sys_role_menu VALUES ('5', '20532');
INSERT INTO sys_role_menu VALUES ('5', '20533');
INSERT INTO sys_role_menu VALUES ('5', '20534');
INSERT INTO sys_role_menu VALUES ('5', '20535');
INSERT INTO sys_role_menu VALUES ('5', '20536');

INSERT INTO sys_role_menu VALUES ('5', '20540');
INSERT INTO sys_role_menu VALUES ('5', '20541');
INSERT INTO sys_role_menu VALUES ('5', '20542');
INSERT INTO sys_role_menu VALUES ('5', '20543');
INSERT INTO sys_role_menu VALUES ('5', '20544');
INSERT INTO sys_role_menu VALUES ('5', '20545');
INSERT INTO sys_role_menu VALUES ('5', '20546');

INSERT INTO sys_role_menu VALUES ('5', '20550');
INSERT INTO sys_role_menu VALUES ('5', '20551');
INSERT INTO sys_role_menu VALUES ('5', '20552');
INSERT INTO sys_role_menu VALUES ('5', '20553');
INSERT INTO sys_role_menu VALUES ('5', '20554');
INSERT INTO sys_role_menu VALUES ('5', '20555');
INSERT INTO sys_role_menu VALUES ('5', '20556');

INSERT INTO sys_role_menu VALUES ('5', '20560');
INSERT INTO sys_role_menu VALUES ('5', '20561');
INSERT INTO sys_role_menu VALUES ('5', '20562');
INSERT INTO sys_role_menu VALUES ('5', '20563');
INSERT INTO sys_role_menu VALUES ('5', '20564');
INSERT INTO sys_role_menu VALUES ('5', '20565');
INSERT INTO sys_role_menu VALUES ('5', '20566');

INSERT INTO sys_role_menu VALUES ('5', '20570');
INSERT INTO sys_role_menu VALUES ('5', '20571');
INSERT INTO sys_role_menu VALUES ('5', '20572');
INSERT INTO sys_role_menu VALUES ('5', '20573');
INSERT INTO sys_role_menu VALUES ('5', '20574');
INSERT INTO sys_role_menu VALUES ('5', '20575');
INSERT INTO sys_role_menu VALUES ('5', '20576');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '20500');

INSERT INTO sys_role_menu VALUES ('6', '20510');
INSERT INTO sys_role_menu VALUES ('6', '20511');
INSERT INTO sys_role_menu VALUES ('6', '20512');
INSERT INTO sys_role_menu VALUES ('6', '20513');
INSERT INTO sys_role_menu VALUES ('6', '20514');
INSERT INTO sys_role_menu VALUES ('6', '20515');
INSERT INTO sys_role_menu VALUES ('6', '20516');

INSERT INTO sys_role_menu VALUES ('6', '20520');
INSERT INTO sys_role_menu VALUES ('6', '20521');
INSERT INTO sys_role_menu VALUES ('6', '20522');
INSERT INTO sys_role_menu VALUES ('6', '20523');
INSERT INTO sys_role_menu VALUES ('6', '20524');
INSERT INTO sys_role_menu VALUES ('6', '20525');
INSERT INTO sys_role_menu VALUES ('6', '20526');

INSERT INTO sys_role_menu VALUES ('6', '20530');
INSERT INTO sys_role_menu VALUES ('6', '20531');
INSERT INTO sys_role_menu VALUES ('6', '20532');
INSERT INTO sys_role_menu VALUES ('6', '20533');
INSERT INTO sys_role_menu VALUES ('6', '20534');
INSERT INTO sys_role_menu VALUES ('6', '20535');
INSERT INTO sys_role_menu VALUES ('6', '20536');

INSERT INTO sys_role_menu VALUES ('6', '20540');
INSERT INTO sys_role_menu VALUES ('6', '20541');
INSERT INTO sys_role_menu VALUES ('6', '20542');
INSERT INTO sys_role_menu VALUES ('6', '20543');
INSERT INTO sys_role_menu VALUES ('6', '20544');
INSERT INTO sys_role_menu VALUES ('6', '20545');
INSERT INTO sys_role_menu VALUES ('6', '20546');

INSERT INTO sys_role_menu VALUES ('6', '20550');
INSERT INTO sys_role_menu VALUES ('6', '20551');
INSERT INTO sys_role_menu VALUES ('6', '20552');
INSERT INTO sys_role_menu VALUES ('6', '20553');
INSERT INTO sys_role_menu VALUES ('6', '20554');
INSERT INTO sys_role_menu VALUES ('6', '20555');
INSERT INTO sys_role_menu VALUES ('6', '20556');

INSERT INTO sys_role_menu VALUES ('6', '20560');
INSERT INTO sys_role_menu VALUES ('6', '20561');
INSERT INTO sys_role_menu VALUES ('6', '20562');
INSERT INTO sys_role_menu VALUES ('6', '20563');
INSERT INTO sys_role_menu VALUES ('6', '20564');
INSERT INTO sys_role_menu VALUES ('6', '20565');
INSERT INTO sys_role_menu VALUES ('6', '20566');

INSERT INTO sys_role_menu VALUES ('6', '20570');
INSERT INTO sys_role_menu VALUES ('6', '20571');
INSERT INTO sys_role_menu VALUES ('6', '20572');
INSERT INTO sys_role_menu VALUES ('6', '20573');
INSERT INTO sys_role_menu VALUES ('6', '20574');
INSERT INTO sys_role_menu VALUES ('6', '20575');
INSERT INTO sys_role_menu VALUES ('6', '20576');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '20500');

INSERT INTO sys_role_menu VALUES ('7', '20510');
INSERT INTO sys_role_menu VALUES ('7', '20511');
INSERT INTO sys_role_menu VALUES ('7', '20512');
INSERT INTO sys_role_menu VALUES ('7', '20513');
INSERT INTO sys_role_menu VALUES ('7', '20514');
INSERT INTO sys_role_menu VALUES ('7', '20515');
INSERT INTO sys_role_menu VALUES ('7', '20516');

INSERT INTO sys_role_menu VALUES ('7', '20520');
INSERT INTO sys_role_menu VALUES ('7', '20521');
INSERT INTO sys_role_menu VALUES ('7', '20522');
INSERT INTO sys_role_menu VALUES ('7', '20523');
INSERT INTO sys_role_menu VALUES ('7', '20524');
INSERT INTO sys_role_menu VALUES ('7', '20525');
INSERT INTO sys_role_menu VALUES ('7', '20526');

INSERT INTO sys_role_menu VALUES ('7', '20530');
INSERT INTO sys_role_menu VALUES ('7', '20531');
INSERT INTO sys_role_menu VALUES ('7', '20532');
INSERT INTO sys_role_menu VALUES ('7', '20533');
INSERT INTO sys_role_menu VALUES ('7', '20534');
INSERT INTO sys_role_menu VALUES ('7', '20535');
INSERT INTO sys_role_menu VALUES ('7', '20536');

INSERT INTO sys_role_menu VALUES ('7', '20540');
INSERT INTO sys_role_menu VALUES ('7', '20541');
INSERT INTO sys_role_menu VALUES ('7', '20542');
INSERT INTO sys_role_menu VALUES ('7', '20543');
INSERT INTO sys_role_menu VALUES ('7', '20544');
INSERT INTO sys_role_menu VALUES ('7', '20545');
INSERT INTO sys_role_menu VALUES ('7', '20546');

INSERT INTO sys_role_menu VALUES ('7', '20550');
INSERT INTO sys_role_menu VALUES ('7', '20551');
INSERT INTO sys_role_menu VALUES ('7', '20552');
INSERT INTO sys_role_menu VALUES ('7', '20553');
INSERT INTO sys_role_menu VALUES ('7', '20554');
INSERT INTO sys_role_menu VALUES ('7', '20555');
INSERT INTO sys_role_menu VALUES ('7', '20556');

INSERT INTO sys_role_menu VALUES ('7', '20560');
INSERT INTO sys_role_menu VALUES ('7', '20561');
INSERT INTO sys_role_menu VALUES ('7', '20562');
INSERT INTO sys_role_menu VALUES ('7', '20563');
INSERT INTO sys_role_menu VALUES ('7', '20564');
INSERT INTO sys_role_menu VALUES ('7', '20565');
INSERT INTO sys_role_menu VALUES ('7', '20566');

INSERT INTO sys_role_menu VALUES ('7', '20570');
INSERT INTO sys_role_menu VALUES ('7', '20571');
INSERT INTO sys_role_menu VALUES ('7', '20572');
INSERT INTO sys_role_menu VALUES ('7', '20573');
INSERT INTO sys_role_menu VALUES ('7', '20574');
INSERT INTO sys_role_menu VALUES ('7', '20575');
INSERT INTO sys_role_menu VALUES ('7', '20576');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '20500');

INSERT INTO sys_role_menu VALUES ('8', '20510');
INSERT INTO sys_role_menu VALUES ('8', '20511');
INSERT INTO sys_role_menu VALUES ('8', '20512');
INSERT INTO sys_role_menu VALUES ('8', '20513');
INSERT INTO sys_role_menu VALUES ('8', '20514');
INSERT INTO sys_role_menu VALUES ('8', '20515');
INSERT INTO sys_role_menu VALUES ('8', '20516');

INSERT INTO sys_role_menu VALUES ('8', '20520');
INSERT INTO sys_role_menu VALUES ('8', '20521');
INSERT INTO sys_role_menu VALUES ('8', '20522');
INSERT INTO sys_role_menu VALUES ('8', '20523');
INSERT INTO sys_role_menu VALUES ('8', '20524');
INSERT INTO sys_role_menu VALUES ('8', '20525');
INSERT INTO sys_role_menu VALUES ('8', '20526');

INSERT INTO sys_role_menu VALUES ('8', '20530');
INSERT INTO sys_role_menu VALUES ('8', '20531');
INSERT INTO sys_role_menu VALUES ('8', '20532');
INSERT INTO sys_role_menu VALUES ('8', '20533');
INSERT INTO sys_role_menu VALUES ('8', '20534');
INSERT INTO sys_role_menu VALUES ('8', '20535');
INSERT INTO sys_role_menu VALUES ('8', '20536');

INSERT INTO sys_role_menu VALUES ('8', '20540');
INSERT INTO sys_role_menu VALUES ('8', '20541');
INSERT INTO sys_role_menu VALUES ('8', '20542');
INSERT INTO sys_role_menu VALUES ('8', '20543');
INSERT INTO sys_role_menu VALUES ('8', '20544');
INSERT INTO sys_role_menu VALUES ('8', '20545');
INSERT INTO sys_role_menu VALUES ('8', '20546');

INSERT INTO sys_role_menu VALUES ('8', '20550');
INSERT INTO sys_role_menu VALUES ('8', '20551');
INSERT INTO sys_role_menu VALUES ('8', '20552');
INSERT INTO sys_role_menu VALUES ('8', '20553');
INSERT INTO sys_role_menu VALUES ('8', '20554');
INSERT INTO sys_role_menu VALUES ('8', '20555');
INSERT INTO sys_role_menu VALUES ('8', '20556');

INSERT INTO sys_role_menu VALUES ('8', '20560');
INSERT INTO sys_role_menu VALUES ('8', '20561');
INSERT INTO sys_role_menu VALUES ('8', '20562');
INSERT INTO sys_role_menu VALUES ('8', '20563');
INSERT INTO sys_role_menu VALUES ('8', '20564');
INSERT INTO sys_role_menu VALUES ('8', '20565');
INSERT INTO sys_role_menu VALUES ('8', '20566');

INSERT INTO sys_role_menu VALUES ('8', '20570');
INSERT INTO sys_role_menu VALUES ('8', '20571');
INSERT INTO sys_role_menu VALUES ('8', '20572');
INSERT INTO sys_role_menu VALUES ('8', '20573');
INSERT INTO sys_role_menu VALUES ('8', '20574');
INSERT INTO sys_role_menu VALUES ('8', '20575');
INSERT INTO sys_role_menu VALUES ('8', '20576');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '20500');

INSERT INTO sys_role_menu VALUES ('9', '20510');
INSERT INTO sys_role_menu VALUES ('9', '20511');
INSERT INTO sys_role_menu VALUES ('9', '20512');
INSERT INTO sys_role_menu VALUES ('9', '20513');
INSERT INTO sys_role_menu VALUES ('9', '20514');
INSERT INTO sys_role_menu VALUES ('9', '20515');
INSERT INTO sys_role_menu VALUES ('9', '20516');

INSERT INTO sys_role_menu VALUES ('9', '20520');
INSERT INTO sys_role_menu VALUES ('9', '20521');
INSERT INTO sys_role_menu VALUES ('9', '20522');
INSERT INTO sys_role_menu VALUES ('9', '20523');
INSERT INTO sys_role_menu VALUES ('9', '20524');
INSERT INTO sys_role_menu VALUES ('9', '20525');
INSERT INTO sys_role_menu VALUES ('9', '20526');

INSERT INTO sys_role_menu VALUES ('9', '20530');
INSERT INTO sys_role_menu VALUES ('9', '20531');
INSERT INTO sys_role_menu VALUES ('9', '20532');
INSERT INTO sys_role_menu VALUES ('9', '20533');
INSERT INTO sys_role_menu VALUES ('9', '20534');
INSERT INTO sys_role_menu VALUES ('9', '20535');
INSERT INTO sys_role_menu VALUES ('9', '20536');

INSERT INTO sys_role_menu VALUES ('9', '20540');
INSERT INTO sys_role_menu VALUES ('9', '20541');
INSERT INTO sys_role_menu VALUES ('9', '20542');
INSERT INTO sys_role_menu VALUES ('9', '20543');
INSERT INTO sys_role_menu VALUES ('9', '20544');
INSERT INTO sys_role_menu VALUES ('9', '20545');
INSERT INTO sys_role_menu VALUES ('9', '20546');

INSERT INTO sys_role_menu VALUES ('9', '20550');
INSERT INTO sys_role_menu VALUES ('9', '20551');
INSERT INTO sys_role_menu VALUES ('9', '20552');
INSERT INTO sys_role_menu VALUES ('9', '20553');
INSERT INTO sys_role_menu VALUES ('9', '20554');
INSERT INTO sys_role_menu VALUES ('9', '20555');
INSERT INTO sys_role_menu VALUES ('9', '20556');

INSERT INTO sys_role_menu VALUES ('9', '20560');
INSERT INTO sys_role_menu VALUES ('9', '20561');
INSERT INTO sys_role_menu VALUES ('9', '20562');
INSERT INTO sys_role_menu VALUES ('9', '20563');
INSERT INTO sys_role_menu VALUES ('9', '20564');
INSERT INTO sys_role_menu VALUES ('9', '20565');
INSERT INTO sys_role_menu VALUES ('9', '20566');

INSERT INTO sys_role_menu VALUES ('9', '20570');
INSERT INTO sys_role_menu VALUES ('9', '20571');
INSERT INTO sys_role_menu VALUES ('9', '20572');
INSERT INTO sys_role_menu VALUES ('9', '20573');
INSERT INTO sys_role_menu VALUES ('9', '20574');
INSERT INTO sys_role_menu VALUES ('9', '20575');
INSERT INTO sys_role_menu VALUES ('9', '20576');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '20500');

INSERT INTO sys_role_menu VALUES ('10', '20510');
INSERT INTO sys_role_menu VALUES ('10', '20511');
INSERT INTO sys_role_menu VALUES ('10', '20512');
INSERT INTO sys_role_menu VALUES ('10', '20513');
INSERT INTO sys_role_menu VALUES ('10', '20514');
INSERT INTO sys_role_menu VALUES ('10', '20515');
INSERT INTO sys_role_menu VALUES ('10', '20516');

INSERT INTO sys_role_menu VALUES ('10', '20520');
INSERT INTO sys_role_menu VALUES ('10', '20521');
INSERT INTO sys_role_menu VALUES ('10', '20522');
INSERT INTO sys_role_menu VALUES ('10', '20523');
INSERT INTO sys_role_menu VALUES ('10', '20524');
INSERT INTO sys_role_menu VALUES ('10', '20525');
INSERT INTO sys_role_menu VALUES ('10', '20526');

INSERT INTO sys_role_menu VALUES ('10', '20530');
INSERT INTO sys_role_menu VALUES ('10', '20531');
INSERT INTO sys_role_menu VALUES ('10', '20532');
INSERT INTO sys_role_menu VALUES ('10', '20533');
INSERT INTO sys_role_menu VALUES ('10', '20534');
INSERT INTO sys_role_menu VALUES ('10', '20535');
INSERT INTO sys_role_menu VALUES ('10', '20536');

INSERT INTO sys_role_menu VALUES ('10', '20540');
INSERT INTO sys_role_menu VALUES ('10', '20541');
INSERT INTO sys_role_menu VALUES ('10', '20542');
INSERT INTO sys_role_menu VALUES ('10', '20543');
INSERT INTO sys_role_menu VALUES ('10', '20544');
INSERT INTO sys_role_menu VALUES ('10', '20545');
INSERT INTO sys_role_menu VALUES ('10', '20546');

INSERT INTO sys_role_menu VALUES ('10', '20550');
INSERT INTO sys_role_menu VALUES ('10', '20551');
INSERT INTO sys_role_menu VALUES ('10', '20552');
INSERT INTO sys_role_menu VALUES ('10', '20553');
INSERT INTO sys_role_menu VALUES ('10', '20554');
INSERT INTO sys_role_menu VALUES ('10', '20555');
INSERT INTO sys_role_menu VALUES ('10', '20556');

INSERT INTO sys_role_menu VALUES ('10', '20560');
INSERT INTO sys_role_menu VALUES ('10', '20561');
INSERT INTO sys_role_menu VALUES ('10', '20562');
INSERT INTO sys_role_menu VALUES ('10', '20563');
INSERT INTO sys_role_menu VALUES ('10', '20564');
INSERT INTO sys_role_menu VALUES ('10', '20565');
INSERT INTO sys_role_menu VALUES ('10', '20566');

INSERT INTO sys_role_menu VALUES ('10', '20570');
INSERT INTO sys_role_menu VALUES ('10', '20571');
INSERT INTO sys_role_menu VALUES ('10', '20572');
INSERT INTO sys_role_menu VALUES ('10', '20573');
INSERT INTO sys_role_menu VALUES ('10', '20574');
INSERT INTO sys_role_menu VALUES ('10', '20575');
INSERT INTO sys_role_menu VALUES ('10', '20576');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '20500');

INSERT INTO sys_role_menu VALUES ('11', '20510');
INSERT INTO sys_role_menu VALUES ('11', '20511');
INSERT INTO sys_role_menu VALUES ('11', '20512');
INSERT INTO sys_role_menu VALUES ('11', '20513');
INSERT INTO sys_role_menu VALUES ('11', '20514');
INSERT INTO sys_role_menu VALUES ('11', '20515');
INSERT INTO sys_role_menu VALUES ('11', '20516');

INSERT INTO sys_role_menu VALUES ('11', '20520');
INSERT INTO sys_role_menu VALUES ('11', '20521');
INSERT INTO sys_role_menu VALUES ('11', '20522');
INSERT INTO sys_role_menu VALUES ('11', '20523');
INSERT INTO sys_role_menu VALUES ('11', '20524');
INSERT INTO sys_role_menu VALUES ('11', '20525');
INSERT INTO sys_role_menu VALUES ('11', '20526');

INSERT INTO sys_role_menu VALUES ('11', '20530');
INSERT INTO sys_role_menu VALUES ('11', '20531');
INSERT INTO sys_role_menu VALUES ('11', '20532');
INSERT INTO sys_role_menu VALUES ('11', '20533');
INSERT INTO sys_role_menu VALUES ('11', '20534');
INSERT INTO sys_role_menu VALUES ('11', '20535');
INSERT INTO sys_role_menu VALUES ('11', '20536');

INSERT INTO sys_role_menu VALUES ('11', '20540');
INSERT INTO sys_role_menu VALUES ('11', '20541');
INSERT INTO sys_role_menu VALUES ('11', '20542');
INSERT INTO sys_role_menu VALUES ('11', '20543');
INSERT INTO sys_role_menu VALUES ('11', '20544');
INSERT INTO sys_role_menu VALUES ('11', '20545');
INSERT INTO sys_role_menu VALUES ('11', '20546');

INSERT INTO sys_role_menu VALUES ('11', '20550');
INSERT INTO sys_role_menu VALUES ('11', '20551');
INSERT INTO sys_role_menu VALUES ('11', '20552');
INSERT INTO sys_role_menu VALUES ('11', '20553');
INSERT INTO sys_role_menu VALUES ('11', '20554');
INSERT INTO sys_role_menu VALUES ('11', '20555');
INSERT INTO sys_role_menu VALUES ('11', '20556');

INSERT INTO sys_role_menu VALUES ('11', '20560');
INSERT INTO sys_role_menu VALUES ('11', '20561');
INSERT INTO sys_role_menu VALUES ('11', '20562');
INSERT INTO sys_role_menu VALUES ('11', '20563');
INSERT INTO sys_role_menu VALUES ('11', '20564');
INSERT INTO sys_role_menu VALUES ('11', '20565');
INSERT INTO sys_role_menu VALUES ('11', '20566');

INSERT INTO sys_role_menu VALUES ('11', '20570');
INSERT INTO sys_role_menu VALUES ('11', '20571');
INSERT INTO sys_role_menu VALUES ('11', '20572');
INSERT INTO sys_role_menu VALUES ('11', '20573');
INSERT INTO sys_role_menu VALUES ('11', '20574');
INSERT INTO sys_role_menu VALUES ('11', '20575');
INSERT INTO sys_role_menu VALUES ('11', '20576');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '20500');

INSERT INTO sys_role_menu VALUES ('1', '20510');
INSERT INTO sys_role_menu VALUES ('1', '20511');
INSERT INTO sys_role_menu VALUES ('1', '20512');
INSERT INTO sys_role_menu VALUES ('1', '20513');
INSERT INTO sys_role_menu VALUES ('1', '20514');
INSERT INTO sys_role_menu VALUES ('1', '20515');
INSERT INTO sys_role_menu VALUES ('1', '20516');

INSERT INTO sys_role_menu VALUES ('1', '20520');
INSERT INTO sys_role_menu VALUES ('1', '20521');
INSERT INTO sys_role_menu VALUES ('1', '20522');
INSERT INTO sys_role_menu VALUES ('1', '20523');
INSERT INTO sys_role_menu VALUES ('1', '20524');
INSERT INTO sys_role_menu VALUES ('1', '20525');
INSERT INTO sys_role_menu VALUES ('1', '20526');

INSERT INTO sys_role_menu VALUES ('1', '20530');
INSERT INTO sys_role_menu VALUES ('1', '20531');
INSERT INTO sys_role_menu VALUES ('1', '20532');
INSERT INTO sys_role_menu VALUES ('1', '20533');
INSERT INTO sys_role_menu VALUES ('1', '20534');
INSERT INTO sys_role_menu VALUES ('1', '20535');
INSERT INTO sys_role_menu VALUES ('1', '20536');

INSERT INTO sys_role_menu VALUES ('1', '20540');
INSERT INTO sys_role_menu VALUES ('1', '20541');
INSERT INTO sys_role_menu VALUES ('1', '20542');
INSERT INTO sys_role_menu VALUES ('1', '20543');
INSERT INTO sys_role_menu VALUES ('1', '20544');
INSERT INTO sys_role_menu VALUES ('1', '20545');
INSERT INTO sys_role_menu VALUES ('1', '20546');

INSERT INTO sys_role_menu VALUES ('1', '20550');
INSERT INTO sys_role_menu VALUES ('1', '20551');
INSERT INTO sys_role_menu VALUES ('1', '20552');
INSERT INTO sys_role_menu VALUES ('1', '20553');
INSERT INTO sys_role_menu VALUES ('1', '20554');
INSERT INTO sys_role_menu VALUES ('1', '20555');
INSERT INTO sys_role_menu VALUES ('1', '20556');

INSERT INTO sys_role_menu VALUES ('1', '20560');
INSERT INTO sys_role_menu VALUES ('1', '20561');
INSERT INTO sys_role_menu VALUES ('1', '20562');
INSERT INTO sys_role_menu VALUES ('1', '20563');
INSERT INTO sys_role_menu VALUES ('1', '20564');
INSERT INTO sys_role_menu VALUES ('1', '20565');
INSERT INTO sys_role_menu VALUES ('1', '20566');

INSERT INTO sys_role_menu VALUES ('1', '20570');
INSERT INTO sys_role_menu VALUES ('1', '20571');
INSERT INTO sys_role_menu VALUES ('1', '20572');
INSERT INTO sys_role_menu VALUES ('1', '20573');
INSERT INTO sys_role_menu VALUES ('1', '20574');
INSERT INTO sys_role_menu VALUES ('1', '20575');
INSERT INTO sys_role_menu VALUES ('1', '20576');