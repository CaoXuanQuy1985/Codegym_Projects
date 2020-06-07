package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR !");
    }

    /*@AfterThrowing(pointcut = "execution(public * com.codegym.service.CustomerService.findAll(..))")
    public void log(){
        System.out.println("Testing log in console");
    }*/

    /*@AfterThrowing(pointcut = "execution(public * com.codegym.service.CustomerService.*(..))", throwing = "ex")
    public void log(Exception ex) {
        System.out.println("[CMS] co loi xay ra: "+ ex.getMessage());
    }*/

    @AfterThrowing(pointcut = "execution(public * com.codegym.service.*.*(..))", throwing = "ex")
    public void log(JoinPoint joinPoint, Exception ex) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, ex.getMessage()));
    }
}
