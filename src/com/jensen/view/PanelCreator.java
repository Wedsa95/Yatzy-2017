package com.jensen.view;
import javax.swing.JPanel;
import java.awt.*;

public class PanelCreator extends JPanel{
	
	private int heigth; 
	private int width;
	
	public PanelCreator(){
	}
	public PanelCreator(int heigth,int width){
		super();
			
		this.heigth = heigth;
		this.width = width;
		this.setPreferredSize(new Dimension(width, heigth));
		
		
	}
	
}
