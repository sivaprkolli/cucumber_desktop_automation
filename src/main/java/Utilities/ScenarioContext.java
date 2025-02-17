package Utilities;

import Enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }

    /*public void setContext(String key, String value) {
        scenarioContext.put(key, value);
    }

    public String getContext(String key) {
        return scenarioContext.get(key);
    }*/
}
