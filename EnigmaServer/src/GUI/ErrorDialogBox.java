package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorDialogBox {
	private JLabel label = null;
	private JPanel labelPanel = null;
	private JDialog errorDialog = null;
	private JButton Ok = null;
	private JPanel buttonPanel = null;

	public ErrorDialogBox(String message,JFrame app) {
		errorDialog = new JDialog(app);
		label = new JLabel(message);
		labelPanel = new JPanel();
		Ok = new JButton("OK");
		buttonPanel = new JPanel();
	}

	public void show() {
		labelPanel.add(label);
		label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
		label.setForeground(Color.BLACK);
		errorDialog.setSize(new Dimension(500, 150));
		errorDialog.setLayout(new GridLayout(2, 1));
		errorDialog.add(labelPanel);
		Ok.addActionListener((ae)->{
			errorDialog.setVisible(false);
			System.exit(0);
		});
		errorDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(-1);
			}
		});
		buttonPanel.add(Ok);
		errorDialog.add(buttonPanel);
		errorDialog.setVisible(true);
	}
}
