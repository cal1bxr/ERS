package com.revature.controllers;

import java.util.List;

import com.revature.models.ErsReimbursement;
import com.revature.services.ErsReimbursementService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ReimbursementController implements Controller{
	private ErsReimbursementService reimbService = new ErsReimbursementService();
	
	public Handler getAllReimbs = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
		List<ErsReimbursement> list = reimbService.getAllTickets();
		
		ctx.json(list);
		ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
	
//	public Handler getPastTickets = (ctx) -> {
//		if (ctx.req.getSession(false) != null) {
//			try {
//				int id = Integer.parseInt(ctx.pathParam("ersuserid"));
//				ErsReimbursement reimb = reimbService.getPastTickets(id);
//				ctx.json(reimb);
//				ctx.status(200);
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//				ctx.status(406);
//			}
//		} else {
//			ctx.status(401);
//		}
//	};
	
	public Handler addReimb = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			ErsReimbursement reimb = ctx.bodyAsClass(ErsReimbursement.class);
			if(reimbService.addErsReimbursement(reimb)) {
				ctx.status(201);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}	
	};
	
	public Handler updateReimb = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			ErsReimbursement reimb = ctx.bodyAsClass(ErsReimbursement.class);
			if (reimbService.updateErsReimbursement(reimb)) {
				ctx.status(200);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}
	};
	
	public Handler updateDescReimb = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			ErsReimbursement reimb = ctx.bodyAsClass(ErsReimbursement.class);
			if (reimbService.describeErsReimbrusement(reimb)) {
				ctx.status(200);
			} else {
				ctx.status(400);
			}
		} else {
			ctx.status(401);
		}
	};

	

	@Override
	public void addRoutes(Javalin app) {
		// TODO Auto-generated method stub
		app.get("reimbs", this.getAllReimbs);
//		app.get("/reimbs/:tickets", this.getPastTickets);
		app.post("/reimbs", this.addReimb);
		app.put("/reimbs", this.updateReimb);
		app.put("/reimbs/:reimb", this.updateDescReimb);
		
	}
	}
	
	


