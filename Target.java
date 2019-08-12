import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
public class Target
{

    private double xPos;
    private double xPos2;
    private double yPos;
    private double xSpeed;
    private double xSpeed2;
    private Color col;
    
    public Target()
    {
        xPos = 0;
        xPos2 = 0;
        yPos = 0;
        xSpeed=0;
        xSpeed2=0;
        col = Color.RED;
        
    }

    public Target(double x, double y)
    {
        xPos = x;
        yPos = y;
        xPos2 = 0;
        xSpeed=0;
        xSpeed2=0;
        col = Color.RED;
        
    }
    
    public Target(double x, double y,double x2, double Xs, double Xs2 )
    {
        xPos = x;
        yPos = y;
        xPos2 = x2;
        xSpeed=Xs;
        xSpeed2=Xs2;
        col = Color.RED;
        
    }

    

    public double getX()
    {
        return xPos;
    }

    public double getX2()
    {
        return xPos2;
        
    }
    
    public double getY()
    {
        return yPos;
    }
    
    public double getXspeed()
    {
        return xSpeed;
    }
    
    public double getXspeed2()
    {
        return xSpeed2;
    }

    

    

    public void setColor(Color c)
    {
        col=c;
    }
    
    

    public void drawTarget(Graphics window)
    {
      window.setColor(col);
        
        
        window.fillRect((int)xPos,(int)yPos, 100,10);
        window.setColor(Color.GREEN);
        window.fillRect((int)xPos2,(int)yPos + 50, 100,10);
    }
    
    public void move()
    {
        xSpeed+=.0005;
        xPos+=xSpeed;
        if(xPos>900 || xPos<150)
        {
            xSpeed=xSpeed*-1;
        }
        
        xSpeed2+=.0002;
        xPos2+=xSpeed2;
        if(xPos2>900 || xPos2<150)
        {
            xSpeed2=xSpeed2*-1;
        }
        

    }
    
    
}

    