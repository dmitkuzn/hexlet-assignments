package exercise;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello!!!");

        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        System.out.println(labelTag.render());
    }
}
