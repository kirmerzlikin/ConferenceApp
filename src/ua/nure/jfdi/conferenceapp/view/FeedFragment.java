package ua.nure.jfdi.conferenceapp.view;

import java.util.ArrayList;
import java.util.List;

import ua.nure.jfdi.conferenceapp.R;
import ua.nure.jfdi.conferenceapp.entities.Notice;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FeedFragment extends Fragment {

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public FeedFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.fragment_feed,
				container, false);
		ListView listView = (ListView) rootView.findViewById(R.id.list);// stub
		List<Notice> list = new ArrayList<Notice>();// stub
		list.add(new Notice("Title1", "Text1", 641564648));// stub
		list.add(new Notice(
				"Title1",
				"Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2T"
						+ "ext2Text2Text2Text2Text2Text2Text2Text2Text2Text2Te"
						+ "xt2Text2Text2Text2Text2Text2Text2Text2Text2Text2Tex"
						+ "t2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2Text2",
				456465546));// stub
		FeedAdapter adapter = new FeedAdapter(inflater, list);
		listView.setAdapter(adapter);
		return rootView;
	}

}
