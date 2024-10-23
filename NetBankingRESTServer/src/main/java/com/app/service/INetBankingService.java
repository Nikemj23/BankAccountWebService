package com.app.service;

import com.app.dto.CreateAccountRequest;
import com.app.dto.LoginResponse;
import com.app.pojos.BankAccount;

import jakarta.validation.Valid;

public interface INetBankingService {
   LoginResponse authenticateCustomer(String customerId, String pwd);

BankAccount createNewAccount(@Valid CreateAccountRequest request);
}
