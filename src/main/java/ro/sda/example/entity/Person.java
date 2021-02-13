package ro.sda.example.entity;

import java.time.LocalDate;

public abstract class Person {

    private String name;

    // LocalDate - 2021-02-13
    // LocalDateTime - 2021-02-13 09:31
    // LocalTime - 09:31
    // ZonedDateTime - 2021-02-13 09:31 +02:00
    private LocalDate dateOfBirth;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
