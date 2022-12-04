package com.mehdilagdimi.marocair_api.util.HibernateUtil;

import com.mehdilagdimi.marocair_api.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public final class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session = null;
    private static Transaction transaction = null;

    private static final Configuration configuration ;
    private static final Properties properties;

    static {
        configuration = new Configuration();
        properties = new Properties();
        properties.setProperty("hibernate.dialect", Config.getDIALECT());
        properties.setProperty("hibernate.connection.driver_class", Config.getDRIVER());
        properties.setProperty("hibernate.connection.url", Config.getURL());
        properties.setProperty("hibernate.connection.username", Config.getUSER());
        properties.setProperty("hibernate.connection.password", Config.getPASSWORD());
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty(" hibernate.connection.pool_size", "10");
        configuration.setProperties(properties);
        configuration
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Flight.class)
                .addAnnotatedClass(Passenger.class)
                .addAnnotatedClass(Reservation.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

//        Call .configure if properties will be read from hibernate-cfg xml file
//        sessionFactory = new Configuration().setProperties(properties).configure().
//                buildSessionFactory();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    public static Session getSession() {
        if(session != null) return session;
        return openSession();
    }

    public static void setSession(Session session) {
        HibernateUtil.session = session;
    }

     public static Transaction getTransaction() {
            return getSession().getTransaction();
        }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public static boolean isConnected(){
        return openSession().isConnected();
    }


    public static void closeSession(){
        session.close();
    }
}
