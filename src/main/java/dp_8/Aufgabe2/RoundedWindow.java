package dp_8.Aufgabe2;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;

public class RoundedWindow extends DecoratorWindow {

    RoundedWindow(Component window) {
        super(window);
        this.window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                getWindow().setShape(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));
            }
        });
    }
}
