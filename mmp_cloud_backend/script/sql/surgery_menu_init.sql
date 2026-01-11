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

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '24000');

INSERT INTO sys_role_menu VALUES ('5', '24010');
INSERT INTO sys_role_menu VALUES ('5', '24011');
INSERT INTO sys_role_menu VALUES ('5', '24012');
INSERT INTO sys_role_menu VALUES ('5', '24013');
INSERT INTO sys_role_menu VALUES ('5', '24014');
INSERT INTO sys_role_menu VALUES ('5', '24015');
INSERT INTO sys_role_menu VALUES ('5', '24016');

INSERT INTO sys_role_menu VALUES ('5', '24020');
INSERT INTO sys_role_menu VALUES ('5', '24021');
INSERT INTO sys_role_menu VALUES ('5', '24022');
INSERT INTO sys_role_menu VALUES ('5', '24023');
INSERT INTO sys_role_menu VALUES ('5', '24024');
INSERT INTO sys_role_menu VALUES ('5', '24025');
INSERT INTO sys_role_menu VALUES ('5', '24026');

INSERT INTO sys_role_menu VALUES ('5', '24030');
INSERT INTO sys_role_menu VALUES ('5', '24031');
INSERT INTO sys_role_menu VALUES ('5', '24032');
INSERT INTO sys_role_menu VALUES ('5', '24033');
INSERT INTO sys_role_menu VALUES ('5', '24034');
INSERT INTO sys_role_menu VALUES ('5', '24035');
INSERT INTO sys_role_menu VALUES ('5', '24036');

INSERT INTO sys_role_menu VALUES ('5', '24040');
INSERT INTO sys_role_menu VALUES ('5', '24041');
INSERT INTO sys_role_menu VALUES ('5', '24042');
INSERT INTO sys_role_menu VALUES ('5', '24043');
INSERT INTO sys_role_menu VALUES ('5', '24044');
INSERT INTO sys_role_menu VALUES ('5', '24045');
INSERT INTO sys_role_menu VALUES ('5', '24046');

INSERT INTO sys_role_menu VALUES ('5', '24050');
INSERT INTO sys_role_menu VALUES ('5', '24051');
INSERT INTO sys_role_menu VALUES ('5', '24052');
INSERT INTO sys_role_menu VALUES ('5', '24053');
INSERT INTO sys_role_menu VALUES ('5', '24054');
INSERT INTO sys_role_menu VALUES ('5', '24055');
INSERT INTO sys_role_menu VALUES ('5', '24056');

INSERT INTO sys_role_menu VALUES ('5', '24060');
INSERT INTO sys_role_menu VALUES ('5', '24061');
INSERT INTO sys_role_menu VALUES ('5', '24062');
INSERT INTO sys_role_menu VALUES ('5', '24063');
INSERT INTO sys_role_menu VALUES ('5', '24064');
INSERT INTO sys_role_menu VALUES ('5', '24065');
INSERT INTO sys_role_menu VALUES ('5', '24066');

INSERT INTO sys_role_menu VALUES ('5', '24070');
INSERT INTO sys_role_menu VALUES ('5', '24071');
INSERT INTO sys_role_menu VALUES ('5', '24072');
INSERT INTO sys_role_menu VALUES ('5', '24073');
INSERT INTO sys_role_menu VALUES ('5', '24074');
INSERT INTO sys_role_menu VALUES ('5', '24075');
INSERT INTO sys_role_menu VALUES ('5', '24076');

INSERT INTO sys_role_menu VALUES ('5', '24080');
INSERT INTO sys_role_menu VALUES ('5', '24081');
INSERT INTO sys_role_menu VALUES ('5', '24082');
INSERT INTO sys_role_menu VALUES ('5', '24083');
INSERT INTO sys_role_menu VALUES ('5', '24084');
INSERT INTO sys_role_menu VALUES ('5', '24085');
INSERT INTO sys_role_menu VALUES ('5', '24086');

INSERT INTO sys_role_menu VALUES ('5', '24090');
INSERT INTO sys_role_menu VALUES ('5', '24091');
INSERT INTO sys_role_menu VALUES ('5', '24092');
INSERT INTO sys_role_menu VALUES ('5', '24093');
INSERT INTO sys_role_menu VALUES ('5', '24094');
INSERT INTO sys_role_menu VALUES ('5', '24095');
INSERT INTO sys_role_menu VALUES ('5', '24096');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '24000');

INSERT INTO sys_role_menu VALUES ('6', '24010');
INSERT INTO sys_role_menu VALUES ('6', '24011');
INSERT INTO sys_role_menu VALUES ('6', '24012');
INSERT INTO sys_role_menu VALUES ('6', '24013');
INSERT INTO sys_role_menu VALUES ('6', '24014');
INSERT INTO sys_role_menu VALUES ('6', '24015');
INSERT INTO sys_role_menu VALUES ('6', '24016');

INSERT INTO sys_role_menu VALUES ('6', '24020');
INSERT INTO sys_role_menu VALUES ('6', '24021');
INSERT INTO sys_role_menu VALUES ('6', '24022');
INSERT INTO sys_role_menu VALUES ('6', '24023');
INSERT INTO sys_role_menu VALUES ('6', '24024');
INSERT INTO sys_role_menu VALUES ('6', '24025');
INSERT INTO sys_role_menu VALUES ('6', '24026');

INSERT INTO sys_role_menu VALUES ('6', '24030');
INSERT INTO sys_role_menu VALUES ('6', '24031');
INSERT INTO sys_role_menu VALUES ('6', '24032');
INSERT INTO sys_role_menu VALUES ('6', '24033');
INSERT INTO sys_role_menu VALUES ('6', '24034');
INSERT INTO sys_role_menu VALUES ('6', '24035');
INSERT INTO sys_role_menu VALUES ('6', '24036');

INSERT INTO sys_role_menu VALUES ('6', '24040');
INSERT INTO sys_role_menu VALUES ('6', '24041');
INSERT INTO sys_role_menu VALUES ('6', '24042');
INSERT INTO sys_role_menu VALUES ('6', '24043');
INSERT INTO sys_role_menu VALUES ('6', '24044');
INSERT INTO sys_role_menu VALUES ('6', '24045');
INSERT INTO sys_role_menu VALUES ('6', '24046');

INSERT INTO sys_role_menu VALUES ('6', '24050');
INSERT INTO sys_role_menu VALUES ('6', '24051');
INSERT INTO sys_role_menu VALUES ('6', '24052');
INSERT INTO sys_role_menu VALUES ('6', '24053');
INSERT INTO sys_role_menu VALUES ('6', '24054');
INSERT INTO sys_role_menu VALUES ('6', '24055');
INSERT INTO sys_role_menu VALUES ('6', '24056');

INSERT INTO sys_role_menu VALUES ('6', '24060');
INSERT INTO sys_role_menu VALUES ('6', '24061');
INSERT INTO sys_role_menu VALUES ('6', '24062');
INSERT INTO sys_role_menu VALUES ('6', '24063');
INSERT INTO sys_role_menu VALUES ('6', '24064');
INSERT INTO sys_role_menu VALUES ('6', '24065');
INSERT INTO sys_role_menu VALUES ('6', '24066');

INSERT INTO sys_role_menu VALUES ('6', '24070');
INSERT INTO sys_role_menu VALUES ('6', '24071');
INSERT INTO sys_role_menu VALUES ('6', '24072');
INSERT INTO sys_role_menu VALUES ('6', '24073');
INSERT INTO sys_role_menu VALUES ('6', '24074');
INSERT INTO sys_role_menu VALUES ('6', '24075');
INSERT INTO sys_role_menu VALUES ('6', '24076');

INSERT INTO sys_role_menu VALUES ('6', '24080');
INSERT INTO sys_role_menu VALUES ('6', '24081');
INSERT INTO sys_role_menu VALUES ('6', '24082');
INSERT INTO sys_role_menu VALUES ('6', '24083');
INSERT INTO sys_role_menu VALUES ('6', '24084');
INSERT INTO sys_role_menu VALUES ('6', '24085');
INSERT INTO sys_role_menu VALUES ('6', '24086');

INSERT INTO sys_role_menu VALUES ('6', '24090');
INSERT INTO sys_role_menu VALUES ('6', '24091');
INSERT INTO sys_role_menu VALUES ('6', '24092');
INSERT INTO sys_role_menu VALUES ('6', '24093');
INSERT INTO sys_role_menu VALUES ('6', '24094');
INSERT INTO sys_role_menu VALUES ('6', '24095');
INSERT INTO sys_role_menu VALUES ('6', '24096');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '24000');

INSERT INTO sys_role_menu VALUES ('7', '24010');
INSERT INTO sys_role_menu VALUES ('7', '24011');
INSERT INTO sys_role_menu VALUES ('7', '24012');
INSERT INTO sys_role_menu VALUES ('7', '24013');
INSERT INTO sys_role_menu VALUES ('7', '24014');
INSERT INTO sys_role_menu VALUES ('7', '24015');
INSERT INTO sys_role_menu VALUES ('7', '24016');

INSERT INTO sys_role_menu VALUES ('7', '24020');
INSERT INTO sys_role_menu VALUES ('7', '24021');
INSERT INTO sys_role_menu VALUES ('7', '24022');
INSERT INTO sys_role_menu VALUES ('7', '24023');
INSERT INTO sys_role_menu VALUES ('7', '24024');
INSERT INTO sys_role_menu VALUES ('7', '24025');
INSERT INTO sys_role_menu VALUES ('7', '24026');

INSERT INTO sys_role_menu VALUES ('7', '24030');
INSERT INTO sys_role_menu VALUES ('7', '24031');
INSERT INTO sys_role_menu VALUES ('7', '24032');
INSERT INTO sys_role_menu VALUES ('7', '24033');
INSERT INTO sys_role_menu VALUES ('7', '24034');
INSERT INTO sys_role_menu VALUES ('7', '24035');
INSERT INTO sys_role_menu VALUES ('7', '24036');

INSERT INTO sys_role_menu VALUES ('7', '24040');
INSERT INTO sys_role_menu VALUES ('7', '24041');
INSERT INTO sys_role_menu VALUES ('7', '24042');
INSERT INTO sys_role_menu VALUES ('7', '24043');
INSERT INTO sys_role_menu VALUES ('7', '24044');
INSERT INTO sys_role_menu VALUES ('7', '24045');
INSERT INTO sys_role_menu VALUES ('7', '24046');

INSERT INTO sys_role_menu VALUES ('7', '24050');
INSERT INTO sys_role_menu VALUES ('7', '24051');
INSERT INTO sys_role_menu VALUES ('7', '24052');
INSERT INTO sys_role_menu VALUES ('7', '24053');
INSERT INTO sys_role_menu VALUES ('7', '24054');
INSERT INTO sys_role_menu VALUES ('7', '24055');
INSERT INTO sys_role_menu VALUES ('7', '24056');

INSERT INTO sys_role_menu VALUES ('7', '24060');
INSERT INTO sys_role_menu VALUES ('7', '24061');
INSERT INTO sys_role_menu VALUES ('7', '24062');
INSERT INTO sys_role_menu VALUES ('7', '24063');
INSERT INTO sys_role_menu VALUES ('7', '24064');
INSERT INTO sys_role_menu VALUES ('7', '24065');
INSERT INTO sys_role_menu VALUES ('7', '24066');

INSERT INTO sys_role_menu VALUES ('7', '24070');
INSERT INTO sys_role_menu VALUES ('7', '24071');
INSERT INTO sys_role_menu VALUES ('7', '24072');
INSERT INTO sys_role_menu VALUES ('7', '24073');
INSERT INTO sys_role_menu VALUES ('7', '24074');
INSERT INTO sys_role_menu VALUES ('7', '24075');
INSERT INTO sys_role_menu VALUES ('7', '24076');

INSERT INTO sys_role_menu VALUES ('7', '24080');
INSERT INTO sys_role_menu VALUES ('7', '24081');
INSERT INTO sys_role_menu VALUES ('7', '24082');
INSERT INTO sys_role_menu VALUES ('7', '24083');
INSERT INTO sys_role_menu VALUES ('7', '24084');
INSERT INTO sys_role_menu VALUES ('7', '24085');
INSERT INTO sys_role_menu VALUES ('7', '24086');

INSERT INTO sys_role_menu VALUES ('7', '24090');
INSERT INTO sys_role_menu VALUES ('7', '24091');
INSERT INTO sys_role_menu VALUES ('7', '24092');
INSERT INTO sys_role_menu VALUES ('7', '24093');
INSERT INTO sys_role_menu VALUES ('7', '24094');
INSERT INTO sys_role_menu VALUES ('7', '24095');
INSERT INTO sys_role_menu VALUES ('7', '24096');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '24000');

INSERT INTO sys_role_menu VALUES ('8', '24010');
INSERT INTO sys_role_menu VALUES ('8', '24011');
INSERT INTO sys_role_menu VALUES ('8', '24012');
INSERT INTO sys_role_menu VALUES ('8', '24013');
INSERT INTO sys_role_menu VALUES ('8', '24014');
INSERT INTO sys_role_menu VALUES ('8', '24015');
INSERT INTO sys_role_menu VALUES ('8', '24016');

INSERT INTO sys_role_menu VALUES ('8', '24020');
INSERT INTO sys_role_menu VALUES ('8', '24021');
INSERT INTO sys_role_menu VALUES ('8', '24022');
INSERT INTO sys_role_menu VALUES ('8', '24023');
INSERT INTO sys_role_menu VALUES ('8', '24024');
INSERT INTO sys_role_menu VALUES ('8', '24025');
INSERT INTO sys_role_menu VALUES ('8', '24026');

INSERT INTO sys_role_menu VALUES ('8', '24030');
INSERT INTO sys_role_menu VALUES ('8', '24031');
INSERT INTO sys_role_menu VALUES ('8', '24032');
INSERT INTO sys_role_menu VALUES ('8', '24033');
INSERT INTO sys_role_menu VALUES ('8', '24034');
INSERT INTO sys_role_menu VALUES ('8', '24035');
INSERT INTO sys_role_menu VALUES ('8', '24036');

INSERT INTO sys_role_menu VALUES ('8', '24040');
INSERT INTO sys_role_menu VALUES ('8', '24041');
INSERT INTO sys_role_menu VALUES ('8', '24042');
INSERT INTO sys_role_menu VALUES ('8', '24043');
INSERT INTO sys_role_menu VALUES ('8', '24044');
INSERT INTO sys_role_menu VALUES ('8', '24045');
INSERT INTO sys_role_menu VALUES ('8', '24046');

INSERT INTO sys_role_menu VALUES ('8', '24050');
INSERT INTO sys_role_menu VALUES ('8', '24051');
INSERT INTO sys_role_menu VALUES ('8', '24052');
INSERT INTO sys_role_menu VALUES ('8', '24053');
INSERT INTO sys_role_menu VALUES ('8', '24054');
INSERT INTO sys_role_menu VALUES ('8', '24055');
INSERT INTO sys_role_menu VALUES ('8', '24056');

INSERT INTO sys_role_menu VALUES ('8', '24060');
INSERT INTO sys_role_menu VALUES ('8', '24061');
INSERT INTO sys_role_menu VALUES ('8', '24062');
INSERT INTO sys_role_menu VALUES ('8', '24063');
INSERT INTO sys_role_menu VALUES ('8', '24064');
INSERT INTO sys_role_menu VALUES ('8', '24065');
INSERT INTO sys_role_menu VALUES ('8', '24066');

INSERT INTO sys_role_menu VALUES ('8', '24070');
INSERT INTO sys_role_menu VALUES ('8', '24071');
INSERT INTO sys_role_menu VALUES ('8', '24072');
INSERT INTO sys_role_menu VALUES ('8', '24073');
INSERT INTO sys_role_menu VALUES ('8', '24074');
INSERT INTO sys_role_menu VALUES ('8', '24075');
INSERT INTO sys_role_menu VALUES ('8', '24076');

INSERT INTO sys_role_menu VALUES ('8', '24080');
INSERT INTO sys_role_menu VALUES ('8', '24081');
INSERT INTO sys_role_menu VALUES ('8', '24082');
INSERT INTO sys_role_menu VALUES ('8', '24083');
INSERT INTO sys_role_menu VALUES ('8', '24084');
INSERT INTO sys_role_menu VALUES ('8', '24085');
INSERT INTO sys_role_menu VALUES ('8', '24086');

INSERT INTO sys_role_menu VALUES ('8', '24090');
INSERT INTO sys_role_menu VALUES ('8', '24091');
INSERT INTO sys_role_menu VALUES ('8', '24092');
INSERT INTO sys_role_menu VALUES ('8', '24093');
INSERT INTO sys_role_menu VALUES ('8', '24094');
INSERT INTO sys_role_menu VALUES ('8', '24095');
INSERT INTO sys_role_menu VALUES ('8', '24096');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '24000');

INSERT INTO sys_role_menu VALUES ('9', '24010');
INSERT INTO sys_role_menu VALUES ('9', '24011');
INSERT INTO sys_role_menu VALUES ('9', '24012');
INSERT INTO sys_role_menu VALUES ('9', '24013');
INSERT INTO sys_role_menu VALUES ('9', '24014');
INSERT INTO sys_role_menu VALUES ('9', '24015');
INSERT INTO sys_role_menu VALUES ('9', '24016');

INSERT INTO sys_role_menu VALUES ('9', '24020');
INSERT INTO sys_role_menu VALUES ('9', '24021');
INSERT INTO sys_role_menu VALUES ('9', '24022');
INSERT INTO sys_role_menu VALUES ('9', '24023');
INSERT INTO sys_role_menu VALUES ('9', '24024');
INSERT INTO sys_role_menu VALUES ('9', '24025');
INSERT INTO sys_role_menu VALUES ('9', '24026');

INSERT INTO sys_role_menu VALUES ('9', '24030');
INSERT INTO sys_role_menu VALUES ('9', '24031');
INSERT INTO sys_role_menu VALUES ('9', '24032');
INSERT INTO sys_role_menu VALUES ('9', '24033');
INSERT INTO sys_role_menu VALUES ('9', '24034');
INSERT INTO sys_role_menu VALUES ('9', '24035');
INSERT INTO sys_role_menu VALUES ('9', '24036');

INSERT INTO sys_role_menu VALUES ('9', '24040');
INSERT INTO sys_role_menu VALUES ('9', '24041');
INSERT INTO sys_role_menu VALUES ('9', '24042');
INSERT INTO sys_role_menu VALUES ('9', '24043');
INSERT INTO sys_role_menu VALUES ('9', '24044');
INSERT INTO sys_role_menu VALUES ('9', '24045');
INSERT INTO sys_role_menu VALUES ('9', '24046');

INSERT INTO sys_role_menu VALUES ('9', '24050');
INSERT INTO sys_role_menu VALUES ('9', '24051');
INSERT INTO sys_role_menu VALUES ('9', '24052');
INSERT INTO sys_role_menu VALUES ('9', '24053');
INSERT INTO sys_role_menu VALUES ('9', '24054');
INSERT INTO sys_role_menu VALUES ('9', '24055');
INSERT INTO sys_role_menu VALUES ('9', '24056');

INSERT INTO sys_role_menu VALUES ('9', '24060');
INSERT INTO sys_role_menu VALUES ('9', '24061');
INSERT INTO sys_role_menu VALUES ('9', '24062');
INSERT INTO sys_role_menu VALUES ('9', '24063');
INSERT INTO sys_role_menu VALUES ('9', '24064');
INSERT INTO sys_role_menu VALUES ('9', '24065');
INSERT INTO sys_role_menu VALUES ('9', '24066');

INSERT INTO sys_role_menu VALUES ('9', '24070');
INSERT INTO sys_role_menu VALUES ('9', '24071');
INSERT INTO sys_role_menu VALUES ('9', '24072');
INSERT INTO sys_role_menu VALUES ('9', '24073');
INSERT INTO sys_role_menu VALUES ('9', '24074');
INSERT INTO sys_role_menu VALUES ('9', '24075');
INSERT INTO sys_role_menu VALUES ('9', '24076');

INSERT INTO sys_role_menu VALUES ('9', '24080');
INSERT INTO sys_role_menu VALUES ('9', '24081');
INSERT INTO sys_role_menu VALUES ('9', '24082');
INSERT INTO sys_role_menu VALUES ('9', '24083');
INSERT INTO sys_role_menu VALUES ('9', '24084');
INSERT INTO sys_role_menu VALUES ('9', '24085');
INSERT INTO sys_role_menu VALUES ('9', '24086');

INSERT INTO sys_role_menu VALUES ('9', '24090');
INSERT INTO sys_role_menu VALUES ('9', '24091');
INSERT INTO sys_role_menu VALUES ('9', '24092');
INSERT INTO sys_role_menu VALUES ('9', '24093');
INSERT INTO sys_role_menu VALUES ('9', '24094');
INSERT INTO sys_role_menu VALUES ('9', '24095');
INSERT INTO sys_role_menu VALUES ('9', '24096');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '24000');

INSERT INTO sys_role_menu VALUES ('10', '24010');
INSERT INTO sys_role_menu VALUES ('10', '24011');
INSERT INTO sys_role_menu VALUES ('10', '24012');
INSERT INTO sys_role_menu VALUES ('10', '24013');
INSERT INTO sys_role_menu VALUES ('10', '24014');
INSERT INTO sys_role_menu VALUES ('10', '24015');
INSERT INTO sys_role_menu VALUES ('10', '24016');

INSERT INTO sys_role_menu VALUES ('10', '24020');
INSERT INTO sys_role_menu VALUES ('10', '24021');
INSERT INTO sys_role_menu VALUES ('10', '24022');
INSERT INTO sys_role_menu VALUES ('10', '24023');
INSERT INTO sys_role_menu VALUES ('10', '24024');
INSERT INTO sys_role_menu VALUES ('10', '24025');
INSERT INTO sys_role_menu VALUES ('10', '24026');

INSERT INTO sys_role_menu VALUES ('10', '24030');
INSERT INTO sys_role_menu VALUES ('10', '24031');
INSERT INTO sys_role_menu VALUES ('10', '24032');
INSERT INTO sys_role_menu VALUES ('10', '24033');
INSERT INTO sys_role_menu VALUES ('10', '24034');
INSERT INTO sys_role_menu VALUES ('10', '24035');
INSERT INTO sys_role_menu VALUES ('10', '24036');

INSERT INTO sys_role_menu VALUES ('10', '24040');
INSERT INTO sys_role_menu VALUES ('10', '24041');
INSERT INTO sys_role_menu VALUES ('10', '24042');
INSERT INTO sys_role_menu VALUES ('10', '24043');
INSERT INTO sys_role_menu VALUES ('10', '24044');
INSERT INTO sys_role_menu VALUES ('10', '24045');
INSERT INTO sys_role_menu VALUES ('10', '24046');

INSERT INTO sys_role_menu VALUES ('10', '24050');
INSERT INTO sys_role_menu VALUES ('10', '24051');
INSERT INTO sys_role_menu VALUES ('10', '24052');
INSERT INTO sys_role_menu VALUES ('10', '24053');
INSERT INTO sys_role_menu VALUES ('10', '24054');
INSERT INTO sys_role_menu VALUES ('10', '24055');
INSERT INTO sys_role_menu VALUES ('10', '24056');

INSERT INTO sys_role_menu VALUES ('10', '24060');
INSERT INTO sys_role_menu VALUES ('10', '24061');
INSERT INTO sys_role_menu VALUES ('10', '24062');
INSERT INTO sys_role_menu VALUES ('10', '24063');
INSERT INTO sys_role_menu VALUES ('10', '24064');
INSERT INTO sys_role_menu VALUES ('10', '24065');
INSERT INTO sys_role_menu VALUES ('10', '24066');

INSERT INTO sys_role_menu VALUES ('10', '24070');
INSERT INTO sys_role_menu VALUES ('10', '24071');
INSERT INTO sys_role_menu VALUES ('10', '24072');
INSERT INTO sys_role_menu VALUES ('10', '24073');
INSERT INTO sys_role_menu VALUES ('10', '24074');
INSERT INTO sys_role_menu VALUES ('10', '24075');
INSERT INTO sys_role_menu VALUES ('10', '24076');

INSERT INTO sys_role_menu VALUES ('10', '24080');
INSERT INTO sys_role_menu VALUES ('10', '24081');
INSERT INTO sys_role_menu VALUES ('10', '24082');
INSERT INTO sys_role_menu VALUES ('10', '24083');
INSERT INTO sys_role_menu VALUES ('10', '24084');
INSERT INTO sys_role_menu VALUES ('10', '24085');
INSERT INTO sys_role_menu VALUES ('10', '24086');

INSERT INTO sys_role_menu VALUES ('10', '24090');
INSERT INTO sys_role_menu VALUES ('10', '24091');
INSERT INTO sys_role_menu VALUES ('10', '24092');
INSERT INTO sys_role_menu VALUES ('10', '24093');
INSERT INTO sys_role_menu VALUES ('10', '24094');
INSERT INTO sys_role_menu VALUES ('10', '24095');
INSERT INTO sys_role_menu VALUES ('10', '24096');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '24000');

INSERT INTO sys_role_menu VALUES ('11', '24010');
INSERT INTO sys_role_menu VALUES ('11', '24011');
INSERT INTO sys_role_menu VALUES ('11', '24012');
INSERT INTO sys_role_menu VALUES ('11', '24013');
INSERT INTO sys_role_menu VALUES ('11', '24014');
INSERT INTO sys_role_menu VALUES ('11', '24015');
INSERT INTO sys_role_menu VALUES ('11', '24016');

INSERT INTO sys_role_menu VALUES ('11', '24020');
INSERT INTO sys_role_menu VALUES ('11', '24021');
INSERT INTO sys_role_menu VALUES ('11', '24022');
INSERT INTO sys_role_menu VALUES ('11', '24023');
INSERT INTO sys_role_menu VALUES ('11', '24024');
INSERT INTO sys_role_menu VALUES ('11', '24025');
INSERT INTO sys_role_menu VALUES ('11', '24026');

INSERT INTO sys_role_menu VALUES ('11', '24030');
INSERT INTO sys_role_menu VALUES ('11', '24031');
INSERT INTO sys_role_menu VALUES ('11', '24032');
INSERT INTO sys_role_menu VALUES ('11', '24033');
INSERT INTO sys_role_menu VALUES ('11', '24034');
INSERT INTO sys_role_menu VALUES ('11', '24035');
INSERT INTO sys_role_menu VALUES ('11', '24036');

INSERT INTO sys_role_menu VALUES ('11', '24040');
INSERT INTO sys_role_menu VALUES ('11', '24041');
INSERT INTO sys_role_menu VALUES ('11', '24042');
INSERT INTO sys_role_menu VALUES ('11', '24043');
INSERT INTO sys_role_menu VALUES ('11', '24044');
INSERT INTO sys_role_menu VALUES ('11', '24045');
INSERT INTO sys_role_menu VALUES ('11', '24046');

INSERT INTO sys_role_menu VALUES ('11', '24050');
INSERT INTO sys_role_menu VALUES ('11', '24051');
INSERT INTO sys_role_menu VALUES ('11', '24052');
INSERT INTO sys_role_menu VALUES ('11', '24053');
INSERT INTO sys_role_menu VALUES ('11', '24054');
INSERT INTO sys_role_menu VALUES ('11', '24055');
INSERT INTO sys_role_menu VALUES ('11', '24056');

INSERT INTO sys_role_menu VALUES ('11', '24060');
INSERT INTO sys_role_menu VALUES ('11', '24061');
INSERT INTO sys_role_menu VALUES ('11', '24062');
INSERT INTO sys_role_menu VALUES ('11', '24063');
INSERT INTO sys_role_menu VALUES ('11', '24064');
INSERT INTO sys_role_menu VALUES ('11', '24065');
INSERT INTO sys_role_menu VALUES ('11', '24066');

INSERT INTO sys_role_menu VALUES ('11', '24070');
INSERT INTO sys_role_menu VALUES ('11', '24071');
INSERT INTO sys_role_menu VALUES ('11', '24072');
INSERT INTO sys_role_menu VALUES ('11', '24073');
INSERT INTO sys_role_menu VALUES ('11', '24074');
INSERT INTO sys_role_menu VALUES ('11', '24075');
INSERT INTO sys_role_menu VALUES ('11', '24076');

INSERT INTO sys_role_menu VALUES ('11', '24080');
INSERT INTO sys_role_menu VALUES ('11', '24081');
INSERT INTO sys_role_menu VALUES ('11', '24082');
INSERT INTO sys_role_menu VALUES ('11', '24083');
INSERT INTO sys_role_menu VALUES ('11', '24084');
INSERT INTO sys_role_menu VALUES ('11', '24085');
INSERT INTO sys_role_menu VALUES ('11', '24086');

INSERT INTO sys_role_menu VALUES ('11', '24090');
INSERT INTO sys_role_menu VALUES ('11', '24091');
INSERT INTO sys_role_menu VALUES ('11', '24092');
INSERT INTO sys_role_menu VALUES ('11', '24093');
INSERT INTO sys_role_menu VALUES ('11', '24094');
INSERT INTO sys_role_menu VALUES ('11', '24095');
INSERT INTO sys_role_menu VALUES ('11', '24096');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '24000');

INSERT INTO sys_role_menu VALUES ('1', '24010');
INSERT INTO sys_role_menu VALUES ('1', '24011');
INSERT INTO sys_role_menu VALUES ('1', '24012');
INSERT INTO sys_role_menu VALUES ('1', '24013');
INSERT INTO sys_role_menu VALUES ('1', '24014');
INSERT INTO sys_role_menu VALUES ('1', '24015');
INSERT INTO sys_role_menu VALUES ('1', '24016');

INSERT INTO sys_role_menu VALUES ('1', '24020');
INSERT INTO sys_role_menu VALUES ('1', '24021');
INSERT INTO sys_role_menu VALUES ('1', '24022');
INSERT INTO sys_role_menu VALUES ('1', '24023');
INSERT INTO sys_role_menu VALUES ('1', '24024');
INSERT INTO sys_role_menu VALUES ('1', '24025');
INSERT INTO sys_role_menu VALUES ('1', '24026');

INSERT INTO sys_role_menu VALUES ('1', '24030');
INSERT INTO sys_role_menu VALUES ('1', '24031');
INSERT INTO sys_role_menu VALUES ('1', '24032');
INSERT INTO sys_role_menu VALUES ('1', '24033');
INSERT INTO sys_role_menu VALUES ('1', '24034');
INSERT INTO sys_role_menu VALUES ('1', '24035');
INSERT INTO sys_role_menu VALUES ('1', '24036');

INSERT INTO sys_role_menu VALUES ('1', '24040');
INSERT INTO sys_role_menu VALUES ('1', '24041');
INSERT INTO sys_role_menu VALUES ('1', '24042');
INSERT INTO sys_role_menu VALUES ('1', '24043');
INSERT INTO sys_role_menu VALUES ('1', '24044');
INSERT INTO sys_role_menu VALUES ('1', '24045');
INSERT INTO sys_role_menu VALUES ('1', '24046');

INSERT INTO sys_role_menu VALUES ('1', '24050');
INSERT INTO sys_role_menu VALUES ('1', '24051');
INSERT INTO sys_role_menu VALUES ('1', '24052');
INSERT INTO sys_role_menu VALUES ('1', '24053');
INSERT INTO sys_role_menu VALUES ('1', '24054');
INSERT INTO sys_role_menu VALUES ('1', '24055');
INSERT INTO sys_role_menu VALUES ('1', '24056');

INSERT INTO sys_role_menu VALUES ('1', '24060');
INSERT INTO sys_role_menu VALUES ('1', '24061');
INSERT INTO sys_role_menu VALUES ('1', '24062');
INSERT INTO sys_role_menu VALUES ('1', '24063');
INSERT INTO sys_role_menu VALUES ('1', '24064');
INSERT INTO sys_role_menu VALUES ('1', '24065');
INSERT INTO sys_role_menu VALUES ('1', '24066');

INSERT INTO sys_role_menu VALUES ('1', '24070');
INSERT INTO sys_role_menu VALUES ('1', '24071');
INSERT INTO sys_role_menu VALUES ('1', '24072');
INSERT INTO sys_role_menu VALUES ('1', '24073');
INSERT INTO sys_role_menu VALUES ('1', '24074');
INSERT INTO sys_role_menu VALUES ('1', '24075');
INSERT INTO sys_role_menu VALUES ('1', '24076');

INSERT INTO sys_role_menu VALUES ('1', '24080');
INSERT INTO sys_role_menu VALUES ('1', '24081');
INSERT INTO sys_role_menu VALUES ('1', '24082');
INSERT INTO sys_role_menu VALUES ('1', '24083');
INSERT INTO sys_role_menu VALUES ('1', '24084');
INSERT INTO sys_role_menu VALUES ('1', '24085');
INSERT INTO sys_role_menu VALUES ('1', '24086');

INSERT INTO sys_role_menu VALUES ('1', '24090');
INSERT INTO sys_role_menu VALUES ('1', '24091');
INSERT INTO sys_role_menu VALUES ('1', '24092');
INSERT INTO sys_role_menu VALUES ('1', '24093');
INSERT INTO sys_role_menu VALUES ('1', '24094');
INSERT INTO sys_role_menu VALUES ('1', '24095');
INSERT INTO sys_role_menu VALUES ('1', '24096');