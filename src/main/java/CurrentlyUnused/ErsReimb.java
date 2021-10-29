package CurrentlyUnused;

import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ErsReimb {
	
	public enum ReimbType {LODGING, TRAVEL, FOOD, OTHER};
	public enum ReimbStatus {APPROVED, PENDING, DENIED};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reimbId;
	
	@Column(nullable=false)
	private double reimbAmount;
	
	@Column(nullable=false)
	private Timestamp reimbSubmitted;
	
	
	private Timestamp reimbResolved;
	
	
	private Byte[] reimbReciept;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="userId", updatable=false, insertable=false)
	private ErsUser reimbAuthor;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="userId", updatable=false, insertable=false)
	private ErsUser reimbResolver;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private ReimbStatus reimbStatusId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private ReimbType reimbStatusType;
//	private ErsUser ersUser;

	public ErsReimb(int reimbId, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			Byte[] reimbReciept, ErsUser reimbAuthor, ErsUser reimbResolver, ReimbStatus reimbStatusId,
			ReimbType reimbStatusType) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReciept = reimbReciept;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbStatusType = reimbStatusType;
	}

	public ErsReimb(double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, Byte[] reimbReciept,
			ErsUser reimbAuthor, ErsUser reimbResolver, ReimbStatus reimbStatusId, ReimbType reimbStatusType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbReciept = reimbReciept;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbStatusType = reimbStatusType;
	}

	public ErsReimb() {
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

	public Byte[] getReimbReciept() {
		return reimbReciept;
	}

	public void setReimbReciept(Byte[] reimbReciept) {
		this.reimbReciept = reimbReciept;
	}

	public ErsUser getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(ErsUser reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public ErsUser getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(ErsUser reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public ReimbStatus getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(ReimbStatus reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public ReimbType getReimbStatusType() {
		return reimbStatusType;
	}

	public void setReimbStatusType(ReimbType reimbStatusType) {
		this.reimbStatusType = reimbStatusType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimbAuthor == null) ? 0 : reimbAuthor.hashCode());
		result = prime * result + reimbId;
		result = prime * result + Arrays.hashCode(reimbReciept);
		result = prime * result + ((reimbResolved == null) ? 0 : reimbResolved.hashCode());
		result = prime * result + ((reimbResolver == null) ? 0 : reimbResolver.hashCode());
		result = prime * result + ((reimbStatusId == null) ? 0 : reimbStatusId.hashCode());
		result = prime * result + ((reimbStatusType == null) ? 0 : reimbStatusType.hashCode());
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
		ErsReimb other = (ErsReimb) obj;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthor == null) {
			if (other.reimbAuthor != null)
				return false;
		} else if (!reimbAuthor.equals(other.reimbAuthor))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (!Arrays.equals(reimbReciept, other.reimbReciept))
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbResolver == null) {
			if (other.reimbResolver != null)
				return false;
		} else if (!reimbResolver.equals(other.reimbResolver))
			return false;
		if (reimbStatusId != other.reimbStatusId)
			return false;
		if (reimbStatusType != other.reimbStatusType)
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
		return "ErsReimb [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbReciept=" + Arrays.toString(reimbReciept)
				+ ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatusId="
				+ reimbStatusId + ", reimbStatusType=" + reimbStatusType + "]";
	}

	
}
