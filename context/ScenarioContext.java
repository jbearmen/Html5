

package com.smsgatewayadapter.ft.dynamic.context;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScenarioContext {

	private Map<String, Object> scenarioContext;

	public ScenarioContext(){
		scenarioContext = new HashMap<>();
	}

	public void clear(){
		scenarioContext = new HashMap<>();
	}

	public void setContext(String key, Object value) {
		scenarioContext.put(key.toString(), value);
	}

	public Object getContext(String key){
		return scenarioContext.get(key.toString());
	}

	public Boolean isContains(String key){
		return scenarioContext.containsKey(key.toString());
	}
}
