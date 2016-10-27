package sk.cyklosoft.hrmservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.joda.time.DateTime;
import org.joda.time.contrib.hibernate.PersistentDateTime;

@Entity
@Table(name = "USER_INFO")
@TypeDefs({ @TypeDef(name = "jodaDateTime", typeClass = PersistentDateTime.class) })
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 6191394199565198633L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long userInfoId;

	@Column(name = "weight")
	private double weight;
	
	@Column(name = "lenght")
	private int lenght;
	
	@Column(name = "birthdate")
	@Type(type = "jodaDateTime")
    private DateTime birthdate;
	
	@Column(name = "gender")
	private char gender;
	
	@OneToOne
    @JoinColumn(name = "user_id")
    private User users;

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public DateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
}
