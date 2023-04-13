package classes;

public class AddCommand implements Command {
    private final Catalog catalog;
    private final Document document;

    public AddCommand(Catalog catalog, Document document)  {

        this.catalog = catalog;
        this.document = document;
    }

    @Override
    public void ex()  {
        catalog.add(document);
    }
}
