package com.rest.api.Messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.rest.api.Messanger.Model.Message;

public class FakeDatabase {

	static Map<Integer, Message> messages = new HashMap<>();

	public static Map<Integer, Message> getMessages() {
		return messages;
	}
}
