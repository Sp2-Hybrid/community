package com.songpeng.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author songpeng
 */
@Component
@Aspect
public class AlphaAspect {
    @Pointcut("execution(* com.songpeng.community.service.*.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before(){

    }

    @After("pointcut()")
    public void after(){

    }

    @AfterReturning("pointcut()")
    public void afterReturning(){

    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around before");
        Object obj = joinPoint.proceed();
        System.out.println("around after");
        return obj;
    }
}
