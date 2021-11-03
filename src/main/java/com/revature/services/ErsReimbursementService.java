package com.revature.services;

import java.util.List;

import com.revature.repositories.ErsReimbursementDaoImpl;


import com.revature.models.ErsReimbursement;
import com.revature.repositories.ErsReimbursementDAO;

public class ErsReimbursementService {
	private ErsReimbursementDAO reimbDao = new ErsReimbursementDaoImpl();

	public List<ErsReimbursement> getAllTickets() {
		return reimbDao.viewAllTickets();
	}

	public List<ErsReimbursement> getReimbursementByStatus(int status) {
		return reimbDao.getReimbByStatus(status);
	}

	public List<ErsReimbursement> getReimbursementById(int id) {
		return reimbDao.getReimbByStatus(id);
	}

	public List<ErsReimbursement> getPastTickets(int ersUsersId) {
		List<ErsReimbursement> reimb = reimbDao.viewPastTickets(ersUsersId);
		if (reimb != null) {
			return reimb;
		} else {
			return null;
		}
	}

	public boolean addErsReimbursement(ErsReimbursement reimb) {
		return reimbDao.addReimbursement(reimb);
	}

	public boolean updateErsReimbursement(ErsReimbursement reimb) {
		return reimbDao.updateReimbursement(reimb);
	}
}


