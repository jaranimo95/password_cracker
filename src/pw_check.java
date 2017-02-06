import DLB.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class pw_check {

    public static void main(String[] args) throws FileNotFoundException {

        double start_time = System.currentTimeMillis();                                   // Base time used in calculating how long it takes to reach any given password during brute force enumeration
        StringBuilder password = new StringBuilder();                                     // We choose a StringBuilder for it's mutability while still retaining the functionality of a String object
        PrintWriter pringus = new PrintWriter(new File("all_passwords.txt"));   // My dude Pringus will let us write all of our password/time combos to a file! How cool of him!

        int[] char_track = {0,0,0,24,24};                                                                 // Will help us keep track of what category (letter, number, or symbol) a given character of our password belongs to. Initialized to first legal combination
        char[] alphabet = new char[]{'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l',                    // a, i , 1, and 4 are pruned due to a & i's inclusion in all_passwords.txt and 1 & 4 being valid substitutions for said characters
                                     'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                                     'w', 'x', 'y', 'z', '0', '2', '3', '5', '6', '7',
                                     '8', '9', '!', '@', '$', '_', '*', '^'};
                                                                                                          // Initialized to our password's corresponding addresses in the alphabet array (on a per character, that is)
        pringus.println(password+","+Double.toString(System.currentTimeMillis() - start_time));        // Print password,time to all_passwords.txt
       // Enumerate all possible passwords
        validPasswords(pringus,badPasswords(),alphabet,char_track,start_time,password);                   // Send through PrintWriter, DLB, Related Arrays, Start Time, and Stringbuilder objects to help conserve memory (since validPasswords is recursive)

       // ...in progress... \\

    }

    private static Dtrie badPasswords() throws FileNotFoundException {

        Scanner dictionary = new Scanner(new File("dictionary.txt"));       // Create scanner to read text out of dictionary file
        Dtrie dlb = new Dtrie();                                                      // Create trie to be populated by data from scanner output
        for(int i = 0; i < 500; i++) {                                                // Read out each line from dictionary file and insert into trie
            String s = dictionary.nextLine();
            dlb.insert(s);
        }
        return dlb;                                                                   // Return newly-populated trie
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                                         //
    //    TO DO: Work out a recursive implementation for validPasswords password enumeration, make RWAY trie   //
    //                                                                                                         //
    //          - Prune out all passwords that include any of Strings in all_passwords.txt as                  //
    //              well as their variations with numerical/symbolic substitutions.
    //          - Clean up indenting/brackets within conditional framework.
    //          - Reset char_track addresses correctly once they go out of bounds.
    //          - Trudge through insert statements
    //                                                                                                         //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void validPasswords(PrintWriter printer, Dtrie bad_passwords, char[] alphabet, int[] char_track, double start_time, StringBuilder password) throws FileNotFoundException {

        if (char_track[0] <= 23) {                               // If first character is a letter...                   ||  L----
            if (char_track[1] <= 23) {                               // If second character is a letter...              ||    LL---
                if (char_track[2] <= 23) {                               // If third character is a letter...           ||      LLL--
                    if (char_track[3] > 23 && char_track[3] <= 31) {         // If fourth character is a number...      ||        LLLN-
                        if (char_track[4] > 23 && char_track[4] <= 31)       // Iterate through next number.
                            password.insert(4, alphabet[char_track[4]++]);
                        else if (char_track[4] > 31 && char_track[4] <= 37)  // Iterate through next symbol.
                            password.insert(4, alphabet[char_track[4]++]);

                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LLLS-
                        if (char_track[4] > 23 && char_track[4] <= 31)       // Iterate through all numbers.
                            password.insert(4, alphabet[char_track[4]++]);
                        if (char_track[4] > 31 && char_track[4] <= 37)       // Iterate through all symbols.
                            password.insert(4, alphabet[char_track[4]++]);
                    }
                } else if (char_track[2] > 23 && char_track[2] <= 31) {  // If third character is a number...           ||      LLN--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LLNL-
                    } else if (char_track[3] > 23 && char_track[3] <= 31) {  // If fourth character is a number...      ||        LLNN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LLNS-
                    } else ;
                } else if (char_track[2] > 31 && char_track[2] <= 37) {  // If third character is a symbol...           ||      LLS--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LLSL-
                    } else if (char_track[3] > 23 && char_track[3] <= 31) {  // If fourth character is a number...      ||        LLSN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LLSS-
                    }
                }
            } else if (char_track[1] > 23 && char_track[1] <= 31) {  // If second character is a number...              ||    LN---
                if (char_track[2] <= 23) {                               // If third character is a letter...           ||      LNL--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LNLL-
                    } else if (char_track[3] > 23 && char_track[3] <= 31) {  // If fourth character is a number...      ||        LNLN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LNLS-
                    } else ;
                } else if (char_track[2] > 23 && char_track[2] <= 31) {  // If third character is a number...           ||      LNN--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LNNL-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LNNS-
                    }
                } else if (char_track[2] > 31 && char_track[2] <= 37) {  // If third character is a symbol...           ||      LNS--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LNSL-
                    } else if (char_track[3] > 23 && char_track[3] <= 31) {  // If fourth character is a number...      ||        LNSN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LNSS-
                    }
                }
            } else if (char_track[1] > 31 && char_track[1] <= 37) {  // If second character is a symbol...              ||    LS---
                if (char_track[2] <= 23) {                               // If third character is a letter...           ||      LSL--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LSLL-
                    } else if (char_track[3] > 23 && char_track[3] <= 31) {  // If fourth character is a number...      ||        LSLN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LSLS-
                    }
                } else if (char_track[2] > 23 && char_track[2] <= 31) {  // If third character is a number...           ||      LSN--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LSNL-
                    } else if (char_track[3] > 23 && char_track[3] <= 31) {  // If fourth character is a number...      ||        LSNN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        LSNS-
                    }
                } else if (char_track[2] > 31 && char_track[2] <= 37) {  // If third character is a symbol...           ||      LSS--
                    if (char_track[3] <= 23) {                               // If fourth character is a letter...      ||        LSSL-
                    } else if (char_track[3] > 23 && char_track[3] <= 31) {  // If fourth character is a number...      ||        LSSN-
                    }
                }
            }
        }
        else if(char_track[0] > 23 && char_track[0] <= 31) {     // If first character is a number...                   ||  N----
            if(char_track[1] <= 23) {                                // If second character is a letter...              ||    NL---
                if(char_track[2] <= 23) {                                // If third character is a letter...           ||      NLL--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NLLL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        NLLN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        NLLS-
                    } else;
                } else if(char_track[2] > 23 && char_track[2] <= 31) {   // If third character is a number...           ||      NLN--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NLNL-
                    } else if(char_track[3] > 31 && char_track[3] <= 37) {   // If fourth character is a symbol...      ||        NLNS-
                    } else;
                } else if(char_track[2] > 31 && char_track[2] <= 37) {   // If third character is a symbol...           ||      NLS--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NLSL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        NLSN-
                    } else if(char_track[3] > 31 && char_track[3] <= 37) {   // If fourth character is a symbol...      ||        NLSS-
                    }
                }
            } else if(char_track[1] > 23 && char_track[1] <= 31) {   // If second character is a number...              ||    NN---
                if(char_track[2] <= 23) {                                // If third character is a letter...           ||      NNL--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NNLL-
                    } else if(char_track[3] > 31 && char_track[3] <= 37) {   // If fourth character is a symbol...      ||        NNLS-
                    }
                } else if(char_track[2] > 31 && char_track[2] <= 37) {   // If third character is a symbol...           ||      NNS--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NNSL-
                    } else if(char_track[3] > 31 && char_track[3] <= 37) {   // If fourth character is a symbol...      ||        NNSS-
                    }
                }
            } else if(char_track[1] > 31 && char_track[1] <= 37) {   // If second character is a symbol...              ||    NS---
                if(char_track[2] <= 23) {                                // If third character is a letter...           ||      NSL--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NSLL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        NSLN-
                    } else if(char_track[3] > 31 && char_track[3] <= 37) {   // If fourth character is a symbol...      ||        NSLS-
                    }
                } else if(char_track[2] > 23 && char_track[2] <= 31) {   // If third character is a number...           ||      NSN--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NSNL-
                    } else if(char_track[3] > 31 && char_track[3] <= 37){    // If fourth character is a symbol...      ||        NSNS-
                    }
                } else if(char_track[2] > 31 && char_track[2] <= 37) {   // If third character is a symbol...           ||      NSS--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        NSSL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        NSSN-
                    }
                }
            }
        }
        else if (char_track[0] > 31 && char_track[0] <= 37){     // If first character is a symbol...                   ||  S----
            if(char_track[1] <= 23) {                                // If second character is a letter...              ||    SL---
                if(char_track[2] <= 23) {                                // If third character is a letter...           ||      SLL--
                    if(char_track[3] <= 23){                                 // If fourth character is a letter...      ||        SLLL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        SLLN-
                    } else if (char_track[3] > 31 && char_track[3] <= 37) {  // If fourth character is a symbol...      ||        SLLS-
                    }
                } else if(char_track[2] > 23 && char_track[2] <= 31) {   // If third character is a number...           ||      SLN--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        SLNL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        SLNN-
                    } else if(char_track[3] > 31 && char_track[3] <= 37) {   // If fourth character is a symbol...      ||        SLNS-
                    }
                } else if(char_track[2] > 31 && char_track[2] <= 37) {   // If third character is a symbol...           ||      SLS--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        SLSL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        SLSN-
                    }
                }
            } else if(char_track[1] > 23 && char_track[1] <= 31) {   // If second character is a number...              ||    SN---
                if(char_track[2] <= 23) {                                // If third character is a letter...           ||      SNL--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        SNLL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        SNLN-
                    } else if(char_track[3] > 31 && char_track[3] <= 37) {   // If fourth character is a symbol...      ||        SNLS-
                    }
                } else if(char_track[2] > 23 && char_track[2] <= 31) {   // If third character is a number...           ||      SNN--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        SNNL-
                    } else if(char_track[3] > 31 && char_track[3] <= 37){    // If fourth character is a symbol...      ||        SNNS-
                    }
                } else if(char_track[2] > 31 && char_track[2] <= 37) {   // If third character is a symbol...           ||      SNS--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        SNSL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        SNSN-
                    }
                }
            } else if(char_track[1] > 31 && char_track[1] <= 37) {   // If second character is a symbol...              ||    SS---
                if(char_track[2] <= 23) {                                // If third character is a letter...           ||      SSL--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        SSLL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        SSLN-
                    } else;
                } else if(char_track[2] > 23 && char_track[2] <= 31) {   // If third character is a number...           ||      SSN--
                    if(char_track[3] <= 23) {                                // If fourth character is a letter...      ||        SSNL-
                    } else if(char_track[3] > 23 && char_track[3] <= 31) {   // If fourth character is a number...      ||        SSNN-
                    }
                }
            }
        }

        // Make sure password does not contain a DLB tree path as a substring
        printer.println(password+","+Double.toString(System.currentTimeMillis() - start_time));       // Print password,time to all_passwords.txt
        validPasswords(printer,bad_passwords,alphabet,char_track,start_time,password);                   // Onto the next password!
        return;
    }
}
