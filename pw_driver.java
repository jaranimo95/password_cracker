import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.io.PrintWriter;
import java.util.Stack;

// For password,time search symbol table: have password be the key and time be the value. Can use any implementation we want for symbol table.

public class pw_driver {

    private static PrintWriter printer;
    private static int currentIndex;

	public static void main(String args[]) throws FileNotFoundException {

        Stack<pw_stats> stack = new Stack<pw_stats>();                  // Stack will hold password data between calls
	       stack.push(new pw_stats());

        char[] c = {'+','+','+','+','+'};
        String s = new String(c);
        StringBuilder password = new StringBuilder(s);                   // We choose a StringBuilder for it's mutability while still retaining the functionality of a String object
        printer = new PrintWriter(new File("all_passwords.txt"));       // My dude Pringus will let us write all of our password/time combos to a file! How cool of him!

       validPasswords(stack,password);
	}

    private static void validPasswords(Stack<pw_stats> stack, StringBuilder password) {

        pw_stats temp = stack.pop();
        currentIndex = password.length() - temp.getCharsLeft();

            if (isLetter(password.charAt(currentIndex)) || password.getLetterAmt < 3 && password.charAt(currentIndex) == '+') {
                password.insert(currentIndex, nextLetter(password.charAt(currentIndex)));
                temp.incLetterAmt();
            }
       else if (isNumber(password.charAt(currentIndex)) || password.getLetterAmt() == 3 && password.getNumberAmt() == 0 && password.charAt(currentIndex) == '+') {
                password.insert(currentIndex, nextNumber(password.charAt(currentIndex)));
                temp.incNumberAmt();
            }
       else if (password.getLetterAmt() == 3 && password.getNumberAmt() == 1) {
                password.insert(currentIndex, nextSymbol(password.charAt(currentIndex)));
                temp.incSymbolAmt();
            }

        if(temp.getCharsLeft() > 1)
            temp.decCharsLeft();

        if(password.charAt(currentIndex) == 0) 
            printer.println(password+","+Double.toString(System.currentTimeMillis() - temp.getStartTime()));

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
        return (c == '!' || 
                c == '@' || 
                c == '$' || 
                c == '^' || 
                c == '_' || 
                c == '*' );
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