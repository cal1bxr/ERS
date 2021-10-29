package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ErsReimbursementStatus {
    @Id
    private int reimbStatId;
    
    @Column(nullable=false)
    private String reimbStatus;

    public ErsReimbursementStatus(int reimbStatusId, String reimbStatus) {
        this.reimbStatId = reimbStatusId;
        this.reimbStatus = reimbStatus;
    }

    public ErsReimbursementStatus() {
    }

    public int getReimbStatusId() {
        return reimbStatId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatId = reimbStatusId;
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
        return reimbStatId == that.reimbStatId && Objects.equals(reimbStatus, that.reimbStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbStatId, reimbStatus);
    }

    @Override
    public String toString() {
        return "ErsReimbursmentStatus{" +
                "reimbStatusId=" + reimbStatId +
                ", reimbStatus='" + reimbStatus + '\'' +
                '}';
    }
}
