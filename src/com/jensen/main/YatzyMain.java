package com.jensen.main;

import com.jensen.controller.Controller;
import com.jensen.model.Model;
import com.jensen.view.View;

public class YatzyMain {

	public static void main(String[] args) {
	
		Model model = new Model();
		View view = new View();
	
		Controller con = new Controller(model, view);
	}

}
