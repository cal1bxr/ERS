package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {
    public List<Reimbursement> findAll();
}
