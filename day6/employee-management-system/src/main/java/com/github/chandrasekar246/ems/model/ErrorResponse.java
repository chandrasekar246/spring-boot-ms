package com.github.chandrasekar246.ems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ErrorResponse {

	private ErrorCode errorCode;
	private String errorMessage;
}
