package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

/*
 * Ogni livello corrisponde all'inserimento di una lettera
 * La soluzione parziale è un insieme di caratteri
 * La soluzione parziale è completa se si è arrivati alla lunghezza della parola
 * La soluzione parziale è sempre valida
 * La soluzione completa è sempre valida
 * A Parziale(i) si aggiunge un carattere e si ottiene Parziale(i+1)
 * Per una soluzione parziale o completa utilizzo un array di caratteri
 * Per la ricorsione salvo in una LinkedList (Lista di stringhe)
 */

public class Model {
	
	Set<String> anagrammi;
	
	AnagrammaDAO aDAO;
	
	public Model(){
		aDAO=new AnagrammaDAO();
	}
	
	public Set<String> risolvi(String parola){
		anagrammi=new LinkedHashSet<String>();
		anagrammi.add(parola);
		List<Character> parolaCompleta=new LinkedList<Character>();
		//Inserisco la parola in una lista di caratteri(salvati ocme stringhe)
		for(int i=0; i<parola.length(); i++)
			parolaCompleta.add(parola.charAt(i));
		List<Character> parziale=new LinkedList<Character>();
		int livello=0;
		ricorsione(parolaCompleta, livello, parziale);
		return anagrammi;
	}
	
	public void ricorsione(List<Character> parola, int livello, List<Character> parziale){
		//A: condizione di terminazione
		if(parziale.size()==parola.size()){
			String parolaDaAggiungere="";
			for(Character s:parziale)
				parolaDaAggiungere+=s;
			anagrammi.add(parolaDaAggiungere);
			//System.out.println(parolaDaAggiungere);
			return;
		}
		for(Character s:parola){
			if(!parziale.contains(s) || (conteggio(parziale, s)<conteggio(parola,s))){
				parziale.add(s);
				ricorsione(parola, livello+1, parziale);
				parziale.remove(s);
			}
		}
	}
	
	public int conteggio(List<Character> stringa, char c){
		int occorrenza=0;
		for(Character s:stringa){
			if(s==c)
				occorrenza++;
		}
		return occorrenza;
	}
	
	public boolean isCorrect(String anagramma){
		if(aDAO.isCorrect(anagramma))
			return true;
		else
			return false;
	}

}
