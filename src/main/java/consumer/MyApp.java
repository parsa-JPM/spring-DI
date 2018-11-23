package consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.MessageService;

@Component
public class MyApp {
    private MessageService service;

    @Autowired
    public void setService(MessageService service) {
        this.service = service;
    }

    public boolean processMessage(String msg, String rec) {
        //some magic like validation, logging etc
        return this.service.sendMessage(msg, rec);
    }
}
