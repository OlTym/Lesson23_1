package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date")
    private String data;


    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    public Group() {
    }

    public Group(String name, String data) {
        this.name = name;
        this.data = data;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
      //  student.setGroup(this);
        students.add(student);
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Group{" +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}