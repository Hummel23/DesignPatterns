package dp_2;


class JDBCExampleSingleton extends JDBCExample {


    private static JDBCExampleSingleton instance;
    static int counterOfNewInstances = 0;
    static int callOfInstances = 0;

    private JDBCExampleSingleton() {
        super();

    }

    static JDBCExampleSingleton getInstance() {
        if(instance == null) {
            counterOfNewInstances ++;
            return instance = new JDBCExampleSingleton();
        } else {
            callOfInstances ++;
            return instance;
        }
    }


}