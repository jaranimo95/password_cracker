package DLB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Christian on 2/6/2017.
 */
public class TrieDriver {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner dictionary = new Scanner(new File("dictionary.txt"));       // Create scanner to read text out of dictionary file
        Dtrie dlb = new Dtrie();                                            // Create trie to be populated by data from scanner output
        for(int i = 0; i < 500; i++) {                                      // Read out each line from dictionary file and insert into trie
            String s = dictionary.nextLine();
            dlb.insert(s);
            if(dlb.search(s)) System.out.println(s+" found!");
        }
    }
}
