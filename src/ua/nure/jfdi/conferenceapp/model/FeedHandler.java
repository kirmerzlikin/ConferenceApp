package ua.nure.jfdi.conferenceapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ua.nure.jfdi.conferenceapp.entities.Notice;
import ua.nure.jfdi.conferenceapp.view.IUpdateFeedListener;
import android.content.Context;

public class FeedHandler {
	
	private List<IUpdateFeedListener> feedListeners;
	DataAdapter dataAdapter;
	String macAdress;
	String time;
	
	public FeedHandler(Context context){
		feedListeners = new ArrayList<IUpdateFeedListener>();
		dataAdapter = new DataAdapter(context);
		dataAdapter.setMACAdress("12:34:56:78:90");
		macAdress = dataAdapter.getMACAdress();
		time = "1";
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
					JSONParser jsonParser = new JSONParser();
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("mac", macAdress));
					params.add(new BasicNameValuePair("time", time));
					JSONObject json = jsonParser.makeHttpRequest("http://conference.it-team.in.ua/API/get_announcements", "GET",params);
					JSONArray jsonArray;
					try {
						jsonArray = json.getJSONArray("announcements");
						for(int i = 0; i < jsonArray.length(); i++){
							JSONObject json_data = jsonArray.getJSONObject(i);
							Notice notice = new Notice(json_data.getString("title"), json_data.getString("text"), json_data.getLong("date"));
							list.add(0, notice);;
							time = String.valueOf(json_data.getLong("date"));
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}					
					listener.onUpdateFeed(list);
				}
			}
		}, 0, 15000);
	}
}
