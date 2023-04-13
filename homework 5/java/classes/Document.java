package classes;

import java.io.Serializable;
import java.util.*;

public class Document  {
    private String id;
    private String title;
    private String location;



    public Document(String id, String title, String location) {

        this.id = id;
        this.title = title;
        this.location = location;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location)  {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location +
                '}';
    }
}
