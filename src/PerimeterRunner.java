import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints(Shape s){
        int numPoints = 0;
        for (Point currPt : s.getPoints()) {
            numPoints += 1;
        }

        return numPoints;
    }

    public double getAverageLength(Shape s){
        double perimeter = getPerimeter(s);
        int numPoints = getNumPoints(s);

        return perimeter / numPoints;
    }

    public double getLargestSide(Shape s){
        Point prevPt = s.getLastPoint();
        double prevDist = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update prevPt to be currPt
            prevPt = currPt;

            if(currDist > prevDist) {
                prevDist = currDist;
            }
        }

        return prevDist;
    }

    public double getLargestX(Shape s){
        double largestX = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currX = currPt.getX();

            if(currX > largestX) {
                largestX = currX;
            }
        }

        return largestX;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("points = " + numPoints);
        System.out.println("the average length of a side in your shape is " + averageLength);
        System.out.println("largest side " + largestSide);
        System.out.println("Largest X " + largestX);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
