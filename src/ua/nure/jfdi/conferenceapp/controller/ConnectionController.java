package ua.nure.jfdi.conferenceapp.controller;

import ua.nure.jfdi.conferenceapp.model.ChatHandler;
import ua.nure.jfdi.conferenceapp.model.ConnectionCreator;
import ua.nure.jfdi.conferenceapp.model.FeedHandler;
import ua.nure.jfdi.conferenceapp.view.IUpdateChatListener;
import ua.nure.jfdi.conferenceapp.view.IUpdateFeedListener;
import android.content.Context;

public class ConnectionController {

	FeedHandler fH;
	ChatHandler cH;

	public ConnectionController(Context context) {
		fH = new FeedHandler(context);
		cH = new ChatHandler(context);
	}

	public boolean setUpConnection(String macAddress, IUpdateFeedListener fL,
			IUpdateChatListener cL) {
		ConnectionCreator creator = new ConnectionCreator();
		if (!creator.initializeConnection(macAddress, fH, cH))
			return false;

		fH.addListener(fL);
		cH.addListener(cL);

		fH.runFeedTimer();
		cH.runChatThread();

		return true;
	}

	public void sendMessage(String message) {
		cH.sendMessage(message);
	}

	public void killConnection() {

	}

}
