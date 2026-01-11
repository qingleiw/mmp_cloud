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
INSERT INTO sys_menu VALUES ('20510', '核心制度评估记录', '20500', '10', 'coreSystemAssessmentRecord', 'coresystem/coreSystemAssessmentRecord/index', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemAssessmentRecord:list', 'clipboard-check', 100, 1, sysdate(), NULL, NULL, '核心制度评估记录');
INSERT INTO sys_menu VALUES ('20520', '核心制度目录', '20500', '20', 'coreSystemCatalog', 'coresystem/coreSystemCatalog/index', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemCatalog:list', 'list', 100, 1, sysdate(), NULL, NULL, '核心制度目录');
INSERT INTO sys_menu VALUES ('20530', '核心制度配置', '20500', '30', 'coreSystemConfig', 'coresystem/coreSystemConfig/index', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemConfig:list', 'cog', 100, 1, sysdate(), NULL, NULL, '核心制度配置');
INSERT INTO sys_menu VALUES ('20540', '核心制度执行记录', '20500', '40', 'coreSystemExecutionRecord', 'coresystem/coreSystemExecutionRecord/index', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemExecutionRecord:list', 'play-circle', 100, 1, sysdate(), NULL, NULL, '核心制度执行记录');
INSERT INTO sys_menu VALUES ('20550', '核心制度指标', '20500', '50', 'coreSystemIndicator', 'coresystem/coreSystemIndicator/index', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemIndicator:list', 'chart-bar', 100, 1, sysdate(), NULL, NULL, '核心制度指标');
INSERT INTO sys_menu VALUES ('20560', '核心制度检查记录', '20500', '60', 'coreSystemInspectionRecord', 'coresystem/coreSystemInspectionRecord/index', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemInspectionRecord:list', 'search', 100, 1, sysdate(), NULL, NULL, '核心制度检查记录');
INSERT INTO sys_menu VALUES ('20570', '核心制度整改记录', '20500', '70', 'coreSystemRectificationRecord', 'coresystem/coreSystemRectificationRecord/index', '', 1, 0, 'C', '0', '0', 'coresystem:coreSystemRectificationRecord:list', 'wrench', 100, 1, sysdate(), NULL, NULL, '核心制度整改记录');
INSERT INTO sys_menu VALUES ('20580', '台账业务学习', '20500', '80', 'ledgerBusinessLearning', 'coresystem/ledgerBusinessLearning/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerBusinessLearning:list', 'book-open', 100, 1, sysdate(), NULL, NULL, '台账业务学习');
INSERT INTO sys_menu VALUES ('20590', '台账危重患者', '20500', '90', 'ledgerCriticalPatient', 'coresystem/ledgerCriticalPatient/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerCriticalPatient:list', 'user-injured', 100, 1, sysdate(), NULL, NULL, '台账危重患者');
INSERT INTO sys_menu VALUES ('20600', '台账长期住院患者', '20500', '100', 'ledgerLongStayPatient', 'coresystem/ledgerLongStayPatient/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerLongStayPatient:list', 'bed', 100, 1, sysdate(), NULL, NULL, '台账长期住院患者');
INSERT INTO sys_menu VALUES ('20610', '台账重大手术', '20500', '110', 'ledgerMajorSurgery', 'coresystem/ledgerMajorSurgery/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerMajorSurgery:list', 'syringe', 100, 1, sysdate(), NULL, NULL, '台账重大手术');
INSERT INTO sys_menu VALUES ('20620', '台账患者全周期', '20500', '120', 'ledgerPatientFullCycle', 'coresystem/ledgerPatientFullCycle/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerPatientFullCycle:list', 'route', 100, 1, sysdate(), NULL, NULL, '台账患者全周期');
INSERT INTO sys_menu VALUES ('20630', '台账非计划再手术', '20500', '130', 'ledgerUnplannedReoperation', 'coresystem/ledgerUnplannedReoperation/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerUnplannedReoperation:list', 'redo', 100, 1, sysdate(), NULL, NULL, '台账非计划再手术');

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

-- 台账业务学习按钮
INSERT INTO sys_menu VALUES ('20581', '台账业务学习查询', '20580', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20582', '台账业务学习新增', '20580', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20583', '台账业务学习修改', '20580', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20584', '台账业务学习删除', '20580', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20585', '台账业务学习导入', '20580', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20586', '台账业务学习导出', '20580', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账危重患者按钮
INSERT INTO sys_menu VALUES ('20591', '台账危重患者查询', '20590', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20592', '台账危重患者新增', '20590', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20593', '台账危重患者修改', '20590', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20594', '台账危重患者删除', '20590', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20595', '台账危重患者导入', '20590', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20596', '台账危重患者导出', '20590', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账长期住院患者按钮
INSERT INTO sys_menu VALUES ('20601', '台账长期住院患者查询', '20600', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20602', '台账长期住院患者新增', '20600', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20603', '台账长期住院患者修改', '20600', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20604', '台账长期住院患者删除', '20600', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20605', '台账长期住院患者导入', '20600', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20606', '台账长期住院患者导出', '20600', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账重大手术按钮
INSERT INTO sys_menu VALUES ('20611', '台账重大手术查询', '20610', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20612', '台账重大手术新增', '20610', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20613', '台账重大手术修改', '20610', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20614', '台账重大手术删除', '20610', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20615', '台账重大手术导入', '20610', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20616', '台账重大手术导出', '20610', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账患者全周期按钮
INSERT INTO sys_menu VALUES ('20621', '台账患者全周期查询', '20620', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20622', '台账患者全周期新增', '20620', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20623', '台账患者全周期修改', '20620', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20624', '台账患者全周期删除', '20620', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20625', '台账患者全周期导入', '20620', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20626', '台账患者全周期导出', '20620', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账非计划再手术按钮
INSERT INTO sys_menu VALUES ('20631', '台账非计划再手术查询', '20630', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20632', '台账非计划再手术新增', '20630', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20633', '台账非计划再手术修改', '20630', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20634', '台账非计划再手术删除', '20630', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20635', '台账非计划再手术导入', '20630', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20636', '台账非计划再手术导出', '20630', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:export', '#', 100, 1, sysdate(), NULL, NULL, '');