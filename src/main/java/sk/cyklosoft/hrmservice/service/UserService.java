package sk.cyklosoft.hrmservice.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.hrmservice.data.UserResponseData;
import sk.cyklosoft.hrmservice.vo.UserVO;


public interface UserService {
	public @ResponseBody UserResponseData getUserDetail(@PathVariable String username);

	public void registerUser(UserVO user);

	public void deleteUser(String username);

}
