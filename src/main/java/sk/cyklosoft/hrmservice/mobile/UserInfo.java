package sk.cyklosoft.hrmservice.mobile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.hrmservice.data.UserResponseData;
import sk.cyklosoft.hrmservice.vo.UserVO;

@RequestMapping("/mobil/userInfo")
public interface UserInfo {
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody void registerUser(@RequestBody UserVO user);

	@RequestMapping(value = "/userdetail/{username}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<UserResponseData> getUserDetail(@PathVariable String username);
	
	@RequestMapping(value = "/{username}/{birthdate}/{weight}/{lenght}", method = RequestMethod.POST)
    public @ResponseBody void setUserDetail(@PathVariable String username, @PathVariable String birthdate,
    		@PathVariable int weight, @PathVariable int lenght);

	@RequestMapping(value = "/delete", method = RequestMethod.PUT)
	public @ResponseBody void deleteUser(@RequestBody UserVO user);	
	
	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.POST)
    public @ResponseBody void loginUser(@PathVariable String username, @PathVariable String birthdate,
    		@PathVariable int weight, @PathVariable int lenght);
	
	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public @ResponseBody void logoutUser(@PathVariable String username, @PathVariable String birthdate,
    		@PathVariable int weight, @PathVariable int lenght);
    		
	
}
