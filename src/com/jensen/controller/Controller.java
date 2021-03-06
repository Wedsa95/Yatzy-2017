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
 * This class is the controller in the MVC
 * design pattern. It Controlls the input from the 
 * user and gives the instructions to the Model, View or
 * the Correction classes. 
 * @author Jonas, Takeyoshi, Sergej, Oskar
 * 
 * @version 0.1
 * 
 * @see Model , View, Correction
 */
public class Controller implements ActionListener, MouseListener{
    private Correction corr;
    private Model model;
    private View view;
    
    public Controller(Model model, View view){
     
    	
        this.model = model;
        this.view = view;
        this.corr = new Correction(model);
        view.setUpScoreName(model.getScoreName());
        view.setUpScoreBoard(model.getScoreBoard());
        view.setUpDiceBtn(model.getDiceArray());
        addListeners();
        view.setVisible(true);
    }
    /**
     * This class takes the objects it needs in the View class and
     * add actionPerformed, mouseClicked to the objects.
     * @see mouseClicked, actionPerformed, ActionEvent 
     */
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
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == view.getRollBtn()) {
            if(model.gameComplete()){
                JOptionPane.showMessageDialog(null, "Spelet �r slut");
            }
            else{
                model.setOnePlayerRule(true);
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
                    view.getRollBtn().setText("Rulla T�rningarna " + "(" + model.getRollCounter() + ")" );
                    Correction.check(model.getRollResult());
                    view.updateScore(model.getUnderlyingScoreboard());
                    
                    for(int i=0; i<5; i++){
                        view.setDiceBtn(i, model.getRollResult()[i]); 
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "V�nligen v�lj");
                }
                
                //sets the forgroundcolor to green for every placement and turn to green
                for(int i=0; i<19; i++){
                    for(int j=0; j<model.getNumberPlayers(); j++){
                        if(model.getPlaced(i, j)){
                            view.getScoreLb()[j][i].setForeground(Color.BLUE);
                        }
                        else{
                            view.getScoreLb()[j][i].setForeground(Color.BLACK);
                        }
                    }
                }
            }
        }
        for(int i=0; i<5; i++){
            if (e.getSource() == view.getDiceBtn()[i]) {
                if(model.getDiceThrow(i)){
                    model.setDiceThrow(i, false);
                    view.getDiceBtn()[i].setBackground(new Color(66,134,244));
                }
                else{
                    model.setDiceThrow(i, true);
                    view.getDiceBtn()[i].setBackground(Color.WHITE);
                }
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i=0; i<model.getNumberPlayers(); i++){
            for(int j=1; j<18; j++){
                if(e.getSource() == view.getScoreLb()[i][j]){
                    if(j==7 || j==8){
                        //nothing happens on mouseclick on row 7 and 8, ("Summa" and "Bonus")
                    }
                    else{
                        if(model.getOnePlayerRule()){
                            if(model.gameComplete()){
                                JOptionPane.showMessageDialog(null, "Spelet �r slut");
                            }
                            if(!model.gameComplete()){
                                if(model.getTurn() == i && model.getPlaced(0, model.getTurn())){
                                    if(!model.getPlaced(j, model.getTurn())){
                                        if(model.getScore(j, model.getTurn()) == -1){
                                            int selected = JOptionPane.showConfirmDialog(null, "Vill du nolla?", "", JOptionPane.YES_NO_OPTION);
                                            if(selected == 0){
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
                                                            view.getScoreLb()[m][l].setForeground(Color.BLUE);
                                                        }
                                                        else{
                                                            view.getScoreLb()[m][l].setForeground(Color.BLACK);
                                                        }
                                                    }
                                                }
                                                if(model.getNumberPlayers()==1){
                                                    model.setOnePlayerRule(false);
                                                }
                                            }
                                            else if(selected == 1){
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
                                                        view.getScoreLb()[m][l].setForeground(Color.BLUE);
                                                    }
                                                    else{
                                                        view.getScoreLb()[m][l].setForeground(Color.BLACK);
                                                    }
                                                }
                                            }
                                            if(model.getNumberPlayers()==1){
                                                model.setOnePlayerRule(false);
                                            }
                                        }
                                    }
                                    else if(model.getPlaced(j, model.getTurn())){
                                        JOptionPane.showMessageDialog(null, "Redan vald");
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Det �r inte din tur �n");
                                }
                                if(model.gameComplete()){
                                    JOptionPane.showMessageDialog(null, model.getPlayerName(model.whoIsTheWinner()) + " Vann!");
                                }
                            }
                        }
                    }
                }
            }
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
