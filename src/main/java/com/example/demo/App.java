package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class App {

	public static void main(String[] args) {
		setLog4j2Props();
		SpringApplication.run(App.class, args);
	}

	private static void setLog4j2Props() {
		// Ensure that debug logging performed using java.util.logging is routed into Log4j 2
		// Ref: https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-configure-log4j-for-logging
		System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
		// Make all loggers async
		// Ref: https://logging.apache.org/log4j/2.x/manual/async.html#AllAsync
		System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
	}

}
