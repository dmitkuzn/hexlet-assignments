package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private String filePath;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(initialData));
    }

    private Map<String, String> readData() {
        String data = Utils.readFile(filePath);
        return Utils.deserialize(data);
    }

    private void writeData(Map<String, String> data) {
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> data = readData();
        data.put(key, value);
        writeData(data);
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = readData();
        data.remove(key);
        writeData(data);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = readData();
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return readData();
    }
}
// END
