package Assignment;

import java.util.Random;

public class BuffThread extends Thread {
    private winPicture paper;
    private Bricks b;
    private BuffSquare bs;
    private Player player;
    static int count = 1;
    private int countTime = 0;
    static boolean launch = false;

    public BuffThread(winPicture paper, Bricks b, BuffSquare bs, Player p) {
        this.paper = paper;
        this.b = b;
        this.bs = bs;
        player = p;
    }
    public void run() {
        this.paper.buffOn = true;
        this.paper.buffGot = false;
        Random r = new Random();
        BuffSquare.buffType = r.nextInt(3) + 1;
        while(this.paper.buffOn){
            try {
                while(paper.isPause()) {
                    System.out.print("");
                }
                while(count == 1){
                    this.bs.setBuffx(this.b.getxBrick() + this.b.getwBrick() / 2 - this.bs.getBuffw() / 2);
                    this.bs.setBuffy(this.b.getyBrick() + this.b.gethBrick());
                    count++;
                }
                this.bs.setBuffy(this.bs.getBuffy() + 1.5);


                if (this.bs.rectBuff.intersects(player.rectPlayer)){
                    this.paper.buffGot = true;
                    while(count == 2){
                        if (BuffSquare.buffType == 1) {
                            player.setPlayerW(240);
                            if(player.getPlayerX() - player.getPlayerW() / 4 >= 0 && player.getPlayerX() + player.getPlayerW() * 3 / 4 <= 1200){
                                player.setPlayerX(player.getPlayerX() - player.getPlayerW() / 4);
                            } else if (player.getPlayerX() - player.getPlayerW() / 4 < 0) {
                                player.setPlayerX(0);
                            } else {player.setPlayerX(1200 - player.getPlayerW());}
                        } else if (BuffSquare.buffType == 2 ) {
                            this.bs.setBuffx(player.getPlayerX() + player.getPlayerW() / 2 - 10);
                            this.bs.setBuffy(player.getPlayerY() - 20);
                        } else if (BuffSquare.buffType == 3 ) {
                            this.bs.setBuffy(800);
                        } else if (BuffSquare.buffType == 4) {
                            this.bs.setBuffy(800);
                        }
                        count++;
                    }
                }

                if (BuffSquare.buffType == 1) {
                    if (this.paper.buffGot) {
                        this.bs.setBuffy(this.bs.getBuffy() - 0.5);
                    }
                    if ( this.bs.getBuffy() >= 1200 ) {
                        this.paper.buffOn = false;
                        if (this.paper.buffGot) {player.setPlayerX(player.getPlayerX() + 30);}
                        player.setPlayerW(120);
                    }
                } else if (BuffSquare.buffType == 2) {
                    if (this.paper.buffGot) {
                        countTime++;
                        if (launch) {
                            this.bs.setBuffy(this.bs.getBuffy() - 41.5);
                            for (int i = 0; i < this.paper.brick.length; i++) {
                                if(this.paper.brick[i].rectBrick.intersects(this.bs.rectBuff) && this.paper.brick[i].getxBrick() < (this.bs.getBuffx() + this.bs.getBuffw()/2) && (this.bs.getBuffx() + this.bs.getBuffw()/2) < (this.paper.brick[i].getxBrick() + this.paper.brick[i].getwBrick()) ){
                                    this.paper.brick[i].setVisible(false);
                                    this.paper.visibleNum--;
                                    this.paper.font.setScore(this.paper.font.getScore() + 50);
                                    this.paper.font.setBrickNum(this.paper.font.getBrickNum() - 1);
                                }
                            }
                        }
                        if (!launch) {
                            this.bs.setBuffx(this.player.getPlayerX() + this.player.getPlayerW() / 2 - 10);
                            this.bs.setBuffy(this.bs.getBuffy() - 1.5);
                            if(countTime > 600) {
                                this.bs.setBuffy(-100);
                                this.paper.buffOn = false;
                            }
                        }
                    }
                    if ( this.bs.getBuffy() <= -20 || this.bs.getBuffy() >= 1200) {
                        this.paper.buffOn = false;
                        launch = false;
                    }
                } else if (BuffSquare.buffType == 3) {
                    if (this.paper.buffGot) {
                        countTime++;
                        this.paper.sticky = true;
                        if(countTime > 500) {
                            this.paper.buffOn = false;
                            this.paper.sticky = false;
                        }
                    }
                    if(this.bs.getBuffy() >= 1200 && !this.paper.sticky) {
                        this.paper.buffOn = false;
                    }
                } else if (BuffSquare.buffType == 4) {
                    if(this.bs.getBuffy() >= 1200) {
                        this.paper.buffOn = false;
                    }
                }

                this.paper.repaint();
                Thread.currentThread().sleep(10);

            } catch (Exception exception) {
                System.err.println(exception.toString());
            }
        }
        count = 1;
        countTime = 0;
        this.paper.buffGot = false;

    }


}