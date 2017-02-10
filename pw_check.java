import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class pw_check {

    private static PrintWriter printer;
    private static double start;
    private static DLBTrie dlb;
    private static char[] set_letters = {'b', 'c', 'd','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static char[] set_numbers = {'0','2','3','5','6','7','8','9'};
    private static char[] set_symbols = {'!', '@', '$','^','_','*'};
    private static int max_length = 5;
    private static int max_letters = 3;
    private static int max_numbers = 2;
    private static int max_symbols = 2;

    public static void main(String[] args) throws FileNotFoundException
    {

        char[] A = new char[max_length];
        dlb = new DLBTrie();
        start = System.currentTimeMillis();
        printer = new PrintWriter("all_passwords.txt");

        recurse(A);
    }

    private static void recurse(char[] A)
    {
        recurse(A, 0, 0, 0, 0);
    }

    private static void recurse(char[] A, int length, int num_letters, int num_numbers, int num_symbols)
    {
        if(num_letters > max_letters || num_numbers > max_numbers || num_symbols > max_symbols)
        {
            return;
        }
        else if(length == 5)
        {
            printer.println(A+","+Double.toString(System.currentTimeMillis() - start));
        }
        else
        {
            int i;
            for(i = 0; i < set_letters.length; i++)
            {
                A[length] = set_letters[i];
                recurse(A, length + 1, num_letters + 1, num_numbers, num_symbols);
            }

            for(i = 0; i < set_numbers.length; i++)
            {
                A[length] = set_numbers[i];
                recurse(A, length + 1, num_letters, num_numbers + 1, num_symbols);
            }

            for(i = 0; i < set_symbols.length; i++)
            {
                A[length] = set_symbols[i];
                recurse(A, length + 1, num_letters, num_numbers, num_symbols + 1);
            }
        }
    }
}
