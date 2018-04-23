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
		super();
		Dimension sizeDimension = new Dimension(600,600);
		this.app = app;
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		ellipseList = new ArrayList<Ellipse2D>();
		rectangleList = new ArrayList<Rectangle>();
		
		canvasImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
		this.setMinimumSize(sizeDimension);
		this.setPreferredSize(sizeDimension);
		this.setMaximumSize(getPreferredSize());
	}
	
	public void addShape(Shape current)
	{
		if(current instanceof Polygon)
		{
			if(((Polygon)current).xpoints.length == 3)
			{
				triangleList.add((Polygon) current);
			}
			else
			{
				polygonList.add((Polygon) current);
			}
		}
		else if(current instanceof Ellipse2D)
		{
			ellipseList.add((Ellipse2D) current);
		}
		else
		{
			rectangleList.add((Rectangle) current);
		}
		updateImage();
	}
	
	public void clear()
	{
		
	}
	
	public void changeBackground()
	{
		
	}
	
	public void save()
	{
		
	}
	
	private Color randomColor()
	{
		
	}
	
	private void updateImage()
	{
		
	}
	
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(canvasImage,  0,  0,  null);
	}
}
