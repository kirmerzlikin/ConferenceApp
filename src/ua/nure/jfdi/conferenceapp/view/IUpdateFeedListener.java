package ua.nure.jfdi.conferenceapp.view;

import java.util.List;

import ua.nure.jfdi.conferenceapp.entities.Notice;

public interface IUpdateFeedListener {

	public void onUpdateFeed(List<Notice> list);
}
