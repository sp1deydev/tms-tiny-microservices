/*
 Navicat Premium Dump SQL

 Source Server         : thientdk_vps_postgresql
 Source Server Type    : PostgreSQL
 Source Server Version : 160009 (160009)
 Source Host           : 103.188.83.162:5432
 Source Catalog        : tms_inventory
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 160009 (160009)
 File Encoding         : 65001

 Date: 24/06/2025 15:42:37
*/


-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS "public"."products";
CREATE TABLE "public"."products" (
  "id" uuid NOT NULL,
  "name" text COLLATE "pg_catalog"."default",
  "description" text COLLATE "pg_catalog"."default",
  "price" numeric(10,2),
  "stock " int4,
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "created_by" uuid,
  "updated_by" uuid
)
;

-- ----------------------------
-- Primary Key structure for table products
-- ----------------------------
ALTER TABLE "public"."products" ADD CONSTRAINT "products_pkey" PRIMARY KEY ("id");
