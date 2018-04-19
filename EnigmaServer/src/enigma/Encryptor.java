package enigma;

public class Encryptor extends Machine {
	
	
	public static int rand;
	
	public static void setUniqueID() {
		int min = 1;
		int max = 6;
		rand = min + (int) (Math.random() * ((max - min) + 1));
 	}
	

	
	public static String joiner(String str, char letter_sp) {

		String srtg=String.valueOf(letter_sp);
		str+=srtg;
		return str;
		
	}
	
	int i;

	void encodeAlter() {

		this.a.reverse();
		
		char t = this.a.charAt(0);
		this.a.deleteCharAt(0);
		this.a.append(t);
		
		this.a.reverse();

	}

	public String encodeMain(String inp) {
		
		String temp = "";
		char letter, match;

		for (int str = 0; str < inp.length(); str++) {
			letter = inp.charAt(str);
			if (((Character.isLetter(letter)||letter=='#')||(letter=='*'||letter=='&'))||(letter=='@'||letter=='$')) {
				for (i = 0; i < 31; i++) {
					match = this.a.charAt(i);
					if (letter == match) {
						temp = temp.concat(Character.toString(this.b.charAt(i)));
						this.encodeAlter();
						break;
					}
				}
			} else if ((Character.isDigit(letter)||letter=='.')||(letter=='%'||letter=='-')) // Encrypting Digits
			{
				for (i = 0; i < 13; i++) {
					match = this.c.charAt(i);
					if (letter == match) {
						temp = temp.concat(Character.toString(this.d.charAt(i)));
						this.encodeAlter();
						break;
					}
				}
			} else if(letter=='\n')
				temp = temp.concat(Character.toString('\n'));
			 else
				temp = temp.concat(Character.toString(letter));
		}
		
		return temp;
		
	}
	
	// function to encode the message
	public String encode(String inp) {
		
		

		setUniqueID();
		
		inp = inp.toLowerCase( );
		char match, letter_sp='0';
		
		String string = String.valueOf(rand);
		letter_sp =string.charAt(0);
		
		for (i = 1; i <= rand; i++) {
			match = this.c.charAt(i);
			if (letter_sp == match) {
				letter_sp=this.d.charAt(i);
				break;
			}
		}
		

		for(int i=0; i<rand;i++)
		{	encodeAlter(); }
		
		
		
		
		String temp = "";
		char letter;

		for (int str = 0; str < inp.length(); str++) {
			letter = inp.charAt(str);
			if (((Character.isLetter(letter)||letter=='#')||(letter=='*'||letter=='&'))||(letter=='@'||letter=='$')) {
				for (i = 0; i < 31; i++) {
					match = this.a.charAt(i);
					if (letter == match) {
						temp = temp.concat(Character.toString(this.b.charAt(i)));
						this.encodeAlter();
						break;
					}
				}
			} else if ((Character.isDigit(letter)||letter=='.')||(letter=='%'||letter=='-')) // Encrypting Digits
			{
				for (i = 0; i < 13; i++) {
					match = this.c.charAt(i);
					if (letter == match) {
						temp = temp.concat(Character.toString(this.d.charAt(i)));
						this.encodeAlter();
						break;
					}
				}
			} else if(letter=='\n')
				temp = temp.concat(Character.toString('\n'));
			 else
				temp = temp.concat(Character.toString(letter));
		}
		
		
		return joiner(temp,letter_sp);
	}
	
}
