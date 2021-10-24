package com.revature.controllers;

import java.util.List;

import com.revature.models.ErsReimbursement;
import com.revature.models.ErsUsers;
import com.revature.services.ErsUsersService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UsersController implements Controller{
	
	private ErsUsersService userService = new ErsUsersService();
	
	public Handler getAllUsers = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
		List<ErsUsers> list = userService.findAllUsers();
		
		ctx.json(list);
		ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler getUser = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			ErsUsers user = userService.getUserById(Integer.parseInt(ctx.pathParam("ers_users_id")));
			ctx.json(user);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler login = (ctx) -> {
		
	};

	@Override
	public void addRoutes(Javalin app) {
		app.get("/ersUsers", this.getAllUsers);
		app.get("/ersUsers/:user", this.getUser);
	
	}
		

}
