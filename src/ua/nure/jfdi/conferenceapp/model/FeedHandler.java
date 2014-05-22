package ua.nure.jfdi.conferenceapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import ua.nure.jfdi.conferenceapp.entities.Notice;
import ua.nure.jfdi.conferenceapp.view.IUpdateFeedListener;

public class FeedHandler {
	
	private List<IUpdateFeedListener> feedListeners;
	
	public FeedHandler(){
		feedListeners = new ArrayList<IUpdateFeedListener>();
	}
	
	public void addListener(IUpdateFeedListener listener){
		feedListeners.add(listener);
	}

	public void runFeedTimer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				for (IUpdateFeedListener listener : feedListeners) {
					List<Notice> list = new ArrayList<Notice>();
					listener.onUpdateFeed(list);
				}
			}
		}, 15000, 15000);
	}
}
