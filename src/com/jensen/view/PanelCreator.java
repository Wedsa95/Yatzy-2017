package com.jensen.view;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * 
 * @author Jonas
 *
 */
public class PanelCreator extends JPanel{
	
	private int heigth; 
	private int width;
	private BufferedImage img;
	
	public PanelCreator(){
	}
	public PanelCreator(int heigth,int width){
		super();
		
		this.heigth = heigth;
		this.width = width;
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, heigth));
		 
		try {
			img = ImageIO.read(new File("img/wood.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}
	//http://stackoverflow.com/questions/13791984/add-an-background-image-to-a-panel/13792503#13792503
    @Override
    public Dimension getPreferredSize() {
        return img == null ? super.getPreferredSize() : new Dimension (width, heigth);
    }

   
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight()- img.getHeight()) / 2;
            g.drawImage(img, x, y, this);
        }
    }
    
}
