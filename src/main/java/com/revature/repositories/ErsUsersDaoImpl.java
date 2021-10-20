package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ErsUsers;
import com.revature.utils.HibernateUtil;

public class ErsUsersDaoImpl implements ErsUsersDAO {
    @Override
    public List<ErsUsers> getAllUsers() {
    	Session session = HibernateUtil.getSession();
    	List<ErsUsers> users = session.createQuery("From ErsUsers").list();
        return users;
    }
    
    @Override
    public ErsUsers getUser(int ersUsersId) {
		Session session = HibernateUtil.getSession();
		ErsUsers user = session.get(ErsUsers.class, ersUsersId);
    	return user;
    	
    };

    @Override
    public boolean userLogin(String ersUsername, String ersPassword) {
    	Session session = HibernateUtil.getSession();
    	ErsUsers user = session.get(ErsUsers.class, ersUsername);
    	ErsUsers pass = session.get(ErsUsers.class, ersPassword);
    	String username = user.getErsUsername();
    	String password = user.getErsPassword();
    	if((ersUsername.equals(username) && (ersPassword.equals(password)))) {
    		return true;
    	} else {
    		System.out.println("Invalid login");
    	}
    	
        return false;
    }

	@Override
	public void insert(ErsUsers user) {
		Session session = HibernateUtil.getSession();
		session.save(user);
		HibernateUtil.closeSession();
	}

	@Override
	public void update(ErsUsers user) {
		Session session = HibernateUtil.getSession();
		session.merge(user);
		HibernateUtil.closeSession();		
	}

	@Override
	public void delete(ErsUsers user) {
		Session session = HibernateUtil.getSession();
		session.delete(user);
		HibernateUtil.closeSession();		
	}

}
