public class Rnode {

    /*
    Branching Factor (R):
    There are 24 possible lowercase letters
    8 Numbers in total
    6 Symbols
    So a branching factor of 38
    */
    private static final int R = 38;
    private boolean endOfPass;
    private char name;

    // The index goes 0-37 but each has a name correlating to a
    // letter, num, or symbol (b-z except i, 0-9, except 1 and 4, and 6 symbols
    Rnode[] next = new Rnode[R];

    Rnode() {
        endOfPass = false;
    }

    public void setEndOfPass(boolean endOfPass) {
        this.endOfPass = endOfPass;
    }

    public boolean getEndOfPass() {
        return this.endOfPass;
    }

    public Rnode[] getNext() {
        return this.next;
    }


    public int getIndexFromChar(char UTFval) {
    // Convert UTF - 8 to char array of length 38
    // UTF - 8 is backwards compatible with ASCII so I'm using
    // an ASCII table to translate

        // if it's a lowercase letter
        // Use 0-23 of index for b-z (exclude i)
        int indexVal = -1;

        if(UTFval >= 98 && UTFval < 105) {
            // If it's between b and i (exclude i)
            // Account for change in index start

            return UTFval - 98;
        }else if(UTFval > 105 && UTFval <= 122) {
            // If it's between i and z (exclude i)
            // Since we're excluding i, we have to shift it down
            // 1 more to account for that
            return UTFval - 99;
        }else if(UTFval == 0) {
            // At this point, indices 0-23 are accounted for

            // A java char is unsigned so just check upper bound

            // We're starting after letters so starting index is 24
            // UTFval is 0 so we don't need to add it
            return 24;
        }else if(UTFval > 1 && UTFval < 4) {
            // Since we're skipping 1, we move the starting index back
            // by 1. Now it's 23 instead of 24
            return UTFval + 23;
        } else if(UTFval <= 9) {
            // Since we're skipping 4, we move the starting index back by 1
            // so now it's 22
            return UTFval + 22;
        }

        // Now indices 0-31 have been taken care of
        // For the last values, we're going to manually assign them indices
        switch (UTFval) {
            case '!':
                return 32;
            case '@':
                return 33;
            case '$':
                return 34;
            case '^':
                return 35;
            case '_':
                return 36;
            case '*':
                return 37;
            default:
                System.out.println("Invalid UTFval in method getIndexFromChar");
                break;

        }
        return indexVal;
    }

}
