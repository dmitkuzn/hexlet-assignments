package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN
import java.util.Map;
import org.junit.jupiter.api.Test;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void testFileKV() {
        FileKV storage = new FileKV("src/test/resources/file", Map.of("key", "value"));

        assertThat(storage.get("key", "default")).isEqualTo("value");
        assertThat(storage.get("hz", "default")).isEqualTo("default");


        storage.set("Key2", "Value2");
        assertThat(storage.get("Key2", "default")).isEqualTo("Value2");


        storage.unset("key");
        assertThat(storage.get("key", "default")).isEqualTo("default");

        Map<String, String> expectedData = Map.of("Key2", "Value2");
        assertThat(storage.toMap()).isEqualTo(expectedData);
    }
    // END
}
