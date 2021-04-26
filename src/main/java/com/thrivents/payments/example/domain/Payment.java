package com.thrivents.payments.example.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@NotNull(message = "Id can not be null")
	private long id;

	@NotNull(message = "Please provide first Name")
	private String firstName;

	@NotNull(message = "Please provide last Name")
	private String lastName;

	@Email(message = "please provide a valid email id")
	private String email;

}