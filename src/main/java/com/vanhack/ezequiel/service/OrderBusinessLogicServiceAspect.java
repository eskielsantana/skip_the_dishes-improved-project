package com.vanhack.ezequiel.service;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderBusinessLogicServiceAspect {

    //@Before("execution(* com.vanhack.ezequiel.service.OrderBusinessLogicServiceImpl.requestOrder (java.lang.String)) && args(orderId)")
    //@Before("execution(* OrderBusinessLogicService.requestOrder(..)) && args(orderId)")
//    @Before("execution(* com.vanhack.ezequiel.service.OrderBusinessLogicServiceImpl.requestOrder(..)) && args(orderRestDto,..)")
//    public void beforeGetOrderById(JoinPoint joinPoint, OrderRestDto orderRestDto) throws Exception {
//        System.out.println("CHAMOU O GET ORDER BY ID POARRR");
//        throw new Exception("TESTANDO 123");
//    }



}
