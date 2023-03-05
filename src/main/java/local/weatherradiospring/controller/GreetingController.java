package local.weatherradiospring.controller;

import local.weatherradiospring.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return "Hello, " + message.getName() + "!";
    }
}
