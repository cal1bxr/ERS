package com.revature.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.ErsReimbursement;
import com.revature.models.ErsReimbursementStatus;
import com.revature.models.ErsReimbursementType;
import com.revature.models.ErsUsers;
import com.revature.utils.HibernateUtil;

public class ErsReimbursementDaoImpl implements ErsReimbursementDAO {

	@Override
	public List<ErsReimbursement> viewAllTickets() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM ErsReimbursement").list();
//		for (ErsReimbursement r : reimbList) {
//			ErsUsers ersUser = session.get(ErsUsers.class, r.getReimbAuthor());
//			System.out.println(ersUser);
//		}
//		
//		return reimbList;
	}

	@Override
	public ErsReimbursement findById(int id) {
		Session session = HibernateUtil.getSession();
		return session.get(ErsReimbursement.class, id);
	}
	
//	@Override
//	public ErsReimbursement viewPastReimbursement(int ersUsersId) {
//		Session session = HibernateUtil.getSession();
//		return session.get(ErsReimbursement.class, ersUsersId);
//	}

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
			return false;
		}
	}

	@Override
	public boolean updateReimb(ErsReimbursement reimb) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

//	@Override
//	public Timestamp submitReimb() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Timestamp resolveReimb() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean describeReimb(ErsReimbursement reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.merge(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

//	@Override
//	public byte[] uploadReceipt() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ErsReimbursement filterReimb(int reimbStatusId) {
		Session session = HibernateUtil.getSession();
		return session.get(ErsReimbursement.class, reimbStatusId);
	}

	@Override
	public boolean addReimbursementStatus(ErsReimbursementStatus reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public boolean addReimbursementType(ErsReimbursementType reimb) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			session.save(reimb);
			tx.commit();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
