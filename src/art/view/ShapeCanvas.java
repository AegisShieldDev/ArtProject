package art.view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javax.swing.*;

import art.controller.*;

public class ShapeCanvas extends JPanel
{
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Rectangle> rectangleList;
	private ArtController app;
	
	private BufferedImage canvasImage;
	
	public ShapeCanvas(ArtController app)
	{
		
	}
}
