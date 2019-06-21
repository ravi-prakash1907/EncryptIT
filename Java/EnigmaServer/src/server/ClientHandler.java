package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

import GUI.GUIFrame;
import enigma.Decryptor;
import enigma.Encryptor;

public class ClientHandler implements Callable<Void> {

	private Socket client = null;
	private Encryptor encryptor = null;
	private Decryptor decryptor = null;
	private GUIFrame app = null;
	public ClientHandler(Socket client,GUIFrame app) {
		this.client = client;
		this.app = app;
		encryptor = new Encryptor();
		decryptor = new Decryptor();
	}

	@Override
	public Void call() throws Exception {
		try (BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
				BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"))) {
			String recievedData = input.readLine();
			String msg = recievedData.substring(0,recievedData.indexOf(':'));
			String operation = recievedData.substring(recievedData.indexOf(':')+1);
			if(operation.equals("encrypt")) {
				msg = encryptor.encode(msg);
			} else {
				msg = decryptor.decode(msg);
			}
			output.write(msg+"\n");
			output.flush();
		} catch (IOException e) {
			app.writeLog("[Debug] unable to open streams to client "+client.getInetAddress());
		}
		return null;
	}

}
