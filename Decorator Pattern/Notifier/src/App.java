interface NotifierInterface {
    void send(String message);
}

class NotifierClass implements NotifierInterface{
    @Override
    public void send(String message){
        System.out.println("Sending message..");
    }
}

class baseDecorator extends NotifierClass{
    private NotifierClass wrapper;

    baseDecorator(NotifierClass notifier){
        this.wrapper = notifier;
    }

    public void send(String message){
        wrapper.send(message);
    }
}

class slackNotifier extends baseDecorator{

    slackNotifier(NotifierClass notifier){
        super(notifier);
        System.out.println("Sending message by Slack!!");
    }

    public void send(String message){
        super.send(message);
    }
}

class emailNotifier extends baseDecorator{

    emailNotifier(NotifierClass notifier){
        super(notifier);
        System.out.println("Sending message by Email!!");
    }

    public void send(String message){
        super.send(message);
    }
}

class smsNotifier extends baseDecorator{

    smsNotifier(NotifierClass notifier){
        super(notifier);
        System.out.println("Sending message by SMS!!");
    }

    public void send(String message){
        super.send(message);
    }
}

class facebookNotifier extends baseDecorator{

    facebookNotifier(NotifierClass notifier){
        super(notifier);
        System.out.println("Sending message by Facebook!!");
    }

    public void send(String message){
        super.send(message);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        NotifierClass notifier = new smsNotifier(new facebookNotifier(new slackNotifier(new NotifierClass())));
        notifier.send("Hello World!!");
    }
}
