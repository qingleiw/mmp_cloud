-- ----------------------------
-- 应急管理菜单SQL脚本
-- 生成时间：2026-01-11
-- ----------------------------

-- ----------------------------
-- 1. 创建应急管理主菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('21000', '应急管理', '0', '100', 'emergency', NULL, '', 1, 0, 'M', '0', '0', '', 'ambulance', 100, 1, sysdate(), NULL, NULL, '应急管理目录');

-- ----------------------------
-- 2. 创建子菜单
-- ----------------------------
INSERT INTO sys_menu VALUES ('21010', '应急演练计划', '21000', '10', 'emergencyDrillPlan', 'emergency/emergencyDrillPlan/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyDrillPlan:list', 'clipboard-list', 100, 1, sysdate(), NULL, NULL, '应急演练计划');
INSERT INTO sys_menu VALUES ('21020', '应急演练总结', '21000', '20', 'emergencyDrillSummary', 'emergency/emergencyDrillSummary/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyDrillSummary:list', 'file-alt', 100, 1, sysdate(), NULL, NULL, '应急演练总结');
INSERT INTO sys_menu VALUES ('21030', '应急事件', '21000', '30', 'emergencyEvent', 'emergency/emergencyEvent/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyEvent:list', 'exclamation-triangle', 100, 1, sysdate(), NULL, NULL, '应急事件');
INSERT INTO sys_menu VALUES ('21040', '应急事件响应', '21000', '40', 'emergencyEventResponse', 'emergency/emergencyEventResponse/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyEventResponse:list', 'reply', 100, 1, sysdate(), NULL, NULL, '应急事件响应');
INSERT INTO sys_menu VALUES ('21050', '应急事件处理', '21000', '50', 'emergencyEventTreatment', 'emergency/emergencyEventTreatment/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyEventTreatment:list', 'wrench', 100, 1, sysdate(), NULL, NULL, '应急事件处理');
INSERT INTO sys_menu VALUES ('21060', '应急事件', '21000', '60', 'emergencyIncident', 'emergency/emergencyIncident/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyIncident:list', 'bolt', 100, 1, sysdate(), NULL, NULL, '应急事件');
INSERT INTO sys_menu VALUES ('21070', '应急医疗支持', '21000', '70', 'emergencyMedicalSupport', 'emergency/emergencyMedicalSupport/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyMedicalSupport:list', 'medkit', 100, 1, sysdate(), NULL, NULL, '应急医疗支持');
INSERT INTO sys_menu VALUES ('21080', '应急预案', '21000', '80', 'emergencyPlan', 'emergency/emergencyPlan/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyPlan:list', 'shield-alt', 100, 1, sysdate(), NULL, NULL, '应急预案');
INSERT INTO sys_menu VALUES ('21090', '应急预案审批', '21000', '90', 'emergencyPlanApproval', 'emergency/emergencyPlanApproval/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyPlanApproval:list', 'check-circle', 100, 1, sysdate(), NULL, NULL, '应急预案审批');
INSERT INTO sys_menu VALUES ('21100', '应急队伍', '21000', '100', 'emergencyTeam', 'emergency/emergencyTeam/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyTeam:list', 'users', 100, 1, sysdate(), NULL, NULL, '应急队伍');
INSERT INTO sys_menu VALUES ('21110', '应急队伍成员', '21000', '110', 'emergencyTeamMember', 'emergency/emergencyTeamMember/index', '', 1, 0, 'C', '0', '0', 'emergency:emergencyTeamMember:list', 'user-friends', 100, 1, sysdate(), NULL, NULL, '应急队伍成员');
INSERT INTO sys_menu VALUES ('21120', '重要医疗事件', '21000', '120', 'importantMedicalEvent', 'emergency/importantMedicalEvent/index', '', 1, 0, 'C', '0', '0', 'emergency:importantMedicalEvent:list', 'exclamation-circle', 100, 1, sysdate(), NULL, NULL, '重要医疗事件');

-- ----------------------------
-- 3. 定义按钮权限
-- ----------------------------
-- 应急演练计划按钮
INSERT INTO sys_menu VALUES ('21011', '应急演练计划查询', '21010', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21012', '应急演练计划新增', '21010', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21013', '应急演练计划修改', '21010', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21014', '应急演练计划删除', '21010', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21015', '应急演练计划导入', '21010', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21016', '应急演练计划导出', '21010', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急演练总结按钮
INSERT INTO sys_menu VALUES ('21021', '应急演练总结查询', '21020', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillSummary:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21022', '应急演练总结新增', '21020', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillSummary:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21023', '应急演练总结修改', '21020', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillSummary:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21024', '应急演练总结删除', '21020', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillSummary:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21025', '应急演练总结导入', '21020', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillSummary:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21026', '应急演练总结导出', '21020', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyDrillSummary:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急事件按钮
INSERT INTO sys_menu VALUES ('21031', '应急事件查询', '21030', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEvent:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21032', '应急事件新增', '21030', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEvent:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21033', '应急事件修改', '21030', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEvent:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21034', '应急事件删除', '21030', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEvent:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21035', '应急事件导入', '21030', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEvent:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21036', '应急事件导出', '21030', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEvent:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急事件响应按钮
INSERT INTO sys_menu VALUES ('21041', '应急事件响应查询', '21040', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventResponse:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21042', '应急事件响应新增', '21040', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventResponse:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21043', '应急事件响应修改', '21040', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventResponse:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21044', '应急事件响应删除', '21040', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventResponse:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21045', '应急事件响应导入', '21040', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventResponse:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21046', '应急事件响应导出', '21040', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventResponse:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急事件处理按钮
INSERT INTO sys_menu VALUES ('21051', '应急事件处理查询', '21050', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventTreatment:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21052', '应急事件处理新增', '21050', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventTreatment:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21053', '应急事件处理修改', '21050', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventTreatment:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21054', '应急事件处理删除', '21050', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventTreatment:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21055', '应急事件处理导入', '21050', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventTreatment:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21056', '应急事件处理导出', '21050', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyEventTreatment:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急事件按钮 (第二个)
INSERT INTO sys_menu VALUES ('21061', '应急事件查询', '21060', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyIncident:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21062', '应急事件新增', '21060', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyIncident:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21063', '应急事件修改', '21060', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyIncident:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21064', '应急事件删除', '21060', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyIncident:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21065', '应急事件导入', '21060', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyIncident:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21066', '应急事件导出', '21060', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyIncident:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急医疗支持按钮
INSERT INTO sys_menu VALUES ('21071', '应急医疗支持查询', '21070', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyMedicalSupport:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21072', '应急医疗支持新增', '21070', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyMedicalSupport:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21073', '应急医疗支持修改', '21070', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyMedicalSupport:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21074', '应急医疗支持删除', '21070', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyMedicalSupport:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21075', '应急医疗支持导入', '21070', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyMedicalSupport:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21076', '应急医疗支持导出', '21070', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyMedicalSupport:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急预案按钮
INSERT INTO sys_menu VALUES ('21081', '应急预案查询', '21080', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlan:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21082', '应急预案新增', '21080', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlan:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21083', '应急预案修改', '21080', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlan:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21084', '应急预案删除', '21080', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlan:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21085', '应急预案导入', '21080', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlan:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21086', '应急预案导出', '21080', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlan:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急预案审批按钮
INSERT INTO sys_menu VALUES ('21091', '应急预案审批查询', '21090', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlanApproval:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21092', '应急预案审批新增', '21090', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlanApproval:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21093', '应急预案审批修改', '21090', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlanApproval:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21094', '应急预案审批删除', '21090', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlanApproval:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21095', '应急预案审批导入', '21090', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlanApproval:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21096', '应急预案审批导出', '21090', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyPlanApproval:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急队伍按钮
INSERT INTO sys_menu VALUES ('21101', '应急队伍查询', '21100', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeam:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21102', '应急队伍新增', '21100', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeam:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21103', '应急队伍修改', '21100', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeam:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21104', '应急队伍删除', '21100', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeam:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21105', '应急队伍导入', '21100', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeam:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21106', '应急队伍导出', '21100', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeam:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 应急队伍成员按钮
INSERT INTO sys_menu VALUES ('21111', '应急队伍成员查询', '21110', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeamMember:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21112', '应急队伍成员新增', '21110', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeamMember:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21113', '应急队伍成员修改', '21110', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeamMember:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21114', '应急队伍成员删除', '21110', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeamMember:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21115', '应急队伍成员导入', '21110', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeamMember:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21116', '应急队伍成员导出', '21110', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:emergencyTeamMember:export', '#', 100, 1, sysdate(), NULL, NULL, '');

-- 重要医疗事件按钮
INSERT INTO sys_menu VALUES ('21121', '重要医疗事件查询', '21120', '1', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:importantMedicalEvent:query', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21122', '重要医疗事件新增', '21120', '2', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:importantMedicalEvent:add', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21123', '重要医疗事件修改', '21120', '3', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:importantMedicalEvent:edit', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21124', '重要医疗事件删除', '21120', '4', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:importantMedicalEvent:remove', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21125', '重要医疗事件导入', '21120', '5', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:importantMedicalEvent:import', '#', 100, 1, sysdate(), NULL, NULL, '');
INSERT INTO sys_menu VALUES ('21126', '重要医疗事件导出', '21120', '6', '#', '', '', 1, 0, 'F', '0', '0', 'emergency:importantMedicalEvent:export', '#', 100, 1, sysdate(), NULL, NULL, '');