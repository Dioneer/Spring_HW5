package Pegas.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AspectForAnnotation {

    @Pointcut("@annotation(Pegas.aspect.TrackUserAction)")
    public void isTrackUserAction(){}

    @Before("isTrackUserAction()")
    public void addLogging(JoinPoint joinPoint){
        var methodSignature = (MethodSignature)joinPoint.getSignature();
        var methodName = methodSignature.getMethod();
        var args = joinPoint.getArgs();
        log.info("Method "+methodName+" with args "+ Arrays.toString(args)+" was called");
    }
}
