package com.revature.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

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
    
//    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinColumn(name="ersUsersId")
//    private int reimbAuthor;
//    
//    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//    @JoinColumn(name="ersUsersId")
//    private int reimbResolver;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "ersUsersId")
    private ErsUsers ersUsers;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name= "reimbStatusId")
    private ErsReimbursementStatus reimbStatus;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="reimbTypeId")
    private ErsReimbursementType reimbType;

	public ErsReimbursement(int reimbId, double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved,
			byte[] reimbReceipt, ErsUsers ersUsers, ErsReimbursementStatus reimbStatus,
			ErsReimbursementType reimbType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReceipt = reimbReceipt;
		this.ersUsers = ersUsers;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public ErsReimbursement(double reimbAmount, LocalDateTime reimbSubmitted, LocalDateTime reimbResolved,
			byte[] reimbReceipt, ErsUsers ersUsers, ErsReimbursementStatus reimbStatus,
			ErsReimbursementType reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReceipt = reimbReceipt;
		this.ersUsers = ersUsers;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
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

	public ErsUsers getErsUsers() {
		return ersUsers;
	}

	public void setErsUsers(ErsUsers ersUsers) {
		this.ersUsers = ersUsers;
	}

	public ErsReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(ErsReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public ErsReimbursementType getReimbType() {
		return reimbType;
	}

	public void setReimbType(ErsReimbursementType reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersUsers == null) ? 0 : ersUsers.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbId;
		result = prime * result + Arrays.hashCode(reimbReceipt);
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbSubmitted == null) ? 0 : reimbSubmitted.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
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
		if (reimbId != other.reimbId)
			return false;
		if (!Arrays.equals(reimbReceipt, other.reimbReceipt))
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbReceipt="
				+ Arrays.toString(reimbReceipt) + ", ersUsers=" + ersUsers + ", reimbStatus=" + reimbStatus
				+ ", reimbType=" + reimbType + "]";
	}

	
}
