package com.uks.assignment1.common.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static Session session;

	public SessionFactory createSessionFactory() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public Session getSession() {
		session = createSessionFactory().getCurrentSession();
		return session;
	}

}