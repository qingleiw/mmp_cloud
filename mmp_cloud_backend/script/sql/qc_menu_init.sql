-- ----------------------------
-- 质量控制菜单SQL脚本
-- 生成时间：2026-01-14
-- 根据实际目录结构更新
-- ----------------------------
DELETE FROM sys_role_menu WHERE menu_id >= 22000 AND menu_id < 22500;
DELETE FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;
-- ----------------------------
-- 1. 创建质量控制主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('22000', '质量控制', '0', '100', 'qc', NULL, '', 1, 0, 'M', '0', '0', '', 'check-circle', 100, 1, sysdate(), NULL, NULL, '质量控制目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('22010', '质量数据采集', '22000', '10', 'qcDataCollection', 'qc/qcDataCollection/index', '', 1, 0, 'C', '0', '0', 'qc:qcDataCollection:list', 'database', 100, 1, sysdate(), NULL, NULL, '质量数据采集');
INSERT INTO sys_menu VALUES ('22020', '指标采集配置', '22000', '20', 'qcIndicatorCollectionConfig', 'qc/qcIndicatorCollectionConfig/index', '', 1, 0, 'C', '0', '0', 'qc:qcIndicatorCollectionConfig:list', 'cogs', 100, 1, sysdate(), NULL, NULL, '指标采集配置');
INSERT INTO sys_menu VALUES ('22030', '指标要素', '22000', '30', 'qcIndicatorFactor', 'qc/qcIndicatorFactor/index', '', 1, 0, 'C', '0', '0', 'qc:qcIndicatorFactor:list', 'puzzle-piece', 100, 1, sysdate(), NULL, NULL, '指标要素');
INSERT INTO sys_menu VALUES ('22040', '手工数据', '22000', '40', 'qcManualData', 'qc/qcManualData/index', '', 1, 0, 'C', '0', '0', 'qc:qcManualData:list', 'keyboard', 100, 1, sysdate(), NULL, NULL, '手工数据');
INSERT INTO sys_menu VALUES ('22050', '质量指标', '22000', '50', 'qcQualityIndicator', 'qc/qcQualityIndicator/index', '', 1, 0, 'C', '0', '0', 'qc:qcQualityIndicator:list', 'chart-line', 100, 1, sysdate(), NULL, NULL, '质量指标');
INSERT INTO sys_menu VALUES ('22060', '评分结果', '22000', '60', 'qcScoringResult', 'qc/qcScoringResult/index', '', 1, 0, 'C', '0', '0', 'qc:qcScoringResult:list', 'star', 100, 1, sysdate(), NULL, NULL, '评分结果');
INSERT INTO sys_menu VALUES ('22070', '评分规则', '22000', '70', 'qcScoringRule', 'qc/qcScoringRule/index', '', 1, 0, 'C', '0', '0', 'qc:qcScoringRule:list', 'gavel', 100, 1, sysdate(), NULL, NULL, '评分规则');
INSERT INTO sys_menu VALUES ('22080', '专科类别', '22000', '80', 'qcSpecialtyCategory', 'qc/qcSpecialtyCategory/index', '', 1, 0, 'C', '0', '0', 'qc:qcSpecialtyCategory:list', 'sitemap', 100, 1, sysdate(), NULL, NULL, '专科类别');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 质量数据采集按钮
INSERT INTO sys_menu VALUES ('22011', '质量数据采集查询', '22010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22012', '质量数据采集新增', '22010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22013', '质量数据采集修改', '22010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22014', '质量数据采集删除', '22010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22015', '质量数据采集导入', '22010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22016', '质量数据采集导出', '22010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcDataCollection:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 指标采集配置按钮
INSERT INTO sys_menu VALUES ('22021', '指标采集配置查询', '22020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorCollectionConfig:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22022', '指标采集配置新增', '22020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorCollectionConfig:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22023', '指标采集配置修改', '22020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorCollectionConfig:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22024', '指标采集配置删除', '22020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorCollectionConfig:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22025', '指标采集配置导入', '22020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorCollectionConfig:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22026', '指标采集配置导出', '22020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorCollectionConfig:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 指标要素按钮
INSERT INTO sys_menu VALUES ('22031', '指标要素查询', '22030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorFactor:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22032', '指标要素新增', '22030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorFactor:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22033', '指标要素修改', '22030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorFactor:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22034', '指标要素删除', '22030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorFactor:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22035', '指标要素导入', '22030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorFactor:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22036', '指标要素导出', '22030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcIndicatorFactor:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 手工数据按钮
INSERT INTO sys_menu VALUES ('22041', '手工数据查询', '22040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcManualData:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22042', '手工数据新增', '22040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcManualData:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22043', '手工数据修改', '22040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcManualData:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22044', '手工数据删除', '22040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcManualData:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22045', '手工数据导入', '22040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcManualData:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22046', '手工数据导出', '22040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcManualData:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 质量指标按钮
INSERT INTO sys_menu VALUES ('22051', '质量指标查询', '22050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcQualityIndicator:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22052', '质量指标新增', '22050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcQualityIndicator:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22053', '质量指标修改', '22050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcQualityIndicator:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22054', '质量指标删除', '22050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcQualityIndicator:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22055', '质量指标导入', '22050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcQualityIndicator:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22056', '质量指标导出', '22050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcQualityIndicator:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 评分结果按钮
INSERT INTO sys_menu VALUES ('22061', '评分结果查询', '22060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringResult:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22062', '评分结果新增', '22060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringResult:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22063', '评分结果修改', '22060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringResult:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22064', '评分结果删除', '22060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringResult:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22065', '评分结果导入', '22060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringResult:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22066', '评分结果导出', '22060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringResult:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 评分规则按钮
INSERT INTO sys_menu VALUES ('22071', '评分规则查询', '22070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringRule:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22072', '评分规则新增', '22070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringRule:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22073', '评分规则修改', '22070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringRule:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22074', '评分规则删除', '22070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringRule:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22075', '评分规则导入', '22070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringRule:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22076', '评分规则导出', '22070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcScoringRule:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 专科类别按钮
INSERT INTO sys_menu VALUES ('22081', '专科类别查询', '22080', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcSpecialtyCategory:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22082', '专科类别新增', '22080', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcSpecialtyCategory:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22083', '专科类别修改', '22080', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcSpecialtyCategory:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22084', '专科类别删除', '22080', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcSpecialtyCategory:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22085', '专科类别导入', '22080', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcSpecialtyCategory:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22086', '专科类别导出', '22080', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qc:qcSpecialtyCategory:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 22000 AND menu_id < 22500;

COMMIT;