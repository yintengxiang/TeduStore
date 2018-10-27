package cn.tedu.store.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {
    //在userService的所有方法之前执行test1方法
    @Before("bean(userService)")
    public void test1(){
        System.out.println("test1");
    }
    //在userService的所有方法之后执行test2方法
    @After("bean(userService)")
    public void test2(){
        System.out.println("test2");
    }
    //在userService的所有方法正常执行之后执行test3方法
    @AfterReturning("bean(userService)")
    public void test3(){
        System.out.println("test3");
    }
    //在userService的所有方法出现异常之后执行test4方法
    @AfterThrowing("bean(userService)")
    public void test4(){
        System.out.println("test4");
    }
    @Before("execution(* cn.tedu.store.service.IUserService.login(..))")
    public void test5(){
        System.out.println("test5");
    }
    @Before("within(cn.tedu.store.service.*ServiceImpl)")
    public void test6(){
        System.out.println("test6");
    }


}
