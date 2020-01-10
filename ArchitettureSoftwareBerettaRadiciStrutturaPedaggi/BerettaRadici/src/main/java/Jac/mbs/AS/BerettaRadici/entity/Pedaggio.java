package Jac.mbs.AS.BerettaRadici.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Jac.mbs.AS.BerettaRadici.entity2.Macchina;

@Entity
@Table(name = "multa")
public class Pedaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmulta")
	private int idMulta;

	@OneToOne 
	@JoinColumn(name = "targa")
	private Macchina Targa;

	@Column(name = "Stazione", length = 45)
	private String Stazione;

	@Column(name = "oraPassagio")
	private Date oraPassaggio;

	@Column(name = "creation_time")
	private Date creationTime;

	@Column(name = "creation_user")
	private String creationUser;

	@Column(name = "validFrom")
	private Date validFrom;

	@Column(name = "validTo")
	private Date validTo;
	@Column(name = "update_user", length = 20)
	private String updateUser;

	@Column(name = "update_time")
	private Date updateTime;

	public int getIdMulta() {
		return idMulta;
	}

	public void setIdMulta(int idMulta) {
		this.idMulta = idMulta;
	}

	public Macchina getTarga() {
		return Targa;
	}

	public void setTarga(Macchina Targa) {
		this.Targa = Targa;
	}

	public String getStazione() {
		return Stazione;
	}

	public void setStazione(String Stazione) {
		this.Stazione = Stazione;
	}

	public Date getOraPassaggio() {
		return oraPassaggio;
	}

	public void setDataDoc(Date oraPassaggio) {
		this.oraPassaggio = oraPassaggio;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Targa == null) ? 0 : Targa.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
		result = prime * result + ((Targa== null) ? 0 : Targa.hashCode());
		result = prime * result + idMulta;
		result = prime * result + ((Stazione == null) ? 0 : Stazione.hashCode());
		result = prime * result + ((oraPassaggio== null) ? 0 : oraPassaggio.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((creationUser == null) ? 0 : creationUser.hashCode());
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
		Pedaggio other = (Pedaggio) obj;
		if (Targa == null) {
			if (other.Targa != null)
				return false;
		} else if (!Targa.equals(other.Targa))
			return false;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (creationUser == null) {
			if (other.creationUser != null)
				return false;
		} else if (!creationUser.equals(other.creationUser))
			return false;

		if (idMulta != other.idMulta)
			return false;

		if (Stazione == null) {
			if (other.Stazione != null)
				return false;
		} else if (!Stazione.equals(other.Stazione))
			return false;

		if (oraPassaggio == null) {
			if (other.oraPassaggio != null)
				return false;
		} else if (!oraPassaggio.equals(other.oraPassaggio))
			return false;

		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;

		if (creationUser == null) {
			if (other.creationUser != null)
				return false;
		} else if (!creationUser.equals(other.creationUser))
			return false;
		if (validFrom == null) {
			if (other.validFrom != null)
				return false;
		} else if (!validFrom.equals(other.validFrom))
			return false;
		if (validTo == null) {
			if (other.validTo != null)
				return false;
		} else if (!validTo.equals(other.validTo))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updateUser == null) {
			if (other.updateUser != null)
				return false;
		} else if (!updateUser.equals(other.updateUser))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Macchina [idMulta=" + idMulta + ", Targa=" + Targa + ", Stazione=" + Stazione + ", Ora passaggio =" + oraPassaggio
				+ ", creationTime=" +  creationTime		+ ", creationUser=" + creationUser +  ", validFrom=" + validFrom + ", validTo=" + validTo +", updateUser=" + updateUser
				+ ", updateTime=" + updateTime + "]";
	}

}




