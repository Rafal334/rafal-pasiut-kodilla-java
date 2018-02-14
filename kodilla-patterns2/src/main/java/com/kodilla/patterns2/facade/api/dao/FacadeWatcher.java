package com.kodilla.patterns2.facade.api.dao;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {

    public static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.dao.calculator.Watcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId)")
    public void logProcessOrderEvent(OrderDto order, Long userId) {
        LOGGER.info("Processing order for user: " + userId);
    }
}
