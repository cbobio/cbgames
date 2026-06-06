package br.com.cbobio.cbgames.service.interceptor;

/*
 * Copyright (c) 2025, Atacadão S.A. and/or its affiliates. All rights reserved.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomResponseMessage {
	String value() default "Operation succeeded";
}
