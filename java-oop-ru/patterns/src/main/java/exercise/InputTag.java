package exercise;

// BEGIN
public class InputTag implements TagInterface{

    private String type;
    private String save;

    @Override
    public String render() {
        return "<input type=\"" + type + "\" value=\"" + save + "\">";
    }

    public InputTag(String type, String save) {
        this.type = type;
        this.save = save;
    }
}
// END
