package com.ainosoft.demo.dao;

// Generated 13 Feb, 2015 11:15:58 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ainosoft.demo.pojo.Address;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Address.
 * @see com.ainosoft.demo.dao.Address
 * @author Hibernate Tools
 */
public class AddressHome {

	private static final Log log = LogFactory.getLog(Address.class);

	private final SessionFactory sessionFactory = getSessionFactory();
    private Session s;
	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public Address persist(Address transientInstance) {
		log.debug("persisting Address instance");
		try {
			s= HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			Address ad=(Address) s.merge(transientInstance);
			s.getTransaction().commit();
			s.close();
			log.debug("persist successful");
			return ad;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		
	}

	public void attachDirty(Address instance) {
		log.debug("attaching dirty Address instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Address instance) {
		log.debug("attaching clean Address instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Address persistentInstance) {
		log.debug("deleting Address instance");
		try {
			s= HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentInstance);
			s.getTransaction().commit();
			s.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Address merge(Address detachedInstance) {
		log.debug("merging Address instance");
		try {
			Address result = (Address) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Address findById(int id) {
		log.debug("getting Address instance with id: " + id);
		try {
			Address instance = (Address) sessionFactory.getCurrentSession()
					.get("com.ainosoft.demo.dao.Address", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Address> findByExample(Address instance) {
		log.debug("finding Address instance by example");
		try {
			List<Address> results = (List<Address>) s.createCriteria("com.ainosoft.demo.dao.Address").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Address> getList() {
		log.debug("finding Address instance by example");
		try {
			s= HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			List<Address> results = (List<Address>) s.createCriteria("com.ainosoft.demo.dao.Address").list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
