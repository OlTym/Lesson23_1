package Dao;

import Model.Group;
import Model.Student;
import Service.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DaoEntity implements Dao {


    @Override
    public void creatGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
        }
    }

    @Override
    public void creatStudent(Student student) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    public List<?> getStudentByGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            List<?> list = session.createQuery("From Student as s inner join Group as g on s.group = g.id where g.name=:name")
                    .setParameter("name", group.getName()).list();

            return list;
        }


    }


}
