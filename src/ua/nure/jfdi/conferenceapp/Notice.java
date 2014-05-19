package ua.nure.jfdi.conferenceapp;

import android.media.Image;

public class Notice {
	private String title;
	private String text;
	private Image image;

	public Notice(String title, String text, Image image) {
		this.image = image;
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public Image getImage() {
		return image;
	}

}
