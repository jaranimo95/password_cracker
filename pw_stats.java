

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

	public void incCharsLeft() {
		chars_left++;
		return;
	}

	public void decCharsLeft() {
		chars_left--;
		return;
	}

	public int getCharsLeft(){
		return chars_left;
	}

				public void incLetterAmt() {
					letters_amt++;
					return;
				}

				public void decLetterAmt() {
					letters_amt--;
					return;
				}

				public int getLetterAmt(){
					return letters_amt;
				}

	public void incNumberAmt() {
		numbers_amt++;
		return;
	}

	public void decNumberAmt() {
		numbers_amt--;
		return;
	}

	public int getNumberAmt(){
		return numbers_amt;
	}

				public void incSymbolAmt() {
					symbols_amt++;
					return;
				}

				public void decSymbolAmt() {
					symbols_amt--;
					return;
				}

				public int getSymbolAmt(){
					return symbols_amt;
				}

	public double getStartTime() {
		return start_time;
	}
}