package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import server.EnigmaServer;

public class GUIFrame {
	private JFrame app = null;
	private JPanel mainHeaderPanel = null;
	private JLabel mainHeader = null;
	private JButton start = null;
	private JButton stop = null;
	private JPanel buttonPanel = null;
	private JScrollPane log = null;
	private JTextArea logTextArea = null;
	private EnigmaServer server;

	public GUIFrame(String title) {
		app = new JFrame(title);
		mainHeader = new JLabel("ENIGMA SERVER");
		mainHeaderPanel = new JPanel();
		start = new JButton("Start Server");
		stop = new JButton("Stop Server");
		buttonPanel = new JPanel();
		logTextArea = new JTextArea(10,30);
		log = new JScrollPane(logTextArea);
		try {
			server = new EnigmaServer(this);
		} catch (IOException e) {
			new ErrorDialogBox("FATAL ERROR: port 1234 is already in use",app).show();
		}
	}

	public void init() {

		// setting application GUI properties
		app.setSize(new Dimension(400, 350));
		app.setResizable(false);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setLayout(new GridBagLayout());
		app.setBackground(Color.WHITE);

		// Formatting properties of mainHeader
		mainHeader.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));

		// adding mainHeader to mainHeaderPanel
		mainHeaderPanel.add(mainHeader);

		// layout constraints for mainHeaderPanel i.e, Enigma Server Header
		GridBagConstraints appGbc = new GridBagConstraints();
		appGbc.gridx = 0;
		appGbc.gridy = 0;
		appGbc.weighty=0.10;
		appGbc.fill = GridBagConstraints.HORIZONTAL;

		// adding mainHeader to application
		app.add(mainHeaderPanel, appGbc);

		// configuring buttonPanel's layout i.e, start and stop button
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints buttonPanelGbc = new GridBagConstraints();
		buttonPanelGbc.gridx = 0;
		buttonPanelGbc.gridy = 0;
		buttonPanelGbc.weightx=0.5;
		buttonPanelGbc.fill = GridBagConstraints.HORIZONTAL;
		buttonPanel.add(start, buttonPanelGbc);
		buttonPanelGbc.gridx = 4;
		buttonPanel.add(stop, buttonPanelGbc);
		
		//disabling stop button in starting
		stop.setEnabled(false);
		
		//adding listener to start and stop buttons
		start.addActionListener(new StartServerListener(this));
		stop.addActionListener(new StopServerListener(this));

		//adding JSeparator
		appGbc.gridy=1;
		appGbc.fill = GridBagConstraints.HORIZONTAL;
		app.add(new JSeparator(),appGbc);
		
		// configuring button panel and adding it to main application GUI
		appGbc.gridx = 0;
		appGbc.gridy = 2;
		appGbc.weighty=0.20;
		appGbc.fill = GridBagConstraints.VERTICAL;
		app.add(buttonPanel, appGbc);
		
		//adding JSeparator
		appGbc.gridy=3;
		appGbc.fill = GridBagConstraints.HORIZONTAL;
		app.add(new JSeparator(),appGbc);

		// configuring log scroll pane and adding it to app
		appGbc.gridx = 0;
		appGbc.gridy = 4;
		appGbc.weighty=0.70;
		appGbc.fill = GridBagConstraints.HORIZONTAL;
		logTextArea.setEditable(false);
		app.add(log,appGbc);
	}

	public void start() {
		app.setVisible(true);
	}

	public EnigmaServer getServer() {
		return server;
	}
	
	public JButton getStartButton() {
		return start;
	}
	
	public JButton getStopButton() {
		return stop;
	}

	public void writeLog(String logMessage) {
		synchronized (logTextArea) {
			logTextArea.append(logMessage+"\n");
		}
	}
}
