package com.revature.repositories;

import com.revature.models.ErsReimbursement;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

public interface ErsReimbursementDAO {
    public void addReimbursement(ErsReimbursement reimb);
    public int viewPendingReimbursement();
    public List<ErsReimbursement> viewAllTickets();
    public boolean approveDenyReimb();
    public Timestamp submitReimb();
    public Timestamp resolveReimb();
    public String describeReimb();
    public byte[] uploadReceipt();
    public HashMap<Integer, Integer> filterReimb();
}
