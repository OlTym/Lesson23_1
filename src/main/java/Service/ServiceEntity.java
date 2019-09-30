package Service;

import Dao.Dao;
import Dao.DaoEntity;
import Model.Group;
import Model.Student;

import java.util.List;

public class ServiceEntity implements Service {

    public void addGroup(Group group) {

        Dao dao = new DaoEntity();
        dao.creatGroup(group);
    }

    public void addStudent(Student student) {

        Dao dao = new DaoEntity();
        dao.creatStudent(student);
    }

    public String getStudentsByGroup(Group group) {
        Dao dao = new DaoEntity();
        List<?> list = dao.getStudentByGroup(group);
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Group ").append(group.getName()).append("\n");


        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            Student student = (Student) row[0];
            stringBuilder.append(student.getName()).append(" ").append(student.getAge()).append("\n");


        }
        return stringBuilder.toString();
    }


}
