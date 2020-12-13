package com.andremata.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andremata.hrpayroll.entities.Payment;
import com.andremata.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{idWorker}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable long idWorker, @PathVariable int days) {
		Payment p = service.getPayment(idWorker, days);
		
		return ResponseEntity.ok(p);
	}
}
