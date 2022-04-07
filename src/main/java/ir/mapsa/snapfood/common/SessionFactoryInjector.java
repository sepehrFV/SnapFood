package ir.mapsa.snapfood.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryInjector {

    private SessionFactory sessionFactory;
    private Session session;

    public SessionFactoryInjector(){
        super();
    }

    public Session getSession() {

        if (session == null) {
            sessionFactory = new Configuration().buildSessionFactory();
            this.session = sessionFactory.openSession();
        } else this.session = sessionFactory.getCurrentSession();

        return session;

    }
}
