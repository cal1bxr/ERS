package com.revature.daos;

import com.revature.models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {
    List<Reimbursement> findAll();
}
