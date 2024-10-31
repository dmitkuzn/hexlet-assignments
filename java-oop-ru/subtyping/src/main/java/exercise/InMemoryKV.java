package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {

    private Map<String, String> values;

    public InMemoryKV(Map<String, String> map) {
        this.values = new HashMap<String, String>(map);
    }

    public void set(String key, String value) {
        values.put(key, value);
    }

    public void unset(String key) {
        values.remove(key);
    }

    public String get(String key, String defaultValue) {
        return values.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return new HashMap<String, String>(values);
    }
}
// END
