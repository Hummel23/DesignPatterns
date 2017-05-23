package dp_2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JDBCExampleSingletonTest {

    @Test
    public void shouldCreateASingletonConnection() throws Exception {
        JDBCExampleSingleton.getInstance().printAll();
        assertThat(String.format("Expected count of instances is 1, but is %s", JDBCExampleSingleton.counterOfNewInstances),
                JDBCExampleSingleton.counterOfNewInstances, is(1));
        assertThat(String.format("Expected calls of instance is 0, but is %s", JDBCExampleSingleton.callOfInstances),
                JDBCExampleSingleton.callOfInstances, is(0));

        JDBCExampleSingleton.getInstance().printAll();
        assertThat(String.format("Expected count of instances is 1, but is %s", JDBCExampleSingleton.counterOfNewInstances),
                JDBCExampleSingleton.counterOfNewInstances, is(1));
        assertThat(String.format("Expected calls of instance is 1, but is %s", JDBCExampleSingleton.callOfInstances ),
                JDBCExampleSingleton.callOfInstances, is(1));

        JDBCExampleSingleton.getInstance().printAll();
        assertThat(String.format("Expected count of instances is 1, but is %s", JDBCExampleSingleton.counterOfNewInstances),
                JDBCExampleSingleton.counterOfNewInstances, is(1));
        assertThat(String.format("Expected calls of instance is 2, but is %s", JDBCExampleSingleton.callOfInstances ),
                JDBCExampleSingleton.callOfInstances, is(2));

        JDBCExampleSingleton.getInstance().printAll();
        assertThat(String.format("Expected count of instances is 1, but is %s", JDBCExampleSingleton.counterOfNewInstances),
                JDBCExampleSingleton.counterOfNewInstances, is(1));
        assertThat(String.format("Expected calls of instance is 3, but is %s", JDBCExampleSingleton.callOfInstances ),
                JDBCExampleSingleton.callOfInstances, is(3));

        JDBCExampleSingleton.getInstance().close();
        assertThat(String.format("Expected count of instances is 1, but is %s", JDBCExampleSingleton.counterOfNewInstances),
                JDBCExampleSingleton.counterOfNewInstances, is(1));
        assertThat(String.format("Expected calls of instance is 4, but is %s", JDBCExampleSingleton.callOfInstances ),
                JDBCExampleSingleton.callOfInstances, is(4));
    }
}
