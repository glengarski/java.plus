package javaplus.server.main;

import javaplus.server.dispatcher.Dispatcher;

public class ServerMain {

	public static void main(String args[]) {

		ChatServer server = new ChatServer(Constants.SERVER_PORT);
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.start();

		server.addDispatcher(dispatcher);
		server.start();

	}
}
