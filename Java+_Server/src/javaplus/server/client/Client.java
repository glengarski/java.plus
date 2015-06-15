package javaplus.server.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import javaplus.server.main.Constants;

public class Client implements Runnable {

	private SocketChannel socket;
	private boolean running;
	private ByteBuffer buff;

	public Client(SocketChannel socket) {
		this.socket = socket;
		this.running = true;
		this.buff = ByteBuffer.allocate(Constants.BYTE_BUFFER_SIZE);
	}

	public void run() {
		while (isRunning()) {
			try {
				int readedBytes = socket.read(buff);
				if (readedBytes != 0) {
					String msg = buff.asCharBuffer().toString();
					System.out.println(msg);
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public boolean isRunning() {
		return this.running;
	}

	public String getMessage() {
		return null;
	}

}
