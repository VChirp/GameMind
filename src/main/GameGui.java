package main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameGui {

    private GameLogic logic = new GameLogic();
    private MyPoint[][] status = logic.getStatus();

    GameGui() {
        showGUI();
    }

    private JLabel[][] createLabels(MyPoint[][] status) {
        JLabel[][] labels = new JLabel[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                labels[i][j] = new JLabel("" + status[i][j].getValue()) {
                    public void paintComponent(Graphics g) {
                        //draw background
                        Color old = g.getColor();
                        g.setColor(getBackground());
                        g.fillRect(0, 0, getWidth(), getHeight());
                        g.setColor(old);
                        super.paintComponent(g);
                    }
                };
                final Point labelPoint = new Point();
                labelPoint.setLocation(i, j);
                labels[i][j].setForeground(Color.BLACK);
                labels[i][j].setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.gray));
                labels[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 48));
                labels[i][j].setBackground(Color.black);
                MouseAdapter mouseListener = new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(labelPoint);
                        logic.userClick(labelPoint.x, labelPoint.y);
                        JLabel labelOnClick;
                        labelOnClick = (JLabel) e.getComponent();
                        labelOnClick.setBackground(Color.green);
                        SwingUtilities.invokeLater(() -> {
                            try {
                                for (int i = 0; i < 4; i++) {
                                    for (int j = 0; j < 4; j++) {
                                        if (status[i][j].isWasSelected()) {
                                            labels[i][j].setBackground(Color.green);
                                        } else {
                                            labels[i][j].setBackground(Color.black);
                                        }
                                    }
                                }
                                Thread.sleep(500);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        });
                        super.mouseClicked(e);
                    }
                };
                labels[i][j].addMouseListener(mouseListener);
            }
        }
        return labels;
    }

    private void showGUI() {
        JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Display the window.
        JLabel[][] labels = createLabels(status);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label = labels[i][j];
                frame.add(label);
            }
        }

        frame.setLayout(new GridLayout(4, 4));
        frame.pack();
        frame.setVisible(true);
    }
}
