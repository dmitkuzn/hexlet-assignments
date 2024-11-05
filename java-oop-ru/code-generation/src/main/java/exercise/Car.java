package exercise;

import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        return jsonString;
    }

    public static Car deserialize(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car deserializedCar = objectMapper.readValue(json, Car.class);
        return deserializedCar;
    }

    // END
}
