import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.Set;

public class pw_driver {

    private static PrintWriter printer;

	public static void main(String args[]) throws FileNotFoundException {

        Stack<pw_stats> stack = new Stack<pw_stats>();                  // Stack will hold password data between calls
	    StringBuilder password = new StringBuilder();                   // We choose a StringBuilder for it's mutability while still retaining the functionality of a String object
        printer = new PrintWriter(new File("all_passwords.txt"));       // My dude Pringus will let us write all of our password/time combos to a file! How cool of him!

        passwordSetup(stack,alphabet,password);
	}

    private static void passwordSetup(Stack<pw_stats> stack, char[] alphabet, StringBuilder password) {
        pw_stats stats = new pw_stats();
        
       // Initialize to first possible combination of characters (Letter, Letter, Letter, Number, Symbol [LLLNS])
        password.insert(0,'b');
        password.insert(1,'b');
        password.insert(2,'b');
        password.insert(3,'0');
        password.insert(4,'!');
        
       // Initialize password content trackers to correspond with first possible combination (LLLNS)
        stats.setLetterAmt(3);
        stats.setNumberAmt(1);
        stats.setSymbolAmt(1);
        stats.setCharsLeft(0);
        
        stack.push(stats);                          // Push password stats onto stack
        validPasswords(stack,password);             // Call password enumeration method
    }    

    private static void validPasswords(Stack<pw_stats> stack, StringBuilder password) {

        pw_stack stats = stack.pop();
        if (stats.getCharsLeft() == 0) {
            
        }
        return;
    }

    private static boolean isLetter(char c) {
        return (c >= 'b' && c <= 'z');
    }

    private static char nextLetter(char c) {
        if (c >= 'b' && c < 'z') {              // Won't contain 'a' since it is pruned out
            c++;
            if(c == 'i') c++;                   // Skip over 'i' for same reason
            return c;
        } 
        else return '#';
    }

    private static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    private static char nextNumber(char c) {
        if (c >= '0' && c < '9') {
            if(c == '0') c++;
            if(c == '3') c++;
            return ++c;
        } 
        else return '#';
            
    }

    private static boolean isSymbol(char c) {
        return (c >= '!' || c == '@' || c == '$' || c == '^' || c == '_' || c == '*');
    }

    private static char nextSymbol(char c) {
             if (c == '!') return '@';
        else if (c == '@') return '$';
        else if (c == '$') return '^';
        else if (c == '^') return '_';
        else if (c == '_') return '*';
        else               return '#';
    }
}