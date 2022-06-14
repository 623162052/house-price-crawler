-- 废弃

CREATE TABLE `t_price_info` (
  `serial_id` int NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `execute_date` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '执行日期',
  `price_type` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地区编码',
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地区名称',
  `latitude` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '纬度',
  `longitude` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '经度',
  `full_spell` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地区',
  `count` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '数量',
  `count_str` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '展示数量',
  `count_unit` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '数量单位',
  `entity_id` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `entity_type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `icon` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图标',
  `image_type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '图片类型',
  `price` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '价格',
  `price_str` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '展示价格',
  `price_unit` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '价格单位',
  `descx` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '展示价格',
  `selected` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `border` varchar(8192) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '边界',
  `bubble_desc` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '边界描述',
  PRIMARY KEY (`serial_id`),
  UNIQUE KEY `IDX_DATE_TYPE_ID` (`execute_date`,`price_type`,`id`) COMMENT '执行日期、价格类型、区域编码组合唯一约束，避免重复数据'
) ENGINE=InnoDB AUTO_INCREMENT=458 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
