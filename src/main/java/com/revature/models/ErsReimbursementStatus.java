package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="ers_reimbursment_status")
public class ErsReimbursementStatus {
    @Id
    @Column(name = "reimb_status_id")
    private int reimbStatusId;
    
    @Column(name = "reimb_status")
    private String reimbStatus;

    public ErsReimbursementStatus(int reimbStatusId, String reimbStatus) {
        this.reimbStatusId = reimbStatusId;
        this.reimbStatus = reimbStatus;
    }

    public ErsReimbursementStatus() {
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsReimbursementStatus that = (ErsReimbursementStatus) o;
        return reimbStatusId == that.reimbStatusId && Objects.equals(reimbStatus, that.reimbStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbStatusId, reimbStatus);
    }

    @Override
    public String toString() {
        return "ErsReimbursmentStatus{" +
                "reimbStatusId=" + reimbStatusId +
                ", reimbStatus='" + reimbStatus + '\'' +
                '}';
    }
}