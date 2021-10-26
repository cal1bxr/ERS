package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UsersController;
import com.revature.models.ErsReimbursement;
import com.revature.models.ErsReimbursementStatus;
import com.revature.models.ErsReimbursementType;
import com.revature.models.ErsUserRoles;
import com.revature.models.ErsUsers;
import com.revature.repositories.ErsReimbursementDAO;
import com.revature.repositories.ErsReimbursementDaoImpl;
import com.revature.repositories.ErsUsersDAO;
import com.revature.repositories.ErsUsersDaoImpl;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

	private static Javalin app;

	public static void main(String[] args) {
		
		ErsReimbursementDAO reimbDao = new ErsReimbursementDaoImpl();
		ErsUsersDAO ersUserDao = new ErsUsersDaoImpl();
		
		ErsUsers ersUser = new ErsUsers("mjordan", "Password", "Matt", "Jordan", "mjordan@mjordan", 1, null);
		ErsUserRoles ersUserRoles = new ErsUserRoles(1, "Admin", null);
		ErsReimbursementType ersReimbursementType = new ErsReimbursementType(1, "LODGING", null);
		ErsReimbursementStatus ersReimbursementStatus = new ErsReimbursementStatus(1, "APPROVED", null);
		ErsReimbursement ersReimbursement = new ErsReimbursement(500.00, null, null, null, 1, 1, null, null, null);
		

		ersUserDao.addErsUserRoles(ersUserRoles);
		reimbDao.addReimbursementStatus(ersReimbursementStatus);
		reimbDao.addReimbursementType(ersReimbursementType);
		ersUserDao.addErsUser(ersUser);
		reimbDao.addReimbursement(ersReimbursement);

		
		
		
		
		app = Javalin.create((config)->{
			config.addStaticFiles("/static", Location.CLASSPATH);
		});
		
		configure(new UsersController(), new ReimbursementController(), new LoginController());
		
		app.start(8081);
	}

	public static void configure(Controller... controllers) {
		for(Controller c:controllers) {
			c.addRoutes(app);
		}
	}
}
