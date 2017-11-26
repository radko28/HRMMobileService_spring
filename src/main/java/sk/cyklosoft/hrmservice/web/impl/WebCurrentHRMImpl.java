package sk.cyklosoft.hrmservice.web.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import sk.cyklosoft.hrmservice.vo.CurrentHRM;

@Controller
public class WebCurrentHRMImpl {

	@MessageMapping("/currentHRM")
	@SendTo("/topic/currentHRM")
	public CurrentHRM getCurrentHRM(HelloMessage message) throws Exception {
		String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
		//read value from DB
		Random  rnd = new Random();
		int currentHRM = rnd.nextInt((180 - 135) + 1) + 135;
		
		return new CurrentHRM(currentHRM, time);
	}
}
