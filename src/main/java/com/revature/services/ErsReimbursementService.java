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

	public ErsReimbursement getPastTickets(int ersUsersId) {
		if (reimbDao != null) {
			return reimbDao.viewPastReimbursement(ersUsersId);
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
	
	public byte[] uploadReimb() {
		return reimbDao.uploadReceipt();
	}
	
	public ErsReimbursement filterErsReimbursement(int reimbStatusId) {
		return reimbDao.filterReimb(reimbStatusId);
	}
	
}
