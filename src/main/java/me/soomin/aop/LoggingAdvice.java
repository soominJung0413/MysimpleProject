package me.soomin.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
@Log4j
public class LoggingAdvice {

    @Around("execution(* me.soomin.*.service.*ServiceImpl.*(..))")
    public Object Logging(ProceedingJoinPoint point){
        log.info("Logging....Params..."+ Arrays.toString(point.getArgs()));
        log.info("Logging....Target..."+point.getTarget());
        log.info("Logging....MethodSig..."+point.getSignature().toLongString());

        Object result = null;
        try{
        result = point.proceed();
        }catch(Throwable e){
            log.info(e);
        }
        return result;
    }
}
