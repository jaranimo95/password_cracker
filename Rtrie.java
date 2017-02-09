import java.util.Arrays;

/**
 * Created by User on 9/28/2016.
 */
public class Rtrie extends Rnode {

    /* This will be used for the symbol table
    The valid passwords out of all_passwords.txt will be tracked
    via this data structure
    */

    private Rnode root = new Rnode();

    // Constructor
    Rtrie() {
    root = new Rnode();
    }

    public boolean search(String searchString) {

        // Use a recursive helper method
        return search(root, searchString, 0);
    }

    private boolean search(Rnode searchNode, String searchString, int index) {

        if(null == searchNode) {
            // If we reach a null value then it's not there
            return false;
        }
        if(searchString.length() == index ) {
            // If we reached the end of the string, then let's find out
            // if we've reached the end in the trie as well
            return searchNode.getEndOfPass();
        }

        // Use the current char as the index for our node array
        // Our chars don't exactly match up to their ascii value
        // So use getIndexFromChar to map the char to an index 0-37
        int nodeIndex = getIndexFromChar(searchString.charAt(index));

        return search(searchNode.next[nodeIndex], searchString, index + 1);
    }
    // TODO implement crack
    public boolean crack(String answer) {
        char[] guess = new char[5];
        // Just create this since the recursive helper needs it

        // Null indicates success (super innovative)
        return (crack(root,answer,guess,0,0) == null);

    }

    private Rnode crack(Rnode node, String answer, char[] guess, int guessIndex, int nextCounter) {
        // So we have to exhaustively navigate through the Rway Trie

        // Still need to update the guess array

        // Returns guess[]

        if(guessIndex == 4) {
            // We reached the end of the guess so check if it's correct


            if (Arrays.equals(guess, answer.toCharArray())) {
                // Base case is that our guess equals the answer
                return null;
            }else{
                guessIndex = 0;
            }
        }

        // Move horizontally by incrementing nodeCounter
        // Move vertically by moving to the next node
        // So move horizontally and move vertically within each horizontal movement
        // Also move through the guess string for every vertical move

        crack(node.next[nextCounter++], answer, guess,guessIndex,nextCounter);


        return node = crack(node.next[nextCounter], answer, guess,guessIndex++,nextCounter);
    }

    public void insert(String newString) {
        insert(root, newString, 0);
    }

    private Rnode insert(RnNode newNode, String newString, int index) {
        if(null == newNode) {
            // If we don't have a node yet, make one
            newNode = new Rnode();
        }
        if(newString.length() == index) {
            // If we reached the end of the string and our
            // index matches the length, we've hit the end
            newNode.setEndOfPass(true);
        }else {
            // Use the current char as the index for our node array
            // Our chars don't exactly match up to their ascii value
            // So use getIndexFromChar to map the char to an index 0-37
            int nodeIndex = getIndexFromChar(newString.charAt(index));

            // Give this node some info
            newNode.next[nodeIndex] = insert(newNode.next[nodeIndex], newString, index + 1);
        }
        // Return a node so we can fill up our search trie with some non-null data
        return newNode;
    }
}
