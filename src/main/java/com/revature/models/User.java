package com.revature.models;

public class User {

		private String username;
		private int password;
		private String rold;
		public User(String username, int password, String rold) {
			super();
			this.username = username;
			this.password = password;
			this.rold = rold;
		}
		public int getPassword() {
			return password;
		}
		public void setPassword(int password) {
			this.password = password;
		}
		
}
