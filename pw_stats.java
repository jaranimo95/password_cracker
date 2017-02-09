

public class pw_stats {

	private int[] category;			// Will help us keep track of what category (letter, number, or symbol) or character is currently iterating through

	private int chars_left;			// Amount of characters in empty state, represented by '+' in password
	private int letters_amt;		// Amount of letters in password at any given time
	private int numbers_amt;		// Amount of numbers in password at any given time
	private int symbols_amt;		// Amount of symbols in password at any given time
	private double start_time;		// Start time of program in milliseconds
	
	public pw_stats() {
		
		category = {0,0,0,1,2};		// 0 = letter, 1 = number, 2 = symbol. We start password at bbb0!, so we initialize the array to reflect that

		 chars_left = 1;	     	// Initialized to 1 since we will constantly be editing the last character, it makes sense trust me lol
		letters_amt = 0;
		numbers_amt = 0;
		symbols_amt = 0;
		 start_time = System.currentTimeMillis();
	}

	public int getCategory(int currentIndex) {
		return category[currentIndex];
	}

	public boolean incCategory(int currentIndex) {
		category[currentIndex]++;					// Increment to next category
		if (category[currentIndex] == 3) {			// If increment past bounds
			category[currentIndex] = 0;				// Roll back to 0
			return false;
		}
		return true;;
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

				public void incLetAmt() {
					letters_amt++;
					return;
				}

				public void decLetAmt() {
					letters_amt--;
					return;
				}

				public int getLetAmt(){
					return letters_amt;
				}

	public void incNumAmt() {
		numbers_amt++;
		return;
	}

	public void decNumAmt() {
		numbers_amt--;
		return;
	}

	public int getNumAmt(){
		return numbers_amt;
	}

				public void incSymAmt() {
					symbols_amt++;
					return;
				}

				public void decSymAmt() {
					symbols_amt--;
					return;
				}

				public int getSymAmt(){
					return symbols_amt;
				}

	public double getStartTime() {
		return start_time;
	}
}