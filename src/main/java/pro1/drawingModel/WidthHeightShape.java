package pro1.drawingModel;

public abstract class WidthHeightShape extends XYShape
{
    protected int height;
    protected int width;

    public WidthHeightShape(int x, int y, int height, int width) {
        super(x,y);
        this.height = height;
        this.width = width;
    }
}
