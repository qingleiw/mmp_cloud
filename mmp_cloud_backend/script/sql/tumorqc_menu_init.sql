-- ----------------------------
-- 肿瘤质控菜单SQL脚本
-- 生成时间：2026-01-16
-- 根据实际目录结构修正
-- ----------------------------
DELETE FROM sys_role_menu WHERE menu_id >= 24500 AND menu_id < 25000;
DELETE FROM sys_menu WHERE menu_id >= 24500 AND menu_id < 25000;

-- ----------------------------
-- 1. 创建肿瘤质控主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('24500', '肿瘤质控', '0', '100', 'tumorqc', NULL, '', 1, 0, 'M', '0', '0', '', 'microscope', 100, 1, sysdate(), NULL, NULL, '肿瘤质控目录');

-- ----------------------------
-- 2. 创建子菜单（根据实际目录结构）
-- ----------------------------
INSERT INTO sys_menu VALUES ('24510', '肿瘤质控指标配置', '24500', '10', 'tumorQcIndicatorConfig', 'tumorqc/tumorQcIndicatorConfig/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcIndicatorConfig:list', 'cogs', 100, 1, sysdate(), NULL, NULL, '肿瘤质控指标配置');
INSERT INTO sys_menu VALUES ('24520', '肿瘤质控指标明细', '24500', '20', 'tumorQcIndicatorDetail', 'tumorqc/tumorQcIndicatorDetail/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcIndicatorDetail:list', 'list-alt', 100, 1, sysdate(), NULL, NULL, '肿瘤质控指标明细');
INSERT INTO sys_menu VALUES ('24530', '肿瘤质控指标记录', '24500', '30', 'tumorQcIndicatorRecord', 'tumorqc/tumorQcIndicatorRecord/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcIndicatorRecord:list', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '肿瘤质控指标记录');
INSERT INTO sys_menu VALUES ('24540', '肿瘤质控检查', '24500', '40', 'tumorQcInspection', 'tumorqc/tumorQcInspection/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcInspection:list', 'search', 100, 1, sysdate(), NULL, NULL, '肿瘤质控检查');
INSERT INTO sys_menu VALUES ('24550', '肿瘤质控计划', '24500', '50', 'tumorQcPlan', 'tumorqc/tumorQcPlan/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcPlan:list', 'clipboard-check', 100, 1, sysdate(), NULL, NULL, '肿瘤质控计划');
INSERT INTO sys_menu VALUES ('24560', '肿瘤质控整改', '24500', '60', 'tumorQcRectification', 'tumorqc/tumorQcRectification/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcRectification:list', 'wrench', 100, 1, sysdate(), NULL, NULL, '肿瘤质控整改');
INSERT INTO sys_menu VALUES ('24570', '肿瘤质控报告', '24500', '70', 'tumorQcReport', 'tumorqc/tumorQcReport/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcReport:list', 'file-alt', 100, 1, sysdate(), NULL, NULL, '肿瘤质控报告');
INSERT INTO sys_menu VALUES ('24580', '肿瘤质控结果', '24500', '80', 'tumorQcResult', 'tumorqc/tumorQcResult/index', '', 1, 0, 'C', '0', '0', 'tumorqc:tumorQcResult:list', 'check-circle', 100, 1, sysdate(), NULL, NULL, '肿瘤质控结果');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 肿瘤质控指标配置按钮
INSERT INTO sys_menu VALUES ('24511', '肿瘤质控指标配置查询', '24510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24512', '肿瘤质控指标配置新增', '24510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24513', '肿瘤质控指标配置修改', '24510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24514', '肿瘤质控指标配置删除', '24510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24515', '肿瘤质控指标配置导入', '24510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24516', '肿瘤质控指标配置导出', '24510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorConfig:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控指标明细按钮
INSERT INTO sys_menu VALUES ('24521', '肿瘤质控指标明细查询', '24520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorDetail:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24522', '肿瘤质控指标明细新增', '24520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorDetail:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24523', '肿瘤质控指标明细修改', '24520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorDetail:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24524', '肿瘤质控指标明细删除', '24520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorDetail:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24525', '肿瘤质控指标明细导入', '24520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorDetail:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24526', '肿瘤质控指标明细导出', '24520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorDetail:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控指标记录按钮
INSERT INTO sys_menu VALUES ('24531', '肿瘤质控指标记录查询', '24530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24532', '肿瘤质控指标记录新增', '24530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24533', '肿瘤质控指标记录修改', '24530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24534', '肿瘤质控指标记录删除', '24530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24535', '肿瘤质控指标记录导入', '24530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24536', '肿瘤质控指标记录导出', '24530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcIndicatorRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控检查按钮
INSERT INTO sys_menu VALUES ('24541', '肿瘤质控检查查询', '24540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcInspection:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24542', '肿瘤质控检查新增', '24540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcInspection:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24543', '肿瘤质控检查修改', '24540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcInspection:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24544', '肿瘤质控检查删除', '24540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcInspection:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24545', '肿瘤质控检查导入', '24540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcInspection:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24546', '肿瘤质控检查导出', '24540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcInspection:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控计划按钮
INSERT INTO sys_menu VALUES ('24551', '肿瘤质控计划查询', '24550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24552', '肿瘤质控计划新增', '24550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24553', '肿瘤质控计划修改', '24550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24554', '肿瘤质控计划删除', '24550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24555', '肿瘤质控计划导入', '24550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24556', '肿瘤质控计划导出', '24550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控整改按钮
INSERT INTO sys_menu VALUES ('24561', '肿瘤质控整改查询', '24560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRectification:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24562', '肿瘤质控整改新增', '24560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRectification:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24563', '肿瘤质控整改修改', '24560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRectification:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24564', '肿瘤质控整改删除', '24560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRectification:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24565', '肿瘤质控整改导入', '24560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRectification:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24566', '肿瘤质控整改导出', '24560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcRectification:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控报告按钮
INSERT INTO sys_menu VALUES ('24571', '肿瘤质控报告查询', '24570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcReport:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24572', '肿瘤质控报告新增', '24570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcReport:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24573', '肿瘤质控报告修改', '24570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcReport:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24574', '肿瘤质控报告删除', '24570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcReport:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24575', '肿瘤质控报告导入', '24570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcReport:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24576', '肿瘤质控报告导出', '24570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcReport:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 肿瘤质控结果按钮
INSERT INTO sys_menu VALUES ('24581', '肿瘤质控结果查询', '24580', '1', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcResult:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24582', '肿瘤质控结果新增', '24580', '2', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcResult:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24583', '肿瘤质控结果修改', '24580', '3', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcResult:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24584', '肿瘤质控结果删除', '24580', '4', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcResult:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24585', '肿瘤质控结果导入', '24580', '5', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcResult:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('24586', '肿瘤质控结果导出', '24580', '6', '#', '', '', 1, 0, 'F', '0', '0', 'tumorqc:tumorQcResult:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配（批量方式）
-- ----------------------------
-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 24500 AND menu_id <= 24586;

COMMIT;
