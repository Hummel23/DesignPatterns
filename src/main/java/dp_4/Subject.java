package dp_4;

/**
 * Created by saba on 11.05.17.
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyAllObservers(int state);

}
