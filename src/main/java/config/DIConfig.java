package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.EmailService;
import services.MessageService;

@Configuration
@ComponentScan(value = {"consumer"})
public class DIConfig {

    @Bean
    public MessageService getMessageService() {
        return new EmailService();
    }
}
