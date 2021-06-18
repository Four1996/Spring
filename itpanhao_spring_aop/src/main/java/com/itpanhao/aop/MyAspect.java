package com.itpanhao.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author panhao
 * @date 2021年04月09日 10:55 上午
 */
public class MyAspect {
    public void before(){
        System.out.println("前值增强....");
    }
    public void afterReturning(){
        System.out.println("后置增强...");
    }
//    正在执行的连接点==切点
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//Proceeding JoinPoint正在执行的连接点===切入点
        System.out.println("环绕前增强。。");
        Object proceed = proceedingJoinPoint.proceed();//切点方法

        System.out.println("环绕后增强。。");
        return proceed;
    }
    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }
    public void after(){
        System.out.println("最终增强..");
    }
}
