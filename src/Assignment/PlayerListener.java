package Assignment;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {
    private winPicture wpic;
    private boolean begin = false;
    private Color selectColor = Color.green;
    private Color unSelectColor = Color.white;
    private int colorLine = 1;
    private int colorLineP = 1;
    static BallThread bThread1;

    public PlayerListener (winPicture p) {
        wpic = p;
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT && !wpic.isShowMenu()){
            if (wpic.player.getPlayerX() > 0) {
                if(!wpic.isPause()) {
                    wpic.movePlayer(-20);
                    if(!begin) {
                        wpic.moveBall(-20);
                    }
                }

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !wpic.isShowMenu()) {
            if (wpic.player.getPlayerX() + wpic.player.getPlayerW() < 1200) {
                if(!wpic.isPause()) {
                    wpic.movePlayer(20);
                    if(!begin) {
                        wpic.moveBall(20);
                    }
                }
            }
        }

        if (wpic.isShowMenu()) {
            if (e.getKeyCode() == e.VK_ENTER && colorLine == 1) {
                wpic.setShowMenu(!wpic.isShowMenu());
                wpic.reNew();
                wpic.setPause(false);
            }
            if (e.getKeyCode() == e.VK_ENTER && colorLine == 2) {
                wpic.setShowHelp(true);
            }
            if(e.getKeyCode() == e.VK_BACK_SPACE && colorLine == 2){
                wpic.setShowHelp(false);
            }
            if (e.getKeyCode() == e.VK_ENTER && colorLine == 3) {
                wpic.setShowHigh(true);
            }
            if (e.getKeyCode() == e.VK_BACK_SPACE && colorLine == 3) {
                wpic.setShowHigh(false);
            }
            if (e.getKeyCode() == e.VK_ENTER && colorLine == 4) {
                System.exit(0);
            }
            if (e.getKeyCode() == e.VK_ENTER && colorLine == 5) {
                if(wpic.isPause()){
                    wpic.setShowMenu(!wpic.isShowMenu());
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_UP && colorLine >= 2) {
                colorLine--;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN && colorLine <= 4) {
                colorLine++;
            }
            if(colorLine == 1){
                wpic.menu.setColorStart(selectColor);
                wpic.menu.setColorHelp(unSelectColor);
                wpic.menu.setColorHigh(unSelectColor);
                wpic.menu.setColorExit(unSelectColor);
                wpic.menu.setColorLoad(unSelectColor);
            } else if (colorLine == 2) {
                wpic.menu.setColorStart(unSelectColor);
                wpic.menu.setColorHelp(selectColor);
                wpic.menu.setColorHigh(unSelectColor);
                wpic.menu.setColorExit(unSelectColor);
                wpic.menu.setColorLoad(unSelectColor);
            } else if (colorLine == 3) {
                wpic.menu.setColorStart(unSelectColor);
                wpic.menu.setColorHelp(unSelectColor);
                wpic.menu.setColorHigh(selectColor);
                wpic.menu.setColorExit(unSelectColor);
                wpic.menu.setColorLoad(unSelectColor);
            } else if (colorLine == 4) {
                wpic.menu.setColorStart(unSelectColor);
                wpic.menu.setColorHelp(unSelectColor);
                wpic.menu.setColorHigh(unSelectColor);
                wpic.menu.setColorExit(selectColor);
                wpic.menu.setColorLoad(unSelectColor);
            } else {
                wpic.menu.setColorStart(unSelectColor);
                wpic.menu.setColorHelp(unSelectColor);
                wpic.menu.setColorHigh(unSelectColor);
                wpic.menu.setColorExit(unSelectColor);
                wpic.menu.setColorLoad(selectColor);
            }


        }

        if(wpic.isPause() && !wpic.isShowMenu()) {
            if (e.getKeyCode() == e.VK_ENTER && colorLineP == 2) {
                wpic.setShowMenu(!wpic.isShowMenu());
                colorLineP = 1;
            }
            if(e.getKeyCode() == KeyEvent.VK_UP && colorLineP == 2) {
                colorLineP--;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN && colorLineP == 1) {
                colorLineP++;
            }
            if (colorLineP == 1) {
                wpic.pauseMenu.setColorResume(selectColor);
                wpic.pauseMenu.setColorBackMenu(unSelectColor);
            } else {
                wpic.pauseMenu.setColorResume(unSelectColor);
                wpic.pauseMenu.setColorBackMenu(selectColor);
            }
        }

        if (e.getKeyCode() == e.VK_SPACE && !wpic.isShowMenu()) {
            if(wpic.isReactSpace()){
                bThread1 = new BallThread(wpic);
                bThread1.start();

            }
        }

        if (e.getKeyCode() == e.VK_P && !wpic.isShowMenu()) {
            wpic.setPause(!wpic.isPause());

        }

        if (e.getKeyCode() == e.VK_F && !wpic.isShowMenu() && !wpic.getLifeLoss() && wpic.buffGot) {
            BuffThread.launch = true;

        }

        if (e.getKeyCode() == e.VK_S && wpic.sticky) {
            wpic.sticky = false;
        }



        wpic.repaint();
    }



}
