package com.revature.repositories;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import com.revature.models.ErsReimbursement;
import com.revature.utils.HibernateUtil;

public class ErsReimbursementDaoImpl implements ErsReimbursementDAO {

	@Override
	public void addReimbursement(ErsReimbursement reimb) {
		Session session = HibernateUtil.getSession();
		session.save(reimb);
		HibernateUtil.closeSession();
	}

	@Override
	public int viewPendingReimbursement() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ErsReimbursement> viewAllTickets() {
		Session session = HibernateUtil.getSession();
		List<ErsReimbursement> reimbursements = session.createQuery("From ErsReimbursement").list();
		return reimbursements;
	}

	@Override
	public boolean approveDenyReimb() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Timestamp submitReimb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp resolveReimb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String describeReimb() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] uploadReceipt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Integer> filterReimb() {
		// TODO Auto-generated method stub
		return null;
	}
}
