package ro.sda.example;

import ro.sda.example.entity.Student;
import ro.sda.example.exception.MaximumNumberOfStudentsReached;
import ro.sda.example.exception.SeniorityLevelInvalid;
import ro.sda.example.repository.Repository;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Repository repo = Repository.getInstance();

    public static void main(String[] args) {
        System.out.println("Printing list sizes...");
        System.out.println(repo.getStudents().size() + " " + repo.getTrainers().size() + " " + repo.getGroups().size());

        putPeopleInGroups();

        System.out.println("----------------- Sorting people from a specific group ---------------------");
        sortPeopleFromGroups(0);

        System.out.println("------------ Printing all students assigned to groups that are under 25 years old ---------------");
        studentsUnder25();
    }

    private static void putPeopleInGroups() {
        try {
            repo.getGroups().get(0).setTrainer(repo.getTrainers().get(0));
            repo.getGroups().get(1).setTrainer(repo.getTrainers().get(0));
            repo.getGroups().get(2).setTrainer(repo.getTrainers().get(1));
            repo.getGroups().get(3).setTrainer(repo.getTrainers().get(2));

            // adding for first group
            // adding same student twice for checking that students are unique in groups
            repo.getGroups().get(0).addStudent(repo.getStudents().get(0));
            repo.getGroups().get(0).addStudent(repo.getStudents().get(0));
            repo.getGroups().get(0).addStudent(repo.getStudents().get(4));
            repo.getGroups().get(0).addStudent(repo.getStudents().get(6));
            repo.getGroups().get(0).addStudent(repo.getStudents().get(9));

            // adding for second group
            repo.getGroups().get(1).addStudent(repo.getStudents().get(1));
            repo.getGroups().get(1).addStudent(repo.getStudents().get(3));
            repo.getGroups().get(1).addStudent(repo.getStudents().get(7));

            // adding for third group
            repo.getGroups().get(2).addStudent(repo.getStudents().get(1));
            repo.getGroups().get(2).addStudent(repo.getStudents().get(2));
            repo.getGroups().get(2).addStudent(repo.getStudents().get(8));
            repo.getGroups().get(2).addStudent(repo.getStudents().get(5));

            // adding for forth group
            repo.getGroups().get(3).addStudent(repo.getStudents().get(2));
            repo.getGroups().get(3).addStudent(repo.getStudents().get(4));
            repo.getGroups().get(3).addStudent(repo.getStudents().get(6));
            repo.getGroups().get(3).addStudent(repo.getStudents().get(8));
//        separate exception handling
//        } catch (SeniorityLevelInvalid sli) {
//            System.out.println("Some trainers don't have the required seniority level. Error message is: " + sli.getMessage());
//            return;
//        } catch (MaximumNumberOfStudentsReached mnsr) {
//            System.out.println("Some groups have reached the max ammount of students. Error message is: " + mnsr.getMessage());
//            return;
//        }

//      generic exception handling with | (pipe) operator
        } catch (SeniorityLevelInvalid | MaximumNumberOfStudentsReached e) {
            System.out.println("Some group error has occurred. Error message is: " + e.getMessage());
            return;
        }

        repo.getGroups().forEach(g -> {
            System.out.println("Trainer is: " + g.getTrainer().getName() + " for group " + g.getName());
            g.getStudents().stream().map(Student::getName).forEach(System.out::println);
            System.out.println("---------------------------------------");
        });
    }

    private static void sortPeopleFromGroups(int index) {
        repo.getGroups().get(index).getStudents().stream().map(Student::getName).sorted().forEach(System.out::println);
    }

    private static void studentsUnder25() {
        Set<Student> students = new HashSet<>();
        repo.getGroups().forEach(g -> students.addAll(g.getStudents()));
        System.out.println("Evaluating age for " + students.size() + " students.");
        students.stream().filter(s -> s.getAge() < 25).forEach(s -> System.out.println(s.getName() + " is " + s.getAge() + " years old."));
    }

}
