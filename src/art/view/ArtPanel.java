package art.view;

import java.awt.*;
import javax.swing.*;
import java.util.Hashtable;
import javax.swing.event.*;
import art.controller.ArtController;

public class ArtPanel
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
		
		currentScale = MINIMUM_SCALE;
		currentEdgeCount = MINIMUM_EDGE;
		scaleSlider = new JSlider(MINIMUM_SCALE, MAXIMUM_SCALE);
		edgeSlider = new JSlider(MINIMUM_EDGE, MAXIMUM_EDGE);
		
		canvas = new ShapeCanvas(app);
		sliderPanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(0,1));
		
		triangleButton = new JButton("add triangle");
		rectangleButton = new JButton("add rectangle");
		ellipseButton = new JButton("add ellipse");
		polygonButton = new JButton("add polygon");
		clearButton = new JButton("clear image");
		saveButton = new JButton("save image");
		colorButton = new JButton("change color");
		
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
		
	}
	public void setupLayout()
	{
		
	}
	public void setupListeners()
	{
		
	}
}
