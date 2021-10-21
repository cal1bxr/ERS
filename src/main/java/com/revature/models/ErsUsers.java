package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="ers_users")
public class ErsUsers {
    @Id
    @Column(name="ers_users_id")
    private int ersUsersId;
    @Column(length=50, name="ers_username", nullable = false, unique = true)
    private String ersUsername;
    @Column(length=50, name="ers_password", nullable = false)
    private String ersPassword;
    @Column(length=100, name="ers_first_name", nullable = false)
    private String userFirstName;
    @Column(length=100, name="ers_last_name", nullable = false)
    private String userLastName;
    @Column(length=150, name="user_email", nullable = false, unique = true)
    private String userEmail;
    @Column(name="user_role_id", nullable = false)
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="ers_role_id")
    private int userRoleId;

    public ErsUsers(int ersUsersId, String ersUsername, String ersPassword, String userFirstName, String userLastName, String userEmail, int userRoleId) {
        this.ersUsersId = ersUsersId;
        this.ersUsername = ersUsername;
        this.ersPassword = ersPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleId = userRoleId;
    }

    public ErsUsers() {
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
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
        ErsUsers ersUsers = (ErsUsers) o;
        return ersUsersId == ersUsers.ersUsersId && userRoleId == ersUsers.userRoleId && Objects.equals(ersUsername, ersUsers.ersUsername) && Objects.equals(ersPassword, ersUsers.ersPassword) && Objects.equals(userFirstName, ersUsers.userFirstName) && Objects.equals(userLastName, ersUsers.userLastName) && Objects.equals(userEmail, ersUsers.userEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ersUsersId, ersUsername, ersPassword, userFirstName, userLastName, userEmail, userRoleId);
    }

    @Override
    public String toString() {
        return "ErsUsers{" +
                "ersUsersId=" + ersUsersId +
                ", ersUsername='" + ersUsername + '\'' +
                ", ersPassword='" + ersPassword + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRoleId=" + userRoleId +
                '}';
    }
}
