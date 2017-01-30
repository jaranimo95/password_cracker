import DLB.Trie;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class crack {

    public static void main(String[] args) throws FileNotFoundException {
        Dtrie t = badPasswords();                                               // Populate a DLB trie with all illegal passwords from dictionary.txt
        validPasswords(t);                                                      // Enumerate all possible passwords
    }

    private static Trie badPasswords() throws FileNotFoundException {
        Scanner d = new Scanner(new File("dictionary.txt"));                    // Create scanner to read text out of dictionary file
        Dtrie t = new Dtrie();                                                  // Create trie to be populated by data from scanner output

        for(int i = 0; i < 500; i++) {                                          // Read out each line from dictionary file and insert into trie
            String s = d.nextLine();
            t.insert(s);
        }
        return t;                                                               // Return newly-populated trie
    }


    // TO DO: Work out a recursive implementation for validPasswords password enumeration
    //
    //          - Prune out all passwords that include any of Strings in all_passwords.txt as
    //              well as their variations with numerical/symbolic substitutions.
    //          - Might be worthwhile to look into a solution implementing dynamic programming
    //              or memoization. I've heard it's a lot easier / better than recursion.

    private static void validPasswords(Trie t) throws FileNotFoundException {

        double time;
        StringBuilder password = new StringBuilder();
        PrintWriter pw = new PrintWriter(new File("all_passwords.txt"));

        // a, i , 1, and 4 are pruned out due to a & i's inclusion in all_passwords.txt and 1 & 4 being valid substitutions for said characters
        char[] alphabet = new char[]{'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l','m', 'n', 'o',
                'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z', '0', '2',
                '3', '5', '6', '7','8', '9', '!', '@', '$', '_', '*', '^'};



    }
}
