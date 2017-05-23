package dp_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saba on 11.05.17.
 */
public class ConcreteSubject implements Subject {
    List<Observer> observers = new ArrayList<>();

    Integer state;

    ConcreteSubject(Integer state) {
        this.state = state;
    }

    @Override
    public void addObserver(Observer observer) {
        observer.update(state);
        this.observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyAllObservers(int state) {
        for (Observer observer : observers) {
            observer.update(state);
        }


    }

    public void updateState(int state) {
        this.state = state;
        System.out.println(this.observers.size());

        this.notifyAllObservers(state);
    }
}
