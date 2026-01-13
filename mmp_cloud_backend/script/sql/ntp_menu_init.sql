-- ----------------------------
-- 新技术项目管理完整菜单SQL脚本
-- 生成时间：2026-01-12
-- 包含8个子模块：
--   项目管理、评估、病例、文档、推广、实施、映射、进度
-- ----------------------------

-- 清理旧数据
DELETE FROM sys_role_menu WHERE menu_id >= 21500 AND menu_id < 22000;
DELETE FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- ----------------------------
-- 1. 创建新技术项目管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('21500', '新技术项目管理', '0', '100', 'ntp', NULL, '', 1, 0, 'M', '0', '0', '', 'lightbulb', 100, 1, sysdate(), NULL, NULL, '新技术项目管理目录');

-- ----------------------------
-- 2. 创建子菜单(8个模块)
-- ----------------------------
INSERT INTO sys_menu VALUES ('21510', '新技术项目', '21500', '10', 'newTechnologyProject', 'ntp/newTechnologyProject/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProject:list', 'project-diagram', 100, 1, sysdate(), NULL, NULL, '新技术项目');
INSERT INTO sys_menu VALUES ('21520', '项目评估', '21500', '20', 'newTechnologyProjectAssessment', 'ntp/newTechnologyProjectAssessment/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProjectAssessment:list', 'clipboard-check', 100, 1, sysdate(), NULL, NULL, '项目评估');
INSERT INTO sys_menu VALUES ('21530', '项目病例', '21500', '30', 'newTechnologyProjectCase', 'ntp/newTechnologyProjectCase/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProjectCase:list', 'file-medical', 100, 1, sysdate(), NULL, NULL, '项目病例');
INSERT INTO sys_menu VALUES ('21540', '项目文档', '21500', '40', 'newTechnologyProjectDocument', 'ntp/newTechnologyProjectDocument/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProjectDocument:list', 'folder-open', 100, 1, sysdate(), NULL, NULL, '项目文档');
INSERT INTO sys_menu VALUES ('21550', '项目推广', '21500', '50', 'newTechnologyProjectExtension', 'ntp/newTechnologyProjectExtension/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProjectExtension:list', 'share-alt', 100, 1, sysdate(), NULL, NULL, '项目推广');
INSERT INTO sys_menu VALUES ('21560', '项目实施', '21500', '60', 'newTechnologyProjectImplementation', 'ntp/newTechnologyProjectImplementation/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProjectImplementation:list', 'tasks', 100, 1, sysdate(), NULL, NULL, '项目实施');
INSERT INTO sys_menu VALUES ('21570', '项目映射', '21500', '70', 'newTechnologyProjectMapping', 'ntp/newTechnologyProjectMapping/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProjectMapping:list', 'sitemap', 100, 1, sysdate(), NULL, NULL, '项目映射');
INSERT INTO sys_menu VALUES ('21580', '项目进度', '21500', '80', 'newTechnologyProjectProgress', 'ntp/newTechnologyProjectProgress/index', '', 1, 0, 'C', '0', '0', 'ntp:newTechnologyProjectProgress:list', 'chart-line', 100, 1, sysdate(), NULL, NULL, '项目进度');

-- ----------------------------
-- 3. 定义按钮权限(每个模块6个按钮)
-- ----------------------------

-- 3.1 新技术项目按钮
INSERT INTO sys_menu VALUES ('21511', '新技术项目查询', '21510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21512', '新技术项目新增', '21510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21513', '新技术项目修改', '21510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21514', '新技术项目删除', '21510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21515', '新技术项目导入', '21510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21516', '新技术项目导出', '21510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProject:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.2 项目评估按钮
INSERT INTO sys_menu VALUES ('21521', '项目评估查询', '21520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectAssessment:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21522', '项目评估新增', '21520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectAssessment:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21523', '项目评估修改', '21520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectAssessment:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21524', '项目评估删除', '21520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectAssessment:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21525', '项目评估导入', '21520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectAssessment:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21526', '项目评估导出', '21520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectAssessment:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.3 项目病例按钮
INSERT INTO sys_menu VALUES ('21531', '项目病例查询', '21530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectCase:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21532', '项目病例新增', '21530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectCase:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21533', '项目病例修改', '21530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectCase:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21534', '项目病例删除', '21530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectCase:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21535', '项目病例导入', '21530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectCase:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21536', '项目病例导出', '21530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectCase:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.4 项目文档按钮
INSERT INTO sys_menu VALUES ('21541', '项目文档查询', '21540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectDocument:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21542', '项目文档新增', '21540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectDocument:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21543', '项目文档修改', '21540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectDocument:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21544', '项目文档删除', '21540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectDocument:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21545', '项目文档导入', '21540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectDocument:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21546', '项目文档导出', '21540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectDocument:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.5 项目推广按钮
INSERT INTO sys_menu VALUES ('21551', '项目推广查询', '21550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectExtension:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21552', '项目推广新增', '21550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectExtension:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21553', '项目推广修改', '21550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectExtension:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21554', '项目推广删除', '21550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectExtension:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21555', '项目推广导入', '21550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectExtension:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21556', '项目推广导出', '21550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectExtension:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.6 项目实施按钮
INSERT INTO sys_menu VALUES ('21561', '项目实施查询', '21560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectImplementation:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21562', '项目实施新增', '21560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectImplementation:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21563', '项目实施修改', '21560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectImplementation:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21564', '项目实施删除', '21560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectImplementation:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21565', '项目实施导入', '21560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectImplementation:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21566', '项目实施导出', '21560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectImplementation:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.7 项目映射按钮
INSERT INTO sys_menu VALUES ('21571', '项目映射查询', '21570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectMapping:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21572', '项目映射新增', '21570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectMapping:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21573', '项目映射修改', '21570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectMapping:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21574', '项目映射删除', '21570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectMapping:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21575', '项目映射导入', '21570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectMapping:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21576', '项目映射导出', '21570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectMapping:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 3.8 项目进度按钮
INSERT INTO sys_menu VALUES ('21581', '项目进度查询', '21580', '1', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectProgress:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21582', '项目进度新增', '21580', '2', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectProgress:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21583', '项目进度修改', '21580', '3', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectProgress:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21584', '项目进度删除', '21580', '4', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectProgress:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21585', '项目进度导入', '21580', '5', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectProgress:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21586', '项目进度导出', '21580', '6', '#', '', '', 1, 0, 'F', '0', '0', 'ntp:newTechnologyProjectProgress:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------

-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 21500 AND menu_id < 22000;

COMMIT;