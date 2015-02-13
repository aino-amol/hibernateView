package com.ainosoft.demo.dao;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionfactory;
	private static Configuration config;
	private static Logger logger = Logger.getLogger(HibernateUtil.class
			.getName());
	
	static {
		try {
			config = new Configuration().configure();
		} catch (final Throwable e) {
			logger.log(Level.SEVERE, "Problem in static block", e);
		}

	}

	public static SessionFactory getSessionFactory() {
		if (HibernateUtil.sessionfactory != null)
			return sessionfactory;

		sessionfactory = HibernateUtil.config.buildSessionFactory();
		return sessionfactory;

	}

}
