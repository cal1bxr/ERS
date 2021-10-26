package com.revature.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursment_type")
public class ErsReimbursementType {
    @Id
    @Column(name = "reimb_type_id", nullable=false)
    private int reimbTypeId;
    
    @Column(name = "reimb_type", length=10, nullable=false)
    private String reimbType;
    
    @OneToMany(mappedBy="reimbType", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<ErsReimbursement> reimbs;

	public ErsReimbursementType(int reimbTypeId, String reimbType, List<ErsReimbursement> reimbs) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
		this.reimbs = reimbs;
	}

	public ErsReimbursementType() {
		super();
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
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		result = prime * result + reimbTypeId;
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
		ErsReimbursementType other = (ErsReimbursementType) obj;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		if (reimbTypeId != other.reimbTypeId)
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
		return "ErsReimbursementType [reimbTypeId=" + reimbTypeId + ", reimbType=" + reimbType + ", reimbs=" + reimbs
				+ "]";
	}

    
}
