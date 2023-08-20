package Assignment;

import java.awt.*;

public class BuffSquare extends AbstractDrawing{
    Rectangle rectBuff;
    static int buffType = 0;

    public BuffSquare(double x, double y, double w, double h) {
        super(x, y, w, h);

    }

    public void setBuffx(double x) {
        this.x = x;
    }

    public double getBuffx() {
        return this.x;
    }

    public void setBuffy(double y) {
        this.y = y;
    }

    public double getBuffy() {
        return this.y;
    }

    public double getBuffw() {
        return this.width;
    }

    @Override
    public void draw(Graphics g) {
        if(buffType == 1) {
            g.setColor(Color.green);
        } else if (buffType == 2) {
            g.setColor(Color.blue);
        } else if (buffType == 3) {
            g.setColor(Color.white);
        } else if (buffType == 4) {
            g.setColor(Color.magenta);
        }

        g.fillRect((int)x, (int)y, (int)width, (int)height);
        rectBuff = new Rectangle((int)x, (int)y, (int)width, (int)height);

    }
}
