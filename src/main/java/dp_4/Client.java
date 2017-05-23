package dp_4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame{

    private Integer state = Integer.valueOf(0);
    JLabel label;
    ConcreteSubject concreteSubject;

    Client() {
        super("Client");
        concreteSubject = new ConcreteSubject(state);

        this.setSize(150, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = initPanel();

        this.add(panel);

        this.setVisible(true);
    }

    private JPanel initPanel() {
        JPanel panel = new JPanel();
        label = new JLabel(state.toString());
        JButton button = initButton();
        panel.add(this.label);
        panel.add(button);
        return panel;
    }

    private JButton initButton() {
        JButton button = new JButton("++");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state++;
                concreteSubject.updateState(state);
                label.setText(state.toString());
            }
        });
        return button;
    }
}
