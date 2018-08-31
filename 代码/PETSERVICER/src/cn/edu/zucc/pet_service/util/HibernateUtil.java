package cn.edu.zucc.pet_service.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @Author JiangLR
 * @Time 2018-08-31 18:52
 */
public class HibernateUtil {
    private static final Configuration CONFIGURATION;
    private static final SessionFactory SESSION_FACTORY;

    static {
        CONFIGURATION = new Configuration().configure();
        SESSION_FACTORY = CONFIGURATION.buildSessionFactory();
    }

    public static Session openSession() {
        return SESSION_FACTORY.openSession();
    }
}
