package br.com.cbobio.cbgames.service.interceptor;

/*
 * Copyright (c) 2025, Atacadão S.A. and/or its affiliates. All rights reserved.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class APIResponseAdvice implements ResponseBodyAdvice<Object> {
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body,
	                              MethodParameter returnType,
	                              MediaType selectedContentType,
	                              Class selectedConverterType,
	                              ServerHttpRequest request,
	                              ServerHttpResponse response){
		if(body instanceof DefaultAPIResponse){
			return body;
		}

		if (!MediaType.APPLICATION_JSON.equals(selectedContentType)) {
			return body;
		}

		String customMessage = "Operation succeeded";
		CustomResponseMessage annotation = returnType.getMethodAnnotation(CustomResponseMessage.class);
		if(annotation != null){
			customMessage = annotation.value();
		}

		ApiResponseData<Object> data = new ApiResponseData<>(body);
		DefaultAPIResponse<Object> apiResponse = new DefaultAPIResponse<>(DefaultAPIResponse.ResponseStatus.SUCCESS, data, customMessage);

		if (body instanceof String) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				return objectMapper.writeValueAsString(apiResponse);
			} catch (Exception e) {
				throw new RuntimeException("Erro ao converter resposta para JSON", e);
			}
		}

		return apiResponse;
	}
}