package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println("Hi!!!");

        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage);
        storage.get("key", "default"); // "default"
        storage.get("value", "default"); // "key"

        System.out.println(storage.toMap()); // => {value=key, value2=key2}

    }

    public static void swapKeyValue(KeyValueStorage kvs) {
        for (var entry : kvs.toMap().entrySet()) {
            kvs.unset(entry.getKey());
            kvs.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
