package com.thrivent.payments.example.service;

import org.springframework.stereotype.Service;

import com.thrivent.payments.example.domain.Payment;
import com.thrivent.payments.example.exception.CustomException;
import com.thrivent.payments.example.exception.NotFoundException;

@Service("ExampleService")
public class ExampleService {

	public Payment getPaymentById(final long paymentId) throws CustomException, NotFoundException {
		
		if (paymentId == 1) {
			throw new CustomException("Incorrect payment Id");
		}
		if (paymentId == 2) {
			throw new NotFoundException("No payment found");
		}
		
		return new Payment(paymentId, "Test", "Customer", "contact-us@thrivent.com");
	}

	public Payment registerPayment(final Payment payment) throws CustomException {

		return payment;
	}

}
