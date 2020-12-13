package com.andremata.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.andremata.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long idWorker, int days) {
		return new Payment("Bob", 200.0, days);
	}
}
