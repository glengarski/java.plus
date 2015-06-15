package javaplus.server.dispatcher;

import java.util.ArrayList;
import java.util.List;

import javaplus.server.client.Client;

public class Dispatcher extends Thread {

	private List<Client> clients;
	private int clientID;
	private boolean running;

	public Dispatcher() {
		this.clients = new ArrayList<Client>();
		this.running = true;
	}

	public void run() {
		while (isRunning()) {
			for (Client client : clients) {
				String message = client.getMessage();
			}
		}

	}

	public boolean isRunning() {
		return this.running;
	}

	public void addClient(Client client) {
		if (client != null) {
			clientID++;
			Thread t = new Thread(client, "Client-" + clientID);
			clients.add(client);
		}
	}

}
