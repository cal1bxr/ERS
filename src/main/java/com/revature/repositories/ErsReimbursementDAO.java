package com.revature.repositories;

import com.revature.models.ErsReimbursement;

import CurrentlyUnused.ErsReimb;
import CurrentlyUnused.ErsReimb.ReimbStatus;

import java.sql.Timestamp;
import java.util.List;

public interface ErsReimbursementDAO {
	List<ErsReimbursement> viewAllTickets();
	List<ErsReimbursement> viewPastTickets(int ersUserId);
	List<ErsReimbursement> getReimbByStatus(ErsReimbursement status);
	ErsReimbursement viewPastReimbursement(int ersUsersId);
	ErsReimbursement findById(int reimbId);
    boolean addReimbursement(ErsReimbursement reimb);
    boolean updateReimbursement(ErsReimbursement reimb);
//    public Timestamp resolveReimb()
}
