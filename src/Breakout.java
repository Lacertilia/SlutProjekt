import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Breakout extends Canvas{
    JFrame frame;
    static int width = 1520;
    static int height = 750;
    static int x = 660;
    int moveSlab = 15;
    int fps = 30;
    static int hitBlocks = 0;
    static int points = 0;
    static Ball ball = new Ball();
    Thread t;
    static Block[] list = new Block[40];
    Image dbImage;
    static Graphics dbg;
    static boolean gameOver = false;
    static boolean notStarted = true;

    /**
     * Creating everything for the game.
     * */
    public Breakout(){
        frame = new JFrame("Breakout");
        frame.setSize(new Dimension(width, height));
        frame.add(this);
        frame.setResizable(false);
        for(int i = 0; i<list.length; i++){//Creating blocks
            if(i<10){
                list[i] = new Block((150*i+20), 50, i);
            }else if(i<20){
                list[i] = new Block((150*(i-10)+20), 110, i);
            }else if(i<30){
                list[i] = new Block((150*(i-20)+20), 170, i);
            }else if(i<40){
                list[i] = new Block((150*(i-30)+20), 230, i);
            }

        }
        addKeyListener(new KL());
        addMouseListener(new ML());
        t = new Thread(ball);
        t.start();
        notStarted = false;

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

        long lastUpdate = System.nanoTime();
        long dt = 1000000000/fps;
        while(!notStarted){
            if(System.nanoTime() - lastUpdate > dt){
                lastUpdate = System.nanoTime();
                draw();
            }

        }
    }
    /**
     * Draws the game.
     * */
    private void draw(){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();

        if(!gameOver) {
            if (hitBlocks < 40) {

                dbg.setColor(Color.DARK_GRAY);
                dbg.fillRect(0, 0, width, height);
                dbg.setColor(Color.WHITE);
                dbg.drawString("" + points, 750, 450);
                ball.draw(dbg);
                for (int i = 0; i < list.length; i++) {//Draws blocks
                    list[i].draw(dbg);
                }
                drawSlab(dbg);

                getGraphics().drawImage(dbImage, 0, 0, this);
            } else {
                dbg.setColor(Color.DARK_GRAY);
                dbg.fillRect(0, 0, width, height);
                dbg.setColor(Color.WHITE);
                dbg.setFont(dbg.getFont().deriveFont(dbg.getFont().getSize() * 2F));
                dbg.drawString("You Won!", 750, 350);

                getGraphics().drawImage(dbImage, 0, 0, this);
            }
        }else{
            dbg.setColor(Color.DARK_GRAY);
            dbg.fillRect(0, 0, width, height);
            dbg.setColor(Color.WHITE);
            dbg.setFont(dbg.getFont().deriveFont(dbg.getFont().getSize() * 2F));
            dbg.drawString("Game Over!", 750, 350);

            getGraphics().drawImage(dbImage, 0, 0, this);
        }
    }

    /**
     * Draws platform.
     * */
    private void drawSlab(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, 675, 200, 20);
    }


    /**
     * Keylistener for platform movement with keyboard.
     * */
    public class KL implements KeyListener{

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT){
                if((x+200)<(width-moveSlab)){
                    x += moveSlab;
                }
            }
            if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
                if(x>moveSlab){
                    x -= moveSlab;
                }
            }

        }


        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
    /**
     * Mouselistener for platform movement with mouse.
     * */
    public class ML implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            x = mouseEvent.getX()-100;
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {


        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
    /**
     * Starts Game.
     * */
    public static void main(String[] args) {
        new Breakout();
    }
}
