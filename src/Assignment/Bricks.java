package Assignment;

import java.awt.*;

public class Bricks extends AbstractDrawing{
    private Boolean visible;
    Rectangle rectBrick;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }


    public Bricks(double x, double y, double w, double h) {
        super(x, y, w, h);
        visible = false;
    }

    public double getwBrick() {
        return width;
    }

    public double gethBrick() {
        return height;
    }

    public double getxBrick() {
        return x;
    }

    public double getyBrick() {
        return y;
    }

    public void draw(Graphics g) {
        if (visible) {
            g.setColor(Color.ORANGE);
            g.fill3DRect((int)x, (int)y, (int)width, (int)height, true);
            g.setColor(Color.magenta);
            //     g.drawRect(xBrick, yBrick, wBrick, hBrick);
            rectBrick = new Rectangle((int)x, (int)y, (int)width, (int)height);
        } else {
            rectBrick = new Rectangle(0,0,0,0);
        }

    }
}
