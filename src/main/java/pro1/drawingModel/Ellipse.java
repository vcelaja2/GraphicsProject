package pro1.drawingModel;

import java.awt.*;

public class Ellipse extends WidthHeightShape {

    private String color; // Např.#FF56A1

    public Ellipse(int x, int y, int width, int height, String color) {
        super(x,y,height,width);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));
        g.fillOval(x,y,width,height);
    }
}
