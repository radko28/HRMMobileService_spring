package sk.cyklosoft.hrmservice.mobile.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.hrmservice.data.UserResponseData;
import sk.cyklosoft.hrmservice.mobile.UserInfo;
import sk.cyklosoft.hrmservice.service.UserService;
import sk.cyklosoft.hrmservice.vo.UserVO;

@Controller
public class UserInfoImpl implements UserInfo {
    @Autowired
    UserService userService;
    
    @Override
    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody void registerUser(@RequestBody UserVO user) {
    	
    	userService.registerUser(user);
		
	}

    @Override
    @RequestMapping(value = "/userdetail/{username}", method = RequestMethod.GET)
	public @ResponseBody
	UserResponseData getUserDetail(@PathVariable String username) {
    	UserResponseData response = userService.getUserDetail(username);
        return response;
    }
	
	@Override
	@RequestMapping(value = "/{username}/{birthdate}/{weight}/{lenght}", method = RequestMethod.POST)
	public @ResponseBody
	void setUserDetail(@PathVariable String username,
			@PathVariable String birthdate, @PathVariable int weight,
			@PathVariable int lenght) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public @ResponseBody void deleteUser(@RequestBody UserVO user)	{
		 userService.deleteUser(user.getUsername());
		
	}

	@Override
	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.POST)
	public @ResponseBody
	void loginUser(@PathVariable String username,
			@PathVariable String birthdate, @PathVariable int weight,
			@PathVariable int lenght) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	public @ResponseBody
	void logoutUser(@PathVariable String username,
			@PathVariable String birthdate, @PathVariable int weight,
			@PathVariable int lenght) {
		// TODO Auto-generated method stub
		
	}

	

	
}
