package com.ainosoft.demo.dao;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public final void testGetSessionFactory() {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		assertTrue(factory != null);
	}
}
