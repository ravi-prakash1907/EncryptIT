package enigma;

public class Decryptor extends Machine {

	int i;

	void decodeAlter() {

		char t = this.b.charAt(0);
		this.b.deleteCharAt(0);
		this.b.append(t);

	}


	// function to decode the message
	public String decode(String inp) {

		inp = inp.toLowerCase();
		
		int initial=-1;
		char check = inp.charAt(inp.length()-1);
		for(i=0;i<10;i++)
		{
			if(check==this.d.charAt(i)) {
				check=this.c.charAt(i);
				initial = i;
				break;
			}
		}
		
		for(int i=0; i<initial;i++)
		{	decodeAlter(); }
		
		
		String temp = "";
		char real, match;
		for (int str = 0; str < inp.length(); str++) {
			real = inp.charAt(str);
			if ((Character.isLetter(real)||real=='%')||(real=='*'||real=='#')||(real=='-'||real=='4')) // Decrypting Alphabets
			{
				for (i = 0; i < 31; i++) {
					match = this.b.charAt(i);
					if (real == match) {
						temp = temp.concat(Character.toString(this.a.charAt(i)));
						this.decodeAlter();
						break;
					}
				}
			} else if ((Character.isDigit(real)&&(real!='4'))||(real=='@'||real=='$')||(real=='&'||real=='`')) // Decrypting Digits
			{
				for (i = 0; i < 13; i++) {
					match = this.d.charAt(i);
					if (real == match) {
						temp = temp.concat(Character.toString(this.c.charAt(i)));
						this.decodeAlter();
						break;
					}
				}
			} else if(real=='\n')
				temp = temp.concat(Character.toString('\n'));
			else
				temp = temp.concat(Character.toString(real));
		}

		temp = temp.substring(0, (inp.length()-1));
		return temp;
	}

}
