import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TrieDriver
{
    public static void main(String args[]) throws FileNotFoundException
    {
        Dtrie trie = new Dtrie();
        boolean result;

        trie.insert("property");
        result = trie.search("property");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");
        result = trie.search("pr0perty");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");
        result = trie.search("prop3rty");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");
        result = trie.search("pr0p3r7y");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");

        trie.insert("sut");
        result = trie.search("sut");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");
         result = trie.search("su");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");
        result = trie.search("5ut");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");
        result = trie.search("su7");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");
        result = trie.search("5u7");
        if(result == true) System.out.println("-----------Found it!");
        else               System.out.println("-----------Not found.");

        Scanner dictionary = new Scanner(new File("dictionary.txt"));       // Create scanner to read text out of dictionary file
        String s;
        for(int i = 0; i < 500; i++) {                                      // Read out each line from dictionary file and insert into trie
            s = dictionary.nextLine();
            trie.insert(s);
            if(s.length() <=5){
                System.out.println("\n"+s);
                if(trie.search(s)) System.out.println("-----------Found it!");
                else               System.out.println("--------------------Not found."); 
            }
        }
    }
}
