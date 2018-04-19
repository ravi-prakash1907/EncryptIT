package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import GUI.GUIFrame;

public class EnigmaServer implements Runnable {

	private ServerSocket server = null;
	private static final int DEFAULT_PORT = 1234;
	private static final int DEFAULT_NO_OF_CONNECTIONS = 500;
	private ExecutorService executor = null;
	private boolean shouldRun = true;
	private GUIFrame app = null;

	public EnigmaServer(int serverPort, int maxConnections,GUIFrame app) throws IOException {
		server = new ServerSocket(serverPort);
		executor = Executors.newFixedThreadPool(maxConnections);
		this.app = app;
	}

	public EnigmaServer(int port,GUIFrame app) throws IOException {
		this(port, EnigmaServer.DEFAULT_NO_OF_CONNECTIONS,app);
	}

	public EnigmaServer(GUIFrame app) throws IOException {
		this(EnigmaServer.DEFAULT_PORT, EnigmaServer.DEFAULT_NO_OF_CONNECTIONS,app);
	}

	@Override
	public void run() {
		while (shouldRun) {
			try {
				Socket client = server.accept();
				executor.submit(new ClientHandler(client,app));
			} catch (IOException e) {
				app.writeLog("[ERROR] Unable to open connection");
			}
		}
		executor.shutdown();
	}
	
	public void stop() {
		this.shouldRun=false;
	}
}