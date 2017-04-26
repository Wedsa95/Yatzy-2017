package com.jensen.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jensen.model.Dice;
import com.jensen.model.Model;

/**
 * 
 * @author Jonas
 * 
 * @version 0,01
 * 
 * @see Model , View
 */
public class View extends JFrame{
	
	private int players;
	
	private GridBagConstraints pos = new GridBagConstraints();
	private PanelCreator dicePanel; 
	private PanelCreator tablePanel;
	private PanelCreator botButtonPanel;
	private PanelCreator scoreNamePanel;
	private PanelCreator scorePanel;

	private JButton[] diceBtn = new JButton[5];

	private JButton rollBtn;
	private JButton zeroBtn;
	/*	Om vi behöver några av dom här
	* 	private JButton nextPlayerBtn = new JButton("Nästa Spelare");
	*/
	private JLabel[][] scoreLb;
	
	private JLabel[] scoreNameLb = new JLabel[19];
	private Component verticalStrut;
	
	public View(int players){
		
		System.out.println("In View");
		
		this.players = players;
		this.scoreLb = new JLabel[players][19];
		
		this.setPreferredSize(new Dimension(420+(60*players),600));
		this.setResizable(false);
		this.setTitle("Yatzy");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		dicePanel = new PanelCreator(150,300); 
		dicePanel.setBackground(Color.GREEN);
		dicePanel.getLayout();
	
		tablePanel = new PanelCreator();
		tablePanel.setBackground(Color.GREEN);
		
		tablePanel.setLayout(null);
		scoreNamePanel = new PanelCreator();
		scoreNamePanel.setBounds(6, 6, 100, 532); //ändrade till 532 från 504
		scoreNamePanel.setLayout(new GridLayout(19, 0, 0, 0)); //ändrade till 19 från 18
		scorePanel = new PanelCreator();
		scorePanel.setBounds(111, 6, (players*60), 532); //ändrade till 532 från 504
		tablePanel.add(scorePanel);
		GridBagLayout gbl_scorePanel = new GridBagLayout();

		scorePanel.setLayout(gbl_scorePanel);
		tablePanel.add(scoreNamePanel);
		
		botButtonPanel = new PanelCreator();	
		botButtonPanel.setBackground(Color.GREEN);
		FlowLayout flowLayout_1 = (FlowLayout) botButtonPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		setupBottomBtn();
		rollBtn = new JButton("Rulla Tärningarna");
		rollBtn.setFont(new Font("Arial", Font.BOLD, 14));
		zeroBtn = new JButton("Sett ut nolla");
		zeroBtn.setFont(new Font("Arial", Font.BOLD, 14));
		botButtonPanel.add(rollBtn);
		botButtonPanel.add(zeroBtn);

		getContentPane().add(dicePanel,BorderLayout.WEST);
		
		verticalStrut = Box.createVerticalStrut(250);
		dicePanel.add(verticalStrut);
		
		getContentPane().add(botButtonPanel, BorderLayout.PAGE_END);
		getContentPane().add(tablePanel, BorderLayout.CENTER);
		
		this.pack();
		
	}
	
	public JButton getRollBtn() {
		return rollBtn;
	}

	public JButton getZeroBtn() {
		return zeroBtn;
	}

	public void uppdateScore(String[][] scoreBoard){
			for(int i = 0; i<players; i++){
				for(int j = 0; j < 19; j++){ //ändrade till 19 från 18
					scoreLb[i][j] = new JLabel(scoreBoard[i][j]);
					
					scoreLb[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					scoreLb[i][j].setFont(new Font("Arial", Font.BOLD, 12));
					scoreLb[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
					
					scoreLb[i][j].setPreferredSize(new Dimension(60,28));
					scoreLb[i][j].setMaximumSize(new Dimension(60,28));
					scoreLb[i][j].setMinimumSize(new Dimension(60,28));
					
					scorePanel.add(scoreLb[i][j],gridBagPosition(i,j));
				}
			}
			
	}
	
	//yoshi*
	public void updateScore(int[][] underlyingScoreboard){
		for(int i=1; i<19; i++){
			for(int j=0; j<players; j++){
				if(!(underlyingScoreboard[i][j]==-1)){
					scoreLb[j][i].setText(String.valueOf(underlyingScoreboard[i][j]));
					//scoreLb[j][i].setForeground(Color.GREEN);
				}
				else{
					scoreLb[j][i].setText("");
				}
			}
		}
	}
	//*yoshi
	private GridBagConstraints gridBagPosition(int i, int j){
		pos.gridx = i;
		pos.gridy = j;
		return pos;
		
	}
	public void setupScoreName(String[] scoreName){
		for(int i = 0; i< 19; i++){ //ändrade till 19 från 18
			scoreNameLb[i] = new JLabel(scoreName[i]);
			scoreNameLb[i].setHorizontalAlignment(SwingConstants.CENTER);
			scoreNameLb[i].setFont(new Font("Arial", Font.BOLD, 12));
			scoreNameLb[i].setBorder(BorderFactory.createLineBorder(Color.black));
			
			scoreNamePanel.add(scoreNameLb[i]);
		}
		
	}
	public void uppdateDiceBtn(Dice[] diceArray){
		for (int i = 0;i < 5; i++){
			diceBtn[i] = new JButton("0");//tog bort String.valueOf(diceArray[i].value())); och ersatte med "0"
			dicePanel.add(diceBtn[i]);
		}
	}
	private void setupBottomBtn(){
		
	}
	//yoshi*
	public void setDiceBtn(int i, int j){
		diceBtn[i].setText(j + "");
	}
	//*yoshi
	public JButton[] getDiceBtn() {
		return diceBtn;
	}
	public int getPlayers() {
		return players;
	}
	public JLabel[][] getScoreLb() {
		return scoreLb;
	}
}
