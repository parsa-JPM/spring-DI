import consumer.MyApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.MessageService;

@Configuration
@ComponentScan(value = {"consumer"})
public class MyAppTest {
    private AnnotationConfigApplicationContext context;

    @Bean
    public MessageService getMessage() {
        return new MessageService() {
            public boolean sendMessage(String msg, String rec) {
                System.out.println(rec + " " + msg);
                return true;
            }
        };
    }


    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(MyAppTest.class);
    }

    @After
    public void tearDown() {
        context.close();
    }

    @Test
    public void test() {
        MyApp app = context.getBean(MyApp.class);
        app.processMessage("Hi there", "Parsa");
    }
}
