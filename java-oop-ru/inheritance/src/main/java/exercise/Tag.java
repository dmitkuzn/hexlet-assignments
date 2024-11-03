package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public class Tag {
    private HashMap<String, String> tagAttributes;
    protected String tagName;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagAttributes = new LinkedHashMap<>(tagAttributes);
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("<" + tagName);
        tagAttributes.forEach((key, value) -> {
            str.append(" ");
            str.append(key);
            str.append("=\"");
            str.append(value);
            str.append("\"");
        });
        str.append(">");
        return str.toString();
    }


}
// END
