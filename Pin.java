
import java.awt.Color;
import java.awt.Graphics;
public class Pin
{
    private int size;
    private double xPos;
    private double yPos;
    private Color color;

    public Pin()
    {
        size=3;
        xPos=0;
        yPos=600;
        color = Color.BLACK;
    }

    public Pin(int s,double x,double y)
    {
        s=size;
        xPos=x;
        yPos=y;
        color = Color.BLACK;
    }

    public Pin(int s,double x,double y, Color c)
    {
        size=s;
        xPos=x;
        yPos=y;
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

    private double getSize()
    {
        return size;
    }

    public void drawPin(Graphics window)
    {
        window.setColor(color);
        window.fillOval((int)xPos,(int)yPos, size*2,size*2);
    }
}