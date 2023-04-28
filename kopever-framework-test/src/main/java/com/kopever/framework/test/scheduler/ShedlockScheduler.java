package com.kopever.framework.test.scheduler;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockAssert;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShedlockScheduler {

    @Scheduled(fixedRate = 10000)
    @SchedulerLock(name = "shedlock_test_scheduler", lockAtLeastFor = "15s")
    public void testShedlockScheduler() {
        LockAssert.assertLocked();
        logger.info("shedlock test");
    }

}
