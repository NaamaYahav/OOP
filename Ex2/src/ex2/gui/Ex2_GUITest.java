package ex2.gui;

import ex2.ex2.ShapeCollection;
import ex2.geo.GeoShape;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Ex2_GUITest {
    Point_2D p1= Point_2D.ORIGIN;
    Point_2D p2= new Point_2D(3,3);
    Segment_2D test1= new Segment_2D(p1,p2);
    GUI_Shape g1= new GUIShape(test1,true, Color.black, 1);

    @Test
    void init() {
        Ex2 ex2 = Ex2.getInstance();
        ShapeCollection sc=new ShapeCollection();
        sc.add(g1);
        ex2.init(sc);
        assertEquals(sc,ex2.getShape_Collection());
    }

    @Test
    void getShape_Collection() {
        Ex2 ex2 = Ex2.getInstance();
        ShapeCollection sc=new ShapeCollection();
        sc.add(g1);
        ex2.init(sc);
        assertEquals(sc,ex2.getShape_Collection());
    }

    @Test
    void getInfo() {
        Ex2 ex2 = Ex2.getInstance();
        ShapeCollection sc=new ShapeCollection();
        sc.add(g1);
        ex2.init(sc);
        String a =ex2.getInfo();
        assertEquals(sc.toString()+"\n",a.toString());
    }
}