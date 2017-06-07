package dp_6;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.BorderLayout.*;
import static javax.swing.JFrame.*;
import static javax.swing.JOptionPane.*;


class Solitaer {

    @Getter
    private JFrame gui;
    private JPanel mainPanel;

    @Getter
    @Setter
    Model model;

    Solitaer() {
        this.model = new Model();
    }

    void showGUI() {
        gui = new JFrame("Solitaer");

        mainPanel = new MyPanel();
        JPanel buttonPanel = createButtonPanel();

        gui.add(mainPanel, CENTER);
        gui.add(buttonPanel, SOUTH);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setSize(750, 700);
        gui.setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton undo = new JButton("undo");
        JButton newGame = new JButton("new game");

        buttonPanel.add(undo);
        buttonPanel.add(newGame);

        undo.addActionListener(e -> {
            boolean moveSuccessful = getModel().undoMove();
            if (moveSuccessful) {
                mainPanel.repaint();
            } else {
                showMessageDialog(mainPanel,
                        "There are no moves to undo.",
                        "Error",
                        ERROR_MESSAGE);
            }
        });

        newGame.addActionListener(e -> {
            setModel(new Model());
            mainPanel.repaint();
        });

        return buttonPanel;
    }


    private class MyPanel extends JPanel implements MouseListener {
        boolean moveStarted = false;
        Point startPoint;
        Point endPoint;

        MyPanel() {
            this.addMouseListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int row = 0; row < 7; row++)
                for (int col = 0; col < 7; col++) {
                    g.setColor(Color.WHITE);
                    g.draw3DRect(100 + row * 80, 100 + col * 80, 80, 80, true);
                    if (model.field[row][col] == State.NOT) {
                        g.setColor(Color.LIGHT_GRAY);
                        g.fill3DRect(100 + col * 80, 100 + row * 80, 80, 80, true);
                    } else if (model.field[row][col] == State.FREE) {
                        g.setColor(Color.green);
                        g.fill3DRect(100 + col * 80, 100 + row * 80, 80, 80, true);
                    } else if (model.field[row][col] == State.USED) {
                        g.setColor(Color.green);
                        g.fill3DRect(100 + col * 80, 100 + row * 80, 80, 80, true);
                        g.setColor(Color.red);
                        g.fillOval(130 + 80 * col, 130 + 80 * row, 20, 20);
                    }
                }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int row = (y - 100) / 80;
            int col = (x - 100) / 80;
            if (moveStarted) {
                endPoint = new Point(row, col);
                boolean moveSuccessful = model.move(new Move(startPoint, endPoint));
                if (moveSuccessful) {
                    this.repaint();
                    if (model.gameIsWon()) {
                        int n = showConfirmDialog(mainPanel,
                                "Well done! You won... \n Would you like to play again?",
                                "Congratulations",
                                YES_NO_OPTION);
                        if (n == YES_OPTION) {
                            setModel(new Model());
                            this.repaint();
                        } else {
                            getGui().setVisible(false);
                            getGui().dispose();
                        }
                    }
                } else{
                    showMessageDialog(mainPanel,
                            "This move is not allowed.",
                            "Error",
                            ERROR_MESSAGE);
                }
                moveStarted = false;
            } else {
                moveStarted = true;
                startPoint = new Point(row, col);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    }


