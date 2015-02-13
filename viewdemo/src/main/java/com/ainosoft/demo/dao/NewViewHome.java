package com.ainosoft.demo.dao;

// Generated 13 Feb, 2015 11:15:58 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ainosoft.demo.pojo.NewView;
import com.ainosoft.demo.pojo.NewViewId;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class NewView.
 * 
 * @see com.ainosoft.demo.dao.NewView
 * @author Hibernate Tools
 */
public class NewViewHome {

	private static final Log log = LogFactory.getLog(NewViewHome.class);
	private final SessionFactory sessionFactory = getSessionFactory();
	private Session s;

	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public NewView persist(NewView transientInstance) {
		log.debug("persisting NewView instance");
		try {
			s = HibernateUtil.getSessionFactory().openSession();
			s.beginTransaction();
			NewView nv = (NewView) s.merge(transientInstance);
			s.getTransaction().commit();
			s.close();
			log.debug("persist successful");
			return nv;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	
	public void attachDirty(NewView instance) {
		log.debug("attaching dirty NewView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewView instance) {
		log.debug("attaching clean NewView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(NewView persistentInstance) {
		log.debug("deleting NewView instance");
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

	public NewView merge(NewView detachedInstance) {
		log.debug("merging NewView instance");
		try {
			NewView result = (NewView) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public NewView findById(NewViewId id) {
		log.debug("getting NewView instance with id: " + id);
		try {
			s = HibernateUtil.getSessionFactory().openSession();
			NewView instance = (NewView) s.get("com.ainosoft.demo.dao.NewView", id);
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

	public List<NewView> findByExample(NewView instance) {
		log.debug("finding NewView instance by example");
		try {
			s = HibernateUtil.getSessionFactory().openSession();
			List<NewView> results = (List<NewView>) s.createCriteria("com.ainosoft.demo.dao.NewView").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<NewView> getList() {
		log.debug("finding NewView instance by example");
		try {
			s = HibernateUtil.getSessionFactory().openSession();
			List<NewView> results = (List<NewView>) s.createCriteria("com.ainosoft.demo.dao.NewView").list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
