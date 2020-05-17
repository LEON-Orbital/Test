/*
	General good practice to put your main class as 'public'!
	(Same for Main.java and Point.java)
*/
class Circle{
    
    private double radius;
    private Point centre;

    private Circle(Point centre, double radius){
		this.centre = centre;
		this.radius = radius;
	}

	static Circle getCircle(Point centre, double radius){
		if(radius > 0){
			return new Circle(centre, radius);
		}
		else{
			return null;
		}
	}

	/*
		Do try using String.foramt in Lab 2!
	*/
	@Override
	public String toString(){
		return "circle of radius " + this.radius + " centered at " + centre.toString();
	}

	/*
		Naming convention can be better!
		If you are simply returning the centre, just write getCentre()
	*/
	Point getCen(){
		return this.centre;
	}

}

