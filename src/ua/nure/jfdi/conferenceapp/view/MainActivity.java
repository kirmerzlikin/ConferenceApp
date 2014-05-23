package ua.nure.jfdi.conferenceapp.view;

import java.util.Locale;

import ua.nure.jfdi.conferenceapp.R;
import ua.nure.jfdi.conferenceapp.Settings;
import ua.nure.jfdi.conferenceapp.controller.ConnectionController;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	ConnectionController controller;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	Button settingbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		WifiInfo wInfo = wifiManager.getConnectionInfo();
		String macAddress = wInfo.getMacAddress();
		
		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		
		controller = new ConnectionController(this);
		if(! controller.setUpConnection(macAddress, 
				(FeedFragment) mSectionsPagerAdapter.getItem(0),
				(ChatFragment) mSectionsPagerAdapter.getItem(1))){
			
		}
		
	settingbutton=(Button) findViewById(R.id.action_settings);
	    
	    OnClickListener oclBtnOk = new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	Intent intent = new Intent(null, Settings.class);
	            startActivity(intent);	         
	        }
	      };
	      settingbutton.setOnClickListener(oclBtnOk);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		Fragment fragmentList[];

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
			fragmentList = new Fragment[2];
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment;
			if (position == 0) {
				if (fragmentList[position] == null) {
					fragment = new FeedFragment();
					Bundle args = new Bundle();
					args.putInt(FeedFragment.ARG_SECTION_NUMBER, position + 1);
					fragment.setArguments(args);
					fragmentList[position] = fragment;
					FeedFragment temp = (FeedFragment) fragment;
					temp.setActivity(MainActivity.this);
				}
				fragment = fragmentList[position];

			} else {
				if (fragmentList[position] == null) {
					fragment = new ChatFragment();
					Bundle args = new Bundle();
					args.putInt(ChatFragment.ARG_SECTION_NUMBER, position + 1);
					fragment.setArguments(args);
					fragmentList[position] = fragment;
					ChatFragment temp = (ChatFragment) fragment;
					temp.setActivity(MainActivity.this);
				}
				fragment = fragmentList[position];
			}
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}
	}
}
