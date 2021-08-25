package vn.nacl.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
    public static final SessionFactory sessionfactory= buildSessionFactory();
    private static SessionFactory buildSessionFactory()
    {
        try
        {
            //tọa ss từ hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable e){
            System.out.println("Init Sesion Factory Fail" + e);
            throw new ExceptionInInitializerError(e);
        }

    }
    public static SessionFactory getSessionFactory()
    {
        return sessionfactory;
    }
}
