import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Breakout extends Canvas{
    JFrame frame;
    int width = 1000;
    int height = 500;
    public Breakout(){
        frame = new JFrame("Breakout");
        frame.setSize(new Dimension(width, height));
        frame.add(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g){
        draw(g);
    }

    private void draw(Graphics g) {
        drawSlab(g);
    }

    private void drawSlab(Graphics g) {
        g.setColor(Color.RED);
    }


    public class KL implements KeyListener{

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            if (){

            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
}
