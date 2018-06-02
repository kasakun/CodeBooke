import java.util.Collection;
import java.util.NoSuchElementException;

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
        root = add(data, root);
    }

    /**
     * Helper method for add(T data)
     * This method
     * 
     * @param data
     * @param curr tree node
     * @return the node which owns updated subtree
     */
    private BSTNode<T> add(T data, BSTNode<T> node) {
        // The end of the branch. return the new node
        if (node == null) {
            ++size;
            return new BST<T>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(add(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(add(data, node.getRight()));
        }
        
        return node;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public T remove(T data) {
        if (data = null) {
            throw new IllegalArgumentException("The input data is null!");
        }
        
        BSTNode<T> temp = new BSTNode<>(null);
        root = remove (data, root, temp);
        return temp.getData();
    }

    /**
     * 
     * @throws java.util.NoSuchElementException
     * @param data to be removed
     * @param node current node in the tree
     * @param temporary node to contain the removed node if exists.
     * @return the cuurent node
     */
    private BSTNode<T> remove(T data, BSTNode<T> node, BSTNode<T> temp) {
        if (node == null)
            throw new java.util.NoSuchElementException("Data does not exist");
        

        if (data.equals(node.getData())) {
            //hit
            temp.setData(data);
            if (node.getLeft() == null && node. getRight == null) {
                // the leaf
                node = null;
                --size;
            } else if (node.getLeft() != null && node.getRight() == null) {
                node = node.getLeft();
                --size;
            } else if (node.getLeft() == null && node.getRight() != null) {
                node = node.getRight();
                --size;
            } else {
                // has left and right child left is always smaller than right
                // pick the largest in the left to be the connector
                BSTNode<T> master = new BSTNode<>(null);
                node.setLeft(removeLargest(node.getLeft(), master));
                node.setData(master.getData());
                --size;
            }
        } else {
            //not hit
            if (data.compareTo(node.getData()) < 0) {
                cur.setLeft(remove(data, node.getLeft(), temp));
            } else {
                cur.setRight(remove(data, node.getRight(), temp));
            }
        }

        return node;
    }

    /**
     * 
     * Helper method, to find the largest node in the tree
     * 
     * @param node current node
     * @param mastert point to the largest node
     * @return current node
     */
    private BSTNode<T> removeLargest(BSTNode<T> node, BSTNode<T> master) {
        if (node.getRight() == null) {
            master.setData(node.getData());
            node = node.getLeft();
        } else {
            // keep right, because the largest is the rightest
            node.setRight(removeLargest(node.getRight(), master));
        }

        return node;
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