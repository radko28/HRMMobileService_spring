package sk.cyklosoft.hrmservice.data;

import sk.cyklosoft.hrmservice.vo.UserVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseData {
	
	private UserVO user;

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}
	

}
