package ua.nure.jfdi.conferenceapp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.datatype.Duration;

import ua.nure.jfdi.conferenceapp.R;
import ua.nure.jfdi.conferenceapp.entities.Notice;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class FeedFragment extends Fragment {

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	ListView listView;
	FeedAdapter adapter;

	public FeedFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_feed,
				container, false);
		listView = (ListView) rootView.findViewById(R.id.list);// stub
		List<Notice> list = new ArrayList<Notice>();// stub
		list.add(new Notice("Title1", "Text1", 641564648));// stub
		list.add(new Notice(
				"Title1",
				"Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2T"
						+ "ext2Text2Text2Text2Text2Text2Text2Text2Text2Text2Te"
						+ "xt2Text2Text2Text2Text2Text2Text2Text2Text2Text2Tex"
						+ "t2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2",
				456465546));// stub
		adapter = new FeedAdapter(inflater, list);
		listView.setAdapter(adapter);
		return rootView;
	}

	public void runTimer(final Activity activity) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						//adapter.addNotice(new Notice("Title1", "Text1",
						//		641564648));
						//adapter.notifyDataSetChanged();
						Toast.makeText(activity, "Another notice.", Toast.LENGTH_SHORT).show();;
					}
				});

			}
		}, 15000, 15000);
	}

}
