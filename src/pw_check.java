import DLB.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class pw_check {

    public static void main(String[] args) throws FileNotFoundException {

        Dtrie badPasswords = badPasswords();                                              // Populate a DLB trie with all illegal passwords from dictionary.txt

        double start_time = System.currentTimeMillis();                                   // Base time used in calculating how long it takes to reach any given password during brute force enumeration
        StringBuilder password = new StringBuilder();                                     // We choose a StringBuilder for it's mutability while still retaining the functionality of a String object
        PrintWriter pringus = new PrintWriter(new File("all_passwords.txt"));   // My dude Pringus will let us write all of our password/time combos to a file! How cool of him!

       // a, i , 1, and 4 are pruned due to a & i's inclusion in all_passwords.txt and 1 & 4 being valid substitutions for said characters
        char[] alphabet = new char[]{'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l',
                                     'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                                     'w', 'x', 'y', 'z', '0', '2', '3', '5', '6', '7',
                                     '8', '9', '!', '@', '$', '_', '*', '^'};

        password.append(new char[] {'b','b','b','0','0'});                                                // Set password to first possible legal combination of characters
        int[] char_track = {0,0,0,24,24};                                                                 // Will help us keep track of what category (letter, number, or symbol) a given character of our password belongs to
                                                                                                          // Initialized to our password's corresponding addresses in the alphabet array (on a per character, that is)
        pringus.println(password+","+Double.toString(System.currentTimeMillis() - start_time));        // Print password,time to all_passwords.txt
       // Enumerate all possible passwords
        validPasswords(pringus,alphabet,char_track,start_time,password);

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
    //              well as their variations with numerical/symbolic substitutions.                            //
    //                                                                                                         //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void validPasswords(PrintWriter printer, char[] alphabet, int[] char_track, double start_time, StringBuilder password) throws FileNotFoundException {

        if(char_track[0] <= 23){                                                                          // If first character is a letter...                   ||  L----
            if(char_track[1] <= 23) {                                                                         // If second character is a letter...              ||  LL---
                if(char_track[2] <= 23) {                                                                         // If third character is a letter...           ||  LLL--
                    if(char_track[3] > 23 && char_track[3] <= 31) {                                                   // If fourth character is a number...      ||  LLLN-

                    }
                    else if (char_track[3] > 31 && char_track[3] <= 37) {                                             // Else if fourth character is a symbol... ||  LLLS-

                    } else {                                                                                          // Else your ass is oob.
                        //return;
                    }
                }
            }
            else if(char_track[1] > 23 && char_track[1] <= 31) {                                              // If second character is a number...              ||  LN---
                if(char_track[2] <= 23) {                                                                         // If third character is a letter...           ||  LNL--
                    if(char_track[3] <= 23) {                                                                         // If fourth character is a letter...           ||  LNLL-

                    }
                    else if(char_track[3] > 31 && char_track[3] <= 37) {                                              // If fourth character is a symbol...           ||  LNLS-

                    } else {

                    }
                }
                else if(char_track[2] > 23 && char_track[2] <= 31) {                                              // If third character is a number...           ||  LNN--

                }
                else if(char_track[2] > 31 && char_track[2] <= 37) {                                              // If third character is a symbol...           ||  LNS--

                } else {

                }
            }
            else if(char_track[1] > 31 && char_track[1] <= 37) {                                              // If second character is a symbol...              ||  LS---

            } else {

            }
        }
        else if (char_track[0] > 23 && char_track[0] <= 31) {                                             // Else if first character is a number...              ||  N----

        }
        else if (char_track[0] > 31 && char_track[0] <= 37){                                              // Else first character is a symbol...                 ||  S----

        } else {                                                                                          // Else your ass is oob

        }

        printer.println(password+","+Double.toString(System.currentTimeMillis() - start_time));       // Print password,time to all_passwords.txt
        validPasswords(printer,alphabet,char_track,start_time,password);                                  // Onto the next password!
        return;
    }
}`
