package org.json;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {

    private final Map<String, Object> map;

    public JSONObject() {
        this.map = new HashMap<>();
    }

    public void put(String key, Object value) {
        this.map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    public boolean containsKey(String key) {
        return this.map.containsKey(key);
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}
