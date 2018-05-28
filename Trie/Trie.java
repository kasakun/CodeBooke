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
        node.countClear();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); ++i) {
            TrieNode newNode = new TrieNode();
            node.put(word.charAt(i), newNode);   
            node = newNode;
        }
        
        node.countInc();
    }

    /**
     * 
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
private class TrieNode {
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
        return nodes[ch - 'a'] != null;
    }

    /**
     * 
     * @param char
     * @return the node contains the char
     */
    public TrieNode get(char ch) {
        return nodes[ch - 'a'];
    }

    /**
     * 
     * put the node at the
     * @param char, node
     */
    public void put(char ch, TreeNode node) {
        nodes[ch - 'a'] = node;
    }

    /**
     * 
     * .
     * @return count of the node
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @return if the node has the word.
     * 
     */
    public boolean hasWord() {
        return count != 0;
    }

    /**
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