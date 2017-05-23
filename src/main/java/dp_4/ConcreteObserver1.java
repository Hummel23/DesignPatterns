package dp_4;

import javax.swing.*;

/**
 * Created by saba on 11.05.17.
 */
public class ConcreteObserver1 extends JFrame implements Observer {

    Integer state;
    JLabel label;

    public ConcreteObserver1() {
        super("Observer 1");
        this.setSize(150, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        state = Integer.valueOf(0);
        JPanel panel = initPanel();

        this.add(panel);
        this.setVisible(true);
    }

    private JPanel initPanel() {
        JPanel panel = new JPanel();
        label = new JLabel(state.toString());
        panel.add(label);
        return panel;
    }

    @Override
    public void update(int state) {
        this.state = Integer.valueOf(state);
        System.out.println(" "  + state);
        label.setText(this.state.toString());
    }
}
