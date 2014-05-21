package ua.nure.jfdi.conferenceapp;

import java.util.Date;

import android.media.Image;

public class Notice {
	private String title;
	private String text;
	private Image image;
	private Date date;

	public Notice(String title, String text, Image image, long date) {
		this.image = image;
		this.title = title;
		this.text = text;
		this.date = new Date(date);
	}

	public Date getDate() {
		return date;
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
