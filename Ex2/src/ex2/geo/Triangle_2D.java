package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape{
	////// add your code here //////
	private Point_2D _p1,_p2,_p3;
	////////////////////////////////
	public Triangle_2D(Point_2D a, Point_2D b, Point_2D c) {
		////// add your code here //////
		this._p1= new Point_2D(a);
		this._p2= new Point_2D(b);
		this._p3= new Point_2D(c);
		////////////////////////////////
	}
	public Triangle_2D(Triangle_2D t1) {
		////// add your code here //////
		_p1= new Point_2D(t1._p1);
		_p2= new Point_2D(t1._p2);
		_p3= new Point_2D(t1._p3);

		////////////////////////////////
	}


	public Point_2D[] getAllPoints() {
		Point_2D[] arr= new Point_2D[3];
		arr[0]= _p1;
		arr[1]=_p2;
		arr[2]=_p3 ;
		return arr ;
	}
	@Override
	public boolean contains(Point_2D ot) {
    double sum= new Triangle_2D(_p1,_p2,ot).area();
	sum+=new Triangle_2D(_p3,_p2,ot).area();
	sum+=new Triangle_2D(_p1,_p3,ot).area();
	return (sum<this.area()+Ex2_Const.EPS);
	}

	@Override
	public double area() {
		double d1 = _p1.distance(_p2);
		double d2 = _p2.distance(_p3);
		double d3 = _p3.distance(_p1);
		double hrn1 = (d1+d2+d3);
		double hrn2= (d1+d2-d3);
		double hrn3= (d2+d3-d1);
		double hrn4= (d3+d1-d2);

		double area= Math.sqrt(hrn1*hrn2*hrn3*hrn4);
		area=(area/4);
		return area;
	}

	@Override
	public double perimeter() {
		double d1 = _p1.distance(_p2);
		double d2 = _p2.distance(_p3);
		double d3 = _p3.distance(_p1);
		double per = d1 + d2 + d3;
		return per;
	}

	@Override
	public void translate(Point_2D vec) {
	_p1.move(vec);
	_p2.move(vec);
	_p3.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Triangle_2D(this);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
	this._p1.scale(center,ratio);
	this._p2.scale(center,ratio);
	this._p3.scale(center,ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
	this._p1.rotate(center,angleDegrees);
	this._p2.rotate(center,angleDegrees);
	this._p3.rotate(center,angleDegrees);
	}
	@Override
	public String toString(){
		return _p1.toString()+ ","+_p2.toString()+","+ _p3.toString();
	}

	@Override
	public boolean equals(Object p)
	{
		if(p==null || !(p instanceof Triangle_2D)) {return false;}
		Triangle_2D t1 = (Triangle_2D) p;
		return  (t1.contains(_p1)&& t1.contains(_p2)&&t1.contains(_p3)&&this.area()==t1.area()
		&& this.perimeter()==this.perimeter());
	}
}

