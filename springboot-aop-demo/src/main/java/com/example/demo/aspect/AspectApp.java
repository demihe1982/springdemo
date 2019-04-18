package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AspectApp {


    public AspectApp(){
        System.out.println("Aspect init.........................");
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.controller.v1.*.*(..))",returning = "retVal")
    public String afterReturn(JoinPoint jp, Object retVal){
        System.out.println("[afterReturningAdvice] Method Signature: "  + jp.getSignature());
        System.out.println("[afterReturningAdvice] Returning: " + retVal.toString());

        String str = "Refactor to Hello admin !!!";

        retVal = str;

        return str;
    }

    @After(value = "execution(* com.example.demo.controller.v1..*.*(..))")
    public void after(){
        System.out.println("after....................................");
    }

    @Around("execution(public org.springframework.http.ResponseEntity<com.example.demo.vo.Demo> com.example.demo.controller.v1..*.*(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("around....................................");
        System.out.println("[aroundAdvice] Around advice");
        Object[] args=jp.getArgs();
        if(args.length>0){
            System.out.print("[aroundAdvice] Arguments passed: " );
            for (int i = 0; i < args.length; i++) {
                System.out.print("[aroundAdvice] arg "+(i+1)+": "+args[i]);
            }
        }

        Object result=jp.proceed(args);
        String str = result.toString()+"!!!!!!!!!!!!";
        System.out.println("[aroundAdvice] Returning " + result);
        return result;
    }

}
