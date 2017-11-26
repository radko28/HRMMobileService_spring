package sk.cyklosoft.hrmservice.vo;

import java.util.List;

import javax.validation.constraints.Size;

import sk.cyklosoft.hrmservice.model.UserInfo;
import sk.cyklosoft.hrmservice.util.RoleType;
import sk.cyklosoft.hrmservice.util.SportType;

public class UserVO  {
    
    private Long userId;
    @Size(min=4, max=32, message = "{validation.name.notempty.message}")
    private String username;
    @Size(min=4, max=32, message = "{validation.name.notempty.message}")
    private String firstname;
    private String lastname;
    private String password;
    private Address address;
    private UserInfo userInfo;
    private List<Team> team;
    private String confirm;
    private String role;
    private boolean enabled; 
    private RoleType authority;
    
    private SportType currentActivity;

    public UserVO(Long userId, String username, String firstname, String lastname, String password) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname; 
        this.password= password; 
//        setEnabled(enabled);
  //      setRole(authority.toString());
    }

    
    public UserVO() {
        // TODO Auto-generated constructor stub
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

	public List<Team> getTeam() {
		return team;
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public RoleType getAuthority() {
		return authority;
	}


	public void setAuthority(RoleType authority) {
		this.authority = authority;
	}

	

}
