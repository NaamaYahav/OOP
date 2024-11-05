
package ex2.ex2;

import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import java.awt.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList<GUI_Shape> _shapes;

	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}

	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		_shapes.remove(i);
		return null;

	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		_shapes.add(i, s);
	}

	@Override
	public void add(GUI_Shape s) {
		if (s != null && s.getShape() != null) {
			_shapes.add(s);
		}
	}

	@Override
	public GUI_Shape_Collection copy() {
		ShapeCollection SC = new ShapeCollection();
		for (int i = 0; i < _shapes.size(); i++) {
			SC.add(_shapes.get(i));
		}
		return SC;

	}

	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		this._shapes.clear();
	}

	public String modifyString(String replacement, String[] t) {
		String temp = "";

		for (int i = 4; i < t.length; i++) {
			temp += t[i] + ",";
		}
		String m = t[0] + "," + replacement + "," + temp;
		return m;
	}


	@Override
	public void save(String file) {
		String[] shapeString = file.split(",");
		try (BufferedWriter myWriter = new BufferedWriter(new FileWriter(shapeString[0]))) {
			for (GUI_Shape shape : _shapes) {
				String allStrings = shape.toString();
				if (allStrings.contains("java.awt.Color")) {
					String[] t = allStrings.split(",");
					int colorS = colorEncoding(shape.getColor());
					allStrings = modifyString(String.valueOf(colorS), t);
				}
				myWriter.write(allStrings);
				myWriter.newLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error writing to file" + e.getMessage());
		}
	}

	public static int colorEncoding(Color c) {
		int red = c.getRed();
		int blue = c.getBlue();
		int green = c.getGreen();
		int ce = red * 256 * 256 + green * 256 + blue;
		return ce;
	}

	@Override
	public void load(String file) {
		try {
			File objectL = new File(file);
			Scanner reader = new Scanner(objectL);
			_shapes.clear();

			while (reader.hasNextLine()) {
				String stringData = reader.nextLine();
				GUI_Shape shape = new GUIShape(stringData);
				_shapes.add(shape);
				System.out.println(stringData);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}


	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i).toString();
		}
		return ans;
	}

}
