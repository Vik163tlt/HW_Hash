import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Passport {
    private String number;
    private String name;
    private String surName;
    private String patronymic;
    private String dateOfBirth;

    public Passport(String number, String name, String surName, String patronymic, String dateOfBirth) {
        if (number == null || number.isBlank() || number.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать номер паспорта!");
        } else {
            this.number = number;
        }
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать имя!");
        } else {
            this.name = name;
        }
        if (surName == null || surName.isBlank() || surName.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать отчество!");
        } else {
            this.surName = surName;
        }
        this.patronymic = patronymic;
        if (dateOfBirth == null || dateOfBirth.isBlank() || dateOfBirth.isEmpty()) {
            throw new IllegalArgumentException("Необходимо указать дату рождения!");
        } else {
            this.dateOfBirth = dateOfBirth;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(number, passport.number) &&
                Objects.equals(name, passport.name) &&
                Objects.equals(surName, passport.surName) &&
                Objects.equals(patronymic, passport.patronymic) &&
                Objects.equals(dateOfBirth, passport.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, surName, patronymic, dateOfBirth);
    }

    @Override
    public String toString() {
        return  getSurName() + " " +
                getName() + " " +
                getPatronymic() + " " + ", дата рождения: " +
                getDateOfBirth() + ", номер паспорта: " +
                getNumber() + "\n";
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}