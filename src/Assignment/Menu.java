package Assignment;

import java.awt.*;



public class Menu {
    private int xWelcome, yWelcome;
    private int xStart, yStart;
    private int xHigh, yHigh;
    private int xHelp, yHelp;
    private int xExit, yEXit;
    private int xLoad, yLoad;

    private Color colorStart = Color.green;
    private Color colorHelp = Color.white ;
    private Color colorHigh = Color.white ;
    private Color colorExit = Color.white ;
    private Color colorLoad = Color.white;

    private boolean getHelp;
    private boolean getHigh;

    private String playerName;
    private int grade;
    static int[] gradeArray = {0, 0, 0, 0, 0, 0, 0};
    static String[] playerArray2 = {"none", "none", "none","none", "none", "none", "none"};



    public void setColorStart(Color colorStart) {
        this.colorStart = colorStart;
    }

    public void setColorHelp(Color colorHelp) {
        this.colorHelp = colorHelp;
    }

    public void setColorHigh(Color colorHigh) {
        this.colorHigh = colorHigh;
    }

    public void setColorExit(Color colorExit) {
        this.colorExit = colorExit;
    }

    public void setGetHelp(boolean getHelp) {
        this.getHelp = getHelp;
    }

    public void setGetHigh(boolean getHigh) {
        this.getHigh = getHigh;
    }

    public void setColorLoad(Color colorLoad) {
        this.colorLoad = colorLoad;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Menu(int xWelcome, int yWelcome, int xStart, int yStart, int xHelp, int yHelp, int xHigh, int yHigh, int xExit, int yEXit, int xLoad, int yLoad) {
        this.xWelcome = xWelcome;
        this.yWelcome = yWelcome;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xHigh = xHigh;
        this.yHigh = yHigh;
        this.xHelp = xHelp;
        this.yHelp = yHelp;
        this.xExit = xExit;
        this.yEXit = yEXit;
        this.xLoad = xLoad;
        this.yLoad = yLoad;
    }



    public void drawMenu(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1200, 800);
        g.setColor(Color.black);
        g.fillRect(60, 30, 1000, 140);
        g.fillRect(1000, 30, 120, 650);
        for (int i = 0; i < 5; i++) {
            g.fillRect(995 - 5 * i, 685 + 10 * i, 120, 5);
        }
        g.setColor(Color.ORANGE);
        Font newFont = new Font("MV Boli", Font.BOLD, 70);
        g.setFont(newFont);
        g.drawString(winPicture.menuString[0], xWelcome, yWelcome);
        Font newFont2 = new Font("Comic Sans MS", Font.BOLD, 40);
        g.setFont(newFont2);
        g.setColor(colorStart);
        g.drawString(winPicture.menuString[1], xStart, yStart);
        g.setColor(colorHelp);
        g.drawString(winPicture.menuString[2], xHelp, yHelp);
        g.setColor(colorHigh);
        g.drawString(winPicture.menuString[3], xHigh, yHigh);
        g.setColor(colorExit);
        g.drawString(winPicture.menuString[4], xExit, yEXit);
        g.setColor(colorLoad);
        g.drawString(winPicture.menuString[5], xLoad, yLoad);
        g.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
        g.drawString(winPicture.menuString[6], xLoad, yLoad + 20);
        if (this.getHelp) {
            backGround(g);
            g.drawString(winPicture.helpString[1], xWelcome - 30, yWelcome + 40);
            g.drawString(winPicture.helpString[2], xWelcome - 30, yWelcome + 80);
            g.drawString(winPicture.helpString[3], xWelcome - 30, yWelcome + 120);
            g.drawString(winPicture.helpString[4], xWelcome - 5, yWelcome + 160);
            g.drawString(winPicture.helpString[5], xWelcome - 30, yWelcome + 200);
            g.drawString(winPicture.helpString[6], xWelcome - 30, yWelcome + 240);
            g.drawString(winPicture.helpString[7], xWelcome - 5, yWelcome + 300);
            g.drawString(winPicture.helpString[8], xWelcome - 5, yWelcome + 360);
            g.drawString(winPicture.helpString[9], xWelcome + 20, yWelcome + 400);
            g.drawString(winPicture.helpString[10], xWelcome - 5, yWelcome + 460);
            g.drawString(winPicture.helpString[11], xWelcome + 20, yWelcome + 500);
            g.drawString(winPicture.helpString[12], xWelcome - 5, yWelcome + 560);

            g.setColor(Color.green);
            g.fillRect(1100, 400,20,20);
            g.setColor(Color.blue);
            g.fillRect(1100, 490, 20, 20);
            g.setColor(Color.white);
            g.fillRect(1100, 580, 20, 20);
            g.setColor(Color.magenta);
            g.fillRect(1100, 670, 20, 20);

        }
        if (this.getHigh) {
            backGround(g);
            g.drawString("1. " + playerArray2[0], xWelcome - 30, yWelcome + 40);
            g.drawString("2. " + playerArray2[1], xWelcome - 30, yWelcome + 100);
            g.drawString("3. " + playerArray2[2], xWelcome - 30, yWelcome + 160);
            g.drawString("4. " + playerArray2[3], xWelcome - 30, yWelcome + 220);
            g.drawString("5. " + playerArray2[4], xWelcome - 30, yWelcome + 280);
            g.drawString("6. " + playerArray2[5], xWelcome - 30, yWelcome + 340);
            g.setColor(Color.cyan);
            g.drawString(" " + gradeArray[0], xWelcome + 230, yWelcome + 40);
            g.drawString(" " + gradeArray[1], xWelcome + 230, yWelcome + 100);
            g.drawString(" " + gradeArray[2], xWelcome + 230, yWelcome + 160);
            g.drawString(" " + gradeArray[3], xWelcome + 230, yWelcome + 220);
            g.drawString(" " + gradeArray[4], xWelcome + 230, yWelcome + 280);
            g.drawString(" " + gradeArray[5], xWelcome + 230, yWelcome + 340);

        }

    }

    public void backGround(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 1200, 800);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        if(this.getHelp){g.drawString(winPicture.helpString[0], xWelcome + 325, yWelcome - 20);}
        if(this.getHigh){g.drawString("Score Rank", xWelcome + 325, yWelcome - 20);}
        g.setColor(Color.white);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
    }



}
