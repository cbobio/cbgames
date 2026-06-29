package br.com.cbobio.cbgames.service.interceptor;

/*
 * Copyright (c) 2025, Atacadão S.A. and/or its affiliates. All rights reserved.
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultAPIResponse<T> {
	public enum ResponseStatus {
		SUCCESS,
		ERROR
	}

	private ResponseStatus status;
	private ApiResponseData<T> data;
	private String message;

	public static <T> DefaultAPIResponse<T> success(ApiResponseData<T> data){
		return new DefaultAPIResponse<>(ResponseStatus.SUCCESS, data, "Operation succeeded");
	}

	public static <T> DefaultAPIResponse<T> error(String message){
		return new DefaultAPIResponse<>(ResponseStatus.ERROR, null, message);
	}

	public static <T> DefaultAPIResponse<T> error(String message, ApiResponseData<T> data){
		return new DefaultAPIResponse<>(ResponseStatus.ERROR, data, message);
	}
}
