package com.wordpress.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.wordpress.enums.ExtentReportEnums;

@Retention(RUNTIME)
@Target(TYPE)
public @interface ExtentReport {

	public ExtentReportEnums[] category();
}
