import config.DIConfig;
import consumer.MyApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApp {
    public static void main(String[] args) {

        /*
         it’s used for autowiring the services to components.
          */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);

        //it is injecting the component
        MyApp app = context.getBean(MyApp.class);

        app.processMessage("Hi Parsa", "codefather.ir");

        //close the context
        //Context objects are resource intensive, so we should close them when we are done with it
        context.close();
    }
}
