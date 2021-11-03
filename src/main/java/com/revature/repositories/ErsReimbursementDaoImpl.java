package com.revature.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ErsReimbursement;
import com.revature.utils.HibernateUtil;


public class ErsReimbursementDaoImpl implements ErsReimbursementDAO {

	@Override
	public List<ErsReimbursement> viewAllTickets() {
		Session session = HibernateUtil.getSession();
		List<ErsReimbursement> list = session.createQuery("FROM ErsReimbursement").list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public List<ErsReimbursement> viewPastTickets(int reimbAuthor) {
		Session session = HibernateUtil.getSession();
		List<ErsReimbursement> list =  session.createQuery("FROM ErsReimbursement WHERE reimbAuthor = '" + reimbAuthor + "'").list();
		HibernateUtil.closeSession();
		return list;

	}

	@Override
	public List<ErsReimbursement> getReimbByStatus(int status) {
		Session session = HibernateUtil.getSession();
		List<ErsReimbursement> list = session.createQuery("FROM ErsReimbursement WHERE reimbStatusId = " + status).list();
		HibernateUtil.closeSession();
		return list;
	}

	@Override
	public List<ErsReimbursement> getReimbById(int id) {
		Session session = HibernateUtil.getSession();
		List<ErsReimbursement> list = session.createQuery("FROM ErsReimbursement WHERE reimbId = " + id).list();
		List<ErsReimbursement> firstIndex = (List<ErsReimbursement>) list.get(0);
		HibernateUtil.closeSession();
		return firstIndex;
	}

	@Override
	public ErsReimbursement findById(int reimbId) {
		Session session = HibernateUtil.getSession();
		ErsReimbursement ersReimb = session.get(ErsReimbursement.class, reimbId);
		HibernateUtil.closeSession();
		return ersReimb;
	}

	@Override
	public boolean addReimbursement(ErsReimbursement reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(reimb);
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
			session.update(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}	
}
