package dp_8.Aufgabe2;

import javax.swing.*;

public class DecoratorMain {

    public static void main(String[] args) {
        DecoratorWindow window = new RoundedWindow(new UnborderedWindow(new MoveableWindow(new JFrame())));

    }
}
