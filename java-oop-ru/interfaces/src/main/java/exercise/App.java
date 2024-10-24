package exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println("Start lesson 2 home work");
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }

    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        ArrayList<String> homesList = new ArrayList();
        if ((homes != null) && (homes.size() >= n)) {
            ArrayList<Home> apartments = new ArrayList<Home>(homes);
            Collections.sort(apartments, (home1, home2) -> home1.compareTo(home2));
            for (int i = 0; i < n; i++) {
                homesList.add(apartments.get(i).toString());
            }
        }
        return homesList;
    }
}
// END
