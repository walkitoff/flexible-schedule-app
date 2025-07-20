package com.shiftplanner.flexible_schedule;

import org.springframework.boot.SpringApplication;

public class TestFlexibleScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.from(FlexibleScheduleApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
