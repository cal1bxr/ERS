package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementServices;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class ReimbursementController {
    private static Logger log =
            LoggerFactory.getLogger(ReimbursementController.class);
    Scanner scan = new Scanner(System.in);
    private ReimbursementServices reimbService = new ReimbursementServices();

    public void displayAllTickets(){
        System.out.println("Here is a list of the reimbursement tickets");
        List<Reimbursement> list = reimbService.findAllTickets();
        for (Reimbursement reimbursement : list){
            System.out.println((reimbursement));
        }
    }
}
