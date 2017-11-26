package sk.cyklosoft.hrmservice.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sk.cyklosoft.hrmservice.util.SportType;
import sk.cyklosoft.hrmservice.vo.UserVO;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = -1505910553398879998L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userId;

    @Column(name = "username", nullable = false, columnDefinition = "varchar(32)")
    private String username;

    @Column(name = "firstname", nullable = false, length = 15)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 15)
    private String lastname;

    @Column(name = "password", nullable = false)
    private String password;
    
    @OneToOne(mappedBy = "users")
    private Address address;
    
    @OneToOne(mappedBy = "users")
    private UserInfo userInfo;
    
    @OneToMany(mappedBy = "users")
    private List<HRMData> hrmData;
   
    @Column(name = "currentActivity", nullable = true)
    private SportType currentActivity;
    
    public UserVO copy() {
        return new UserVO(userId, username, firstname, lastname, password);
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public SportType getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(SportType currentActivity) {
		this.currentActivity = currentActivity;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<HRMData> getHrmData() {
		return hrmData;
	}

	public void setHrmData(List<HRMData> hrmData) {
		this.hrmData = hrmData;
	}

	

	

}
