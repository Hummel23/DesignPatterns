package dp_5;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by saba on 18.05.17.
 */
public class MyTableMain {

    public static void main(String[] args) {
       Adapter tableAdapter = new Adapter("s0550668", "password");

        invokeLater(() -> MyTable.createAndShowTable(tableAdapter.createTableData()));
    }
}
