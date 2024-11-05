package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{
	private Point_2D _p1, _p2;
	public Segment_2D(Point_2D a, Point_2D b) {
		_p1= new Point_2D(a);
		_p2= new Point_2D(b);
	}
	public Segment_2D(Segment_2D t1) {
		////// add your code here //////
		_p1= new Point_2D(t1._p1);
		_p2= new Point_2D(t1.get_p2());
		////////////////////////////////
	}

	public Point_2D get_p1() {

		return new Point_2D(_p1);
	}
	public Point_2D get_p2() {

		return new Point_2D(_p2);
	}
	private boolean isVertical(){
		return _p1.x()==_p2.x();
	}
	@Override
	public boolean contains(Point_2D ot) {
		double dist= _p1.distance(_p2);
		double d1= _p1.distance(ot);
		double d2= ot.distance(_p2);
		boolean ans= d1+d2<dist+ Ex2_Const.EPS;
		return ans;
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		double len= _p1.distance(_p2);
		return len*2;
	}

	@Override
	public void translate(Point_2D vec) {
	_p1.move(vec);
	_p2.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment_2D(this);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		this._p1.scale(center, ratio);
		this._p2.scale(center, ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		this._p1.rotate(center,angleDegrees);
		this._p2.rotate(center,angleDegrees);
	}
	@Override
	public String toString(){
		return  _p1.toString()+ "," +_p2.toString();
	}

	@Override
	public boolean equals(Object p)
	{
		if(p==null || !(p instanceof Segment_2D)) {return false;}
		Segment_2D s1 = (Segment_2D) p;
		return  (s1._p1.equals(this._p1) && s1._p2.equals(this._p2) || s1._p1.equals(this._p2) && s1._p2.equals(this._p1));
	}
}