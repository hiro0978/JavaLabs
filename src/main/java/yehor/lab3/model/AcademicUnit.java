package yehor.lab3.model;

/**
 * Базовий клас для будь-якого структурного підрозділу університету:
 * кожен підрозділ має назву та керівника (голову).
 */
public abstract class AcademicUnit {

    private String name;
    private Human head;

    protected AcademicUnit() {
    }

    protected AcademicUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    /**
     * Назва посади голови підрозділу (ректор, декан тощо).
     */
    public abstract String getHeadTitle();
}
