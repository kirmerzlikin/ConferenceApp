package ua.nure.jfdi.conferenceapp;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedAdapter extends BaseAdapter {

	
	private List<Notice> data;
	private LayoutInflater inflater = null;
	
	public FeedAdapter(LayoutInflater inflater, List<Notice> data) 
	{        
        this.data=data;
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			convertView = inflater.inflate(R.layout.feed_item, null);
		
		TextView title = (TextView)convertView.findViewById(R.id.feed_item_title);  	   // title
        TextView text = (TextView)convertView.findViewById(R.id.feed_item_text); 		   // feed  item text
        ImageView thumb_image=(ImageView)convertView.findViewById(R.id.feed_item_image);   // thumb image
		
        Notice notice;
        notice = data.get(position);
        
        title.setText(notice.getTitle());
        text.setText(notice.getText());
        thumb_image.setImageResource(R.drawable.feed_image_default);
		return convertView;
	}

}
