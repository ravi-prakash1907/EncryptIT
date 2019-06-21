package enigma;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Machine {

	FileReader in = null;
	FileWriter out = null;

	public int choice;
	public String code = "";
	public StringBuffer a = new StringBuffer("abcdefghijklmnopqrstuvwxyz#*&@$");//len = 31
	public StringBuffer b = new StringBuffer("%wqertyuiop*asdf-ghjkl4zxcvb#nm");//len = 31     %*#-4
	public StringBuffer c = new StringBuffer("0123456789.%-");//len = 13
	public StringBuffer d = new StringBuffer("50@239`$7&681");//len = 13

	// To creat a text file of encrypted code

	public void writeFile() throws IOException {
		try {
			out = new FileWriter("output.txt");
			out.write(this.code);
			out.close();

			System.out.println("\nText file is created!!");
		} finally {
			if (out != null)
				out.close();
		}
	}

}
