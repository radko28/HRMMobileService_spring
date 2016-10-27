package sk.cyklosoft.hrmservice.vo;

import java.util.List;

import sk.cyklosoft.hrmservice.model.UserInfo;
import sk.cyklosoft.hrmservice.util.SportType;

public class UserVO  {
    
    private Long userId;
    
    private String username;
    
    private String firstname;
    
    private String lastname;
    
    private String password;
    
    private Address address;
    
    private UserInfo userInfo;
    
    private List<Team> team;
    
    private SportType currentActivity;

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

	public List<Team> getTeam() {
		return team;
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

	

}
