package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.ErsUserRoles;
import com.revature.models.ErsUsers;
import com.revature.utils.HibernateUtil;

public class ErsUsersDaoImpl implements ErsUsersDAO {
	private static Logger log = LoggerFactory.getLogger(ErsUsersDaoImpl.class);
	
	@Override
	public List<ErsUsers> getAllUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsUsers").list();
	}

	@Override
	public ErsUsers getUser(int ersUsersId) {
		Session session = HibernateUtil.getSession();
		return session.get(ErsUsers.class, ersUsersId);
	}

	@Override
	public boolean addErsUser(ErsUsers ersUser) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersUser);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public boolean addErsUserRoles(ErsUserRoles ersUser) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersUser);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	};

//	@Override
//	public ErsUsers getByUsername(String ersUsername) {
//		Session session = HibernateUtil.getSession();
//		return session.get(ErsUsers.class, ersUsername);
//	}
//	
//	public ErsUsers getByUsername2(String ersUsername) {
//		Session session = HibernateUtil.getSession();
//		Query q = session.createNativeQuery("SELECT * FROM ersUsers WHERE ers_username = ersUsername");
//		List result = q.list();
//		return q;
//	}
}
