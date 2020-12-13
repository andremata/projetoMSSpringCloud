package com.andremata.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.andremata.hrpayroll.entities.Payment;
import com.andremata.hrpayroll.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String WorkerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long idWorker, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+idWorker);
		
		Worker worker = restTemplate.getForObject(WorkerHost + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
