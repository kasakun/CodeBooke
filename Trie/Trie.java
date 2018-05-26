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
}


/**
 * 
 * TrieNode Structure
 * _______________________
 * |____boolean isEnd____|
 * |a|b|c|d|...|v|w|x|y|z|
 * |_|_|_|_|...|_|_|_|_|_|
 * 
 */
private class TrieNode {
    private TrieNode[]  nodes;
    private final int size = 26;
    private boolean isEnd;
    
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
        return nodes[ch - 'a'] = null;
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
     * check the node if the end of the word.
     * @return if the node is the end
     */
    public boolean isEnd() {
        return isEnd;
    }

    /**
     * 
     * set the isEnd true
     */
    public void setEnd() {
        isEnd = true;
    }



}