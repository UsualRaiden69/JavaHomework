package org.example.javawebapp_vadzim.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* org.example.javawebapp_vadzim.service..*(..))")
    public Object logMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        long start = System.currentTimeMillis();

        logger.info("➡ENTER: {} | args={}",
                methodName,
                Arrays.toString(args));

        try {
            Object result = joinPoint.proceed();

            long time = System.currentTimeMillis() - start;

            logger.info("EXIT: {} | time={}ms | result={}",
                    methodName,
                    time,
                    result);

            return result;

        } catch (Throwable ex) {

            long time = System.currentTimeMillis() - start;

            logger.error("ERROR in {} | time={}ms | message={}",
                    methodName,
                    time,
                    ex.getMessage());

            throw ex;
        }
    }
}