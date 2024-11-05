package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPoint {
    private Point_2D a= new Point_2D(0,0);
    @Test
    public void testToString(){
        String testT= a.x()+ "," +a.y();
        String testA= a.toString();
        assertEquals(testA,testT);
    }
    @Test
    public void testAdd(){
        Point_2D testA= new Point_2D(1,1);
        Point_2D temp= a.add(testA);
        assertEquals(temp,testA);
    }
    @Test
    public void testDistance(){
    double dist= 5;
    Point_2D d= new Point_2D(5,0);
     double s= a.distance(d);
    assertEquals(s,dist,Ex2_Const.EPS);
    }
    @Test
    public void testMove(){
        Point_2D testA= new Point_2D(1,1);
        a.move(new Point_2D(1,1));
        assertEquals(a,testA);
    }
    @Test
    public void testScale(){
        Point_2D a= new Point_2D(1,1);
        Point_2D centerTest= new Point_2D(0,0);
        Point_2D testA= new Point_2D(1.1,1.1);
        a.scale(centerTest,110.0/100.0);
        assertEquals(a,testA);

    }
    @Test
    public void testRotate(){
        Point_2D temp= a.add(a);
        Point_2D centerTest= new Point_2D(1,1);
        a.rotate(centerTest,45);
        assertNotEquals(a,temp);
        a.rotate(centerTest,-45);
        assertEquals(a.x(),temp.x(),Ex2_Const.EPS);
        assertEquals(a.y(),temp.y(),Ex2_Const.EPS);
    }
    @Test
    public void testEquals(){
        Point_2D testP= new Point_2D(0,0);
        assertTrue(a.equals(testP));
        Point_2D test2= new Point_2D(1,1);
        assertFalse(a.equals(test2));
    }
}
