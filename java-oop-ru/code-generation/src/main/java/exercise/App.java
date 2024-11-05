package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println("Hi!!!");

        User user = new User(1, "", "", 2);
        System.out.println(user.toString());

        User owner = new User(1, "Ivan", "P", 25);
        Car car = new Car(1, "bmv", "x5", "black", owner);
        String jsonRepresentation = null;
        try {
            jsonRepresentation = car.serialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonRepresentation);

        Car instance = null;
        try {
            instance = Car.deserialize(jsonRepresentation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(instance.getBrand());
        System.out.println(instance.getModel());

        try {
            Path path1 = Paths.get("/tmp/file1.json");
            Car car1 = new Car(1, "audi", "q3", "black", owner);
            App.save(path1, car1); // Сохраняет представление объекта в файл
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        try {
            Path path2 = Paths.get("/tmp/file2.json");
            Car car2 = App.extract(path2); // Возвращает инстанс класса Car
            car2.getModel(); // "passat"
        } catch(Exception e) {
            System.out.println(e.toString());
        }

    }

    public static void save(Path filePath, Car car) throws IOException {
        Files.writeString(filePath, car.serialize());
    }

    public static Car extract(Path filePath) throws IOException {
        String jsonString = Files.readString(filePath);
        return Car.deserialize(jsonString);
    }
}
// END
