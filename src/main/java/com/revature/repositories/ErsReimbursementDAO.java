package com.revature.repositories;

import com.revature.models.ErsReimbursment;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface ErsReimbursementDAO {
    public double addReimbursement();
    public int viewPendingReimbursement();
    public List<ErsReimbursment> viewAllTickets();
    public boolean approveDenyReimb();
    public Timestamp submitReimb();
    public Timestamp resolveReimb();
    public String describeReimb();
    public byte[] uploadReceipt();
}
