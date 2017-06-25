package dp_8.Aufgabe2;


import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public abstract class DecoratorWindow extends Component {
    @Getter
    JFrame window;
    int width = 500;
    int height = 500;


    DecoratorWindow(Component window) {
        this.window = (JFrame) window;
        this.window.setSize(width, height);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
    }


}
