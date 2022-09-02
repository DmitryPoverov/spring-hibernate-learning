package ru.clevertec.hibernate.tregulov._2_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.clevertec.hibernate.tregulov._2_OneToOne.entity.Detail;
import ru.clevertec.hibernate.tregulov._2_OneToOne.entity.Employee;

public class Runner2 {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Detail.class);

        try (SessionFactory factory = configuration.buildSessionFactory()) {
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

/* To add a user and details to DB
                Detail detail = Detail.builder()
                        .city("Town8")
                        .phoneNumber("123-45-67")
                        .email("test8@test.com")
                        .build();
                Employee employee = Employee.builder()
                        .userName("TestName")
                        .firstName("FNAme")
                        .lastName("LName")
                        .department("Test")
                        .salary(11111)
                        .detail(detail)
                        .build();
                session.save(employee);*/

/* To get a user from DB and, thanks to cascade, we get and his details
                Employee employee = session.get(Employee.class, 8L);
                System.out.println(employee.getDetail());*/

/* To delete a user from DB and, thanks to cascade, we delete and his details
                Employee employee = session.get(Employee.class, 8L);
                session.delete(employee);*/

/* To add a new detail and automatically a new user
                Detail detail = Detail.builder()
                        .city("Town10")
                        .phoneNumber("101-01-01")
                        .email("test10@test.com")
                        .build();
                Employee employee = Employee.builder()
                        .userName("TestName10")
                        .firstName("FNAme10")
                        .lastName("LName10")
                        .department("Test10")
                        .salary(1010)
                        .build();
//                detail.setEmployee(employee);
                employee.setDetail(detail);
                session.save(employee);*/

/* To get a detail and automatically get its user
            Detail detail = session.get(Detail.class, 1);
            System.out.println(detail.getEmployee());*/

/* To delete a detail and automatically delete its user
            Detail detail = session.get(Detail.class, 11);
            session.delete(detail);*/
                session.getTransaction().commit();
            }
        }
    }
}
