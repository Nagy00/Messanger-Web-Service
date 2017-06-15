package com.rest.api.Messanger.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rest.api.Messanger.Model.Message;
import com.rest.api.Messanger.database.FakeDatabase;

public class MessageService {

	FakeDatabase obj = new FakeDatabase();
	Map<Integer, Message> messages = FakeDatabase.getMessages();

	public MessageService() {
		messages.put(1, new Message(1, "Mohamed", new Date(), "REST API"));
		messages.put(2, new Message(2, "Nagy", new Date(), "REST API"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message getMessage(int id) {
		if (messages.get(id) != null) {
			return messages.get(id);
		}
		return null;
	}

	public Message updateMessage(Message message) {
		if (messages.get(message.getId()) != null) {
			messages.put(message.getId(), message);
			return message;
		}
		return null;
	}

	public void removeMessage(int id) {
		messages.remove(id);
	}

	public List<Message> getAllMessagesPaginated(int start,int size){
		List<Message> paginatedMessages = new ArrayList<>(messages.values());		
		return paginatedMessages.subList(start,start+size);
	}
	
	public List<Message> getAllMessagesFromYear(int year){
		List<Message> messagesForYear = new ArrayList<>(messages.values());		
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

}
