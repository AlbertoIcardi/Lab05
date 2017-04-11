package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAnagrammi;

    @FXML
    private Button btnAnagrammi;

    @FXML
    private TextArea txtResultCorretto;

    @FXML
    private TextArea txtResultErrato;

    @FXML
    private Button btnReset;
    
    public void setModel(Model model) {
    	this.model=model;
    }

    @FXML
    void doAnagrammi(ActionEvent event) {
    	if(!txtAnagrammi.getText().matches("[a-zA-Z]+")){
			txtResultCorretto.setText("Caratteri non validi");
    		txtResultErrato.clear();
    	}	
    	else{
    		Set<String> anagrammi=new LinkedHashSet<String>();
    		anagrammi=model.risolvi(txtAnagrammi.getText());
    		for(String s:anagrammi){
    			if(model.isCorrect(s))
    				txtResultCorretto.appendText(s+"\n");
    			else
    				txtResultErrato.appendText(s+"\n");
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResultCorretto.clear();
    	txtResultErrato.clear();
    }

    @FXML
    void initialize() {
        assert txtAnagrammi != null : "fx:id=\"txtAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultCorretto != null : "fx:id=\"txtResultCorretto\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResultErrato != null : "fx:id=\"txtResultErrato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
