package com.jensen.view;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * This class extends JPanel. The things added to
 * the JPanel is the paintComponent method that 
 * adds a background to the panel.
 * @author Jonas
 * @see JPanel
 */
public class PanelCreator extends JPanel{
	
	private int heigth; 
	private int width;
	private BufferedImage img;
	
	/**
	 * This constructor receives a heigth and width.
	 * And sets them as the heigth and width of the panel. 
	 * @param heigth
	 * @param width
	 */
	public PanelCreator(int heigth,int width){
		super();
		
		this.heigth = heigth;
		this.width = width;
	//	this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, heigth));
		 
		try {
			img = ImageIO.read(new File("img/wood.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}
	/**
	 * This method draws the img on the panel.
	 * @see paintComponent, Graphics
	 */
	//http://stackoverflow.com/questions/13791984/add-an-background-image-to-a-panel/13792503#13792503
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
    
}
