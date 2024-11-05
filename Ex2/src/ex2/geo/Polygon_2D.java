package ex2.geo;

import ex2.ex2.Ex2_Const;

import java.util.ArrayList;

public class Polygon_2D implements GeoShape {
	ArrayList<Point_2D> points;
	public Polygon_2D() {
		this.points = new ArrayList<>();
	}
	public Polygon_2D(Polygon_2D po) {
		this.points = new ArrayList<>();
		for (int i = 0; i <po.points.size(); i++) {
			this.points.add(po.points.get(i));
		}
	}
	public Point_2D[] getAllPoints() {
		Point_2D[] arr=new Point_2D[points.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=points.get(i);
		}
		return arr;
	}
	public void add(Point_2D p) {
		points.add(p);
	}
	@Override
	public String toString()
	{
		String str="";
		if(points.size()>0)
			str+=points.get(0).toString();
		for (int i = 1; i < this.points.size(); i++){
			str+= ","+points.get(i).toString();
		}
		return str;
	}
	@Override
	public boolean contains(Point_2D ot) {
		for (int i = 0; i < this.points.size(); i++) {
			if(ot.close2equals(this.points.get(i),Ex2_Const.EPS))
				return true;
		}
	int i;
	int j;
	boolean result= false;
		for ( i = 0, j =(points.size()-1); i<points.size(); j= i++) {
			if ((points.get(i).y()>ot.y())!=(points.get(j).y()>ot.y()) &&
					ot.x()<(points.get(j).x()-points.get(i).x())*(ot.y()- points.get(i).y())/(points.get(j).y()
							-points.get(i).y()) + points.get(i).x()) {
				result = !result;
			}
		}
		return result;
	}

	@Override
	public double area() {
		int allPoints= points.size();
		double count= 0;
		for (int i = 1; i < (points.size()-1); i++) {
			double oneS = points.get(i).x() * points.get(i+1).y() + points.get(allPoints-1).x() * points.get(0).y();
			double secondS = points.get(i+1).x() *points.get(i).y() - points.get(0).x() * points.get(allPoints-1).y();
			double bothS= (oneS-secondS);
			count += bothS;
		}
		count= (Math.abs(count))/2;
		return count;
	}
	@Override
	public double perimeter() {
		double counter=0;
		for (int i = 0; i < points.size()-1; i++) {
			 counter += points.get(i).distance(points.get(i + 1));
		}
		return counter+points.get(points.size()-1).distance(points.get(0));
	}
	@Override
	public void translate(Point_2D vec) {
		for (int i = 0; i < points.size(); i++) {
		points.get(i).move(vec);
		}
	}
	@Override
	public GeoShape copy() {
		return(new Polygon_2D(this));
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		for (int i = 0; i <points.size() ; i++) {
			points.get(i).scale(center, ratio);
		}
	}
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		for (int i = 0; i <points.size() ; i++) {
			points.get(i).rotate(center,angleDegrees);
		}
	}
	@Override
	public boolean equals(Object p)
	{
		if(p==null || !(p instanceof Polygon_2D)) {return false;}
		Polygon_2D pol = (Polygon_2D) p;
		if(!(this.points.size()<=pol.points.size()))
			return false;
		if(this.area()==pol.area() && this.perimeter() == pol.perimeter())
			return false;
		for (int i = 0; i < this.points.size(); i++) {
			if(!(pol.contains(this.points.get(i))))
				return false;
		}
		return true;
	}
}
