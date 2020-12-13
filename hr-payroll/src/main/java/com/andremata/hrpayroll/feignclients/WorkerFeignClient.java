package com.andremata.hrpayroll.feignclients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.andremata.hrpayroll.entities.Worker;

@RibbonClient(name = "hr-worker")
@Component
@FeignClient(name = "hr-worker",  path = "/workers")
public interface WorkerFeignClient {
	
	@GetMapping(value = "{id}")
	ResponseEntity<Worker> find(@PathVariable Long id);
}
