package ua.nure.jfdi.conferenceapp.view;

import java.util.List;

import ua.nure.jfdi.conferenceapp.R;
import ua.nure.jfdi.conferenceapp.entities.Notice;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedAdapter extends BaseAdapter {

	private List<Notice> data;
	private LayoutInflater inflater = null;
	

	public FeedAdapter(LayoutInflater inflater, List<Notice> data) {
		this.data = data;
		this.inflater = inflater;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = inflater.inflate(R.layout.feed_item, null);

		TextView title = (TextView) convertView
				.findViewById(R.id.feed_item_title); // title
		final TextView text = (TextView) convertView
				.findViewById(R.id.feed_item_text); // feed item text
		ImageView thumb_image = (ImageView) convertView
				.findViewById(R.id.feed_item_image); // thumb image
		final TextView textButton = (TextView) convertView
				.findViewById(R.id.feed_item_show_more); // feed item text
		textButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (text.getMaxHeight() == 40) {
					text.setMaxHeight(1000);
					textButton.setText("Hide");
				} else {
					text.setMaxHeight(40);
					textButton.setText("Show more");
				}
			}
		});

		Notice notice;
		notice = data.get(position);

		title.setText(notice.getTitle());
		text.setText(notice.getText());
		thumb_image.setImageResource(R.drawable.feed_image_default);
		return convertView;
	}

	public void addNotice(Notice notice) {
		data.add(notice);
	}	
}
