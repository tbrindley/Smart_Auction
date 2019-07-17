package com.ally.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
      return new Configuration().configure().buildSessionFactory();
    }
    public static SessionFactory getSessionFactory() {

      return factory;
    }
}
