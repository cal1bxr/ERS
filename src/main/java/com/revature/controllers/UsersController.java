package com.revature.controllers;

import java.util.List;

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
			List<ErsUsers> ersUser = userService.getUserById(Integer.parseInt(ctx.pathParam("ersUserId")));
			ctx.json(ersUser);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler getUserByUsername = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			String idString = ctx.pathParam("ersUsername"); // mjordan
			ErsUsers ersUser = userService.getUserByUsername(idString);
			ctx.json(ersUser);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler getUserByEmail = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			String idString = ctx.pathParam("ersUsername");
			ErsUsers ersUser = userService.getUserByEmail("idString");
			ctx.json(ersUser);

			ctx.json(ersUser);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler getUserPassword = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			ErsUsers user = userService.getUserPass(Integer.parseInt(ctx.pathParam("ersPassword")));
			ctx.json(user);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};
	
	public Handler addUser = (ctx) -> {
		ErsUsers ersUser = ctx.bodyAsClass(ErsUsers.class);
		if (userService.addUser(ersUser)) {
			ctx.status(201);
		} else {
			ctx.status(400);
		}
	};
	
	public Handler getRoleById = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			String idString = ctx.pathParam("ersRoleId"); // mjordan
			ErsUsers ersUser = userService.getUserRole(Integer.parseInt(ctx.pathParam("ersUsersId")));
			ctx.json(ersUser);
			ctx.status(200);
		} else {
			ctx.status(401);
		}
	};

	@Override
	public void addRoutes(Javalin app) {
		app.get("/ersUsers", this.getAllUsers);
		app.get("/ersUsers/:ersUsername", this.getUserByUsername);
		app.get("/ersUsers/:ersRoleId", this.getUserByUsername);
	
	}
		

}
