package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopServerListener implements ActionListener {

	private GUIFrame app = null;
	
	public StopServerListener(GUIFrame app) {
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		app.getServer().stop();
		app.getStartButton().setEnabled(true);
		app.getStopButton().setEnabled(false);
		app.writeLog("Server Stopped");
	}

}
