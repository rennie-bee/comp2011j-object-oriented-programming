package Assignment;

import java.awt.*;


public class PauseMenu {
    private int xPause;
    private int yPause;
    private int wPause;
    private int hPause;
    private Color colorResume = Color.green;
    private Color colorBackMenu = Color.white;

    public PauseMenu(int xPause, int yPause, int wPause, int hPause) {
        this.xPause = xPause;
        this.yPause = yPause;
        this.wPause = wPause;
        this.hPause = hPause;
    }

    public void setColorResume(Color colorResume) {
        this.colorResume = colorResume;
    }

    public void setColorBackMenu(Color colorBackMenu) {
        this.colorBackMenu = colorBackMenu;
    }

    public void drawPauseMenu(Graphics g) {
        g.setColor(Color.darkGray);
        g.fill3DRect(xPause, yPause, wPause, hPause, true);
        g.setColor(Color.GRAY);
        g.fillRect(xPause + 25, yPause + 25, wPause - 50, hPause - 50);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        g.drawString("Game Paused" ,xPause + 142, yPause + 100);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.setColor(colorResume);
        g.drawString("Resume Game", xPause + 200, yPause + 180);
        g.setColor(colorBackMenu);
        g.drawString("Back To Menu", xPause + 195, yPause + 250);
        g.setColor(colorResume);
        g.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        g.drawString("(Press 'P' again)", xPause + 220, yPause + 200);
    }
}
