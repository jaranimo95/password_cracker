import DLB.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class crack {

    public static void main(String[] args) throws FileNotFoundException {
        Dtrie t = badPasswords();                                               // Populate a DLB trie with all illegal passwords from dictionary.txt
        StringBuilder password = new StringBuilder();
        PrintWriter pringus = new PrintWriter(new File("all_passwords.txt"));   // My dude Pringus will let us write all of our password/time combos to a file! How cool of him!

       // a, i , 1, and 4 are pruned due to a & i's inclusion in all_passwords.txt and 1 & 4 being valid substitutions for said characters
        char[] alphabet = new char[]{'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l','m', 'n', 'o',
                                     'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z', '0', '2',
                                     '3', '5', '6', '7','8', '9', '!', '@', '$', '_', '*', '^'};
        char[] pw = new char[5];     // Used to store characters of the passwords being enumerated

       // Enumerate all possible passwords
        validPasswords(pringus, alphabet, pw);

    }

    private static Dtrie badPasswords() throws FileNotFoundException {
        Scanner dictionary = new Scanner(new File("dictionary.txt"));           // Create scanner to read text out of dictionary file
        Dtrie dlb = new Dtrie();                                                // Create trie to be populated by data from scanner output
        for(int i = 0; i < 500; i++) {                                          // Read out each line from dictionary file and insert into trie
            String s = dictionary.nextLine();
            dlb.insert(s);
        }
        return dlb;                                                               // Return newly-populated trie
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                                         //
    //    TO DO: Work out a recursive implementation for validPasswords password enumeration, make RWAY trie   //
    //                                                                                                         //
    //          - Prune out all passwords that include any of Strings in all_passwords.txt as                  //
    //              well as their variations with numerical/symbolic substitutions.                            //
    //                                                                                                         //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
///
    private static void validPasswords(PrintWriter pringus, char[] alphabet, char[] pw) throws FileNotFoundException {



    }
}
