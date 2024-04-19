package demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void logger() {
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
}
