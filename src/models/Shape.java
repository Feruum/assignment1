package models;
import java.util.ArrayList;

public class Shape {
    // container of Points (e.g. ArrayList<Point>)
    private ArrayList<Point> vertices;

    public Shape (){
        this.vertices = new ArrayList<>();
    }

    // addPoint(Point) - adds to the container
    public void addPoint (Point newP){
        vertices.add(newP);
    }
    // calculatePerimeter()
    public double calculatePerimeter() {
        double perimetr = 0;
        int n=vertices.size();
        for(int i=0;i<n;i++){
            Point current = vertices.get(i);
            Point next = vertices.get((i+1)%n);

            perimetr += current.distance(next);
        }
        return perimetr;
    }
    // getAverageSide()
    public double getAverageSide(){
        return calculatePerimeter()/vertices.size();
    }

    // getLongestSide()
    public double getLongest(){
        double maxSide = 0;
        int n=vertices.size();
        for(int i=0;i<n;i++){
            double currentSide = vertices.get(i).distance(vertices.get((i+1)%n));
            if(currentSide > maxSide){
                maxSide = currentSide;
            }
        }
        return maxSide;
    }
    //Area
    public double getArea(){
        double area=0;
        int n= vertices.size();
        for(int i=0;i<n;i++){
            Point p1 = vertices.get(i);
            Point p2 = vertices.get((i+1)%n);
            area += (p1.getX() * p2.getY()) - (p2.getX() * p1.getY());
        }
        return Math.abs(area) / 2.0;

    }
}