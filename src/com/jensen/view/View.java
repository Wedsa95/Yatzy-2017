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
 * @author Jonas, Takeyoshi
 * @version 1.0
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
	/*	Om vi behöver några av dom här
	* 	private JButton nextPlayerBtn = new JButton("Nästa Spelare");
	*/
	private JLabel[][] scoreLb;
	private JLabel[] scoreNameLb = new JLabel[19];
	
	/**
	 * @param players The number och players partisipating.
	 */
	public View(int players){
		
		System.out.println("In View");
		
		this.players = players;
		this.scoreLb = new JLabel[players][19];
		
		this.setPreferredSize(new Dimension(225+(60*players),600));
		this.setResizable(false);
		this.setTitle("Yatzy");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		dicePanel = new PanelCreator(532,110); 
		dicePanel.setBackground(Color.WHITE);
	
		tablePanel = new PanelCreator(100+(players*60), 532);
		tablePanel.setBackground(Color.WHITE);
		
		tablePanel.setLayout(null);
		scoreNamePanel = new PanelCreator(100, 532);
		scoreNamePanel.setBackground(Color.WHITE);
		scoreNamePanel.setBounds(0, 0, 100, 532);
		scoreNamePanel.setLayout(new GridLayout(19, 0, 0, 0));
		scorePanel = new PanelCreator((players*60), 532);
		scorePanel.setBounds(105, 0, (players*60), 532);
		scorePanel.setBackground(Color.WHITE);
		tablePanel.add(scorePanel);
		GridBagLayout gbl_scorePanel = new GridBagLayout();

		scorePanel.setLayout(gbl_scorePanel);
		tablePanel.add(scoreNamePanel);
		
		botButtonPanel = new PanelCreator(35,225+(60*players));	
		botButtonPanel.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) botButtonPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		//Roll Button
		rollBtn = new JButton("Rulla Tärningarna");
		rollBtn.setBackground(Color.white);
		rollBtn.setFont(new Font("Arial", Font.BOLD, 14));
		botButtonPanel.add(rollBtn);

		getContentPane().add(dicePanel,BorderLayout.WEST);
		dicePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(botButtonPanel, BorderLayout.PAGE_END);
		getContentPane().add(tablePanel, BorderLayout.CENTER);
		this.pack();
	}
	/**
	 * This method draws the game board with JLabel.
	 * It gets the shape and names of the players from 
	 * the scoreBoard object in the Model class. 
	 * @param scoreBoard is a String[][] and the strings on 
	 *        [x][0] are the player names.
	 * @see Model, Controller  
	 */
	public void setUpScoreBoard(String[][] scoreBoard){
			for(int i = 0; i<players; i++){
				for(int j = 0; j < 19; j++){
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
	
	/**
	 * This method updates the visual scoreboard with the underlying scoreboard.
	 * @param underlyingScoreboard
	 * @see Model
	 */
	public void updateScore(int[][] underlyingScoreboard){
		for(int i=1; i<19; i++){
			for(int j=0; j<players; j++){
				if(!(underlyingScoreboard[i][j]==-1)){
					scoreLb[j][i].setText(String.valueOf(underlyingScoreboard[i][j]));
				}
				else{
					scoreLb[j][i].setText("");
				}
			}
		}
	}
	
	/**
	 * This method creates a GridBagConstraints for a
	 * GridBagLayout. The i and j values sets which position
	 * in a grid the pos will have.
	 * @param i is a int value that represent the column.
	 * @param j is a int value that represent the row.
	 * @return pos is a GridBagConstraints.
	 */
	private GridBagConstraints gridBagPosition(int i, int j){
		pos.gridx = i;
		pos.gridy = j;
		return pos;
	}
	/**
	 * This method draws a list of JLabels that 
	 * explains what the row on the board do.
	 * @param scoreName is a String[][], of the names 
	 * used to describe 
	 */
	public void setUpScoreName(String[] scoreName){
		for(int i = 0; i< 19; i++){ //ändrade till 19 från 18
			scoreNameLb[i] = new JLabel(scoreName[i]);
			scoreNameLb[i].setHorizontalAlignment(SwingConstants.CENTER);
			scoreNameLb[i].setFont(new Font("Arial", Font.BOLD, 14));
			scoreNameLb[i].setBorder(BorderFactory.createLineBorder(Color.black));
			
			scoreNamePanel.add(scoreNameLb[i]);
		}
		
	}
	/**
	 * This method draw a five button representations
	 * of the Dice object. 
	 * @param diceArray is a array och the object Dice.
	 */
	public void setUpDiceBtn(Dice[] diceArray){
		for (int i = 0;i < 5; i++){
			diceBtn[i] = new JButton("0");//tog bort String.valueOf(diceArray[i].value())); och ersatte med "0"
			diceBtn[i].setPreferredSize(new Dimension(100,100)); 
			diceBtn[i].setBackground(Color.white);
			diceBtn[i].setFont(new Font("Arial", Font.BOLD, 42));
			dicePanel.add(diceBtn[i]);
		}
	}
	
	/**
	 * This method assigns the dice button objects with a text.
	 * @param i is an integer value representing which button (1-5).
	 * @param j is an integer value representing the text, a dice result 1-6.
	 */
	public void setDiceBtn(int i, int j){
		diceBtn[i].setText(j + "");
	}
	
	/**
	 * This method return an array of JButton objects representing all the dice buttons.
	 * @return an array of JButton objects representing all the dice buttons.
	 */
	public JButton[] getDiceBtn() {
		return diceBtn;
	}
	
	/**
	 * This method returns an integer representing the amount of players participating.
	 * @return an integer value representing the amount of players participating.
	 */
	public int getPlayers() {
		return players;
	}
	
	/**
	 * This method returns a two dimensional array of JLabels object representing the scoreboard.
	 * @return a two dimensional array of JLabels object representing the scoreboard.
	 */
	public JLabel[][] getScoreLb() {
		return scoreLb;
	}
	
	/**
	 * This method returns JButton object that representing the roll button.
	 * @return a JButton object that representing the roll button.
	 */
	public JButton getRollBtn() {
		return rollBtn;
	}
}
