package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTriangle {
    private Triangle_2D s1= new Triangle_2D(Point_2D.ORIGIN,
            new Point_2D(6,6), new Point_2D(-6,6));
    private Point_2D p1= new Point_2D(2,0);
    private Point_2D p2= new Point_2D(-2,0);
    private Point_2D p3= new Point_2D(0,4);
    private Triangle_2D s2= new Triangle_2D(p1,p2,p3);
    @Test
    public void testArea(){
        double a= s1.area();
        assertEquals(a,36,Ex2_Const.EPS);
        double ar= s2.area();
        assertEquals(ar,8,Ex2_Const.EPS);

    }
    @Test
    public void testPerimeter(){
       double per= s1.perimeter();
       double per1= s2.perimeter();
       assertEquals(per,28.970562748477136, Ex2_Const.EPS);
       assertEquals(per1,12.94427190999916,Ex2_Const.EPS);

    }
    @Test
    public void testContains(){
        Point_2D q0 = new Point_2D(0,2);
        boolean b1 = s1.contains(q0);
        assertTrue(b1);
        Point_2D q1 = new Point_2D(0,7);
        boolean b2 = s1.contains(q1);
        assertFalse(b2);
        Point_2D q2 = new Point_2D(0,2);
        boolean b3 = s2.contains(q2);
        assertTrue(b3);
        Point_2D q3 = new Point_2D(0,5);
        boolean b4 = s1.contains(q3);
        assertTrue(b4);
    }
    @Test
    public void testScale(){
        Point_2D n=new Point_2D(0,2);
        Triangle_2D temp =(Triangle_2D) s2.copy();
        s2.scale(n,90.0/100.0);
        assertNotEquals(s2.area(),temp.area(),Ex2_Const.EPS);
        s2.scale(n,100.0/90.0);
        assertEquals(s2.area(),temp.area(),Ex2_Const.EPS);
        Point_2D n1=new Point_2D(0,2);
        Triangle_2D temp1 =(Triangle_2D) s1.copy();
        s1.scale(n1,100.0/110.0);
        assertNotEquals(s2.area(),temp1.area(),Ex2_Const.EPS);
        s1.scale(n1,110.0/100.0);
        assertEquals(s1.area(),temp1.area(),Ex2_Const.EPS);
    }
    @Test
    public void testRotate(){
        Point_2D centerTest= new Point_2D(0,2);
        Triangle_2D temp= (Triangle_2D) s2.copy();
        s2.rotate(centerTest,45);
        Point_2D[]arrayS1=s2.getAllPoints();
        Point_2D[] arrayTemp= temp.getAllPoints();
        for (int j = 0; j < arrayS1.length ; j++) {
            assertNotEquals(arrayS1[j].x(),arrayTemp[j].x());
            assertNotEquals(arrayS1[j].y(),arrayTemp[j].y());}
        s2.rotate(centerTest,-45);
        Point_2D [] arrS2= s2.getAllPoints();
        Point_2D [] arrTemp= temp.getAllPoints();
        for (int i = 0; i < arrS2.length; i++) {
            assertEquals(arrS2[i].x(), arrTemp[i].x(), Ex2_Const.EPS);
            assertEquals(arrS2[i].y(), arrTemp[i].y(), Ex2_Const.EPS);
        }
    }
    @Test
    public void tastToString(){
        String testS1= s1.toString();
        String testTo= "0.0,0.0,6.0,6.0,-6.0,6.0";
        assertEquals(testS1,testTo);
    }
    @Test
    public void testGetAllPoints(){
        Point_2D[] testS2= s2.getAllPoints();
        Point_2D [] testArr= new Point_2D[3];
        testArr[0]= new Point_2D(2,0);
        testArr[1]= new Point_2D(-2,0);
        testArr[2]= new Point_2D(0,4);
        assertArrayEquals(testS2,testArr);
    }
    @Test
    public void testCopy(){
        Triangle_2D temp= (Triangle_2D) s2.copy();
        assertArrayEquals(s2.getAllPoints(),temp.getAllPoints());
        Triangle_2D temp1= (Triangle_2D) s1.copy();
        assertArrayEquals(s1.getAllPoints(),temp1.getAllPoints());
    }
    @Test
    public void testTranslate(){
        Triangle_2D testS1= new Triangle_2D(new Point_2D(1,1),new Point_2D(7,7),new Point_2D(-5,7));
        s1.translate(new Point_2D(1,1));
        assertArrayEquals(s1.getAllPoints(),testS1.getAllPoints());
        Triangle_2D testS2= new Triangle_2D(new Point_2D(4,2),new Point_2D(0,2),new Point_2D(2,6));
        s2.translate(new Point_2D(2,2));
        assertArrayEquals(s2.getAllPoints(),testS2.getAllPoints());
    }
    @Test
    public void testEquals(){
        Triangle_2D testE= (Triangle_2D) s1.copy();
        assertTrue(s1.equals(testE));
        assertEquals(s1,testE);
    }
}

