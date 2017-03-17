/**
 * 
 */
package com.xinxilanr.venus.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xinxilanr.venus.dao.Dao;

/**
 * @author norris
 *
 */
@Repository
public class DaoImpl implements Dao {
//	public Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
	@Override
	public void insert(Serializable entity) {
		//getSession().save(entity);
		System.out.println("Dao");
	}
	
}
