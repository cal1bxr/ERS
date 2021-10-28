package com.revature;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.controllers.Controller;
import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UsersController;
import com.revature.models.ErsReimbursement;
import com.revature.models.ErsReimbursementStatus;
import com.revature.models.ErsReimbursementType;
import com.revature.models.ErsUserRoles;
import com.revature.models.ErsUsers;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

	private static Javalin app;

	public static void main(String[] args) {
		
//		ErsReimbursement ersReimbursement = new ErsReimbursement(500.00, null, null,null, null, null, null,	null);
//		ErsReimbursementStatus ersReimbursementStatus = new ErsReimbursementStatus(1, "APPROVED");
//		ErsReimbursementType ersReimbursementType = new ErsReimbursementType(1, "LODGING");
//		ErsUserRoles ersUserRoles = new ErsUserRoles(1, "ADMIN");
//		ErsUsers ersUsers = new ErsUsers("mjordan", "Password", "Matt", "Jordan", "mjordan@mjordan", null);
//		
//		
//		insert(ersUsers);
//		insert(ersUserRoles);
//		insert(ersReimbursementType);
//		insert(ersReimbursementStatus);
//		insert(ersReimbursement);

		
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
	
	public static void insert(ErsUsers user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(user);
		System.out.println(obj);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	public static void insert(ErsUserRoles user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(user);
		System.out.println(obj);
		tx.commit();
		HibernateUtil.closeSession();
	}
	public static void insert(ErsReimbursement reimb) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(reimb);
		System.out.println(obj);
		tx.commit();
		HibernateUtil.closeSession();
	}
	public static void insert(ErsReimbursementStatus reimb) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(reimb);
		System.out.println(obj);
		tx.commit();
		HibernateUtil.closeSession();
	}
	public static void insert(ErsReimbursementType reimb) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object obj = session.save(reimb);
		System.out.println(obj);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
}
