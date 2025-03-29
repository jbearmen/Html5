
package com.smsgatewayadapter.ft.dynamic;

import com.smsgatewayadapter.ft.dynamic.context.ScenarioContext;
import com.smsgatewayadapter.ft.dynamic.function.FunctionInvoker;
import com.smsgatewayadapter.ft.dynamic.function.FunctionPattern;
import com.smsgatewayadapter.ft.dynamic.utils.MapUtils;
import com.smsgatewayadapter.ft.dynamic.variable.VariablePattern;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ParametersTransformer {

	private FunctionInvoker invoker = new FunctionInvoker();

	@Autowired
	private ScenarioContext context;

	public List<Map<String, Object>> transform(DataTable dataTable){
		return dataTable.asMaps().stream().map(row -> transform(row)).collect(Collectors.toList());
	}

	private  Map<String, Object> transform(Map<String, String> row){
		Map<String, Object> transformedRow = new HashMap<>(row.size());
		row.forEach((key, value)-> MapUtils.setValue(transformedRow, key, transform(value)));
		return transformedRow;
	}

	public  Object transform(String value){
		VariablePattern variablePattern = VariablePattern.pattern(value);
		if(variablePattern.isVariable()){
			Object variable = context.getContext(variablePattern.getVariableName());
			if(variable!=null){
				return variable.toString();
			}else{
				return value;
			}
		}else{
			FunctionPattern functionPattern = FunctionPattern.pattern(value);
			if(functionPattern.isFunction()){
				return invoker.invoke(functionPattern.getFunctionName(),functionPattern.getFunctionArgs());
			}else{
				return value;
			}
		}
	}

}
