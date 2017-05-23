package dp_2;

/**
 * Created by saba on 27.04.17.
 */
public class JDBC_main {

    public static void main(String[] args) {

        JDBCExample jdbConnection = new JDBCExample();

        jdbConnection.printAll();
        jdbConnection.close();

        JDBCExampleSingleton.getInstance().printAll();
        JDBCExampleSingleton.getInstance().close();

    }
}
