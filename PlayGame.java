import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.lang.Math;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
public class PlayGame extends JPanel implements MouseListener
{
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private ArrayList<Ball> balls;
    private int mouseX;
    private int mouseY;
    Pin[][] pins;
    Target t;
    private boolean pass;
    private int count;
    public PlayGame()
    {
        balls = new ArrayList<Ball>();
        pins = new Pin[5][8];
        t = new Target(300,500,300,.002,.003);
        count=0;
        pass=false;
        for(int r = 0; r < pins.length; r++)
        {
            for(int c = 0; c< pins[r].length; c++)
            {
                if(r%2==0)
                {
                    pins[r][c] = new Pin(6,400+(WIDTH/20)*c,200+(HEIGHT/11)*r, Color.BLACK);
                }
                else
                {
                    pins[r][c] = new Pin(6,400+((WIDTH/20)*c)+33,200+(HEIGHT/11)*r, Color.BLACK);
                }
            }
        }

        addMouseListener(this); 
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        setBackground(Color.WHITE);

        for(int i=0;i<balls.size();i++)
        {
            balls.get(i).drawBall(g);
            balls.get(i).update(t);
            if(((balls.get(i).getY()+10)> t.getY()+45) && balls.get(i).getY() +10 <t.getY() + 60 && ((balls.get(i).getX()+10) >= t.getX2() && (balls.get(i).getX()+10) <= (t.getX2()+100)))
            {
                if(!pass && balls.get(i).getColor()==Color.BLUE)
                {
                    pass=true;
                    balls.get(i).setColor(Color.WHITE);
                    count++;
                    g.fillRect(900,100,100,20);
                }
            }
            else
            {
                pass=false;
            }
            for(int r = 0; r < pins.length; r++)
            {
                for(int c = 0; c< pins[r].length; c++)
                {

                    pins[r][c].drawPin(g);
                    balls.get(i).hit(pins[r][c]);

                }
            }

            g.drawString("Points : "+ count,900,100);

        }
        t.drawTarget(g);
        t.move();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
       g.drawString("DROPPED",500,70);
       
       if(count==3)
       {
           g.fillRect(0,0,1280,720);
           g.setFont(new Font("TimesRoman", Font.PLAIN, 200));
           g.setColor(Color.WHITE);
           g.drawString("YOU WIN!",200,300);
        }
    }

    public void mouseClicked(MouseEvent e)
    {
        if(e.getX()>400 && e.getX()<870)
        {
            if(e.getY()<195)
            {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        }

    }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    public void mousePressed(MouseEvent e)
    {
        if(e.getX()>400 && e.getX()<870)
        {
            if(e.getY()<195)
            {
                mouseX = e.getX();
                mouseY = e.getY();
                Ball b = new Ball(10,mouseX,mouseY);
                balls.add(b); 
            }
        }
    }

    public void mouseReleased(MouseEvent e) { }

    public static void main(String args[])
    {
        JFrame frame = new JFrame("DROPPED");
        PlayGame game = new PlayGame();
        frame.add(game);
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        while (true)
        {
            game.repaint();
        }
    }

}
