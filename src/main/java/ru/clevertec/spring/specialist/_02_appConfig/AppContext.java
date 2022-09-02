package ru.clevertec.spring.specialist._02_appConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.spring.specialist._01_xml.PersonBean;

@Configuration
public class AppContext {

    @Bean
    public PersonBean personBean() {
        return new PersonBean(18, "Bob_App");
    }
}
