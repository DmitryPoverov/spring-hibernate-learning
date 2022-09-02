package ru.clevertec.hibernate.clevertec.util;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import ru.clevertec.hibernate.clevertec.entity.Company;
import ru.clevertec.hibernate.clevertec.entity.Users;

@UtilityClass
public class HibernateUtil {

    public Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Users.class);
        configuration.addAnnotatedClass(Company.class);             /* I also added this class to hibernate.cfg.xml.*/
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();
        return configuration;
    }

    public SessionFactory buildSessionFactory() {
        return getConfiguration().buildSessionFactory();
    }
}
