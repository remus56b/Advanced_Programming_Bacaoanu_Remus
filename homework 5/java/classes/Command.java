package classes;

import java.io.IOException;

public interface Command {
    void ex() throws IOException, CommandException;
}
