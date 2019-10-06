import Model.Group;
import Model.Student;
import Service.Service;
import Service.ServiceEntity;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /* Отношение 1:M
     Создать несколько групп
     Добавить несколько студентов в каждую группу
     Список студентов по названию группы (в любом регистре)
 */
    public static void main(String[] args) {


        Group groupJava = new Group("Java", "26.08.19");
        Group groupPhp = new Group("PHP", "21.09.19");
        Group groupRuby = new Group("Ruby", "22.06.19");

        List<Student> studentsJava = new ArrayList<>();
        studentsJava.add(new Student("Alex", 22));
        studentsJava.add(new Student("Norman", 20));
        studentsJava.add(new Student("Ben", 25));
        studentsJava.add(new Student("Natali", 30));

        for (Student student : studentsJava) {

            groupJava.addStudent(student);
            student.setGroup(groupJava);
        }
        List<Student> studentsPhp = new ArrayList<>();
        studentsPhp.add(new Student("Tom", 21));
        studentsPhp.add(new Student("Victor", 35));
        studentsPhp.add(new Student("Juli", 27));
        studentsPhp.add(new Student("Olga", 31));

        for (Student student : studentsPhp) {

            groupPhp.addStudent(student);
            student.setGroup(groupPhp);
        }

        List<Student> studentsRuby = new ArrayList<>();
        studentsRuby.add(new Student("Sandra", 35));
        studentsRuby.add(new Student("Sam", 23));
        studentsRuby.add(new Student("Anna", 27));

        for (Student student : studentsRuby) {

            groupRuby.addStudent(student);
            student.setGroup(groupRuby);
        }

        Service service = new ServiceEntity();

        service.addGroup(groupJava);
        service.addGroup(groupPhp);
        service.addGroup(groupRuby);

        System.out.println(service.getStudentsByGroup("ruby"));
        System.out.println(service.getStudentsByGroup("java"));
        System.out.println(service.getStudentsByGroup("php"));

    }
}
