package sk.cyklosoft.hrmservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.hrmservice.data.UserResponseData;
import sk.cyklosoft.hrmservice.vo.UserVO;


public interface UserService {
	@ResponseBody UserResponseData getUserDetail(@PathVariable String username);
	void registerUser(UserVO user);
	void deleteUser(Long userId);
	List<UserVO> findAllUsers();
	String getWholeNameByUsername(String string);
    UserVO getUserById(Long userId);
	void updateUser(UserVO user);
}
