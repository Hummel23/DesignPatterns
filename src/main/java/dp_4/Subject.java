package dp_4;

interface Subject {

    void addObserver(Observer observer);

    //void removeObserver(Observer observer);

    void notifyAllObservers(int state);

}
