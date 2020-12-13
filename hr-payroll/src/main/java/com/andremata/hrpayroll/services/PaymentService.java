package com.andremata.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andremata.hrpayroll.entities.Payment;
import com.andremata.hrpayroll.entities.Worker;
import com.andremata.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long idWorker, int days) {
		Worker worker = workerFeignClient.find(idWorker).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
