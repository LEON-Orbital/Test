import java.util.Scanner;

/*
	Good code here! :D
*/
class Main{

	static Circle createCircle(Point p, Point q, double radius){

		if ((p.x - q.x == 0) && (p.y - q.y == 0)){
			return null;
		}

		Point mid = p.midPoint(q);
		double pToMid = Math.hypot(mid.x - p.x, mid.y - p.y);

		if (pToMid > radius){
			return null;
		}

		double midToCen = Math.sqrt((radius * radius) - (pToMid * pToMid));
		double a = Math.PI/2+ p.angleTo(q);
		Point cen = mid.moveTo(a, midToCen);

		return Circle.getCircle(cen, radius);
	}

	public static void main(String[] args){
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();

		Point points[] = new Point[n];

		for(int i = 1; i <= n; i ++){
			points[i-1] = new Point(s.nextDouble(), s.nextDouble());
		}


		int highest = 0;
		int counter = 0;

		for(int j = 0; j < n-1; ++j){
			
			for(int k = j+1; k < n; ++k){
				Circle a = Main.createCircle(points[j], points[k], 1);
					if(a == null){
						continue;
					}
				counter = 0;

				for(Point p : points){
					if(a.getCen().distanceTo(p) <= 1){
						counter += 1;
					}
				}
				if(counter > highest){
					highest = counter;
				}
			}
		}
		System.out.println("Maximum Disc Coverage: " + highest);

	}
}
