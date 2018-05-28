import java.awt.*;

public class Block{
    int x;
    int y;
    int number;
    Rectangle r;
    Color c, c2, c3, c4;
    boolean exist;

    public Block(int x, int y, int n){
        this.x = x;
        this.y = y;
        r = new Rectangle(x, y, 130, 50);
        c = new Color(0xff00ff);
        c2 = new Color(0xfff3f);
        c3 = new Color(0xfaaf3f);
        c4 = new Color(0xabcde);

        this.exist = true;
        number = n;
    }
    /**Draws the blocks.
     * Different colors for each row.
     * */
    public void draw(Graphics g){
        if(exist){
            if(number <10){
                g.setColor(c);
                g.fillRect(r.x, r.y, r.width, r.height);
            }else if(number <20){
                g.setColor(c2);
                g.fillRect(r.x, r.y, r.width, r.height);
            }else if(number<30){
                g.setColor(c3);
                g.fillRect(r.x, r.y, r.width, r.height);
            }else if(number <40){
                g.setColor(c4);
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        }
    }

}
