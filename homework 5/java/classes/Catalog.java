package classes;
import java.io.Serializable;
import java.util.*;
public class Catalog  {
    private final String name;
    private final List<Document> documents;


    public Catalog(String name) {
        this.name = name;
        this.documents = new ArrayList<>();
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public Document findById(String id) throws InvalidDataException {
        if (id == null || id.isEmpty()) {
            throw new InvalidDataException("Invalid id!");
        }
        for (var doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", documents=" + documents +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocuments() {
        return documents;
    }
}


