/*
 Navicat Premium Dump SQL

 Source Server         : thientdk_vps_postgresql
 Source Server Type    : PostgreSQL
 Source Server Version : 160009 (160009)
 Source Host           : 103.188.83.162:5432
 Source Catalog        : tms_wallet
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 160009 (160009)
 File Encoding         : 65001

 Date: 24/06/2025 15:43:52
*/


-- ----------------------------
-- Table structure for transactions
-- ----------------------------
DROP TABLE IF EXISTS "public"."transactions";
CREATE TABLE "public"."transactions" (
  "id" uuid NOT NULL,
  "wallet_id" uuid,
  "amount" numeric(10,2),
  "type" text COLLATE "pg_catalog"."default",
  "note" text COLLATE "pg_catalog"."default",
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "created_by" uuid,
  "updated_by" uuid
)
;

-- ----------------------------
-- Primary Key structure for table transactions
-- ----------------------------
ALTER TABLE "public"."transactions" ADD CONSTRAINT "transactions_pkey" PRIMARY KEY ("id");
