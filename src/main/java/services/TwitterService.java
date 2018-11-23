package services;

public class TwitterService implements MessageService {
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter : " + rec + "\n" + msg);
        return true;
    }
}
