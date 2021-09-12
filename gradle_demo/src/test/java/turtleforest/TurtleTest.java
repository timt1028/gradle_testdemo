package turtleforest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pirate.Pirate;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurtleTest {

    final String expectedName = "?";

    @Test
    public void test() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("PeopleList.json")).getFile());
        System.out.println(file.getAbsolutePath());
        try {
            String data = FileUtils.readFileToString(file, "UTF-8");
            JSONObject jsonObject = new JSONObject(data);
            JSONArray pirates = jsonObject.optJSONArray("pirates");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Pirate>>() {}.getType();
            List<Pirate> list = gson.fromJson(String.valueOf(pirates), type);
            Optional<Pirate> any = list.stream().filter(o -> expectedName.equalsIgnoreCase(o.getName())).findAny();
            any.ifPresent(pirate -> System.out.println(" ans: " + pirate.getHobby()));
            assertEquals(expectedName, any.isPresent() ? any.get().getName() : "?");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
