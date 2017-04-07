package com.jensen.main;

import com.jensen.controller.Controller;
import com.jensen.model.Model;
import com.jensen.view.View;

public class YatzyMain {

	public static void main(String[] args) {
		
		String[] names = {"jon","bon","jon","bon","jon","bon",};
		int numberOfPlayers = names.length;
		Model model = new Model(names);
		View view = new View(numberOfPlayers);
	
		Controller con = new Controller(model, view);
	}

}
