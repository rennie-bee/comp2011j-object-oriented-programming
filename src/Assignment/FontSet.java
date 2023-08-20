package Assignment;

import java.awt.*;

public class FontSet {
    private int countBall = 3;
    private int score ;
    private int level = 1;
    private int brickNum = 0;
    private int xFont1, xFont2, xFont3, xFont4;
    private int yFont;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBrickNum() {
        return brickNum;
    }

    public void setBrickNum(int brickNum) {
        this.brickNum = brickNum;
    }

    public int getCountBall() {
        return countBall;
    }

    public void setCountBall(int countBall) {
        this.countBall = countBall;
    }


    public FontSet(int x1, int x2, int x3, int x4,  int y) {
        xFont1 = x1;
        xFont2 = x2;
        xFont3 = x3;
        xFont4 = x4;
        yFont = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        Font newFont = new Font("Comic Sans MS", Font.BOLD, 25);
        g.setFont(newFont);
        g.drawString("Ball(s): " + countBall, xFont1, yFont);
        g.drawString("Scores: " + score, xFont2, yFont);
        g.drawString("Levels: " + level, xFont3, yFont);
        g.drawString("Bricks: "  + brickNum, xFont4, yFont);
    }
}
