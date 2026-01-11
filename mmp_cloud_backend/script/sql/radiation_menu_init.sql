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