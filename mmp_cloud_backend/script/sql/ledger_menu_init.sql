-- ----------------------------
-- 台账管理完整菜单SQL脚本
-- 生成时间：2026-01-14
-- 包含7个子模块：
--   业务学习、危重患者、长期住院患者、重大手术、患者全周期、非计划再手术、死亡病例讨论
-- ----------------------------

-- 清理旧数据
DELETE FROM sys_role_menu WHERE menu_id >= 25500 AND menu_id < 26000;
DELETE FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- ----------------------------
-- 1. 创建台账管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25500', '台账管理', '0', '110', 'ledger', NULL, '', 1, 0, 'M', '0', '0', '', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '台账管理目录');

-- ----------------------------
-- 2. 创建子菜单(7个模块)
-- ----------------------------
INSERT INTO sys_menu VALUES ('25510', '台账业务学习', '25500', '10', 'ledgerBusinessLearning', 'ledger/ledgerBusinessLearning/index', '', 1, 0, 'C', '0', '0', 'ledger:ledgerBusinessLearning:list', 'book-open', 100, 1, sysdate(), NULL, NULL, '台账业务学习');
INSERT INTO sys_menu VALUES ('25520', '台账危重患者', '25500', '20', 'ledgerCriticalPatient', 'ledger/ledgerCriticalPatient/index', '', 1, 0, 'C', '0', '0', 'ledger:ledgerCriticalPatient:list', 'user-injured', 100, 1, sysdate(), NULL, NULL, '台账危重患者');
INSERT INTO sys_menu VALUES ('25530', '台账长期住院患者', '25500', '30', 'ledgerLongStayPatient', 'ledger/ledgerLongStayPatient/index', '', 1, 0, 'C', '0', '0', 'ledger:ledgerLongStayPatient:list', 'bed', 100, 1, sysdate(), NULL, NULL, '台账长期住院患者');
INSERT INTO sys_menu VALUES ('25540', '台账重大手术', '25500', '40', 'ledgerMajorSurgery', 'ledger/ledgerMajorSurgery/index', '', 1, 0, 'C', '0', '0', 'ledger:ledgerMajorSurgery:list', 'syringe', 100, 1, sysdate(), NULL, NULL, '台账重大手术');
INSERT INTO sys_menu VALUES ('25550', '台账患者全周期', '25500', '50', 'ledgerPatientFullCycle', 'ledger/ledgerPatientFullCycle/index', '', 1, 0, 'C', '0', '0', 'ledger:ledgerPatientFullCycle:list', 'route', 100, 1, sysdate(), NULL, NULL, '台账患者全周期');
INSERT INTO sys_menu VALUES ('25560', '台账非计划再手术', '25500', '60', 'ledgerUnplannedReoperation', 'ledger/ledgerUnplannedReoperation/index', '', 1, 0, 'C', '0', '0', 'ledger:ledgerUnplannedReoperation:list', 'redo', 100, 1, sysdate(), NULL, NULL, '台账非计划再手术');
INSERT INTO sys_menu VALUES ('25570', '台账死亡病例讨论', '25500', '70', 'deathCaseDiscussion', 'ledger/deathCaseDiscussion/index', '', 1, 0, 'C', '0', '0', 'ledger:deathCaseDiscussion:list', 'skull', 100, 1, sysdate(), NULL, NULL, '台账死亡病例讨论');
INSERT INTO sys_menu VALUES ('25580', '医疗仪表板', '25500', '80', 'medicalStats', 'ledger/medicalStats/index', '', 1, 0, 'C', '0', '0', 'ledger:medicalStats:list', 'pie-chart', 100, 1, sysdate(), NULL, NULL, '医疗质量统计数据');

-- ----------------------------
-- 3. 定义按钮权限(每个模块6个按钮)
-- ----------------------------

-- 3.1 台账业务学习按钮
INSERT INTO sys_menu VALUES ('25511', '台账业务学习查询', '25510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerBusinessLearning:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25512', '台账业务学习新增', '25510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerBusinessLearning:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25513', '台账业务学习修改', '25510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerBusinessLearning:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25514', '台账业务学习删除', '25510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerBusinessLearning:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25515', '台账业务学习导入', '25510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerBusinessLearning:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25516', '台账业务学习导出', '25510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerBusinessLearning:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.2 台账危重患者按钮
INSERT INTO sys_menu VALUES ('25521', '台账危重患者查询', '25520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerCriticalPatient:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25522', '台账危重患者新增', '25520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerCriticalPatient:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25523', '台账危重患者修改', '25520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerCriticalPatient:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25524', '台账危重患者删除', '25520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerCriticalPatient:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25525', '台账危重患者导入', '25520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerCriticalPatient:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25526', '台账危重患者导出', '25520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerCriticalPatient:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.3 台账长期住院患者按钮
INSERT INTO sys_menu VALUES ('25531', '台账长期住院患者查询', '25530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerLongStayPatient:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25532', '台账长期住院患者新增', '25530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerLongStayPatient:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25533', '台账长期住院患者修改', '25530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerLongStayPatient:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25534', '台账长期住院患者删除', '25530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerLongStayPatient:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25535', '台账长期住院患者导入', '25530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerLongStayPatient:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25536', '台账长期住院患者导出', '25530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerLongStayPatient:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.4 台账重大手术按钮
INSERT INTO sys_menu VALUES ('25541', '台账重大手术查询', '25540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerMajorSurgery:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25542', '台账重大手术新增', '25540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerMajorSurgery:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25543', '台账重大手术修改', '25540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerMajorSurgery:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25544', '台账重大手术删除', '25540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerMajorSurgery:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25545', '台账重大手术导入', '25540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerMajorSurgery:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25546', '台账重大手术导出', '25540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerMajorSurgery:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.5 台账患者全周期按钮
INSERT INTO sys_menu VALUES ('25551', '台账患者全周期查询', '25550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerPatientFullCycle:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25552', '台账患者全周期新增', '25550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerPatientFullCycle:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25553', '台账患者全周期修改', '25550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerPatientFullCycle:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25554', '台账患者全周期删除', '25550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerPatientFullCycle:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25555', '台账患者全周期导入', '25550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerPatientFullCycle:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25556', '台账患者全周期导出', '25550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerPatientFullCycle:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.6 台账非计划再手术按钮
INSERT INTO sys_menu VALUES ('25561', '台账非计划再手术查询', '25560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerUnplannedReoperation:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25562', '台账非计划再手术新增', '25560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerUnplannedReoperation:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25563', '台账非计划再手术修改', '25560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerUnplannedReoperation:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25564', '台账非计划再手术删除', '25560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerUnplannedReoperation:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25565', '台账非计划再手术导入', '25560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerUnplannedReoperation:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25566', '台账非计划再手术导出', '25560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:ledgerUnplannedReoperation:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.7 台账死亡病例讨论按钮
INSERT INTO sys_menu VALUES ('25571', '台账死亡病例讨论查询', '25570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:deathCaseDiscussion:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25572', '台账死亡病例讨论新增', '25570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:deathCaseDiscussion:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25573', '台账死亡病例讨论修改', '25570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:deathCaseDiscussion:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25574', '台账死亡病例讨论删除', '25570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:deathCaseDiscussion:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25575', '台账死亡病例讨论导入', '25570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:deathCaseDiscussion:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25576', '台账死亡病例讨论导出', '25570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:deathCaseDiscussion:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.8 医疗仪表板按钮
INSERT INTO sys_menu VALUES ('25581', '医疗仪表板查询', '25580', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:medicalStats:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25582', '医疗仪表板新增', '25580', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:medicalStats:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25583', '医疗仪表板修改', '25580', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:medicalStats:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25584', '医疗仪表板删除', '25580', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:medicalStats:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25585', '医疗仪表板导入', '25580', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:medicalStats:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25586', '医疗仪表板导出', '25580', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ledger:medicalStats:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------

-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 25500 AND menu_id < 26000;

COMMIT;