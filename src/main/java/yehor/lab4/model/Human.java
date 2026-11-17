package yehor.lab4.model;

import java.util.Objects;

public class Human {

    private String firstName;
    private String lastName;
    private String middleName;
    private Sex sex;

    public Human() {
    }

    public Human(String firstName, String lastName, String middleName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getShortName() {
        return lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0) + ".";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Human human = (Human) other;
        return Objects.equals(firstName, human.firstName)
                && Objects.equals(lastName, human.lastName)
                && Objects.equals(middleName, human.middleName)
                && sex == human.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, sex);
    }
    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " (" + sex.getShortName() + ")";
    }
}
