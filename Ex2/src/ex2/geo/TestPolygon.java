package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.Test;

import static org.junit.Assert.*;
public class TestPolygon {

    Polygon_2D s1= new Polygon_2D();

    Point_2D a= Point_2D.ORIGIN;
    Point_2D b=new Point_2D(0,1);
    Point_2D c=new Point_2D(1,1);
    Point_2D d= new Point_2D(1,5);
    Point_2D e= new Point_2D(5,5);
    Point_2D f=new Point_2D(5,0);

    private Polygon_2D s2= new Polygon_2D();
        Point_2D _p1= Point_2D.ORIGIN;
        Point_2D _p2=  new Point_2D(6,6);
        Point_2D _p3= new Point_2D(-6,6);



//
    @Test public void testArea(){
     s1.add(a);
     s1.add(b);
     s1.add(c);
     s1.add(d);
     s1.add(e);
     s1.add(f);
     double ar= s1.area();
     assertEquals(ar,21.0,Ex2_Const.EPS);
     s2.add(_p1);
     s2.add(_p2);
     s2.add(_p3);
     double are= s2.area();
     assertEquals(are,36.0,Ex2_Const.EPS);
    }
    @Test
    public void testPerimeter(){
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        double per= s1.perimeter();
        assertEquals(per,20.0,Ex2_Const.EPS);
    }
    @Test
    public void testContain(){
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        Point_2D _p5= new Point_2D(2,3);
        boolean con= s1.contains(_p5);
        assertTrue(con);
        s2.add(_p1);
        s2.add(_p2);
        s2.add(_p3);
        Point_2D _p7= new Point_2D(0,7 );
        boolean cont= s2.contains(_p7);
        assertFalse(cont);
    }
    @Test
    public void testCopy(){
        Polygon_2D temp= (Polygon_2D) s1.copy();
        assertArrayEquals(temp.getAllPoints(),s1.getAllPoints());
    }
    @Test
    public void testGetAllPoints(){
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        Point_2D[] testArr= new Point_2D[6];
        testArr[0]= Point_2D.ORIGIN;
        testArr[1]= new Point_2D(0,1);
        testArr[2]= new Point_2D(1,1);
        testArr[3]= new Point_2D(1,5);
        testArr[4]= new Point_2D(5,5);
        testArr[5]= new Point_2D(5,0);
        Point_2D[] testS1= s1.getAllPoints();
        assertArrayEquals(testS1,testArr);
    }
    @Test
    public void testToString(){
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        String testS1= s1.toString();
        //System.out.println(testStr);
        String testStr= "0.0,0.0,0.0,1.0,1.0,1.0,1.0,5.0,5.0,5.0,5.0,0.0";
        assertEquals(testS1,testStr);
    }
    @Test
    public void testTranslate(){
        Polygon_2D temp= (Polygon_2D)s1.copy();
        temp.add(new Point_2D(1,1));
        temp.add(new Point_2D(1,2));
        temp.add(new Point_2D(2,2));
        temp.add(new Point_2D(2,6));
        temp.add(new Point_2D(6,6));
        temp.add(new Point_2D(6,1));
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        s1.translate(new Point_2D(1,1));
        assertArrayEquals(s1.getAllPoints(),temp.getAllPoints());
    }
    @Test
    public void testScale(){
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        Polygon_2D temp= (Polygon_2D) s1.copy();
        Point_2D centerTest= new Point_2D(2,2);
        s1.scale(centerTest,110.0/100.0);
        assertNotEquals(temp.getAllPoints(),s1.getAllPoints());
        s1.scale(centerTest,100.0/110.0);
        assertArrayEquals(s1.getAllPoints(),temp.getAllPoints());
    }
    @Test
    public void testRotate(){
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        Polygon_2D temp= (Polygon_2D) s1.copy();
        Point_2D centerTest= new Point_2D(2,2);
        s1.rotate(centerTest,45);
        assertNotEquals(s1.getAllPoints(),temp.getAllPoints());
        s1.rotate(centerTest,-45);
        assertArrayEquals(s1.getAllPoints(),temp.getAllPoints());
    }
    @Test
    public void testAdd(){
       s1.add(a);
        String testS1= s1.toString();
        System.out.println(s1);
        assertEquals(testS1,"0.0,0.0");
    }
    @Test
    public void testEquals(){
        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        Polygon_2D testE= (Polygon_2D) s1.copy();
        assertTrue(testE.toString().equals(s1.toString()));
        assertEquals(s1.toString(),testE.toString());
    }
}
