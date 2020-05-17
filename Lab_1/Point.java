/*
    Nice job for this class! Kudos!
*/
class Point{

    double x;
    double y;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "point (" + String.format("%.3f", this.x) + ", " + String.format("%.3f", this.y) + ")";
    }

    Point midPoint(Point otherPoint){
        double midx = (this.x + otherPoint.x)/2;
        double midy = (this.y + otherPoint.y)/2;

        return new Point(midx, midy);
    }

    double angleTo(Point otherPoint){
        return  Math.atan2(otherPoint.y - this.y, otherPoint.x - this.x);
        }

    Point moveTo(double a , double d){
        double newX = this.x + d*Math.cos(a);
        double newY = this.y + d*Math.sin(a);

        return new Point(newX, newY);
    }
	
	double distanceTo(Point p){
		return Math.hypot(p.x - this.x, p.y - this.y);
		}
}


