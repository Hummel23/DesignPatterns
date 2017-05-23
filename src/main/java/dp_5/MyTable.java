package dp_5;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
 
public class MyTable extends JPanel {
 
    private MyTable(Object[][] data) {
        super(new GridLayout(1,0));
 
        JTable table = new JTable(new MyTableModel(data));
        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
 
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Id", "Vorname", "Nachname"};
        
        private Object[][] data;
        
        MyTableModel(Object[][] data)
        {
        		this.data=data;
        }

 
        public int getColumnCount() {
            return columnNames.length;
        }
 
        public int getRowCount() {
            return data.length;
        }
 
        public String getColumnName(int col) {
            return columnNames[col];
        }
 
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowTable(Object[][] data) {
    	
        //Create and set up the window.
        JFrame frame = new JFrame("Mockuptable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        MyTable newContentPane = new MyTable(data);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}