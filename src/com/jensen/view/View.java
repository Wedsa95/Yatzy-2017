package com.jensen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import java.awt.ComponentOrientation;
import java.awt.Window.Type;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;

public class View extends JFrame{
	
	private int players;
	
	private PanelCreator dicePanel; 
	private PanelCreator tablePanel;
	private PanelCreator botButtonPanel;
	private PanelCreator partOne;
	private PanelCreator partTwo;

	private JButton[] diceBtn = new JButton[5];
	private JButton rollBtn;
	private JButton zeroBtn;
	
	private JLabel[][] scoreLb;
	private JLabel[] scoreNameLb;
	
	public View(){
		
		players = 6;
		this.setPreferredSize(new Dimension(800,600));
		setResizable(false);
		System.out.println("In View");
		this.setTitle("Yatzy");
		getContentPane().setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		dicePanel = new PanelCreator(150,400);
		
		
			for (int i = 0;i < 5; i++){
				diceBtn[i] = new JButton("1");
				dicePanel.add(diceBtn[i]);
			}
	
		tablePanel = new PanelCreator(500,300);
		scoreNameLb = new JLabel[19];
		
		//autogenererat av com.jgoodies.forms.layout
		tablePanel.setLayout(new FormLayout(new ColumnSpec[] {FormFactory.RELATED_GAP_COLSPEC,
		ColumnSpec.decode("100px"),FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
		ColumnSpec.decode("270px"),},new RowSpec[] {FormFactory.RELATED_GAP_ROWSPEC,RowSpec.decode("500px"),}));
		
		partOne = new PanelCreator(150,300);
		
		tablePanel.add(partOne, "2, 2, fill, fill");
		partOne.setLayout(new GridLayout(19, 1, 0, 0));
		
		
		partTwo = new PanelCreator(350,300);
		tablePanel.add(partTwo, "4, 2, fill, fill");
		partTwo.setLayout(new GridLayout(19, 6, 0, 0));
		
		for(int i = 0; i< 19; i++){
			scoreNameLb[i] = new JLabel("Hejsan");
			scoreNameLb[i].setHorizontalAlignment(SwingConstants.CENTER);
			scoreNameLb[i].setFont(new Font("Arial", Font.BOLD, 10));
			scoreNameLb[i].setBorder(BorderFactory.createLineBorder(Color.black));
			partOne.add(scoreNameLb[i]);
		}
		
		scoreLb = new JLabel[players][19];
		for(int i = 0; i<players; i++){
			for(int j = 0; j < 19; j++){
				scoreLb[i][j] = new JLabel("   ");
				scoreLb[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				scoreLb[i][j].setFont(new Font("Arial", Font.BOLD, 10));
				scoreLb[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				partTwo.add(scoreLb[i][j]);
			}
		}
		
		botButtonPanel = new PanelCreator(50,100);
		
		rollBtn = new JButton("Roll");
		zeroBtn = new JButton("0");
		botButtonPanel.add(rollBtn);
		botButtonPanel.add(zeroBtn);

		getContentPane().add(dicePanel,BorderLayout.WEST);
		
		getContentPane().add(botButtonPanel, BorderLayout.PAGE_END);
		getContentPane().add(tablePanel, BorderLayout.CENTER);
		
		this.pack();
	}
}
