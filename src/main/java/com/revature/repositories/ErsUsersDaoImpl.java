package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.ErsUsers;
import com.revature.utils.HibernateUtil;

public class ErsUsersDaoImpl implements ErsUsersDAO {
	private static Logger log = LoggerFactory.getLogger(ErsUsersDaoImpl.class);
	
	@Override
	public List<ErsUsers> getAllUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("From ErsUsers").list();
	}

	@Override
	public ErsUsers getUser(int ersUsersId) {
		Session session = HibernateUtil.getSession();
		return session.get(ErsUsers.class, ersUsersId);
	};

	@Override
	public ErsUsers getByUsername(String username) {
		ErsUsers ersUser = new ErsUsers();
		if(username.equals(ersUser.getErsUsername())){
			return ersUser;
		}
		return null;
	}
}
