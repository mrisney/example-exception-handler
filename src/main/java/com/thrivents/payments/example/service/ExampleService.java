package com.thrivents.payments.example.service;

import org.springframework.stereotype.Service;

import com.thrivents.payments.example.domain.Payment;
import com.thrivents.payments.example.exception.CustomException;
import com.thrivents.payments.example.exception.NotFoundException;

@Service("ExampleService")
public class ExampleService {

	public Payment getPaymentById(final long paymentId) throws CustomException, NotFoundException {
		if (paymentId == 1) {
			throw new CustomException("Custom Service Exception");
		}
		if (paymentId == 2) {
			throw new NotFoundException("Not found exception");
		}
		
		return new Payment(paymentId, "Test", "Customer", "contact-us@thrivent.com");
	}

	public Payment registerPayment(final Payment payment) throws CustomException {

		return payment;
	}

}
