package ua.nure.jfdi.conferenceapp.model;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionCreator {

	private boolean getInfoByMac(String macAddress) {
		// запрос здесь
		return true;
	}

	public boolean initializeConnection(String macAddress, FeedHandler fH,
			final ChatHandler cH) {
		if (!getInfoByMac(macAddress))
			return false;

		Thread connectionThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Socket socket = new Socket("10.0.2.2", 50000);
					cH.setSocketConnection(socket);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			}
		});

		connectionThread.start();

		try {
			connectionThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}

		return true;

	}

}
