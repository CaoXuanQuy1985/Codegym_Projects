package com.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class Logger {

    public void error() {
        System.out.println("[com.codegym] ERROR !");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.controller.LibraryController.*(..))", throwing = "ex")
    public void log(JoinPoint joinPoint, Exception ex) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println(String.format("[Application] co loi xay ra: %s.%s%s: %s", className, method, args, ex.getMessage()));
    }

    @After("execution(public * com.codegym.controller.LibraryController.borrowBook(..))")
    public void log_2(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println(String.format("[Application] Ung dung muon sach vua thuc hien hanh dong cho muon sach voi thong tin sau: %s.%s%s", className, method, args));
    }

    @After("execution(public * com.codegym.controller.LibraryController.returnBook(..))")
    public void log_3(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println(String.format("[Application] Ung dung muon sach vua thuc hien hanh dong cho tra sach voi thong tin sau: %s.%s%s", className, method, args));
    }
}
