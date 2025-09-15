package org.api.friend.config;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HibernateUtil {

    public SessionFactory buildSessionFactory() {
        Configuration configuration = buildConfiguration();
        configuration.configure();

        return configuration.buildSessionFactory();
    }

    private Configuration buildConfiguration(){
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        return configuration;
    }
}
