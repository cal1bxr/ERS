package com.revature.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
//@Table(name="ers_reimbursement")
public class ErsReimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reimbId;
    private double reimbAmount;
    private Timestamp reimSubmitted;
    private Timestamp reimbResolved;
    private byte[] reimbReceipt;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private int reimbAuthor;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private int reimbResolver;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private int reimbStatusId;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private int reimb_type_id;

   
    public ErsReimbursement(int reimbId, double reimbAmount,
                           Timestamp reimSubmitted, Timestamp reimbResolved, byte[] reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimb_type_id) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimSubmitted = reimSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbReceipt = reimbReceipt;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimb_type_id = reimb_type_id;
    }

    public ErsReimbursement(double reimbAmount, Timestamp reimSubmitted,
                           Timestamp reimbResolved, byte[] reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimb_type_id) {
        this.reimbAmount = reimbAmount;
        this.reimSubmitted = reimSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbReceipt = reimbReceipt;
        this.reimbAuthor = reimbAuthor;
        this.reimbResolver = reimbResolver;
        this.reimbStatusId = reimbStatusId;
        this.reimb_type_id = reimb_type_id;
    }
    
    

    public ErsReimbursement(int reimbId, double reimbAmount, Timestamp reimSubmitted, Timestamp reimbResolved,
			int reimbAuthor, int reimbResolver, int reimbStatusId, int reimb_type_id) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimSubmitted = reimSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimb_type_id = reimb_type_id;
	}

	public ErsReimbursement() {
    }

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(int reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public Timestamp getReimSubmitted() {
        return reimSubmitted;
    }

    public void setReimSubmitted(Timestamp reimSubmitted) {
        this.reimSubmitted = reimSubmitted;
    }

    public Timestamp getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(Timestamp reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public byte[] getReimbReceipt() {
        return reimbReceipt;
    }

    public void setReimbReceipt(byte[] reimbReceipt) {
        this.reimbReceipt = reimbReceipt;
    }

    public int getReimbAuthor() {
        return reimbAuthor;
    }

    public void setReimbAuthor(int reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public int getReimbResolver() {
        return reimbResolver;
    }

    public void setReimbResolver(int reimbResolver) {
        this.reimbResolver = reimbResolver;
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public int getReimb_type_id() {
        return reimb_type_id;
    }

    public void setReimb_type_id(int reimb_type_id) {
        this.reimb_type_id = reimb_type_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErsReimbursement that = (ErsReimbursement) o;
        return reimbId == that.reimbId && reimbAmount == that.reimbAmount && reimbAuthor == that.reimbAuthor && reimbResolver == that.reimbResolver && reimbStatusId == that.reimbStatusId && reimb_type_id == that.reimb_type_id && Objects.equals(reimSubmitted, that.reimSubmitted) && Objects.equals(reimbResolved, that.reimbResolved) && Arrays.equals(reimbReceipt, that.reimbReceipt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(reimbId, reimbAmount, reimSubmitted, reimbResolved, reimbAuthor, reimbResolver, reimbStatusId, reimb_type_id);
        result = 31 * result + Arrays.hashCode(reimbReceipt);
        return result;
    }

    @Override
    public String toString() {
        return "ErsReimbursment{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", reimSubmitted=" + reimSubmitted +
                ", reimbResolved=" + reimbResolved +
                ", reimbReceipt=" + Arrays.toString(reimbReceipt) +
                ", reimbAuthor=" + reimbAuthor +
                ", reimbResolver=" + reimbResolver +
                ", reimbStatusId=" + reimbStatusId +
                ", reimb_type_id=" + reimb_type_id +
                '}';
    }
}
