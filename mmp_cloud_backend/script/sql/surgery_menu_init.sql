-- ----------------------------
-- 手术管理完整菜单SQL脚本（正确版本）
-- 生成时间：2026-01-14
-- 包含7个子模块
-- ----------------------------

-- 清理旧数据
DELETE FROM sys_role_menu WHERE menu_id >= 24000 AND menu_id < 24500;
DELETE FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24500;

-- ----------------------------
-- 1. 创建手术管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('24000', '手术管理', '0', '100', 'surgery', NULL, '', 1, 0, 'M', '0', '0', '', 'user-md', 100, 1, sysdate(), NULL, NULL, '手术管理目录');

-- ----------------------------
-- 2. 创建子菜单(7个模块)
-- ----------------------------
INSERT INTO sys_menu VALUES ('24010', '手术审批表单', '24000', '10', 'surgeryApprovalForm', 'surgery/surgeryApprovalForm/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryApprovalForm:list', 'file-signature', 100, 1, sysdate(), NULL, NULL, '手术审批表单');
INSERT INTO sys_menu VALUES ('24020', '手术目录', '24000', '20', 'surgeryCatalog', 'surgery/surgeryCatalog/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryCatalog:list', 'book', 100, 1, sysdate(), NULL, NULL, '手术目录');
INSERT INTO sys_menu VALUES ('24030', '手术并发症记录', '24000', '30', 'surgeryComplicationRecord', 'surgery/surgeryComplicationRecord/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryComplicationRecord:list', 'exclamation-triangle', 100, 1, sysdate(), NULL, NULL, '手术并发症记录');
INSERT INTO sys_menu VALUES ('24040', '手术记录', '24000', '40', 'surgeryRecord', 'surgery/surgeryRecord/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryRecord:list', 'clipboard', 100, 1, sysdate(), NULL, NULL, '手术记录');
INSERT INTO sys_menu VALUES ('24050', '手术团队', '24000', '50', 'surgeryTeam', 'surgery/surgeryTeam/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryTeam:list', 'users', 100, 1, sysdate(), NULL, NULL, '手术团队');
INSERT INTO sys_menu VALUES ('24060', '手术视频', '24000', '60', 'surgeryVideo', 'surgery/surgeryVideo/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryVideo:list', 'video', 100, 1, sysdate(), NULL, NULL, '手术视频');
INSERT INTO sys_menu VALUES ('24070', '手术工作量统计', '24000', '70', 'surgeryWorkloadStatistics', 'surgery/surgeryWorkloadStatistics/index', '', 1, 0, 'C', '0', '0', 'surgery:surgeryWorkloadStatistics:list', 'chart-bar', 100, 1, sysdate(), NULL, NULL, '手术工作量统计');

-- ----------------------------
-- 3. 定义按钮权限(每个模块6个按钮，共42个按钮)
-- ----------------------------

-- 3.1 手术审批表单按钮
INSERT INTO sys_menu VALUES ('24011', '手术审批表单查询', '24010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryApprovalForm:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24012', '手术审批表单新增', '24010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryApprovalForm:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24013', '手术审批表单修改', '24010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryApprovalForm:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24014', '手术审批表单删除', '24010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryApprovalForm:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24015', '手术审批表单导入', '24010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryApprovalForm:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24016', '手术审批表单导出', '24010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryApprovalForm:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.2 手术目录按钮
INSERT INTO sys_menu VALUES ('24021', '手术目录查询', '24020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCatalog:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24022', '手术目录新增', '24020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCatalog:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24023', '手术目录修改', '24020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCatalog:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24024', '手术目录删除', '24020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCatalog:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24025', '手术目录导入', '24020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCatalog:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24026', '手术目录导出', '24020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryCatalog:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.3 手术并发症记录按钮
INSERT INTO sys_menu VALUES ('24031', '手术并发症记录查询', '24030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplicationRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24032', '手术并发症记录新增', '24030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplicationRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24033', '手术并发症记录修改', '24030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplicationRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24034', '手术并发症记录删除', '24030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplicationRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24035', '手术并发症记录导入', '24030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplicationRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24036', '手术并发症记录导出', '24030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryComplicationRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.4 手术记录按钮
INSERT INTO sys_menu VALUES ('24041', '手术记录查询', '24040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24042', '手术记录新增', '24040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24043', '手术记录修改', '24040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24044', '手术记录删除', '24040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24045', '手术记录导入', '24040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24046', '手术记录导出', '24040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.5 手术团队按钮
INSERT INTO sys_menu VALUES ('24051', '手术团队查询', '24050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24052', '手术团队新增', '24050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24053', '手术团队修改', '24050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24054', '手术团队删除', '24050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24055', '手术团队导入', '24050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24056', '手术团队导出', '24050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryTeam:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.6 手术视频按钮
INSERT INTO sys_menu VALUES ('24061', '手术视频查询', '24060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryVideo:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24062', '手术视频新增', '24060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryVideo:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24063', '手术视频修改', '24060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryVideo:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24064', '手术视频删除', '24060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryVideo:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24065', '手术视频导入', '24060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryVideo:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24066', '手术视频导出', '24060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryVideo:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.7 手术工作量统计按钮
INSERT INTO sys_menu VALUES ('24071', '手术工作量统计查询', '24070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryWorkloadStatistics:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24072', '手术工作量统计新增', '24070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryWorkloadStatistics:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24073', '手术工作量统计修改', '24070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryWorkloadStatistics:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24074', '手术工作量统计删除', '24070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryWorkloadStatistics:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24075', '手术工作量统计导入', '24070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryWorkloadStatistics:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24076', '手术工作量统计导出', '24070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'surgery:surgeryWorkloadStatistics:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 角色权限分配
-- ----------------------------

-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 24000 AND menu_id < 24100;

COMMIT;