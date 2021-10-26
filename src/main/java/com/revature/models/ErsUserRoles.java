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
    @Column(name = "ers_role_id", nullable=false)
    private int userRoleId;
    
    @Column(name = "reimb_status_id", length=10, nullable=false)
    private String userRole;
    
    @OneToMany(mappedBy="ersRoles", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<ErsUsers> ersUser;

	public ErsUserRoles(int userRoleId, String userRole, List<ErsUsers> ersUser) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
		this.ersUser = ersUser;
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

	public List<ErsUsers> getErsUser() {
		return ersUser;
	}

	public void setErsUser(List<ErsUsers> ersUser) {
		this.ersUser = ersUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersUser == null) ? 0 : ersUser.hashCode());
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
		if (ersUser == null) {
			if (other.ersUser != null)
				return false;
		} else if (!ersUser.equals(other.ersUser))
			return false;
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
		return "ErsUserRoles [userRoleId=" + userRoleId + ", userRole=" + userRole + ", ersUser=" + ersUser + "]";
	}
    
    
    
	
}
