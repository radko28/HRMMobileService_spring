package sk.cyklosoft.hrmservice.web.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketImpl {
	
	@MessageMapping("/gs-guide-websocket")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
		String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
	    return new Greeting(message.getFrom(), message.getText(), time);
   }


}
