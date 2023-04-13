package classes;
import classes.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, CommandException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("421", "article1", "D:\\Facultate");
        var article = new Document("324", "book1", "D:\\Facultate");
        Command addBookCommand = new AddCommand(catalog, book);
        Command addArticleCommand = new AddCommand(catalog, article);
        Command listCommand = new ListCommand(catalog);
        Command viewCommand = new ViewCommand(book);
        Command reportCommand = new ReportCommand(catalog, "app.html");

        addBookCommand.ex();
        addArticleCommand.ex();
        listCommand.ex();
        viewCommand.ex();
        reportCommand.ex();
    }
}
