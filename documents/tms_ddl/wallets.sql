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

 Date: 24/06/2025 15:43:59
*/


-- ----------------------------
-- Table structure for wallets
-- ----------------------------
DROP TABLE IF EXISTS "public"."wallets";
CREATE TABLE "public"."wallets" (
  "id" uuid NOT NULL,
  "user_id" uuid,
  "balance" numeric(10,2),
  "created_at" timestamp(6),
  "updated_at" timestamp(6),
  "created_by" uuid,
  "updated_by" uuid
)
;

-- ----------------------------
-- Primary Key structure for table wallets
-- ----------------------------
ALTER TABLE "public"."wallets" ADD CONSTRAINT "wallets_pkey" PRIMARY KEY ("id");
