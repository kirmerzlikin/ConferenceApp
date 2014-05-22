package ua.nure.jfdi.conferenceapp.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ua.nure.jfdi.conferenceapp.entities.Message;
import ua.nure.jfdi.conferenceapp.view.IUpdateChatListener;

public class ChatHandler {

	Socket socket;

	ObjectOutputStream writer;

	ObjectInputStream reader;

	List<IUpdateChatListener> chatListeners;

	public void setSocketConnection(Socket givenSocket) {

	}

	public ChatHandler() {
		chatListeners = new ArrayList<IUpdateChatListener>();
	}

	public void addListener(IUpdateChatListener cL) {
		chatListeners.add(cL);

	}

	public void runChatThread() {
		// TODO Auto-generated method stub

	}

	public void sendMessage(Message m) {
		try {
			writer.writeObject(m);
			writer.flush();
		} catch (IOException e) {

		}
	}

}
