package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Document");
        var book = new Document("carte1","Titlu1", "D:\\Facultate" );
        var article = new Document("articol1", "Titlu2", "D:\\Facultate" );
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "D:\\Facultate\\catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("D:\\Facultate\\catalog.json");
        CatalogUtil.view(catalog.findById("articol1"));
        System.out.println(catalog);
    }
}