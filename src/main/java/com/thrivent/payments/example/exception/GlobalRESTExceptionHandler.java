package com.thrivent.payments.example.exception;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalRESTExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<Object> customerNotFound(NotFoundException ex) {
		
		ApiErrorResponse response = ApiErrorResponse.builder()
				.detail("Not able to find customer record")
				.message(ex.getMessage())
				.errorCode("404")
				.status(HttpStatus.NOT_FOUND)
				.timeStamp(LocalDateTime.now(ZoneOffset.UTC).toString())
				.build();
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		
		List<String> errorMsg = 
				ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage())
				.collect(Collectors.toList());
		
		ApiErrorResponse response = ApiErrorResponse.builder().status(status).detail("not valid arguments")
				.message(errorMsg.toString()).errorCode("406")
				.errorCode(status.NOT_ACCEPTABLE.name())
				.timeStamp(LocalDateTime.now(ZoneOffset.UTC).toString())
				.build();
		
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<Object> handleCustomAPIException(CustomException ex) {

		ApiErrorResponse response = ApiErrorResponse.builder()
				.detail("Some Custom Error")
				.message(ex.getMessage())
				.errorCode("410")
				.status(HttpStatus.GONE)
				.timeStamp(LocalDateTime.now(ZoneOffset.UTC).toString())
				.build();

		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorResponse> handleCustomAPIException(Exception ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ApiErrorResponse response = ApiErrorResponse.builder()
				.status(status).detail("Something went wrong")
				.message(ex.getLocalizedMessage())
				.errorCode("502")
				.errorCode(status.BAD_GATEWAY.name())
				.timeStamp(LocalDateTime.now(ZoneOffset.UTC).toString())
				.build();
		return new ResponseEntity<>(response, response.getStatus());
	}

}
