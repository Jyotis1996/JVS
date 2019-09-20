package com.uks.jyoti.struts.common.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Jyoti
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Session session;

	/*public HibernateUtil() {
		sessionFactory = createSessionFactory();
	}*/

	public SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public Session getSession() {
		session = createSessionFactory().getCurrentSession();
		return session;
	}

}