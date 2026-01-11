-- ----------------------------
-- 手术管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建手术管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('24000', '手术管理', '0', '100', 'surgery', NULL, '', 1, 0, 'M', '0', '0', '', 'user-md', 100, 1, sysdate(), NULL, NULL, '手术管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('24010', '重大手术申请', '24000', '10', 'majorSurgeryApplication', 'surgery/majorSurgeryApplication/index', '', 1, 0, 'C', '0', '0', 'surgery:majorSurgeryApplication:list', 'file-signature', 100, 1, sysdate(), NULL, NULL, '重大手术申请');
INSERT INTO sys_menu VALUES ('24020', '手术病例', '24000', '20', 'surgeryCase', 'surgery/surgeryCase/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryCase:list', 'file-medical', 100, 1, sysdate(), NULL, NULL, '手术病例');
INSERT INTO sys_menu VALUES ('24030', '手术并发症', '24000', '30', 'surgeryComplication', 'surgery/surgeryComplication/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryComplication:list', 'exclamation-triangle', 100, 1, sysdate(), NULL, NULL, '手术并发症');
INSERT INTO sys_menu VALUES ('24040', '手术设备', '24000', '40', 'surgeryEquipment', 'surgery/surgeryEquipment/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryEquipment:list', 'cogs', 100, 1, sysdate(), NULL, NULL, '手术设备');
INSERT INTO sys_menu VALUES ('24050', '手术护士', '24000', '50', 'surgeryNurse', 'surgery/surgeryNurse/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryNurse:list', 'user-nurse', 100, 1, sysdate(), NULL, NULL, '手术护士');
INSERT INTO sys_menu VALUES ('24060', '手术记录', '24000', '60', 'surgeryRecord', 'surgery/surgeryRecord/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryRecord:list', 'clipboard', 100, 1, sysdate(), NULL, NULL, '手术记录');
INSERT INTO sys_menu VALUES ('24070', '手术排班', '24000', '70', 'surgerySchedule', 'surgery/surgerySchedule/index', '', 1, 0, 'C', '0', '0', 'surgery:surgerySchedule:list', 'calendar-alt', 100, 1, sysdate(), NULL, NULL, '手术排班');
INSERT INTO sys_menu VALUES ('24080', '手术统计', '24000', '80', 'surgeryStatistics', 'surgery/surgeryStatistics/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryStatistics:list', 'chart-bar', 100, 1, sysdate(), NULL, NULL, '手术统计');
INSERT INTO sys_menu VALUES ('24090', '手术团队', '24000', '90', 'surgeryTeam', 'surgery/surgeryTeam/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryTeam:list', 'users', 100, 1, sysdate(), NULL, NULL, '手术团队');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 重大手术申请按钮
INSERT INTO sys_menu VALUES ('24011', '重大手术申请查询', '24010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:majorSurgeryApplication:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24012', '重大手术申请新增', '24010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:majorSurgeryApplication:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24013', '重大手术申请修改', '24010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:majorSurgeryApplication:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24014', '重大手术申请删除', '24010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:majorSurgeryApplication:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24015', '重大手术申请导入', '24010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:majorSurgeryApplication:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24016', '重大手术申请导出', '24010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:majorSurgeryApplication:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术病例按钮
INSERT INTO sys_menu VALUES ('24021', '手术病例查询', '24020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCase:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24022', '手术病例新增', '24020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCase:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24023', '手术病例修改', '24020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCase:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24024', '手术病例删除', '24020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCase:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24025', '手术病例导入', '24020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCase:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24026', '手术病例导出', '24020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCase:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术并发症按钮
INSERT INTO sys_menu VALUES ('24031', '手术并发症查询', '24030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplication:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24032', '手术并发症新增', '24030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplication:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24033', '手术并发症修改', '24030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplication:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24034', '手术并发症删除', '24030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplication:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24035', '手术并发症导入', '24030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplication:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24036', '手术并发症导出', '24030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplication:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术设备按钮
INSERT INTO sys_menu VALUES ('24041', '手术设备查询', '24040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryEquipment:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24042', '手术设备新增', '24040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryEquipment:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24043', '手术设备修改', '24040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryEquipment:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24044', '手术设备删除', '24040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryEquipment:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24045', '手术设备导入', '24040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryEquipment:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24046', '手术设备导出', '24040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryEquipment:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术护士按钮
INSERT INTO sys_menu VALUES ('24051', '手术护士查询', '24050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryNurse:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24052', '手术护士新增', '24050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryNurse:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24053', '手术护士修改', '24050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryNurse:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24054', '手术护士删除', '24050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryNurse:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24055', '手术护士导入', '24050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryNurse:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24056', '手术护士导出', '24050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryNurse:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术记录按钮
INSERT INTO sys_menu VALUES ('24061', '手术记录查询', '24060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24062', '手术记录新增', '24060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24063', '手术记录修改', '24060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24064', '手术记录删除', '24060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24065', '手术记录导入', '24060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24066', '手术记录导出', '24060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术排班按钮
INSERT INTO sys_menu VALUES ('24071', '手术排班查询', '24070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgerySchedule:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24072', '手术排班新增', '24070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgerySchedule:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24073', '手术排班修改', '24070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgerySchedule:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24074', '手术排班删除', '24070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgerySchedule:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24075', '手术排班导入', '24070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgerySchedule:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24076', '手术排班导出', '24070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgerySchedule:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术统计按钮
INSERT INTO sys_menu VALUES ('24081', '手术统计查询', '24080', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryStatistics:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24082', '手术统计新增', '24080', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryStatistics:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24083', '手术统计修改', '24080', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryStatistics:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24084', '手术统计删除', '24080', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryStatistics:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24085', '手术统计导入', '24080', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryStatistics:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24086', '手术统计导出', '24080', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryStatistics:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手术团队按钮
INSERT INTO sys_menu VALUES ('24091', '手术团队查询', '24090', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24092', '手术团队新增', '24090', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24093', '手术团队修改', '24090', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24094', '手术团队删除', '24090', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24095', '手术团队导入', '24090', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24096', '手术团队导出', '24090', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:export', '#', 100, 1, sysdate(), NULL, NULL, '');