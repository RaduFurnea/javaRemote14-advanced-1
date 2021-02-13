package ro.sda.example.repository;

import ro.sda.example.entity.Group;
import ro.sda.example.entity.Student;
import ro.sda.example.entity.Trainer;
import ro.sda.example.entity.enums.SeniorityLevelEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Lazy initialization singleton. Class is initialized only the first time it's requested.
 * In EAGER initialization singleton, class is initialized at class load time in JVM.
 */
public class Repository {

    // EAGER

//    private final static Repository repository = new Repository();
//
//    private Repository() {}
//
//    public static Repository getInstance() {
//        return repository;
//    }

    // LAZY ----------------------------------------

    private static Repository repository;

    private Repository() {
        this.populateGroups();
        this.populateStudents();
        this.populateTrainers();
    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    private List<Student> students = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private List<Trainer> trainers = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    private void populateTrainers() {
        this.trainers.add(new Trainer("Paul", LocalDate.of(1990, 2, 13), SeniorityLevelEnum.MID));
        this.trainers.add(new Trainer("Ana", LocalDate.of(1992, 6, 3), SeniorityLevelEnum.SENIOR));
        this.trainers.add(new Trainer("Mihai", LocalDate.of(1985, 10, 22), SeniorityLevelEnum.SENIOR));
    }

    private void populateGroups() {
        this.groups.add(new Group("JavaRemote14"));
        this.groups.add(new Group("TestingCluj"));
        this.groups.add(new Group("AngularBrasov"));
        this.groups.add(new Group("PythonPloiesti"));
    }

    private void populateStudents() {
        this.students.add(new Student.Builder()
                .name("Marian")
                .hasPreviousJavaKnowledge(true)
                .dateOfBirth(LocalDate.of(2000, 12, 30))
                .build());
        this.students.add(new Student.Builder()
                .name("Corina")
                .hasPreviousJavaKnowledge(false)
                .dateOfBirth(LocalDate.of(1982, 2, 5))
                .build());
        this.students.add(new Student.Builder()
                .name("Andreea")
                .hasPreviousJavaKnowledge(true)
                .dateOfBirth(LocalDate.of(1998, 6, 12))
                .build());
        this.students.add(new Student.Builder()
                .name("Marius")
                .hasPreviousJavaKnowledge(false)
                .dateOfBirth(LocalDate.of(1982, 2, 5))
                .build());
        this.students.add(new Student.Builder()
                .name("Razvan")
                .hasPreviousJavaKnowledge(false)
                .dateOfBirth(LocalDate.of(1990, 11, 22))
                .build());
        this.students.add(new Student.Builder()
                .name("Cosmin")
                .hasPreviousJavaKnowledge(true)
                .dateOfBirth(LocalDate.of(1985, 9, 30))
                .build());
        this.students.add(new Student.Builder()
                .name("Paula")
                .hasPreviousJavaKnowledge(false)
                .dateOfBirth(LocalDate.of(1989, 1, 1))
                .build());
        this.students.add(new Student.Builder()
                .name("Pavel")
                .hasPreviousJavaKnowledge(true)
                .dateOfBirth(LocalDate.of(1994, 4, 20))
                .build());
        this.students.add(new Student.Builder()
                .name("Raluca")
                .hasPreviousJavaKnowledge(true)
                .dateOfBirth(LocalDate.of(1999, 10, 10))
                .build());
        this.students.add(new Student.Builder()
                .name("Adrian")
                .hasPreviousJavaKnowledge(false)
                .dateOfBirth(LocalDate.of(1995, 8, 5))
                .build());
    }
}
