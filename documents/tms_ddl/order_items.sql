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

 Date: 24/06/2025 15:43:02
*/


-- ----------------------------
-- Table structure for order_items
-- ----------------------------
DROP TABLE IF EXISTS "public"."order_items";
CREATE TABLE "public"."order_items" (
  "id" uuid NOT NULL,
  "order_id" uuid,
  "product_id" uuid,
  "price" numeric(10,2),
  "quantity" int4
)
;

-- ----------------------------
-- Primary Key structure for table order_items
-- ----------------------------
ALTER TABLE "public"."order_items" ADD CONSTRAINT "order_items_pkey" PRIMARY KEY ("id");
