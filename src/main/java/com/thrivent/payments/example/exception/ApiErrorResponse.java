package com.thrivent.payments.example.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class ApiErrorResponse {

	private HttpStatus status;
	private String errorCode;
	private String message;
	private String detail;
	private String timeStamp;

}

