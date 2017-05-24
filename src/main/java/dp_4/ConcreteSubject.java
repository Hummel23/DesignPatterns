package dp_4;

import java.util.ArrayList;
import java.util.List;

class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    private Integer state;

    ConcreteSubject(Integer state) {
        this.state = state;
    }

    @Override
    public void addObserver(Observer observer) {
        observer.update(state);
        this.observers.add(observer);

    }

/*    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);

    }*/

    @Override
    public void notifyAllObservers(int state) {
        for (Observer observer : observers) {
            observer.update(state);
        }


    }

    void updateState(int state) {
        this.state = state;
        System.out.println(this.observers.size());

        this.notifyAllObservers(state);
    }
}
