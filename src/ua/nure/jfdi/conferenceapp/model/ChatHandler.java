package ua.nure.jfdi.conferenceapp.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
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
		socket = givenSocket;
		try {
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
	}

	public ChatHandler() {
		chatListeners = new ArrayList<IUpdateChatListener>();
	}

	public void addListener(IUpdateChatListener cL) {
		chatListeners.add(cL);

	}

	public void runChatThread() {
		Thread chatThread = new Thread(new Runnable(){
			@Override
			public void run(){
				Message income;
				try {
					while ((income = ((Message)reader.readObject())) != null) {
						for(IUpdateChatListener l : chatListeners){
							l.onUpdateChat(income);
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		chatThread.start();

	}

	public void sendMessage(Message m) {
		try {
			writer.writeObject(m);
			writer.flush();
		} catch (IOException e) {

		}
	}

}
