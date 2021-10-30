package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ErsReimbursement;
import com.revature.utils.HibernateUtil;

import CurrentlyUnused.ErsReimb;
import CurrentlyUnused.ErsReimb.ReimbStatus;

public class ErsReimbursementDaoImpl implements ErsReimbursementDAO {

	@Override
	public List<ErsReimbursement> viewAllTickets() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsReimbursement").list();
	}

	@Override
	public List<ErsReimbursement> viewPastTickets(int ersUserId) {
		Session session = HibernateUtil.getSession();
		Query q = session.createQuery("FROM ErsReimbursement WHERE ReimbAuthor = :id" );
		q.setParameter("id", ersUserId);
		List<ErsReimbursement> list = q.list();
		ErsReimbursement reimbs = list.get(0);
		return reimbs;
	}

	@Override
	public List<ErsReimbursement> getReimbByStatus(ErsReimbursement status) {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM Ers_Reimbursement WHERE Reimb_StatId = " + status).list();
	}

	@Override
	public ErsReimbursement viewPastReimbursement(int ersUsersId) {
		Session session = HibernateUtil.getSession();
		return session.get(ErsReimbursement.class, ersUsersId);
	}

	@Override
	public ErsReimbursement findById(int reimbId) {
		Session session = HibernateUtil.getSession();
		return session.get(ErsReimbursement.class, reimbId);
	}

	@Override
	public boolean addReimbursement(ErsReimbursement reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateReimbursement(ErsReimbursement reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}	
}
