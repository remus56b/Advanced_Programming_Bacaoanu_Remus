package clase;

import clase.Person;

import java.time.LocalDate;
/**
 * Represents a programmer in a social network.
 */
class Programmer extends Person {
    private String programmingLanguage;

    /**
     * Creates a new programmer with the given name, birth date, and programming language.
     *
     * @param name      the name of the programmer
     * @param birthDate the birth date of the programmer
     * @param programmingLanguage  the programming language that the programmer knows
     */
    public Programmer(String name, LocalDate birthDate, String programmingLanguage) {
        super(name, birthDate);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}