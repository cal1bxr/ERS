package com.revature.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="ers_reimbursement")
public class ErsReimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reimb_id")
    private int reimbId;
    
    @Column(name = "reimb_amount")
    private double reimbAmount;
    
    @Column(name = "reimb_submitted")
    private Timestamp reimbSubmitted;
    
    @Column(name = "reimb_resolved")
    private Timestamp reimbResolved;
    
    @Column(name = "reimb_receipt")
    private byte[] reimbReceipt;
    
//    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @Column(name = "reimb_author")
    private int reimbAuthor;
    
//    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @Column(name = "reimb_resolver")
    private int reimbResolver;
    
//    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @Column(name = "reimb_status_id")
    private int reimbStatusId;
    
//    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @Column(name = "reimb_type_id")
    private int reimb_type_id;

	public ErsReimbursement(int reimbId, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			byte[] reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId, int reimb_type_id) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimb_type_id = reimb_type_id;
	}


	public ErsReimbursement(double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, byte[] reimbReceipt,
			int reimbAuthor, int reimbResolver, int reimbStatusId, int reimb_type_id) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimb_type_id = reimb_type_id;
	}


	public ErsReimbursement(double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, int reimbAuthor,
			int reimbResolver, int reimbStatusId, int reimb_type_id) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimb_type_id = reimb_type_id;
	}


	public ErsReimbursement() {
		super();
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


	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}


	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}


	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbAuthor;
		result = prime * result + reimbId;
		result = prime * result + Arrays.hashCode(reimbReceipt);
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + reimbResolver;
		result = prime * result + reimbStatusId;
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
		result = prime * result + reimb_type_id;
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
		ErsReimbursement other = (ErsReimbursement) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthor != other.reimbAuthor)
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (!Arrays.equals(reimbReceipt, other.reimbReceipt))
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbResolver != other.reimbResolver)
			return false;
		if (reimbStatusId != other.reimbStatusId)
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimb_type_id != other.reimb_type_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbReceipt="
				+ Arrays.toString(reimbReceipt) + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusId=" + reimbStatusId + ", reimb_type_id=" + reimb_type_id + "]";
	}
	
	


}
