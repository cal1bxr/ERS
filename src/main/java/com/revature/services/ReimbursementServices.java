package com.revature.services;

import java.util.List;

public class ReimbursementServices {
    private ReimbursementDAO reimbDao = new ReimbursementDAOImpl();

    public List<Reimbursement> findAllTickets() {return reimbDao.findAll();}
}
