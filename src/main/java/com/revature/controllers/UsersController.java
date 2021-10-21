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
		List<ErsUsers> list = userService.getAllUsers();
		
		ctx.json(list);
		ctx.status(200);
	};
	
	public Handler getUser = (ctx) -> {
		try {
			String idString = ctx.pathParam("ers_user_id");
			int ersUserId = Integer.parseInt(idString);
			ErsUsers user = userService.getUserById(ersUserId);
			ctx.json(user);
			ctx.status(200);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			ctx.status(406);
		}
	};
	
	public Handler login = (ctx) -> {
		
	};

	@Override
	public void addRoutes(Javalin app) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		app.get("users", this.getAllUsers);
		app.get("/users/:user", this.getUser);
	
	}
		

}
