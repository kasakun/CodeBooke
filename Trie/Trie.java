import jdk.nashorn.internal.ir.BlockLexicalContext;

/**
 * 
 * Trie Structure
 * Keep in mind that in Trie, the link or the branch is the char keeper. The
 * node is not the one keep the char. It shows whether it is the end of the 
 * word.
 * 
 * @author: Zeyu Chen
 * @version： 0.1
 */

 /**
  * 
  * Trie
  *
  */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.countClear();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (node.get(ch) == null) {
                TrieNode newNode = new TrieNode();
                newNode.countClear();
                node.put(ch, newNode);   
                node = newNode;
            } else {
                node = node.get(ch);
            }
        }
        // The end of the word.
        node.countInc();
    }

    /**
     * Get sub-node if contains, check the last node count
     * @param word 
     * @return if the word is in the trie
     */
    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return false;
            }
        }

        return node.hasWord();
    }

    /**
     * 
     * @param word
     * @return count if the word exits
     */
    public int getCount(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }
        }

        return node.getCount();
    }

    /**
     * 
     * @param prefix
     * @return if contains the prefix
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return false;
            }
        }

        return true;
    }
}


/**
 * 
 * TrieNode Structure
 * _______________________
 * |______int count______|
 * |a|b|c|d|...|v|w|x|y|z|
 * |_|_|_|_|...|_|_|_|_|_|
 * 
 */
class TrieNode {
    private TrieNode[]  nodes;
    private final int size = 26;
    int count;
    
    /**
     * 
     * Constructor
     */
    public TrieNode() {
        nodes = new TrieNode[size];
    }

    /**
     * 
     * @param char
     * @return if contain the char
     */
    public boolean containsKey(char ch) {
        int index = ch - 'a' < 0 ? (ch - 'A') : (ch - 'a');   
        return nodes[index] != null;
    }

    /**
     * 
     * @param char
     * @return the node contains the char
     */
    public TrieNode get(char ch) {
        int index = ch - 'a' < 0 ? (ch - 'A') : (ch - 'a');           
        return nodes[index];
    }

    /**
     * 
     * put the node at the
     * @param char, node
     */
    public void put(char ch, TrieNode node) {
        int index = ch - 'a' < 0 ? (ch - 'A') : (ch - 'a');  
        nodes[index] = node;
    }

    /**
     * 
     * @return count of the node
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @return if the node has the word.
     */
    public boolean hasWord() {
        return count != 0;
    }

    /**
     * 
     * Only used when the node is new.
     * clear the count
     */
    public void countClear() {
        count = 0;
    }

    /**
     * 
     * count the words.
     */
    public void countInc() {
        ++count;
    }
}