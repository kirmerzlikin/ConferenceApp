package ua.nure.jfdi.conferenceapp.model;

import java.net.Socket;

public class ConnectionCreator {

	Socket socket;

	private boolean getInfoByMac(String macAddress) {
		return true;
	}

	public boolean initializeConnection(String macAddress, FeedHandler fH,
			ChatHandler cH) {
		if (!getInfoByMac(macAddress))
			return false;

		return true;

	}

}
