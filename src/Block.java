import java.awt.*;

public class Block{
    int x;
    int y;
    int number;
    Rectangle r;
    Color c;
    boolean exist;

    public Block(int x, int y, int n){
        this.x = x;
        this.y = y;
        r = new Rectangle(x, y, 130, 50);
        c = new Color(0xff00ff);
        this.exist = true;
        number = n;
    }

    public void draw(Graphics g){
        if(exist){
            g.setColor(c);
            g.fillRect(r.x, r.y, r.width, r.height);
        }
    }

}
