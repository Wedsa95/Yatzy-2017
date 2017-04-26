package com.jensen.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.jensen.controller.Correction;
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
		//System.out.println(e);
		if (e.getSource() == view.getRollBtn()) {
			if(model.gameComplete()){
				JOptionPane.showMessageDialog(null, "Spelet är slut");
			}
			if(model.getResetDiceResult()){
				for(int k=0; k<5; k++){
					model.setDiceThrow(k, true);
					view.getDiceBtn()[k].setBackground(Color.WHITE);
				}
			}
			model.setResetDiceResult(false);
			model.continuePlaying();
			if(model.getContinuePlaying() || model.getPlacementDone()){
				model.setContinuePlaying(true);
				model.setPlacementDone(false);
				model.roll();
				model.rollCounter();
				model.whosTurn();
				view.getRollBtn().setText("Rulla Tärningarna " + "(" + model.getRollCounter() + ")" );
				
				//System.out.println(model.getPlaced(0, model.getTurn()));
				Correction.check(model.getRollResult());
				view.updateScore(model.getUnderlyingScoreboard());
				
				//System.out.println("\n\nrollCounter: " + model.getRollCounter());
				//System.out.println("turn: " + model.getTurn());
				
				for(int i=0; i<5; i++){
					view.setDiceBtn(i, model.getRollResult()[i]); 
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Vänligen välj");
			}
			
			//sets the forgroundcolor to green for every placement and turn to green
			for(int i=0; i<19; i++){
				for(int j=0; j<model.getNumberPlayers(); j++){
					if(model.getPlaced(i, j)){
						view.getScoreLb()[j][i].setForeground(Color.GREEN);
					}
					else{
						view.getScoreLb()[j][i].setForeground(Color.BLACK);
					}
				}
			}
		}
		//yoshi
		if(e.getSource() == view.getZeroBtn()){
			System.out.println("zero knapp");
		}
		
		for(int i=0; i<5; i++){
			if (e.getSource() == view.getDiceBtn()[i]) {
				//System.out.println("tärning " + (i + 1));
				if(model.getDiceThrow(i)){
					model.setDiceThrow(i, false);
					view.getDiceBtn()[i].setBackground(Color.GREEN);
				}
				else{
					model.setDiceThrow(i, true);
					view.getDiceBtn()[i].setBackground(Color.WHITE);
				}
				//System.out.println(model.getDiceThrow(i));
			}
		}
	}
	@Override
    public void mouseClicked(MouseEvent e) {
		for(int i=0; i<model.getNumberPlayers(); i++){
			for(int j=0; j<19; j++){
				if(e.getSource() == view.getScoreLb()[i][j]){
					if(model.gameComplete()){
						JOptionPane.showMessageDialog(null, "Spelet är slut");
					}
					if(!model.gameComplete()){
						if(model.getTurn() == i && model.getPlaced(0, model.getTurn())){
							if(!model.getPlaced(j, model.getTurn())){
								if(model.getScore(j, model.getTurn()) == -1){
									int selected = JOptionPane.showConfirmDialog(null, "Vill du nolla?", "hej", JOptionPane.YES_NO_OPTION);
									System.out.println(selected);
									if(selected == 0){
										System.out.println("nolla");
										model.setScore(0, j, model.getTurn());
										
										view.updateScore(model.getUnderlyingScoreboard());
										model.setPlacementDone(true);
										model.setPlacedTrue(j, i);
										model.setNextInTurn();
										model.setResetRollCounter();
										model.setResetDiceResult(true);
										
										for(int k=0; k<5; k++){
											model.setDiceThrow(k, true);
											view.getDiceBtn()[k].setBackground(Color.WHITE);
										}
										for(int l=0; l<19; l++){
											for(int m=0; m<model.getNumberPlayers(); m++){
												if(model.getPlaced(l, m)){
													view.getScoreLb()[m][l].setForeground(Color.GREEN);
												}
												else{
													view.getScoreLb()[m][l].setForeground(Color.BLACK);
												}
											}
										}
									}
								}
								else{
									view.updateScore(model.getUnderlyingScoreboard());
									model.setPlacementDone(true);
									model.setPlacedTrue(j, i);
									model.setNextInTurn();
									model.setResetRollCounter();
									model.setResetDiceResult(true);
									
									for(int k=0; k<5; k++){
										model.setDiceThrow(k, true);
										view.getDiceBtn()[k].setBackground(Color.WHITE);
									}
									for(int l=0; l<19; l++){
										for(int m=0; m<model.getNumberPlayers(); m++){
											if(model.getPlaced(l, m)){
												view.getScoreLb()[m][l].setForeground(Color.GREEN);
											}
											else{
												view.getScoreLb()[m][l].setForeground(Color.BLACK);
											}
										}
									}
								}
							}
							else if(model.getPlaced(j, model.getTurn())){
								JOptionPane.showMessageDialog(null, "Redan vald");
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Det är inte din tur än");
						}
						if(model.gameComplete()){
							JOptionPane.showMessageDialog(null, model.getPlayerName(model.whoIsTheWinner()) + " Vann!");
						}
					}
				}
			}
		}
		//System.out.println(e);
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
