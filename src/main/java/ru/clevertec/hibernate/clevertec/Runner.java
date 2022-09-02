package ru.clevertec.hibernate.clevertec;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.clevertec.hibernate.clevertec.entity.Company;
import ru.clevertec.hibernate.clevertec.entity.Users;
import ru.clevertec.hibernate.clevertec.repository.Repository;
import ru.clevertec.hibernate.clevertec.util.HibernateUtil;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

/* To create a company:
                Company google = Company.builder()
                        .name("Meta")
                        .build();
                session.save(google);*/

/* To get a company:
                Company company1 = session.get(Company.class, 1L);
                System.out.println(company1);*/

                Repository repository = new Repository();

                List<Users> allEmployees = repository.getAllEmployees();
                allEmployees.forEach(e -> System.out.println(e.getUserName() + ", " + e.getCompany().getName()));

                Users userById = repository.getUserById(1L);
                System.out.println(userById);

                List<Users> usersList = repository.getUsersByCompanyName("Meta");
                System.out.println(usersList);

                List<Company> companyNameWithMore4Name = repository.getCompanyNameWithMore5Name();
                System.out.println(companyNameWithMore4Name);

                List<Users> employeesWithNameMore4 = repository.getEmployeesWithNameMore4();
                System.out.println(employeesWithNameMore4);

                session.getTransaction().commit();
            }
        }
    }
}
