-- ----------------------------
-- 资格管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建资格管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('22500', '资格管理', '0', '100', 'qualification', NULL, '', 1, 0, 'M', '0', '0', '', 'certificate', 100, 1, sysdate(), NULL, NULL, '资格管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('22510', '资格目录', '22500', '10', 'qualificationCatalog', 'qualification/qualificationCatalog/index', '', 1, 0, 'C', '0', '0', 'qualification:qualificationCatalog:list', 'book', 100, 1, sysdate(), NULL, NULL, '资格目录');
INSERT INTO sys_menu VALUES ('22520', '资格证书', '22500', '20', 'qualificationCertificate', 'qualification/qualificationCertificate/index', '', 1, 0, 'C', '0', '0', 'qualification:qualificationCertificate:list', 'certificate', 100, 1, sysdate(), NULL, NULL, '资格证书');
INSERT INTO sys_menu VALUES ('22530', '资格考试', '22500', '30', 'qualificationExam', 'qualification/qualificationExam/index', '', 1, 0, 'C', '0', '0', 'qualification:qualificationExam:list', 'graduation-cap', 100, 1, sysdate(), NULL, NULL, '资格考试');
INSERT INTO sys_menu VALUES ('22540', '资格考试记录', '22500', '40', 'qualificationExamRecord', 'qualification/qualificationExamRecord/index', '', 1, 0, 'C', '0', '0', 'qualification:qualificationExamRecord:list', 'file-signature', 100, 1, sysdate(), NULL, NULL, '资格考试记录');
INSERT INTO sys_menu VALUES ('22550', '资格计划', '22500', '50', 'qualificationPlan', 'qualification/qualificationPlan/index', '', 1, 0, 'C', '0', '0', 'qualification:qualificationPlan:list', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '资格计划');
INSERT INTO sys_menu VALUES ('22560', '资格培训', '22500', '60', 'qualificationTraining', 'qualification/qualificationTraining/index', '', 1, 0, 'C', '0', '0', 'qualification:qualificationTraining:list', 'chalkboard-teacher', 100, 1, sysdate(), NULL, NULL, '资格培训');
INSERT INTO sys_menu VALUES ('22570', '资格培训记录', '22500', '70', 'qualificationTrainingRecord', 'qualification/qualificationTrainingRecord/index', '', 1, 0, 'C', '0', '0', 'qualification:qualificationTrainingRecord:list', 'history', 100, 1, sysdate(), NULL, NULL, '资格培训记录');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 资格目录按钮
INSERT INTO sys_menu VALUES ('22511', '资格目录查询', '22510', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCatalog:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22512', '资格目录新增', '22510', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCatalog:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22513', '资格目录修改', '22510', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCatalog:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22514', '资格目录删除', '22510', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCatalog:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22515', '资格目录导入', '22510', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCatalog:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22516', '资格目录导出', '22510', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCatalog:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 资格证书按钮
INSERT INTO sys_menu VALUES ('22521', '资格证书查询', '22520', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCertificate:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22522', '资格证书新增', '22520', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCertificate:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22523', '资格证书修改', '22520', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCertificate:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22524', '资格证书删除', '22520', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCertificate:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22525', '资格证书导入', '22520', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCertificate:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22526', '资格证书导出', '22520', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationCertificate:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 资格考试按钮
INSERT INTO sys_menu VALUES ('22531', '资格考试查询', '22530', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExam:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22532', '资格考试新增', '22530', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExam:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22533', '资格考试修改', '22530', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExam:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22534', '资格考试删除', '22530', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExam:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22535', '资格考试导入', '22530', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExam:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22536', '资格考试导出', '22530', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExam:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 资格考试记录按钮
INSERT INTO sys_menu VALUES ('22541', '资格考试记录查询', '22540', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExamRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22542', '资格考试记录新增', '22540', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExamRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22543', '资格考试记录修改', '22540', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExamRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22544', '资格考试记录删除', '22540', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExamRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22545', '资格考试记录导入', '22540', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExamRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22546', '资格考试记录导出', '22540', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationExamRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 资格计划按钮
INSERT INTO sys_menu VALUES ('22551', '资格计划查询', '22550', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22552', '资格计划新增', '22550', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22553', '资格计划修改', '22550', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22554', '资格计划删除', '22550', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22555', '资格计划导入', '22550', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22556', '资格计划导出', '22550', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 资格培训按钮
INSERT INTO sys_menu VALUES ('22561', '资格培训查询', '22560', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTraining:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22562', '资格培训新增', '22560', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTraining:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22563', '资格培训修改', '22560', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTraining:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22564', '资格培训删除', '22560', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTraining:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22565', '资格培训导入', '22560', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTraining:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22566', '资格培训导出', '22560', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTraining:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 资格培训记录按钮
INSERT INTO sys_menu VALUES ('22571', '资格培训记录查询', '22570', '1', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTrainingRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22572', '资格培训记录新增', '22570', '2', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTrainingRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22573', '资格培训记录修改', '22570', '3', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTrainingRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22574', '资格培训记录删除', '22570', '4', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTrainingRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22575', '资格培训记录导入', '22570', '5', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTrainingRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('22576', '资格培训记录导出', '22570', '6', '#', '', '', 1, 0, 'F', '0', '0', 'qualification:qualificationTrainingRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------
-- 为护士角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('5', '22500');

INSERT INTO sys_role_menu VALUES ('5', '22510');
INSERT INTO sys_role_menu VALUES ('5', '22511');
INSERT INTO sys_role_menu VALUES ('5', '22512');
INSERT INTO sys_role_menu VALUES ('5', '22513');
INSERT INTO sys_role_menu VALUES ('5', '22514');
INSERT INTO sys_role_menu VALUES ('5', '22515');
INSERT INTO sys_role_menu VALUES ('5', '22516');

INSERT INTO sys_role_menu VALUES ('5', '22520');
INSERT INTO sys_role_menu VALUES ('5', '22521');
INSERT INTO sys_role_menu VALUES ('5', '22522');
INSERT INTO sys_role_menu VALUES ('5', '22523');
INSERT INTO sys_role_menu VALUES ('5', '22524');
INSERT INTO sys_role_menu VALUES ('5', '22525');
INSERT INTO sys_role_menu VALUES ('5', '22526');

INSERT INTO sys_role_menu VALUES ('5', '22530');
INSERT INTO sys_role_menu VALUES ('5', '22531');
INSERT INTO sys_role_menu VALUES ('5', '22532');
INSERT INTO sys_role_menu VALUES ('5', '22533');
INSERT INTO sys_role_menu VALUES ('5', '22534');
INSERT INTO sys_role_menu VALUES ('5', '22535');
INSERT INTO sys_role_menu VALUES ('5', '22536');

INSERT INTO sys_role_menu VALUES ('5', '22540');
INSERT INTO sys_role_menu VALUES ('5', '22541');
INSERT INTO sys_role_menu VALUES ('5', '22542');
INSERT INTO sys_role_menu VALUES ('5', '22543');
INSERT INTO sys_role_menu VALUES ('5', '22544');
INSERT INTO sys_role_menu VALUES ('5', '22545');
INSERT INTO sys_role_menu VALUES ('5', '22546');

INSERT INTO sys_role_menu VALUES ('5', '22550');
INSERT INTO sys_role_menu VALUES ('5', '22551');
INSERT INTO sys_role_menu VALUES ('5', '22552');
INSERT INTO sys_role_menu VALUES ('5', '22553');
INSERT INTO sys_role_menu VALUES ('5', '22554');
INSERT INTO sys_role_menu VALUES ('5', '22555');
INSERT INTO sys_role_menu VALUES ('5', '22556');

INSERT INTO sys_role_menu VALUES ('5', '22560');
INSERT INTO sys_role_menu VALUES ('5', '22561');
INSERT INTO sys_role_menu VALUES ('5', '22562');
INSERT INTO sys_role_menu VALUES ('5', '22563');
INSERT INTO sys_role_menu VALUES ('5', '22564');
INSERT INTO sys_role_menu VALUES ('5', '22565');
INSERT INTO sys_role_menu VALUES ('5', '22566');

INSERT INTO sys_role_menu VALUES ('5', '22570');
INSERT INTO sys_role_menu VALUES ('5', '22571');
INSERT INTO sys_role_menu VALUES ('5', '22572');
INSERT INTO sys_role_menu VALUES ('5', '22573');
INSERT INTO sys_role_menu VALUES ('5', '22574');
INSERT INTO sys_role_menu VALUES ('5', '22575');
INSERT INTO sys_role_menu VALUES ('5', '22576');

-- 为医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '22500');

INSERT INTO sys_role_menu VALUES ('6', '22510');
INSERT INTO sys_role_menu VALUES ('6', '22511');
INSERT INTO sys_role_menu VALUES ('6', '22512');
INSERT INTO sys_role_menu VALUES ('6', '22513');
INSERT INTO sys_role_menu VALUES ('6', '22514');
INSERT INTO sys_role_menu VALUES ('6', '22515');
INSERT INTO sys_role_menu VALUES ('6', '22516');

INSERT INTO sys_role_menu VALUES ('6', '22520');
INSERT INTO sys_role_menu VALUES ('6', '22521');
INSERT INTO sys_role_menu VALUES ('6', '22522');
INSERT INTO sys_role_menu VALUES ('6', '22523');
INSERT INTO sys_role_menu VALUES ('6', '22524');
INSERT INTO sys_role_menu VALUES ('6', '22525');
INSERT INTO sys_role_menu VALUES ('6', '22526');

INSERT INTO sys_role_menu VALUES ('6', '22530');
INSERT INTO sys_role_menu VALUES ('6', '22531');
INSERT INTO sys_role_menu VALUES ('6', '22532');
INSERT INTO sys_role_menu VALUES ('6', '22533');
INSERT INTO sys_role_menu VALUES ('6', '22534');
INSERT INTO sys_role_menu VALUES ('6', '22535');
INSERT INTO sys_role_menu VALUES ('6', '22536');

INSERT INTO sys_role_menu VALUES ('6', '22540');
INSERT INTO sys_role_menu VALUES ('6', '22541');
INSERT INTO sys_role_menu VALUES ('6', '22542');
INSERT INTO sys_role_menu VALUES ('6', '22543');
INSERT INTO sys_role_menu VALUES ('6', '22544');
INSERT INTO sys_role_menu VALUES ('6', '22545');
INSERT INTO sys_role_menu VALUES ('6', '22546');

INSERT INTO sys_role_menu VALUES ('6', '22550');
INSERT INTO sys_role_menu VALUES ('6', '22551');
INSERT INTO sys_role_menu VALUES ('6', '22552');
INSERT INTO sys_role_menu VALUES ('6', '22553');
INSERT INTO sys_role_menu VALUES ('6', '22554');
INSERT INTO sys_role_menu VALUES ('6', '22555');
INSERT INTO sys_role_menu VALUES ('6', '22556');

INSERT INTO sys_role_menu VALUES ('6', '22560');
INSERT INTO sys_role_menu VALUES ('6', '22561');
INSERT INTO sys_role_menu VALUES ('6', '22562');
INSERT INTO sys_role_menu VALUES ('6', '22563');
INSERT INTO sys_role_menu VALUES ('6', '22564');
INSERT INTO sys_role_menu VALUES ('6', '22565');
INSERT INTO sys_role_menu VALUES ('6', '22566');

INSERT INTO sys_role_menu VALUES ('6', '22570');
INSERT INTO sys_role_menu VALUES ('6', '22571');
INSERT INTO sys_role_menu VALUES ('6', '22572');
INSERT INTO sys_role_menu VALUES ('6', '22573');
INSERT INTO sys_role_menu VALUES ('6', '22574');
INSERT INTO sys_role_menu VALUES ('6', '22575');
INSERT INTO sys_role_menu VALUES ('6', '22576');

-- 为科室主任分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('7', '22500');

INSERT INTO sys_role_menu VALUES ('7', '22510');
INSERT INTO sys_role_menu VALUES ('7', '22511');
INSERT INTO sys_role_menu VALUES ('7', '22512');
INSERT INTO sys_role_menu VALUES ('7', '22513');
INSERT INTO sys_role_menu VALUES ('7', '22514');
INSERT INTO sys_role_menu VALUES ('7', '22515');
INSERT INTO sys_role_menu VALUES ('7', '22516');

INSERT INTO sys_role_menu VALUES ('7', '22520');
INSERT INTO sys_role_menu VALUES ('7', '22521');
INSERT INTO sys_role_menu VALUES ('7', '22522');
INSERT INTO sys_role_menu VALUES ('7', '22523');
INSERT INTO sys_role_menu VALUES ('7', '22524');
INSERT INTO sys_role_menu VALUES ('7', '22525');
INSERT INTO sys_role_menu VALUES ('7', '22526');

INSERT INTO sys_role_menu VALUES ('7', '22530');
INSERT INTO sys_role_menu VALUES ('7', '22531');
INSERT INTO sys_role_menu VALUES ('7', '22532');
INSERT INTO sys_role_menu VALUES ('7', '22533');
INSERT INTO sys_role_menu VALUES ('7', '22534');
INSERT INTO sys_role_menu VALUES ('7', '22535');
INSERT INTO sys_role_menu VALUES ('7', '22536');

INSERT INTO sys_role_menu VALUES ('7', '22540');
INSERT INTO sys_role_menu VALUES ('7', '22541');
INSERT INTO sys_role_menu VALUES ('7', '22542');
INSERT INTO sys_role_menu VALUES ('7', '22543');
INSERT INTO sys_role_menu VALUES ('7', '22544');
INSERT INTO sys_role_menu VALUES ('7', '22545');
INSERT INTO sys_role_menu VALUES ('7', '22546');

INSERT INTO sys_role_menu VALUES ('7', '22550');
INSERT INTO sys_role_menu VALUES ('7', '22551');
INSERT INTO sys_role_menu VALUES ('7', '22552');
INSERT INTO sys_role_menu VALUES ('7', '22553');
INSERT INTO sys_role_menu VALUES ('7', '22554');
INSERT INTO sys_role_menu VALUES ('7', '22555');
INSERT INTO sys_role_menu VALUES ('7', '22556');

INSERT INTO sys_role_menu VALUES ('7', '22560');
INSERT INTO sys_role_menu VALUES ('7', '22561');
INSERT INTO sys_role_menu VALUES ('7', '22562');
INSERT INTO sys_role_menu VALUES ('7', '22563');
INSERT INTO sys_role_menu VALUES ('7', '22564');
INSERT INTO sys_role_menu VALUES ('7', '22565');
INSERT INTO sys_role_menu VALUES ('7', '22566');

INSERT INTO sys_role_menu VALUES ('7', '22570');
INSERT INTO sys_role_menu VALUES ('7', '22571');
INSERT INTO sys_role_menu VALUES ('7', '22572');
INSERT INTO sys_role_menu VALUES ('7', '22573');
INSERT INTO sys_role_menu VALUES ('7', '22574');
INSERT INTO sys_role_menu VALUES ('7', '22575');
INSERT INTO sys_role_menu VALUES ('7', '22576');

-- 为质控员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('8', '22500');

INSERT INTO sys_role_menu VALUES ('8', '22510');
INSERT INTO sys_role_menu VALUES ('8', '22511');
INSERT INTO sys_role_menu VALUES ('8', '22512');
INSERT INTO sys_role_menu VALUES ('8', '22513');
INSERT INTO sys_role_menu VALUES ('8', '22514');
INSERT INTO sys_role_menu VALUES ('8', '22515');
INSERT INTO sys_role_menu VALUES ('8', '22516');

INSERT INTO sys_role_menu VALUES ('8', '22520');
INSERT INTO sys_role_menu VALUES ('8', '22521');
INSERT INTO sys_role_menu VALUES ('8', '22522');
INSERT INTO sys_role_menu VALUES ('8', '22523');
INSERT INTO sys_role_menu VALUES ('8', '22524');
INSERT INTO sys_role_menu VALUES ('8', '22525');
INSERT INTO sys_role_menu VALUES ('8', '22526');

INSERT INTO sys_role_menu VALUES ('8', '22530');
INSERT INTO sys_role_menu VALUES ('8', '22531');
INSERT INTO sys_role_menu VALUES ('8', '22532');
INSERT INTO sys_role_menu VALUES ('8', '22533');
INSERT INTO sys_role_menu VALUES ('8', '22534');
INSERT INTO sys_role_menu VALUES ('8', '22535');
INSERT INTO sys_role_menu VALUES ('8', '22536');

INSERT INTO sys_role_menu VALUES ('8', '22540');
INSERT INTO sys_role_menu VALUES ('8', '22541');
INSERT INTO sys_role_menu VALUES ('8', '22542');
INSERT INTO sys_role_menu VALUES ('8', '22543');
INSERT INTO sys_role_menu VALUES ('8', '22544');
INSERT INTO sys_role_menu VALUES ('8', '22545');
INSERT INTO sys_role_menu VALUES ('8', '22546');

INSERT INTO sys_role_menu VALUES ('8', '22550');
INSERT INTO sys_role_menu VALUES ('8', '22551');
INSERT INTO sys_role_menu VALUES ('8', '22552');
INSERT INTO sys_role_menu VALUES ('8', '22553');
INSERT INTO sys_role_menu VALUES ('8', '22554');
INSERT INTO sys_role_menu VALUES ('8', '22555');
INSERT INTO sys_role_menu VALUES ('8', '22556');

INSERT INTO sys_role_menu VALUES ('8', '22560');
INSERT INTO sys_role_menu VALUES ('8', '22561');
INSERT INTO sys_role_menu VALUES ('8', '22562');
INSERT INTO sys_role_menu VALUES ('8', '22563');
INSERT INTO sys_role_menu VALUES ('8', '22564');
INSERT INTO sys_role_menu VALUES ('8', '22565');
INSERT INTO sys_role_menu VALUES ('8', '22566');

INSERT INTO sys_role_menu VALUES ('8', '22570');
INSERT INTO sys_role_menu VALUES ('8', '22571');
INSERT INTO sys_role_menu VALUES ('8', '22572');
INSERT INTO sys_role_menu VALUES ('8', '22573');
INSERT INTO sys_role_menu VALUES ('8', '22574');
INSERT INTO sys_role_menu VALUES ('8', '22575');
INSERT INTO sys_role_menu VALUES ('8', '22576');

-- 为医务部分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('9', '22500');

INSERT INTO sys_role_menu VALUES ('9', '22510');
INSERT INTO sys_role_menu VALUES ('9', '22511');
INSERT INTO sys_role_menu VALUES ('9', '22512');
INSERT INTO sys_role_menu VALUES ('9', '22513');
INSERT INTO sys_role_menu VALUES ('9', '22514');
INSERT INTO sys_role_menu VALUES ('9', '22515');
INSERT INTO sys_role_menu VALUES ('9', '22516');

INSERT INTO sys_role_menu VALUES ('9', '22520');
INSERT INTO sys_role_menu VALUES ('9', '22521');
INSERT INTO sys_role_menu VALUES ('9', '22522');
INSERT INTO sys_role_menu VALUES ('9', '22523');
INSERT INTO sys_role_menu VALUES ('9', '22524');
INSERT INTO sys_role_menu VALUES ('9', '22525');
INSERT INTO sys_role_menu VALUES ('9', '22526');

INSERT INTO sys_role_menu VALUES ('9', '22530');
INSERT INTO sys_role_menu VALUES ('9', '22531');
INSERT INTO sys_role_menu VALUES ('9', '22532');
INSERT INTO sys_role_menu VALUES ('9', '22533');
INSERT INTO sys_role_menu VALUES ('9', '22534');
INSERT INTO sys_role_menu VALUES ('9', '22535');
INSERT INTO sys_role_menu VALUES ('9', '22536');

INSERT INTO sys_role_menu VALUES ('9', '22540');
INSERT INTO sys_role_menu VALUES ('9', '22541');
INSERT INTO sys_role_menu VALUES ('9', '22542');
INSERT INTO sys_role_menu VALUES ('9', '22543');
INSERT INTO sys_role_menu VALUES ('9', '22544');
INSERT INTO sys_role_menu VALUES ('9', '22545');
INSERT INTO sys_role_menu VALUES ('9', '22546');

INSERT INTO sys_role_menu VALUES ('9', '22550');
INSERT INTO sys_role_menu VALUES ('9', '22551');
INSERT INTO sys_role_menu VALUES ('9', '22552');
INSERT INTO sys_role_menu VALUES ('9', '22553');
INSERT INTO sys_role_menu VALUES ('9', '22554');
INSERT INTO sys_role_menu VALUES ('9', '22555');
INSERT INTO sys_role_menu VALUES ('9', '22556');

INSERT INTO sys_role_menu VALUES ('9', '22560');
INSERT INTO sys_role_menu VALUES ('9', '22561');
INSERT INTO sys_role_menu VALUES ('9', '22562');
INSERT INTO sys_role_menu VALUES ('9', '22563');
INSERT INTO sys_role_menu VALUES ('9', '22564');
INSERT INTO sys_role_menu VALUES ('9', '22565');
INSERT INTO sys_role_menu VALUES ('9', '22566');

INSERT INTO sys_role_menu VALUES ('9', '22570');
INSERT INTO sys_role_menu VALUES ('9', '22571');
INSERT INTO sys_role_menu VALUES ('9', '22572');
INSERT INTO sys_role_menu VALUES ('9', '22573');
INSERT INTO sys_role_menu VALUES ('9', '22574');
INSERT INTO sys_role_menu VALUES ('9', '22575');
INSERT INTO sys_role_menu VALUES ('9', '22576');

-- 为医务部主任角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('10', '22500');

INSERT INTO sys_role_menu VALUES ('10', '22510');
INSERT INTO sys_role_menu VALUES ('10', '22511');
INSERT INTO sys_role_menu VALUES ('10', '22512');
INSERT INTO sys_role_menu VALUES ('10', '22513');
INSERT INTO sys_role_menu VALUES ('10', '22514');
INSERT INTO sys_role_menu VALUES ('10', '22515');
INSERT INTO sys_role_menu VALUES ('10', '22516');

INSERT INTO sys_role_menu VALUES ('10', '22520');
INSERT INTO sys_role_menu VALUES ('10', '22521');
INSERT INTO sys_role_menu VALUES ('10', '22522');
INSERT INTO sys_role_menu VALUES ('10', '22523');
INSERT INTO sys_role_menu VALUES ('10', '22524');
INSERT INTO sys_role_menu VALUES ('10', '22525');
INSERT INTO sys_role_menu VALUES ('10', '22526');

INSERT INTO sys_role_menu VALUES ('10', '22530');
INSERT INTO sys_role_menu VALUES ('10', '22531');
INSERT INTO sys_role_menu VALUES ('10', '22532');
INSERT INTO sys_role_menu VALUES ('10', '22533');
INSERT INTO sys_role_menu VALUES ('10', '22534');
INSERT INTO sys_role_menu VALUES ('10', '22535');
INSERT INTO sys_role_menu VALUES ('10', '22536');

INSERT INTO sys_role_menu VALUES ('10', '22540');
INSERT INTO sys_role_menu VALUES ('10', '22541');
INSERT INTO sys_role_menu VALUES ('10', '22542');
INSERT INTO sys_role_menu VALUES ('10', '22543');
INSERT INTO sys_role_menu VALUES ('10', '22544');
INSERT INTO sys_role_menu VALUES ('10', '22545');
INSERT INTO sys_role_menu VALUES ('10', '22546');

INSERT INTO sys_role_menu VALUES ('10', '22550');
INSERT INTO sys_role_menu VALUES ('10', '22551');
INSERT INTO sys_role_menu VALUES ('10', '22552');
INSERT INTO sys_role_menu VALUES ('10', '22553');
INSERT INTO sys_role_menu VALUES ('10', '22554');
INSERT INTO sys_role_menu VALUES ('10', '22555');
INSERT INTO sys_role_menu VALUES ('10', '22556');

INSERT INTO sys_role_menu VALUES ('10', '22560');
INSERT INTO sys_role_menu VALUES ('10', '22561');
INSERT INTO sys_role_menu VALUES ('10', '22562');
INSERT INTO sys_role_menu VALUES ('10', '22563');
INSERT INTO sys_role_menu VALUES ('10', '22564');
INSERT INTO sys_role_menu VALUES ('10', '22565');
INSERT INTO sys_role_menu VALUES ('10', '22566');

INSERT INTO sys_role_menu VALUES ('10', '22570');
INSERT INTO sys_role_menu VALUES ('10', '22571');
INSERT INTO sys_role_menu VALUES ('10', '22572');
INSERT INTO sys_role_menu VALUES ('10', '22573');
INSERT INTO sys_role_menu VALUES ('10', '22574');
INSERT INTO sys_role_menu VALUES ('10', '22575');
INSERT INTO sys_role_menu VALUES ('10', '22576');

-- 为医院管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('11', '22500');

INSERT INTO sys_role_menu VALUES ('11', '22510');
INSERT INTO sys_role_menu VALUES ('11', '22511');
INSERT INTO sys_role_menu VALUES ('11', '22512');
INSERT INTO sys_role_menu VALUES ('11', '22513');
INSERT INTO sys_role_menu VALUES ('11', '22514');
INSERT INTO sys_role_menu VALUES ('11', '22515');
INSERT INTO sys_role_menu VALUES ('11', '22516');

INSERT INTO sys_role_menu VALUES ('11', '22520');
INSERT INTO sys_role_menu VALUES ('11', '22521');
INSERT INTO sys_role_menu VALUES ('11', '22522');
INSERT INTO sys_role_menu VALUES ('11', '22523');
INSERT INTO sys_role_menu VALUES ('11', '22524');
INSERT INTO sys_role_menu VALUES ('11', '22525');
INSERT INTO sys_role_menu VALUES ('11', '22526');

INSERT INTO sys_role_menu VALUES ('11', '22530');
INSERT INTO sys_role_menu VALUES ('11', '22531');
INSERT INTO sys_role_menu VALUES ('11', '22532');
INSERT INTO sys_role_menu VALUES ('11', '22533');
INSERT INTO sys_role_menu VALUES ('11', '22534');
INSERT INTO sys_role_menu VALUES ('11', '22535');
INSERT INTO sys_role_menu VALUES ('11', '22536');

INSERT INTO sys_role_menu VALUES ('11', '22540');
INSERT INTO sys_role_menu VALUES ('11', '22541');
INSERT INTO sys_role_menu VALUES ('11', '22542');
INSERT INTO sys_role_menu VALUES ('11', '22543');
INSERT INTO sys_role_menu VALUES ('11', '22544');
INSERT INTO sys_role_menu VALUES ('11', '22545');
INSERT INTO sys_role_menu VALUES ('11', '22546');

INSERT INTO sys_role_menu VALUES ('11', '22550');
INSERT INTO sys_role_menu VALUES ('11', '22551');
INSERT INTO sys_role_menu VALUES ('11', '22552');
INSERT INTO sys_role_menu VALUES ('11', '22553');
INSERT INTO sys_role_menu VALUES ('11', '22554');
INSERT INTO sys_role_menu VALUES ('11', '22555');
INSERT INTO sys_role_menu VALUES ('11', '22556');

INSERT INTO sys_role_menu VALUES ('11', '22560');
INSERT INTO sys_role_menu VALUES ('11', '22561');
INSERT INTO sys_role_menu VALUES ('11', '22562');
INSERT INTO sys_role_menu VALUES ('11', '22563');
INSERT INTO sys_role_menu VALUES ('11', '22564');
INSERT INTO sys_role_menu VALUES ('11', '22565');
INSERT INTO sys_role_menu VALUES ('11', '22566');

INSERT INTO sys_role_menu VALUES ('11', '22570');
INSERT INTO sys_role_menu VALUES ('11', '22571');
INSERT INTO sys_role_menu VALUES ('11', '22572');
INSERT INTO sys_role_menu VALUES ('11', '22573');
INSERT INTO sys_role_menu VALUES ('11', '22574');
INSERT INTO sys_role_menu VALUES ('11', '22575');
INSERT INTO sys_role_menu VALUES ('11', '22576');

-- 为超级管理员角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('1', '22500');

INSERT INTO sys_role_menu VALUES ('1', '22510');
INSERT INTO sys_role_menu VALUES ('1', '22511');
INSERT INTO sys_role_menu VALUES ('1', '22512');
INSERT INTO sys_role_menu VALUES ('1', '22513');
INSERT INTO sys_role_menu VALUES ('1', '22514');
INSERT INTO sys_role_menu VALUES ('1', '22515');
INSERT INTO sys_role_menu VALUES ('1', '22516');

INSERT INTO sys_role_menu VALUES ('1', '22520');
INSERT INTO sys_role_menu VALUES ('1', '22521');
INSERT INTO sys_role_menu VALUES ('1', '22522');
INSERT INTO sys_role_menu VALUES ('1', '22523');
INSERT INTO sys_role_menu VALUES ('1', '22524');
INSERT INTO sys_role_menu VALUES ('1', '22525');
INSERT INTO sys_role_menu VALUES ('1', '22526');

INSERT INTO sys_role_menu VALUES ('1', '22530');
INSERT INTO sys_role_menu VALUES ('1', '22531');
INSERT INTO sys_role_menu VALUES ('1', '22532');
INSERT INTO sys_role_menu VALUES ('1', '22533');
INSERT INTO sys_role_menu VALUES ('1', '22534');
INSERT INTO sys_role_menu VALUES ('1', '22535');
INSERT INTO sys_role_menu VALUES ('1', '22536');

INSERT INTO sys_role_menu VALUES ('1', '22540');
INSERT INTO sys_role_menu VALUES ('1', '22541');
INSERT INTO sys_role_menu VALUES ('1', '22542');
INSERT INTO sys_role_menu VALUES ('1', '22543');
INSERT INTO sys_role_menu VALUES ('1', '22544');
INSERT INTO sys_role_menu VALUES ('1', '22545');
INSERT INTO sys_role_menu VALUES ('1', '22546');

INSERT INTO sys_role_menu VALUES ('1', '22550');
INSERT INTO sys_role_menu VALUES ('1', '22551');
INSERT INTO sys_role_menu VALUES ('1', '22552');
INSERT INTO sys_role_menu VALUES ('1', '22553');
INSERT INTO sys_role_menu VALUES ('1', '22554');
INSERT INTO sys_role_menu VALUES ('1', '22555');
INSERT INTO sys_role_menu VALUES ('1', '22556');

INSERT INTO sys_role_menu VALUES ('1', '22560');
INSERT INTO sys_role_menu VALUES ('1', '22561');
INSERT INTO sys_role_menu VALUES ('1', '22562');
INSERT INTO sys_role_menu VALUES ('1', '22563');
INSERT INTO sys_role_menu VALUES ('1', '22564');
INSERT INTO sys_role_menu VALUES ('1', '22565');
INSERT INTO sys_role_menu VALUES ('1', '22566');

INSERT INTO sys_role_menu VALUES ('1', '22570');
INSERT INTO sys_role_menu VALUES ('1', '22571');
INSERT INTO sys_role_menu VALUES ('1', '22572');
INSERT INTO sys_role_menu VALUES ('1', '22573');
INSERT INTO sys_role_menu VALUES ('1', '22574');
INSERT INTO sys_role_menu VALUES ('1', '22575');
INSERT INTO sys_role_menu VALUES ('1', '22576');