package classes;

public class ListCommand implements Command {
    private final Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void ex() {
        for (Document document : catalog.getDocuments()) {
            System.out.println(document);
        }
    }
}