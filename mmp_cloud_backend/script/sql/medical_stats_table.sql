-- ----------------------------
-- 医疗质量统计数据表
-- 生成时间：2026-01-14
-- 适用于北京积水潭医院医务管理平台
-- ----------------------------

DROP TABLE IF EXISTS `mmp_medical_stats`;
CREATE TABLE `mmp_medical_stats` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '科室ID',
  `dept_name` varchar(100) DEFAULT NULL COMMENT '科室名称',
  `stat_date` date DEFAULT NULL COMMENT '统计日期',
  `new_admissions` bigint(20) DEFAULT '0' COMMENT '新入院患者数',
  `in_ward` bigint(20) DEFAULT '0' COMMENT '在院患者数',
  `critical` bigint(20) DEFAULT '0' COMMENT '危重患者数',
  `discharged` bigint(20) DEFAULT '0' COMMENT '出院患者数',
  `deaths` bigint(20) DEFAULT '0' COMMENT '死亡患者数',
  `transfers_in` bigint(20) DEFAULT '0' COMMENT '转入患者数',
  `transfers_out` bigint(20) DEFAULT '0' COMMENT '转出患者数',
  `attention_patients` bigint(20) DEFAULT '0' COMMENT '关注患者数',
  `rescues` bigint(20) DEFAULT '0' COMMENT '抢救次数',
  `critical_values` bigint(20) DEFAULT '0' COMMENT '危急值次数',
  `critically_ill` bigint(20) DEFAULT '0' COMMENT '病危患者数',
  `seriously_ill` bigint(20) DEFAULT '0' COMMENT '病重患者数',
  `consultations` bigint(20) DEFAULT '0' COMMENT '会诊次数',
  `long_stay_patients` bigint(20) DEFAULT '0' COMMENT '住院超30天患者数',
  `level3_surgeries` bigint(20) DEFAULT '0' COMMENT '三级手术次数',
  `level4_surgeries` bigint(20) DEFAULT '0' COMMENT '四级手术次数',
  `secondary_surgeries` bigint(20) DEFAULT '0' COMMENT '二次手术次数',
  `blood_transfusions` bigint(20) DEFAULT '0' COMMENT '输血次数',
  `pathway_entries` bigint(20) DEFAULT '0' COMMENT '入径患者数',
  `antibiotic_usage` bigint(20) DEFAULT '0' COMMENT '抗菌药物使用次数',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_dept` bigint(20) DEFAULT NULL COMMENT '创建部门',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_dept_id` (`dept_id`) USING BTREE,
  KEY `idx_stat_date` (`stat_date`) USING BTREE,
  KEY `idx_dept_date` (`dept_id`,`stat_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医疗质量统计数据表';

-- ----------------------------
-- 初始化一些示例数据
-- ----------------------------
INSERT INTO `mmp_medical_stats` VALUES
(1, 101, '骨科', '2024-01-14', 12, 156, 8, 18, 2, 5, 3, 12, 6, 4, 8, 15, 23, 8, 45, 12, 3, 18, 67, 156, '骨科今日统计数据', 1, 1, '2024-01-14 08:00:00', 1, '2024-01-14 18:00:00'),
(2, 102, '外科', '2024-01-14', 18, 189, 12, 22, 1, 8, 6, 18, 9, 7, 12, 22, 31, 12, 67, 18, 5, 25, 89, 189, '外科今日统计数据', 1, 1, '2024-01-14 08:00:00', 1, '2024-01-14 18:00:00'),
(3, 103, '内科', '2024-01-14', 25, 234, 15, 28, 3, 12, 9, 25, 12, 9, 15, 28, 42, 18, 89, 25, 7, 32, 112, 234, '内科今日统计数据', 1, 1, '2024-01-14 08:00:00', 1, '2024-01-14 18:00:00');