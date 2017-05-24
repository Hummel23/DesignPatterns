package dp_4;

import javax.swing.*;

public class ConcreteObserver2 extends JFrame implements Observer {

    Integer state;
    JLabel label;

    public ConcreteObserver2() {
        super("Observer 2");
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
        label.setText(this.state.toString());
    }
}
