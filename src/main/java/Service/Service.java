package Service;

import Model.Group;
import Model.Student;

public interface Service {

    void addGroup(Group group);

    void addStudent(Student student);

    String getStudentsByGroup(String nameGroup);


}
