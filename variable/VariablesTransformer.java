
package com.smsgatewayadapter.ft.dynamic.variable;

import com.smsgatewayadapter.ft.dynamic.context.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VariablesTransformer {

	@Autowired
	private ScenarioContext context;

	public String transform(String value){
		VariablePattern pattern = VariablePattern.pattern(value);
		if(pattern.isVariable()){
			Object variable = context.getContext(pattern.getVariableName());
			if(variable!=null){
				return variable.toString();
			}
			return null;
		}else{
			return value;
		}
	}

}
