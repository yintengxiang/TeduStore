package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component//声明是通用组件
@Aspect//声明当前类是切面组件
public class ProxyAspect {
    @Around("bean(list)")//表示切入到list bean对象的全部方法
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable{
        //joinPoint代表被调用目标的对象方法
        //其封装了目标对像，和调用的方法
        Signature s = joinPoint.getSignature();
        System.out.println(s);
        //添加同步代码块
        synchronized (this){
            return joinPoint.proceed();
        }

    }
}
