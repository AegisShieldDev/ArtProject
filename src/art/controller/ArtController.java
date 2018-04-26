package art.controller;

import art.view.ArtFrame;
import javax.swing.*;
import java.io.IOException;

//import art.view.ProjectFrame;

public class ArtController
{	
	private ArtFrame appFrame;
	
	public ArtController()
	{
		appFrame = new ArtFrame(this);
	}
	
	public void start()
	{
	}
	
	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}
	
	public ArtFrame getFrame()
	{
		return appFrame;
	}
}
