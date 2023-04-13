package classes;
import com.fasterxml.jackson.databind.*;
import java.io.File;
import java.io.IOException;


public class CatalogUtil {
    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public static Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Catalog.class);
    }

    public static void view(Document doc) {
        System.out.println(doc);
    }

}
