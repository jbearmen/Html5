

package com.smsgatewayadapter.ft.dynamic.function;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author: Xiongqiang Xu
 * @date: 2020/2/20
 */
@Slf4j
public class FunctionPattern {

	private final static Pattern functionPattern = Pattern.compile("^\\$\\.([a-zA-Z0-9]*)\\(([\\s|\\S]*)\\)$");
	private Matcher matcher;

	public static FunctionPattern pattern(String text){
		FunctionPattern pattern = new FunctionPattern();
		pattern.matcher = functionPattern.matcher(text);
		pattern.matcher.find();
		return pattern;
	}

	public boolean isFunction(){
		return matcher.matches();
	}

	public String getFunctionName(){
		return matcher.group(1);
	}

	public String[] getFunctionArgs(){
		String argsStr = matcher.group(2);
		if(StringUtils.isBlank(argsStr)){
			return new String[0];
		}
		String[] args = StringUtils.split(argsStr,",");
		for(int i=0; i<args.length; i++){
			args[i] = StringUtils.trim(args[i]);
		}
		return args;
	}

}
