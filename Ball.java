import java.awt.Color;
import java.awt.Graphics;
public class Ball
{
    private int r;
    private double xPos;
    private double yPos;
    private double xSpeed;
    private double ySpeed;
    private static double yAcc = .003;

    private Color color;
    public Ball()
    {
        r=5;
        xPos=200;
        yPos=200;
        xSpeed=0;
        ySpeed=0; 
        color = Color.BLUE;
    }

    public Ball(int radius,double x,double y)
    {
        r=radius;
        xPos=x;
        yPos=y;
        xSpeed=0;
        ySpeed=0;
        color = Color.BLUE;
    }

    public Ball(int radius,double x,double y, double xS, double yS)
    {
        r=radius;
        xPos=x;
        yPos=y;
        xSpeed=xS;
        ySpeed=yS;
        color=Color.BLUE;
    }

    public Ball(int radius,double x,double y, double xS, double yS, Color c)
    {
        r=radius;
        xPos=x;
        yPos=y;
        xSpeed=xS;
        ySpeed=yS;
        color = c;
    }

    public double getX()
    {
        return xPos;
    }

    public double getY()
    {
        return yPos;
    }

    private double getRadius()
    {
        return r;
    }

    public void setColor(Color c)
    {
        color=c;
    }

    public Color getColor()
    {
        return color;
    }
    
    public void drawBall(Graphics window)
    {
        window.setColor(color);

        if(getY()>550)
        {
            window.setColor(Color.WHITE);

        }
        window.fillOval((int)xPos,(int)yPos, r*2,r*2);
        

    }

    public void fall(Target t)
    {
        ySpeed+=yAcc;
        yPos+=ySpeed;
        
        if(((getY()+10)> t.getY()-5) && getY() +10 >t.getY() + 10 && ((getX()+10) >= t.getX() && (getX()+10) <= (t.getX()+100)))
        {
            setColor(Color.WHITE);
            
        }
    }
    
    

    public void hit(Pin p)
    {
        
        if((getY()+10) >= p.getY() && ((getY()+10) <= p.getY()+3))
        {
            {
                if((getX()+5)>=(p.getX())+2 && (getX()+5)<(p.getX()+11))
                {
                    
                    
                        xSpeed+=20;
                        xPos+=xSpeed;
                    
                    
                }
                if((getX()+5)<(p.getX())+2 && (getX()+5)> (p.getX()-9))
                {
                    
                        xSpeed-=20;
                        xPos+=xSpeed;
                    

                }
            }
            xSpeed=0;

        }
    }

    public void update(Target t)
    {

        fall(t);
    }

}
