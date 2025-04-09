package pro1.swingComponents;

import pro1.drawingModel.Drawable;
import pro1.drawingModel.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    DrawingPanel drawingPanel;
    private int lastX;
    private int lastY;

    public MainFrame(Drawable example) {
        setTitle("PRO1 Graphics");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingPanel = new DrawingPanel(example);
        add(drawingPanel, BorderLayout.CENTER);
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(
                new Dimension(200,0));
        add(leftPanel, BorderLayout.WEST);
        JButton button = new JButton("Draw rectangle");
        JCheckBox checkBox = new JCheckBox("Random color");
        leftPanel.add(button);
        leftPanel.add(checkBox);
        Random random = new Random();
        String defaultColor = "#555555";
        defaultColor = "#444444";
        String defaultColor2 = defaultColor;
        button.addActionListener((e)->{
            String color = defaultColor2;
            if(checkBox.isSelected())
            {
                String red = String.format("%02X",random.nextInt(256));
                String green = String.format("%02X",random.nextInt(256));
                String blue = String.format("%02X",random.nextInt(256));
                color = "#"+red+green+blue;
            }
            else
            {
                color = "#000000";
            }
            drawingPanel.setImage(new Rectangle(lastX,lastY,40,40,color));
        });

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lastX = e.getX() - 400;
                lastY = e.getY() - 400;
            }
        });
    }
}