package ua.nure.jfdi.conferenceapp.controller;

import ua.nure.jfdi.conferenceapp.entities.Message;
import ua.nure.jfdi.conferenceapp.model.ChatHandler;
import ua.nure.jfdi.conferenceapp.model.ConnectionCreator;
import ua.nure.jfdi.conferenceapp.model.FeedHandler;
import ua.nure.jfdi.conferenceapp.view.IUpdateChatListener;
import ua.nure.jfdi.conferenceapp.view.IUpdateFeedListener;

public class ConnectionController {
	
	FeedHandler fH;
	ChatHandler cH;
	
	public ConnectionController(){
		fH = new FeedHandler();
		cH = new ChatHandler();
	}
	
	public boolean setUpConnection(String macAddress, IUpdateFeedListener fL, IUpdateChatListener cL){
		ConnectionCreator creator = new ConnectionCreator();
		creator.initializeConnection(fH, cH);
		fH.addListener(fL);
		cH.addListener(cL);
		
		fH.runFeedTimer();
		cH.runChatThread();
		
		return true;
	}
	
	public void sendMessage(Message m){
		cH.sendMessage(m);
	}
	
	public void killConnection(){
		
	}

}
