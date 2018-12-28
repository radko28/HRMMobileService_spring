package sk.cyklosoft.hrmservice;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import sk.cyklosoft.hrmservice.data.UserResponseData;
import sk.cyklosoft.hrmservice.vo.UserVO;

public class UserServiceTest {
	
	private static String URL = "http://localhost:8080/HRMMobileService/userInfo";

	private RestTemplate restTemplate = null; 
	private UserResponseData response = null;	
	
	 @Before
	 public void setUp() {
		 restTemplate = new RestTemplate();
	 }

	@Test
	public void registerUser() {
		String method = "/register";
		UserVO user = new UserVO();
		user.setFirstname("Radoslav");
		user.setLastname("Kuzma");
		user.setPassword("hrmservice");
		user.setUsername(USERNAME);
		response = restTemplate.postForObject(URL + method, user, UserResponseData.class);
		
		user.setUsername(USERNAME2);
		response = restTemplate.postForObject(URL + method, user, UserResponseData.class);
		
	}
	
	@Test
	public void getUserDetail() {
		String method = "/userdetail/{username}";
		response = restTemplate.getForObject(URL + method, UserResponseData.class, USERNAME);
		System.out.println(response);
	}
	
	@Test
	public void deleteUser() {
		String method = "/delete";
		UserVO user = new UserVO();
		user.setUsername(USERNAME);
		restTemplate.put(URL + method, user);
	}

	
	void setUserDetail() {
		
	}
	
	void loginUser() {
		
	}
	
	void logoutUser() {
		
	}
}
