package it.polito.tdp.anagrammi.model;

import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		
		String parola="ciao";
		Model model=new Model();
		model.risolvi(parola);
		Set<String> anagrammi=model.risolvi(parola);
		System.out.println(anagrammi);
	}

}
