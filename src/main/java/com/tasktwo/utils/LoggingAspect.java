package com.tasktwo.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

  @Before("@annotation(LogMethodParam)")
  public void logMethodParam(JoinPoint joinPoint) throws Throwable {
    Object[] arguments = joinPoint.getArgs();
    String logString = "";
    for (Object obj : arguments) {
      logString = logString + " " + obj.toString();
    }
    log.info("Method {} - Parameters - {}", joinPoint.toShortString(), logString);
  }
}
