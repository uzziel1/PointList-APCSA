// Class MyPoint - represents a point in 2 dimensions
//
import java.util.*;

public class Point
{
    private double x;   // the x-coordinate
    private double y;   // the y-coordinate
    
    // default class constructor - sets point to origin
    public Point()
    {
        x=0;
        y=0;
    }
    
    // construct a point at (x,y)
    public Point( double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    // return the points x-coordinate
    public double getX() { return x; }
    
    //return the points y-coordinate
    public double getY() { return y; }
    
    // set the point's x-coordinate
    public void   setX(double x) { this.x = x; }
    
    // set the point's y-coodinate
    public void   setY(double y) { this.y = y; }
    
    // get point's distance from the origin
    public double distance() { return Math.sqrt(x*x+y*y); }
    
    // get distance between two points
    public double distance(Point p)
    {
        return Math.sqrt( Math.pow( p.getX()-this.getX(),2 ) + 
                          Math.pow( p.getY()-this.getY(),2 )    );
    }
    
        
    
    
    public String toString() { return "("+getX()+", "+getY()+")"; }
    
    
    
}
