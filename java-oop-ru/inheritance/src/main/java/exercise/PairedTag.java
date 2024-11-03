package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String tagBody;
    private List<Tag> childs;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List childs) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childs = new ArrayList(childs);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        childs.forEach((v) -> {
            str.append(v.toString());
        });
        str.append(tagBody);
        str.append("</" + tagName + ">");
        return str.toString();
    }
}
// END
