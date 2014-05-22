package ua.nure.jfdi.conferenceapp.controller;

import ua.nure.jfdi.conferenceapp.model.*;

public class ConnectionController {
	
	FeedHandler fH;
	ChatHandler cH;
	
	public ConnectionController(){
		fH = new FeedHandler();
		cH = new ChatHandler();
	}
	
	public void setUpConnection(){
		ConnectionCreator creator = new ConnectionCreator();
		creator.initializeConnection(fH, cH);
	}
	
	public void killConnection(){
		
	}

}
