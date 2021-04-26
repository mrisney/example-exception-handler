package com.thrivents.payments.example.comtroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thrivents.payments.example.domain.Payment;
import com.thrivents.payments.example.exception.CustomException;
import com.thrivents.payments.example.exception.NotFoundException;
import com.thrivents.payments.example.service.ExampleService;

@RestController
@RequestMapping("/payments")
public class ExampleController {

	@Autowired
	ExampleService exampleService;

	@GetMapping("/payment/{id}")
	public Payment getPayment(@PathVariable long id) throws CustomException, NotFoundException {
		return exampleService.getPaymentById(id);
	}

	@PostMapping("/payment/register")
	public Payment createPayment(@Valid @RequestBody Payment payment) throws CustomException {
		return exampleService.registerPayment(payment);
	}

}
