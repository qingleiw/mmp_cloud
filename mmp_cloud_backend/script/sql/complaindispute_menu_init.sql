-- ----------------------------
-- 投诉纠纷菜单SQL脚本
-- 生成时间：2026-01-17
-- 包含：投诉纠纷主、投诉处理、投诉调查
-- ----------------------------
DELETE FROM sys_role_menu WHERE menu_id >= 25000 AND menu_id < 25500;
DELETE FROM sys_menu WHERE menu_id >= 25000 AND menu_id < 25500;

-- ----------------------------
-- 1. 创建投诉纠纷主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('25000', '投诉纠纷管理', '0', '100', 'complaintdispute', NULL, '', 1, 0, 'M', '0', '0', '', 'balance-scale', 100, 1, sysdate(), NULL, NULL, '投诉纠纷管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
-- 2.1 投诉纠纷主菜单
INSERT INTO sys_menu VALUES ('25010', '投诉纠纷', '25000', '10', 'complaintDispute', 'complaindispute/complaintDispute/index', '', 1, 0, 'C', '0', '0', 'complaintdispute:complaintDispute:list', 'gavel', 100, 1, sysdate(), NULL, NULL, '投诉纠纷主菜单');

-- 2.2 投诉处理菜单
INSERT INTO sys_menu VALUES ('25020', '投诉处理', '25000', '20', 'complaintHandling', 'complaindispute/complaintHandling/index', '', 1, 0, 'C', '0', '0', 'complaintdispute:complaintHandling:list', 'edit', 100, 1, sysdate(), NULL, NULL, '投诉处理菜单');

-- 2.3 投诉调查菜单
INSERT INTO sys_menu VALUES ('25030', '投诉调查', '25000', '30', 'complaintInvestigation', 'complaindispute/complaintInvestigation/index', '', 1, 0, 'C', '0', '0', 'complaintdispute:complaintInvestigation:list', 'search', 100, 1, sysdate(), NULL, NULL, '投诉调查菜单');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------

-- 3.1 投诉纠纷按钮权限
INSERT INTO sys_menu VALUES ('25011', '投诉纠纷查询', '25010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25012', '投诉纠纷新增', '25010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25013', '投诉纠纷修改', '25010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25014', '投诉纠纷删除', '25010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25015', '投诉纠纷导入', '25010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25016', '投诉纠纷导出', '25010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintDispute:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.2 投诉处理按钮权限
INSERT INTO sys_menu VALUES ('25021', '投诉处理查询', '25020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintHandling:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25022', '投诉处理新增', '25020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintHandling:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25023', '投诉处理修改', '25020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintHandling:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25024', '投诉处理删除', '25020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintHandling:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25025', '投诉处理导入', '25020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintHandling:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25026', '投诉处理导出', '25020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintHandling:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.3 投诉调查按钮权限
INSERT INTO sys_menu VALUES ('25031', '投诉调查查询', '25030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintInvestigation:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25032', '投诉调查新增', '25030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintInvestigation:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25033', '投诉调查修改', '25030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintInvestigation:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25034', '投诉调查删除', '25030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintInvestigation:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25035', '投诉调查导入', '25030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintInvestigation:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('25036', '投诉调查导出', '25030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'complaintdispute:complaintInvestigation:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------

-- 4.1 为护士角色(role_id=5)分配权限
INSERT INTO sys_role_menu VALUES ('5', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('5', '25010');
INSERT INTO sys_role_menu VALUES ('5', '25011');
INSERT INTO sys_role_menu VALUES ('5', '25012');
INSERT INTO sys_role_menu VALUES ('5', '25013');
INSERT INTO sys_role_menu VALUES ('5', '25014');
INSERT INTO sys_role_menu VALUES ('5', '25015');
INSERT INTO sys_role_menu VALUES ('5', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('5', '25020');
INSERT INTO sys_role_menu VALUES ('5', '25021');
INSERT INTO sys_role_menu VALUES ('5', '25022');
INSERT INTO sys_role_menu VALUES ('5', '25023');
INSERT INTO sys_role_menu VALUES ('5', '25024');
INSERT INTO sys_role_menu VALUES ('5', '25025');
INSERT INTO sys_role_menu VALUES ('5', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('5', '25030');
INSERT INTO sys_role_menu VALUES ('5', '25031');
INSERT INTO sys_role_menu VALUES ('5', '25032');
INSERT INTO sys_role_menu VALUES ('5', '25033');
INSERT INTO sys_role_menu VALUES ('5', '25034');
INSERT INTO sys_role_menu VALUES ('5', '25035');
INSERT INTO sys_role_menu VALUES ('5', '25036');

-- 4.2 为医生角色(role_id=6)分配权限
INSERT INTO sys_role_menu VALUES ('6', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('6', '25010');
INSERT INTO sys_role_menu VALUES ('6', '25011');
INSERT INTO sys_role_menu VALUES ('6', '25012');
INSERT INTO sys_role_menu VALUES ('6', '25013');
INSERT INTO sys_role_menu VALUES ('6', '25014');
INSERT INTO sys_role_menu VALUES ('6', '25015');
INSERT INTO sys_role_menu VALUES ('6', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('6', '25020');
INSERT INTO sys_role_menu VALUES ('6', '25021');
INSERT INTO sys_role_menu VALUES ('6', '25022');
INSERT INTO sys_role_menu VALUES ('6', '25023');
INSERT INTO sys_role_menu VALUES ('6', '25024');
INSERT INTO sys_role_menu VALUES ('6', '25025');
INSERT INTO sys_role_menu VALUES ('6', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('6', '25030');
INSERT INTO sys_role_menu VALUES ('6', '25031');
INSERT INTO sys_role_menu VALUES ('6', '25032');
INSERT INTO sys_role_menu VALUES ('6', '25033');
INSERT INTO sys_role_menu VALUES ('6', '25034');
INSERT INTO sys_role_menu VALUES ('6', '25035');
INSERT INTO sys_role_menu VALUES ('6', '25036');

-- 4.3 为科室主任(role_id=7)分配权限
INSERT INTO sys_role_menu VALUES ('7', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('7', '25010');
INSERT INTO sys_role_menu VALUES ('7', '25011');
INSERT INTO sys_role_menu VALUES ('7', '25012');
INSERT INTO sys_role_menu VALUES ('7', '25013');
INSERT INTO sys_role_menu VALUES ('7', '25014');
INSERT INTO sys_role_menu VALUES ('7', '25015');
INSERT INTO sys_role_menu VALUES ('7', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('7', '25020');
INSERT INTO sys_role_menu VALUES ('7', '25021');
INSERT INTO sys_role_menu VALUES ('7', '25022');
INSERT INTO sys_role_menu VALUES ('7', '25023');
INSERT INTO sys_role_menu VALUES ('7', '25024');
INSERT INTO sys_role_menu VALUES ('7', '25025');
INSERT INTO sys_role_menu VALUES ('7', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('7', '25030');
INSERT INTO sys_role_menu VALUES ('7', '25031');
INSERT INTO sys_role_menu VALUES ('7', '25032');
INSERT INTO sys_role_menu VALUES ('7', '25033');
INSERT INTO sys_role_menu VALUES ('7', '25034');
INSERT INTO sys_role_menu VALUES ('7', '25035');
INSERT INTO sys_role_menu VALUES ('7', '25036');

-- 4.4 为质控员(role_id=8)分配权限
INSERT INTO sys_role_menu VALUES ('8', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('8', '25010');
INSERT INTO sys_role_menu VALUES ('8', '25011');
INSERT INTO sys_role_menu VALUES ('8', '25012');
INSERT INTO sys_role_menu VALUES ('8', '25013');
INSERT INTO sys_role_menu VALUES ('8', '25014');
INSERT INTO sys_role_menu VALUES ('8', '25015');
INSERT INTO sys_role_menu VALUES ('8', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('8', '25020');
INSERT INTO sys_role_menu VALUES ('8', '25021');
INSERT INTO sys_role_menu VALUES ('8', '25022');
INSERT INTO sys_role_menu VALUES ('8', '25023');
INSERT INTO sys_role_menu VALUES ('8', '25024');
INSERT INTO sys_role_menu VALUES ('8', '25025');
INSERT INTO sys_role_menu VALUES ('8', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('8', '25030');
INSERT INTO sys_role_menu VALUES ('8', '25031');
INSERT INTO sys_role_menu VALUES ('8', '25032');
INSERT INTO sys_role_menu VALUES ('8', '25033');
INSERT INTO sys_role_menu VALUES ('8', '25034');
INSERT INTO sys_role_menu VALUES ('8', '25035');
INSERT INTO sys_role_menu VALUES ('8', '25036');

-- 4.5 为医务部(role_id=9)分配权限
INSERT INTO sys_role_menu VALUES ('9', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('9', '25010');
INSERT INTO sys_role_menu VALUES ('9', '25011');
INSERT INTO sys_role_menu VALUES ('9', '25012');
INSERT INTO sys_role_menu VALUES ('9', '25013');
INSERT INTO sys_role_menu VALUES ('9', '25014');
INSERT INTO sys_role_menu VALUES ('9', '25015');
INSERT INTO sys_role_menu VALUES ('9', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('9', '25020');
INSERT INTO sys_role_menu VALUES ('9', '25021');
INSERT INTO sys_role_menu VALUES ('9', '25022');
INSERT INTO sys_role_menu VALUES ('9', '25023');
INSERT INTO sys_role_menu VALUES ('9', '25024');
INSERT INTO sys_role_menu VALUES ('9', '25025');
INSERT INTO sys_role_menu VALUES ('9', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('9', '25030');
INSERT INTO sys_role_menu VALUES ('9', '25031');
INSERT INTO sys_role_menu VALUES ('9', '25032');
INSERT INTO sys_role_menu VALUES ('9', '25033');
INSERT INTO sys_role_menu VALUES ('9', '25034');
INSERT INTO sys_role_menu VALUES ('9', '25035');
INSERT INTO sys_role_menu VALUES ('9', '25036');

-- 4.6 为医务部主任(role_id=10)分配权限
INSERT INTO sys_role_menu VALUES ('10', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('10', '25010');
INSERT INTO sys_role_menu VALUES ('10', '25011');
INSERT INTO sys_role_menu VALUES ('10', '25012');
INSERT INTO sys_role_menu VALUES ('10', '25013');
INSERT INTO sys_role_menu VALUES ('10', '25014');
INSERT INTO sys_role_menu VALUES ('10', '25015');
INSERT INTO sys_role_menu VALUES ('10', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('10', '25020');
INSERT INTO sys_role_menu VALUES ('10', '25021');
INSERT INTO sys_role_menu VALUES ('10', '25022');
INSERT INTO sys_role_menu VALUES ('10', '25023');
INSERT INTO sys_role_menu VALUES ('10', '25024');
INSERT INTO sys_role_menu VALUES ('10', '25025');
INSERT INTO sys_role_menu VALUES ('10', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('10', '25030');
INSERT INTO sys_role_menu VALUES ('10', '25031');
INSERT INTO sys_role_menu VALUES ('10', '25032');
INSERT INTO sys_role_menu VALUES ('10', '25033');
INSERT INTO sys_role_menu VALUES ('10', '25034');
INSERT INTO sys_role_menu VALUES ('10', '25035');
INSERT INTO sys_role_menu VALUES ('10', '25036');

-- 4.7 为医院管理员(role_id=11)分配权限
INSERT INTO sys_role_menu VALUES ('11', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('11', '25010');
INSERT INTO sys_role_menu VALUES ('11', '25011');
INSERT INTO sys_role_menu VALUES ('11', '25012');
INSERT INTO sys_role_menu VALUES ('11', '25013');
INSERT INTO sys_role_menu VALUES ('11', '25014');
INSERT INTO sys_role_menu VALUES ('11', '25015');
INSERT INTO sys_role_menu VALUES ('11', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('11', '25020');
INSERT INTO sys_role_menu VALUES ('11', '25021');
INSERT INTO sys_role_menu VALUES ('11', '25022');
INSERT INTO sys_role_menu VALUES ('11', '25023');
INSERT INTO sys_role_menu VALUES ('11', '25024');
INSERT INTO sys_role_menu VALUES ('11', '25025');
INSERT INTO sys_role_menu VALUES ('11', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('11', '25030');
INSERT INTO sys_role_menu VALUES ('11', '25031');
INSERT INTO sys_role_menu VALUES ('11', '25032');
INSERT INTO sys_role_menu VALUES ('11', '25033');
INSERT INTO sys_role_menu VALUES ('11', '25034');
INSERT INTO sys_role_menu VALUES ('11', '25035');
INSERT INTO sys_role_menu VALUES ('11', '25036');

-- 4.8 为超级管理员(role_id=1)分配权限
INSERT INTO sys_role_menu VALUES ('1', '25000');
-- 投诉纠纷
INSERT INTO sys_role_menu VALUES ('1', '25010');
INSERT INTO sys_role_menu VALUES ('1', '25011');
INSERT INTO sys_role_menu VALUES ('1', '25012');
INSERT INTO sys_role_menu VALUES ('1', '25013');
INSERT INTO sys_role_menu VALUES ('1', '25014');
INSERT INTO sys_role_menu VALUES ('1', '25015');
INSERT INTO sys_role_menu VALUES ('1', '25016');
-- 投诉处理
INSERT INTO sys_role_menu VALUES ('1', '25020');
INSERT INTO sys_role_menu VALUES ('1', '25021');
INSERT INTO sys_role_menu VALUES ('1', '25022');
INSERT INTO sys_role_menu VALUES ('1', '25023');
INSERT INTO sys_role_menu VALUES ('1', '25024');
INSERT INTO sys_role_menu VALUES ('1', '25025');
INSERT INTO sys_role_menu VALUES ('1', '25026');
-- 投诉调查
INSERT INTO sys_role_menu VALUES ('1', '25030');
INSERT INTO sys_role_menu VALUES ('1', '25031');
INSERT INTO sys_role_menu VALUES ('1', '25032');
INSERT INTO sys_role_menu VALUES ('1', '25033');
INSERT INTO sys_role_menu VALUES ('1', '25034');
INSERT INTO sys_role_menu VALUES ('1', '25035');
INSERT INTO sys_role_menu VALUES ('1', '25036');

-- ----------------------------
-- 执行完成提示
-- ----------------------------
-- 菜单ID分配说明：
-- 25000: 投诉纠纷管理主目录
-- 25010-25016: 投诉纠纷及其按钮权限
-- 25020-25026: 投诉处理及其按钮权限
-- 25030-25036: 投诉调查及其按钮权限
-- ----------------------------
COMMIT;