-- ----------------------------
-- 投诉纠纷菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------
DELETE FROM sys_role_menu WHERE menu_id >= 25000 AND menu_id < 25500;
DELETE FROM sys_menu WHERE menu_id >= 25000 AND menu_id < 25500;

-- ----------------------------
-- 1. 创建投诉纠纷主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25000', '投诉纠纷', '0', '100', 'complaintdispute', NULL, '', 1, 0, 'M', '0', '0', '', 'balance-scale', 100, 1, sysdate(), NULL, NULL, '投诉纠纷目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25010', '投诉纠纷', '25000', '10', 'complaintDispute', 'complaintdispute/complaintDispute/index', '', 1, 0, 'C', '0', '0', 'complaintdispute:complaintDispute:list', 'gavel', 100, 1, sysdate(), NULL, NULL, '投诉纠纷');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 投诉纠纷按钮
INSERT INTO sys_menu VALUES ('25011', '投诉纠纷查询', '25010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25012', '投诉纠纷新增', '25010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25013', '投诉纠纷修改', '25010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25014', '投诉纠纷删除', '25010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25015', '投诉纠纷导入', '25010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25016', '投诉纠纷导出', '25010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '25000');

INSERT INTO sys_role_menu VALUES ('5', '25010');
INSERT INTO sys_role_menu VALUES ('5', '25011');
INSERT INTO sys_role_menu VALUES ('5', '25012');
INSERT INTO sys_role_menu VALUES ('5', '25013');
INSERT INTO sys_role_menu VALUES ('5', '25014');
INSERT INTO sys_role_menu VALUES ('5', '25015');
INSERT INTO sys_role_menu VALUES ('5', '25016');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '25000');

INSERT INTO sys_role_menu VALUES ('6', '25010');
INSERT INTO sys_role_menu VALUES ('6', '25011');
INSERT INTO sys_role_menu VALUES ('6', '25012');
INSERT INTO sys_role_menu VALUES ('6', '25013');
INSERT INTO sys_role_menu VALUES ('6', '25014');
INSERT INTO sys_role_menu VALUES ('6', '25015');
INSERT INTO sys_role_menu VALUES ('6', '25016');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '25000');

INSERT INTO sys_role_menu VALUES ('7', '25010');
INSERT INTO sys_role_menu VALUES ('7', '25011');
INSERT INTO sys_role_menu VALUES ('7', '25012');
INSERT INTO sys_role_menu VALUES ('7', '25013');
INSERT INTO sys_role_menu VALUES ('7', '25014');
INSERT INTO sys_role_menu VALUES ('7', '25015');
INSERT INTO sys_role_menu VALUES ('7', '25016');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '25000');

INSERT INTO sys_role_menu VALUES ('8', '25010');
INSERT INTO sys_role_menu VALUES ('8', '25011');
INSERT INTO sys_role_menu VALUES ('8', '25012');
INSERT INTO sys_role_menu VALUES ('8', '25013');
INSERT INTO sys_role_menu VALUES ('8', '25014');
INSERT INTO sys_role_menu VALUES ('8', '25015');
INSERT INTO sys_role_menu VALUES ('8', '25016');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '25000');

INSERT INTO sys_role_menu VALUES ('9', '25010');
INSERT INTO sys_role_menu VALUES ('9', '25011');
INSERT INTO sys_role_menu VALUES ('9', '25012');
INSERT INTO sys_role_menu VALUES ('9', '25013');
INSERT INTO sys_role_menu VALUES ('9', '25014');
INSERT INTO sys_role_menu VALUES ('9', '25015');
INSERT INTO sys_role_menu VALUES ('9', '25016');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '25000');

INSERT INTO sys_role_menu VALUES ('10', '25010');
INSERT INTO sys_role_menu VALUES ('10', '25011');
INSERT INTO sys_role_menu VALUES ('10', '25012');
INSERT INTO sys_role_menu VALUES ('10', '25013');
INSERT INTO sys_role_menu VALUES ('10', '25014');
INSERT INTO sys_role_menu VALUES ('10', '25015');
INSERT INTO sys_role_menu VALUES ('10', '25016');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '25000');

INSERT INTO sys_role_menu VALUES ('11', '25010');
INSERT INTO sys_role_menu VALUES ('11', '25011');
INSERT INTO sys_role_menu VALUES ('11', '25012');
INSERT INTO sys_role_menu VALUES ('11', '25013');
INSERT INTO sys_role_menu VALUES ('11', '25014');
INSERT INTO sys_role_menu VALUES ('11', '25015');
INSERT INTO sys_role_menu VALUES ('11', '25016');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '25000');

INSERT INTO sys_role_menu VALUES ('1', '25010');
INSERT INTO sys_role_menu VALUES ('1', '25011');
INSERT INTO sys_role_menu VALUES ('1', '25012');
INSERT INTO sys_role_menu VALUES ('1', '25013');
INSERT INTO sys_role_menu VALUES ('1', '25014');
INSERT INTO sys_role_menu VALUES ('1', '25015');
INSERT INTO sys_role_menu VALUES ('1', '25016');