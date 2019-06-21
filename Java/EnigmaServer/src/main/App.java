package main;

import javax.swing.SwingUtilities;

import GUI.GUIFrame;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			GUIFrame app = new GUIFrame("Enigma Server");
			app.init();
			app.start();
		});
	}
}
