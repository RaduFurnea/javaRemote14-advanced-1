package ro.sda.example.entity;

import java.time.LocalDate;
import java.time.Period;

public class Student extends Person {

    private boolean hasPreviousJavaKnowledge;

    private int age;

    private Student() {
    }

    public boolean isHasPreviousJavaKnowledge() {
        return hasPreviousJavaKnowledge;
    }

    public void setHasPreviousJavaKnowledge(boolean hasPreviousJavaKnowledge) {
        this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
    }

    public int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    public static class Builder {

        private String name;
        private LocalDate dateOfBirth;
        private boolean hasPreviousJavaKnowledge;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder hasPreviousJavaKnowledge(boolean hasPreviousJavaKnowledge) {
            this.hasPreviousJavaKnowledge = hasPreviousJavaKnowledge;
            return this;
        }

        public Student build() {
            Student s = new Student();
            s.setName(this.name);
            s.setDateOfBirth(this.dateOfBirth);
            s.setHasPreviousJavaKnowledge(this.hasPreviousJavaKnowledge);
            return s;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "hasPreviousJavaKnowledge=" + hasPreviousJavaKnowledge +
                ", age=" + age +
                "} " + super.toString();
    }


}
