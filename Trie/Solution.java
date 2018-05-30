import java.io.*;
import java.util.Random;

class Solution {
    public static void main(String[] args) {
        Trie trie = new Trie(); 
        String _case = "Zeyu";
        String para = "Xibei Zhang is a pigeon. Xibei works very hard. She is " 
                    + "currently working at Microsoft. I am very proud of her."
                    + " She is a really smart and gorgeous girl. I love her.";

        System.out.println("Test for Trie. Case insensitive.");
        System.out.println("================================================");                    
        System.out.println("Insert paragraph word by word.");
        String[] arr = para.split("[^a-zA-Z0-9]+");
        for (String x: arr) {
            trie.insert(x);
        }
        
        System.out.println("================================================");        
        System.out.println("Search each word.");
        for (String x: arr) {
            System.out.print(x + " ");
            System.out.println(trie.search(x));
        }
        System.out.println(_case + " " + trie.search(_case));

        System.out.println("================================================");
        System.out.println("Search each word prefix.");
        for (String x: arr) {
            Random rand = new Random(); 
            int value = rand.nextInt(x.length()); 
            String subStr = x.substring(0, value);
            System.out.print(subStr + " ");
            System.out.println(trie.search(x));
        }

        System.out.println("================================================");        
        System.out.println("Output count if search is true.");
        for (String x: arr) {
            System.out.println(x + " " + trie.getCount(x));
        }
        
        System.out.println(_case + " " + trie.getCount(_case));
        
    }
}