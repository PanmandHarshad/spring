package com.easybytes.easyschool.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* com.easybytes.easyschool..*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info(proceedingJoinPoint.getSignature().toString() + " method execution start");

        Instant start = Instant.now();
        // proceed() will return the return type object of executing method
        Object returnObj = proceedingJoinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapse = Duration.between(start, finish).toMillis();

        log.info("Time took to execute " + proceedingJoinPoint.getSignature().toString() + " method is " + timeElapse);
        log.info(proceedingJoinPoint.getSignature().toString() + " method execution end");

        return returnObj;
    }

    @AfterThrowing(value = "execution(* com.easybytes.easyschool.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error(joinPoint.getSignature().toString() + " An exception happened due to " + ex.getMessage());
    }
}
