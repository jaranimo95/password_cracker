

public class pw_stats {

	private int chars_left;
	private int letters_amt;
	private int numbers_amt;
	private int symbols_amt;
	private double start_time;
	
	public pw_stats() {
		chars_left = 5;
		letters_amt = 0;
		numbers_amt = 0;
		symbols_amt = 0;
		start_time = System.currentTimeMillis();
	}

	public void setCharsLeft(int n) {
		chars_left = n;
		return;
	}

	public int getCharsLeft(){
		return chars_left;
	}

	public void setLetterAmt(int n) {
		letters_amt = n;
		return;
	}

	public int getLetterAmt(){
		return letters_amt;
	}

	public void setNumberAmt(int n) {
		numbers_amt = n;
		return;
	}

	public int getNumberAmt(){
		return numbers_amt;
	}

	public void setSymbolAmt(int n) {
		symbols_amt = n;
		return;
	}

	public int getSymbolAmt(){
		return symbols_amt;
	}

	public double getStartTime() {
		return start_time;
	}
}