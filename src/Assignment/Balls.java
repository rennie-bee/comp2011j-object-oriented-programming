package Assignment;

import java.awt.*;

public class Balls extends AbstractDrawing{
    private Rectangle rectBall;
    public Balls(double x, double y, int w, int h){
        super(x, y, w, h);
    }

    public double getBallX() {
        return x;
    }

    public double getBallY() {
        return y;
    }

    public void setBallX(double newX) {
        x = newX;
    }

    public void setBallY(double newY) {
        y = newY;
    }


    public Rectangle getRectBall() {
        return rectBall;
    }

    public double getWidthBall() {
        return width;
    }

    public double getHeightBall() {
        return height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, (int)width, (int)height);
        rectBall = new Rectangle((int)x, (int)y, (int)width, (int)height);

    }



}
