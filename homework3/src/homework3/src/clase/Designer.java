package clase;

import java.time.LocalDate;

// clase.Designer class that extends Person and has a design software property
class Designer extends Person {
    private String designSoftware;

    public Designer(String name, LocalDate birthDate, String designSoftware) {
        super(name, birthDate);
        this.designSoftware = designSoftware;
    }

    public String getDesignSoftware() {
        return designSoftware;
    }
}