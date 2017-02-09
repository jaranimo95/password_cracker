import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class pw_check {

    private static PrintWriter printer;
    private static int currentIndex;
    private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@', '$', '^', '_', '*'};

    public static void main(String args[]) throws FileNotFoundException {

        char[] buffer = new char[5];
        recurse(buffer);
    }

    public static void recurse(char[] A)
    {
        recurse(A, 0, 0, 0, 0);
    }

    private static void printShit(char[] A, int length, int num_letters, int num_numbers, int num_symbols)
    {
        System.out.print(A);
        System.out.format("%d %d %d %d\n", length, num_letters, num_numbers, num_symbols);
    }

    public static void recurse(char[] A, int length, int num_letters, int num_numbers, int num_symbols)
    {
        //printShit(A, length, num_letters, num_numbers, num_symbols);
        if(length == 5)
        {
            //dlb.add(A);
            System.out.println(A); 
            return;
        }
        else
        {
            for(int i = 0; i < alphabet.length; i++)
            {
                A[length] = alphabet[i];
                int a = getType(alphabet[i]);
                switch(a)
                {
                    case 1:
                        if(num_letters + 1 <= 3)
                        {
                            recurse(A, length + 1, num_letters + 1, num_numbers, num_symbols);
                        }
                        break;
                    case 2:
                        if(num_numbers + 1 <= 2)
                        {
                            recurse(A, length + 1, num_letters, num_numbers + 1, num_symbols);
                        }
                        break;
                    case 3:
                        if(num_symbols + 1 <= 2)
                        {
                            recurse(A, length + 1, num_letters, num_numbers, num_symbols + 1);
                        }
                        break;
                }
            }
        }
        return;
    }

    private static int getType(char a)
    {
        // 1 - a is letter
        // 2 - a is number
        // 3 - a is symbol 
        if(a >= 'a' && a <= 'z')
        {
            return 1;
        }
        else if (a >= '0' && a <= '9')
        {
            return 2;
        }
        return 3;
    }
}
