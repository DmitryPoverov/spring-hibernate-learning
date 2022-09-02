package ru.clevertec.hibernate.clevertec.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.clevertec.hibernate.clevertec.entity.Company;
import ru.clevertec.hibernate.clevertec.entity.Users;
import ru.clevertec.hibernate.clevertec.util.HibernateUtil;

import java.util.List;

public class Repository {

    public List<Users> getAllEmployees() {
        List<Users> users;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                users = session.createQuery("select e from Users e", Users.class).list();

            }
        }
        return users;
    }

    public Users getUserById(long id) {
        List<Users> users;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                users = session.createQuery("select e from Users e where id = :id", Users.class)
                        .setParameter("id", id)
                        .list();

            }
        }
        return users.get(0);
    }

    public List<Users> getUsersByCompanyName(String name) {
        List<Users> users;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                users = session.createQuery("select u from Users u join u.company c where c.name = :name", Users.class)
                        .setParameter("name", name)
                        .list();
            }
        }
        return users;
    }

    public List<Company> getCompanyNameWithMore5Name() {
        List<Company> companies;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                companies = session.createQuery("select c from Company c where length(c.name) > 5", Company.class)
                        .list();
            }
        }
        return companies;
    }

    public List<Users> getEmployeesWithNameMore4() {
        List<Users> users;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                users = session.createNativeQuery("SELECT * FROM clevertec_users e where length(e.user_name) > 4", Users.class)
                        .list();
            }
        }
        return users;
    }
}
