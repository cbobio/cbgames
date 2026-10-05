package br.com.cbobio.cbgames.service.interceptor;

/*
 * Copyright (c) 2025, Atacadão S.A. and/or its affiliates. All rights reserved.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseData<T> {
	private T resource;
}
