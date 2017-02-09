import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.io.PrintWriter;

// For password,time search symbol table: have password be the key and time be the value. Can use any implementation we want for symbol table.

public class pw_driver {

    private static PrintWriter printer;
    private static int currentIndex;

	public static void main(String args[]) throws FileNotFoundException {

        pw_stats stats = new pw_stats();
        char[] c = {'b','b','b','0','!'};                           // Initialize to first possible combination if iteraing from letters -> numbers -> symbols
        String s = new String(c);
        StringBuilder password = new StringBuilder(s);
        printer = new PrintWriter(new File("all_passwords.txt"));
        printer.println(password+','+Double.toString(System.currentTimeMillis - stats.getStartTime()));

        validPasswords(stats,password);
	}

    // Work on conditionals so you don't have to duplicate code

    private static void validPasswords(pw_stats stats, StringBuilder password) {

        currentIndex = password.length() - stats.getCharsLeft();

        if (currentIndex == 0 && currentIndex == 1) {                                                                                 // If dealing with first character
            if (stats.getCategory(currentIndex) == 0) password.insert(currentIndex,nextLet(password.chatAt(currentIndex)));           // If first character is a letter, go to next letter
            else if (stats.getCategory(currentIndex) == 1) password.insert(currentIndex,nextNum(password.chatAt(currentIndex)));      // If first character is a number, go to next number
            else if (stats.getCategory(currentIndex) == 2) password.insert(currentIndex,nextSym(password.chatAt(currentIndex)));      // If first character is a symbol, go to next symbol
            
            if(password.charAt(0) == '#') {
                if (!stats.incCategory()) return;
                else if (stats.getCategory() == 1) {
                    stats.decLetAmt();
                    stats.incNumAmt();
                } 
                else if (stats.getCategory() == 2) {
                    stats.decNumAmt();
                    stats.incSymAmt();
                }
                password.charAt(0) = '+';
            }
        }
        else if (currentIndex == 2) {
            if (stats.getCategory(currentIndex) == 0 && stats.getLetAmt < 3) password.insert(currentIndex,nextLet(password.chatAt(currentIndex)));
            else if (stats.getCategory(currentIndex) == 1 && stats.getNumAmt < 2) password.insert(currentIndex,nextNum(password.chatAt(currentIndex)));      // If first character is a number, go to next number
            else if (stats.getCategory(currentIndex) == 2 && stats.getSymAmt < 2) password.insert(currentIndex,nextSym(password.chatAt(currentIndex)));      // If first character is a symbol, go to next symbol
            
            if(password.charAt(0) == '#') {
                if (!stats.incCategory()) return;
                else if (stats.getCategory() == 1) {
                    stats.decLetAmt();
                    stats.incNumAmt();
                } 
                else if (stats.getCategory() == 2) {
                    stats.decNumAmt();
                    stats.incSymAmt();
                }
                password.charAt(0) = '+';
            }

        validPasswords(stats,password);
        return;
    }

    private static char nextLet(char c) {
            if (c == '+') return 'b';               // Passing in '+' is used to signify that StringBuilder char is uninitialized, return first possible value
       else if (c >= 'b' && c < 'z') {              // Won't contain 'a' since it is pruned out
            if (c == 'i') c++;                      // Skip over 'i' for same reason
            return ++c;                             // Return next letter
     } else return '#';
    }

    private static char nextNum(char c) {
             if (c == '+') return '0';
        else if (c >= '0' && c < '9') {
             if (c == '0') c++;
        else if (c == '3') c++;
             return ++c;
      } else return '#';
    }

    private static char nextSym(char c) {
             if (c == '+') return '!';
        else if (c == '!') return '@';
        else if (c == '@') return '$';
        else if (c == '$') return '^';
        else if (c == '^') return '_';
        else if (c == '_') return '*';
        else               return '#';
    }

    /*
        if (stats.getCategory[currentIndex] == 0)
                password.insert(currentIndex, nextLet(password.charAt(currentIndex)));
       else if (stats.getCategory[currentIndex] == 1)
                password.insert(currentIndex, nextNum(password.charAt(currentIndex)));
       else if (stats.getCategory[currentIndex] == 2)
                password.insert(currentIndex, nextSym(password.charAt(currentIndex)));
            
            if (password.charAt(currentIndex) == '#') {         // If reached end of legal characters in a category
                if(currentIndex == 0) return;                   // If first character reaches end of legal characters, return bc all passwords enumerated
                if(!stats.incCategory(currentIndex)) {          // If cannot increment category (end of character categories reached)
                    password.insert(currentIndex,'+');          // Reset value to empty state '+'
                    stats.decCharsLeft();
                }
                password.charAt(currentIndex) = '+';
            } else {
                if (stats.getLetterAmt() > 3)
                printer.println(password+','+Double.toString(System.currentTimeMillis - stats.getStartTime()));
            }
    */
}