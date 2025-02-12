/** Programming Assignment #10 -Program utilizes built-in arrays
 */
import java.util.*;

public class PointList
{
    final static int MAX_POINTS = 50;
    
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int    i = 0;
        int    choice;
        int    k;
        double  x;
        double  y;
  

        Point[] point = new Point[ MAX_POINTS ];
        int     size = 0; // current #points in list
        
        //Dummy code ERASE LATER 
        point[0] = new Point(1, 2); 
        point[1] = new Point(1, 3); 
        point[2] = new Point(1, 4); 

        size = 3;

        do
        {
            displayOptions();
            choice = console.nextInt();
    
            if( choice == 1 )
            {
                // Add a point 
                System.out.printf( "Enter point %d as two doubles separated by spaces: ", size);
                x = console.nextDouble();
                y = console.nextDouble();
            
                // Create a single point and add to array
                
                // add code here
                point[i] = new Point(x, y);
                i++;
                size++;
            } 
            else if( choice == 2 )
            {
                // Display the points
                System.out.println( "Point list:\n" );
        
                // add code here
                for (i = 0; i < point.length; i++) {
                    if (point[i] != null)
                        System.out.printf("#%d: %s distance from the origin = %.2f. \n", i, point[i],point[i].distance() );
                }
                    
            }
            else if( choice == 3 )
            {
                // Remove a point from the list
                System.out.print( "Remove which point (Enter index number)? " );
                k = console.nextInt();
                    
                    // add code here
                    point[k] = null;
                    
                    for (i = k + 1; i < point.length -1; i++) {
                        point[i - 1] = point[i];
                    }
            }
            else if( choice == 4 )
            {
                if (size < 2) {
                    System.out.println("At least 2 points are required to calculate the line of best fit.");
                } else {
                    // calculate the the line of best-fit.
                    double covXY = covXY(point,size);
                    double varX = varX(point,size);
                    double varY = varY(point,size);
                    
                    if (varX == 0) {
                        System.out.println("Variance of X is 0, Cannot calculate slope (m).");
                    } else {
                        double m = covXY / varX; 
                    
                        double b = meanY(point, size) - m * meanX(point, size);
                        double r = 0;
                        if (varX != 0 && varY != 0) {
                            r = covXY / (Math.sqrt(varX) * Math.sqrt(varY));
                        }
                        System.out.printf("Line of best fit:\nY = %f * x + %f \nr = %f", m, b, r);      
                }
           
                    
                   
                    }

                               
              
            }
        } while( choice < 5 );    
        
        
    }
    
    /**
     * Display the programs options to the user
     */
    public static void displayOptions()
    {
        System.out.println("\n1. Add a point to the list.      2. Display the points.");
        System.out.println("3. Remove a point from the list  4. Compute the line of best fit.");
        System.out.println("5. Quit");
        System.out.print("Which (1-5)? ");
    }
    private static double meanX (Point[] p, int points) {
        double sum = 0;
        for (int i = 0; i < points; i++) {
            sum += p[i].getX();
        }
        double mean = (sum/points);
        
        return mean; 
    }
    
      private static double meanY (Point[] p, int points) {
        double sum = 0;
        for (int i = 0; i < points; i++) {
            if (p[i] != null)
            sum += p[i].getY();
        }
        double mean = (sum/points);
        
        return mean; 
    }
    
    private static double varX (Point[] p, int points) {
        double meanX = meanX(p, points);
        double sum = 0;
        for (int i = 0; i < points; i++) {
            if (p[i] != null)
            sum += (p[i].getX() - meanX) * ((p[i].getX() - meanX));
        }
        double varX = sum/points;
        
       return varX;  
    }
    
    private static double varY (Point[] p, int points) {
        double meanY = meanY(p, points);
        double sum = 0;
        for (int i = 0; i < points; i++) {
            if (p[i] != null)
            sum += (p[i].getY() - meanY) * ((p[i].getY() - meanY));
        }
        double varY = (sum/points);
        
       return varY;  
    }
    
    private static double covXY (Point[] p, int points) {
        double meanX = meanX(p, points);
        double meanY = meanY(p, points);
        double sum = 0;
        for (int i = 0; i < points; i++) {
            if (p[i] != null)
            sum += (p[i].getX() - meanX) * (p[i].getY() - meanY);
        }
        double covXY = (sum/points);
        
       return covXY;  
    }
    
    
}
