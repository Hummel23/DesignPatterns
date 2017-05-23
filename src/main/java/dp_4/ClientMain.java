package dp_4;

/**
 * Created by saba on 11.05.17.
 */
public class ClientMain {
    public static void main(String[] args) {

        Client client = new Client();

        Subject subject = client.concreteSubject;

        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.addObserver(observer1);
        subject.addObserver(observer2);


    }
    }
