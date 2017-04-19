package com.jensen.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.jensen.model.Model;
import com.jensen.view.View;
/**
 * 
 * @author Jonas
 * 
 * @version 0,01
 * 
 * @see Model , View
 */
public class Controller implements ActionListener, MouseListener{
	private Model model;
	private View view;
	
	public Controller(Model model, View view){
		
		
		this.model = model;
		this.view = view;
		Correction corr = new Correction(model);
		
		view.setupScoreName(model.getScoreName());
		view.uppdateScore(model.getScoreBoard());
		view.uppdateDiceBtn(model.getDiceArray());
		addListeners();
		view.setVisible(true);
		
	}
	public void addListeners(){
		for (int i = 0; i < view.getPlayers(); i++){
	        for(int j = 0; j < 18; j++){
	        	view.getScoreLb()[i][j].addMouseListener(this);
	        }
		}
		
		for(int i = 0; i < view.getDiceBtn().length; i++){
			view.getDiceBtn()[i].addActionListener(this);
		}
		
		view.getRollBtn().addActionListener(this);
		view.getZeroBtn().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(e);
		if (e.getSource() == view.getRollBtn()) {
			model.rollCounter();
			Correction.check(model.rollDice());
			System.out.println("\n\nrollCounter: " + model.getRollCounter());
			System.out.println("turn: " + model.getTurn());
		}
	}
	@Override
    public void mouseClicked(MouseEvent e) {
		System.out.println(e);
		if (e.getSource() == view.getRollBtn()) {
			
		}
    }
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
