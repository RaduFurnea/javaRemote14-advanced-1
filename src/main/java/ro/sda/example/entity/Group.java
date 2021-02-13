package ro.sda.example.entity;

import ro.sda.example.entity.enums.SeniorityLevelEnum;
import ro.sda.example.exception.MaximumNumberOfStudentsReached;
import ro.sda.example.exception.SeniorityLevelInvalid;

import java.util.*;

public class Group {

    private String name;

    private Trainer trainer;

    private Set<Student> students = new HashSet<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrainer(Trainer trainer) throws SeniorityLevelInvalid {
        if (SeniorityLevelEnum.JUNIOR.equals(trainer.getSeniorityLevelEnum())) {
            throw new SeniorityLevelInvalid("Trainer cannot be JUNIOR");
        }
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return this.trainer;
    }

    public void addStudent(Student student) throws MaximumNumberOfStudentsReached {
        if (this.students.size() == 5) {
            throw new MaximumNumberOfStudentsReached("Too many students");
        }
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        // Lambda method of removing elements from list based on a condition
        this.students.removeIf(s -> s.equals(student));

        // Classic if method
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).equals(student)) {
//                students.remove(i);
//            }
//        }

        // Classic iterator method
//        Iterator<Student> iterator = this.students.listIterator();
//        while (iterator.hasNext()) {
//            Student s = iterator.next();
//            if (s.equals(student)) {
//                iterator.remove();
//            }
//        }
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(this.students);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", trainer=" + trainer +
                ", students=" + students +
                '}';
    }
}
