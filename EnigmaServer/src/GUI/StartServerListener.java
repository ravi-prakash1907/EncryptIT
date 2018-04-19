package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartServerListener implements ActionListener {

	private GUIFrame app=null;
	public StartServerListener(GUIFrame app) {
		this.app=app;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		new Thread(app.getServer()).start();
		app.writeLog("Server started on port 1234");
		app.getStartButton().setEnabled(false);
		app.getStopButton().setEnabled(true);
	}

}
