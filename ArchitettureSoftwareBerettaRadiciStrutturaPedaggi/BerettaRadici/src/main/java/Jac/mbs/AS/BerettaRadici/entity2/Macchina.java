package Jac.mbs.AS.BerettaRadici.entity2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Jac.mbs.AS.BerettaRadici.entity2.Macchina;

@Entity
@Table(name = "Macchina")
public class Macchina {

	@Id
	@Column(name = "targa")
	private String targa;

	@Column(name = "marca", length = 45)
	private String marca;

	@Column(name = "modello", length = 45)
	private String modello;

	@Column(name = "telepass", length = 45)
	private Boolean telepass;

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

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Boolean getTelepass() {
		return telepass;
	}

	public void setTelepass(Boolean telepass) {
		this.telepass = telepass;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Macchina other = (Macchina) obj;
		if (modello == null) {
			if (other.modello != null)
				return false;
		} else if (!modello.equals(other.modello))
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

		if (targa != other.targa)
			return false;

		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;

		if (telepass == null) {
			if (other.telepass != null)
				return false;
		} else if (!telepass.equals(other.telepass))
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
		return "Macchina [Targa=" + targa + ", modello=" + modello + ", marca=" + marca + ", telepass=" + telepass
				+ ", creationTime=" + creationTime + ", creationUser=" + creationUser + ", validFrom=" + validFrom
				+ ", validTo=" + validTo + ", updateUser=" + updateUser + ", updateTime=" + updateTime + "]";
	}

}
