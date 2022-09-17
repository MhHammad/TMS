package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseDTO<T> {
	
	private T result;
	
	public ResponseDTO(T result) {
		
		this.result=result;		
	}


}
