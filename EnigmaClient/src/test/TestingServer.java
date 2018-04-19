package test;

import networking.Encoder;

public class TestingServer {
	public static void main(String[] args) throws Exception {
		Encoder encoder = new Encoder("localhost");
		System.out.println(encoder.encode("aaaa"));
	}
}
