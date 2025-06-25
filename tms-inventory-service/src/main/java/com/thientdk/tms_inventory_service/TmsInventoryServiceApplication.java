package com.thientdk.tms_inventory_service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TmsInventoryServiceApplication {

	private static final Logger log = LogManager.getLogger(TmsInventoryServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TmsInventoryServiceApplication.class, args);

		log.info("========================================================");
		log.info("|              TMS - TINY MICROSERVICE                 |");
		log.info("|              INVENTORY SERVICE                       |");
		log.info("========================================================");
	}
}
