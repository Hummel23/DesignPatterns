package dp_6;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Solitaer {
    JPanel mainPanel;
    JButton undo, newGame;

    @Getter
    @Setter
    Model model;

    Solitaer() {
        this.model = new Model();
    }

    void showGUI() {
        JFrame gui = new JFrame("Solitaer");
        this.mainPanel = new MyPanel();
        gui.add(mainPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        this.undo = new JButton("undo");
        this.newGame = new JButton("new game");
        buttonPanel.add(undo);
        // hier der ActionListener für den undo-Button
        buttonPanel.add(newGame);
        newGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setModel(new Model());
                mainPanel.repaint();

            }

        });
        gui.add(buttonPanel, BorderLayout.SOUTH);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(750, 700);
        gui.setVisible(true);
    }

    class MyPanel extends JPanel implements MouseListener {
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
                    model.checkWin();
                } else{
                    JOptionPane.showMessageDialog(mainPanel,
                            "This move is not allowed.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
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


