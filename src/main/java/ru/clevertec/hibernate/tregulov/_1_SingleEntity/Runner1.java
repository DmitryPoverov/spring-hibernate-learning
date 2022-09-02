package ru.clevertec.hibernate.tregulov._1_SingleEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.clevertec.hibernate.tregulov._1_SingleEntity.entity.Employee;

public class Runner1 {

    public static void main(String[] args) {

/* A shorter variant:
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();*/

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

/* To add a new user to the table in a separate session:
                Employee employee = Employee.builder()
                        .userName("Dolly3")
                        .firstName("Dolly")
                        .lastName("Dawson")
                        .department("Sales")
                        .salary(725)
                        .build();
                session.save(employee);*/

/*To get a user in a separate session:
                Employee dolly1 = session.get(Employee.class, 7L);
                System.out.println(dolly1);*/

/* To get a list of the Employees
                List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
                employees.forEach(System.out::println);*/

/* To get a list of the Employees with a name "Dolly"
                List<Employee> employees = session.createQuery
                                ("from Employee e where e.firstName = :firstName and e.lastName = 'Dawson'", Employee.class)
                        .setParameter("firstName", "Dolly")
                        .list();
                employees.forEach(System.out::println);*/

/* Get a user with id=1 and set to him a new salary
                Employee employee = session.get(Employee.class, 1L);
                System.out.println("********" + employee);
                employee.setSalary(900);
                employee = session.get(Employee.class, 1L);
                System.out.println("********" + employee);*/

/* Changing the salary to all users with name = "Dolly"

// The first variant: get all users and than setSalary():
                List<Employee> employees = session.createQuery("from Employee e where e.firstName = :name", Employee.class)
                        .setParameter("name", "Dolly")
                        .list();
                employees.forEach(e -> e.setSalary(1000));

// The second variant: update Users.salary
                session.createQuery("update Employee e set e.salary = 1500 where e.firstName = :name")
                        .setParameter("name", "Dolly")
                        .executeUpdate();*/

/* To delete user with id = 8
                Employee employee = session.get(Employee.class, 8L);
                session.delete(employee);*/

/* To delete user with name = "test" using QHL
            session.createQuery("delete from Employee e where e.firstName = :name")
                        .setParameter("name", "test")
                        .executeUpdate();*/

                session.getTransaction().commit();
            }
        }
    }
}
