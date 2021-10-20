package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="ers_user_roles")
public class ErsUserRoles {
    @Id
//    @OneToMany(mappedBy="ers_user_roles", fetch=FetchType.EAGER)
    @Column(name="user_role_id")
    private int userRoleId;
    @Column(length = 10, name="user_role", nullable = false)
    private String userRole;

    public ErsUserRoles(int userRoleId, String userRole) {
        this.userRoleId = userRoleId;
        this.userRole = userRole;
    }

    public ErsUserRoles() {
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsUserRoles that = (ErsUserRoles) o;
        return userRoleId == that.userRoleId && Objects.equals(userRole, that.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleId, userRole);
    }

    @Override
    public String toString() {
        return "ErsUserRoles{" +
                "userRoleId=" + userRoleId +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
