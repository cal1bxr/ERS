package com.revature.services;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Reimbursement;

import java.util.List;

public class ReimbursementServices {
    private ReimbursementDAO reimbDao = new ReimbursementDAOImpl();

    public List<Reimbursement> findAllTickets() {return reimbDao.findAll();}
}
