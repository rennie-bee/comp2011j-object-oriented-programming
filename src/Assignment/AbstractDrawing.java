package Assignment;

import java.awt.*;

public abstract class AbstractDrawing {
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    public AbstractDrawing(double x1, double y1, double w1, double h1) {
        x = x1;
        y = y1;
        width = w1;
        height = h1;
    }


    public abstract void draw(Graphics g);
}
