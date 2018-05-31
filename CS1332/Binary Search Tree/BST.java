import java.util.Collection;

/**
 * Binary Search Tree
 * The element is unique in the tree.
 * 
 * @author Zeyu Chen
 * @version 0.1
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    /**
     * 
     * root and size
     */
    private BSTNode<T> root;
    private int size;

    /**
     * Counstructor
     */
    public BST() {
    }

    /**
     * Initializes the BST with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Can not insert null"
                    + " data into binary search tree");
        }

        for (T element : data) {
            add(element);
        }
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public void add(T data) {
        if (data == null)
            throw new IllegalArgumentException("The input is null");
        root = add(root, data);
    }

    /**
     * Helper method for add(T data)
     * 
     * @param data
     * @param curr tree node
     * @return the node which owns updated subtree
     */
    private BSTNode<T> add(T data, BSTNode<T> node) {
        if 
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public T remove(T data) {
        return null;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public T get(T data) {
        return null;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public boolean contains(T data) {
        return false;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * 
     * @see Interface
     */

}