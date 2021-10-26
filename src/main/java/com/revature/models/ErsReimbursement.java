package com.revature.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="ers_reimbursement")
public class ErsReimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reimb_id", nullable=false)
    private int reimbId;
    
    @Column(name = "reimb_amount", nullable=false)
    private double reimbAmount;
    
    @Column(name = "reimb_submitted")
    private LocalDateTime reimbSubmitted;
    
    @Column(name = "reimb_resolved")
    private LocalDateTime reimbResolved;
    
    @Column(name = "reimb_receipt")
    @Lob
    private byte[] reimbReceipt;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="ersUsersId")
    @Column(name = "reimb_author", nullable=false)
    private int reimbAuthor;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="ersUsersId")
    @Column(name = "reimb_resolver", nullable=false)
    private int reimbResolver;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name= "reimbStatusId")
    @Column(name = "reimb_status_id", nullable=false)
    private int reimbStatusId;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="reimbTypeId")
    @Column(name = "reimb_type_id", nullable=false)
    private int reimbTypeId;

	public ErsReimbursement(int reimbId, double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved,
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
		this.reimbTypeId = reimb_type_id;
	}


	public ErsReimbursement(double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved, byte[] reimbReceipt,
			int reimbAuthor, int reimbResolver, int reimbStatusId, int reimb_type_id) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimb_type_id;
	}


	public ErsReimbursement(double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved, int reimbAuthor,
			int reimbResolver, int reimbStatusId, int reimb_type_id) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimb_type_id;
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


	public LocalDateTime getReimbSubmitted() {
		return reimbSubmitted;
	}


	public void setReimbSubmitted(LocalDateTime reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}


	public LocalDateTime getReimbResolved() {
		return reimbResolved;
	}


	public void setReimbResolved(LocalDateTime reimbResolved) {
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
		return reimbTypeId;
	}


	public void setReimb_type_id(int reimb_type_id) {
		this.reimbTypeId = reimb_type_id;
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
		result = prime * result + reimbTypeId;
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
		if (reimbTypeId != other.reimbTypeId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbReceipt="
				+ Arrays.toString(reimbReceipt) + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatusId=" + reimbStatusId + ", reimb_type_id=" + reimbTypeId + "]";
	}
	
	


}
