package dp_8.Aufgabe2;

import java.awt.*;

public class UnborderedWindow extends DecoratorWindow {

    UnborderedWindow(Component window) {
        super(window);
        this.window.setUndecorated(true);
    }

}
