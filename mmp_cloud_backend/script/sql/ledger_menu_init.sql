-- ----------------------------
-- 台账管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建台账管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25500', '台账管理', '0', '110', 'ledger', NULL, '', 1, 0, 'M', '0', '0', '', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '台账管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25510', '台账业务学习', '25500', '10', 'ledgerBusinessLearning', 'coresystem/ledgerBusinessLearning/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerBusinessLearning:list', 'book-open', 100, 1, sysdate(), NULL, NULL, '台账业务学习');
INSERT INTO sys_menu VALUES ('25520', '台账危重患者', '25500', '20', 'ledgerCriticalPatient', 'coresystem/ledgerCriticalPatient/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerCriticalPatient:list', 'user-injured', 100, 1, sysdate(), NULL, NULL, '台账危重患者');
INSERT INTO sys_menu VALUES ('25530', '台账长期住院患者', '25500', '30', 'ledgerLongStayPatient', 'coresystem/ledgerLongStayPatient/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerLongStayPatient:list', 'bed', 100, 1, sysdate(), NULL, NULL, '台账长期住院患者');
INSERT INTO sys_menu VALUES ('25540', '台账重大手术', '25500', '40', 'ledgerMajorSurgery', 'coresystem/ledgerMajorSurgery/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerMajorSurgery:list', 'syringe', 100, 1, sysdate(), NULL, NULL, '台账重大手术');
INSERT INTO sys_menu VALUES ('25550', '台账患者全周期', '25500', '50', 'ledgerPatientFullCycle', 'coresystem/ledgerPatientFullCycle/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerPatientFullCycle:list', 'route', 100, 1, sysdate(), NULL, NULL, '台账患者全周期');
INSERT INTO sys_menu VALUES ('25560', '台账非计划再手术', '25500', '60', 'ledgerUnplannedReoperation', 'coresystem/ledgerUnplannedReoperation/index', '', 1, 0, 'C', '0', '0', 'coresystem:ledgerUnplannedReoperation:list', 'redo', 100, 1, sysdate(), NULL, NULL, '台账非计划再手术');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 台账业务学习按钮
INSERT INTO sys_menu VALUES ('25511', '台账业务学习查询', '25510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25512', '台账业务学习新增', '25510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25513', '台账业务学习修改', '25510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25514', '台账业务学习删除', '25510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25515', '台账业务学习导入', '25510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25516', '台账业务学习导出', '25510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerBusinessLearning:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账危重患者按钮
INSERT INTO sys_menu VALUES ('25521', '台账危重患者查询', '25520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25522', '台账危重患者新增', '25520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25523', '台账危重患者修改', '25520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25524', '台账危重患者删除', '25520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25525', '台账危重患者导入', '25520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25526', '台账危重患者导出', '25520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerCriticalPatient:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账长期住院患者按钮
INSERT INTO sys_menu VALUES ('25531', '台账长期住院患者查询', '25530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25532', '台账长期住院患者新增', '25530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25533', '台账长期住院患者修改', '25530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25534', '台账长期住院患者删除', '25530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25535', '台账长期住院患者导入', '25530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25536', '台账长期住院患者导出', '25530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerLongStayPatient:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账重大手术按钮
INSERT INTO sys_menu VALUES ('25541', '台账重大手术查询', '25540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25542', '台账重大手术新增', '25540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25543', '台账重大手术修改', '25540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25544', '台账重大手术删除', '25540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25545', '台账重大手术导入', '25540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25546', '台账重大手术导出', '25540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerMajorSurgery:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账患者全周期按钮
INSERT INTO sys_menu VALUES ('25551', '台账患者全周期查询', '25550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25552', '台账患者全周期新增', '25550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25553', '台账患者全周期修改', '25550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25554', '台账患者全周期删除', '25550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25555', '台账患者全周期导入', '25550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25556', '台账患者全周期导出', '25550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerPatientFullCycle:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 台账非计划再手术按钮
INSERT INTO sys_menu VALUES ('25561', '台账非计划再手术查询', '25560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25562', '台账非计划再手术新增', '25560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25563', '台账非计划再手术修改', '25560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25564', '台账非计划再手术删除', '25560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25565', '台账非计划再手术导入', '25560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25566', '台账非计划再手术导出', '25560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'coresystem:ledgerUnplannedReoperation:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '25500');

INSERT INTO sys_role_menu VALUES ('5', '25510');
INSERT INTO sys_role_menu VALUES ('5', '25511');
INSERT INTO sys_role_menu VALUES ('5', '25512');
INSERT INTO sys_role_menu VALUES ('5', '25513');
INSERT INTO sys_role_menu VALUES ('5', '25514');
INSERT INTO sys_role_menu VALUES ('5', '25515');
INSERT INTO sys_role_menu VALUES ('5', '25516');

INSERT INTO sys_role_menu VALUES ('5', '25520');
INSERT INTO sys_role_menu VALUES ('5', '25521');
INSERT INTO sys_role_menu VALUES ('5', '25522');
INSERT INTO sys_role_menu VALUES ('5', '25523');
INSERT INTO sys_role_menu VALUES ('5', '25524');
INSERT INTO sys_role_menu VALUES ('5', '25525');
INSERT INTO sys_role_menu VALUES ('5', '25526');

INSERT INTO sys_role_menu VALUES ('5', '25530');
INSERT INTO sys_role_menu VALUES ('5', '25531');
INSERT INTO sys_role_menu VALUES ('5', '25532');
INSERT INTO sys_role_menu VALUES ('5', '25533');
INSERT INTO sys_role_menu VALUES ('5', '25534');
INSERT INTO sys_role_menu VALUES ('5', '25535');
INSERT INTO sys_role_menu VALUES ('5', '25536');

INSERT INTO sys_role_menu VALUES ('5', '25540');
INSERT INTO sys_role_menu VALUES ('5', '25541');
INSERT INTO sys_role_menu VALUES ('5', '25542');
INSERT INTO sys_role_menu VALUES ('5', '25543');
INSERT INTO sys_role_menu VALUES ('5', '25544');
INSERT INTO sys_role_menu VALUES ('5', '25545');
INSERT INTO sys_role_menu VALUES ('5', '25546');

INSERT INTO sys_role_menu VALUES ('5', '25550');
INSERT INTO sys_role_menu VALUES ('5', '25551');
INSERT INTO sys_role_menu VALUES ('5', '25552');
INSERT INTO sys_role_menu VALUES ('5', '25553');
INSERT INTO sys_role_menu VALUES ('5', '25554');
INSERT INTO sys_role_menu VALUES ('5', '25555');
INSERT INTO sys_role_menu VALUES ('5', '25556');

INSERT INTO sys_role_menu VALUES ('5', '25560');
INSERT INTO sys_role_menu VALUES ('5', '25561');
INSERT INTO sys_role_menu VALUES ('5', '25562');
INSERT INTO sys_role_menu VALUES ('5', '25563');
INSERT INTO sys_role_menu VALUES ('5', '25564');
INSERT INTO sys_role_menu VALUES ('5', '25565');
INSERT INTO sys_role_menu VALUES ('5', '25566');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '25500');

INSERT INTO sys_role_menu VALUES ('6', '25510');
INSERT INTO sys_role_menu VALUES ('6', '25511');
INSERT INTO sys_role_menu VALUES ('6', '25512');
INSERT INTO sys_role_menu VALUES ('6', '25513');
INSERT INTO sys_role_menu VALUES ('6', '25514');
INSERT INTO sys_role_menu VALUES ('6', '25515');
INSERT INTO sys_role_menu VALUES ('6', '25516');

INSERT INTO sys_role_menu VALUES ('6', '25520');
INSERT INTO sys_role_menu VALUES ('6', '25521');
INSERT INTO sys_role_menu VALUES ('6', '25522');
INSERT INTO sys_role_menu VALUES ('6', '25523');
INSERT INTO sys_role_menu VALUES ('6', '25524');
INSERT INTO sys_role_menu VALUES ('6', '25525');
INSERT INTO sys_role_menu VALUES ('6', '25526');

INSERT INTO sys_role_menu VALUES ('6', '25530');
INSERT INTO sys_role_menu VALUES ('6', '25531');
INSERT INTO sys_role_menu VALUES ('6', '25532');
INSERT INTO sys_role_menu VALUES ('6', '25533');
INSERT INTO sys_role_menu VALUES ('6', '25534');
INSERT INTO sys_role_menu VALUES ('6', '25535');
INSERT INTO sys_role_menu VALUES ('6', '25536');

INSERT INTO sys_role_menu VALUES ('6', '25540');
INSERT INTO sys_role_menu VALUES ('6', '25541');
INSERT INTO sys_role_menu VALUES ('6', '25542');
INSERT INTO sys_role_menu VALUES ('6', '25543');
INSERT INTO sys_role_menu VALUES ('6', '25544');
INSERT INTO sys_role_menu VALUES ('6', '25545');
INSERT INTO sys_role_menu VALUES ('6', '25546');

INSERT INTO sys_role_menu VALUES ('6', '25550');
INSERT INTO sys_role_menu VALUES ('6', '25551');
INSERT INTO sys_role_menu VALUES ('6', '25552');
INSERT INTO sys_role_menu VALUES ('6', '25553');
INSERT INTO sys_role_menu VALUES ('6', '25554');
INSERT INTO sys_role_menu VALUES ('6', '25555');
INSERT INTO sys_role_menu VALUES ('6', '25556');

INSERT INTO sys_role_menu VALUES ('6', '25560');
INSERT INTO sys_role_menu VALUES ('6', '25561');
INSERT INTO sys_role_menu VALUES ('6', '25562');
INSERT INTO sys_role_menu VALUES ('6', '25563');
INSERT INTO sys_role_menu VALUES ('6', '25564');
INSERT INTO sys_role_menu VALUES ('6', '25565');
INSERT INTO sys_role_menu VALUES ('6', '25566');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '25500');

INSERT INTO sys_role_menu VALUES ('7', '25510');
INSERT INTO sys_role_menu VALUES ('7', '25511');
INSERT INTO sys_role_menu VALUES ('7', '25512');
INSERT INTO sys_role_menu VALUES ('7', '25513');
INSERT INTO sys_role_menu VALUES ('7', '25514');
INSERT INTO sys_role_menu VALUES ('7', '25515');
INSERT INTO sys_role_menu VALUES ('7', '25516');

INSERT INTO sys_role_menu VALUES ('7', '25520');
INSERT INTO sys_role_menu VALUES ('7', '25521');
INSERT INTO sys_role_menu VALUES ('7', '25522');
INSERT INTO sys_role_menu VALUES ('7', '25523');
INSERT INTO sys_role_menu VALUES ('7', '25524');
INSERT INTO sys_role_menu VALUES ('7', '25525');
INSERT INTO sys_role_menu VALUES ('7', '25526');

INSERT INTO sys_role_menu VALUES ('7', '25530');
INSERT INTO sys_role_menu VALUES ('7', '25531');
INSERT INTO sys_role_menu VALUES ('7', '25532');
INSERT INTO sys_role_menu VALUES ('7', '25533');
INSERT INTO sys_role_menu VALUES ('7', '25534');
INSERT INTO sys_role_menu VALUES ('7', '25535');
INSERT INTO sys_role_menu VALUES ('7', '25536');

INSERT INTO sys_role_menu VALUES ('7', '25540');
INSERT INTO sys_role_menu VALUES ('7', '25541');
INSERT INTO sys_role_menu VALUES ('7', '25542');
INSERT INTO sys_role_menu VALUES ('7', '25543');
INSERT INTO sys_role_menu VALUES ('7', '25544');
INSERT INTO sys_role_menu VALUES ('7', '25545');
INSERT INTO sys_role_menu VALUES ('7', '25546');

INSERT INTO sys_role_menu VALUES ('7', '25550');
INSERT INTO sys_role_menu VALUES ('7', '25551');
INSERT INTO sys_role_menu VALUES ('7', '25552');
INSERT INTO sys_role_menu VALUES ('7', '25553');
INSERT INTO sys_role_menu VALUES ('7', '25554');
INSERT INTO sys_role_menu VALUES ('7', '25555');
INSERT INTO sys_role_menu VALUES ('7', '25556');

INSERT INTO sys_role_menu VALUES ('7', '25560');
INSERT INTO sys_role_menu VALUES ('7', '25561');
INSERT INTO sys_role_menu VALUES ('7', '25562');
INSERT INTO sys_role_menu VALUES ('7', '25563');
INSERT INTO sys_role_menu VALUES ('7', '25564');
INSERT INTO sys_role_menu VALUES ('7', '25565');
INSERT INTO sys_role_menu VALUES ('7', '25566');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '25500');

INSERT INTO sys_role_menu VALUES ('8', '25510');
INSERT INTO sys_role_menu VALUES ('8', '25511');
INSERT INTO sys_role_menu VALUES ('8', '25512');
INSERT INTO sys_role_menu VALUES ('8', '25513');
INSERT INTO sys_role_menu VALUES ('8', '25514');
INSERT INTO sys_role_menu VALUES ('8', '25515');
INSERT INTO sys_role_menu VALUES ('8', '25516');

INSERT INTO sys_role_menu VALUES ('8', '25520');
INSERT INTO sys_role_menu VALUES ('8', '25521');
INSERT INTO sys_role_menu VALUES ('8', '25522');
INSERT INTO sys_role_menu VALUES ('8', '25523');
INSERT INTO sys_role_menu VALUES ('8', '25524');
INSERT INTO sys_role_menu VALUES ('8', '25525');
INSERT INTO sys_role_menu VALUES ('8', '25526');

INSERT INTO sys_role_menu VALUES ('8', '25530');
INSERT INTO sys_role_menu VALUES ('8', '25531');
INSERT INTO sys_role_menu VALUES ('8', '25532');
INSERT INTO sys_role_menu VALUES ('8', '25533');
INSERT INTO sys_role_menu VALUES ('8', '25534');
INSERT INTO sys_role_menu VALUES ('8', '25535');
INSERT INTO sys_role_menu VALUES ('8', '25536');

INSERT INTO sys_role_menu VALUES ('8', '25540');
INSERT INTO sys_role_menu VALUES ('8', '25541');
INSERT INTO sys_role_menu VALUES ('8', '25542');
INSERT INTO sys_role_menu VALUES ('8', '25543');
INSERT INTO sys_role_menu VALUES ('8', '25544');
INSERT INTO sys_role_menu VALUES ('8', '25545');
INSERT INTO sys_role_menu VALUES ('8', '25546');

INSERT INTO sys_role_menu VALUES ('8', '25550');
INSERT INTO sys_role_menu VALUES ('8', '25551');
INSERT INTO sys_role_menu VALUES ('8', '25552');
INSERT INTO sys_role_menu VALUES ('8', '25553');
INSERT INTO sys_role_menu VALUES ('8', '25554');
INSERT INTO sys_role_menu VALUES ('8', '25555');
INSERT INTO sys_role_menu VALUES ('8', '25556');

INSERT INTO sys_role_menu VALUES ('8', '25560');
INSERT INTO sys_role_menu VALUES ('8', '25561');
INSERT INTO sys_role_menu VALUES ('8', '25562');
INSERT INTO sys_role_menu VALUES ('8', '25563');
INSERT INTO sys_role_menu VALUES ('8', '25564');
INSERT INTO sys_role_menu VALUES ('8', '25565');
INSERT INTO sys_role_menu VALUES ('8', '25566');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '25500');

INSERT INTO sys_role_menu VALUES ('9', '25510');
INSERT INTO sys_role_menu VALUES ('9', '25511');
INSERT INTO sys_role_menu VALUES ('9', '25512');
INSERT INTO sys_role_menu VALUES ('9', '25513');
INSERT INTO sys_role_menu VALUES ('9', '25514');
INSERT INTO sys_role_menu VALUES ('9', '25515');
INSERT INTO sys_role_menu VALUES ('9', '25516');

INSERT INTO sys_role_menu VALUES ('9', '25520');
INSERT INTO sys_role_menu VALUES ('9', '25521');
INSERT INTO sys_role_menu VALUES ('9', '25522');
INSERT INTO sys_role_menu VALUES ('9', '25523');
INSERT INTO sys_role_menu VALUES ('9', '25524');
INSERT INTO sys_role_menu VALUES ('9', '25525');
INSERT INTO sys_role_menu VALUES ('9', '25526');

INSERT INTO sys_role_menu VALUES ('9', '25530');
INSERT INTO sys_role_menu VALUES ('9', '25531');
INSERT INTO sys_role_menu VALUES ('9', '25532');
INSERT INTO sys_role_menu VALUES ('9', '25533');
INSERT INTO sys_role_menu VALUES ('9', '25534');
INSERT INTO sys_role_menu VALUES ('9', '25535');
INSERT INTO sys_role_menu VALUES ('9', '25536');

INSERT INTO sys_role_menu VALUES ('9', '25540');
INSERT INTO sys_role_menu VALUES ('9', '25541');
INSERT INTO sys_role_menu VALUES ('9', '25542');
INSERT INTO sys_role_menu VALUES ('9', '25543');
INSERT INTO sys_role_menu VALUES ('9', '25544');
INSERT INTO sys_role_menu VALUES ('9', '25545');
INSERT INTO sys_role_menu VALUES ('9', '25546');

INSERT INTO sys_role_menu VALUES ('9', '25550');
INSERT INTO sys_role_menu VALUES ('9', '25551');
INSERT INTO sys_role_menu VALUES ('9', '25552');
INSERT INTO sys_role_menu VALUES ('9', '25553');
INSERT INTO sys_role_menu VALUES ('9', '25554');
INSERT INTO sys_role_menu VALUES ('9', '25555');
INSERT INTO sys_role_menu VALUES ('9', '25556');

INSERT INTO sys_role_menu VALUES ('9', '25560');
INSERT INTO sys_role_menu VALUES ('9', '25561');
INSERT INTO sys_role_menu VALUES ('9', '25562');
INSERT INTO sys_role_menu VALUES ('9', '25563');
INSERT INTO sys_role_menu VALUES ('9', '25564');
INSERT INTO sys_role_menu VALUES ('9', '25565');
INSERT INTO sys_role_menu VALUES ('9', '25566');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '25500');

INSERT INTO sys_role_menu VALUES ('10', '25510');
INSERT INTO sys_role_menu VALUES ('10', '25511');
INSERT INTO sys_role_menu VALUES ('10', '25512');
INSERT INTO sys_role_menu VALUES ('10', '25513');
INSERT INTO sys_role_menu VALUES ('10', '25514');
INSERT INTO sys_role_menu VALUES ('10', '25515');
INSERT INTO sys_role_menu VALUES ('10', '25516');

INSERT INTO sys_role_menu VALUES ('10', '25520');
INSERT INTO sys_role_menu VALUES ('10', '25521');
INSERT INTO sys_role_menu VALUES ('10', '25522');
INSERT INTO sys_role_menu VALUES ('10', '25523');
INSERT INTO sys_role_menu VALUES ('10', '25524');
INSERT INTO sys_role_menu VALUES ('10', '25525');
INSERT INTO sys_role_menu VALUES ('10', '25526');

INSERT INTO sys_role_menu VALUES ('10', '25530');
INSERT INTO sys_role_menu VALUES ('10', '25531');
INSERT INTO sys_role_menu VALUES ('10', '25532');
INSERT INTO sys_role_menu VALUES ('10', '25533');
INSERT INTO sys_role_menu VALUES ('10', '25534');
INSERT INTO sys_role_menu VALUES ('10', '25535');
INSERT INTO sys_role_menu VALUES ('10', '25536');

INSERT INTO sys_role_menu VALUES ('10', '25540');
INSERT INTO sys_role_menu VALUES ('10', '25541');
INSERT INTO sys_role_menu VALUES ('10', '25542');
INSERT INTO sys_role_menu VALUES ('10', '25543');
INSERT INTO sys_role_menu VALUES ('10', '25544');
INSERT INTO sys_role_menu VALUES ('10', '25545');
INSERT INTO sys_role_menu VALUES ('10', '25546');

INSERT INTO sys_role_menu VALUES ('10', '25550');
INSERT INTO sys_role_menu VALUES ('10', '25551');
INSERT INTO sys_role_menu VALUES ('10', '25552');
INSERT INTO sys_role_menu VALUES ('10', '25553');
INSERT INTO sys_role_menu VALUES ('10', '25554');
INSERT INTO sys_role_menu VALUES ('10', '25555');
INSERT INTO sys_role_menu VALUES ('10', '25556');

INSERT INTO sys_role_menu VALUES ('10', '25560');
INSERT INTO sys_role_menu VALUES ('10', '25561');
INSERT INTO sys_role_menu VALUES ('10', '25562');
INSERT INTO sys_role_menu VALUES ('10', '25563');
INSERT INTO sys_role_menu VALUES ('10', '25564');
INSERT INTO sys_role_menu VALUES ('10', '25565');
INSERT INTO sys_role_menu VALUES ('10', '25566');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '25500');

INSERT INTO sys_role_menu VALUES ('11', '25510');
INSERT INTO sys_role_menu VALUES ('11', '25511');
INSERT INTO sys_role_menu VALUES ('11', '25512');
INSERT INTO sys_role_menu VALUES ('11', '25513');
INSERT INTO sys_role_menu VALUES ('11', '25514');
INSERT INTO sys_role_menu VALUES ('11', '25515');
INSERT INTO sys_role_menu VALUES ('11', '25516');

INSERT INTO sys_role_menu VALUES ('11', '25520');
INSERT INTO sys_role_menu VALUES ('11', '25521');
INSERT INTO sys_role_menu VALUES ('11', '25522');
INSERT INTO sys_role_menu VALUES ('11', '25523');
INSERT INTO sys_role_menu VALUES ('11', '25524');
INSERT INTO sys_role_menu VALUES ('11', '25525');
INSERT INTO sys_role_menu VALUES ('11', '25526');

INSERT INTO sys_role_menu VALUES ('11', '25530');
INSERT INTO sys_role_menu VALUES ('11', '25531');
INSERT INTO sys_role_menu VALUES ('11', '25532');
INSERT INTO sys_role_menu VALUES ('11', '25533');
INSERT INTO sys_role_menu VALUES ('11', '25534');
INSERT INTO sys_role_menu VALUES ('11', '25535');
INSERT INTO sys_role_menu VALUES ('11', '25536');

INSERT INTO sys_role_menu VALUES ('11', '25540');
INSERT INTO sys_role_menu VALUES ('11', '25541');
INSERT INTO sys_role_menu VALUES ('11', '25542');
INSERT INTO sys_role_menu VALUES ('11', '25543');
INSERT INTO sys_role_menu VALUES ('11', '25544');
INSERT INTO sys_role_menu VALUES ('11', '25545');
INSERT INTO sys_role_menu VALUES ('11', '25546');

INSERT INTO sys_role_menu VALUES ('11', '25550');
INSERT INTO sys_role_menu VALUES ('11', '25551');
INSERT INTO sys_role_menu VALUES ('11', '25552');
INSERT INTO sys_role_menu VALUES ('11', '25553');
INSERT INTO sys_role_menu VALUES ('11', '25554');
INSERT INTO sys_role_menu VALUES ('11', '25555');
INSERT INTO sys_role_menu VALUES ('11', '25556');

INSERT INTO sys_role_menu VALUES ('11', '25560');
INSERT INTO sys_role_menu VALUES ('11', '25561');
INSERT INTO sys_role_menu VALUES ('11', '25562');
INSERT INTO sys_role_menu VALUES ('11', '25563');
INSERT INTO sys_role_menu VALUES ('11', '25564');
INSERT INTO sys_role_menu VALUES ('11', '25565');
INSERT INTO sys_role_menu VALUES ('11', '25566');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '25500');

INSERT INTO sys_role_menu VALUES ('1', '25510');
INSERT INTO sys_role_menu VALUES ('1', '25511');
INSERT INTO sys_role_menu VALUES ('1', '25512');
INSERT INTO sys_role_menu VALUES ('1', '25513');
INSERT INTO sys_role_menu VALUES ('1', '25514');
INSERT INTO sys_role_menu VALUES ('1', '25515');
INSERT INTO sys_role_menu VALUES ('1', '25516');

INSERT INTO sys_role_menu VALUES ('1', '25520');
INSERT INTO sys_role_menu VALUES ('1', '25521');
INSERT INTO sys_role_menu VALUES ('1', '25522');
INSERT INTO sys_role_menu VALUES ('1', '25523');
INSERT INTO sys_role_menu VALUES ('1', '25524');
INSERT INTO sys_role_menu VALUES ('1', '25525');
INSERT INTO sys_role_menu VALUES ('1', '25526');

INSERT INTO sys_role_menu VALUES ('1', '25530');
INSERT INTO sys_role_menu VALUES ('1', '25531');
INSERT INTO sys_role_menu VALUES ('1', '25532');
INSERT INTO sys_role_menu VALUES ('1', '25533');
INSERT INTO sys_role_menu VALUES ('1', '25534');
INSERT INTO sys_role_menu VALUES ('1', '25535');
INSERT INTO sys_role_menu VALUES ('1', '25536');

INSERT INTO sys_role_menu VALUES ('1', '25540');
INSERT INTO sys_role_menu VALUES ('1', '25541');
INSERT INTO sys_role_menu VALUES ('1', '25542');
INSERT INTO sys_role_menu VALUES ('1', '25543');
INSERT INTO sys_role_menu VALUES ('1', '25544');
INSERT INTO sys_role_menu VALUES ('1', '25545');
INSERT INTO sys_role_menu VALUES ('1', '25546');

INSERT INTO sys_role_menu VALUES ('1', '25550');
INSERT INTO sys_role_menu VALUES ('1', '25551');
INSERT INTO sys_role_menu VALUES ('1', '25552');
INSERT INTO sys_role_menu VALUES ('1', '25553');
INSERT INTO sys_role_menu VALUES ('1', '25554');
INSERT INTO sys_role_menu VALUES ('1', '25555');
INSERT INTO sys_role_menu VALUES ('1', '25556');

INSERT INTO sys_role_menu VALUES ('1', '25560');
INSERT INTO sys_role_menu VALUES ('1', '25561');
INSERT INTO sys_role_menu VALUES ('1', '25562');
INSERT INTO sys_role_menu VALUES ('1', '25563');
INSERT INTO sys_role_menu VALUES ('1', '25564');
INSERT INTO sys_role_menu VALUES ('1', '25565');
INSERT INTO sys_role_menu VALUES ('1', '25566');