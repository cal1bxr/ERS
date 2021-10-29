package com.revature.services;

import java.util.List;

import com.revature.repositories.ErsReimbursementDaoImpl;

import CurrentlyUnused.ErsReimb;
import CurrentlyUnused.ErsReimb.ReimbStatus;

import com.revature.models.ErsReimbursement;
import com.revature.repositories.ErsReimbursementDAO;

public class ErsReimbursementService {
	private ErsReimbursementDAO reimbDao = new ErsReimbursementDaoImpl();

	public List<ErsReimbursement> getAllTickets() {
		return reimbDao.viewAllTickets();
	}
	
	public List<ErsReimbursement> filterErsReimbursement(ReimbStatus status) {
		List<ErsReimbursement> reimb = reimbDao.getReimbByStatus(status);
		if (reimb != null) {
			return reimb;
		} else {
			return null;
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
	
	public ErsReimbursement getReimbursement(int id) {
		ErsReimbursement reimb = reimbDao.findById(id);
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
		return reimbDao.updateReimbursement(reimb);
	}

}
