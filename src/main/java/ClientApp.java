import config.DIConfig;
import consumer.MyApp;
import consumer.MyXMLApp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {
    public static void main(String[] args) {
        annotationBased();
        xmlBased();
    }


    /**
     * DI with annotation method
     */
    private static void annotationBased() {
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

    /**
     * DI with XML method
     */
    private static void xmlBased() {

        //is used to get the ApplicationContext object by providing the configuration files location
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "appContext.xml");

        /**
         * Rest of the code is similar to annotation based
         */

        MyXMLApp app = context.getBean(MyXMLApp.class);

        app.processMessage("Hi Pankaj", "pankaj@abc.com");

        // close the context
        context.close();
    }
}
