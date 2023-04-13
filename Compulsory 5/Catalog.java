package org.example;
import java.io.Serializable;
import java.util.*;

import static java.util.Locale.filter;

public class Catalog implements Serializable {
    private String name;

    private List<Document> docs = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }
    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Document document) {
        this.docs.add(document) ;
    }

}

