package ua.nure.jfdi.conferenceapp.view;

import java.util.ArrayList;
import java.util.List;

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

public class FeedFragment extends Fragment implements IUpdateFeedListener {

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	Activity activity;
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
		adapter = new FeedAdapter(inflater, list);
		listView.setAdapter(adapter);
		return rootView;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void onUpdateFeed(final List<Notice> list) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				adapter.addListNotice(list);
				adapter.notifyDataSetChanged();
				if (!list.isEmpty()) {
					Toast.makeText(activity, "New notice.", Toast.LENGTH_SHORT)
							.show();
				}
			}
		});
	}

}
