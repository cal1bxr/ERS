package com.revature.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class ErsReimbursementType {
    @Id
    private int reimbTypeId;
    
    @Column(nullable=false)
    private String reimbType;

    public ErsReimbursementType(int reimbTypeId, String reimbType) {
        this.reimbTypeId = reimbTypeId;
        this.reimbType = reimbType;
    }

    public ErsReimbursementType() {
    }

    public int getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(int reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    public String getReimbType() {
        return reimbType;
    }

    public void setReimbType(String reimbType) {
        this.reimbType = reimbType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsReimbursementType that = (ErsReimbursementType) o;
        return reimbTypeId == that.reimbTypeId && Objects.equals(reimbType, that.reimbType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbTypeId, reimbType);
    }

    @Override
    public String toString() {
        return "ErsReimbursementType{" +
                "reimbTypeId=" + reimbTypeId +
                ", reimbType='" + reimbType + '\'' +
                '}';
    }
}
