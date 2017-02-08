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
	       stack.push(new pw_stats());
        StringBuilder password = new StringBuilder();                   // We choose a StringBuilder for it's mutability while still retaining the functionality of a String object
        printer = new PrintWriter(new File("all_passwords.txt"));       // My dude Pringus will let us write all of our password/time combos to a file! How cool of him!

        validPasswords(stack,password);
	}

    private static void validPasswords(Stack<pw_stats> stack, StringBuilder password) {

        pw_stats temp = stack.pop();

        if (temp.getCharsLeft() == 5) {                 // Regular Condition: Unreachable until all passwords enumerated
            if (password.length() == 0) {               // Initial Condition: First Character
                password.insert(0,nextLetter('+'));     // Pass '+' into nextLetter to signify initial condition (empty password)
                temp.setLetterAmt(1);                  
                temp.setCharsLeft(4);
            } else {

            }

        } else if (temp.getCharsLeft() == 4) {          // Regular Condition: First Character
            if (password.length() == 1) {               // Initial Condition: Second Character
                password.insert(1,nextLetter('+'));     // Pass '+' into nextLetter to signify initial condition (empty password)
                temp.setLetterAmt(2);                  
                temp.setCharsLeft(3);
            } else {

            }

        } else if (temp.getCharsLeft() == 3) {          // Regular Condition: Second Character
            if (password.length() == 2) {               // Initial Condition: Third Character
                password.insert(2,nextLetter('+'));     // Pass '+' into nextLetter to signify initial condition (empty password)
                temp.setLetterAmt(3);                  
                temp.setCharsLeft(2);
            } else {

            }

        } else if (temp.getCharsLeft() == 2) {          // Regular Condition: Third Character
            if (password.length() == 3) {               // Initial Condition: Fourth Character
                password.insert(3,nextNumber('+'));     // Pass '+' into nextLetter to signify initial condition (empty password)
                temp.setNumberAmt(1);                  
                temp.setCharsLeft(1);
            } else {

            }

        } else if (temp.getCharsLeft() == 1) {          // Regular Condition: Fourth Character
            if (password.length() == 4) {               // Initial Condition: Fifth Character
                password.insert(4,nextSymbol('+'));     // Pass '+' into nextLetter to signify initial condition (empty password)
                temp.setSymbolAmt(1);                  
                temp.setCharsLeft(0);
                printer.println(password+","+Double.toString(System.currentTimeMillis() - temp.getStartTime()));
            } else {

            }

        } else if (temp.getCharsLeft() == 0) {                                                              // Regular Condition: Fifth Character
            
            if (temp.getLetterAmt() < 3 && temp.getNumberAmt() != 0 && temp.getSymbolAmt() != 0)                // If less than 3 letters, atleast 1 number, atleast 1 symbol
                password.insert(4,nextLetter(password.charAt(4)));                                                  // Insert a letter
            else if (temp.getNumberAmt() < 2 && temp.getLetterAmt() != 0 && temp.getSymbolAmt() != 0)           // If less than 2 numbers, atleast 1 letter, atleast 1 symbol
                password.insert(4,nextNumber(password.charAt(4)));                                                  // Insert a number
            else if (temp.getSymbolAmt() < 2 && temp.getLetterAmt() != 0 && temp.getNumberAmt() != 0)           // If less than 2 symbols, atleast 1 letter, atleast 1 number
                password.insert(4,nextSymbol(password.charAt(4)));                                                  // Insert a symbol

            if(password.charAt(4) == '#') {
                password.insert(4,'+');
                return;
            }

            printer.println(password+","+Double.toString(System.currentTimeMillis() - temp.getStartTime()));
        }

        stack.push(temp);
        validPasswords(stack,password);
        return;
    }

    private static boolean isLetter(char c) {
        return (c >= 'b' && c <= 'z');
    }

    private static char nextLetter(char c) {
             if (c == '+') return 'b';               // Passing in '+' is used to signify that StringBuilder char is uninitialized, return first possible value
        else if (c >= 'b' && c < 'z') {              // Won't contain 'a' since it is pruned out
             if (c == 'i') c++;                      // Skip over 'i' for same reason
             return ++c;                             // Return next letter
      } else return '#';
    }

    private static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    private static char nextNumber(char c) {
             if (c == '+') return '0';
        else if (c >= '0' && c < '9') {
             if (c == '0') c++;
        else if (c == '3') c++;
             return ++c;
      } else return '#';
    }

    private static boolean isSymbol(char c) {
        return (c >= '!' || c == '@' || c == '$' || c == '^' || c == '_' || c == '*');
    }

    private static char nextSymbol(char c) {
             if (c == '+') return '!';
        else if (c == '!') return '@';
        else if (c == '@') return '$';
        else if (c == '$') return '^';
        else if (c == '^') return '_';
        else if (c == '_') return '*';
        else               return '#';
    }
}