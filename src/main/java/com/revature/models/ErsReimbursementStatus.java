package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="ers_reimbursment_status")
public class ErsReimbursementStatus {
    @Id
    @Column(name = "reimb_status_id", nullable=false)
    private int reimbStatusId;
    
    @Column(name = "reimb_status", nullable=false)
    private String reimbStatus;
    
    @OneToMany(mappedBy="reimbStatus", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<ErsReimbursement> reimbs;

	public ErsReimbursementStatus(int reimbStatusId, String reimbStatus, List<ErsReimbursement> reimbs) {
		super();
		this.reimbStatusId = reimbStatusId;
		this.reimbStatus = reimbStatus;
		this.reimbs = reimbs;
	}

	public ErsReimbursementStatus() {
		super();
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

	public List<ErsReimbursement> getReimbs() {
		return reimbs;
	}

	public void setReimbs(List<ErsReimbursement> reimbs) {
		this.reimbs = reimbs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + reimbStatusId;
		result = prime * result + ((reimbs == null) ? 0 : reimbs.hashCode());
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
		ErsReimbursementStatus other = (ErsReimbursementStatus) obj;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbStatusId != other.reimbStatusId)
			return false;
		if (reimbs == null) {
			if (other.reimbs != null)
				return false;
		} else if (!reimbs.equals(other.reimbs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErsReimbursementStatus [reimbStatusId=" + reimbStatusId + ", reimbStatus=" + reimbStatus + ", reimbs="
				+ reimbs + "]";
	}

    
}
