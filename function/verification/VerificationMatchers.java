/*
 * Copyright Ericsson AB 2019 - All Rights Reserved.
 * The copyright to the computer program(s) herein is the property of Ericsson AB.
 * The programs may be used and/or copied only with written permission from Ericsson AB
 * or in accordance with the terms and conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */

package com.smsgatewayadapter.ft.dynamic.function.verification;

import com.smsgatewayadapter.ft.dynamic.function.FunctionPattern;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.Matchers.hasToString;

public class VerificationMatchers {

	public static Matcher<Object> toMatcher(String text) {
		FunctionPattern pattern = FunctionPattern.pattern(text);
		if (pattern.isFunction()) {
			return ReflectionTestUtils
					.invokeMethod(null, Matchers.class, pattern.getFunctionName(), pattern.getFunctionArgs());
		}
		return hasToString(text);
	}
}
