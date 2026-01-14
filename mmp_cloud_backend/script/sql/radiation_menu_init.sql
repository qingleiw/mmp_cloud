-- ----------------------------
-- 放射管理完整菜单SQL脚本
-- 生成时间：2026-01-14
-- 包含13个子模块
-- ----------------------------

-- 清理旧数据
DELETE FROM sys_role_menu WHERE menu_id >= 23000 AND menu_id < 23500;
DELETE FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- ----------------------------
-- 1. 创建放射管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('23000', '放射管理', '0', '100', 'radiation', NULL, '', 1, 0, 'M', '0', '0', '', 'radiation', 100, 1, sysdate(), NULL, NULL, '放射管理目录');

-- ----------------------------
-- 2. 创建子菜单(13个模块)
-- ----------------------------
INSERT INTO sys_menu VALUES ('23010', '辐射剂量警报', '23000', '10', 'radiationDoseAlert', 'radiation/radiationDoseAlert/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationDoseAlert:list', 'exclamation-triangle', 100, 1, sysdate(), NULL, NULL, '辐射剂量警报');
INSERT INTO sys_menu VALUES ('23020', '剂量警报记录', '23000', '20', 'radiationDoseAlertRecord', 'radiation/radiationDoseAlertRecord/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationDoseAlertRecord:list', 'file-alt', 100, 1, sysdate(), NULL, NULL, '剂量警报记录');
INSERT INTO sys_menu VALUES ('23030', '辐射剂量监测', '23000', '30', 'radiationDoseMonitoring', 'radiation/radiationDoseMonitoring/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationDoseMonitoring:list', 'chart-line', 100, 1, sysdate(), NULL, NULL, '辐射剂量监测');
INSERT INTO sys_menu VALUES ('23040', '辐射剂量记录', '23000', '40', 'radiationDoseRecord', 'radiation/radiationDoseRecord/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationDoseRecord:list', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '辐射剂量记录');
INSERT INTO sys_menu VALUES ('23050', '辐射设备检查', '23000', '50', 'radiationEquipmentInspection', 'radiation/radiationEquipmentInspection/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationEquipmentInspection:list', 'cogs', 100, 1, sysdate(), NULL, NULL, '辐射设备检查');
INSERT INTO sys_menu VALUES ('23060', '辐射健康检查', '23000', '60', 'radiationHealthExam', 'radiation/radiationHealthExam/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationHealthExam:list', 'heartbeat', 100, 1, sysdate(), NULL, NULL, '辐射健康检查');
INSERT INTO sys_menu VALUES ('23070', '健康检查计划', '23000', '70', 'radiationHealthExamPlan', 'radiation/radiationHealthExamPlan/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationHealthExamPlan:list', 'calendar-check', 100, 1, sysdate(), NULL, NULL, '健康检查计划');
INSERT INTO sys_menu VALUES ('23080', '健康检查结果', '23000', '80', 'radiationHealthExamResult', 'radiation/radiationHealthExamResult/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationHealthExamResult:list', 'file-medical', 100, 1, sysdate(), NULL, NULL, '健康检查结果');
INSERT INTO sys_menu VALUES ('23090', '放射人员', '23000', '90', 'radiationStaff', 'radiation/radiationStaff/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationStaff:list', 'users', 100, 1, sysdate(), NULL, NULL, '放射人员');
INSERT INTO sys_menu VALUES ('23100', '放射培训', '23000', '100', 'radiationTraining', 'radiation/radiationTraining/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationTraining:list', 'chalkboard-teacher', 100, 1, sysdate(), NULL, NULL, '放射培训');
INSERT INTO sys_menu VALUES ('23110', '培训参与者', '23000', '110', 'radiationTrainingParticipant', 'radiation/radiationTrainingParticipant/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationTrainingParticipant:list', 'user-check', 100, 1, sysdate(), NULL, NULL, '培训参与者');
INSERT INTO sys_menu VALUES ('23120', '培训计划', '23000', '120', 'radiationTrainingPlan', 'radiation/radiationTrainingPlan/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationTrainingPlan:list', 'calendar-alt', 100, 1, sysdate(), NULL, NULL, '培训计划');
INSERT INTO sys_menu VALUES ('23130', '放射工作人员', '23000', '130', 'radiationWorker', 'radiation/radiationWorker/index', '', 1, 0, 'C', '0', '0', 'radiation:radiationWorker:list', 'user-md', 100, 1, sysdate(), NULL, NULL, '放射工作人员');

-- 以下为各模块按钮权限，为节省篇幅，仅展示格式
-- 实际使用时需补充所有13个模块的按钮（每个模块6个按钮，共78个按钮）

-- 示例：辐射剂量警报按钮（23011-23016）
INSERT INTO sys_menu VALUES ('23011', '辐射剂量警报查询', '23010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23012', '辐射剂量警报新增', '23010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23013', '辐射剂量警报修改', '23010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23014', '辐射剂量警报删除', '23010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23015', '辐射剂量警报导入', '23010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23016', '辐射剂量警报导出', '23010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlert:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 剂量警报记录按钮（23021-23026）
INSERT INTO sys_menu VALUES ('23021', '剂量警报记录查询', '23020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlertRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23022', '剂量警报记录新增', '23020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlertRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23023', '剂量警报记录修改', '23020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlertRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23024', '剂量警报记录删除', '23020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlertRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23025', '剂量警报记录导入', '23020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlertRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23026', '剂量警报记录导出', '23020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseAlertRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射剂量监测按钮（23031-23036）
INSERT INTO sys_menu VALUES ('23031', '辐射剂量监测查询', '23030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23032', '辐射剂量监测新增', '23030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23033', '辐射剂量监测修改', '23030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23034', '辐射剂量监测删除', '23030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23035', '辐射剂量监测导入', '23030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23036', '辐射剂量监测导出', '23030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseMonitoring:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射剂量记录按钮（23041-23046）
INSERT INTO sys_menu VALUES ('23041', '辐射剂量记录查询', '23040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseRecord:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23042', '辐射剂量记录新增', '23040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseRecord:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23043', '辐射剂量记录修改', '23040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseRecord:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23044', '辐射剂量记录删除', '23040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseRecord:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23045', '辐射剂量记录导入', '23040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseRecord:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23046', '辐射剂量记录导出', '23040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationDoseRecord:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射设备检查按钮（23051-23056）
INSERT INTO sys_menu VALUES ('23051', '辐射设备检查查询', '23050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentInspection:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23052', '辐射设备检查新增', '23050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentInspection:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23053', '辐射设备检查修改', '23050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentInspection:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23054', '辐射设备检查删除', '23050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentInspection:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23055', '辐射设备检查导入', '23050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentInspection:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23056', '辐射设备检查导出', '23050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationEquipmentInspection:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 辐射健康检查按钮（23061-23066）
INSERT INTO sys_menu VALUES ('23061', '辐射健康检查查询', '23060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExam:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23062', '辐射健康检查新增', '23060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExam:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23063', '辐射健康检查修改', '23060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExam:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23064', '辐射健康检查删除', '23060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExam:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23065', '辐射健康检查导入', '23060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExam:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23066', '辐射健康检查导出', '23060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExam:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 健康检查计划按钮（23071-23076）
INSERT INTO sys_menu VALUES ('23071', '健康检查计划查询', '23070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23072', '健康检查计划新增', '23070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23073', '健康检查计划修改', '23070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23074', '健康检查计划删除', '23070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23075', '健康检查计划导入', '23070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23076', '健康检查计划导出', '23070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 健康检查结果按钮（23081-23086）
INSERT INTO sys_menu VALUES ('23081', '健康检查结果查询', '23080', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamResult:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23082', '健康检查结果新增', '23080', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamResult:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23083', '健康检查结果修改', '23080', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamResult:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23084', '健康检查结果删除', '23080', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamResult:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23085', '健康检查结果导入', '23080', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamResult:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23086', '健康检查结果导出', '23080', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationHealthExamResult:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 放射人员按钮（23091-23096）
INSERT INTO sys_menu VALUES ('23091', '放射人员查询', '23090', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationStaff:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23092', '放射人员新增', '23090', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationStaff:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23093', '放射人员修改', '23090', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationStaff:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23094', '放射人员删除', '23090', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationStaff:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23095', '放射人员导入', '23090', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationStaff:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23096', '放射人员导出', '23090', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationStaff:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 放射培训按钮（23101-23106）
INSERT INTO sys_menu VALUES ('23101', '放射培训查询', '23100', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTraining:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23102', '放射培训新增', '23100', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTraining:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23103', '放射培训修改', '23100', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTraining:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23104', '放射培训删除', '23100', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTraining:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23105', '放射培训导入', '23100', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTraining:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23106', '放射培训导出', '23100', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTraining:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 培训参与者按钮（23111-23116）
INSERT INTO sys_menu VALUES ('23111', '培训参与者查询', '23110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingParticipant:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23112', '培训参与者新增', '23110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingParticipant:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23113', '培训参与者修改', '23110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingParticipant:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23114', '培训参与者删除', '23110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingParticipant:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23115', '培训参与者导入', '23110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingParticipant:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23116', '培训参与者导出', '23110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingParticipant:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 培训计划按钮（23121-23126）
INSERT INTO sys_menu VALUES ('23121', '培训计划查询', '23120', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23122', '培训计划新增', '23120', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23123', '培训计划修改', '23120', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23124', '培训计划删除', '23120', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23125', '培训计划导入', '23120', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23126', '培训计划导出', '23120', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationTrainingPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 放射工作人员按钮 + 角色权限分配
-- ----------------------------

-- 放射工作人员按钮（23131-23136）
INSERT INTO sys_menu VALUES ('23131', '放射工作人员查询', '23130', '1', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationWorker:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23132', '放射工作人员新增', '23130', '2', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationWorker:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23133', '放射工作人员修改', '23130', '3', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationWorker:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23134', '放射工作人员删除', '23130', '4', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationWorker:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23135', '放射工作人员导入', '23130', '5', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationWorker:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('23136', '放射工作人员导出', '23130', '6', '#', '', '', 1, 0, 'F', '0', '0', 'radiation:radiationWorker:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- ----------------------------
-- 4. 定义角色权限分配
-- ----------------------------

-- 为护士角色(Role ID: 5)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '5', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- 为医生角色(Role ID: 6)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '6', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- 为科室主任角色(Role ID: 7)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '7', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- 为质控员角色(Role ID: 8)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '8', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- 为医务部角色(Role ID: 9)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '9', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- 为医务部主任角色(Role ID: 10)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '10', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- 为医院管理员角色(Role ID: 11)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '11', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

-- 为超级管理员角色(Role ID: 1)分配所有菜单权限
INSERT INTO sys_role_menu SELECT '1', menu_id FROM sys_menu WHERE menu_id >= 23000 AND menu_id < 23500;

COMMIT;