package com.jensen.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jensen.model.Model;
import com.jensen.view.View;

public class Controller implements ActionListener{
	private Model model;
	private View view;
	
	public Controller(Model model, View view){
		this.model = model;
		this.view = view;
		
		
		view.setupScoreName(model.getScoreName());
		view.uppdateScore(model.getScoreBoard());
		view.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		 if (e.getSource() == e) {
			 
		 }
		 
	}
	
}
