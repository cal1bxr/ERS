package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ers_users")
public class ErsUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ers_users_id", nullable=false)
    private int ersUsersId;
    
    @Column(name = "ers_username", length=50, nullable=false)
    private String ersUsername;
    
    @Column(name = "ers_password", length=50, nullable=false)
    private String ersPassword;
    
    @Column(name = "ers_first_name", length=100, nullable=false)
    private String ersFirstName;
    
    @Column(name = "ers_last_name", length=100, nullable=false)
    private String ersLastName;
    
    @Column(name = "ers_email", length=150, nullable=false)
    private String ersEmail;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "userRoleId")
    @Column(name = "ers_role_id", nullable=false)
    private int ersRoleId;
        
//    private ErsUserRoles ersUserRoles;

	public ErsUsers(int ersUsersId, String ersUsername, String ersPassword, String userFirstName, String userLastName,
			String userEmail, int userRoleId) {
		super();
		this.ersUsersId = ersUsersId;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.ersFirstName = userFirstName;
		this.ersLastName = userLastName;
		this.ersEmail = userEmail;
		this.ersRoleId = userRoleId;
//		this.ersUserRoles = ersUserRoles;
	}

	public ErsUsers(String ersUsername, String ersPassword, String userFirstName, String userLastName, String userEmail,
			int userRoleId) {
		super();
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.ersFirstName = userFirstName;
		this.ersLastName = userLastName;
		this.ersEmail = userEmail;
		this.ersRoleId = userRoleId;
//		this.ersUserRoles = ersUserRoles;
	}

	public ErsUsers() {
		super();
	}

	public int getErsUsersId() {
		return ersUsersId;
	}

	public void setErsUsersId(int ersUsersId) {
		this.ersUsersId = ersUsersId;
	}

	public String getErsUsername() {
		return ersUsername;
	}

	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getUserFirstName() {
		return ersFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.ersFirstName = userFirstName;
	}

	public String getUserLastName() {
		return ersLastName;
	}

	public void setUserLastName(String userLastName) {
		this.ersLastName = userLastName;
	}

	public String getUserEmail() {
		return ersEmail;
	}

	public void setUserEmail(String userEmail) {
		this.ersEmail = userEmail;
	}

	public int getUserRoleId() {
		return ersRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.ersRoleId = userRoleId;
	}

//	public ErsUserRoles getErsUserRoles() {
//		return ersUserRoles;
//	}

//	public void setErsUserRoles(ErsUserRoles ersUserRoles) {
//		this.ersUserRoles = ersUserRoles;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersPassword == null) ? 0 : ersPassword.hashCode());
		result = prime * result + ((ersUsername == null) ? 0 : ersUsername.hashCode());
		result = prime * result + ersUsersId;
		result = prime * result + ((ersEmail == null) ? 0 : ersEmail.hashCode());
		result = prime * result + ((ersFirstName == null) ? 0 : ersFirstName.hashCode());
		result = prime * result + ((ersLastName == null) ? 0 : ersLastName.hashCode());
		result = prime * result + ersRoleId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsUsers other = (ErsUsers) obj;
		if (ersPassword == null) {
			if (other.ersPassword != null)
				return false;
		} else if (!ersPassword.equals(other.ersPassword))
			return false;
		if (ersUsername == null) {
			if (other.ersUsername != null)
				return false;
		} else if (!ersUsername.equals(other.ersUsername))
			return false;
		if (ersUsersId != other.ersUsersId)
			return false;
		if (ersEmail == null) {
			if (other.ersEmail != null)
				return false;
		} else if (!ersEmail.equals(other.ersEmail))
			return false;
		if (ersFirstName == null) {
			if (other.ersFirstName != null)
				return false;
		} else if (!ersFirstName.equals(other.ersFirstName))
			return false;
		if (ersLastName == null) {
			if (other.ersLastName != null)
				return false;
		} else if (!ersLastName.equals(other.ersLastName))
			return false;
		if (ersRoleId != other.ersRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsUsers [ersUsersId=" + ersUsersId + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", userFirstName=" + ersFirstName + ", userLastName=" + ersLastName + ", userEmail=" + ersEmail
				+ ", userRoleId=" + ersRoleId + "]";
	}

    
    

}
