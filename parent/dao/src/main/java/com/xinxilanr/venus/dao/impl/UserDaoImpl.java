/**
 * 
 */
package com.xinxilanr.venus.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xinxilanr.venus.dao.UserDao;
import com.xinxilanr.venus.datamodel.User;

/**
 * @author norris
 *
 */
@Repository
public class UserDaoImpl extends DaoImpl implements UserDao {

	@Override
	public User getByEmail(String email) {
		return (User)getSession().createCriteria(User.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
	}

}
