public class RNode {

    private boolean ending;
    private static final int r = 38; // 24 letters + 8 numbers + 6 symbols

    RNode[] next = new RNode[r]; //Indexed from 0 thru 37, corresponding to each possible character (letter, number, symbol)

    RNode() { ending = false; }

    public void setEnding(boolean ending) { this.ending = ending; }

    public boolean getEnding() { return this.ending; }

    public RNode[] getNext() {
        return this.next;
    }


    public int getIndex(char u) { // u-8 is bwards compatible to ASCII, so we'll use that I guess lol

        int indexVal = -1;  // Initialize indexVal so if all none of our conditionals evaluate to true, we know some shit is up

             if (u >= 98 && u < 105)  return u - 98;   // Since b starts at 98 in ASCII, we'll subtract that to get our corresponding UTI-8 value
        else if (u > 105 && u <= 122) return u - 99;   // If between i and z, we need to shift down since we are excluding i
        else if (u == 0)              return 24;       // UTI-8 Indices 0 thru 23 are dealt with above. Chars are unsigned so check upper bound. Index is 24 since we're starting after letters
        else if (u > 1 && u < 4)      return u + 23;   // We gotta move the starting index back by 1 since we're skipping one.
        else if (u <= 9)              return u + 22;   // We're skipping 4 so we gotta move the starting index back by one, so now it's 22.

        switch (u) {                                   // Now we just assigned indices manually
            case '!': return 32;
            case '@': return 33;
            case '$': return 34;
            case '^': return 35;
            case '_': return 36;
            case '*': return 37;
             default: 
                    System.out.println("ERROR - invalid u value");
                    break;

        }
        return indexVal;    // Return the index
    }

}
