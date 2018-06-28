import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Collection;
/**
 * 
 * @author Zeyu Chen
 * @version 0.1
 */
public class AVL<T extends Comparable<? super T>> implements AVLInterface<T> {
    private AVLNode<T> root;
    private int size;

    /**
     * Constructor
     */
    public AVL() {
    }

    /**
     * Initializes the AVL tree with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public AVL(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data collecion is null!");
        }

        for (T element : data) {
            add(element);
        }
    }

    /**
     * @see Interface
     */
    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null!");
        }

        root  = add(root, data);
    }

    /**
     * Helper method
     * 
     * @param node  current node
     * @param data  the data we want add
     * @return a node of updated subtree
     */
    private AVLNode<T> add(AVLNode<T> node, T data) {
        if (node == null) {
            ++size;
            return new AVLNode<>(data);
        } else {
            if (data.compareTo(node.getData()) > 0) {
                // smaller
                node.setRight(add(node.getRight(), data));
            } else if (data.compareTo(node.getData()) < 0) {
                // larger
                node.setLeft(add(node.getLeft(), data));
            }
            // equal
            update(node);
            node = balance(node);
            return node;
        }
    }

    /**
     * Update height and balance factor of node
     * 
     * factor=leftheight-rightheight
     * @param node the current node
     */
    private void update(AVLNode<T> node) {
        int leftHeight;
        int rightHeight;

        if (node.getLeft() == null) {
            leftHeight = -1;
        } else {
            leftHeight = node.getLeft().getHeight();
        }

        if (node.getRight() == null) {
            rightHeight = -1;
        } else {
            rightHeight = node.getRight().getHeight();
        }

        node.setHeight(Math.max(leftHeight, rightHeight) + 1);
        node.setBalanceFactor(leftHeight - rightHeight);
    }

    /**
     * 4 situations
     * @param node the root of the unbalanced subtree
     * @return a node with updated balanced tree
     */
    private AVLNode<T> balance(AVLNode<T> node) {
        if (node.getBalanceFactor() < -1) { //right heavy
            if (node.getRight().getBalanceFactor() <= 0) {
                //single left rotation
                return leftRotation(node);
            } else {
                //right left rotation
                node.setRight(rightRotation(node.getRight()));
                return leftRotation(node);
            }
        } else if (node.getBalanceFactor() > 1) { //left heavy
            if (node.getLeft().getBalanceFactor() >= 0) {
                //single right notation
                return rightRotation(node);
            } else {
                //left right notation
                node.setLeft(leftRotation(node.getLeft()));
                return rightRotation(node);
            }
        }
        return node;
    }

    /**
     * 1         2
     *  \  -->  /
     *   2     1
     * Perform anti clockwise rotation of AVL
     * @param node the current node
     * @return the updated node after rotation
     */
    private AVLNode<T> leftRotation(AVLNode<T> node) {
        AVLNode<T> newTop = node.getRight();
        node.setRight(newTop.getLeft());
        newTop.setLeft(node);

        // update balance after change
        update(node);
        update(newTop);
        return newTop;
    }


    /**
     *   1      2
     *  /   -->  \
     * 2          1
     * Perform clockwise rotation of AVL
     * @param node the current node
     * @return the updated node after rotation
     */
    private AVLNode<T> rightRotation(AVLNode<T> node) {
        AVLNode<T> newTop = node.getLeft();
        node.setLeft(newTop.getRight());
        newTop.setRight(node);

        // update balance after change
        update(node);
        update(newTop);
        return newTop;
    }
}