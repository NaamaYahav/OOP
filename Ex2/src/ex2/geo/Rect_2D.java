package ex2.geo;

import ex2.ex2.Ex2_Const;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect_2D implements GeoShape {
	private Point_2D _p1, _p2, _p3, _p4;

	public Rect_2D(Point_2D p1, Point_2D p2) {
		////// add your code here //////
		this._p1 = new Point_2D(p1);
		this._p3 = new Point_2D(p2);
		this._p2 = new Point_2D(_p3.x(), _p1.y());
		this._p4 = new Point_2D(_p1.x(), _p3.y());

		////////////////////////////////
	}

	public Rect_2D(Rect_2D t1) {
		////// add your code here //////
		_p1 = new Point_2D(t1._p1);
		_p2 = new Point_2D(t1._p2);
		_p3 = new Point_2D(t1._p3);
		_p4 = new Point_2D(t1._p4);
		////////////////////////////////
	}

	public Point_2D[] getAllPoints() {
		Point_2D[] arr = new Point_2D[4];
		arr[0] = this._p1;
		arr[1] = this._p2;
		arr[2] = this._p3;
		arr[3] = this._p4;
		return arr;
	}

	@Override
	public boolean contains(Point_2D ot) {
		double sum = new Triangle_2D(_p1, _p2, ot).area();
		sum += new Triangle_2D(_p1, _p4, ot).area();
		sum += new Triangle_2D(_p4, _p3, ot).area();
		sum += new Triangle_2D(_p3, _p2, ot).area();
		return (sum <= this.area() + Ex2_Const.EPS);
	}


	@Override
	public double area() {
		double len = _p1.distance(_p2);
		double len1 = _p1.distance(_p4);
		double ar = len * len1;
		return ar;
	}

	@Override
	public double perimeter() {
		double len = _p1.distance(_p2);
		double len1 = _p1.distance(_p4);
		double per = len * 2 + len1 * 2;
		return per;
	}

	@Override
	public void translate(Point_2D vec) {
		_p1.move(vec);
		_p2.move(vec);
		_p3.move(vec);
		_p4.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Rect_2D(this);
	}

	@Override
	public void scale(Point_2D center, double ratio) {
		_p1.scale(center, ratio);
		_p2.scale(center, ratio);
		_p3.scale(center, ratio);
		_p4.scale(center, ratio);
	}

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_p1.rotate(center, angleDegrees);
		_p2.rotate(center,angleDegrees);
		_p3.rotate(center,angleDegrees);
		_p4.rotate(center,angleDegrees);
	}
	@Override
  public String toString() {
	return _p1.toString()+","+_p2.toString()+","+_p3.toString()+","+_p4.toString();
	}
	@Override
	public boolean equals(Object p)
	{
		if(p==null || !(p instanceof Rect_2D)) {return false;}
		 Rect_2D r1 = (Rect_2D) p;
		return  (r1._p1.equals(this._p1)&& (r1._p2.equals(this._p2))&&(r1._p3.equals(this._p3))&&r1._p4.equals(this._p4)
				&&this.area()==r1.area()&&this.perimeter()==r1.perimeter());
	}
}

