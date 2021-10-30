package com.revature.models;

public class User {

		@SuppressWarnings("unused")
		private String username;
		private String password;
		@SuppressWarnings("unused")
		private String role;
		
		public User(String username, String password, String role) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
		}
		public String getPassword() {
			return password;
		}		
}
