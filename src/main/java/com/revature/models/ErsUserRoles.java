package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ers_user_roles")
public class ErsUserRoles {
    @Id
    @OneToMany(mappedBy="ersUserRoles", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @Column(name = "ers_role_id", nullable=false)
    private int userRoleId;
    
    @Column(name = "reimb_status_id", length=10, nullable=false)
    private String userRole;
    
//    List<ErsUsers> ersUsers;

	public ErsUserRoles(int userRoleId, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
//		this.ersUsers = ersUsers;
	}

	public ErsUserRoles() {
		super();
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

//	public List<ErsUsers> getErsUsers() {
//		return ersUsers;
//	}

//	public void setErsUsers(List<ErsUsers> ersUsers) {
//		this.ersUsers = ersUsers;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + userRoleId;
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
		ErsUserRoles other = (ErsUserRoles) obj;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsUserRoles [userRoleId=" + userRoleId + ", userRole=" + userRole + ", ersUsers=" + "]";
	}
    
    

}
