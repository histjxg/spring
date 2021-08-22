package org.springframework.orm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// 声明一个切面
@Aspect
public class PerformanceTraceAspect {

    // 匹配任意返回值、任意包下的、任意参数的fly方法。在这个demo中，将匹配到com.luhc.springaop.aspect.FlyImpl#fly这个方法
    @Pointcut("execution(* *..*fly(..))")
    public void pointcutName(){}

    // 声明切入的前置逻辑
    @Before("pointcutName()")
    public void before(JoinPoint joinPoint) {
        // 可以通过JoinPoint获取到pointcut方法的详细信息
        System.out.println("Before --> 获取到Joinpoint的方法名: " + joinPoint.getSignature().getName());
    }

    // 声明切入的后置逻辑
    @After("pointcutName()")
    public void after(JoinPoint joinPoint) {
        // 可以通过JoinPoint获取到pointcut方法的详细信息
        System.out.println("After --> 获取到Joinpoint的方法名: " + joinPoint.getSignature().getName());
    }

    // 声明切入的环绕逻辑（即在方法执行前后切入逻辑）
    @Around("pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        try {
            // 调用执行链
            return joinPoint.proceed();
        } finally {
            System.out.println(String.format("cost time %s", System.currentTimeMillis() - start));
        }
    }
}

