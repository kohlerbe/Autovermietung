package controllers;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import model.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.mvc.WebSocket;

public class AutoObserver implements Observer{
	public WebSocket.Out<JsonNode> auto;
	
	public AutoObserver(){
		Model.sharedInstance.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object autoID) {
		System.out.println("ER UPDATET in AutoObserver!");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonAutoID = null;
		try{
			jsonAutoID = mapper.readTree("{\"AutoID\":\""+autoID+"\"}");
			
		}catch (JsonProcessingException e) {
			System.out.println("Fehler bei update von Observer - JSON Exc");
			e.printStackTrace();
			} catch (IOException e) {
			System.out.println("Fehler bei update von Observer - IO Exc");
			e.printStackTrace();
			}
		
		auto.write(Model.sharedInstance.zeigeAktuelleAutos(jsonAutoID));
		
		
		
	}

}
