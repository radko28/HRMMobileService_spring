package sk.cyklosoft.hrmservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.hrmservice.data.UserResponseData;
import sk.cyklosoft.hrmservice.vo.UserVO;


public interface UserService {
	public @ResponseBody UserResponseData getUserDetail(@PathVariable String username);

	public void registerUser(UserVO user);
	public void deleteUser(Long userId);
	public List<UserVO> findAllUsers();
	public String getWholeNameByUsername(String string);
}
