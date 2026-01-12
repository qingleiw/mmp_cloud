-- ----------------------------
--  资格管理菜单SQL脚本（修正版）
-- 生成时间：2026-01-12
-- 修正说明：
--   1. 修复菜单22550的重复路由问题 - 改为qualificationExamArrangement
--   2. 修复按钮22556的父级ID错误 - 从22540改为22550
--   3. 移除角色菜单分配中的重复记录
--   4. 补充遗漏的菜单项22510
--   5. 统一日期格式
-- ----------------------------

DELETE FROM sys_role_menu WHERE menu_id>=22500 AND menu_id<23000;
DELETE FROM sys_menu WHERE menu_id>=22500 AND menu_id<23000;

-- ----------------------------
-- 1.创建资格管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES('22500','资格管理','0','100','qualification',NULL,'',1,0,'M','0','0','','certificate',100,1,sysdate(),NULL,NULL,'资格管理目录');


-- ----------------------------
-- 2.创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES(22510,'资格目录',22500,10,'qualificationCatalog','qualification/qualificationCatalog/index','',1,0,'C','0','0','qualification:qualificationCatalog:list','book',100,1,sysdate(),NULL,NULL,'资格目录');
INSERT INTO sys_menu VALUES(22520,'资质准入条件',22500,20,'qualificationAdmissionCondition','qualification/qualificationAdmissionCondition/index','',1,0,'C','0','0','qualification:qualificationAdmissionCondition:list','certificate',100,1,sysdate(),1,'2026-01-12 21:23:15','资质准入条件');
INSERT INTO sys_menu VALUES(22530,'资质授权申请',22500,30,'qualificationAuthorizationApply','qualification/qualificationAuthorizationApply/index','',1,0,'C','0','0','qualification:qualificationAuthorizationApply:list','chalkboard-teacher',100,1,sysdate(),1,'2026-01-12 21:27:59','资质授权申请');
INSERT INTO sys_menu VALUES(22540,'资质授权记录',22500,40,'qualificationAuthorizationRecord','qualification/qualificationAuthorizationRecord/index','',1,0,'C','0','0','qualification:qualificationAuthorizationRecord:list','history',100,1,sysdate(),1,'2026-01-12 21:28:51','资质授权记录');
INSERT INTO sys_menu VALUES(22550,'资质考试安排记录',22500,50,'qualificationExamArrangement','qualification/qualificationExamArrangement/index','',1,0,'C','0','0','qualification:qualificationExamArrangement:list','calendar-alt',100,1,sysdate(),1,'2026-01-12 21:29:00','资质考试安排记录');
INSERT INTO sys_menu VALUES(22560,'资质考核试卷',22500,60,'qualificationExamPaper','qualification/qualificationExamPaper/index','',1,0,'C','0','0','qualification:qualificationExamPaper:list','graduation-cap',100,1,sysdate(),1,'2026-01-12 21:35:55','资质考核试卷');
INSERT INTO sys_menu VALUES(22570,'资质考核题库',22500,70,'qualificationExamQuestion','qualification/qualificationExamQuestion/index','',1,0,'C','0','0','qualification:qualificationExamQuestion:list','clipboard-list',100,1,sysdate(),1,'2026-01-12 21:31:28','资质考核题库');
INSERT INTO sys_menu VALUES(22580,'资格考试记录',22500,80,'qualificationExamRecord','qualification/qualificationExamRecord/index','',1,0,'C','0','0','qualification:qualificationExamRecord:list','file-signature',100,1,sysdate(),1,'2026-01-12 21:36:32','资格考试记录');
INSERT INTO sys_menu VALUES(22590,'资质权限调整历史',22500,90,'qualificationPermissionAdjustment','qualification/qualificationPermissionAdjustment/index','',1,0,'C','0','0','qualification:qualificationPermissionAdjustment:list','exchange-alt',100,1,sysdate(),1,'2026-01-12 21:37:00','资质权限调整历史');
INSERT INTO sys_menu VALUES(22600,'资质风险监测',22500,100,'qualificationRiskMonitor','qualification/qualificationRiskMonitor/index','',1,0,'C','0','0','qualification:qualificationRiskMonitor:list','exclamation-triangle',100,1,sysdate(),1,'2026-01-12 21:37:30','资质风险监测');
INSERT INTO sys_menu VALUES(22610,'资质使用记录',22500,110,'qualificationUsageRecord','qualification/qualificationUsageRecord/index','',1,0,'C','0','0','qualification:qualificationUsageRecord:list','list-alt',100,1,sysdate(),1,'2026-01-12 21:38:00','资质使用记录');
INSERT INTO sys_menu VALUES(22620,'医技资质目录',22500,120,'technicianQualificationCatalog','qualification/technicianQualificationCatalog/index','',1,0,'C','0','0','qualification:technicianQualificationCatalog:list','user-md',100,1,sysdate(),1,'2026-01-12 21:38:30','医技资质目录');

-- ----------------------------
-- 3.定义按钮权限
-- ----------------------------

-- 资格目录按钮权限
INSERT INTO sys_menu VALUES(22511,'资格目录查询',22510,1,'#','','',1,0,'F','0','0','qualification:qualificationCatalog:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22512,'资格目录新增',22510,2,'#','','',1,0,'F','0','0','qualification:qualificationCatalog:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22513,'资格目录修改',22510,3,'#','','',1,0,'F','0','0','qualification:qualificationCatalog:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22514,'资格目录删除',22510,4,'#','','',1,0,'F','0','0','qualification:qualificationCatalog:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22515,'资格目录导入',22510,5,'#','','',1,0,'F','0','0','qualification:qualificationCatalog:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22516,'资格目录导出',22510,6,'#','','',1,0,'F','0','0','qualification:qualificationCatalog:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质准入条件按钮权限
INSERT INTO sys_menu VALUES(22521,'资质准入条件查询',22520,1,'#','','',1,0,'F','0','0','qualification:qualificationAdmissionCondition:query','#',100,1,sysdate(),1,'2026-01-12 21:18:27','');
INSERT INTO sys_menu VALUES(22522,'资质准入条件新增',22520,2,'#','','',1,0,'F','0','0','qualification:qualificationAdmissionCondition:add','#',100,1,sysdate(),1,'2026-01-12 21:18:46','');
INSERT INTO sys_menu VALUES(22523,'资质准入条件修改',22520,3,'#','','',1,0,'F','0','0','qualification:qualificationAdmissionCondition:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22524,'资质准入条件删除',22520,4,'#','','',1,0,'F','0','0','qualification:qualificationAdmissionCondition:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22525,'资质准入条件导入',22520,5,'#','','',1,0,'F','0','0','qualification:qualificationAdmissionCondition:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22526,'资质准入条件导出',22520,6,'#','','',1,0,'F','0','0','qualification:qualificationAdmissionCondition:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质授权申请按钮权限
INSERT INTO sys_menu VALUES(22531,'资质授权申请查询',22530,1,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationApply:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22532,'资质授权申请新增',22530,2,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationApply:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22533,'资质授权申请修改',22530,3,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationApply:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22534,'资质授权申请删除',22530,4,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationApply:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22535,'资质授权申请导入',22530,5,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationApply:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22536,'资质授权申请导出',22530,6,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationApply:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质授权记录按钮权限
INSERT INTO sys_menu VALUES(22541,'资质授权记录查询',22540,1,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationRecord:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22542,'资质授权记录新增',22540,2,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationRecord:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22543,'资质授权记录修改',22540,3,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationRecord:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22544,'资质授权记录删除',22540,4,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationRecord:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22545,'资质授权记录导入',22540,5,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationRecord:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22546,'资质授权记录导出',22540,6,'#','','',1,0,'F','0','0','qualification:qualificationAuthorizationRecord:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质考试安排按钮权限
INSERT INTO sys_menu VALUES(22551,'资质考试安排查询',22550,1,'#','','',1,0,'F','0','0','qualification:qualificationExamArrangement:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22552,'资质考试安排新增',22550,2,'#','','',1,0,'F','0','0','qualification:qualificationExamArrangement:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22553,'资质考试安排修改',22550,3,'#','','',1,0,'F','0','0','qualification:qualificationExamArrangement:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22554,'资质考试安排删除',22550,4,'#','','',1,0,'F','0','0','qualification:qualificationExamArrangement:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22555,'资质考试安排导入',22550,5,'#','','',1,0,'F','0','0','qualification:qualificationExamArrangement:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22556,'资质考试安排导出',22550,6,'#','','',1,0,'F','0','0','qualification:qualificationExamArrangement:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质考核试卷按钮权限
INSERT INTO sys_menu VALUES(22561,'资质考核试卷查询',22560,1,'#','','',1,0,'F','0','0','qualification:qualificationExamPaper:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22562,'资质考核试卷新增',22560,2,'#','','',1,0,'F','0','0','qualification:qualificationExamPaper:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22563,'资质考核试卷修改',22560,3,'#','','',1,0,'F','0','0','qualification:qualificationExamPaper:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22564,'资质考核试卷删除',22560,4,'#','','',1,0,'F','0','0','qualification:qualificationExamPaper:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22565,'资质考核试卷导入',22560,5,'#','','',1,0,'F','0','0','qualification:qualificationExamPaper:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22566,'资质考核试卷导出',22560,6,'#','','',1,0,'F','0','0','qualification:qualificationExamPaper:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质考核题库按钮权限
INSERT INTO sys_menu VALUES(22571,'资质考核题库查询',22570,1,'#','','',1,0,'F','0','0','qualification:qualificationExamQuestion:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22572,'资质考核题库新增',22570,2,'#','','',1,0,'F','0','0','qualification:qualificationExamQuestion:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22573,'资质考核题库修改',22570,3,'#','','',1,0,'F','0','0','qualification:qualificationExamQuestion:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22574,'资质考核题库删除',22570,4,'#','','',1,0,'F','0','0','qualification:qualificationExamQuestion:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22575,'资质考核题库导入',22570,5,'#','','',1,0,'F','0','0','qualification:qualificationExamQuestion:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22576,'资质考核题库导出',22570,6,'#','','',1,0,'F','0','0','qualification:qualificationExamQuestion:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资格考试记录按钮权限
INSERT INTO sys_menu VALUES(22581,'资格考试记录查询',22580,1,'#','','',1,0,'F','0','0','qualification:qualificationExamRecord:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22582,'资格考试记录新增',22580,2,'#','','',1,0,'F','0','0','qualification:qualificationExamRecord:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22583,'资格考试记录修改',22580,3,'#','','',1,0,'F','0','0','qualification:qualificationExamRecord:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22584,'资格考试记录删除',22580,4,'#','','',1,0,'F','0','0','qualification:qualificationExamRecord:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22585,'资格考试记录导入',22580,5,'#','','',1,0,'F','0','0','qualification:qualificationExamRecord:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22586,'资格考试记录导出',22580,6,'#','','',1,0,'F','0','0','qualification:qualificationExamRecord:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质权限调整历史按钮权限
INSERT INTO sys_menu VALUES(22591,'资质权限调整历史查询',22590,1,'#','','',1,0,'F','0','0','qualification:qualificationPermissionAdjustment:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22592,'资质权限调整历史新增',22590,2,'#','','',1,0,'F','0','0','qualification:qualificationPermissionAdjustment:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22593,'资质权限调整历史修改',22590,3,'#','','',1,0,'F','0','0','qualification:qualificationPermissionAdjustment:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22594,'资质权限调整历史删除',22590,4,'#','','',1,0,'F','0','0','qualification:qualificationPermissionAdjustment:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22595,'资质权限调整历史导入',22590,5,'#','','',1,0,'F','0','0','qualification:qualificationPermissionAdjustment:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22596,'资质权限调整历史导出',22590,6,'#','','',1,0,'F','0','0','qualification:qualificationPermissionAdjustment:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质风险监测按钮权限
INSERT INTO sys_menu VALUES(22601,'资质风险监测查询',22600,1,'#','','',1,0,'F','0','0','qualification:qualificationRiskMonitor:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22602,'资质风险监测新增',22600,2,'#','','',1,0,'F','0','0','qualification:qualificationRiskMonitor:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22603,'资质风险监测修改',22600,3,'#','','',1,0,'F','0','0','qualification:qualificationRiskMonitor:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22604,'资质风险监测删除',22600,4,'#','','',1,0,'F','0','0','qualification:qualificationRiskMonitor:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22605,'资质风险监测导入',22600,5,'#','','',1,0,'F','0','0','qualification:qualificationRiskMonitor:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22606,'资质风险监测导出',22600,6,'#','','',1,0,'F','0','0','qualification:qualificationRiskMonitor:export','#',100,1,sysdate(),NULL,NULL,'');

-- 资质使用记录按钮权限
INSERT INTO sys_menu VALUES(22611,'资质使用记录查询',22610,1,'#','','',1,0,'F','0','0','qualification:qualificationUsageRecord:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22612,'资质使用记录新增',22610,2,'#','','',1,0,'F','0','0','qualification:qualificationUsageRecord:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22613,'资质使用记录修改',22610,3,'#','','',1,0,'F','0','0','qualification:qualificationUsageRecord:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22614,'资质使用记录删除',22610,4,'#','','',1,0,'F','0','0','qualification:qualificationUsageRecord:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22615,'资质使用记录导入',22610,5,'#','','',1,0,'F','0','0','qualification:qualificationUsageRecord:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22616,'资质使用记录导出',22610,6,'#','','',1,0,'F','0','0','qualification:qualificationUsageRecord:export','#',100,1,sysdate(),NULL,NULL,'');

-- 医技资质目录按钮权限
INSERT INTO sys_menu VALUES(22621,'医技资质目录查询',22620,1,'#','','',1,0,'F','0','0','qualification:technicianQualificationCatalog:query','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22622,'医技资质目录新增',22620,2,'#','','',1,0,'F','0','0','qualification:technicianQualificationCatalog:add','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22623,'医技资质目录修改',22620,3,'#','','',1,0,'F','0','0','qualification:technicianQualificationCatalog:edit','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22624,'医技资质目录删除',22620,4,'#','','',1,0,'F','0','0','qualification:technicianQualificationCatalog:remove','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22625,'医技资质目录导入',22620,5,'#','','',1,0,'F','0','0','qualification:technicianQualificationCatalog:import','#',100,1,sysdate(),NULL,NULL,'');
INSERT INTO sys_menu VALUES(22626,'医技资质目录导出',22620,6,'#','','',1,0,'F','0','0','qualification:technicianQualificationCatalog:export','#',100,1,sysdate(),NULL,NULL,'');

-- ----------------------------
-- 4.定义角色权限分配
-- ----------------------------

-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 22500 AND menu_id < 23000;

COMMIT;