package classes;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {
    private final Document document;
    public ViewCommand(Document document) throws InvalidDataException {
        if (document == null || document.getLocation() == null) {
            throw new InvalidDataException("Invalid document");
        }
        this.document = document;
    }

    @Override
    public void ex() throws IOException {
        try {
            Desktop.getDesktop().open(new File(document.getLocation()));
        } catch (IOException e) {
            throw new IOException("Nu se poate deschide!", e);
        }
    }
}