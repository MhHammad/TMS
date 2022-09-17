package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ErrorResponse {

	private String message ;
	private LocalDateTime date;
	public ErrorResponse(String message) {
		super();
		this.message = message;
		this.date= LocalDateTime.now();
	}
	
	
}
