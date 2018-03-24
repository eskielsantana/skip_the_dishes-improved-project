package com.vanhack.ezequiel.service;

import com.vanhack.ezequiel.dto.CustomerDto;

public interface CustomerBusinessLogicService {

    void registerNewCustomer(CustomerDto customerDto) throws Exception;

    String loginCustomer(String email, String password) throws Exception;

    Integer validateToken(String token);

}