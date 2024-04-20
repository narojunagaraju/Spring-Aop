package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void logger(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        System.out.println("Argument value is " + joinPoint.getArgs()[0]);
        System.out.println("loggers");
    }

    /****
     * 1st * for any return type
     * 2nd * for any package
     * .* for any class
     * .* for any method
     */
    @After("execution(* *.*.checkout(..))")
    public void afterLogger() {
        System.out.println("After Logger");
    }


    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {

    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After returning "+retVal);
    }
}
