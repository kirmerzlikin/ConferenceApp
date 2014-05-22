package ua.nure.jfdi.conferenceapp.entities;

import java.util.Date;

public class Message {

	String author;
	String text;
	Date date;
	
	public Message(String givenAuthor, String givenText, Date givenDate){
		author = givenAuthor;
		text = givenText;
		date = givenDate;				
	}
	
}
