package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.Test;

import javax.lang.model.util.Elements;

import static org.junit.Assert.*;
    public class TestCircle {
        private Circle_2D c1= new Circle_2D(Point_2D.ORIGIN,2);
        private Point_2D p1= new Point_2D(1,0);
        private Circle_2D c2= new Circle_2D(p1,3);

        @Test
        public void testArea(){
            double a= c1.area();
            assertEquals(a,4*Math.PI,Ex2_Const.EPS);
            double ar= c2.area();
            assertEquals(ar,9*Math.PI,Ex2_Const.EPS);
        }

        @Test
        public void testPerimeter(){
            double a= c1.perimeter();
            assertEquals(a,4*Math.PI,Ex2_Const.EPS);
            double ar= c2.perimeter();
            assertEquals(ar,6*Math.PI,Ex2_Const.EPS);
        }
        @Test
        public void testContain(){
            Point_2D q0 = new Point_2D(1,0);
            boolean b1 = c1.contains(q0);
            assertTrue(b1);
            Point_2D q1 = new Point_2D(3,0 );
            boolean b2 = c1.contains(q1);
            assertFalse(b2);
            Point_2D q2 = new Point_2D(2,0 );
            boolean b3 = c2.contains(q2);
            assertTrue(b3);
            Point_2D q3 = new Point_2D(4,0 );
            boolean b4 = c2.contains(q3);
            assertFalse(b4);
        }
        @Test
        public void testScale(){
            Circle_2D temp= (Circle_2D) c1.copy();
            Point_2D centerTest= new Point_2D(1,1);
            c1.scale(centerTest,110.0/100.0);
            assertNotEquals(c1.area(),temp.area(),Ex2_Const.EPS);
            c1.scale(centerTest,100.0/110.0);
            assertEquals(c1.area(),temp.area(),Ex2_Const.EPS);
            Circle_2D temp1= (Circle_2D) c2.copy();
            c2.scale(centerTest,90.0/100.0);
            assertNotEquals(c2.area(),temp.area(),Ex2_Const.EPS);
            c2.scale(centerTest,100.0/90.0);
            assertNotEquals(c2.area(),temp.area(),Ex2_Const.EPS);
        }
        @Test
        public void testRotate(){
            Circle_2D temp= (Circle_2D) c1.copy();
            Point_2D centerTest= new Point_2D(0,0);
            c1.rotate(centerTest,45);
            c1.rotate(centerTest,-45);
            assertEquals(c1.getCenter(),temp.getCenter());
            Circle_2D temp1= (Circle_2D) c2.copy();
            Point_2D centerT= new Point_2D(0,0);
            c2.rotate(centerT,45);
            assertNotEquals(c2.getCenter(),temp1.getCenter());
            c2.rotate(centerT,-45);
            assertEquals(c2.getCenter(),temp1.getCenter());
        }
        @Test
        public void testToString(){
           String testC1= c1.toString();
           String testStr= "0.0,0.0,2.0";
           assertEquals(testStr,testC1);
            String testC2= c2.toString();
            String testString= "1.0,0.0,3.0";
            assertEquals(testString,testC2);

        }
        @Test
        public void testGetCenter(){
            Point_2D testC1= c1.getCenter();
            assertEquals(testC1, Point_2D.ORIGIN);
            Point_2D testC2= c2.getCenter();
            assertEquals(testC2,new Point_2D(1,0));
        }
        @Test
        public void testGetRadius(){
            double testC1= c1.getRadius();
            assertEquals(testC1,2.0,Ex2_Const.EPS);
            double testC2= c2.getRadius();
            assertEquals(testC2,3.0,Ex2_Const.EPS);

        }
        @Test
        public void testTranslate(){
            Circle_2D testC1= new Circle_2D(new Point_2D(0,1),2.0);
            c1.translate(new Point_2D(0,1));
            assertEquals(c1.getCenter(),testC1.getCenter());
            assertEquals(c1.getRadius(),testC1.getRadius(),Ex2_Const.EPS);
            Circle_2D testC2= new Circle_2D(new Point_2D(0,0),3.0);
            c2.translate(new Point_2D(-1,0));
            assertEquals(c2.getCenter(),testC2.getCenter());
            assertEquals(c2.getRadius(),testC2.getRadius(),Ex2_Const.EPS);

        }
        @Test
        public void testCopy() {
            Circle_2D temp = (Circle_2D) c1.copy();
            assertEquals(temp.getRadius(),c1.getRadius(),Ex2_Const.EPS);
            assertEquals(temp.getCenter(),c1.getCenter());
            Circle_2D temp1 = (Circle_2D) c2.copy();
            assertEquals(temp1.getRadius(),c2.getRadius(),Ex2_Const.EPS);
            assertEquals(temp1.getCenter(),c2.getCenter());
        }
        @Test
        public void testEquals(){
            Circle_2D testE= (Circle_2D) c1.copy();
            assertTrue(testE.equals(c1));
            Circle_2D testE2= (Circle_2D) c2.copy();
            assertTrue(testE2.equals(c2));
        }
}
