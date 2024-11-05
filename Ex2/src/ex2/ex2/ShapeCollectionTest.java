package ex2.ex2;

import ex2.geo.*;
import ex2.gui.Ex2;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectionTest {
    Point_2D p1 = new Point_2D(3,4);
    Point_2D p2= new Point_2D(3,0);
    Segment_2D s1= new Segment_2D(p2,p1);
    GUI_Shape gs2=new GUIShape(s1,true,Color.black,2);
    Circle_2D c1 = new Circle_2D(p1,2);
    GUI_Shape gs1 = new GUIShape(c1, true,Color.black, 1);
    ShapeCollection sc= new ShapeCollection();


    @Test
    void size() {
    sc.add(gs1);
    int testSC= sc.size();
    int testS= 1;
    assertEquals(testSC,testS);
    }

    @Test
    void removeElementAt() {
    sc.add(gs1);
    sc.add(gs2);
    sc.removeElementAt(0);
    String testSC= sc.toString();
    String testR= "GUIShape,0,true,1,Segment_2D,3.0,0.0,3.0,4.0";
    assertEquals(testR,testSC);
    }

    @Test
    void addAt() {
        sc.add(gs1);
        sc.add(gs2);
        sc.addAt(gs1, 1);
        assertEquals(sc.get(1).toString(),gs1.toString());
    }

    @Test
    void add() {
        sc.add(gs1);
        String testSC= sc.get(0).toString();
        String testS= "GUIShape,0,true,1,Circle_2D,3.0,4.0,2.0";
        assertEquals(testSC,testS);
    }

    @Test
    void copy() {
        GUI_Shape testC= (GUI_Shape) gs1.copy();
        assertEquals(gs1.getShape(),testC.getShape());
    }

    @Test
    void sort() {
       sc.add(gs1);
       sc.add(gs2);
       sc.sort(ShapeComp.CompByArea);
        assertEquals(sc.get(0).toString(), gs2.toString());
       sc.sort(ShapeComp.CompByAntiArea);
       assertEquals(sc.get(0).toString(),gs1.toString());
       sc.sort(ShapeComp.CompByPerimeter);
       assertEquals(sc.get(0).toString(),gs2.toString());
       sc.sort(ShapeComp.CompByToString);
       assertEquals(sc.get(0).toString(), gs1.toString());
       sc.sort(ShapeComp.CompByAntiToString);
       assertEquals(sc.get(0).toString(), gs2.toString());
       sc.sort(ShapeComp.CompByTag);
       assertEquals(sc.get(0).toString(), gs1.toString());
       sc.sort(ShapeComp.CompByAntiTag);
       assertEquals(sc.get(0).toString(),gs2.toString());

    }

    @Test
    void removeAll() {
        sc.add(gs1);
        sc.add(gs2);
        assertEquals(sc.size(),2);
        sc.removeAll();
        assertEquals(sc.size(),0);
    }

    @Test
    void save() {
    sc.add(gs1);
    sc.add(gs2);
    String file= "file.txt";
    //Ex2 in = Ex2.getInstance();
    //in.init(sc);
    sc.save(file);
    ShapeCollection test= new ShapeCollection();
    test.load(file);
    //System.out.println(test);
    //Ex2 in = Ex2.getInstance();
    //in.init(sc);
//        test.modifyString(test.toString(),)
    assertEquals(sc.toString(),test.toString());
    }

    @Test
    void load() {
        sc.load("savetest.txt");
        System.out.println(sc.toString());
        assertNotEquals("",sc.toString());
        String test= sc.toString();
        System.out.println(test);
        assertEquals( "GUIShape,0,true,1,Circle_2D,3.0,4.0,2.0" +
                "GUIShape,16776960,true,2,Rect_2D,3.0,4.0,6.0,4.0,6.0,8.0,3.0,8.0",test);
    }

    @Test
    void testToString() {
        String gs1Temp= gs1.toString();
        String testG= "GUIShape,0,true,1,Circle_2D,3.0,4.0,2.0";
        assertEquals(gs1Temp,testG);
    }
}