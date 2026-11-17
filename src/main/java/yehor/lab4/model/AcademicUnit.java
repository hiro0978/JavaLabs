package yehor.lab4.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AcademicUnit unit = (AcademicUnit) other;
        return Objects.equals(name, unit.name) && Objects.equals(head, unit.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head);
    }
}
