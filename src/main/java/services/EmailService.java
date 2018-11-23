package services;

public class EmailService implements MessageService {
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email : " + rec + "\n" + msg);
        return true;
    }
}
