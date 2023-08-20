package Assignment;

import java.util.Random;

public class BallThread extends Thread {
    private winPicture paper;
    static double velocity = 2;
    static double angle = 90;
    static double ratio = angle / 180;
    static double vx = velocity * Math.cos(Math.PI * ratio);
    static double vy = velocity * Math.sin(Math.PI * ratio);

    public BallThread(winPicture wp) {
        paper = wp;
    }
    public void run(){
        Random r = new Random();
        angle = r.nextInt(10)  + 75;
        paper.setMoveableBall(false);
        paper.setReactSpace(false);
        while(!paper.getLifeLoss()) {
            while(paper.isPause()) {
                System.out.print("");
            }
            paper.actionBall(vx, vy);

            paper.repaint();
            try {
                Thread.currentThread().sleep(7);
            } catch (Exception exception) {
                System.err.println(exception.toString());
            }

        }
        paper.setLifeLoss(false);
        paper.setMoveableBall(true);
        paper.setReactSpace(true);
    }


}
