package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.Test;

import static org.junit.Assert.*;
public class TestRect {

    private Rect_2D s1 = new Rect_2D(Point_2D.ORIGIN, new Point_2D(6, 4));
    private Point_2D p1 = new Point_2D(5, 0);
    private Point_2D p2 = new Point_2D(0, 7);
    private Rect_2D s2= new Rect_2D(p1,p2);

    @Test
    public void areaTest(){
        double a= s1.area();
        assertEquals(a,24,Ex2_Const.EPS);
        double ar= s2.area();
        assertEquals(ar,35, Ex2_Const.EPS);
    }
    @Test
    public void perimeterTest(){
        double p= s1.perimeter();
        assertEquals(p,20,Ex2_Const.EPS);
        double per= s2.perimeter();
        assertEquals(per,24,Ex2_Const.EPS);
    }
    @Test
    public void containsTest(){
        Point_2D q0 = new Point_2D(0,2);
        boolean b1 = s1.contains(q0);
        assertTrue(b1);
        Point_2D q1 = new Point_2D(0,6);
        boolean b2 = s1.contains(q1);
        assertFalse(b2);
        Point_2D q2 = new Point_2D(0,5);
        boolean b3 = s2.contains(q2);
        assertTrue(b3);
        Point_2D q3 = new Point_2D(0,8);
        boolean b4 = s2.contains(q3);
        assertFalse(b4);
    }
    @Test
    public void testCopy(){
        Rect_2D c= (Rect_2D) s1.copy();
        assertEquals(c.getAllPoints(),s1.getAllPoints());
        Rect_2D co= (Rect_2D) s2.copy();
        assertEquals(co.getAllPoints(),s2.getAllPoints());
    }
    @Test
    public void testScale(){
        Rect_2D temp= (Rect_2D) s1.copy();
        Point_2D centerTest= new Point_2D(2,2);
        s1.scale(centerTest,110.0/100.0);
        assertNotEquals(s1.getAllPoints(),temp.getAllPoints());
        s1.scale(centerTest,100.0/110.0);
        assertArrayEquals(s1.getAllPoints(),temp.getAllPoints());
        Rect_2D temp1= (Rect_2D) s2.copy();
        s2.scale(centerTest,90.0/100.0);
        assertNotEquals(s2.getAllPoints(),temp1.getAllPoints());
        s2.scale(centerTest,100.0/90.0);
        assertArrayEquals(s2.getAllPoints(), temp1.getAllPoints());
    }
    @Test
    public void testRotate() {
        Rect_2D temp = (Rect_2D) s1.copy();
        Point_2D centerTest = new Point_2D(2, 2);
        s1.rotate(centerTest, 45);
        assertNotEquals(s1.getAllPoints(), temp.getAllPoints());
        s1.rotate(centerTest, -45);
        Point_2D[] arrS1 = s1.getAllPoints();
        Point_2D[] arrTemp = temp.getAllPoints();
        for (int i = 0; i < arrS1.length; i++) {
            assertEquals(arrS1[i].x(), arrTemp[i].x(), Ex2_Const.EPS);
            assertEquals(arrS1[i].y(), arrTemp[i].y(), Ex2_Const.EPS);
        }
    }
    @Test
    public void testGetAllPounts(){
        Point_2D[] arrS1=s1.getAllPoints();
        Point_2D [] arrTest= new Point_2D[4];
        arrTest[0]= new Point_2D(0,0);
        arrTest[1]= new Point_2D(6,0);
        arrTest[2]= new Point_2D(6,4);
        arrTest[3]= new Point_2D(0,4);
        assertArrayEquals(arrTest,arrS1);
        Point_2D[] arrS2=s2.getAllPoints();
        Point_2D [] arrayTest= new Point_2D[4];
        arrayTest[0]= new Point_2D(5,0);
        arrayTest[1]= new Point_2D(0,0);
        arrayTest[2]= new Point_2D(0,7);
        arrayTest[3]= new Point_2D(5,7);
        assertArrayEquals(arrayTest,arrS2);
        }

        @Test
    public void testToString(){
        String testS1= s1.toString();
        String testStr= "0.0,0.0,6.0,0.0,6.0,4.0,0.0,4.0";
        assertEquals(testStr,testS1);
        String testS2= s2.toString();
        String testString= "5.0,0.0,0.0,0.0,0.0,7.0,5.0,7.0";
        assertEquals(testString,testS2);
        }
        @Test
    public void testTranslate(){
        Rect_2D testS1= new Rect_2D(new Point_2D(1,1),new Point_2D(7,5));
        s1.translate(new Point_2D(1,1));
        assertArrayEquals(s1.getAllPoints(),testS1.getAllPoints());
        Rect_2D testS2= new Rect_2D(new Point_2D(7,2),new Point_2D(2,9));
        s2.translate(new Point_2D(2,2));
        assertArrayEquals(s2.getAllPoints(),testS2.getAllPoints());
        }
        @Test
    public void testEquals(){
        Rect_2D testE= (Rect_2D) s1.copy();
        assertTrue(s1.equals(testE));
        assertEquals(s1,testE);
        }
    }
