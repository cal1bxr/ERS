package com.revature.repositories;

import com.revature.models.ErsReimbursement;

import java.util.List;

public interface ErsReimbursementDAO {
	public ErsReimbursement findById(int id);
    public boolean addReimbursement(ErsReimbursement reimb);
//    public ErsReimbursement viewPastReimbursement(int ersUsersId);
    public List<ErsReimbursement> viewAllTickets();
    public boolean updateReimb(ErsReimbursement reimb);
//    public Timestamp submitReimb();
//    public Timestamp resolveReimb();
    public boolean describeReimb(ErsReimbursement reimb);
//    public byte[] uploadReceipt();
    public ErsReimbursement filterReimb(int reimbStatusId);
}
