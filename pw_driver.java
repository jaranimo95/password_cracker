import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.io.PrintWriter;
import java.util.Stack;

public class pw_driver {

    private static PrintWriter printer;

	public static void main(String args[]) throws FileNotFoundException {

		StringBuilder password = new StringBuilder();                           // We choose a StringBuilder for it's mutability while still retaining the functionality of a String object
        printer = new PrintWriter(new File("all_passwords.txt"));   // My dude Pringus will let us write all of our password/time combos to a file! How cool of him!

        Stack<pw_stats> stack = new Stack<pw_stats>();
        char[] alphabet = new char[] {'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l',                    // a, i , 1, and 4 are pruned due to a & i's inclusion in all_passwords.txt and 1 & 4 being valid substitutions for said characters
                                      'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                                      'w', 'x', 'y', 'z', '0', '2', '3', '5', '6', '7',
                                      '8', '9', '!', '@', '$', '_', '*', '^'};

       passwordSetup(stack,alphabet,password);

	}

    private static void passwordSetup(Stack<pw_stats> stack, char[] alphabet, StringBuilder password) {
        pw_stats stats = new pw_stats();
        
       // Initialize to first possible combination 
        password.insert(0,alphabet[0]);
        password.insert(1,alphabet[0]);
        password.insert(2,alphabet[0]);
        password.insert(3,alphabet[24]);
        password.insert(4,alphabet[31]);
        
       // Initialize password content trackers to correspond with first possible combination 
        stats.setLetterAmt(3);
        stats.setNumberAmt(1);
        stats.setSymbolAmt(1);
        stats.setCharsLeft(0);
        
        stack.push(stats);                          // Push password stats onto stack
        validPasswords(stack,alphabet,password);    // Call password enumeration method
    }    

    private static void validPasswords(Stack<pw_stats> stack, char[] alphabet, StringBuilder password) {

       pw_stack stats = stack.pop();

        if(stats.getCharsLeft() == 0) {
            if(){

            }
            else if(
        }
        return;
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean isSymbol(char c) {
        return (c >= '!' && c <= '/');
    }
}