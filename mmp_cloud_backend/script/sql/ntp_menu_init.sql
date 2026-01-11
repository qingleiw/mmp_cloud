-- ----------------------------
-- 新技术项目管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建新技术项目管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('21500', '新技术项目管理', '0', '100', 'ntp', NULL, '', 1, 0, 'M', '0', '0', '', 'lightbulb', 100, 1, sysdate(), NULL, NULL, '新技术项目管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('21510', '新技术项目', '21500', '10', 'newTechnologyProject', 'ntp/newTechnologyProject/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProject:list', 'project-diagram', 100, 1, sysdate(), NULL, NULL, '新技术项目');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 新技术项目按钮
INSERT INTO sys_menu VALUES ('21511', '新技术项目查询', '21510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21512', '新技术项目新增', '21510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21513', '新技术项目修改', '21510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21514', '新技术项目删除', '21510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21515', '新技术项目导入', '21510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21516', '新技术项目导出', '21510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '21500');

INSERT INTO sys_role_menu VALUES ('5', '21510');
INSERT INTO sys_role_menu VALUES ('5', '21511');
INSERT INTO sys_role_menu VALUES ('5', '21512');
INSERT INTO sys_role_menu VALUES ('5', '21513');
INSERT INTO sys_role_menu VALUES ('5', '21514');
INSERT INTO sys_role_menu VALUES ('5', '21515');
INSERT INTO sys_role_menu VALUES ('5', '21516');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '21500');

INSERT INTO sys_role_menu VALUES ('6', '21510');
INSERT INTO sys_role_menu VALUES ('6', '21511');
INSERT INTO sys_role_menu VALUES ('6', '21512');
INSERT INTO sys_role_menu VALUES ('6', '21513');
INSERT INTO sys_role_menu VALUES ('6', '21514');
INSERT INTO sys_role_menu VALUES ('6', '21515');
INSERT INTO sys_role_menu VALUES ('6', '21516');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '21500');

INSERT INTO sys_role_menu VALUES ('7', '21510');
INSERT INTO sys_role_menu VALUES ('7', '21511');
INSERT INTO sys_role_menu VALUES ('7', '21512');
INSERT INTO sys_role_menu VALUES ('7', '21513');
INSERT INTO sys_role_menu VALUES ('7', '21514');
INSERT INTO sys_role_menu VALUES ('7', '21515');
INSERT INTO sys_role_menu VALUES ('7', '21516');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '21500');

INSERT INTO sys_role_menu VALUES ('8', '21510');
INSERT INTO sys_role_menu VALUES ('8', '21511');
INSERT INTO sys_role_menu VALUES ('8', '21512');
INSERT INTO sys_role_menu VALUES ('8', '21513');
INSERT INTO sys_role_menu VALUES ('8', '21514');
INSERT INTO sys_role_menu VALUES ('8', '21515');
INSERT INTO sys_role_menu VALUES ('8', '21516');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '21500');

INSERT INTO sys_role_menu VALUES ('9', '21510');
INSERT INTO sys_role_menu VALUES ('9', '21511');
INSERT INTO sys_role_menu VALUES ('9', '21512');
INSERT INTO sys_role_menu VALUES ('9', '21513');
INSERT INTO sys_role_menu VALUES ('9', '21514');
INSERT INTO sys_role_menu VALUES ('9', '21515');
INSERT INTO sys_role_menu VALUES ('9', '21516');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '21500');

INSERT INTO sys_role_menu VALUES ('10', '21510');
INSERT INTO sys_role_menu VALUES ('10', '21511');
INSERT INTO sys_role_menu VALUES ('10', '21512');
INSERT INTO sys_role_menu VALUES ('10', '21513');
INSERT INTO sys_role_menu VALUES ('10', '21514');
INSERT INTO sys_role_menu VALUES ('10', '21515');
INSERT INTO sys_role_menu VALUES ('10', '21516');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '21500');

INSERT INTO sys_role_menu VALUES ('11', '21510');
INSERT INTO sys_role_menu VALUES ('11', '21511');
INSERT INTO sys_role_menu VALUES ('11', '21512');
INSERT INTO sys_role_menu VALUES ('11', '21513');
INSERT INTO sys_role_menu VALUES ('11', '21514');
INSERT INTO sys_role_menu VALUES ('11', '21515');
INSERT INTO sys_role_menu VALUES ('11', '21516');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '21500');

INSERT INTO sys_role_menu VALUES ('1', '21510');
INSERT INTO sys_role_menu VALUES ('1', '21511');
INSERT INTO sys_role_menu VALUES ('1', '21512');
INSERT INTO sys_role_menu VALUES ('1', '21513');
INSERT INTO sys_role_menu VALUES ('1', '21514');
INSERT INTO sys_role_menu VALUES ('1', '21515');
INSERT INTO sys_role_menu VALUES ('1', '21516');