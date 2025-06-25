package com.thientdk.be_tms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeTmsApplication {

	private static final Logger log = LogManager.getLogger(BeTmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BeTmsApplication.class, args);

		log.info("========================================================");
		log.info("|              TMS - TINY MICROSERVICE                 |");
		log.info("|              BE TMS - EXPOSE API SERVICE             |");
		log.info("========================================================");
	}

}
