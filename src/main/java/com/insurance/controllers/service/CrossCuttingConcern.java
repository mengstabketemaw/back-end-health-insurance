package com.insurance.controllers.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


// in this class there are all the cross cutting concerns like exception handling and intercepting each method

@org.aspectj.lang.annotation.Aspect
@RestControllerAdvice
public class CrossCuttingConcern {
    Logger logger = Logger.getLogger(CrossCuttingConcern.class.getName());

    @Around(" execution(* com.insurance.controllers.service.*.*(..)) ")
    public Object log(ProceedingJoinPoint jointPoint) throws Throwable {
        logger.info("Executing Methode : "+jointPoint.getSignature().getName());
        Object object = jointPoint.proceed();
        logger.info("Finished Executing Method : "+jointPoint.getSignature().getName());
        return object;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> exception(Exception e){
           Map<String,Object> list = new HashMap<>();
           list.put("type","error");
           list.put("message",e.getMessage());
           list.put("whatToDo","Adjust your request or contact the developers");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
    }
}
