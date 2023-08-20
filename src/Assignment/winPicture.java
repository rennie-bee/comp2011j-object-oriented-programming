package Assignment;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Random;


public class winPicture extends JComponent {
    private boolean xDirect = true;
    private boolean yDirect = true;
    private boolean lifeLoss = false;
    private boolean pause = false;
    private boolean showMenu = true;
    private int counting = 0;
    private int bounceCount = 0;
    private Random r = new Random();
    private boolean moveableBall = true;
    private boolean reactSpace = true;
    private BuffSquare bs = new BuffSquare(-20, -20, 20, 20);

    protected int visibleNum = 0;
    protected int summaryOnce = 1;
    protected boolean sticky = false;
    protected boolean buffOn = false;
    protected boolean buffGot = false;
    protected BuffThread bt;
    protected Menu menu = new Menu(100, 120, 500, 300, 485, 400, 480, 500, 570, 600, 470, 680);
    protected PauseMenu pauseMenu = new PauseMenu(300, 200, 600, 400);
    protected Player player = new Player(540, 780, 120, 20);
    protected Balls ball = new Balls(590, 760, 20, 20);
    protected Bricks[] brick = new Bricks[100];
    protected FontSet font = new FontSet(5, 360, 715, 1050,30);


    static String[] menuString = new String[] {"Welcome to Brick Smasher", "New Game", "Getting Help", "Hall Of Fame", "Exit", "Load Last Try", "(Only works when the game is paused)"};
    static String[] helpString = new String[] {"Helpful Tips", "1.This game supports keyboard action.", "2.In main menu, use UP, DOWN, BACKSPACE & ENTER to access any sections.",
            "3.In game section, use SPACE to launch the ball(You might need to press twice if ","this is a new game); use LEFT & RIGHT to move the player;use P to pause the game.",
            "4.After losing all chances or finishing all 5 levels, you can put your name in the chat box.", "5.You have a few opportunities to trigger buffs below: (Buffs have time limit)", "(1)Double width",
            "(2)Laser shot: use F to clear bricks above you ", "(If a laser intersects 2 brick columns meanwhile, it won't make sense.)", "(3)Sticky paddle: The paddle owns the ability to 'grab' the ball",
            "You can use S to launch the ball at advance", "(4)Split Ball: Splitting into 3 balls." };


    public winPicture() {
        for (int i = 0; i < 10; i++) {
            brick[i] = new Bricks(i * 120, 70, 120, 30);
            brick[i + 10] = new Bricks(i * 120, 100, 120, 30);
            brick[i + 20] = new Bricks(i * 120, 130, 120, 30);
            brick[i + 30] = new Bricks(i * 120, 160, 120, 30);
            brick[i + 40] = new Bricks(i * 120, 190, 120, 30);
            brick[i + 50] = new Bricks(i * 120, 220, 120, 30);
            brick[i + 60] = new Bricks(i * 120, 250, 120, 30);
            brick[i + 70] = new Bricks(i * 120, 280, 120, 30);
            brick[i + 80] = new Bricks(i * 120, 310, 120, 30);
            brick[i + 90] = new Bricks(i * 120, 340, 120, 30);
        }
    }

    protected void paintComponent(Graphics g) {              // extra gifted method
        g.setColor(Color.BLACK);
        g.fillRect(0,40,1200,760);


        try {
           DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("Rank.txt")));
           for (int i = 0; i < Menu.gradeArray.length ; i++) {
               Menu.playerArray2[i] = dis.readUTF();
               Menu.gradeArray[i] = dis.readInt();
           }
        } catch (IOException e) {
           e.printStackTrace();
        }


        if (font.getLevel() == 1) {
            while (counting == 0) {
                for (int i = 10; i < 20; i++) {
                    brick[i].setVisible(true);
                    visibleNum++;
                }
                counting++;
                font.setBrickNum(visibleNum);
            }
            judgeLevel();

        }

        if (font.getLevel() == 2) {
            while (counting == 1) {
                for (int i = 0; i < 10; i++) {
                    brick[i].setVisible(true);
                    brick[i + 20].setVisible(true);
                    visibleNum += 2;
                }
                counting++;
                font.setBrickNum(visibleNum);
            }
            judgeLevel();
        }

        if (font.getLevel() == 3) {
            while (counting == 2) {
                for (int i = 1; i < 6; i++) {
                    brick[i * 11 - 1].setVisible(true);
                    brick[i * 9 + 10].setVisible(true);
                    visibleNum += 2;
                }
                for (int i = 0; i < 3; i++) {
                    brick[i * 11 + 2].setVisible(true);
                    brick[i * 9 + 7].setVisible(true);
                    visibleNum += 2;
                }
                counting++;
                font.setBrickNum(visibleNum);
            }
            judgeLevel();
        }

        if (font.getLevel() == 4) {
            while (counting == 3) {
                for (int i = 0; i < 6; i++) {
                    brick[i * 11 + 2].setVisible(true);
                    brick[(i + 1) * 9 - 2].setVisible(true);
                    visibleNum += 2;
                }
                brick[11].setVisible(true);
                brick[18].setVisible(true);
                brick[20].setVisible(true);
                brick[29].setVisible(true);
                brick[30].setVisible(true);
                brick[39].setVisible(true);
                brick[41].setVisible(true);
                brick[48].setVisible(true);
                visibleNum += 8;
                counting++;
                font.setBrickNum(visibleNum);
            }
            judgeLevel();
        }

        if (font.getLevel() == 5) {
            while (counting == 4) {
                for (int i = 0; i < 3; i++) {
                    brick[i * 9 + 4].setVisible(true);
                    brick[i * 9 + 5].setVisible(true);
                    brick[i * 9 + 15].setVisible(true);
                    brick[i * 9 + 16].setVisible(true);
                    brick[i * 9 + 26].setVisible(true);
                    brick[i * 9 + 27].setVisible(true);
                    visibleNum += 6;
                }
                for (int i = 4; i < 9; i++) {
                    brick[i * 11 - 4].setVisible(true);
                    brick[i * 9 + 13].setVisible(true);
                    visibleNum += 2;
                }
                for (int i = 0; i < 4; i++) {
                    brick[i * 10].setVisible(true);
                    brick[i * 10 + 9].setVisible(true);
                    visibleNum += 2;
                }
                counting++;
                font.setBrickNum(visibleNum);
            }
            if(visibleNum == 0 && summaryOnce == 1) {
                setLifeLoss(true);
                summary();
            }

        }

        for (int i = 0; i < brick.length; i++) {
            brick[i].draw(g);
        }
        bs.draw(g);
        player.draw(g);
        ball.draw(g);
        g.setColor(new Color(80,23,128));
        g.fillRect(0,0,1200,40);
        font.draw(g);
        if(pause){ pauseMenu.drawPauseMenu(g); }
        if(showMenu){
            menu.drawMenu(g);
        }
    }

    public void setShowHelp(boolean b) { menu.setGetHelp(b); }

    public void setShowHigh(boolean b) { menu.setGetHigh(b); }

    public void movePlayer(int a) {
        player.setPlayerX(player.getPlayerX() + a);
    }

    public void moveBall(double a) {
        if (moveableBall) {ball.setBallX(ball.getBallX() + a);}
    }

    public void actionBall(double xa, double ya) {

        if (xDirect) {
            ball.setBallX(ball.getBallX() + xa);
        }
        if (!xDirect) {
            ball.setBallX(ball.getBallX() - xa);
        }
        if (yDirect) {
            ball.setBallY(ball.getBallY() + ya);
        }
        if (!yDirect) {
            ball.setBallY(ball.getBallY() - ya);
        }
        if (ball.getBallX() <= 0) {
            xDirect = true;
        }
        if (ball.getBallX() >= 1200 - ball.getWidthBall()) {
            xDirect = false;
        }
        if (ball.getBallY() <= 40 ) {
            yDirect = true;
        }
        if (ball.getBallY() >= 800 - ball.getHeightBall() - 1 )  {
            lifeLoss = true;
            font.setCountBall(font.getCountBall() - 1);
            font.setScore(font.getScore() - 25);
            bounceCount = 0;
            BallThread.velocity = 2;
            if (font.getCountBall() < 0 && summaryOnce == 1) {
                summary();
            }
            ball.setBallX(player.getPlayerX() + (player.getPlayerW() - ball.getWidthBall()) / 2);
            ball.setBallY(player.getPlayerY() - ball.getHeightBall());
        }
        for (int i = 0; i < brick.length - 1; i++) {
            if(ball.getRectBall().intersects(brick[i].rectBrick) && ball.getRectBall().intersects(brick[i + 1].rectBrick) ) {
                yDirect = !yDirect;
                if(yDirect){ ball.setBallY(brick[i].getyBrick() + brick[i].gethBrick() + 1); }
                if(!yDirect){ ball.setBallY(brick[i].getyBrick() - 1); }
                brick[i].setVisible(false);
                visibleNum--;
                checkbuff(brick[i]);
                font.setBrickNum(font.getBrickNum() - 1);
                font.setScore(font.getScore() + 50);
                brick[i + 1].setVisible(false);
                visibleNum--;
                checkbuff(brick[i + 1]);
                font.setBrickNum(font.getBrickNum() - 1);
                font.setScore(font.getScore() + 50);
            }
        }

        for (int i = 0; i < brick.length; i++) {
            if (brick[i].rectBrick.intersects(ball.getRectBall())
                    && (brick[i].getyBrick()  <= ball.getBallY() && ball.getBallY() <=  brick[i].getyBrick() + brick[i].gethBrick()
                    || brick[i].getyBrick()  <= ball.getBallY() + 20 && ball.getBallY() + 20 <=  brick[i].getyBrick()+ brick[i].gethBrick())
                    &&  brick[i].getxBrick() < (ball.getBallX() + 10) && (ball.getBallX() + 10) < (brick[i].getxBrick() + brick[i].getwBrick())){
                if(brick[i].getVisible()){
                    yDirect = !yDirect;
                    brick[i].setVisible(false);
                    visibleNum--;
                    font.setScore(font.getScore() + 50);
                    font.setBrickNum(font.getBrickNum() - 1);
                    checkbuff(brick[i]);
                }
            }
        }
        for (int i = 0; i < brick.length; i++) {
            if (brick[i].rectBrick.intersects(ball.getRectBall())
                    && ((brick[i].getxBrick()  <= ball.getBallX() && ball.getBallX() <=  brick[i].getxBrick()+ brick[i].getwBrick())
                    || brick[i].getxBrick()  <= ball.getBallX() + 20 && ball.getBallX() + 20 <=  brick[i].getxBrick() + brick[i].getwBrick())
                    &&  brick[i].getyBrick() < (ball.getBallY() + 10) && (ball.getBallY() + 10) < (brick[i].getyBrick() + brick[i].gethBrick()))    {
                if(brick[i].getVisible()){
                    xDirect = !xDirect;
                    brick[i].setVisible(false);
                    visibleNum--;
                    font.setBrickNum(font.getBrickNum() - 1);
                    font.setScore(font.getScore() + 50);
                    checkbuff(brick[i]);
                }
            }
        }
        
        if (ball.getRectBall().intersects(player.rectPlayer)) {
            bounceCount++;
            speedPlusJudge();
            yDirect = !yDirect;
            ball.setBallY(800 - player.getPlayerH() - ball.getHeightBall() - 1);
            while(sticky){
                ball.setBallX(player.getPlayerX() + player.getPlayerW()/2 - 10);
                System.out.print("");
            }

            Random r = new Random();
            if((ball.getBallX() + 10) > (player.getPlayerX() + player.getPlayerW() * 2 / 3) ) {
                if(xDirect){
                    int differ = r.nextInt(21) + 10;
                    if(BallThread.angle - differ >= 30) {
                        BallThread.angle -= differ;
                    }
                } else {
                    int differ = r.nextInt(21) + 10;
                    if(BallThread.angle + differ <= 90) {
                        BallThread.angle += differ;
                    }
                }
            }

            if((ball.getBallX() + 10) < (player.getPlayerX() + player.getPlayerW() / 3) ) {
                if(xDirect){
                    int differ = r.nextInt(21) + 10;
                    if(BallThread.angle + differ <= 90) {
                        BallThread.angle += differ;
                    }
                } else {
                    int differ = r.nextInt(21) + 10;
                    if(BallThread.angle - differ >= 30) {
                        BallThread.angle -= differ;
                    }
                }

            }
            BallThread.ratio = BallThread.angle / 180;
            BallThread.vx = Math.abs(BallThread.velocity * Math.cos(Math.PI * BallThread.ratio));
            BallThread.vy = BallThread.velocity * Math.sin(Math.PI * BallThread.ratio);
        }

    }
    public boolean getLifeLoss() {
        return lifeLoss;
    }

    public void setLifeLoss(Boolean b) {
        lifeLoss = b;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void setMoveableBall(boolean moveableBall) {
        this.moveableBall = moveableBall;
    }

    public boolean isReactSpace() {
        return reactSpace;
    }

    public void setReactSpace(boolean reactSpace) {
        this.reactSpace = reactSpace;
    }

    public void judgeLevel() {
        if(visibleNum == 0) {
            font.setLevel(font.getLevel() + 1);
            player.setPlayerX(600 - player.getPlayerW() / 2);
            font.setCountBall(3);
            ball.setBallX(player.getPlayerX() + (player.getPlayerW() - ball.getWidthBall()) / 2);
            ball.setBallY(player.getPlayerY() - ball.getHeightBall());
            setLifeLoss(true);
            bs.setBuffx(-20);
        }
    }

    public void speedPlusJudge() {
        if (bounceCount == 7 || bounceCount == 14 || bounceCount == 21|| bounceCount == 28 || bounceCount == 35 ) {
            BallThread.velocity += 0.7;
        }
    }



    public void reNew() {
        bounceCount = 0;
        summaryOnce = 1;
        font.setLevel(1);
        font.setCountBall(3);
        font.setScore(0);
        counting = 0;
        visibleNum = 0;
        player.setPlayerX(600 - player.getPlayerW() / 2);
        ball.setBallX(player.getPlayerX() + (player.getPlayerW() - ball.getWidthBall()) / 2);
        ball.setBallY(player.getPlayerY() - ball.getHeightBall());
        for (int i = 0; i < brick.length; i++) {
            brick[i].setVisible(false);
        }
        for (int i = 10; i < 20; i++) {
            brick[i].setVisible(true);
            visibleNum++;
        }
        counting++;
        font.setBrickNum(visibleNum);
        setLifeLoss(true);
        repaint();
    }

    public void writeScore() {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Rank.txt")))) {
            System.out.println(menu.getPlayerName());
            System.out.println(menu.getGrade());
            for (int i = 0; i < Menu.gradeArray.length; i++) {
                dos.writeUTF(Menu.playerArray2[i]);
                dos.writeInt(Menu.gradeArray[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public int[] gradeRank(int[] lst, int temp, String name) {
        int[] sortLst = new int[lst.length];
        String[] nameLst = new String[lst.length];

        for (int i = 0; i <= lst.length - 1; i++) {
            if(lst[i] <= temp) {
                sortLst[i] = temp;
                nameLst[i] = name;
                for (int j = i; j <= lst.length - 2; j++) {
                    sortLst[j+1] = lst[j];
                    nameLst[j+1] = Menu.playerArray2[j];
                }
                break;
            } else {
                sortLst[i] = lst[i];
                nameLst[i] = Menu.playerArray2[i];
            }
        }
        Menu.playerArray2 = nameLst;
        System.out.println(Arrays.toString(Menu.playerArray2));
        return sortLst;
    }

    public void summary() {
        String user = JOptionPane.showInputDialog(null, "Game Over! What is your name?");
        if(user != null) {
            menu.setPlayerName(user);
        } else {menu.setPlayerName("Unknown");}
        menu.setGrade(font.getScore());

        int temp = menu.getGrade();
        String name = menu.getPlayerName();

        Menu.gradeArray = gradeRank(Menu.gradeArray, temp, name);
        writeScore();

        summaryOnce++;
        setShowMenu(true);

    }

    public void checkbuff(Bricks b) {
        int pick = r.nextInt(5);
        if (!buffOn && visibleNum != 0 && pick <= 1) {
            bt = new BuffThread(this, b, bs, player);
            bt.start();
        }
    }
}



