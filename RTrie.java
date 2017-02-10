import java.util.Arrays;

public class RTrie extends RNode {

    private RNode root = new RNode();

    RTrie() {   // Null Constructor
        root = new RNode();
    }

    public boolean search(String s) {
        return searchSetup(root, s, 0);       // Call setup method
    }

    private boolean searchSetup(RNode root, String s, int index) {

        if(null == root) return false;                      // If root does not exist, return false
        if(s.length() == index) return n.getEndOfPass();    // If length of string has been traversed, check if end of branch has been reaced as well

        int nodeIndex = getIndexFromChar(s.charAt(index));  

        return search(n.next[nodeIndex], s, index + 1);
    }

    public boolean crack(String answer) {
        char[] guess = new char[5];                  // Used for recursive method

        return crack(root,answer,guess,0,0) == null; // If null, method ended successfully

    }

    private RNode crack(RNode node, String answer, char[] guess, int guessIndex, int nextCounter) {

        if(guessIndex == 4) {
            
            // End of guess reached, check if guess is correct

            if (Arrays.equals(guess, answer.toCharArray())) {     // If guess equals value found
                return null;                                      // Return indication of success
            } else{
                guessIndex = 0;
            }
        }

        crack(node.next[nextCounter++], answer, guess,guessIndex,nextCounter);  // Horizontal trie movement achieved by incrementing nodeCounter, vertical movement by moving to next node

        return node = crack(node.next[nextCounter], answer, guess,guessIndex++,nextCounter);
    }

    public void insert(String newString) {
        insert(root, newString, 0);
    }

    private RNode insert(RnNode newNode, String newString, int index) {
        if(null == newNode) {
           
            newNode = new RNode();  // If no node exists, make one
        }
        if(newString.length() == index) newNode.setEndOfPass(true);    // If end of string has been reached and index == length, end has been reached
        else {
            int nodeIndex = getIndexFromChar(newString.charAt(index));         // Use current char as index for our node array, use getIndexFromChar to map the char to an index from 0 thru 37

            newNode.next[nodeIndex] = insert(newNode.next[nodeIndex], newString, index + 1);    // Populate node with data
        }
        return newNode;
    }
}
