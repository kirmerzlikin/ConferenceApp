package ua.nure.jfdi.conferenceapp;

import ua.nure.jfdi.conferenceapp.model.DataAdapter;
import ua.nure.jfdi.conferenceapp.view.MainActivity;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		DataAdapter d=new DataAdapter(null);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		TextView nametext1=(TextView) findViewById(R.id.nametext);
		nametext1.setText(d.getUserName());
		//Update user name
		Button savebutton =(Button)findViewById(R.id.savebutton);
		OnClickListener oclBtnOk = new OnClickListener() {
		       @Override
		       public void onClick(View v) {
		    	TextView nametext=(TextView) findViewById(R.id.nametext);
		   		TextView snametext=(TextView) findViewById(R.id.snametext);
		   		String name = nametext.getText().toString();
		   		String sname = snametext.getText().toString();
		   		DataAdapter d=new DataAdapter(null);
		   		d.updateUserName(name, sname);
		       }
		     };		
		    
		     savebutton.setOnClickListener(oclBtnOk);
		
		Button cancelbutton=(Button) findViewById(R.id.cancelbutton);
		OnClickListener newonclick = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Settings.this.finish();				
			}
		};
		cancelbutton.setOnClickListener(newonclick);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_settings,
					container, false);
			return rootView;
		}
	}

}
