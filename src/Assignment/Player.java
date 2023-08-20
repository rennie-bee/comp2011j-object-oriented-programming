package Assignment;

import java.awt.*;

public class Player extends AbstractDrawing {
    Rectangle rectPlayer;
    public Player(double x, double y, int w, int h){
        super(x, y, w, h);
    }

    public double getPlayerX() {
        return this.x;
    }

    public double getPlayerY() {
        return this.y;
    }

    public void setPlayerX(double newX) {
        this.x = newX;
    }

    public double getPlayerW() { return this.width; }

    public double getPlayerH() { return this.height; }

    public void setPlayerW(double w) {
        this.width = w;
    }

    public void draw(Graphics g) {
        g.setColor(Color.pink);
        g.fill3DRect((int)x, (int)y, (int)width, (int)height, true);
        rectPlayer = new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
}
