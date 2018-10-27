package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
    /**
     * 在userService的全部方法的前后执行test方法
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    //@Around("bean(userService)|| bean(GoodsService)")
    @Around("bean(*Service)")
    public Object  test(ProceedingJoinPoint joinPoint) throws Throwable{
        long t1=System.currentTimeMillis();
        //执行目标业务方法，val代表 业务方法的返回值
        Object val=joinPoint.proceed();
        long t2=System.currentTimeMillis();
        //获取目标业务方法
        Signature method=joinPoint.getSignature();
        //显示执行方法消耗的时间
        System.out.println(method + ":" + (t2 - t1));
        return val;

    }


}
