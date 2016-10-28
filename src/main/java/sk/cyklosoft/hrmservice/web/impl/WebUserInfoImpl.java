package sk.cyklosoft.hrmservice.web.impl;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import sk.cyklosoft.hrmservice.config.annotation.WebController;
import sk.cyklosoft.hrmservice.web.WebUserInfo;

@WebController
public class WebUserInfoImpl implements WebUserInfo {
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String getView(Model model, Locale locale) {
		return "index";
    }
}
