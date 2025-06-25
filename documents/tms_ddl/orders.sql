/*
 Navicat Premium Dump SQL

 Source Server         : thientdk_vps_postgresql
 Source Server Type    : PostgreSQL
 Source Server Version : 160009 (160009)
 Source Host           : 103.188.83.162:5432
 Source Catalog        : tms_order
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 160009 (160009)
 File Encoding         : 65001

 Date: 24/06/2025 15:43:08
*/


-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS "public"."orders";
CREATE TABLE "public"."orders" (
  "id" uuid NOT NULL,
  "user_id" uuid,
  "total" numeric(10,2),
  "status" text COLLATE "pg_catalog"."default",
  "note" text COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "created_by" uuid,
  "updated_by" uuid
)
;

-- ----------------------------
-- Primary Key structure for table orders
-- ----------------------------
ALTER TABLE "public"."orders" ADD CONSTRAINT "orders_pkey" PRIMARY KEY ("id");
