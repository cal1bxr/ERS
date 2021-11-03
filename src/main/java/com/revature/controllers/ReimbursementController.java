package com.revature.controllers;

import java.util.List;

import com.revature.models.ErsReimbursement;
import com.revature.repositories.ErsReimbursementDAO;
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
		
	public Handler getReimbTicket = (ctx) -> {
		try {
			String reimbursement = ctx.pathParam("ticket");
			int id = Integer.parseInt(reimbursement);
			ErsReimbursement reimb = reimbService.getReimbursementById(id);
			ctx.json(reimb);
			ctx.status(200);			
		}catch(NumberFormatException e){
			e.printStackTrace();
			ctx.status(406);
		}
	};

	public Handler getReimbStatus = (ctx) -> {
		try {
			String idString = ctx.pathParam("status");
			int status = Integer.parseInt(idString);
			List<ErsReimbursement> list = reimbService.getReimbursementByStatus(status);
			ctx.json(list);
			ctx.status(200);
		} catch (NumberFormatException e){
			e.printStackTrace();
			ctx.status(406);
		}
	};
	
	public Handler getPastTickets = (ctx) -> {
		if (ctx.req.getSession(false) != null) {
			try {
				String reimbursement = ctx.pathParam("userId");
				int id = Integer.parseInt(reimbursement);
				List<ErsReimbursement> reimb = reimbService.getPastTickets(id);
				ctx.json(reimb);
				ctx.status(200);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				ctx.status(406);
			}
			} else {
			ctx.status(401);
		}
	};
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
			if(reimbService.updateErsReimbursement(reimb)) {
				ctx.status(201);
			} else {
				ctx.status(400);
			}
		}
		else {
			ctx.status(401);
		}
	};

	@Override
	public void addRoutes(Javalin app) {
		// TODO Auto-generated method stub
		app.get("reimbs", this.getAllReimbs);
		app.get("/reimbs/:userId", this.getPastTickets);
		app.get("/reimbs/one/:ticket", this.getReimbTicket);
		app.get("/reimb/:status", this.getReimbStatus);
		app.post("/reimbs", this.addReimb);
		app.put("/reimbs/reimb", this.updateReimb);

	}
}



	
	


