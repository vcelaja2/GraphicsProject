package pro1.swingComponents;

import pro1.drawingModel.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MeasurementFrame extends JFrame {
    DrawingPanel drawingPanel;
    private int firstX;
    private int firstY;
    private int lastX;
    private int lastY;
    private int meters;
    boolean isFirstClick = true;

    public MeasurementFrame() {
        Ellipse drawable = new Ellipse(0, 0, 0, 0, "#000000");
        setTitle("PRO1 graphics project");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingPanel = new DrawingPanel(drawable);
        add(drawingPanel, BorderLayout.CENTER);
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(
                new Dimension(200,0));
        add(leftPanel, BorderLayout.WEST);
        JTextField text = new JTextField("1",20);
        leftPanel.add(text);
        JLabel label = new JLabel("Nakreslená úsečka měří: 0m");
        leftPanel.add(label);

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    meters = Integer.parseInt(text.getText());
                } catch (NumberFormatException ex) {
                    meters = 0;
                }
                firstX = lastX;
                firstY = lastY;
                lastX = e.getX() - 400;
                lastY = e.getY() - 400;
                if (isFirstClick == false) {
                    long result = (long) Math.sqrt((Math.pow((lastX-firstX), 2))+Math.pow((lastY-firstY), 2));
                    drawingPanel.setImage(new Line(firstX,firstY,lastX,lastY,5,"#444444"));
                    label.setText("Nakreslená úsečka měří: "+meters*result+"m");
                    label.repaint();
                }
                isFirstClick = false;
            }
        });
    }
}
