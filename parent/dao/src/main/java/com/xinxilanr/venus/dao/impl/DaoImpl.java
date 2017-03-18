/**
 * 
 */
package com.xinxilanr.venus.dao.impl;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xinxilanr.venus.dao.Dao;
import com.xinxilanr.venus.datamodel.BaseEntity;

/**
 * @author norris
 *
 */
@Repository
public class DaoImpl implements Dao {
	@Resource
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	protected Session getSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}
	@Override
	public void insert(BaseEntity entity) {
		getSession().save(entity);
	}
	public int delete(BaseEntity c) {
		Session session = getSession();
		return Optional.ofNullable(session.get(c.getClass(), c.getId()))
				       .map(o -> {session.delete(0); return 1;})
				       .orElse(0);
	}
	public void update(BaseEntity entity) {
		getSession().update(entity);
	}
	public BaseEntity find(Class<? extends BaseEntity> c, Serializable id) {
		return getSession().get(c, id);
	}
}
