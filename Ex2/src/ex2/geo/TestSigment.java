package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSigment {
    private Segment_2D s1 = new Segment_2D(Point_2D.ORIGIN, new Point_2D(0, 1));
    private Point_2D p1 = new Point_2D(1, 0);
    private Point_2D p2 = new Point_2D(1, 5);
    private Segment_2D s2 = new Segment_2D(p1, p2);

    @Test
    public void testParamiter() {
        double p = s1.perimeter();
        assertEquals(p, 2, Ex2_Const.EPS);
        p = s2.perimeter();
        assertEquals(p, 10, Ex2_Const.EPS);
    }

    @Test
    public void testContain() {
        Point_2D q0 = new Point_2D(0, 0.3);
        boolean b1 = s1.contains(q0);
        assertTrue(b1);

        q0 = new Point_2D(0, 1.3);
        b1 = s1.contains(q0);
        assertFalse(b1);

        q0 = new Point_2D(1, 3);
        b1 = s2.contains(q0);
        assertTrue(b1);

        q0 = new Point_2D(1, 7);
        b1 = s2.contains(q0);
        assertFalse(b1);
    }

    @Test
    public void testArea() {
        double a = s1.area();
        assertEquals(a, 0, Ex2_Const.EPS);
        double ar = s2.area();
        assertEquals(ar, 0, Ex2_Const.EPS);
    }

    @Test
    public void testScale() {
        Segment_2D temp = (Segment_2D) s1.copy();
        Point_2D centerTest = new Point_2D(1, 0);
        s1.scale(centerTest, 110.0 / 100.0);
        assertNotEquals(s1.get_p1(), temp.get_p1());
        s1.scale(centerTest, 100.0 / 110.0);
        assertEquals(s1.get_p1(), temp.get_p1());
        assertEquals(s1.get_p2(), temp.get_p2());

        Segment_2D temp1 = (Segment_2D) s1.copy();
        s1.scale(centerTest, 90.0 / 100.0);
        assertNotEquals(s1.get_p1(), temp1.get_p1());
        s1.scale(centerTest, 100.0 / 90.0);
        assertEquals(s1.get_p1(), temp1.get_p1());
        assertEquals(s1.get_p2(), temp1.get_p2());
    }

    @Test
    public void testRotate() {
        Segment_2D temp = (Segment_2D) s1.copy();
        Point_2D centerTest = new Point_2D(1, 0);
        s1.rotate(centerTest, 45);
        assertNotEquals(s1.get_p1(), temp.get_p1());
        s1.rotate(centerTest, -45);
        assertEquals(s1.get_p1().x(), temp.get_p1().x(), Ex2_Const.EPS);
        assertEquals(s1.get_p1().y(), temp.get_p1().y(), Ex2_Const.EPS);
        assertEquals(s1.get_p2().x(), temp.get_p2().x(), Ex2_Const.EPS);
        assertEquals(s1.get_p2().y(), temp.get_p2().y(), Ex2_Const.EPS);
    }

    @Test
    public void testCopy() {
        Segment_2D temp = (Segment_2D) s1.copy();
        assertEquals(s1.get_p1(), temp.get_p1());
        assertEquals(s1.get_p2(), temp.get_p2());
        Segment_2D temp1 = (Segment_2D) s2.copy();
        assertEquals(s2.get_p1(), temp1.get_p1());
        assertEquals(s2.get_p2(), temp1.get_p2());
    }

    @Test
    public void testTranslate() {
        Segment_2D testS1 = new Segment_2D(new Point_2D(1, 1), new Point_2D(1, 2));
        s1.translate(new Point_2D(1, 1));
        assertEquals(s1.get_p1(), testS1.get_p1());
        assertEquals(s1.get_p2(), testS1.get_p2());
        Segment_2D testS2 = new Segment_2D(new Point_2D(2, 1), new Point_2D(2, 6));
        s2.translate(new Point_2D(1, 1));
        assertEquals(s2.get_p1(), testS2.get_p1());
        assertEquals(s2.get_p2(), testS2.get_p2());
    }

    @Test
    public void testGet_p1() {
        Point_2D testS1 = s1.get_p1();
        assertEquals(testS1, new Point_2D(0, 0));
        Point_2D testS2 = s2.get_p1();
        assertEquals(testS2, new Point_2D(1, 0));
    }

    @Test
    public void testGet_p2() {
        Point_2D testS1 = s1.get_p2();
        assertEquals(testS1, new Point_2D(0, 1));
        Point_2D testS2 = s2.get_p2();
        assertEquals(testS2, new Point_2D(1, 5));
    }
    @Test
    public void testToString(){
        String temp= s1.toString();
        String testS1="0.0,0.0,0.0,1.0";
        assertEquals(testS1,temp);
        String temp1= s2.toString();
        String testS2="1.0,0.0,1.0,5.0";
        assertEquals(testS2,temp1);
    }
    @Test
    public void testEquals(){
        Segment_2D testE= (Segment_2D) s1.copy();
        assertTrue(testE.equals(s1));
        assertEquals(testE,s1);
    }
}
