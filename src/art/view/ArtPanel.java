package art.view;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.event.*;
import javax.swing.*;
import java.util.Hashtable;
import javax.swing.event.*;
import art.controller.ArtController;

public class ArtPanel extends JPanel
{
	private final int MINIMUM_EDGE = 5;
	private final int MAXIMUM_EDGE = 20;
	private final int MINIMUM_SCALE = 20;
	private final int MAXIMUM_SCALE = 100;
	
	private ArtController app;
	
	private SpringLayout appLayout;
	private ShapeCanvas canvas;
	private JPanel buttonPanel, sliderPanel;
	private JSlider scaleSlider, edgeSlider;
	private JButton triangleButton, rectangleButton, ellipseButton, polygonButton, clearButton, saveButton, colorButton;
	
	private int currentEdgeCount;
	private int currentScale;
	
	
	
	public ArtPanel(ArtController app)
	{
		super();
		this.app = app;
		appLayout = new SpringLayout();
		
		currentScale 		= MINIMUM_SCALE;
		currentEdgeCount 	= MINIMUM_EDGE;
		
		scaleSlider 	= new JSlider(MINIMUM_SCALE, MAXIMUM_SCALE);
		edgeSlider 	= new JSlider(MINIMUM_EDGE, MAXIMUM_EDGE);
		
		canvas = new ShapeCanvas(app);
		appLayout.putConstraint(SpringLayout.NORTH, canvas, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, canvas, 50, SpringLayout.WEST, this);
		
		sliderPanel 	= new JPanel();
		appLayout.putConstraint(SpringLayout.NORTH, sliderPanel, 0, SpringLayout.NORTH, canvas);
		buttonPanel 	= new JPanel(new GridLayout(0,1));
		appLayout.putConstraint(SpringLayout.WEST, sliderPanel, 20, SpringLayout.EAST, buttonPanel);
		appLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 0, SpringLayout.NORTH, canvas);
		appLayout.putConstraint(SpringLayout.WEST, buttonPanel, 40, SpringLayout.EAST, canvas);
		
		triangleButton 	= new JButton("add triangle");
		rectangleButton 	= new JButton("add rectangle");
		ellipseButton 	= new JButton("add ellipse");
		polygonButton 	= new JButton("add polygon");
		clearButton 		= new JButton("clear image");
		saveButton 		= new JButton("save image");
		colorButton 		= new JButton("change color");
		
		setupSliders();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	public void setupSliders()
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		Hashtable<Integer, JLabel> edgeLabels = new Hashtable<Integer, JLabel>();
		
		scaleLabels.put(MINIMUM_SCALE, new JLabel("<HTML>Small<BR>Shape</HTML>"));
		scaleLabels.put((MAXIMUM_SCALE + MINIMUM_SCALE) / 2, new JLabel("<HTML>Medium<BR>Shape</HTML>"));
		scaleLabels.put(MAXIMUM_SCALE, new JLabel("<HTML>Large<BR>Shape</HTML>"));
		
		edgeLabels.put(MINIMUM_EDGE, new JLabel("Edges: " + MINIMUM_EDGE));
		edgeLabels.put(MAXIMUM_EDGE, new JLabel("Edges: " + MAXIMUM_EDGE));
		
		scaleSlider.setLabelTable(scaleLabels);
		scaleSlider.setOrientation(JSlider.VERTICAL);
		scaleSlider.setSnapToTicks(true);
		scaleSlider.setMajorTickSpacing(10);
		scaleSlider.setPaintTicks(true);
		scaleSlider.setPaintLabels(true);
		
		edgeSlider.setLabelTable(edgeLabels);
		edgeSlider.setOrientation(JSlider.VERTICAL);
		edgeSlider.setSnapToTicks(true);
		edgeSlider.setMajorTickSpacing(3);
		edgeSlider.setMajorTickSpacing(1);
		edgeSlider.setPaintTicks(true);
		edgeSlider.setPaintLabels(true);
	}
	public void setupPanel()
	{
		this.setLayout(appLayout);
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension (1024, 768));
		this.add(canvas);
		
		buttonPanel.setPreferredSize(new Dimension(200, 450));
		buttonPanel.add(triangleButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(ellipseButton);
		buttonPanel.add(polygonButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(colorButton);
		
		sliderPanel.setPreferredSize(new Dimension(250, 450));
		sliderPanel.add(scaleSlider);
		sliderPanel.add(edgeSlider);
		
		this.add(buttonPanel);
		this.add(sliderPanel);
	}
	public void setupLayout()
	{
		
	}
	public void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Rectangle rectangle = createRectangle();
				canvas.addShape(rectangle);
			}
		});
		polygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Polygon polygon = createPolygon(currentEdgeCount);
				canvas.addShape(polygon);
			}
		});
		triangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Polygon triangle = createPolygon(3);
				canvas.addShape(triangle);
			}
		});
		ellipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Ellipse2D ellipse = createEllipse();
				canvas.addShape(ellipse);
			}
		});
		
		clearButton.addActionListener(click -> canvas.clear());
		saveButton.addActionListener(click -> canvas.save());
		colorButton.addActionListener(click -> canvas.changeBackground());
		
		scaleSlider.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				if(!scaleSlider.getValueIsAdjusting())
				{
					currentScale = scaleSlider.getValue();
				}
			}
		});
		
		
		
		edgeSlider.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				if(!edgeSlider.getValueIsAdjusting())
				{
					currentEdgeCount = edgeSlider.getValue();
				}
			}
		});
		
		canvas.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{}
			public void mousePressed(MouseEvent e)
			{}
			public void mouseReleased(MouseEvent e)
			{
				canvas.resetPoint();
			}
			public void mouseEntered(MouseEvent e)
			{}
			public void mouseExited(MouseEvent e)
			{
				canvas.resetPoint();	
			}
		});
		
		
		canvas.addMouseMotionListener(new MouseMotionListener()
		{		
			public void mouseDragged(MouseEvent drag)
			{
				int x = drag.getX();
				int y = drag.getY();
				canvas.drawOnCanvas(x,y);
			}
				
			public void mouseMoved(MouseEvent move)
			{
				int x = move.getX();
				int y = move.getY();
					
					System.out.println("The X is at " + " and the Y is at " + y);
			}
				
		});
		
	}
	
	
	private boolean coinFlip()
	{
		return (int)(Math.random() * 2) == 0;
	}
	
	private Polygon createPolygon(int sides)
	{
		Polygon currentShape = new Polygon();
				
		int originX = (int)(Math.random() * 600);
		int originY = (int)(Math.random() * 600);
		
		for(int index = 0; index < sides; index++)
		{
			int minus = coinFlip() ? -1 : 1;
			int shiftX = (int)(Math.random() * currentScale) * minus;
			minus = coinFlip() ? -1 : 1;
			int shiftY = (int)(Math.random() * currentScale) * minus;
			currentShape.addPoint(originX + shiftX,  originY + shiftY);
		}
		
		return currentShape;
	}
	
	private Rectangle createRectangle()
	{
		Rectangle currentRectangle;
		
		int cornerX = (int)(Math.random() * 600);
		int cornerY = (int)(Math.random() * 600);
		int width = (int)(Math.random() * currentScale) + 1;
		if(coinFlip())
		{
			currentRectangle = new Rectangle(cornerX, cornerY, width, width);
		}
		else
		{
			int height = (int)(Math.random() * currentScale) + 1;
			currentRectangle = new Rectangle(cornerX, cornerY, width, height);
		}
		
		return currentRectangle;
	}
	
	private Ellipse2D createEllipse()
	{
		Ellipse2D ellipse = new Ellipse2D.Double();
		
		int cornerX = (int)(Math.random() * 600);
		int cornerY = (int)(Math.random() * 600);
		double width = Math.random() * currentScale + 1;
		if(coinFlip())
		{
			ellipse.setFrame(cornerX, cornerY, width, width);
		}
		else
		{
			double height = (int)(Math.random() * currentScale) + 1;
			ellipse.setFrame(cornerX, cornerY, width, width);
		}
		
		return ellipse;
	}
	
}
