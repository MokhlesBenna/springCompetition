package tn.esprit.mokhlesbenna.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ConfigAOP {

    @Before("execution(* tn.esprit.mokhlesbenna.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("Before Method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* tn.esprit.mokhlesbenna.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        log.info("After Method: " + joinPoint.getSignature().getName());
    }
}
