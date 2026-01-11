-- ----------------------------
-- 放射管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建放射管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('23000', '放射管理', '0', '100', 'radiation', NULL, '', 1, 0, 'M', '0', '0', '', 'radiation', 100, 1, sysdate(), NULL, NULL, '放射管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('23010', '辐射剂量警报', '23000', '10', 'radiationDoseAlert', 'radiation/radiationDoseAlert/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationDoseAlert:list', 'exclamation-triangle', 100, 1, sysdate(), NULL, NULL, '辐射剂量警报');
INSERT INTO sys_menu VALUES ('23020', '辐射剂量监测', '23000', '20', 'radiationDoseMonitoring', 'radiation/radiationDoseMonitoring/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationDoseMonitoring:list', 'chart-line', 100, 1, sysdate(), NULL, NULL, '辐射剂量监测');
INSERT INTO sys_menu VALUES ('23030', '辐射设备', '23000', '30', 'radiationEquipment', 'radiation/radiationEquipment/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationEquipment:list', 'cogs', 100, 1, sysdate(), NULL, NULL, '辐射设备');
INSERT INTO sys_menu VALUES ('23040', '辐射设备维护', '23000', '40', 'radiationEquipmentMaintenance', 'radiation/radiationEquipmentMaintenance/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationEquipmentMaintenance:list', 'wrench', 100, 1, sysdate(), NULL, NULL, '辐射设备维护');
INSERT INTO sys_menu VALUES ('23050', '辐射暴露记录', '23000', '50', 'radiationExposureRecord', 'radiation/radiationExposureRecord/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationExposureRecord:list', 'file-medical', 100, 1, sysdate(), NULL, NULL, '辐射暴露记录');
INSERT INTO sys_menu VALUES ('23060', '辐射防护计划', '23000', '60', 'radiationProtectionPlan', 'radiation/radiationProtectionPlan/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationProtectionPlan:list', 'shield-alt', 100, 1, sysdate(), NULL, NULL, '辐射防护计划');
INSERT INTO sys_menu VALUES ('23070', '辐射安全培训', '23000', '70', 'radiationSafetyTraining', 'radiation/radiationSafetyTraining/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationSafetyTraining:list', 'graduation-cap', 100, 1, sysdate(), NULL, NULL, '辐射安全培训');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 辐射剂量警报按钮
INSERT INTO sys_menu VALUES ('23011', '辐射剂量警报查询', '23010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23012', '辐射剂量警报新增', '23010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23013', '辐射剂量警报修改', '23010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23014', '辐射剂量警报删除', '23010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23015', '辐射剂量警报导入', '23010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23016', '辐射剂量警报导出', '23010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射剂量监测按钮
INSERT INTO sys_menu VALUES ('23021', '辐射剂量监测查询', '23020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23022', '辐射剂量监测新增', '23020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23023', '辐射剂量监测修改', '23020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23024', '辐射剂量监测删除', '23020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23025', '辐射剂量监测导入', '23020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23026', '辐射剂量监测导出', '23020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射设备按钮
INSERT INTO sys_menu VALUES ('23031', '辐射设备查询', '23030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipment:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23032', '辐射设备新增', '23030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipment:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23033', '辐射设备修改', '23030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipment:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23034', '辐射设备删除', '23030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipment:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23035', '辐射设备导入', '23030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipment:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23036', '辐射设备导出', '23030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipment:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射设备维护按钮
INSERT INTO sys_menu VALUES ('23041', '辐射设备维护查询', '23040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentMaintenance:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23042', '辐射设备维护新增', '23040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentMaintenance:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23043', '辐射设备维护修改', '23040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentMaintenance:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23044', '辐射设备维护删除', '23040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentMaintenance:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23045', '辐射设备维护导入', '23040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentMaintenance:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23046', '辐射设备维护导出', '23040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentMaintenance:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射暴露记录按钮
INSERT INTO sys_menu VALUES ('23051', '辐射暴露记录查询', '23050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationExposureRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23052', '辐射暴露记录新增', '23050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationExposureRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23053', '辐射暴露记录修改', '23050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationExposureRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23054', '辐射暴露记录删除', '23050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationExposureRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23055', '辐射暴露记录导入', '23050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationExposureRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23056', '辐射暴露记录导出', '23050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationExposureRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射防护计划按钮
INSERT INTO sys_menu VALUES ('23061', '辐射防护计划查询', '23060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationProtectionPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23062', '辐射防护计划新增', '23060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationProtectionPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23063', '辐射防护计划修改', '23060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationProtectionPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23064', '辐射防护计划删除', '23060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationProtectionPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23065', '辐射防护计划导入', '23060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationProtectionPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23066', '辐射防护计划导出', '23060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationProtectionPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射安全培训按钮
INSERT INTO sys_menu VALUES ('23071', '辐射安全培训查询', '23070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationSafetyTraining:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23072', '辐射安全培训新增', '23070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationSafetyTraining:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23073', '辐射安全培训修改', '23070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationSafetyTraining:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23074', '辐射安全培训删除', '23070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationSafetyTraining:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23075', '辐射安全培训导入', '23070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationSafetyTraining:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23076', '辐射安全培训导出', '23070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationSafetyTraining:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '23000');

INSERT INTO sys_role_menu VALUES ('5', '23010');
INSERT INTO sys_role_menu VALUES ('5', '23011');
INSERT INTO sys_role_menu VALUES ('5', '23012');
INSERT INTO sys_role_menu VALUES ('5', '23013');
INSERT INTO sys_role_menu VALUES ('5', '23014');
INSERT INTO sys_role_menu VALUES ('5', '23015');
INSERT INTO sys_role_menu VALUES ('5', '23016');

INSERT INTO sys_role_menu VALUES ('5', '23020');
INSERT INTO sys_role_menu VALUES ('5', '23021');
INSERT INTO sys_role_menu VALUES ('5', '23022');
INSERT INTO sys_role_menu VALUES ('5', '23023');
INSERT INTO sys_role_menu VALUES ('5', '23024');
INSERT INTO sys_role_menu VALUES ('5', '23025');
INSERT INTO sys_role_menu VALUES ('5', '23026');

INSERT INTO sys_role_menu VALUES ('5', '23030');
INSERT INTO sys_role_menu VALUES ('5', '23031');
INSERT INTO sys_role_menu VALUES ('5', '23032');
INSERT INTO sys_role_menu VALUES ('5', '23033');
INSERT INTO sys_role_menu VALUES ('5', '23034');
INSERT INTO sys_role_menu VALUES ('5', '23035');
INSERT INTO sys_role_menu VALUES ('5', '23036');

INSERT INTO sys_role_menu VALUES ('5', '23040');
INSERT INTO sys_role_menu VALUES ('5', '23041');
INSERT INTO sys_role_menu VALUES ('5', '23042');
INSERT INTO sys_role_menu VALUES ('5', '23043');
INSERT INTO sys_role_menu VALUES ('5', '23044');
INSERT INTO sys_role_menu VALUES ('5', '23045');
INSERT INTO sys_role_menu VALUES ('5', '23046');

INSERT INTO sys_role_menu VALUES ('5', '23050');
INSERT INTO sys_role_menu VALUES ('5', '23051');
INSERT INTO sys_role_menu VALUES ('5', '23052');
INSERT INTO sys_role_menu VALUES ('5', '23053');
INSERT INTO sys_role_menu VALUES ('5', '23054');
INSERT INTO sys_role_menu VALUES ('5', '23055');
INSERT INTO sys_role_menu VALUES ('5', '23056');

INSERT INTO sys_role_menu VALUES ('5', '23060');
INSERT INTO sys_role_menu VALUES ('5', '23061');
INSERT INTO sys_role_menu VALUES ('5', '23062');
INSERT INTO sys_role_menu VALUES ('5', '23063');
INSERT INTO sys_role_menu VALUES ('5', '23064');
INSERT INTO sys_role_menu VALUES ('5', '23065');
INSERT INTO sys_role_menu VALUES ('5', '23066');

INSERT INTO sys_role_menu VALUES ('5', '23070');
INSERT INTO sys_role_menu VALUES ('5', '23071');
INSERT INTO sys_role_menu VALUES ('5', '23072');
INSERT INTO sys_role_menu VALUES ('5', '23073');
INSERT INTO sys_role_menu VALUES ('5', '23074');
INSERT INTO sys_role_menu VALUES ('5', '23075');
INSERT INTO sys_role_menu VALUES ('5', '23076');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '23000');

INSERT INTO sys_role_menu VALUES ('6', '23010');
INSERT INTO sys_role_menu VALUES ('6', '23011');
INSERT INTO sys_role_menu VALUES ('6', '23012');
INSERT INTO sys_role_menu VALUES ('6', '23013');
INSERT INTO sys_role_menu VALUES ('6', '23014');
INSERT INTO sys_role_menu VALUES ('6', '23015');
INSERT INTO sys_role_menu VALUES ('6', '23016');

INSERT INTO sys_role_menu VALUES ('6', '23020');
INSERT INTO sys_role_menu VALUES ('6', '23021');
INSERT INTO sys_role_menu VALUES ('6', '23022');
INSERT INTO sys_role_menu VALUES ('6', '23023');
INSERT INTO sys_role_menu VALUES ('6', '23024');
INSERT INTO sys_role_menu VALUES ('6', '23025');
INSERT INTO sys_role_menu VALUES ('6', '23026');

INSERT INTO sys_role_menu VALUES ('6', '23030');
INSERT INTO sys_role_menu VALUES ('6', '23031');
INSERT INTO sys_role_menu VALUES ('6', '23032');
INSERT INTO sys_role_menu VALUES ('6', '23033');
INSERT INTO sys_role_menu VALUES ('6', '23034');
INSERT INTO sys_role_menu VALUES ('6', '23035');
INSERT INTO sys_role_menu VALUES ('6', '23036');

INSERT INTO sys_role_menu VALUES ('6', '23040');
INSERT INTO sys_role_menu VALUES ('6', '23041');
INSERT INTO sys_role_menu VALUES ('6', '23042');
INSERT INTO sys_role_menu VALUES ('6', '23043');
INSERT INTO sys_role_menu VALUES ('6', '23044');
INSERT INTO sys_role_menu VALUES ('6', '23045');
INSERT INTO sys_role_menu VALUES ('6', '23046');

INSERT INTO sys_role_menu VALUES ('6', '23050');
INSERT INTO sys_role_menu VALUES ('6', '23051');
INSERT INTO sys_role_menu VALUES ('6', '23052');
INSERT INTO sys_role_menu VALUES ('6', '23053');
INSERT INTO sys_role_menu VALUES ('6', '23054');
INSERT INTO sys_role_menu VALUES ('6', '23055');
INSERT INTO sys_role_menu VALUES ('6', '23056');

INSERT INTO sys_role_menu VALUES ('6', '23060');
INSERT INTO sys_role_menu VALUES ('6', '23061');
INSERT INTO sys_role_menu VALUES ('6', '23062');
INSERT INTO sys_role_menu VALUES ('6', '23063');
INSERT INTO sys_role_menu VALUES ('6', '23064');
INSERT INTO sys_role_menu VALUES ('6', '23065');
INSERT INTO sys_role_menu VALUES ('6', '23066');

INSERT INTO sys_role_menu VALUES ('6', '23070');
INSERT INTO sys_role_menu VALUES ('6', '23071');
INSERT INTO sys_role_menu VALUES ('6', '23072');
INSERT INTO sys_role_menu VALUES ('6', '23073');
INSERT INTO sys_role_menu VALUES ('6', '23074');
INSERT INTO sys_role_menu VALUES ('6', '23075');
INSERT INTO sys_role_menu VALUES ('6', '23076');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '23000');

INSERT INTO sys_role_menu VALUES ('7', '23010');
INSERT INTO sys_role_menu VALUES ('7', '23011');
INSERT INTO sys_role_menu VALUES ('7', '23012');
INSERT INTO sys_role_menu VALUES ('7', '23013');
INSERT INTO sys_role_menu VALUES ('7', '23014');
INSERT INTO sys_role_menu VALUES ('7', '23015');
INSERT INTO sys_role_menu VALUES ('7', '23016');

INSERT INTO sys_role_menu VALUES ('7', '23020');
INSERT INTO sys_role_menu VALUES ('7', '23021');
INSERT INTO sys_role_menu VALUES ('7', '23022');
INSERT INTO sys_role_menu VALUES ('7', '23023');
INSERT INTO sys_role_menu VALUES ('7', '23024');
INSERT INTO sys_role_menu VALUES ('7', '23025');
INSERT INTO sys_role_menu VALUES ('7', '23026');

INSERT INTO sys_role_menu VALUES ('7', '23030');
INSERT INTO sys_role_menu VALUES ('7', '23031');
INSERT INTO sys_role_menu VALUES ('7', '23032');
INSERT INTO sys_role_menu VALUES ('7', '23033');
INSERT INTO sys_role_menu VALUES ('7', '23034');
INSERT INTO sys_role_menu VALUES ('7', '23035');
INSERT INTO sys_role_menu VALUES ('7', '23036');

INSERT INTO sys_role_menu VALUES ('7', '23040');
INSERT INTO sys_role_menu VALUES ('7', '23041');
INSERT INTO sys_role_menu VALUES ('7', '23042');
INSERT INTO sys_role_menu VALUES ('7', '23043');
INSERT INTO sys_role_menu VALUES ('7', '23044');
INSERT INTO sys_role_menu VALUES ('7', '23045');
INSERT INTO sys_role_menu VALUES ('7', '23046');

INSERT INTO sys_role_menu VALUES ('7', '23050');
INSERT INTO sys_role_menu VALUES ('7', '23051');
INSERT INTO sys_role_menu VALUES ('7', '23052');
INSERT INTO sys_role_menu VALUES ('7', '23053');
INSERT INTO sys_role_menu VALUES ('7', '23054');
INSERT INTO sys_role_menu VALUES ('7', '23055');
INSERT INTO sys_role_menu VALUES ('7', '23056');

INSERT INTO sys_role_menu VALUES ('7', '23060');
INSERT INTO sys_role_menu VALUES ('7', '23061');
INSERT INTO sys_role_menu VALUES ('7', '23062');
INSERT INTO sys_role_menu VALUES ('7', '23063');
INSERT INTO sys_role_menu VALUES ('7', '23064');
INSERT INTO sys_role_menu VALUES ('7', '23065');
INSERT INTO sys_role_menu VALUES ('7', '23066');

INSERT INTO sys_role_menu VALUES ('7', '23070');
INSERT INTO sys_role_menu VALUES ('7', '23071');
INSERT INTO sys_role_menu VALUES ('7', '23072');
INSERT INTO sys_role_menu VALUES ('7', '23073');
INSERT INTO sys_role_menu VALUES ('7', '23074');
INSERT INTO sys_role_menu VALUES ('7', '23075');
INSERT INTO sys_role_menu VALUES ('7', '23076');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '23000');

INSERT INTO sys_role_menu VALUES ('8', '23010');
INSERT INTO sys_role_menu VALUES ('8', '23011');
INSERT INTO sys_role_menu VALUES ('8', '23012');
INSERT INTO sys_role_menu VALUES ('8', '23013');
INSERT INTO sys_role_menu VALUES ('8', '23014');
INSERT INTO sys_role_menu VALUES ('8', '23015');
INSERT INTO sys_role_menu VALUES ('8', '23016');

INSERT INTO sys_role_menu VALUES ('8', '23020');
INSERT INTO sys_role_menu VALUES ('8', '23021');
INSERT INTO sys_role_menu VALUES ('8', '23022');
INSERT INTO sys_role_menu VALUES ('8', '23023');
INSERT INTO sys_role_menu VALUES ('8', '23024');
INSERT INTO sys_role_menu VALUES ('8', '23025');
INSERT INTO sys_role_menu VALUES ('8', '23026');

INSERT INTO sys_role_menu VALUES ('8', '23030');
INSERT INTO sys_role_menu VALUES ('8', '23031');
INSERT INTO sys_role_menu VALUES ('8', '23032');
INSERT INTO sys_role_menu VALUES ('8', '23033');
INSERT INTO sys_role_menu VALUES ('8', '23034');
INSERT INTO sys_role_menu VALUES ('8', '23035');
INSERT INTO sys_role_menu VALUES ('8', '23036');

INSERT INTO sys_role_menu VALUES ('8', '23040');
INSERT INTO sys_role_menu VALUES ('8', '23041');
INSERT INTO sys_role_menu VALUES ('8', '23042');
INSERT INTO sys_role_menu VALUES ('8', '23043');
INSERT INTO sys_role_menu VALUES ('8', '23044');
INSERT INTO sys_role_menu VALUES ('8', '23045');
INSERT INTO sys_role_menu VALUES ('8', '23046');

INSERT INTO sys_role_menu VALUES ('8', '23050');
INSERT INTO sys_role_menu VALUES ('8', '23051');
INSERT INTO sys_role_menu VALUES ('8', '23052');
INSERT INTO sys_role_menu VALUES ('8', '23053');
INSERT INTO sys_role_menu VALUES ('8', '23054');
INSERT INTO sys_role_menu VALUES ('8', '23055');
INSERT INTO sys_role_menu VALUES ('8', '23056');

INSERT INTO sys_role_menu VALUES ('8', '23060');
INSERT INTO sys_role_menu VALUES ('8', '23061');
INSERT INTO sys_role_menu VALUES ('8', '23062');
INSERT INTO sys_role_menu VALUES ('8', '23063');
INSERT INTO sys_role_menu VALUES ('8', '23064');
INSERT INTO sys_role_menu VALUES ('8', '23065');
INSERT INTO sys_role_menu VALUES ('8', '23066');

INSERT INTO sys_role_menu VALUES ('8', '23070');
INSERT INTO sys_role_menu VALUES ('8', '23071');
INSERT INTO sys_role_menu VALUES ('8', '23072');
INSERT INTO sys_role_menu VALUES ('8', '23073');
INSERT INTO sys_role_menu VALUES ('8', '23074');
INSERT INTO sys_role_menu VALUES ('8', '23075');
INSERT INTO sys_role_menu VALUES ('8', '23076');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '23000');

INSERT INTO sys_role_menu VALUES ('9', '23010');
INSERT INTO sys_role_menu VALUES ('9', '23011');
INSERT INTO sys_role_menu VALUES ('9', '23012');
INSERT INTO sys_role_menu VALUES ('9', '23013');
INSERT INTO sys_role_menu VALUES ('9', '23014');
INSERT INTO sys_role_menu VALUES ('9', '23015');
INSERT INTO sys_role_menu VALUES ('9', '23016');

INSERT INTO sys_role_menu VALUES ('9', '23020');
INSERT INTO sys_role_menu VALUES ('9', '23021');
INSERT INTO sys_role_menu VALUES ('9', '23022');
INSERT INTO sys_role_menu VALUES ('9', '23023');
INSERT INTO sys_role_menu VALUES ('9', '23024');
INSERT INTO sys_role_menu VALUES ('9', '23025');
INSERT INTO sys_role_menu VALUES ('9', '23026');

INSERT INTO sys_role_menu VALUES ('9', '23030');
INSERT INTO sys_role_menu VALUES ('9', '23031');
INSERT INTO sys_role_menu VALUES ('9', '23032');
INSERT INTO sys_role_menu VALUES ('9', '23033');
INSERT INTO sys_role_menu VALUES ('9', '23034');
INSERT INTO sys_role_menu VALUES ('9', '23035');
INSERT INTO sys_role_menu VALUES ('9', '23036');

INSERT INTO sys_role_menu VALUES ('9', '23040');
INSERT INTO sys_role_menu VALUES ('9', '23041');
INSERT INTO sys_role_menu VALUES ('9', '23042');
INSERT INTO sys_role_menu VALUES ('9', '23043');
INSERT INTO sys_role_menu VALUES ('9', '23044');
INSERT INTO sys_role_menu VALUES ('9', '23045');
INSERT INTO sys_role_menu VALUES ('9', '23046');

INSERT INTO sys_role_menu VALUES ('9', '23050');
INSERT INTO sys_role_menu VALUES ('9', '23051');
INSERT INTO sys_role_menu VALUES ('9', '23052');
INSERT INTO sys_role_menu VALUES ('9', '23053');
INSERT INTO sys_role_menu VALUES ('9', '23054');
INSERT INTO sys_role_menu VALUES ('9', '23055');
INSERT INTO sys_role_menu VALUES ('9', '23056');

INSERT INTO sys_role_menu VALUES ('9', '23060');
INSERT INTO sys_role_menu VALUES ('9', '23061');
INSERT INTO sys_role_menu VALUES ('9', '23062');
INSERT INTO sys_role_menu VALUES ('9', '23063');
INSERT INTO sys_role_menu VALUES ('9', '23064');
INSERT INTO sys_role_menu VALUES ('9', '23065');
INSERT INTO sys_role_menu VALUES ('9', '23066');

INSERT INTO sys_role_menu VALUES ('9', '23070');
INSERT INTO sys_role_menu VALUES ('9', '23071');
INSERT INTO sys_role_menu VALUES ('9', '23072');
INSERT INTO sys_role_menu VALUES ('9', '23073');
INSERT INTO sys_role_menu VALUES ('9', '23074');
INSERT INTO sys_role_menu VALUES ('9', '23075');
INSERT INTO sys_role_menu VALUES ('9', '23076');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '23000');

INSERT INTO sys_role_menu VALUES ('10', '23010');
INSERT INTO sys_role_menu VALUES ('10', '23011');
INSERT INTO sys_role_menu VALUES ('10', '23012');
INSERT INTO sys_role_menu VALUES ('10', '23013');
INSERT INTO sys_role_menu VALUES ('10', '23014');
INSERT INTO sys_role_menu VALUES ('10', '23015');
INSERT INTO sys_role_menu VALUES ('10', '23016');

INSERT INTO sys_role_menu VALUES ('10', '23020');
INSERT INTO sys_role_menu VALUES ('10', '23021');
INSERT INTO sys_role_menu VALUES ('10', '23022');
INSERT INTO sys_role_menu VALUES ('10', '23023');
INSERT INTO sys_role_menu VALUES ('10', '23024');
INSERT INTO sys_role_menu VALUES ('10', '23025');
INSERT INTO sys_role_menu VALUES ('10', '23026');

INSERT INTO sys_role_menu VALUES ('10', '23030');
INSERT INTO sys_role_menu VALUES ('10', '23031');
INSERT INTO sys_role_menu VALUES ('10', '23032');
INSERT INTO sys_role_menu VALUES ('10', '23033');
INSERT INTO sys_role_menu VALUES ('10', '23034');
INSERT INTO sys_role_menu VALUES ('10', '23035');
INSERT INTO sys_role_menu VALUES ('10', '23036');

INSERT INTO sys_role_menu VALUES ('10', '23040');
INSERT INTO sys_role_menu VALUES ('10', '23041');
INSERT INTO sys_role_menu VALUES ('10', '23042');
INSERT INTO sys_role_menu VALUES ('10', '23043');
INSERT INTO sys_role_menu VALUES ('10', '23044');
INSERT INTO sys_role_menu VALUES ('10', '23045');
INSERT INTO sys_role_menu VALUES ('10', '23046');

INSERT INTO sys_role_menu VALUES ('10', '23050');
INSERT INTO sys_role_menu VALUES ('10', '23051');
INSERT INTO sys_role_menu VALUES ('10', '23052');
INSERT INTO sys_role_menu VALUES ('10', '23053');
INSERT INTO sys_role_menu VALUES ('10', '23054');
INSERT INTO sys_role_menu VALUES ('10', '23055');
INSERT INTO sys_role_menu VALUES ('10', '23056');

INSERT INTO sys_role_menu VALUES ('10', '23060');
INSERT INTO sys_role_menu VALUES ('10', '23061');
INSERT INTO sys_role_menu VALUES ('10', '23062');
INSERT INTO sys_role_menu VALUES ('10', '23063');
INSERT INTO sys_role_menu VALUES ('10', '23064');
INSERT INTO sys_role_menu VALUES ('10', '23065');
INSERT INTO sys_role_menu VALUES ('10', '23066');

INSERT INTO sys_role_menu VALUES ('10', '23070');
INSERT INTO sys_role_menu VALUES ('10', '23071');
INSERT INTO sys_role_menu VALUES ('10', '23072');
INSERT INTO sys_role_menu VALUES ('10', '23073');
INSERT INTO sys_role_menu VALUES ('10', '23074');
INSERT INTO sys_role_menu VALUES ('10', '23075');
INSERT INTO sys_role_menu VALUES ('10', '23076');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '23000');

INSERT INTO sys_role_menu VALUES ('11', '23010');
INSERT INTO sys_role_menu VALUES ('11', '23011');
INSERT INTO sys_role_menu VALUES ('11', '23012');
INSERT INTO sys_role_menu VALUES ('11', '23013');
INSERT INTO sys_role_menu VALUES ('11', '23014');
INSERT INTO sys_role_menu VALUES ('11', '23015');
INSERT INTO sys_role_menu VALUES ('11', '23016');

INSERT INTO sys_role_menu VALUES ('11', '23020');
INSERT INTO sys_role_menu VALUES ('11', '23021');
INSERT INTO sys_role_menu VALUES ('11', '23022');
INSERT INTO sys_role_menu VALUES ('11', '23023');
INSERT INTO sys_role_menu VALUES ('11', '23024');
INSERT INTO sys_role_menu VALUES ('11', '23025');
INSERT INTO sys_role_menu VALUES ('11', '23026');

INSERT INTO sys_role_menu VALUES ('11', '23030');
INSERT INTO sys_role_menu VALUES ('11', '23031');
INSERT INTO sys_role_menu VALUES ('11', '23032');
INSERT INTO sys_role_menu VALUES ('11', '23033');
INSERT INTO sys_role_menu VALUES ('11', '23034');
INSERT INTO sys_role_menu VALUES ('11', '23035');
INSERT INTO sys_role_menu VALUES ('11', '23036');

INSERT INTO sys_role_menu VALUES ('11', '23040');
INSERT INTO sys_role_menu VALUES ('11', '23041');
INSERT INTO sys_role_menu VALUES ('11', '23042');
INSERT INTO sys_role_menu VALUES ('11', '23043');
INSERT INTO sys_role_menu VALUES ('11', '23044');
INSERT INTO sys_role_menu VALUES ('11', '23045');
INSERT INTO sys_role_menu VALUES ('11', '23046');

INSERT INTO sys_role_menu VALUES ('11', '23050');
INSERT INTO sys_role_menu VALUES ('11', '23051');
INSERT INTO sys_role_menu VALUES ('11', '23052');
INSERT INTO sys_role_menu VALUES ('11', '23053');
INSERT INTO sys_role_menu VALUES ('11', '23054');
INSERT INTO sys_role_menu VALUES ('11', '23055');
INSERT INTO sys_role_menu VALUES ('11', '23056');

INSERT INTO sys_role_menu VALUES ('11', '23060');
INSERT INTO sys_role_menu VALUES ('11', '23061');
INSERT INTO sys_role_menu VALUES ('11', '23062');
INSERT INTO sys_role_menu VALUES ('11', '23063');
INSERT INTO sys_role_menu VALUES ('11', '23064');
INSERT INTO sys_role_menu VALUES ('11', '23065');
INSERT INTO sys_role_menu VALUES ('11', '23066');

INSERT INTO sys_role_menu VALUES ('11', '23070');
INSERT INTO sys_role_menu VALUES ('11', '23071');
INSERT INTO sys_role_menu VALUES ('11', '23072');
INSERT INTO sys_role_menu VALUES ('11', '23073');
INSERT INTO sys_role_menu VALUES ('11', '23074');
INSERT INTO sys_role_menu VALUES ('11', '23075');
INSERT INTO sys_role_menu VALUES ('11', '23076');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '23000');

INSERT INTO sys_role_menu VALUES ('1', '23010');
INSERT INTO sys_role_menu VALUES ('1', '23011');
INSERT INTO sys_role_menu VALUES ('1', '23012');
INSERT INTO sys_role_menu VALUES ('1', '23013');
INSERT INTO sys_role_menu VALUES ('1', '23014');
INSERT INTO sys_role_menu VALUES ('1', '23015');
INSERT INTO sys_role_menu VALUES ('1', '23016');

INSERT INTO sys_role_menu VALUES ('1', '23020');
INSERT INTO sys_role_menu VALUES ('1', '23021');
INSERT INTO sys_role_menu VALUES ('1', '23022');
INSERT INTO sys_role_menu VALUES ('1', '23023');
INSERT INTO sys_role_menu VALUES ('1', '23024');
INSERT INTO sys_role_menu VALUES ('1', '23025');
INSERT INTO sys_role_menu VALUES ('1', '23026');

INSERT INTO sys_role_menu VALUES ('1', '23030');
INSERT INTO sys_role_menu VALUES ('1', '23031');
INSERT INTO sys_role_menu VALUES ('1', '23032');
INSERT INTO sys_role_menu VALUES ('1', '23033');
INSERT INTO sys_role_menu VALUES ('1', '23034');
INSERT INTO sys_role_menu VALUES ('1', '23035');
INSERT INTO sys_role_menu VALUES ('1', '23036');

INSERT INTO sys_role_menu VALUES ('1', '23040');
INSERT INTO sys_role_menu VALUES ('1', '23041');
INSERT INTO sys_role_menu VALUES ('1', '23042');
INSERT INTO sys_role_menu VALUES ('1', '23043');
INSERT INTO sys_role_menu VALUES ('1', '23044');
INSERT INTO sys_role_menu VALUES ('1', '23045');
INSERT INTO sys_role_menu VALUES ('1', '23046');

INSERT INTO sys_role_menu VALUES ('1', '23050');
INSERT INTO sys_role_menu VALUES ('1', '23051');
INSERT INTO sys_role_menu VALUES ('1', '23052');
INSERT INTO sys_role_menu VALUES ('1', '23053');
INSERT INTO sys_role_menu VALUES ('1', '23054');
INSERT INTO sys_role_menu VALUES ('1', '23055');
INSERT INTO sys_role_menu VALUES ('1', '23056');

INSERT INTO sys_role_menu VALUES ('1', '23060');
INSERT INTO sys_role_menu VALUES ('1', '23061');
INSERT INTO sys_role_menu VALUES ('1', '23062');
INSERT INTO sys_role_menu VALUES ('1', '23063');
INSERT INTO sys_role_menu VALUES ('1', '23064');
INSERT INTO sys_role_menu VALUES ('1', '23065');
INSERT INTO sys_role_menu VALUES ('1', '23066');

INSERT INTO sys_role_menu VALUES ('1', '23070');
INSERT INTO sys_role_menu VALUES ('1', '23071');
INSERT INTO sys_role_menu VALUES ('1', '23072');
INSERT INTO sys_role_menu VALUES ('1', '23073');
INSERT INTO sys_role_menu VALUES ('1', '23074');
INSERT INTO sys_role_menu VALUES ('1', '23075');
INSERT INTO sys_role_menu VALUES ('1', '23076');