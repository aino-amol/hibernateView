package com.ainosoft.demo.dao;

// Generated 13 Feb, 2015 11:15:58 AM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ainosoft.demo.pojo.Addressbook;
import com.ainosoft.demo.pojo.NewView;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Addressbook.
 * 
 * @see com.ainosoft.demo.dao.Addressbook
 * @author Hibernate Tools
 */
public class AddressbookHome {

	private static final Log log = LogFactory.getLog(AddressbookHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();
	private Session s;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Addressbook persist(Addressbook transientInstance) {
		log.debug("persisting Addressbook instance");
		try {
			s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			Addressbook ab = (Addressbook) s.merge(transientInstance);
			s.getTransaction().commit();
			s.close();
			log.debug("persist successful");
			return ab;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Addressbook instance) {
		log.debug("attaching dirty Addressbook instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Addressbook instance) {
		log.debug("attaching clean Addressbook instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Addressbook persistentInstance) {
		log.debug("deleting Addressbook instance");
		try {
			s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			s.delete(persistentInstance);
			s.getTransaction().commit();
			s.close();
			System.out.println("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Addressbook merge(Addressbook detachedInstance) {
		log.debug("merging Addressbook instance");
		try {
			Addressbook result = (Addressbook) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Addressbook findById(java.lang.Integer id) {
		log.debug("getting Addressbook instance with id: " + id);
		try {
			Addressbook instance = (Addressbook) sessionFactory
					.getCurrentSession().get(
							"com.ainosoft.demo.dao.Addressbook", id);
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

	public List<Addressbook> findByExample(Addressbook instance) {
		log.debug("finding Addressbook instance by example");
		try {
			s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			List<Addressbook> results = (List<Addressbook>) s
					.createCriteria("com.ainosoft.demo.dao.Addressbook")
					.add(create(instance)).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Addressbook> getList() {
		log.debug("finding Addressbook instance by example");
		try {
			List<Addressbook> booklist = new ArrayList<Addressbook>();
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Query query = session.createQuery("from Addressbook");
			List<?> list = query.list();
			for (Object obj : list) {
				if (obj instanceof Addressbook) {
					Addressbook ab = (Addressbook) obj;
					booklist.add(ab);
				}
			}
			session.flush();
			session.close();
			return booklist;

		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

}
