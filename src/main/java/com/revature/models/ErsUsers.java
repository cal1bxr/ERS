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
public class ErsUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int ersUsersId;
    
    @Column(nullable=false)
    private String ersUsername;
    
    @Column(nullable=false)
    private int ersPassword;
    
    @Column(nullable=false)
    private String ersFirstName;
    
    @Column(nullable=false)
    private String ersLastName;
    
    @Column(nullable=false)
    private String ersEmail;
        
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "userRoleId")
    private ErsUserRoles ersUserRole;

	public ErsUsers(int ersUsersId, String ersUsername, int ersPassword, String ersFirstName, String ersLastName,
			String ersEmail, ErsUserRoles ersUserRole) {
		super();
		this.ersUsersId = ersUsersId;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.ersFirstName = ersFirstName;
		this.ersLastName = ersLastName;
		this.ersEmail = ersEmail;
		this.ersUserRole = ersUserRole;
	}

	public ErsUsers(String ersUsername, int ersPassword, String ersFirstName, String ersLastName, String ersEmail,
			ErsUserRoles ersUserRole) {
		super();
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.ersFirstName = ersFirstName;
		this.ersLastName = ersLastName;
		this.ersEmail = ersEmail;
		this.ersUserRole = ersUserRole;
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

	public int getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(int ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getErsFirstName() {
		return ersFirstName;
	}

	public void setErsFirstName(String ersFirstName) {
		this.ersFirstName = ersFirstName;
	}

	public String getErsLastName() {
		return ersLastName;
	}

	public void setErsLastName(String ersLastName) {
		this.ersLastName = ersLastName;
	}

	public String getErsEmail() {
		return ersEmail;
	}

	public void setErsEmail(String ersEmail) {
		this.ersEmail = ersEmail;
	}

	public ErsUserRoles getErsUserRole() {
		return ersUserRole;
	}

	public void setErsUserRole(ErsUserRoles ersUserRole) {
		this.ersUserRole = ersUserRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersEmail == null) ? 0 : ersEmail.hashCode());
		result = prime * result + ((ersFirstName == null) ? 0 : ersFirstName.hashCode());
		result = prime * result + ((ersLastName == null) ? 0 : ersLastName.hashCode());
		result = prime * result + ersPassword;
		result = prime * result + ((ersUserRole == null) ? 0 : ersUserRole.hashCode());
		result = prime * result + ((ersUsername == null) ? 0 : ersUsername.hashCode());
		result = prime * result + ersUsersId;
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
		if (ersPassword != other.ersPassword)
			return false;
		if (ersUserRole == null) {
			if (other.ersUserRole != null)
				return false;
		} else if (!ersUserRole.equals(other.ersUserRole))
			return false;
		if (ersUsername == null) {
			if (other.ersUsername != null)
				return false;
		} else if (!ersUsername.equals(other.ersUsername))
			return false;
		if (ersUsersId != other.ersUsersId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsUsers [ersUsersId=" + ersUsersId + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", ersFirstName=" + ersFirstName + ", ersLastName=" + ersLastName + ", ersEmail=" + ersEmail
				+ ", ersUserRole=" + ersUserRole + "]";
	}

    
}
