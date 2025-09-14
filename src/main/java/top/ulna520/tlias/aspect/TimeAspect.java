package top.ulna520.tlias.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* top.ulna520.tlias.service.*.*(..))")
    public Object recortTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long end = System.currentTimeMillis();
        String methodName = pjp.getSignature().getName();
        System.out.println(methodName + "方法执行时间：" + (end - start) + "ms");
        return obj;
    }
}
