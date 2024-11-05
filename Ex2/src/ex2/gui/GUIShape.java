package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */
import ex2.geo.*;
import java.awt.*;


public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	public GUIShape(String s) {
		String [] stringData0= s.split(",");
		boolean fi = Boolean.parseBoolean(stringData0[2]);
		int t= Integer.parseInt(stringData0[3]);
		int color= Integer.parseInt(stringData0[1]);
		GeoShape shape= null;
		String shapeString= stringData0[4];
		System.out.println(shapeString);

		if (shapeString.equals("Segment_2D")){
			Point_2D sP= new Point_2D(Double.parseDouble(stringData0[5]),Double.parseDouble(stringData0[6]));
			Point_2D sP2= new Point_2D(Double.parseDouble(stringData0[7]),Double.parseDouble(stringData0[8]));
			shape= new Segment_2D(sP,sP2);
		}
		if (shapeString.equals("Circle_2D")){
			Point_2D cP= new Point_2D(Double.parseDouble(stringData0[5]),Double.parseDouble(stringData0[6]));
			double radius=Double.parseDouble(stringData0[7]);
			shape= new Circle_2D(cP,radius);
		}
		if (shapeString.equals("Triangle_2D")){
			Point_2D tP= new Point_2D(Double.parseDouble(stringData0[5]),Double.parseDouble(stringData0[6]));
			Point_2D tP2= new Point_2D(Double.parseDouble(stringData0[7]),Double.parseDouble(stringData0[8]));
			Point_2D tP3= new Point_2D(Double.parseDouble(stringData0[9]),Double.parseDouble(stringData0[10]));
			shape= new Triangle_2D(tP,tP2,tP3);
		}
		if (shapeString.equals("Rect_2D")){
			Point_2D rP= new Point_2D(Double.parseDouble(stringData0[5]),Double.parseDouble(stringData0[6]));
			Point_2D rP2= new Point_2D(Double.parseDouble(stringData0[9]),Double.parseDouble(stringData0[10]));
			shape= new Rect_2D(rP,rP2);
		}
		if (shapeString.equals("Polygon_2D")){
			Polygon_2D pol= new Polygon_2D();
			for (int i = 5; i<stringData0.length-1; i++) {
				Point_2D pP= new Point_2D(Double.parseDouble(stringData0[i]),Double.parseDouble(stringData0[i+1]));
				pol.add(pP);
				i++;
			}
			shape= pol;
		}
		_g= shape;
		_fill= fi;
		_color= new Color(color);
		_tag= t;
		_isSelected= false;
	}
	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		String ans = ""+this.getClass().getSimpleName()+","+colorEncoding(_color)+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	public static int colorEncoding(Color c) {
		int r = c.getRed();
		int b = c.getBlue();
		int g = c.getGreen();
		int ce = r*256*256 + g*256 + b;
		return ce;
	}

	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
	@Override
	public boolean equals(Object p)
	{
		if(p==null || (p instanceof GUI_Shape)) {return false;}
		GUI_Shape g1= (GUI_Shape) p;
		return (g1.getShape().equals(this._g));
	}
}
