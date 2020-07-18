package com.tapriBrewCafe.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.tapriBrewCafe.dashboard.*"})
@EntityScan(basePackages = {"com.tapriBrewCafe.dashboard.staffMgmt.entity.model"})
@EnableJpaRepositories(basePackages = {"com.tapriBrewCafe.dashboard.staffMgmt.entity.repository"})
public class DashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

}
