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
	public boolean userLogin(String ersUsername, String ersPassword) {
		try {
			Session session = HibernateUtil.getSession();
			ErsUsers user = session.get(ErsUsers.class, ersUsername);
			ErsUsers pass = session.get(ErsUsers.class, ersPassword);
			String username = user.getErsUsername();
			String password = user.getErsPassword();
			HibernateUtil.closeSession();
			if ((ersUsername.equals(username) && (ersPassword.equals(password)))) {
				return true;
			} 
			log.info("Login succesful");
			return true;
		} catch (HibernateException e) {
			log.warn("Username not in database");
			e.printStackTrace();
			return false;
		}
	}

//	@Override
//	public void insert(ErsUsers user) {
//		Session session = HibernateUtil.getSession();
//		session.save(user);
//		HibernateUtil.closeSession();
//	}
//
//	@Override
//	public void update(ErsUsers user) {
//		Session session = HibernateUtil.getSession();
//		session.merge(user);
//		HibernateUtil.closeSession();		
//	}
//
//	@Override
//	public void delete(ErsUsers user) {
//		Session session = HibernateUtil.getSession();
//		session.delete(user);
//		HibernateUtil.closeSession();		
//	}

}
