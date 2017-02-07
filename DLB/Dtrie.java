package DLB;

import java.lang.StringBuilder;

public class Dtrie extends Dnode {

    private Dnode root;

    // Null Constructor
    public Dtrie() {
        root = new Dnode();
    }


   /*
    * Inserts specified string as implicitly-defined path down trie
    * @param string to be inserted
    * @return void
    */

    public void insert(String s) {
        char c;                                                 // Holds individual characters read from key
        Dnode sub = new Dnode();                               //
        Dnode current = root;                                // Used to step through DLB branches, naturally starting at the root
        StringBuilder key = new StringBuilder(s);           // Holds key in a mutable format for easier processing
                                                           //
        for (int i = 0; i < key.length(); i++) {          // For every character of the specified key...
            c = key.charAt(i);                           // Get ith character.
            if(current.isEmpty()) {
                current.setData(c);
            }
            else if(current.getData() != c) {
                while(current.getPeer() != null && current.getData() != c) {
                    current = current.getPeer();
                }
                if(current.getPeer() == null) {
                    current.setPeer(new Dnode(c));
                    current = current.getPeer();
                }
            }
            if(current.getChild() == null) {
                current.setChild(new Dnode());
            }

            // Preventing against substituting numbers for letter in bad passwords
            if(current.getData() == 't'){ current.setPeer(new Dnode('7')); sub.setChild(current.getChild()); }
            else if(current.getData() == 's'){ current.setPeer(new Dnode('5')); sub.setChild(current.getChild()); }
            else if(current.getData() == 'l'){ current.setPeer(new Dnode('1')); sub.setChild(current.getChild()); }
            else if(current.getData() == 'o'){ current.setPeer(new Dnode('0')); sub.setChild(current.getChild()); }
            else if(current.getData() == 'e'){ current.setPeer(new Dnode('3')); sub.setChild(current.getChild());  }

            current = current.getChild();
        }

        current.setData('#');                // Set termination character at end of path
    }

    public boolean search(String s) {
        char c;                                          // Holds individual characters read from key
        Dnode current = root;                            // Used to step through DLB branches, naturally starting at the root
        StringBuilder key = new StringBuilder(s);      // Holds key in a mutable format for easier processing

        for (int i = 0; i < key.length(); i++) {                   // For every character of the specified key...
            c = key.charAt(i);                                    // Get ith character of key
            while (c != current.getData()) {                     // While the current node doesn't contain the same character
                current = current.getPeer();                    // Step to peer
                if (current == null) return false;             // If peer doesn't exist, neither does key
            }
            current = current.getChild();                    // Step to child
            if (current == null)          return false;     // If child doesn't exist, neither does key
            if (current.getData() == '#') return true;     // If current node contains escape character, substring found
        }
        return true;                                     // If max length has been reached, congrats you found it!
    }
}
