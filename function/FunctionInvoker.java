

package com.smsgatewayadapter.ft.dynamic.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author: Xiongqiang Xu
 * @date: 2020/2/20
 */
public class FunctionInvoker {

	private static final Logger logger = LoggerFactory.getLogger(FunctionInvoker.class);

	private FunctionDefinitions functions = new FunctionDefinitions();

	public Object invoke(String functionName, String[] args) {
		try{
			Method method = FunctionDefinitions.class.getMethod(functionName, getArgTypes(args));
			return method.invoke(functions, args);
		}catch (NoSuchMethodException|InvocationTargetException|IllegalAccessException e){
			logger.warn(e.getMessage());
			return null;
		}
	}

	private Class<?>[] getArgTypes(String... args){
		return Arrays.stream(args).map(arg -> String.class).collect(Collectors.toList())
				.toArray(new Class<?>[args.length]);
	}

}
