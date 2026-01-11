-- ----------------------------
-- 投诉纠纷菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建投诉纠纷主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25000', '投诉纠纷', '0', '100', 'complaindispute', NULL, '', 1, 0, 'M', '0', '0', '', 'balance-scale', 100, 1, sysdate(), NULL, NULL, '投诉纠纷目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25010', '投诉纠纷', '25000', '10', 'complaintDispute', 'complaindispute/complaintDispute/index', '', 1, 0, 'C', '0', '0', 'complaindispute:complaintDispute:list', 'gavel', 100, 1, sysdate(), NULL, NULL, '投诉纠纷');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 投诉纠纷按钮
INSERT INTO sys_menu VALUES ('25011', '投诉纠纷查询', '25010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'complaindispute:complaintDispute:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25012', '投诉纠纷新增', '25010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'complaindispute:complaintDispute:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25013', '投诉纠纷修改', '25010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'complaindispute:complaintDispute:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25014', '投诉纠纷删除', '25010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'complaindispute:complaintDispute:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25015', '投诉纠纷导入', '25010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'complaindispute:complaintDispute:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25016', '投诉纠纷导出', '25010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'complaindispute:complaintDispute:export', '#', 100, 1, sysdate(), NULL, NULL, '');