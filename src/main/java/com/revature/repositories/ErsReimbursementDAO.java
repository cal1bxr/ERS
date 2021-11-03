package com.revature.repositories;

import com.revature.models.ErsReimbursement;


import java.util.List;

public interface ErsReimbursementDAO {
	List<ErsReimbursement> viewAllTickets();
	List<ErsReimbursement> viewPastTickets(int ersUserId);
	List<ErsReimbursement> getReimbByStatus(int status);
	ErsReimbursement getReimbById(int id);
	ErsReimbursement findById(int reimbId);
    boolean addReimbursement(ErsReimbursement reimb);
    boolean updateReimbursement(ErsReimbursement reimb);
}
