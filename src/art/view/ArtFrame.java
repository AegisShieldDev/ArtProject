package art.view;

import art.controller.ArtController;
import art.view.ArtPanel;
import javax.swing.*;

public class ArtFrame extends JFrame
{
	private ArtController appController;
	private ArtPanel appPanel;
	
	/**
	 * creates the ChatFrame, calls setupframe
	 * @param ChatbotController appController
	 */
	public ArtFrame(ArtController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ArtPanel(appController);
		setupFrame();
	}
	
	/**
	 * Sets the settings for the chatframe
	 */
	private void setupFrame()
	{	
		this.setContentPane(appPanel);
		this.setSize(1200,700);
		this.setTitle("ARTS");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Getter for the appController
	 * @return
	 */
	public ArtController getBaseController()
	{
		return(appController);
	}
}
