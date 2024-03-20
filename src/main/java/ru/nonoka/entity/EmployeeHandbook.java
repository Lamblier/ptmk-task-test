package ru.nonoka.entity;

import java.time.LocalDate;

public class EmployeeHandbook {

    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDay;
    private Gender gender;

    public EmployeeHandbook(long id, String firstName, String lastName, String patronymic, LocalDate birthDay, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Gender getSex() {
        return gender;
    }

    public void setSex(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "EmployeeHandbook{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                '}';
    }
}
