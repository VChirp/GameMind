import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

class GameGui {

    GameGui(MyPoint[][] gameArr) {
        showGUI(gameArr);
    }

    private int clickCount = 0;
    private JLabel firstPoint;
    private JLabel secondPoint;

    private JLabel[][] createLabels(MyPoint[][] gameArr) {
        JLabel[][] labels = new JLabel[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                labels[i][j] = new JLabel("" + gameArr[i][j].getX()) {
                    public void paintComponent(Graphics g) {
                        //draw background
                        Color old = g.getColor();
                        g.setColor(getBackground());
                        g.fillRect(0, 0, getWidth(), getHeight());
                        g.setColor(old);
                        super.paintComponent(g);
                    }
                };
                final String k=""+i+":"+j;
                labels[i][j].setForeground(Color.BLACK);
                labels[i][j].setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.gray));
                labels[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 48));
                labels[i][j].setBackground(Color.black);
                MouseAdapter mouseListener = new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(k);
                        super.mouseClicked(e);
                        JLabel labelOnClick;
                        labelOnClick = (JLabel) e.getComponent();
                        labelOnClick.setBackground(Color.green);
                        System.out.println(labelOnClick.getText());
                        clickCount++;
                        System.out.println("Cli: " + clickCount);

                        if (clickCount == 2) {
                            secondPoint = labelOnClick;
                            if (Objects.equals(firstPoint.getText(), secondPoint.getText())) {
                                clickCount = 0;
                                System.out.println("yey");
                            } else {
                                SwingUtilities.invokeLater(() -> {
                                    try {
                                        firstPoint.setBackground(Color.black);
                                        secondPoint.setBackground(Color.black);
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e1) {
                                        e1.printStackTrace();
                                    }
                                });
                                clickCount = 0;
                            }
                        } else if (clickCount == 1) {
                            firstPoint = labelOnClick;
                        }
                    }
                };
                labels[i][j].addMouseListener(mouseListener);
            }
        }
        return labels;
    }

    private void showGUI(MyPoint[][] gameArr) {
        JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Display the window.
        JLabel[][] labels = createLabels(gameArr);
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
