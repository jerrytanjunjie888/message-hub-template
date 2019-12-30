/*
Navicat PGSQL Data Transfer

Source Server         : message_hub_develop_template
Source Server Version : 90400
Source Host           : localhost:5000
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90400
File Encoding         : 65001

Date: 2019-07-10 16:31:24
*/

-- ----------------------------
-- Table structure for tbl_event_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_event_type";
CREATE TABLE "public"."tbl_event_type" (
"id" SERIAL  primary key,
"uuid" varchar(50) COLLATE "default",
"event_source" varchar(30) COLLATE "default",
"event_name" varchar(30) COLLATE "default",
"event_param" varchar(255) COLLATE "default",
"system_id" varchar(30) COLLATE "default",
"event_remark" varchar(255) COLLATE "default",
"enable_status" int2,
"notify_url" varchar(30) COLLATE "default",
"gmt_created" timestamp(6),
"creator" varchar(30) COLLATE "default",
"gmt_modified" timestamp(6),
"modifier" varchar(30) COLLATE "default",
"is_deleted" int2
)

WITH (OIDS=FALSE)

;
CREATE INDEX index_event_type_uuid on tbl_event_type(uuid);

COMMENT ON COLUMN "public"."tbl_event_type"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_event_type"."uuid" IS '业务编号';
COMMENT ON COLUMN "public"."tbl_event_type"."event_source" IS '事件来源';
COMMENT ON COLUMN "public"."tbl_event_type"."event_name" IS '事件名称';
COMMENT ON COLUMN "public"."tbl_event_type"."event_param" IS '事件参数  如 sequenceId contactId contactName mobile openId email';
COMMENT ON COLUMN "public"."tbl_event_type"."system_id" IS '迪卡侬上游系统ID';
COMMENT ON COLUMN "public"."tbl_event_type"."event_remark" IS '事件备注';
COMMENT ON COLUMN "public"."tbl_event_type"."enable_status" IS '启用状态 1 启用 2 未启用 ';
COMMENT ON COLUMN "public"."tbl_event_type"."notify_url" IS '消息结果回调地址';
COMMENT ON COLUMN "public"."tbl_event_type"."gmt_created" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_event_type"."creator" IS '创建人';
COMMENT ON COLUMN "public"."tbl_event_type"."gmt_modified" IS '修改时间';
COMMENT ON COLUMN "public"."tbl_event_type"."modifier" IS '修改人';
COMMENT ON COLUMN "public"."tbl_event_type"."is_deleted" IS '是否有效 1 有效 2 无效';

-- ----------------------------
-- Records of tbl_event_type
-- ----------------------------
INSERT INTO "public"."tbl_event_type" VALUES ('4', 'Event-8547533ca7054ebda513f99541e5ecf9', null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for tbl_template_email
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_template_email";
CREATE TABLE "public"."tbl_template_email" (
"id" SERIAL  primary key,
"uuid" varchar(50) COLLATE "default",
"event_type_uuid" varchar(50) COLLATE "default",
"edm_channel" varchar(30) COLLATE "default",
"template_subject" varchar(30) COLLATE "default",
"template_content" varchar(255) COLLATE "default",
"template_country_code" varchar(10) COLLATE "default",
"template_language_code" varchar(10) COLLATE "default",
"communication_channel" varchar(10) COLLATE "default",
"template_attributes" varchar(255) COLLATE "default",
"document_name" varchar(30) COLLATE "default",
"document_url" varchar(255) COLLATE "default",
"start_effective_time" timestamp(6),
"last_effective_time" timestamp(6),
"gmt_created" timestamp(6),
"creator" varchar(30) COLLATE "default",
"gmt_modified" timestamp(6),
"modifier" varchar(30) COLLATE "default",
"is_deleted" int2
)
WITH (OIDS=FALSE)

;
CREATE INDEX index_template_email_uuid on tbl_template_email(uuid);
CREATE INDEX index_template_email_event_type_uuid on tbl_template_email(event_type_uuid);

COMMENT ON COLUMN "public"."tbl_template_email"."id" IS '主键id';
COMMENT ON COLUMN "public"."tbl_template_email"."uuid" IS '微信模板编号';
COMMENT ON COLUMN "public"."tbl_template_email"."event_type_uuid" IS '事件类型';
COMMENT ON COLUMN "public"."tbl_template_email"."edm_channel" IS 'EDM通道';
COMMENT ON COLUMN "public"."tbl_template_email"."template_subject" IS 'Email模板主题';
COMMENT ON COLUMN "public"."tbl_template_email"."template_content" IS '邮件模板内容';
COMMENT ON COLUMN "public"."tbl_template_email"."template_country_code" IS '所属国家';
COMMENT ON COLUMN "public"."tbl_template_email"."template_language_code" IS '模板语言';
COMMENT ON COLUMN "public"."tbl_template_email"."communication_channel" IS '传输方式';
COMMENT ON COLUMN "public"."tbl_template_email"."template_attributes" IS '模板参数';
COMMENT ON COLUMN "public"."tbl_template_email"."document_name" IS 'emai文件名称';
COMMENT ON COLUMN "public"."tbl_template_email"."document_url" IS '邮件地址';
COMMENT ON COLUMN "public"."tbl_template_email"."start_effective_time" IS '邮件开始有效时间';
COMMENT ON COLUMN "public"."tbl_template_email"."last_effective_time" IS '邮件失效时间';
COMMENT ON COLUMN "public"."tbl_template_email"."gmt_created" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_template_email"."creator" IS '创建人';
COMMENT ON COLUMN "public"."tbl_template_email"."gmt_modified" IS '修改时间';
COMMENT ON COLUMN "public"."tbl_template_email"."modifier" IS '修改人';
COMMENT ON COLUMN "public"."tbl_template_email"."is_deleted" IS '是否有效 1 有效 2 无效';

-- ----------------------------
-- Records of tbl_template_email
-- ----------------------------
INSERT INTO "public"."tbl_template_email" VALUES ('3', 'template-email-c99c856840a54f318a626b2b62e60a9e', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for tbl_template_sms
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_template_sms";
CREATE TABLE "public"."tbl_template_sms" (
"id" SERIAL  primary key,
"uuid" varchar(50) COLLATE "default",
"event_type_uuid" varchar(50) COLLATE "default",
"template_channel" varchar(30) COLLATE "default",
"template_content" varchar(255) COLLATE "default",
"template_country_code" varchar(10) COLLATE "default",
"template_language_code" varchar(10) COLLATE "default",
"communication_channel" varchar(10) COLLATE "default",
"template_attributes" varchar(255) COLLATE "default",
"start_effective_time" timestamp(6),
"last_effective_time" timestamp(6),
"gmt_created" timestamp(6),
"creator" varchar(30) COLLATE "default",
"gmt_modified" timestamp(6),
"modifier" varchar(30) COLLATE "default",
"is_deleted" int2
)
WITH (OIDS=FALSE)

;
CREATE INDEX index_template_sms_uuid on tbl_template_sms(uuid);
CREATE INDEX index_template_sms_event_type_uuid on tbl_template_sms(event_type_uuid);

COMMENT ON COLUMN "public"."tbl_template_sms"."id" IS '主键id';
COMMENT ON COLUMN "public"."tbl_template_sms"."uuid" IS '短信模板编号';
COMMENT ON COLUMN "public"."tbl_template_sms"."event_type_uuid" IS '事件类型id';
COMMENT ON COLUMN "public"."tbl_template_sms"."template_channel" IS '短信通道';
COMMENT ON COLUMN "public"."tbl_template_sms"."template_content" IS '短信模板内容';
COMMENT ON COLUMN "public"."tbl_template_email"."template_country_code" IS '所属国家';
COMMENT ON COLUMN "public"."tbl_template_email"."template_language_code" IS '模板语言';
COMMENT ON COLUMN "public"."tbl_template_email"."communication_channel" IS '传输方式';
COMMENT ON COLUMN "public"."tbl_template_email"."template_attributes" IS '模板参数';
COMMENT ON COLUMN "public"."tbl_template_sms"."start_effective_time" IS '有效时间';
COMMENT ON COLUMN "public"."tbl_template_sms"."last_effective_time" IS '失效时间';
COMMENT ON COLUMN "public"."tbl_template_sms"."gmt_created" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_template_sms"."creator" IS '创建人';
COMMENT ON COLUMN "public"."tbl_template_sms"."gmt_modified" IS '修改时间';
COMMENT ON COLUMN "public"."tbl_template_sms"."modifier" IS '修改人';
COMMENT ON COLUMN "public"."tbl_template_sms"."is_deleted" IS '是否有效 1 有效 2 无效';

-- ----------------------------
-- Records of tbl_template_sms
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_template_wechat
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_template_wechat";
CREATE TABLE "public"."tbl_template_wechat" (
"id" SERIAL  primary key,
"uuid" varchar(50) COLLATE "default",
"event_type_uuid" varchar(50) COLLATE "default",
"official_account" varchar(30) COLLATE "default",
"template_subject" varchar(30) COLLATE "default",
"template_content" varchar(255) COLLATE "default",
"template_country_code" varchar(10) COLLATE "default",
"template_language_code" varchar(10) COLLATE "default",
"communication_channel" varchar(10) COLLATE "default",
"template_attributes" varchar(255) COLLATE "default",
"card_connection" varchar(30) COLLATE "default",
"small_routine" varchar(30) COLLATE "default",
"page_path" varchar(30) COLLATE "default",
"template_remark" varchar(255) COLLATE "default",
"start_effective_time" timestamp(6),
"last_effective_time" timestamp(6),
"gmt_created" timestamp(6),
"creator" varchar(30) COLLATE "default",
"gmt_modified" timestamp(6),
"modifier" varchar(30) COLLATE "default",
"is_deleted" int2
)
WITH (OIDS=FALSE)

;
CREATE INDEX index_template_wechat_uuid on tbl_template_wechat(uuid);
CREATE INDEX index_template_wechat_event_type_uuid on tbl_template_wechat(event_type_uuid);

COMMENT ON COLUMN "public"."tbl_template_wechat"."event_type_uuid" IS '事件类型id';
COMMENT ON COLUMN "public"."tbl_template_wechat"."official_account" IS '微信公众号';
COMMENT ON COLUMN "public"."tbl_template_wechat"."template_subject" IS '微信模板名称';
COMMENT ON COLUMN "public"."tbl_template_wechat"."template_content" IS '微信内容';
COMMENT ON COLUMN "public"."tbl_template_email"."template_country_code" IS '所属国家';
COMMENT ON COLUMN "public"."tbl_template_email"."template_language_code" IS '模板语言';
COMMENT ON COLUMN "public"."tbl_template_email"."communication_channel" IS '传输方式';
COMMENT ON COLUMN "public"."tbl_template_email"."template_attributes" IS '模板参数';
COMMENT ON COLUMN "public"."tbl_template_wechat"."card_connection" IS '卡片链接(详情)';
COMMENT ON COLUMN "public"."tbl_template_wechat"."small_routine" IS '小程序APP';
COMMENT ON COLUMN "public"."tbl_template_wechat"."page_path" IS '页面路径';
COMMENT ON COLUMN "public"."tbl_template_wechat"."template_remark" IS '微信备注';
COMMENT ON COLUMN "public"."tbl_template_wechat"."start_effective_time" IS '有效时间';
COMMENT ON COLUMN "public"."tbl_template_wechat"."last_effective_time" IS '失效时间';
COMMENT ON COLUMN "public"."tbl_template_wechat"."gmt_created" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_template_wechat"."creator" IS '创建人';
COMMENT ON COLUMN "public"."tbl_template_wechat"."gmt_modified" IS '修改时间';
COMMENT ON COLUMN "public"."tbl_template_wechat"."modifier" IS '修改人';
COMMENT ON COLUMN "public"."tbl_template_wechat"."is_deleted" IS '是否有效 1 有效 2 无效';

