package ex2.geo;

import java.util.Comparator;

import ex2.ex2.Ex2_Const;
import ex2.gui.GUI_Shape;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shape>{

	public static final ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final ShapeComp CompByAntiArea = new ShapeComp(Ex2_Const.Sort_By_Anti_Area);
	public static final ShapeComp CompByPerimeter= new ShapeComp(Ex2_Const.Sort_By_Perimeter);
	public static final ShapeComp CompByAntiPerimeter = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
	public static final ShapeComp CompByToString = new ShapeComp(Ex2_Const.Sort_By_toString);
	public static final ShapeComp CompByAntiToString = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);
	public static final ShapeComp CompByTag = new ShapeComp(Ex2_Const.Sort_By_Tag);
	public static final ShapeComp CompByAntiTag = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);
	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
	}

	/**
	 * Make sure you implement the basic code below
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return 1 iff o1 is grater than o1, -1 iff o1 is smaller than o2,
	 * and 0 iff o1 and o2 are equals.
	 */
	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		double a1=-1, a2 = -1;
		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans =0;
		if(_flag == Ex2_Const.Sort_By_Area) {
			a1 = s1.area();
			a2 = s2.area();
			if(a1>a2) {ans=1;}
			if(a1<a2) {ans=-1;}
		}
		if (_flag==Ex2_Const.Sort_By_Anti_Area){
			a1= s1.area();
			a2= s2.area();
			if (a1<a2) {ans=1;}
			if (a1>a2)  {ans=-1;}
		}
		if(_flag == Ex2_Const.Sort_By_toString) {
			double b1= s1.toString().length();
			double b2= s2.toString().length();
			if (b1>b2) {ans=1;}
			if (b1<b2) {ans=-1;}
		}
		if (_flag==Ex2_Const.Sort_By_Anti_toString){
			double b1= s1.toString().length();
			double b2= s2.toString().length();
			if(b1<b2) {ans=1;}
			if (b1>b2) {ans=-1;}
		}
		if (_flag==Ex2_Const.Sort_By_Anti_Perimeter) {
			double p1 = s1.perimeter();
			double p2 = s2.perimeter();
			if (p1 < p2) {ans = 1;}
			if (p1 > p2) {ans = -1;}
		}
		if (_flag==Ex2_Const.Sort_By_Perimeter){
			double p1 = s1.perimeter();
			double p2 = s2.perimeter();
			if (p1 > p2) {ans = 1;}
			if (p1 < p2) {ans = -1;}
		}
		if (_flag==Ex2_Const.Sort_By_Anti_Tag){
			double t1= o1.getTag();
			double t2= o2.getTag();
			if (t1<t2) {ans=1;}
			if (t1>t2) {ans=-1;}
		}
		if (_flag==Ex2_Const.Sort_By_Tag) {
			double t1= o1.getTag();
			double t2= o2.getTag();
			if (t1>t2) {ans=1;}
			if (t1<t2) {ans=-1;}
		}
		return ans;
	}
}
