package networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Encoder {
	
	private final static int DEFAULT_PORT = 1234;
	private Socket client = null;
	public Encoder(String host,int port) throws UnableToConnectToServerException {
		try {
			client = new Socket(host, port);
		} catch (IOException e) {
			throw new UnableToConnectToServerException("Unable to connect to server on "+host+":"+port); 
		}
	}
	
	public Encoder(String host) throws UnableToConnectToServerException{
		this(host,DEFAULT_PORT);
	}
	
	public String encode(String message) throws ConnectionInterruptedException {
		String response = "";
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"));
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"))){
			writer.write(message+":encrypt\n");
			writer.flush();
			response = reader.readLine();
		} catch (IOException e) {
			throw new ConnectionInterruptedException("Connection Interrupted");
		}
		return response;
	}
	
}
