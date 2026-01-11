-- ----------------------------
-- 医师档案管理菜单SQL脚本
-- 生成时间：2026-01-10
-- ----------------------------

-- ----------------------------
-- 1. 创建医师档案管理主菜单
-- ----------------------------


INSERT INTO sys_menu VALUES ('20000', '医师档案管理', '0', '100', 'doctor', NULL, '', 1, 0, 'M', '0', '0', '', 'user-md', 100, 1, sysdate(), NULL, NULL, '医师档案管理目录');

-- ----------------------------
-- 2. 创建子菜单（调整后的ID顺序，从20010开始依次向下排列）
-- ----------------------------
INSERT INTO sys_menu VALUES ('20010', '医师仪表板', '20000', '10', 'doctorDashboard', 'doctor/doctorDashboard/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorDashboard:list', 'dashboard', 100, 1, sysdate(), NULL, NULL, '医师仪表板');
INSERT INTO sys_menu VALUES ('20020', '医师信息', '20000', '20', 'doctorInfo', 'doctor/doctorInfo/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorInfo:list', 'user-circle', 100, 1, sysdate(), NULL, NULL, '医师信息管理');
INSERT INTO sys_menu VALUES ('20030', '医师证书', '20000', '30', 'doctorCertificate', 'doctor/doctorCertificate/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorCertificate:list', 'certificate', 100, 1, sysdate(), NULL, NULL, '医师证书管理');
INSERT INTO sys_menu VALUES ('20040', '医师教育', '20000', '40', 'doctorEducation', 'doctor/doctorEducation/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorEducation:list', 'graduation-cap', 100, 1, sysdate(), NULL, NULL, '医师教育经历');
INSERT INTO sys_menu VALUES ('20050', '医师工作经验', '20000', '50', 'doctorWorkExperience', 'doctor/doctorWorkExperience/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorWorkExperience:list', 'briefcase', 100, 1, sysdate(), NULL, NULL, '医师工作经验');
INSERT INTO sys_menu VALUES ('20060', '医师培训', '20000', '60', 'doctorTraining', 'doctor/doctorTraining/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorTraining:list', 'chalkboard-teacher', 100, 1, sysdate(), NULL, NULL, '医师培训记录');
INSERT INTO sys_menu VALUES ('20070', '医师学术职称', '20000', '70', 'doctorAcademicPosition', 'doctor/doctorAcademicPosition/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorAcademicPosition:list', 'user-tie', 100, 1, sysdate(), NULL, NULL, '医师学术职称');
INSERT INTO sys_menu VALUES ('20080', '医师专业评级', '20000', '80', 'doctorProfessionalRating', 'doctor/doctorProfessionalRating/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorProfessionalRating:list', 'star', 100, 1, sysdate(), NULL, NULL, '医师专业评级');
INSERT INTO sys_menu VALUES ('20090', '医师资格目录', '20000', '90', 'doctorQualificationCatalog', 'doctor/doctorQualificationCatalog/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorQualificationCatalog:list', 'list', 100, 1, sysdate(), NULL, NULL, '医师资格目录');
INSERT INTO sys_menu VALUES ('20100', '医师荣誉', '20000', '100', 'doctorHonor', 'doctor/doctorHonor/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorHonor:list', 'trophy', 100, 1, sysdate(), NULL, NULL, '医师荣誉记录');
INSERT INTO sys_menu VALUES ('20110', '医师发表物', '20000', '110', 'doctorPublication', 'doctor/doctorPublication/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorPublication:list', 'book', 100, 1, sysdate(), NULL, NULL, '医师发表物');
INSERT INTO sys_menu VALUES ('20120', '医师研究项目', '20000', '120', 'doctorResearchProject', 'doctor/doctorResearchProject/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorResearchProject:list', 'flask', 100, 1, sysdate(), NULL, NULL, '医师研究项目');
INSERT INTO sys_menu VALUES ('20130', '医师能力评估', '20000', '130', 'doctorAbilityAssessment', 'doctor/doctorAbilityAssessment/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorAbilityAssessment:list', 'chart-line', 100, 1, sysdate(), NULL, NULL, '医师能力评估');
INSERT INTO sys_menu VALUES ('20140', '医师伦理评价', '20000', '140', 'doctorEthicsEvaluation', 'doctor/doctorEthicsEvaluation/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorEthicsEvaluation:list', 'balance-scale', 100, 1, sysdate(), NULL, NULL, '医师伦理评价');
INSERT INTO sys_menu VALUES ('20150', '医师不良记录', '20000', '150', 'doctorAdverseRecord', 'doctor/doctorAdverseRecord/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorAdverseRecord:list', 'exclamation-triangle', 100, 1, sysdate(), NULL, NULL, '医师不良记录');
INSERT INTO sys_menu VALUES ('20160', '医师电子注册', '20000', '160', 'doctorElectronicRegistration', 'doctor/doctorElectronicRegistration/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorElectronicRegistration:list', 'id-card', 100, 1, sysdate(), NULL, NULL, '医师电子注册');
INSERT INTO sys_menu VALUES ('20170', '医师保险代码', '20000', '170', 'doctorInsuranceCode', 'doctor/doctorInsuranceCode/index', '', 1, 0, 'C', '0', '0', 'doctor:doctorInsuranceCode:list', 'shield-alt', 100, 1, sysdate(), NULL, NULL, '医师保险代码');

-- ----------------------------
-- 3. 创建医师相关角色
-- ----------------------------

INSERT INTO sys_role VALUES('5', '000000', '护士', 'nurse', 5, 5, 1, 1, '0', '0', 100, 1, sysdate(), null, null, '护士角色，仅能查看本人数据');
INSERT INTO sys_role VALUES('6', '000000', '医生', 'doctor', 6, 5, 1, 1, '0', '0', 100, 1, sysdate(), null, null, '医生角色，仅能查看本人数据');
INSERT INTO sys_role VALUES('7', '000000', '科室主任', 'dept_director', 7, 3, 1, 1, '0', '0', 100, 1, sysdate(), null, null, '科室主任角色，能查看本部门数据');
INSERT INTO sys_role VALUES('8', '000000', '质控员', 'qc_user', 8, 1, 1, 1, '0', '0', 100, 1, sysdate(), null, null, '医务处角色，能查看全部数据');
INSERT INTO sys_role VALUES('9', '000000', '医务处', 'medical_affairs', 9, 1, 1, 1, '0', '0', 100, 1, sysdate(), null, null, '医务处角色，能查看全部数据');
INSERT INTO sys_role VALUES('10', '000000', '医务处主任', 'medical_director', 10, 1, 1, 1, '0', '0', 100, 1, sysdate(), null, null, '医务处主任角色，能查看全部数据');
INSERT INTO sys_role VALUES('11', '000000', '医院管理员', 'hospital_admin', 11, 0, 1, 1, '0', '0', 100, 1, sysdate(), null, null, '医院管理员角色，能查看全部数据和管理医师档案');

-- ----------------------------
-- 4. 定义按钮权限（每个菜单都有增删改查导出导入权限）
-- ----------------------------
-- 医师仪表板按钮
INSERT INTO sys_menu VALUES ('20011', '医师仪表板查询', '20010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorDashboard:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20012', '医师仪表板新增', '20010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorDashboard:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20013', '医师仪表板修改', '20010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorDashboard:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20014', '医师仪表板删除', '20010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorDashboard:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20015', '医师仪表板导入', '20010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorDashboard:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20016', '医师仪表板导出', '20010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorDashboard:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师信息按钮
INSERT INTO sys_menu VALUES ('20021', '医师信息查询', '20020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInfo:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20022', '医师信息新增', '20020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInfo:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20023', '医师信息修改', '20020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInfo:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20024', '医师信息删除', '20020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInfo:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20025', '医师信息导入', '20020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInfo:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20026', '医师信息导出', '20020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInfo:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师证书按钮
INSERT INTO sys_menu VALUES ('20031', '医师证书查询', '20030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorCertificate:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20032', '医师证书新增', '20030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorCertificate:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20033', '医师证书修改', '20030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorCertificate:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20034', '医师证书删除', '20030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorCertificate:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20035', '医师证书导入', '20030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorCertificate:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20036', '医师证书导出', '20030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorCertificate:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师教育按钮
INSERT INTO sys_menu VALUES ('20041', '医师教育查询', '20040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEducation:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20042', '医师教育新增', '20040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEducation:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20043', '医师教育修改', '20040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEducation:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20044', '医师教育删除', '20040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEducation:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20045', '医师教育导入', '20040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEducation:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20046', '医师教育导出', '20040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEducation:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师工作经验按钮
INSERT INTO sys_menu VALUES ('20051', '医师工作经验查询', '20050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorWorkExperience:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20052', '医师工作经验新增', '20050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorWorkExperience:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20053', '医师工作经验修改', '20050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorWorkExperience:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20054', '医师工作经验删除', '20050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorWorkExperience:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20055', '医师工作经验导入', '20050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorWorkExperience:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20056', '医师工作经验导出', '20050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorWorkExperience:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师培训按钮
INSERT INTO sys_menu VALUES ('20061', '医师培训查询', '20060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorTraining:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20062', '医师培训新增', '20060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorTraining:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20063', '医师培训修改', '20060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorTraining:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20064', '医师培训删除', '20060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorTraining:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20065', '医师培训导入', '20060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorTraining:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20066', '医师培训导出', '20060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorTraining:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师学术职称按钮
INSERT INTO sys_menu VALUES ('20071', '医师学术职称查询', '20070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAcademicPosition:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20072', '医师学术职称新增', '20070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAcademicPosition:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20073', '医师学术职称修改', '20070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAcademicPosition:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20074', '医师学术职称删除', '20070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAcademicPosition:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20075', '医师学术职称导入', '20070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAcademicPosition:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20076', '医师学术职称导出', '20070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAcademicPosition:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师专业评级按钮
INSERT INTO sys_menu VALUES ('20081', '医师专业评级查询', '20080', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorProfessionalRating:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20082', '医师专业评级新增', '20080', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorProfessionalRating:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20083', '医师专业评级修改', '20080', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorProfessionalRating:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20084', '医师专业评级删除', '20080', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorProfessionalRating:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20085', '医师专业评级导入', '20080', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorProfessionalRating:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20086', '医师专业评级导出', '20080', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorProfessionalRating:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师资格目录按钮
INSERT INTO sys_menu VALUES ('20091', '医师资格目录查询', '20090', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorQualificationCatalog:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20092', '医师资格目录新增', '20090', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorQualificationCatalog:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20093', '医师资格目录修改', '20090', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorQualificationCatalog:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20094', '医师资格目录删除', '20090', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorQualificationCatalog:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20095', '医师资格目录导入', '20090', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorQualificationCatalog:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20096', '医师资格目录导出', '20090', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorQualificationCatalog:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师荣誉按钮
INSERT INTO sys_menu VALUES ('20101', '医师荣誉查询', '20100', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorHonor:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20102', '医师荣誉新增', '20100', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorHonor:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20103', '医师荣誉修改', '20100', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorHonor:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20104', '医师荣誉删除', '20100', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorHonor:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20105', '医师荣誉导入', '20100', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorHonor:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20106', '医师荣誉导出', '20100', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorHonor:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师发表物按钮
INSERT INTO sys_menu VALUES ('20111', '医师发表物查询', '20110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorPublication:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20112', '医师发表物新增', '20110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorPublication:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20113', '医师发表物修改', '20110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorPublication:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20114', '医师发表物删除', '20110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorPublication:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20115', '医师发表物导入', '20110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorPublication:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20116', '医师发表物导出', '20110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorPublication:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师研究项目按钮
INSERT INTO sys_menu VALUES ('20121', '医师研究项目查询', '20120', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorResearchProject:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20122', '医师研究项目新增', '20120', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorResearchProject:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20123', '医师研究项目修改', '20120', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorResearchProject:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20124', '医师研究项目删除', '20120', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorResearchProject:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20125', '医师研究项目导入', '20120', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorResearchProject:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20126', '医师研究项目导出', '20120', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorResearchProject:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师能力评估按钮
INSERT INTO sys_menu VALUES ('20131', '医师能力评估查询', '20130', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAbilityAssessment:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20132', '医师能力评估新增', '20130', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAbilityAssessment:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20133', '医师能力评估修改', '20130', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAbilityAssessment:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20134', '医师能力评估删除', '20130', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAbilityAssessment:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20135', '医师能力评估导入', '20130', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAbilityAssessment:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20136', '医师能力评估导出', '20130', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAbilityAssessment:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师伦理评价按钮
INSERT INTO sys_menu VALUES ('20141', '医师伦理评价查询', '20140', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEthicsEvaluation:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20142', '医师伦理评价新增', '20140', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEthicsEvaluation:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20143', '医师伦理评价修改', '20140', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEthicsEvaluation:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20144', '医师伦理评价删除', '20140', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEthicsEvaluation:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20145', '医师伦理评价导入', '20140', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEthicsEvaluation:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20146', '医师伦理评价导出', '20140', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorEthicsEvaluation:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师不良记录按钮
INSERT INTO sys_menu VALUES ('20151', '医师不良记录查询', '20150', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAdverseRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20152', '医师不良记录新增', '20150', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAdverseRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20153', '医师不良记录修改', '20150', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAdverseRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20154', '医师不良记录删除', '20150', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAdverseRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20155', '医师不良记录导入', '20150', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAdverseRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20156', '医师不良记录导出', '20150', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorAdverseRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师电子注册按钮
INSERT INTO sys_menu VALUES ('20161', '医师电子注册查询', '20160', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorElectronicRegistration:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20162', '医师电子注册新增', '20160', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorElectronicRegistration:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20163', '医师电子注册修改', '20160', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorElectronicRegistration:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20164', '医师电子注册删除', '20160', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorElectronicRegistration:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20165', '医师电子注册导入', '20160', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorElectronicRegistration:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20166', '医师电子注册导出', '20160', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorElectronicRegistration:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 医师保险代码按钮
INSERT INTO sys_menu VALUES ('20171', '医师保险代码查询', '20170', '1', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInsuranceCode:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20172', '医师保险代码新增', '20170', '2', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInsuranceCode:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20173', '医师保险代码修改', '20170', '3', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInsuranceCode:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20174', '医师保险代码删除', '20170', '4', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInsuranceCode:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20175', '医师保险代码导入', '20170', '5', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInsuranceCode:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('20176', '医师保险代码导出', '20170', '6', '#', '', '', 1, 0, 'F', '0', '0', 'doctor:doctorInsuranceCode:export', '#', 100, 1, sysdate(), NULL, NULL, '');


-- ----------------------------
-- 5. 为角色分配菜单和按钮权限
-- ----------------------------
-- 为护士角色分配菜单和按钮权限


INSERT INTO sys_role_menu VALUES ('5', '20000');

INSERT INTO sys_role_menu VALUES ('5', '20010');
INSERT INTO sys_role_menu VALUES ('5', '20011');
INSERT INTO sys_role_menu VALUES ('5', '20012');
INSERT INTO sys_role_menu VALUES ('5', '20013');
INSERT INTO sys_role_menu VALUES ('5', '20014');
INSERT INTO sys_role_menu VALUES ('5', '20015');
INSERT INTO sys_role_menu VALUES ('5', '20016');

INSERT INTO sys_role_menu VALUES ('5', '20020');
INSERT INTO sys_role_menu VALUES ('5', '20021');
INSERT INTO sys_role_menu VALUES ('5', '20022');
INSERT INTO sys_role_menu VALUES ('5', '20023');
INSERT INTO sys_role_menu VALUES ('5', '20024');
INSERT INTO sys_role_menu VALUES ('5', '20025');
INSERT INTO sys_role_menu VALUES ('5', '20026');

INSERT INTO sys_role_menu VALUES ('5', '20030');
INSERT INTO sys_role_menu VALUES ('5', '20031');
INSERT INTO sys_role_menu VALUES ('5', '20032');
INSERT INTO sys_role_menu VALUES ('5', '20033');
INSERT INTO sys_role_menu VALUES ('5', '20034');
INSERT INTO sys_role_menu VALUES ('5', '20035');
INSERT INTO sys_role_menu VALUES ('5', '20036');

INSERT INTO sys_role_menu VALUES ('5', '20040');
INSERT INTO sys_role_menu VALUES ('5', '20041');
INSERT INTO sys_role_menu VALUES ('5', '20042');
INSERT INTO sys_role_menu VALUES ('5', '20043');
INSERT INTO sys_role_menu VALUES ('5', '20044');
INSERT INTO sys_role_menu VALUES ('5', '20045');
INSERT INTO sys_role_menu VALUES ('5', '20046');

INSERT INTO sys_role_menu VALUES ('5', '20050');
INSERT INTO sys_role_menu VALUES ('5', '20051');
INSERT INTO sys_role_menu VALUES ('5', '20052');
INSERT INTO sys_role_menu VALUES ('5', '20053');
INSERT INTO sys_role_menu VALUES ('5', '20054');
INSERT INTO sys_role_menu VALUES ('5', '20055');
INSERT INTO sys_role_menu VALUES ('5', '20056');

INSERT INTO sys_role_menu VALUES ('5', '20060');
INSERT INTO sys_role_menu VALUES ('5', '20061');
INSERT INTO sys_role_menu VALUES ('5', '20062');
INSERT INTO sys_role_menu VALUES ('5', '20063');
INSERT INTO sys_role_menu VALUES ('5', '20064');
INSERT INTO sys_role_menu VALUES ('5', '20065');
INSERT INTO sys_role_menu VALUES ('5', '20066');

INSERT INTO sys_role_menu VALUES ('5', '20070');
INSERT INTO sys_role_menu VALUES ('5', '20071');
INSERT INTO sys_role_menu VALUES ('5', '20072');
INSERT INTO sys_role_menu VALUES ('5', '20073');
INSERT INTO sys_role_menu VALUES ('5', '20074');
INSERT INTO sys_role_menu VALUES ('5', '20075');
INSERT INTO sys_role_menu VALUES ('5', '20076');

INSERT INTO sys_role_menu VALUES ('5', '20080');
INSERT INTO sys_role_menu VALUES ('5', '20081');
INSERT INTO sys_role_menu VALUES ('5', '20082');
INSERT INTO sys_role_menu VALUES ('5', '20083');
INSERT INTO sys_role_menu VALUES ('5', '20084');
INSERT INTO sys_role_menu VALUES ('5', '20085');
INSERT INTO sys_role_menu VALUES ('5', '20086');

INSERT INTO sys_role_menu VALUES ('5', '20090');
INSERT INTO sys_role_menu VALUES ('5', '20091');
INSERT INTO sys_role_menu VALUES ('5', '20092');
INSERT INTO sys_role_menu VALUES ('5', '20093');
INSERT INTO sys_role_menu VALUES ('5', '20094');
INSERT INTO sys_role_menu VALUES ('5', '20095');
INSERT INTO sys_role_menu VALUES ('5', '20096');

INSERT INTO sys_role_menu VALUES ('5', '20100');
INSERT INTO sys_role_menu VALUES ('5', '20101');
INSERT INTO sys_role_menu VALUES ('5', '20102');
INSERT INTO sys_role_menu VALUES ('5', '20103');
INSERT INTO sys_role_menu VALUES ('5', '20104');
INSERT INTO sys_role_menu VALUES ('5', '20105');
INSERT INTO sys_role_menu VALUES ('5', '20106');

INSERT INTO sys_role_menu VALUES ('5', '20110');
INSERT INTO sys_role_menu VALUES ('5', '20111');
INSERT INTO sys_role_menu VALUES ('5', '20112');
INSERT INTO sys_role_menu VALUES ('5', '20113');
INSERT INTO sys_role_menu VALUES ('5', '20114');
INSERT INTO sys_role_menu VALUES ('5', '20115');
INSERT INTO sys_role_menu VALUES ('5', '20116');

INSERT INTO sys_role_menu VALUES ('5', '20120');
INSERT INTO sys_role_menu VALUES ('5', '20121');
INSERT INTO sys_role_menu VALUES ('5', '20122');
INSERT INTO sys_role_menu VALUES ('5', '20123');
INSERT INTO sys_role_menu VALUES ('5', '20124');
INSERT INTO sys_role_menu VALUES ('5', '20125');
INSERT INTO sys_role_menu VALUES ('5', '20126');

INSERT INTO sys_role_menu VALUES ('5', '20130');
INSERT INTO sys_role_menu VALUES ('5', '20131');
INSERT INTO sys_role_menu VALUES ('5', '20132');
INSERT INTO sys_role_menu VALUES ('5', '20133');
INSERT INTO sys_role_menu VALUES ('5', '20134');
INSERT INTO sys_role_menu VALUES ('5', '20135');
INSERT INTO sys_role_menu VALUES ('5', '20136');

INSERT INTO sys_role_menu VALUES ('5', '20140');
INSERT INTO sys_role_menu VALUES ('5', '20141');
INSERT INTO sys_role_menu VALUES ('5', '20142');
INSERT INTO sys_role_menu VALUES ('5', '20143');
INSERT INTO sys_role_menu VALUES ('5', '20144');
INSERT INTO sys_role_menu VALUES ('5', '20145');
INSERT INTO sys_role_menu VALUES ('5', '20146');

INSERT INTO sys_role_menu VALUES ('5', '20150');
INSERT INTO sys_role_menu VALUES ('5', '20151');
INSERT INTO sys_role_menu VALUES ('5', '20152');
INSERT INTO sys_role_menu VALUES ('5', '20153');
INSERT INTO sys_role_menu VALUES ('5', '20154');
INSERT INTO sys_role_menu VALUES ('5', '20155');
INSERT INTO sys_role_menu VALUES ('5', '20156');

INSERT INTO sys_role_menu VALUES ('5', '20160');
INSERT INTO sys_role_menu VALUES ('5', '20161');
INSERT INTO sys_role_menu VALUES ('5', '20162');
INSERT INTO sys_role_menu VALUES ('5', '20163');
INSERT INTO sys_role_menu VALUES ('5', '20164');
INSERT INTO sys_role_menu VALUES ('5', '20165');
INSERT INTO sys_role_menu VALUES ('5', '20166');

INSERT INTO sys_role_menu VALUES ('5', '20170');
INSERT INTO sys_role_menu VALUES ('5', '20171');
INSERT INTO sys_role_menu VALUES ('5', '20172');
INSERT INTO sys_role_menu VALUES ('5', '20173');
INSERT INTO sys_role_menu VALUES ('5', '20174');
INSERT INTO sys_role_menu VALUES ('5', '20175');
INSERT INTO sys_role_menu VALUES ('5', '20176');

-- 医生角色分配菜单按钮权限
INSERT INTO sys_role_menu VALUES ('6', '20000');

INSERT INTO sys_role_menu VALUES ('6', '20010');
INSERT INTO sys_role_menu VALUES ('6', '20011');
INSERT INTO sys_role_menu VALUES ('6', '20012');
INSERT INTO sys_role_menu VALUES ('6', '20013');
INSERT INTO sys_role_menu VALUES ('6', '20014');
INSERT INTO sys_role_menu VALUES ('6', '20015');
INSERT INTO sys_role_menu VALUES ('6', '20016');

INSERT INTO sys_role_menu VALUES ('6', '20020');
INSERT INTO sys_role_menu VALUES ('6', '20021');
INSERT INTO sys_role_menu VALUES ('6', '20022');
INSERT INTO sys_role_menu VALUES ('6', '20023');
INSERT INTO sys_role_menu VALUES ('6', '20024');
INSERT INTO sys_role_menu VALUES ('6', '20025');
INSERT INTO sys_role_menu VALUES ('6', '20026');

INSERT INTO sys_role_menu VALUES ('6', '20030');
INSERT INTO sys_role_menu VALUES ('6', '20031');
INSERT INTO sys_role_menu VALUES ('6', '20032');
INSERT INTO sys_role_menu VALUES ('6', '20033');
INSERT INTO sys_role_menu VALUES ('6', '20034');
INSERT INTO sys_role_menu VALUES ('6', '20035');
INSERT INTO sys_role_menu VALUES ('6', '20036');

INSERT INTO sys_role_menu VALUES ('6', '20040');
INSERT INTO sys_role_menu VALUES ('6', '20041');
INSERT INTO sys_role_menu VALUES ('6', '20042');
INSERT INTO sys_role_menu VALUES ('6', '20043');
INSERT INTO sys_role_menu VALUES ('6', '20044');
INSERT INTO sys_role_menu VALUES ('6', '20045');
INSERT INTO sys_role_menu VALUES ('6', '20046');

INSERT INTO sys_role_menu VALUES ('6', '20050');
INSERT INTO sys_role_menu VALUES ('6', '20051');
INSERT INTO sys_role_menu VALUES ('6', '20052');
INSERT INTO sys_role_menu VALUES ('6', '20053');
INSERT INTO sys_role_menu VALUES ('6', '20054');
INSERT INTO sys_role_menu VALUES ('6', '20055');
INSERT INTO sys_role_menu VALUES ('6', '20056');

INSERT INTO sys_role_menu VALUES ('6', '20060');
INSERT INTO sys_role_menu VALUES ('6', '20061');
INSERT INTO sys_role_menu VALUES ('6', '20062');
INSERT INTO sys_role_menu VALUES ('6', '20063');
INSERT INTO sys_role_menu VALUES ('6', '20064');
INSERT INTO sys_role_menu VALUES ('6', '20065');
INSERT INTO sys_role_menu VALUES ('6', '20066');

INSERT INTO sys_role_menu VALUES ('6', '20070');
INSERT INTO sys_role_menu VALUES ('6', '20071');
INSERT INTO sys_role_menu VALUES ('6', '20072');
INSERT INTO sys_role_menu VALUES ('6', '20073');
INSERT INTO sys_role_menu VALUES ('6', '20074');
INSERT INTO sys_role_menu VALUES ('6', '20075');
INSERT INTO sys_role_menu VALUES ('6', '20076');

INSERT INTO sys_role_menu VALUES ('6', '20080');
INSERT INTO sys_role_menu VALUES ('6', '20081');
INSERT INTO sys_role_menu VALUES ('6', '20082');
INSERT INTO sys_role_menu VALUES ('6', '20083');
INSERT INTO sys_role_menu VALUES ('6', '20084');
INSERT INTO sys_role_menu VALUES ('6', '20085');
INSERT INTO sys_role_menu VALUES ('6', '20086');

INSERT INTO sys_role_menu VALUES ('6', '20090');
INSERT INTO sys_role_menu VALUES ('6', '20091');
INSERT INTO sys_role_menu VALUES ('6', '20092');
INSERT INTO sys_role_menu VALUES ('6', '20093');
INSERT INTO sys_role_menu VALUES ('6', '20094');
INSERT INTO sys_role_menu VALUES ('6', '20095');
INSERT INTO sys_role_menu VALUES ('6', '20096');

INSERT INTO sys_role_menu VALUES ('6', '20100');
INSERT INTO sys_role_menu VALUES ('6', '20101');
INSERT INTO sys_role_menu VALUES ('6', '20102');
INSERT INTO sys_role_menu VALUES ('6', '20103');
INSERT INTO sys_role_menu VALUES ('6', '20104');
INSERT INTO sys_role_menu VALUES ('6', '20105');
INSERT INTO sys_role_menu VALUES ('6', '20106');

INSERT INTO sys_role_menu VALUES ('6', '20110');
INSERT INTO sys_role_menu VALUES ('6', '20111');
INSERT INTO sys_role_menu VALUES ('6', '20112');
INSERT INTO sys_role_menu VALUES ('6', '20113');
INSERT INTO sys_role_menu VALUES ('6', '20114');
INSERT INTO sys_role_menu VALUES ('6', '20115');
INSERT INTO sys_role_menu VALUES ('6', '20116');

INSERT INTO sys_role_menu VALUES ('6', '20120');
INSERT INTO sys_role_menu VALUES ('6', '20121');
INSERT INTO sys_role_menu VALUES ('6', '20122');
INSERT INTO sys_role_menu VALUES ('6', '20123');
INSERT INTO sys_role_menu VALUES ('6', '20124');
INSERT INTO sys_role_menu VALUES ('6', '20125');
INSERT INTO sys_role_menu VALUES ('6', '20126');

INSERT INTO sys_role_menu VALUES ('6', '20130');
INSERT INTO sys_role_menu VALUES ('6', '20131');
INSERT INTO sys_role_menu VALUES ('6', '20132');
INSERT INTO sys_role_menu VALUES ('6', '20133');
INSERT INTO sys_role_menu VALUES ('6', '20134');
INSERT INTO sys_role_menu VALUES ('6', '20135');
INSERT INTO sys_role_menu VALUES ('6', '20136');

INSERT INTO sys_role_menu VALUES ('6', '20140');
INSERT INTO sys_role_menu VALUES ('6', '20141');
INSERT INTO sys_role_menu VALUES ('6', '20142');
INSERT INTO sys_role_menu VALUES ('6', '20143');
INSERT INTO sys_role_menu VALUES ('6', '20144');
INSERT INTO sys_role_menu VALUES ('6', '20145');
INSERT INTO sys_role_menu VALUES ('6', '20146');

INSERT INTO sys_role_menu VALUES ('6', '20150');
INSERT INTO sys_role_menu VALUES ('6', '20151');
INSERT INTO sys_role_menu VALUES ('6', '20152');
INSERT INTO sys_role_menu VALUES ('6', '20153');
INSERT INTO sys_role_menu VALUES ('6', '20154');
INSERT INTO sys_role_menu VALUES ('6', '20155');
INSERT INTO sys_role_menu VALUES ('6', '20156');

INSERT INTO sys_role_menu VALUES ('6', '20160');
INSERT INTO sys_role_menu VALUES ('6', '20161');
INSERT INTO sys_role_menu VALUES ('6', '20162');
INSERT INTO sys_role_menu VALUES ('6', '20163');
INSERT INTO sys_role_menu VALUES ('6', '20164');
INSERT INTO sys_role_menu VALUES ('6', '20165');
INSERT INTO sys_role_menu VALUES ('6', '20166');

INSERT INTO sys_role_menu VALUES ('6', '20170');
INSERT INTO sys_role_menu VALUES ('6', '20171');
INSERT INTO sys_role_menu VALUES ('6', '20172');
INSERT INTO sys_role_menu VALUES ('6', '20173');
INSERT INTO sys_role_menu VALUES ('6', '20174');
INSERT INTO sys_role_menu VALUES ('6', '20175');
INSERT INTO sys_role_menu VALUES ('6', '20176');

-- 为科室主任份配菜单按钮权限

INSERT INTO sys_role_menu VALUES ('7', '20000');

INSERT INTO sys_role_menu VALUES ('7', '20010');
INSERT INTO sys_role_menu VALUES ('7', '20011');
INSERT INTO sys_role_menu VALUES ('7', '20012');
INSERT INTO sys_role_menu VALUES ('7', '20013');
INSERT INTO sys_role_menu VALUES ('7', '20014');
INSERT INTO sys_role_menu VALUES ('7', '20015');
INSERT INTO sys_role_menu VALUES ('7', '20016');

INSERT INTO sys_role_menu VALUES ('7', '20020');
INSERT INTO sys_role_menu VALUES ('7', '20021');
INSERT INTO sys_role_menu VALUES ('7', '20022');
INSERT INTO sys_role_menu VALUES ('7', '20023');
INSERT INTO sys_role_menu VALUES ('7', '20024');
INSERT INTO sys_role_menu VALUES ('7', '20025');
INSERT INTO sys_role_menu VALUES ('7', '20026');

INSERT INTO sys_role_menu VALUES ('7', '20030');
INSERT INTO sys_role_menu VALUES ('7', '20031');
INSERT INTO sys_role_menu VALUES ('7', '20032');
INSERT INTO sys_role_menu VALUES ('7', '20033');
INSERT INTO sys_role_menu VALUES ('7', '20034');
INSERT INTO sys_role_menu VALUES ('7', '20035');
INSERT INTO sys_role_menu VALUES ('7', '20036');

INSERT INTO sys_role_menu VALUES ('7', '20040');
INSERT INTO sys_role_menu VALUES ('7', '20041');
INSERT INTO sys_role_menu VALUES ('7', '20042');
INSERT INTO sys_role_menu VALUES ('7', '20043');
INSERT INTO sys_role_menu VALUES ('7', '20044');
INSERT INTO sys_role_menu VALUES ('7', '20045');
INSERT INTO sys_role_menu VALUES ('7', '20046');

INSERT INTO sys_role_menu VALUES ('7', '20050');
INSERT INTO sys_role_menu VALUES ('7', '20051');
INSERT INTO sys_role_menu VALUES ('7', '20052');
INSERT INTO sys_role_menu VALUES ('7', '20053');
INSERT INTO sys_role_menu VALUES ('7', '20054');
INSERT INTO sys_role_menu VALUES ('7', '20055');
INSERT INTO sys_role_menu VALUES ('7', '20056');

INSERT INTO sys_role_menu VALUES ('7', '20060');
INSERT INTO sys_role_menu VALUES ('7', '20061');
INSERT INTO sys_role_menu VALUES ('7', '20062');
INSERT INTO sys_role_menu VALUES ('7', '20063');
INSERT INTO sys_role_menu VALUES ('7', '20064');
INSERT INTO sys_role_menu VALUES ('7', '20065');
INSERT INTO sys_role_menu VALUES ('7', '20066');

INSERT INTO sys_role_menu VALUES ('7', '20070');
INSERT INTO sys_role_menu VALUES ('7', '20071');
INSERT INTO sys_role_menu VALUES ('7', '20072');
INSERT INTO sys_role_menu VALUES ('7', '20073');
INSERT INTO sys_role_menu VALUES ('7', '20074');
INSERT INTO sys_role_menu VALUES ('7', '20075');
INSERT INTO sys_role_menu VALUES ('7', '20076');

INSERT INTO sys_role_menu VALUES ('7', '20080');
INSERT INTO sys_role_menu VALUES ('7', '20081');
INSERT INTO sys_role_menu VALUES ('7', '20082');
INSERT INTO sys_role_menu VALUES ('7', '20083');
INSERT INTO sys_role_menu VALUES ('7', '20084');
INSERT INTO sys_role_menu VALUES ('7', '20085');
INSERT INTO sys_role_menu VALUES ('7', '20086');

INSERT INTO sys_role_menu VALUES ('7', '20090');
INSERT INTO sys_role_menu VALUES ('7', '20091');
INSERT INTO sys_role_menu VALUES ('7', '20092');
INSERT INTO sys_role_menu VALUES ('7', '20093');
INSERT INTO sys_role_menu VALUES ('7', '20094');
INSERT INTO sys_role_menu VALUES ('7', '20095');
INSERT INTO sys_role_menu VALUES ('7', '20096');

INSERT INTO sys_role_menu VALUES ('7', '20100');
INSERT INTO sys_role_menu VALUES ('7', '20101');
INSERT INTO sys_role_menu VALUES ('7', '20102');
INSERT INTO sys_role_menu VALUES ('7', '20103');
INSERT INTO sys_role_menu VALUES ('7', '20104');
INSERT INTO sys_role_menu VALUES ('7', '20105');
INSERT INTO sys_role_menu VALUES ('7', '20106');

INSERT INTO sys_role_menu VALUES ('7', '20110');
INSERT INTO sys_role_menu VALUES ('7', '20111');
INSERT INTO sys_role_menu VALUES ('7', '20112');
INSERT INTO sys_role_menu VALUES ('7', '20113');
INSERT INTO sys_role_menu VALUES ('7', '20114');
INSERT INTO sys_role_menu VALUES ('7', '20115');
INSERT INTO sys_role_menu VALUES ('7', '20116');

INSERT INTO sys_role_menu VALUES ('7', '20120');
INSERT INTO sys_role_menu VALUES ('7', '20121');
INSERT INTO sys_role_menu VALUES ('7', '20122');
INSERT INTO sys_role_menu VALUES ('7', '20123');
INSERT INTO sys_role_menu VALUES ('7', '20124');
INSERT INTO sys_role_menu VALUES ('7', '20125');
INSERT INTO sys_role_menu VALUES ('7', '20126');

INSERT INTO sys_role_menu VALUES ('7', '20130');
INSERT INTO sys_role_menu VALUES ('7', '20131');
INSERT INTO sys_role_menu VALUES ('7', '20132');
INSERT INTO sys_role_menu VALUES ('7', '20133');
INSERT INTO sys_role_menu VALUES ('7', '20134');
INSERT INTO sys_role_menu VALUES ('7', '20135');
INSERT INTO sys_role_menu VALUES ('7', '20136');

INSERT INTO sys_role_menu VALUES ('7', '20140');
INSERT INTO sys_role_menu VALUES ('7', '20141');
INSERT INTO sys_role_menu VALUES ('7', '20142');
INSERT INTO sys_role_menu VALUES ('7', '20143');
INSERT INTO sys_role_menu VALUES ('7', '20144');
INSERT INTO sys_role_menu VALUES ('7', '20145');
INSERT INTO sys_role_menu VALUES ('7', '20146');

INSERT INTO sys_role_menu VALUES ('7', '20150');
INSERT INTO sys_role_menu VALUES ('7', '20151');
INSERT INTO sys_role_menu VALUES ('7', '20152');
INSERT INTO sys_role_menu VALUES ('7', '20153');
INSERT INTO sys_role_menu VALUES ('7', '20154');
INSERT INTO sys_role_menu VALUES ('7', '20155');
INSERT INTO sys_role_menu VALUES ('7', '20156');

INSERT INTO sys_role_menu VALUES ('7', '20160');
INSERT INTO sys_role_menu VALUES ('7', '20161');
INSERT INTO sys_role_menu VALUES ('7', '20162');
INSERT INTO sys_role_menu VALUES ('7', '20163');
INSERT INTO sys_role_menu VALUES ('7', '20164');
INSERT INTO sys_role_menu VALUES ('7', '20165');
INSERT INTO sys_role_menu VALUES ('7', '20166');

INSERT INTO sys_role_menu VALUES ('7', '20170');
INSERT INTO sys_role_menu VALUES ('7', '20171');
INSERT INTO sys_role_menu VALUES ('7', '20172');
INSERT INTO sys_role_menu VALUES ('7', '20173');
INSERT INTO sys_role_menu VALUES ('7', '20174');
INSERT INTO sys_role_menu VALUES ('7', '20175');
INSERT INTO sys_role_menu VALUES ('7', '20176');

-- 为质控员角色分配按钮权限

INSERT INTO sys_role_menu VALUES ('8', '20000');

INSERT INTO sys_role_menu VALUES ('8', '20010');
INSERT INTO sys_role_menu VALUES ('8', '20011');
INSERT INTO sys_role_menu VALUES ('8', '20012');
INSERT INTO sys_role_menu VALUES ('8', '20013');
INSERT INTO sys_role_menu VALUES ('8', '20014');
INSERT INTO sys_role_menu VALUES ('8', '20015');
INSERT INTO sys_role_menu VALUES ('8', '20016');

INSERT INTO sys_role_menu VALUES ('8', '20020');
INSERT INTO sys_role_menu VALUES ('8', '20021');
INSERT INTO sys_role_menu VALUES ('8', '20022');
INSERT INTO sys_role_menu VALUES ('8', '20023');
INSERT INTO sys_role_menu VALUES ('8', '20024');
INSERT INTO sys_role_menu VALUES ('8', '20025');
INSERT INTO sys_role_menu VALUES ('8', '20026');

INSERT INTO sys_role_menu VALUES ('8', '20030');
INSERT INTO sys_role_menu VALUES ('8', '20031');
INSERT INTO sys_role_menu VALUES ('8', '20032');
INSERT INTO sys_role_menu VALUES ('8', '20033');
INSERT INTO sys_role_menu VALUES ('8', '20034');
INSERT INTO sys_role_menu VALUES ('8', '20035');
INSERT INTO sys_role_menu VALUES ('8', '20036');

INSERT INTO sys_role_menu VALUES ('8', '20040');
INSERT INTO sys_role_menu VALUES ('8', '20041');
INSERT INTO sys_role_menu VALUES ('8', '20042');
INSERT INTO sys_role_menu VALUES ('8', '20043');
INSERT INTO sys_role_menu VALUES ('8', '20044');
INSERT INTO sys_role_menu VALUES ('8', '20045');
INSERT INTO sys_role_menu VALUES ('8', '20046');

INSERT INTO sys_role_menu VALUES ('8', '20050');
INSERT INTO sys_role_menu VALUES ('8', '20051');
INSERT INTO sys_role_menu VALUES ('8', '20052');
INSERT INTO sys_role_menu VALUES ('8', '20053');
INSERT INTO sys_role_menu VALUES ('8', '20054');
INSERT INTO sys_role_menu VALUES ('8', '20055');
INSERT INTO sys_role_menu VALUES ('8', '20056');

INSERT INTO sys_role_menu VALUES ('8', '20060');
INSERT INTO sys_role_menu VALUES ('8', '20061');
INSERT INTO sys_role_menu VALUES ('8', '20062');
INSERT INTO sys_role_menu VALUES ('8', '20063');
INSERT INTO sys_role_menu VALUES ('8', '20064');
INSERT INTO sys_role_menu VALUES ('8', '20065');
INSERT INTO sys_role_menu VALUES ('8', '20066');

INSERT INTO sys_role_menu VALUES ('8', '20070');
INSERT INTO sys_role_menu VALUES ('8', '20071');
INSERT INTO sys_role_menu VALUES ('8', '20072');
INSERT INTO sys_role_menu VALUES ('8', '20073');
INSERT INTO sys_role_menu VALUES ('8', '20074');
INSERT INTO sys_role_menu VALUES ('8', '20075');
INSERT INTO sys_role_menu VALUES ('8', '20076');

INSERT INTO sys_role_menu VALUES ('8', '20080');
INSERT INTO sys_role_menu VALUES ('8', '20081');
INSERT INTO sys_role_menu VALUES ('8', '20082');
INSERT INTO sys_role_menu VALUES ('8', '20083');
INSERT INTO sys_role_menu VALUES ('8', '20084');
INSERT INTO sys_role_menu VALUES ('8', '20085');
INSERT INTO sys_role_menu VALUES ('8', '20086');

INSERT INTO sys_role_menu VALUES ('8', '20090');
INSERT INTO sys_role_menu VALUES ('8', '20091');
INSERT INTO sys_role_menu VALUES ('8', '20092');
INSERT INTO sys_role_menu VALUES ('8', '20093');
INSERT INTO sys_role_menu VALUES ('8', '20094');
INSERT INTO sys_role_menu VALUES ('8', '20095');
INSERT INTO sys_role_menu VALUES ('8', '20096');

INSERT INTO sys_role_menu VALUES ('8', '20100');
INSERT INTO sys_role_menu VALUES ('8', '20101');
INSERT INTO sys_role_menu VALUES ('8', '20102');
INSERT INTO sys_role_menu VALUES ('8', '20103');
INSERT INTO sys_role_menu VALUES ('8', '20104');
INSERT INTO sys_role_menu VALUES ('8', '20105');
INSERT INTO sys_role_menu VALUES ('8', '20106');

INSERT INTO sys_role_menu VALUES ('8', '20110');
INSERT INTO sys_role_menu VALUES ('8', '20111');
INSERT INTO sys_role_menu VALUES ('8', '20112');
INSERT INTO sys_role_menu VALUES ('8', '20113');
INSERT INTO sys_role_menu VALUES ('8', '20114');
INSERT INTO sys_role_menu VALUES ('8', '20115');
INSERT INTO sys_role_menu VALUES ('8', '20116');

INSERT INTO sys_role_menu VALUES ('8', '20120');
INSERT INTO sys_role_menu VALUES ('8', '20121');
INSERT INTO sys_role_menu VALUES ('8', '20122');
INSERT INTO sys_role_menu VALUES ('8', '20123');
INSERT INTO sys_role_menu VALUES ('8', '20124');
INSERT INTO sys_role_menu VALUES ('8', '20125');
INSERT INTO sys_role_menu VALUES ('8', '20126');

INSERT INTO sys_role_menu VALUES ('8', '20130');
INSERT INTO sys_role_menu VALUES ('8', '20131');
INSERT INTO sys_role_menu VALUES ('8', '20132');
INSERT INTO sys_role_menu VALUES ('8', '20133');
INSERT INTO sys_role_menu VALUES ('8', '20134');
INSERT INTO sys_role_menu VALUES ('8', '20135');
INSERT INTO sys_role_menu VALUES ('8', '20136');

INSERT INTO sys_role_menu VALUES ('8', '20140');
INSERT INTO sys_role_menu VALUES ('8', '20141');
INSERT INTO sys_role_menu VALUES ('8', '20142');
INSERT INTO sys_role_menu VALUES ('8', '20143');
INSERT INTO sys_role_menu VALUES ('8', '20144');
INSERT INTO sys_role_menu VALUES ('8', '20145');
INSERT INTO sys_role_menu VALUES ('8', '20146');

INSERT INTO sys_role_menu VALUES ('8', '20150');
INSERT INTO sys_role_menu VALUES ('8', '20151');
INSERT INTO sys_role_menu VALUES ('8', '20152');
INSERT INTO sys_role_menu VALUES ('8', '20153');
INSERT INTO sys_role_menu VALUES ('8', '20154');
INSERT INTO sys_role_menu VALUES ('8', '20155');
INSERT INTO sys_role_menu VALUES ('8', '20156');

INSERT INTO sys_role_menu VALUES ('8', '20160');
INSERT INTO sys_role_menu VALUES ('8', '20161');
INSERT INTO sys_role_menu VALUES ('8', '20162');
INSERT INTO sys_role_menu VALUES ('8', '20163');
INSERT INTO sys_role_menu VALUES ('8', '20164');
INSERT INTO sys_role_menu VALUES ('8', '20165');
INSERT INTO sys_role_menu VALUES ('8', '20166');

INSERT INTO sys_role_menu VALUES ('8', '20170');
INSERT INTO sys_role_menu VALUES ('8', '20171');
INSERT INTO sys_role_menu VALUES ('8', '20172');
INSERT INTO sys_role_menu VALUES ('8', '20173');
INSERT INTO sys_role_menu VALUES ('8', '20174');
INSERT INTO sys_role_menu VALUES ('8', '20175');
INSERT INTO sys_role_menu VALUES ('8', '20176');

-- 为医务部分配菜单按钮权限

INSERT INTO sys_role_menu VALUES ('9', '20000');

INSERT INTO sys_role_menu VALUES ('9', '20010');
INSERT INTO sys_role_menu VALUES ('9', '20011');
INSERT INTO sys_role_menu VALUES ('9', '20012');
INSERT INTO sys_role_menu VALUES ('9', '20013');
INSERT INTO sys_role_menu VALUES ('9', '20014');
INSERT INTO sys_role_menu VALUES ('9', '20015');
INSERT INTO sys_role_menu VALUES ('9', '20016');

INSERT INTO sys_role_menu VALUES ('9', '20020');
INSERT INTO sys_role_menu VALUES ('9', '20021');
INSERT INTO sys_role_menu VALUES ('9', '20022');
INSERT INTO sys_role_menu VALUES ('9', '20023');
INSERT INTO sys_role_menu VALUES ('9', '20024');
INSERT INTO sys_role_menu VALUES ('9', '20025');
INSERT INTO sys_role_menu VALUES ('9', '20026');

INSERT INTO sys_role_menu VALUES ('9', '20030');
INSERT INTO sys_role_menu VALUES ('9', '20031');
INSERT INTO sys_role_menu VALUES ('9', '20032');
INSERT INTO sys_role_menu VALUES ('9', '20033');
INSERT INTO sys_role_menu VALUES ('9', '20034');
INSERT INTO sys_role_menu VALUES ('9', '20035');
INSERT INTO sys_role_menu VALUES ('9', '20036');

INSERT INTO sys_role_menu VALUES ('9', '20040');
INSERT INTO sys_role_menu VALUES ('9', '20041');
INSERT INTO sys_role_menu VALUES ('9', '20042');
INSERT INTO sys_role_menu VALUES ('9', '20043');
INSERT INTO sys_role_menu VALUES ('9', '20044');
INSERT INTO sys_role_menu VALUES ('9', '20045');
INSERT INTO sys_role_menu VALUES ('9', '20046');

INSERT INTO sys_role_menu VALUES ('9', '20050');
INSERT INTO sys_role_menu VALUES ('9', '20051');
INSERT INTO sys_role_menu VALUES ('9', '20052');
INSERT INTO sys_role_menu VALUES ('9', '20053');
INSERT INTO sys_role_menu VALUES ('9', '20054');
INSERT INTO sys_role_menu VALUES ('9', '20055');
INSERT INTO sys_role_menu VALUES ('9', '20056');

INSERT INTO sys_role_menu VALUES ('9', '20060');
INSERT INTO sys_role_menu VALUES ('9', '20061');
INSERT INTO sys_role_menu VALUES ('9', '20062');
INSERT INTO sys_role_menu VALUES ('9', '20063');
INSERT INTO sys_role_menu VALUES ('9', '20064');
INSERT INTO sys_role_menu VALUES ('9', '20065');
INSERT INTO sys_role_menu VALUES ('9', '20066');

INSERT INTO sys_role_menu VALUES ('9', '20070');
INSERT INTO sys_role_menu VALUES ('9', '20071');
INSERT INTO sys_role_menu VALUES ('9', '20072');
INSERT INTO sys_role_menu VALUES ('9', '20073');
INSERT INTO sys_role_menu VALUES ('9', '20074');
INSERT INTO sys_role_menu VALUES ('9', '20075');
INSERT INTO sys_role_menu VALUES ('9', '20076');

INSERT INTO sys_role_menu VALUES ('9', '20080');
INSERT INTO sys_role_menu VALUES ('9', '20081');
INSERT INTO sys_role_menu VALUES ('9', '20082');
INSERT INTO sys_role_menu VALUES ('9', '20083');
INSERT INTO sys_role_menu VALUES ('9', '20084');
INSERT INTO sys_role_menu VALUES ('9', '20085');
INSERT INTO sys_role_menu VALUES ('9', '20086');

INSERT INTO sys_role_menu VALUES ('9', '20090');
INSERT INTO sys_role_menu VALUES ('9', '20091');
INSERT INTO sys_role_menu VALUES ('9', '20092');
INSERT INTO sys_role_menu VALUES ('9', '20093');
INSERT INTO sys_role_menu VALUES ('9', '20094');
INSERT INTO sys_role_menu VALUES ('9', '20095');
INSERT INTO sys_role_menu VALUES ('9', '20096');

INSERT INTO sys_role_menu VALUES ('9', '20100');
INSERT INTO sys_role_menu VALUES ('9', '20101');
INSERT INTO sys_role_menu VALUES ('9', '20102');
INSERT INTO sys_role_menu VALUES ('9', '20103');
INSERT INTO sys_role_menu VALUES ('9', '20104');
INSERT INTO sys_role_menu VALUES ('9', '20105');
INSERT INTO sys_role_menu VALUES ('9', '20106');

INSERT INTO sys_role_menu VALUES ('9', '20110');
INSERT INTO sys_role_menu VALUES ('9', '20111');
INSERT INTO sys_role_menu VALUES ('9', '20112');
INSERT INTO sys_role_menu VALUES ('9', '20113');
INSERT INTO sys_role_menu VALUES ('9', '20114');
INSERT INTO sys_role_menu VALUES ('9', '20115');
INSERT INTO sys_role_menu VALUES ('9', '20116');

INSERT INTO sys_role_menu VALUES ('9', '20120');
INSERT INTO sys_role_menu VALUES ('9', '20121');
INSERT INTO sys_role_menu VALUES ('9', '20122');
INSERT INTO sys_role_menu VALUES ('9', '20123');
INSERT INTO sys_role_menu VALUES ('9', '20124');
INSERT INTO sys_role_menu VALUES ('9', '20125');
INSERT INTO sys_role_menu VALUES ('9', '20126');

INSERT INTO sys_role_menu VALUES ('9', '20130');
INSERT INTO sys_role_menu VALUES ('9', '20131');
INSERT INTO sys_role_menu VALUES ('9', '20132');
INSERT INTO sys_role_menu VALUES ('9', '20133');
INSERT INTO sys_role_menu VALUES ('9', '20134');
INSERT INTO sys_role_menu VALUES ('9', '20135');
INSERT INTO sys_role_menu VALUES ('9', '20136');

INSERT INTO sys_role_menu VALUES ('9', '20140');
INSERT INTO sys_role_menu VALUES ('9', '20141');
INSERT INTO sys_role_menu VALUES ('9', '20142');
INSERT INTO sys_role_menu VALUES ('9', '20143');
INSERT INTO sys_role_menu VALUES ('9', '20144');
INSERT INTO sys_role_menu VALUES ('9', '20145');
INSERT INTO sys_role_menu VALUES ('9', '20146');

INSERT INTO sys_role_menu VALUES ('9', '20150');
INSERT INTO sys_role_menu VALUES ('9', '20151');
INSERT INTO sys_role_menu VALUES ('9', '20152');
INSERT INTO sys_role_menu VALUES ('9', '20153');
INSERT INTO sys_role_menu VALUES ('9', '20154');
INSERT INTO sys_role_menu VALUES ('9', '20155');
INSERT INTO sys_role_menu VALUES ('9', '20156');

INSERT INTO sys_role_menu VALUES ('9', '20160');
INSERT INTO sys_role_menu VALUES ('9', '20161');
INSERT INTO sys_role_menu VALUES ('9', '20162');
INSERT INTO sys_role_menu VALUES ('9', '20163');
INSERT INTO sys_role_menu VALUES ('9', '20164');
INSERT INTO sys_role_menu VALUES ('9', '20165');
INSERT INTO sys_role_menu VALUES ('9', '20166');

INSERT INTO sys_role_menu VALUES ('9', '20170');
INSERT INTO sys_role_menu VALUES ('9', '20171');
INSERT INTO sys_role_menu VALUES ('9', '20172');
INSERT INTO sys_role_menu VALUES ('9', '20173');
INSERT INTO sys_role_menu VALUES ('9', '20174');
INSERT INTO sys_role_menu VALUES ('9', '20175');
INSERT INTO sys_role_menu VALUES ('9', '20176');

-- 为医务部主任角色分配按钮权限

INSERT INTO sys_role_menu VALUES ('10', '20000');

INSERT INTO sys_role_menu VALUES ('10', '20010');
INSERT INTO sys_role_menu VALUES ('10', '20011');
INSERT INTO sys_role_menu VALUES ('10', '20012');
INSERT INTO sys_role_menu VALUES ('10', '20013');
INSERT INTO sys_role_menu VALUES ('10', '20014');
INSERT INTO sys_role_menu VALUES ('10', '20015');
INSERT INTO sys_role_menu VALUES ('10', '20016');

INSERT INTO sys_role_menu VALUES ('10', '20020');
INSERT INTO sys_role_menu VALUES ('10', '20021');
INSERT INTO sys_role_menu VALUES ('10', '20022');
INSERT INTO sys_role_menu VALUES ('10', '20023');
INSERT INTO sys_role_menu VALUES ('10', '20024');
INSERT INTO sys_role_menu VALUES ('10', '20025');
INSERT INTO sys_role_menu VALUES ('10', '20026');

INSERT INTO sys_role_menu VALUES ('10', '20030');
INSERT INTO sys_role_menu VALUES ('10', '20031');
INSERT INTO sys_role_menu VALUES ('10', '20032');
INSERT INTO sys_role_menu VALUES ('10', '20033');
INSERT INTO sys_role_menu VALUES ('10', '20034');
INSERT INTO sys_role_menu VALUES ('10', '20035');
INSERT INTO sys_role_menu VALUES ('10', '20036');

INSERT INTO sys_role_menu VALUES ('10', '20040');
INSERT INTO sys_role_menu VALUES ('10', '20041');
INSERT INTO sys_role_menu VALUES ('10', '20042');
INSERT INTO sys_role_menu VALUES ('10', '20043');
INSERT INTO sys_role_menu VALUES ('10', '20044');
INSERT INTO sys_role_menu VALUES ('10', '20045');
INSERT INTO sys_role_menu VALUES ('10', '20046');

INSERT INTO sys_role_menu VALUES ('10', '20050');
INSERT INTO sys_role_menu VALUES ('10', '20051');
INSERT INTO sys_role_menu VALUES ('10', '20052');
INSERT INTO sys_role_menu VALUES ('10', '20053');
INSERT INTO sys_role_menu VALUES ('10', '20054');
INSERT INTO sys_role_menu VALUES ('10', '20055');
INSERT INTO sys_role_menu VALUES ('10', '20056');

INSERT INTO sys_role_menu VALUES ('10', '20060');
INSERT INTO sys_role_menu VALUES ('10', '20061');
INSERT INTO sys_role_menu VALUES ('10', '20062');
INSERT INTO sys_role_menu VALUES ('10', '20063');
INSERT INTO sys_role_menu VALUES ('10', '20064');
INSERT INTO sys_role_menu VALUES ('10', '20065');
INSERT INTO sys_role_menu VALUES ('10', '20066');

INSERT INTO sys_role_menu VALUES ('10', '20070');
INSERT INTO sys_role_menu VALUES ('10', '20071');
INSERT INTO sys_role_menu VALUES ('10', '20072');
INSERT INTO sys_role_menu VALUES ('10', '20073');
INSERT INTO sys_role_menu VALUES ('10', '20074');
INSERT INTO sys_role_menu VALUES ('10', '20075');
INSERT INTO sys_role_menu VALUES ('10', '20076');

INSERT INTO sys_role_menu VALUES ('10', '20080');
INSERT INTO sys_role_menu VALUES ('10', '20081');
INSERT INTO sys_role_menu VALUES ('10', '20082');
INSERT INTO sys_role_menu VALUES ('10', '20083');
INSERT INTO sys_role_menu VALUES ('10', '20084');
INSERT INTO sys_role_menu VALUES ('10', '20085');
INSERT INTO sys_role_menu VALUES ('10', '20086');

INSERT INTO sys_role_menu VALUES ('10', '20090');
INSERT INTO sys_role_menu VALUES ('10', '20091');
INSERT INTO sys_role_menu VALUES ('10', '20092');
INSERT INTO sys_role_menu VALUES ('10', '20093');
INSERT INTO sys_role_menu VALUES ('10', '20094');
INSERT INTO sys_role_menu VALUES ('10', '20095');
INSERT INTO sys_role_menu VALUES ('10', '20096');

INSERT INTO sys_role_menu VALUES ('10', '20100');
INSERT INTO sys_role_menu VALUES ('10', '20101');
INSERT INTO sys_role_menu VALUES ('10', '20102');
INSERT INTO sys_role_menu VALUES ('10', '20103');
INSERT INTO sys_role_menu VALUES ('10', '20104');
INSERT INTO sys_role_menu VALUES ('10', '20105');
INSERT INTO sys_role_menu VALUES ('10', '20106');

INSERT INTO sys_role_menu VALUES ('10', '20110');
INSERT INTO sys_role_menu VALUES ('10', '20111');
INSERT INTO sys_role_menu VALUES ('10', '20112');
INSERT INTO sys_role_menu VALUES ('10', '20113');
INSERT INTO sys_role_menu VALUES ('10', '20114');
INSERT INTO sys_role_menu VALUES ('10', '20115');
INSERT INTO sys_role_menu VALUES ('10', '20116');

INSERT INTO sys_role_menu VALUES ('10', '20120');
INSERT INTO sys_role_menu VALUES ('10', '20121');
INSERT INTO sys_role_menu VALUES ('10', '20122');
INSERT INTO sys_role_menu VALUES ('10', '20123');
INSERT INTO sys_role_menu VALUES ('10', '20124');
INSERT INTO sys_role_menu VALUES ('10', '20125');
INSERT INTO sys_role_menu VALUES ('10', '20126');

INSERT INTO sys_role_menu VALUES ('10', '20130');
INSERT INTO sys_role_menu VALUES ('10', '20131');
INSERT INTO sys_role_menu VALUES ('10', '20132');
INSERT INTO sys_role_menu VALUES ('10', '20133');
INSERT INTO sys_role_menu VALUES ('10', '20134');
INSERT INTO sys_role_menu VALUES ('10', '20135');
INSERT INTO sys_role_menu VALUES ('10', '20136');

INSERT INTO sys_role_menu VALUES ('10', '20140');
INSERT INTO sys_role_menu VALUES ('10', '20141');
INSERT INTO sys_role_menu VALUES ('10', '20142');
INSERT INTO sys_role_menu VALUES ('10', '20143');
INSERT INTO sys_role_menu VALUES ('10', '20144');
INSERT INTO sys_role_menu VALUES ('10', '20145');
INSERT INTO sys_role_menu VALUES ('10', '20146');

INSERT INTO sys_role_menu VALUES ('10', '20150');
INSERT INTO sys_role_menu VALUES ('10', '20151');
INSERT INTO sys_role_menu VALUES ('10', '20152');
INSERT INTO sys_role_menu VALUES ('10', '20153');
INSERT INTO sys_role_menu VALUES ('10', '20154');
INSERT INTO sys_role_menu VALUES ('10', '20155');
INSERT INTO sys_role_menu VALUES ('10', '20156');

INSERT INTO sys_role_menu VALUES ('10', '20160');
INSERT INTO sys_role_menu VALUES ('10', '20161');
INSERT INTO sys_role_menu VALUES ('10', '20162');
INSERT INTO sys_role_menu VALUES ('10', '20163');
INSERT INTO sys_role_menu VALUES ('10', '20164');
INSERT INTO sys_role_menu VALUES ('10', '20165');
INSERT INTO sys_role_menu VALUES ('10', '20166');

INSERT INTO sys_role_menu VALUES ('10', '20170');
INSERT INTO sys_role_menu VALUES ('10', '20171');
INSERT INTO sys_role_menu VALUES ('10', '20172');
INSERT INTO sys_role_menu VALUES ('10', '20173');
INSERT INTO sys_role_menu VALUES ('10', '20174');
INSERT INTO sys_role_menu VALUES ('10', '20175');
INSERT INTO sys_role_menu VALUES ('10', '20176');


-- 为医院管理员角色分配按钮权限

INSERT INTO sys_role_menu VALUES ('11', '20000');

INSERT INTO sys_role_menu VALUES ('11', '20010');
INSERT INTO sys_role_menu VALUES ('11', '20011');
INSERT INTO sys_role_menu VALUES ('11', '20012');
INSERT INTO sys_role_menu VALUES ('11', '20013');
INSERT INTO sys_role_menu VALUES ('11', '20014');
INSERT INTO sys_role_menu VALUES ('11', '20015');
INSERT INTO sys_role_menu VALUES ('11', '20016');

INSERT INTO sys_role_menu VALUES ('11', '20020');
INSERT INTO sys_role_menu VALUES ('11', '20021');
INSERT INTO sys_role_menu VALUES ('11', '20022');
INSERT INTO sys_role_menu VALUES ('11', '20023');
INSERT INTO sys_role_menu VALUES ('11', '20024');
INSERT INTO sys_role_menu VALUES ('11', '20025');
INSERT INTO sys_role_menu VALUES ('11', '20026');

INSERT INTO sys_role_menu VALUES ('11', '20030');
INSERT INTO sys_role_menu VALUES ('11', '20031');
INSERT INTO sys_role_menu VALUES ('11', '20032');
INSERT INTO sys_role_menu VALUES ('11', '20033');
INSERT INTO sys_role_menu VALUES ('11', '20034');
INSERT INTO sys_role_menu VALUES ('11', '20035');
INSERT INTO sys_role_menu VALUES ('11', '20036');

INSERT INTO sys_role_menu VALUES ('11', '20040');
INSERT INTO sys_role_menu VALUES ('11', '20041');
INSERT INTO sys_role_menu VALUES ('11', '20042');
INSERT INTO sys_role_menu VALUES ('11', '20043');
INSERT INTO sys_role_menu VALUES ('11', '20044');
INSERT INTO sys_role_menu VALUES ('11', '20045');
INSERT INTO sys_role_menu VALUES ('11', '20046');

INSERT INTO sys_role_menu VALUES ('11', '20050');
INSERT INTO sys_role_menu VALUES ('11', '20051');
INSERT INTO sys_role_menu VALUES ('11', '20052');
INSERT INTO sys_role_menu VALUES ('11', '20053');
INSERT INTO sys_role_menu VALUES ('11', '20054');
INSERT INTO sys_role_menu VALUES ('11', '20055');
INSERT INTO sys_role_menu VALUES ('11', '20056');

INSERT INTO sys_role_menu VALUES ('11', '20060');
INSERT INTO sys_role_menu VALUES ('11', '20061');
INSERT INTO sys_role_menu VALUES ('11', '20062');
INSERT INTO sys_role_menu VALUES ('11', '20063');
INSERT INTO sys_role_menu VALUES ('11', '20064');
INSERT INTO sys_role_menu VALUES ('11', '20065');
INSERT INTO sys_role_menu VALUES ('11', '20066');

INSERT INTO sys_role_menu VALUES ('11', '20070');
INSERT INTO sys_role_menu VALUES ('11', '20071');
INSERT INTO sys_role_menu VALUES ('11', '20072');
INSERT INTO sys_role_menu VALUES ('11', '20073');
INSERT INTO sys_role_menu VALUES ('11', '20074');
INSERT INTO sys_role_menu VALUES ('11', '20075');
INSERT INTO sys_role_menu VALUES ('11', '20076');

INSERT INTO sys_role_menu VALUES ('11', '20080');
INSERT INTO sys_role_menu VALUES ('11', '20081');
INSERT INTO sys_role_menu VALUES ('11', '20082');
INSERT INTO sys_role_menu VALUES ('11', '20083');
INSERT INTO sys_role_menu VALUES ('11', '20084');
INSERT INTO sys_role_menu VALUES ('11', '20085');
INSERT INTO sys_role_menu VALUES ('11', '20086');

INSERT INTO sys_role_menu VALUES ('11', '20090');
INSERT INTO sys_role_menu VALUES ('11', '20091');
INSERT INTO sys_role_menu VALUES ('11', '20092');
INSERT INTO sys_role_menu VALUES ('11', '20093');
INSERT INTO sys_role_menu VALUES ('11', '20094');
INSERT INTO sys_role_menu VALUES ('11', '20095');
INSERT INTO sys_role_menu VALUES ('11', '20096');

INSERT INTO sys_role_menu VALUES ('11', '20100');
INSERT INTO sys_role_menu VALUES ('11', '20101');
INSERT INTO sys_role_menu VALUES ('11', '20102');
INSERT INTO sys_role_menu VALUES ('11', '20103');
INSERT INTO sys_role_menu VALUES ('11', '20104');
INSERT INTO sys_role_menu VALUES ('11', '20105');
INSERT INTO sys_role_menu VALUES ('11', '20106');

INSERT INTO sys_role_menu VALUES ('11', '20110');
INSERT INTO sys_role_menu VALUES ('11', '20111');
INSERT INTO sys_role_menu VALUES ('11', '20112');
INSERT INTO sys_role_menu VALUES ('11', '20113');
INSERT INTO sys_role_menu VALUES ('11', '20114');
INSERT INTO sys_role_menu VALUES ('11', '20115');
INSERT INTO sys_role_menu VALUES ('11', '20116');

INSERT INTO sys_role_menu VALUES ('11', '20120');
INSERT INTO sys_role_menu VALUES ('11', '20121');
INSERT INTO sys_role_menu VALUES ('11', '20122');
INSERT INTO sys_role_menu VALUES ('11', '20123');
INSERT INTO sys_role_menu VALUES ('11', '20124');
INSERT INTO sys_role_menu VALUES ('11', '20125');
INSERT INTO sys_role_menu VALUES ('11', '20126');

INSERT INTO sys_role_menu VALUES ('11', '20130');
INSERT INTO sys_role_menu VALUES ('11', '20131');
INSERT INTO sys_role_menu VALUES ('11', '20132');
INSERT INTO sys_role_menu VALUES ('11', '20133');
INSERT INTO sys_role_menu VALUES ('11', '20134');
INSERT INTO sys_role_menu VALUES ('11', '20135');
INSERT INTO sys_role_menu VALUES ('11', '20136');

INSERT INTO sys_role_menu VALUES ('11', '20140');
INSERT INTO sys_role_menu VALUES ('11', '20141');
INSERT INTO sys_role_menu VALUES ('11', '20142');
INSERT INTO sys_role_menu VALUES ('11', '20143');
INSERT INTO sys_role_menu VALUES ('11', '20144');
INSERT INTO sys_role_menu VALUES ('11', '20145');
INSERT INTO sys_role_menu VALUES ('11', '20146');

INSERT INTO sys_role_menu VALUES ('11', '20150');
INSERT INTO sys_role_menu VALUES ('11', '20151');
INSERT INTO sys_role_menu VALUES ('11', '20152');
INSERT INTO sys_role_menu VALUES ('11', '20153');
INSERT INTO sys_role_menu VALUES ('11', '20154');
INSERT INTO sys_role_menu VALUES ('11', '20155');
INSERT INTO sys_role_menu VALUES ('11', '20156');

INSERT INTO sys_role_menu VALUES ('11', '20160');
INSERT INTO sys_role_menu VALUES ('11', '20161');
INSERT INTO sys_role_menu VALUES ('11', '20162');
INSERT INTO sys_role_menu VALUES ('11', '20163');
INSERT INTO sys_role_menu VALUES ('11', '20164');
INSERT INTO sys_role_menu VALUES ('11', '20165');
INSERT INTO sys_role_menu VALUES ('11', '20166');

INSERT INTO sys_role_menu VALUES ('11', '20170');
INSERT INTO sys_role_menu VALUES ('11', '20171');
INSERT INTO sys_role_menu VALUES ('11', '20172');
INSERT INTO sys_role_menu VALUES ('11', '20173');
INSERT INTO sys_role_menu VALUES ('11', '20174');
INSERT INTO sys_role_menu VALUES ('11', '20175');
INSERT INTO sys_role_menu VALUES ('11', '20176');

-- 为超级管理员角色分配按钮权限

INSERT INTO sys_role_menu VALUES ('1', '20000');

INSERT INTO sys_role_menu VALUES ('1', '20010');
INSERT INTO sys_role_menu VALUES ('1', '20011');
INSERT INTO sys_role_menu VALUES ('1', '20012');
INSERT INTO sys_role_menu VALUES ('1', '20013');
INSERT INTO sys_role_menu VALUES ('1', '20014');
INSERT INTO sys_role_menu VALUES ('1', '20015');
INSERT INTO sys_role_menu VALUES ('1', '20016');

INSERT INTO sys_role_menu VALUES ('1', '20020');
INSERT INTO sys_role_menu VALUES ('1', '20021');
INSERT INTO sys_role_menu VALUES ('1', '20022');
INSERT INTO sys_role_menu VALUES ('1', '20023');
INSERT INTO sys_role_menu VALUES ('1', '20024');
INSERT INTO sys_role_menu VALUES ('1', '20025');
INSERT INTO sys_role_menu VALUES ('1', '20026');

INSERT INTO sys_role_menu VALUES ('1', '20030');
INSERT INTO sys_role_menu VALUES ('1', '20031');
INSERT INTO sys_role_menu VALUES ('1', '20032');
INSERT INTO sys_role_menu VALUES ('1', '20033');
INSERT INTO sys_role_menu VALUES ('1', '20034');
INSERT INTO sys_role_menu VALUES ('1', '20035');
INSERT INTO sys_role_menu VALUES ('1', '20036');

INSERT INTO sys_role_menu VALUES ('1', '20040');
INSERT INTO sys_role_menu VALUES ('1', '20041');
INSERT INTO sys_role_menu VALUES ('1', '20042');
INSERT INTO sys_role_menu VALUES ('1', '20043');
INSERT INTO sys_role_menu VALUES ('1', '20044');
INSERT INTO sys_role_menu VALUES ('1', '20045');
INSERT INTO sys_role_menu VALUES ('1', '20046');

INSERT INTO sys_role_menu VALUES ('1', '20050');
INSERT INTO sys_role_menu VALUES ('1', '20051');
INSERT INTO sys_role_menu VALUES ('1', '20052');
INSERT INTO sys_role_menu VALUES ('1', '20053');
INSERT INTO sys_role_menu VALUES ('1', '20054');
INSERT INTO sys_role_menu VALUES ('1', '20055');
INSERT INTO sys_role_menu VALUES ('1', '20056');

INSERT INTO sys_role_menu VALUES ('1', '20060');
INSERT INTO sys_role_menu VALUES ('1', '20061');
INSERT INTO sys_role_menu VALUES ('1', '20062');
INSERT INTO sys_role_menu VALUES ('1', '20063');
INSERT INTO sys_role_menu VALUES ('1', '20064');
INSERT INTO sys_role_menu VALUES ('1', '20065');
INSERT INTO sys_role_menu VALUES ('1', '20066');

INSERT INTO sys_role_menu VALUES ('1', '20070');
INSERT INTO sys_role_menu VALUES ('1', '20071');
INSERT INTO sys_role_menu VALUES ('1', '20072');
INSERT INTO sys_role_menu VALUES ('1', '20073');
INSERT INTO sys_role_menu VALUES ('1', '20074');
INSERT INTO sys_role_menu VALUES ('1', '20075');
INSERT INTO sys_role_menu VALUES ('1', '20076');

INSERT INTO sys_role_menu VALUES ('1', '20080');
INSERT INTO sys_role_menu VALUES ('1', '20081');
INSERT INTO sys_role_menu VALUES ('1', '20082');
INSERT INTO sys_role_menu VALUES ('1', '20083');
INSERT INTO sys_role_menu VALUES ('1', '20084');
INSERT INTO sys_role_menu VALUES ('1', '20085');
INSERT INTO sys_role_menu VALUES ('1', '20086');

INSERT INTO sys_role_menu VALUES ('1', '20090');
INSERT INTO sys_role_menu VALUES ('1', '20091');
INSERT INTO sys_role_menu VALUES ('1', '20092');
INSERT INTO sys_role_menu VALUES ('1', '20093');
INSERT INTO sys_role_menu VALUES ('1', '20094');
INSERT INTO sys_role_menu VALUES ('1', '20095');
INSERT INTO sys_role_menu VALUES ('1', '20096');

INSERT INTO sys_role_menu VALUES ('1', '20100');
INSERT INTO sys_role_menu VALUES ('1', '20101');
INSERT INTO sys_role_menu VALUES ('1', '20102');
INSERT INTO sys_role_menu VALUES ('1', '20103');
INSERT INTO sys_role_menu VALUES ('1', '20104');
INSERT INTO sys_role_menu VALUES ('1', '20105');
INSERT INTO sys_role_menu VALUES ('1', '20106');

INSERT INTO sys_role_menu VALUES ('1', '20110');
INSERT INTO sys_role_menu VALUES ('1', '20111');
INSERT INTO sys_role_menu VALUES ('1', '20112');
INSERT INTO sys_role_menu VALUES ('1', '20113');
INSERT INTO sys_role_menu VALUES ('1', '20114');
INSERT INTO sys_role_menu VALUES ('1', '20115');
INSERT INTO sys_role_menu VALUES ('1', '20116');

INSERT INTO sys_role_menu VALUES ('1', '20120');
INSERT INTO sys_role_menu VALUES ('1', '20121');
INSERT INTO sys_role_menu VALUES ('1', '20122');
INSERT INTO sys_role_menu VALUES ('1', '20123');
INSERT INTO sys_role_menu VALUES ('1', '20124');
INSERT INTO sys_role_menu VALUES ('1', '20125');
INSERT INTO sys_role_menu VALUES ('1', '20126');

INSERT INTO sys_role_menu VALUES ('1', '20130');
INSERT INTO sys_role_menu VALUES ('1', '20131');
INSERT INTO sys_role_menu VALUES ('1', '20132');
INSERT INTO sys_role_menu VALUES ('1', '20133');
INSERT INTO sys_role_menu VALUES ('1', '20134');
INSERT INTO sys_role_menu VALUES ('1', '20135');
INSERT INTO sys_role_menu VALUES ('1', '20136');

INSERT INTO sys_role_menu VALUES ('1', '20140');
INSERT INTO sys_role_menu VALUES ('1', '20141');
INSERT INTO sys_role_menu VALUES ('1', '20142');
INSERT INTO sys_role_menu VALUES ('1', '20143');
INSERT INTO sys_role_menu VALUES ('1', '20144');
INSERT INTO sys_role_menu VALUES ('1', '20145');
INSERT INTO sys_role_menu VALUES ('1', '20146');

INSERT INTO sys_role_menu VALUES ('1', '20150');
INSERT INTO sys_role_menu VALUES ('1', '20151');
INSERT INTO sys_role_menu VALUES ('1', '20152');
INSERT INTO sys_role_menu VALUES ('1', '20153');
INSERT INTO sys_role_menu VALUES ('1', '20154');
INSERT INTO sys_role_menu VALUES ('1', '20155');
INSERT INTO sys_role_menu VALUES ('1', '20156');

INSERT INTO sys_role_menu VALUES ('1', '20160');
INSERT INTO sys_role_menu VALUES ('1', '20161');
INSERT INTO sys_role_menu VALUES ('1', '20162');
INSERT INTO sys_role_menu VALUES ('1', '20163');
INSERT INTO sys_role_menu VALUES ('1', '20164');
INSERT INTO sys_role_menu VALUES ('1', '20165');
INSERT INTO sys_role_menu VALUES ('1', '20166');

INSERT INTO sys_role_menu VALUES ('1', '20170');
INSERT INTO sys_role_menu VALUES ('1', '20171');
INSERT INTO sys_role_menu VALUES ('1', '20172');
INSERT INTO sys_role_menu VALUES ('1', '20173');
INSERT INTO sys_role_menu VALUES ('1', '20174');
INSERT INTO sys_role_menu VALUES ('1', '20175');
INSERT INTO sys_role_menu VALUES ('1', '20176');