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
    
    @JoinColumn(name="ersUsersId")
    private int reimbAuthor;
    
    @JoinColumn(name="ersUsersId")
    private int reimbResolver;
    
//    @JoinColumn(name= "reimbStatusId")
//    private int reimbStatus;
//    
//    @JoinColumn(name="reimbTypeId")
//    private int reimbType;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ersUsersId")
    private ErsUsers ersUsers;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "reimbTypeId")
    private ErsReimbursementType reimbType;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "reimbStatusId")
    private ErsReimbursementStatus reimbStatus;

	public ErsReimbursement(int reimbId, double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved,
			byte[] reimbReceipt, int reimbAuthor, int reimbResolver, ErsUsers ersUsers, ErsReimbursementType reimbType,
			ErsReimbursementStatus reimbStatus) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.ersUsers = ersUsers;
		this.reimbType = reimbType;
		this.reimbStatus = reimbStatus;
	}

	public ErsReimbursement(double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved,
			byte[] reimbReceipt, int reimbAuthor, int reimbResolver, ErsUsers ersUsers, ErsReimbursementType reimbType,
			ErsReimbursementStatus reimbStatus) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.ersUsers = ersUsers;
		this.reimbType = reimbType;
		this.reimbStatus = reimbStatus;
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

	public ErsUsers getErsUsers() {
		return ersUsers;
	}

	public void setErsUsers(ErsUsers ersUsers) {
		this.ersUsers = ersUsers;
	}

	public ErsReimbursementType getReimbType() {
		return reimbType;
	}

	public void setReimbType(ErsReimbursementType reimbType) {
		this.reimbType = reimbType;
	}

	public ErsReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(ErsReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersUsers == null) ? 0 : ersUsers.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbAuthor;
		result = prime * result + reimbId;
		result = prime * result + Arrays.hashCode(reimbReceipt);
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + reimbResolver;
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
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
		if (ersUsers == null) {
			if (other.ersUsers != null)
				return false;
		} else if (!ersUsers.equals(other.ersUsers))
			return false;
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
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbReceipt="
				+ Arrays.toString(reimbReceipt) + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", ersUsers=" + ersUsers + ", reimbType=" + reimbType + ", reimbStatus=" + reimbStatus + "]";
	}
    
    

}
