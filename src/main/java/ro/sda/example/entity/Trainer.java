package ro.sda.example.entity;

import ro.sda.example.entity.enums.SeniorityLevelEnum;

import java.time.LocalDate;

public class Trainer extends Person {

    private SeniorityLevelEnum seniorityLevelEnum;

    public Trainer(String name, LocalDate dateOfBirth, SeniorityLevelEnum seniorityLevelEnum) {
        super(name, dateOfBirth);
        this.seniorityLevelEnum = seniorityLevelEnum;
    }

    public SeniorityLevelEnum getSeniorityLevelEnum() {
        return seniorityLevelEnum;
    }

    public void setSeniorityLevelEnum(SeniorityLevelEnum seniorityLevelEnum) {
        this.seniorityLevelEnum = seniorityLevelEnum;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "seniorityLevelEnum=" + seniorityLevelEnum +
                "} " + super.toString();
    }
}
