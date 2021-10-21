package com.revature.controllers;

import java.util.List;

import com.revature.models.ErsReimbursement;
import com.revature.services.ErsReimbursementService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController implements Controller{
	private ErsReimbursementService reimbService = new ErsReimbursementService();
	
	public Handler getAllReimbs = (ctx) -> {
		List<ErsReimbursement> list = reimbService.getAllTickets();
		
		ctx.json(list);
		ctx.status(200);
	};
	
	public Handler pastTickets = (ctx) -> {
		try {
			String idString = ctx.pathParam("ers_user_id");
			int ersUserId = Integer.parseInt(idString);
			ErsReimbursement reimb = reimbService.getPastTickets(ersUserId);
			ctx.json(reimb);
			ctx.status(200);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			ctx.status(406);
		}
	};
	
	public Handler addReimb = (ctx) -> {
		ErsReimbursement reimb = ctx.bodyAsClass(ErsReimbursement.class);
		if(reimbService.addErsReimbursement(reimb)) {
			ctx.status(201);
		} else {
			ctx.status(400);
		}
	};
	
	public Handler updateReimb = (ctx) -> {
		ErsReimbursement reimb = ctx.bodyAsClass(ErsReimbursement.class);
		if (reimbService.updateErsReimbursement(reimb)) {
			ctx.status(200);
		} else {
			ctx.status(400);
		}
	};
	
	public Handler updateDescReimb = (ctx) -> {
		ErsReimbursement reimb = ctx.bodyAsClass(ErsReimbursement.class);
		if (reimbService.describeErsReimbrusement(reimb)) {
			ctx.status(200);
		} else {
			ctx.status(400);
		}
	};

	@Override
	public void addRoutes(Javalin app) {
		// TODO Auto-generated method stub
		app.get("reimbursements", this.getAllReimbs);
		app.get("/reimbursements/:tickets", this.pastTickets);
		app.post("/reimbursements", this.addReimb);
		app.put("/reimbursements", this.updateReimb);
		app.put("/reimbursements/:reimb", this.updateDescReimb);
		
	}
	
	

}
