package dp_6;

import javax.swing.*;

public class SolitaerMain {

    public static void main(String[] args) {
        Solitaer solitaer = new Solitaer();
        SwingUtilities.invokeLater(solitaer::showGUI);
    }
}
