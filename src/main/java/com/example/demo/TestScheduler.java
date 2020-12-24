package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class TestScheduler {

    @Scheduled(fixedDelay = 5000L)
    void task() {
        log.info("Test task!");
    }

}
