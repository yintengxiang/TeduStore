package cn.tedu.store;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProxxyAspect {
    @Around("bean(list)")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable{
        Signature s = joinPoint.getSignature();
        System.out.println(s);

        synchronized (this){
           return joinPoint.proceed();

        }
    }
}
