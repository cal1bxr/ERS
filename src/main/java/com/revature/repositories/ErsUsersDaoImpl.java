package com.revature.repositories;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.ErsReimbursement;
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
	public List<ErsUsers> getUserId(int ersUsersId) {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsUsers WHERE ErsUsers.ersUserId = " + ersUsersId).list();
	}
	
	@Override
	public ErsUsers getUsername (String ersUsername){
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("FROM ErsUsers WHERE ersUsername= :ersUsername" );
		q.setParameter("ersUsername", ersUsername);
		List<ErsUsers> list = q.list();
		ErsUsers users = list.get(0);
		return users;
	}

	@Override
	public ErsUsers getUserByEmail(String email) {
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("FROM ErsUsers WHERE ersEmail= :userEmail" );
			query.setParameter("userEmail", email);
			List<ErsUsers> list = query.list();
			
		    ErsUsers userEmail = list.get(0);
	        return userEmail;
	}

	@Override
	public ErsUsers getPassword(int ersUsersId) {
		Session session = HibernateUtil.getSession();
		List<ErsUsers> list = session.createQuery(" FROM ErsUsers WHERE ErsUsers.ersUserId = " + ersUsersId).list();
	    ErsUsers user = list.get(0);
	    return user;
	}

	@Override
	public ErsUsers getUserRole(int ersUsersId) {
		Session session = HibernateUtil.getSession();
		List<ErsUsers> list = session.createQuery("FROM ErsUsers WHERE ErsUsers.ersUserId = " + ersUsersId).list();
	    ErsUsers user = list.get(0);
        return user;
	}

	@Override
	public boolean addUser(ErsUsers ersUser) {
		try{
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(ersUser);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		}
			catch (HibernateException e) {
			e.printStackTrace();
			return false;
			}
	}
}
