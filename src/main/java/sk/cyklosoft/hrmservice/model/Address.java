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

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 2904001232587790185L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long addressId;
    
    @Column(name = "address", nullable = false, columnDefinition = "varchar(64)")
    private String address;
    
    @Column(name = "zip", nullable = false, columnDefinition = "varchar(64)")
    private String zip;
    
    @Column(name = "city", nullable = false, columnDefinition = "varchar(64)")
    private String city;
    
    @Column(name = "country", nullable = false, columnDefinition = "varchar(64)")
    private String country;
    
    @Column(name = "phone", nullable = false, columnDefinition = "varchar(64)")
    private String phone;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}



}
