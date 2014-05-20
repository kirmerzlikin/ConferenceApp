package ua.nure.jfdi.conferenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class DataAdapter {

	private SharedPreferences sharedPreferences;
	private final String NAME = "name";
	private final String SURNAME = "surname";
	private final String MAC = "mac";

	public DataAdapter(Context context) {
		sharedPreferences = context.getSharedPreferences("Account",
				Context.MODE_PRIVATE);
	}

	public void setUserName(String name, String surname) {
		Editor editor = sharedPreferences.edit();
		editor.putString(NAME, name);
		editor.putString(SURNAME, surname);
		editor.commit();
	}

	public void setMACAdress(String mac) {
		Editor editor = sharedPreferences.edit();
		editor.putString(MAC, mac);
		editor.commit();
	}

	public void updateUserName(String name, String surname) {
		setUserName(name, surname);
	}

	public String getMACAdress() {
		String mac = sharedPreferences.getString(MAC, "");
		return mac;
	}

	public String getUserName() {
		String name = sharedPreferences.getString(NAME, "");
		return name;
	}

	public String getUserSurname() {
		String surname = sharedPreferences.getString(SURNAME, "");
		return surname;
	}

}
