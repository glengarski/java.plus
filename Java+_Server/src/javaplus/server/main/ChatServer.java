package javaplus.server.main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

import javaplus.server.dispatcher.Dispatcher;

public class ChatServer extends Thread {

	private Dispatcher dispatccher;
	private int port;
	private ServerSocketChannel ssc;
	private Selector selector;
	private boolean running;

	public ChatServer(int port) {
		this.port = port;
		initChatServer();
		this.running = true;
		System.out.println("Server starting on port " + this.port);
	}

	private void initChatServer() {
		try {
			this.ssc = ServerSocketChannel.open();
			this.ssc.socket().bind(new InetSocketAddress(port));
			this.ssc.configureBlocking(false);
			this.selector = Selector.open();
			this.ssc.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void addDispatcher(Dispatcher dispatcher) {
		this.dispatccher = dispatcher;
	}

	@Override
	public void run() {
		while (isRunning()) {

		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
