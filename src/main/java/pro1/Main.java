package pro1;

import pro1.drawingModel.*;
import pro1.swingComponents.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            /*Group g1 = new Group(new Drawable[]{
                    new Ellipse(20, 10, 200, 200, "#F0F377"),
                    new Rectangle(200, 300, 300, 300, "#B4FF77"),
                    new Line(120, 110, 350, 450, 10, "#E2AD00")
            }, 0, 0.6, 0.6);
            Group g2 = new Group(new Drawable[]{
                    new Ellipse(20, 10, 200, 200, "#F0F377"),
                    new Rectangle(200, 300, 300, 300, "#B4FF77"),
                    new Line(120, 110, 350, 450, 10, "#E2AD00")
            }, 60, 0.4, 0.4);
            Group g3 = new Group(new Drawable[]{g1, g2}, 0, 1, 1);*/
            new MeasurementFrame();
        });
    }
}