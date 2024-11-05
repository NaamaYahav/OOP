package ex2.gui;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;
public class GuiTest {
    Point_2D p1 = new Point_2D(3,4);
    Circle_2D c1 = new Circle_2D(p1,2);
    GUI_Shape gs1 = new GUIShape(c1, true, Color.black, 1);
    @Test
    public void testCopy(){
     GUI_Shape copy= (GUI_Shape) gs1.copy();
     assertEquals(copy.getShape(),gs1.getShape());
    }
    @Test
    public void testToString(){
        String temp= gs1.toString();
        //System.out.println(temp);
        String testS= "GUIShape,java.awt.Color[r=0,g=0,b=0],true,1,Circle_2D,3.0,4.0, 2.0";
        assertEquals(testS,temp);
    }
    @Test
    public void testEquals(){
        GUI_Shape testE= (GUI_Shape) gs1.copy();
        assertTrue(testE.getShape().equals(gs1.getShape()));
        assertEquals(testE.getShape(),gs1.getShape());
    }

}
