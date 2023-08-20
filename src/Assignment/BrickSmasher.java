package Assignment;


import java.awt.*;
import javax.swing.*;

public class BrickSmasher {
    public static void main(String[] args) {
        JFrame window = new JFrame("Brick Smasher");
        initialWindow(window, 1216, 839);

        winPicture wp = new winPicture();
        window.add(wp);

        PlayerListener pl = new PlayerListener(wp);
        window.addKeyListener(pl);

        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
    }

    private static void initialWindow(JFrame jf, int width, int height){
        jf.setSize(new Dimension(width, height));
        int windowWidth = jf.getWidth();
        int windowHeight = jf.getHeight();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        System.out.println(screenWidth);
        System.out.println(screenHeight);
        jf.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
    }
}

