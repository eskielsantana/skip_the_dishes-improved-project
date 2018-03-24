package com.vanhack.ezequiel.controller;

import com.vanhack.ezequiel.dto.restDto.OrderListRestDto;
import com.vanhack.ezequiel.dto.restDto.OrderRestDto;
import com.vanhack.ezequiel.service.CustomerBusinessLogicService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MainControllerAspect {

    private static final Integer CUSTOMER_NOT_FOUND_ID = -1;

    @Autowired
    private CustomerBusinessLogicService customerBusinessLogicService;

    @Around("execution(* com.vanhack.ezequiel.controller.MainController.getOrderById (..)) && args(token, orderId, ..)")
    public ResponseEntity<String> aroundGetOrderById(ProceedingJoinPoint joinPoint, String token, Integer orderId) throws Throwable {
        return validateToken(joinPoint, token);
    }

    @Around("execution(* com.vanhack.ezequiel.controller.MainController.requestOrders (..)) && args(token, orderRestListDto, ..)")
    public ResponseEntity<String> aroundRequestOrders(ProceedingJoinPoint joinPoint, String token, OrderListRestDto orderRestListDto) throws Throwable {
        return validateToken(joinPoint, token);
    }

    @Around("execution(* com.vanhack.ezequiel.controller.MainController.requestOrder (..)) && args(token, orderRestDto, ..)")
    public ResponseEntity<String> aroundRequestOrder(ProceedingJoinPoint joinPoint, String token, OrderRestDto orderRestDto) throws Throwable {
        return validateToken(joinPoint, token);
    }

    @Around("execution(* com.vanhack.ezequiel.controller.MainController.cancelOrder (..)) && args(token, orderId, ..)")
    public ResponseEntity<String> aroundCancelOrder(ProceedingJoinPoint joinPoint, String token, Integer orderId) throws Throwable {
        return validateToken(joinPoint, token);
    }

    @Around("execution(* com.vanhack.ezequiel.controller.MainController.getOrderStatusById (..)) && args(token, orderId, ..)")
    public ResponseEntity<String> aroundGetOrderStatusById(ProceedingJoinPoint joinPoint, String token, Integer orderId) throws Throwable {
        return validateToken(joinPoint, token);
    }

    private ResponseEntity<String> validateToken(ProceedingJoinPoint joinPoint, String token) throws Throwable {
        if( CUSTOMER_NOT_FOUND_ID.equals(customerBusinessLogicService.validateToken(token)) ){
            Object[] args = joinPoint.getArgs();
            return new ResponseEntity<>("Error: Token is invalid: " + token, HttpStatus.BAD_REQUEST);
        }
        return (ResponseEntity<String>) joinPoint.proceed();
    }
}
