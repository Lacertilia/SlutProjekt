import java.awt.*;

public class Ball implements Runnable{
    int x = 750;
    int y = 600;
    Rectangle r;
    Color c;
    int vx = 10, vy = 5; //Velocity x and y

    public Ball(){
        r = new Rectangle(x, y, 25, 25);
        c = new Color(0x00ffff);
    }
    /**
     * To make the ball move when game is started.
     * */
    public void run(){
        while(!Breakout.gameOver || Breakout.hitBlocks <40){
            r.x += vx;
            r.y += vy;
            collision();
            try{
                Thread.sleep(40);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
    /**
     * To check if ball collides.
     * */
    private void collision() {
        if((r.y+25)>=675 && r.x >= Breakout.x && r.x<=(Breakout.x+200)){
            if(vy>0){
                vy = -vy;
            }
        }
        if(r.y <=0){
            vy = -vy;
        }
        if((r.y+25) >=725){
            Breakout.gameOver = true;
        }
        if(r.x<=0 || r.x+25 >=1520){
            vx = -vx;
        }
        if(r.y<280 && r.y+25>230){

            for(int i = 30; i<40; i++) {
                if(r.x < (Breakout.list[i].x+130) && r.x+25 > Breakout.list[i].x && Breakout.list[i].exist){
                    Breakout.list[i].exist = false;
                    Breakout.hitBlocks++;
                    Breakout.points++;
                    Toolkit.getDefaultToolkit().beep();
                    if(r.x >Breakout.list[i].x +5 || r.x <Breakout.list[i].x+125){
                        if(r.y > Breakout.list[i].y+5 && r.y < Breakout.list[i].y+45){
                            vx = -vx;
                        }else{
                            vy = -vy;
                        }

                    }else{
                        vy = -vy;
                    }
                }
            }
        }
        if(r.y<=220 && r.y+25>=170){

            for(int i = 20; i<30; i++) {
                if(r.x <= (Breakout.list[i].x+130) && r.x+25 >= Breakout.list[i].x && Breakout.list[i].exist){
                    Breakout.list[i].exist = false;
                    Breakout.points+=2;
                    Breakout.hitBlocks++;
                    Toolkit.getDefaultToolkit().beep();
                    if(r.x >Breakout.list[i].x +5 || r.x <Breakout.list[i].x+125){
                        if(r.y > Breakout.list[i].y+5 && r.y < Breakout.list[i].y+45){
                            vx = -vx;
                        }else{
                            vy = -vy;
                        }

                    }else{
                        vy = -vy;
                    }
                }
            }
        }
        if(r.y<=160 && r.y+25>=110){

            for(int i = 10; i<20; i++) {
                if(r.x <= (Breakout.list[i].x+130) && r.x+25 >= Breakout.list[i].x && Breakout.list[i].exist){
                    Breakout.list[i].exist = false;
                    Breakout.points+=5;
                    Breakout.hitBlocks++;
                    Toolkit.getDefaultToolkit().beep();
                    if(r.x <Breakout.list[i].x +5 || r.x >Breakout.list[i].x+125){
                        if(r.y > Breakout.list[i].y+5 && r.y < Breakout.list[i].y+45){
                            vx = -vx;
                        }else{
                            vy = -vy;
                        }

                    }else{
                        vy = -vy;
                    }
                }
            }
        }
        if(r.y<=100 && r.y+25>=50){

            for(int i = 0; i<10; i++) {
                if(r.x <= (Breakout.list[i].x+130) && r.x+25 >= Breakout.list[i].x && Breakout.list[i].exist){
                    Breakout.list[i].exist = false;
                    Breakout.points+=10;
                    Breakout.hitBlocks++;
                    Toolkit.getDefaultToolkit().beep();
                    if(r.x <Breakout.list[i].x +5 || r.x >Breakout.list[i].x+125){
                        if(r.y > Breakout.list[i].y+5 && r.y < Breakout.list[i].y+45){
                            vx = -vx;
                        }else{
                            vy = -vy;
                        }

                    }else{
                        vy = -vy;
                    }

                }
            }
        }
    }
    /**
     * To draw the ball
     * */
    public void draw(Graphics g){
        g.setColor(c);
        g.fillOval(r.x, r.y, (int)r.getWidth(), (int)r.getHeight());

    }

}
