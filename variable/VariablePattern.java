

package com.smsgatewayadapter.ft.dynamic.variable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author: Xiongqiang Xu
 * @date: 2020/2/20
 */
public class VariablePattern {

	private final static Pattern variablePattern = Pattern.compile("^\\$\\{([a-zA-Z0-9]*)\\}$");
	private Matcher matcher;

	public static VariablePattern pattern(String text){
		VariablePattern pattern = new VariablePattern();
		pattern.matcher = variablePattern.matcher(text);
		pattern.matcher.find();
		return pattern;
	}

	public boolean isVariable(){
		return matcher.matches();
	}

	public String getVariableName(){
		return matcher.group(1);
	}

}
