package exercise;

import java.util.Map;
import exercise.SingleTag;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("Hi!");
        Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
        System.out.println(img.toString());


        Tag p = new PairedTag(
                "p",
                Map.of("id", "abc"),
                "Text paragraph",
                new ArrayList<Tag>()
        );

        p.toString(); // <p id="abc">Text paragraph</p>

        Tag div = new PairedTag(
                "div",
                Map.of("class", "y-5"),
                "",
                List.of(
                        new SingleTag("br", Map.of("id", "s")),
                        new SingleTag("hr", Map.of("class", "a-5"))
                )
        );

        System.out.println(div.toString());



    }
}
