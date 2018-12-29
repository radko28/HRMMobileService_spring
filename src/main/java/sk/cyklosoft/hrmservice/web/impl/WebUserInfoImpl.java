package sk.cyklosoft.hrmservice.web.impl;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sk.cyklosoft.hrmservice.config.annotation.WebController;
import sk.cyklosoft.hrmservice.service.UserService;
import sk.cyklosoft.hrmservice.vo.UserVO;
import sk.cyklosoft.hrmservice.web.WebUserInfo;


@WebController
public class WebUserInfoImpl implements WebUserInfo {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getView(Model model, Locale locale) {
		return "homeView";
    }
	
	@RequestMapping(value = {"/currentHRM"}, method = RequestMethod.GET)
    public String getCurrentHRM(Model model, Locale locale) {
		return "currentHRM";
    }
	
	@RequestMapping(value = {"admin/register","register"}, method = RequestMethod.GET)
    public String addUser(Model model, Locale locale) {
        model.addAttribute("user", new UserVO());
        //model.addAttribute("categoryList", productService.findAllCategories());
        //if(AppHelper.hasAdminRole()) {
            //model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        //}
        return "userAddView";
    }
    
    @RequestMapping(value = {"admin/register","register"}, method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")
    @Valid UserVO user, BindingResult result, Model model, Locale locale) {
        String page = null;
        if(result.hasErrors()) {
            page = "userAddView";
        } else {
            userService.registerUser(user);
            //if(AppHelper.hasAdminRole()) {
              page = "redirect:userList";
            //} else {
            // page = "redirect:login";
            //}
            //page = "redirect:index";
        }
        return page;
    }
    
    @RequestMapping(value = {"admin/userList"}, method = RequestMethod.GET)
    public String getAdminUserList(Model model, Locale locale) {
        String page = null;
        page = "userListView";
        model.addAttribute("userList", userService.findAllUsers());
        model.addAttribute("wholeName", userService.getWholeNameByUsername("AppHelper.getUsername()"));
        return page;
    }
    
    @RequestMapping(value = {"admin/deleteUser", "deleteUser"}, method = RequestMethod.GET)
    public String deleteUser(@RequestParam(value = "userId", required = true)
    	String userId,Model model, Locale locale) {
           //delete user
    	userService.deleteUser(Long.parseLong(userId));
    	return "redirect:userList";
    }
    	
/*        String page = null;
        page = "userListView";
        userService.deleteUser("username");
        model.addAttribute("userList", userService.findAllUsers());
        model.addAttribute("wholeName", userService.getWholeNameByUsername("AppHelper.getUsername()"));
        return page;
    }*/
    
    @RequestMapping(value = {"admin/userDetail","userDetail"}, method = RequestMethod.GET)
    public String userDetail(@RequestParam(value = "userId", required = true)
    String userId,Model model, Locale locale) {
        model.addAttribute("user", userService.getUserById(Long.parseLong(userId)));    	
    	model.addAttribute("wholeName", userService.getWholeNameByUsername("AppHelper.getUsername()"));
        return "userView";
    }
    
    @RequestMapping(value = {"admin/editUser", "editUser"}, method = RequestMethod.GET)
    public String editUser(Model model, Locale locale) {
        //model.addAttribute("userList", userService.findAllUsers());
        model.addAttribute("wholeName", userService.getWholeNameByUsername("AppHelper.getUsername()"));
        return "editUserView";
    }
    /*
    @RequestMapping(value = {"admin/editUser","editUser"}, method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user")
    UserVO user, Model model, Locale locale) {
        String page = null;
        userService.updateUser(user);
        if(user.getAuthority().equals(RoleType.ROLE_ADMIN.toString())) {
            AppHelper.initUser(user.getUsername(), RoleType.ROLE_ADMIN.toString());
        }         
        if(AppHelper.hasAdminRole()) {        
            page = "redirect:userList";
        } else {
            page = "redirect:userIndex";
        }
        return page;
    }*/
    




	
}
