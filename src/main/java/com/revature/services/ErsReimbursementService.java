package com.revature.services;

import java.util.List;

import com.revature.models.ErsReimbursement;
import com.revature.repositories.ErsReimbursementDaoImpl;
import com.revature.repositories.ErsReimbursementDAO;

public class ErsReimbursementService {
	private ErsReimbursementDAO reimbDao = new ErsReimbursementDaoImpl();

	public List<ErsReimbursement> getAllTickets() {
		return reimbDao.viewAllTickets();
	}
	
	public ErsReimbursement getReimb(int id) {
		ErsReimbursement reimb = reimbDao.findById(id);
		if (reimb != null) {
			return reimb;
		} else {
			return new ErsReimbursement();
		}
	}

	public ErsReimbursement getPastTickets(int ersUsersId) {
		ErsReimbursement reimb = reimbDao.viewPastReimbursement(ersUsersId);
		if (reimb != null) {
			return reimb;
		} else {
			return new ErsReimbursement();
		}
	}
	
	public boolean addErsReimbursement(ErsReimbursement reimb) {
		return reimbDao.addReimbursement(reimb);
	}
	
	public boolean updateErsReimbursement(ErsReimbursement reimb) {
		return reimbDao.updateReimb(reimb);
	}
	
	public boolean describeErsReimbrusement(ErsReimbursement reimb) {
		return reimbDao.describeReimb(reimb);
	}
	
//	public byte[] uploadReimb() {
//		return reimbDao.uploadReceipt();
//	}
	
	public ErsReimbursement filterErsReimbursement(int reimbStatusId) {
		ErsReimbursement reimb = reimbDao.viewPastReimbursement(reimbStatusId);
		if (reimb != null) {
			return reimb;
		} else {
			return new ErsReimbursement();
		}
	}
	
}
