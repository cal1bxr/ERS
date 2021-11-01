package com.revature;


import java.sql.Timestamp;
import java.util.Date;

import com.revature.controllers.Controller;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UsersController;
import com.revature.models.ErsReimbursement;
import com.revature.models.ErsReimbursementStatus;
import com.revature.models.ErsReimbursementType;
import com.revature.models.ErsUserRoles;
import com.revature.models.ErsReimbursement;
//import com.revature.models.ErsReimbursementStatus;
//import com.revature.models.ErsReimbursementType;
//import com.revature.models.ErsUserRoles;
//import com.revature.models.ErsUsers;
//import com.revature.repositories.ErsReimbursementDAO;
//import com.revature.repositories.ErsReimbursementDaoImpl;
//import com.revature.repositories.ErsUsersDAO;
//import com.revature.repositories.ErsUsersDaoImpl;
import com.revature.models.ErsUsers;
import com.revature.repositories.ErsReimbursementDAO;
import com.revature.repositories.ErsReimbursementDaoImpl;
import com.revature.repositories.ErsUsersDAO;
import com.revature.repositories.ErsUsersDaoImpl;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
	private static ErsUsersDAO userDao = new ErsUsersDaoImpl();
	private static ErsReimbursementDAO reimbDao = new ErsReimbursementDaoImpl();

	private static Javalin app;

	public static void main(String[] args) {
		Date date = new Date(0);  
        Timestamp ts=new Timestamp(date.getTime()); 

		
		
//		ErsReimbursementStatus ersReimbursementStatus1 = new ErsReimbursementStatus(1, "APPROVED");
//		ErsReimbursementStatus ersReimbursementStatus2 = new ErsReimbursementStatus(2, "PENDING");
//		ErsReimbursementStatus ersReimbursementStatus3 = new ErsReimbursementStatus(3, "DENIED");
//
//		ErsReimbursementType ersReimbursementType1 = new ErsReimbursementType(1, "LODGING");
//		ErsReimbursementType ersReimbursementType2 = new ErsReimbursementType(2, "FOOD");
//		ErsReimbursementType ersReimbursementType3 = new ErsReimbursementType(3, "TRAVEL");
//		ErsReimbursementType ersReimbursementType4 = new ErsReimbursementType(4, "OTHER");
//		
//		ErsUserRoles ersUserRole1 = new ErsUserRoles(1, "ADMIN");
//		ErsUserRoles ersUserRole2 = new ErsUserRoles(2, "EMPLOYEE");
//////
//		ErsUsers ersUser1 = new ErsUsers("mjordan","Password".hashCode(),"Matt","Jordan","mjordan@mjordan", ersUserRole1);
//		ErsUsers ersUser2 = new ErsUsers("mjo","password".hashCode(),"M","Jo","new@new", ersUserRole2);
//		ErsUsers ersUser3 = new ErsUsers("test","test".hashCode(),"test","test","something@mjordan", ersUserRole2);
//		ErsUsers ersUser4 = new ErsUsers("test2","whatever".hashCode(),"test2","test2","matt@mjordan", ersUserRole2);
//////		
//		ErsReimbursement ersReimb1 = new ErsReimbursement(100.00, ts, null, null, ersUser1, null, ersReimbursementStatus1, ersReimbursementType1);
//		ErsReimbursement ersReimb2 = new ErsReimbursement(2100.00, ts, null, null, ersUser2, null, ersReimbursementStatus2, ersReimbursementType2);
//		ErsReimbursement ersReimb3 = new ErsReimbursement(399.99, ts, ts, null, ersUser3, ersUser1, ersReimbursementStatus1, ersReimbursementType3);
//		ErsReimbursement ersReimb4 = new ErsReimbursement(52.35, ts, null, null, ersUser4, null, ersReimbursementStatus3, ersReimbursementType4);
////
//////
////		
//		userDao.addUser(ersUser1);
//		userDao.addUser(ersUser2);
//		userDao.addUser(ersUser3);
//		userDao.addUser(ersUser4);
////		
//		reimbDao.addReimbursement(ersReimb1);
//		reimbDao.addReimbursement(ersReimb2);
//		reimbDao.addReimbursement(ersReimb3);
//		reimbDao.addReimbursement(ersReimb4);
		
   
		
		
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
