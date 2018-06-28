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

    /**
     * @see Interface
     */
    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null!");
        }

        AVLNode<T> removed = new AVLNode<>(null);
        root = remove(root, data, removed);
        return removed.getData();
    }

    /**
     * Helper method for remove
     * @param node the current node
     * @param data the data we want to remove
     * @param removed a node storing the removed data in AVL tree
     * @return a node of updated subtree after removing and balancing
     */
    private AVLNode<T> remove(AVLNode<T> node, T data, AVLNode<T> removed) {
        if (node == null) {
            throw new NoSuchElementException("No such element!");
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(remove(node.getLeft(), data, removed));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(remove(node.getRight(), data, removed));
        } else {
            removed.setData(node.getData());
            --size;

            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            } else if (node.getLeft() != null && node.getRight() == null) {
                node = node.getLeft();
            } else if (node.getRight() != null && node.getLeft() == null) {
                node = node.getRight();
            } else {
                AVLNode<T> ParentNode = new AVLNode<>(null);
                node.setLeft(removeParentNode(node.getLeft(), ParentNode));
                node.setData(ParentNode.getData());
            }
        }

        if (node == null) {
            return null;
        }

        update(node);
        node = balance(node);

        return node;
    }


    /**
     * Helper method for remove to remove a node with two children
     * @param node the current node we want to remove
     * @param ParentNode a node storing the data of node's ParentNode
     * @return a node of updated subtree after removing ParentNode 
     * and balancing
     */
    private AVLNode<T> removeParentNode(AVLNode<T> node, AVLNode<T> ParentNode) {
        if (node.getRight() == null) {
            ParentNode.setData(node.getData());
            return node.getLeft();
        } else {
            node.setRight(removeParentNode(node.getRight(), ParentNode));
        }

        update(node);
        node = balance(node);

        return node;
    }

    /**
     * @see Interface
     */
    @Override
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null!");
        }

        return get(root, data);
    }

    /**
     * Helper method for get
     * @param node the current node
     * @param data the data we want to get
     * @return the data in the tree matching the parameter passed in
     */
    private T get(AVLNode<T> node, T data) {
        if (node == null) {
            throw new NoSuchElementException("No such element!");
        }

        if (data.compareTo(node.getData()) < 0) {
            return get(node.getLeft(), data);
        } else if (data.compareTo(node.getData()) > 0) {
            return get(node.getRight(), data);
        } else {
            return node.getData();
        }
    }

    /**
     * @see Interface
     */
    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data is null!");
        }
        return contains(root, data);
    }

    /**
     * Helper method for contains(T data) to check whether
     * or not the data is in the tree
     * @param node the current node
     * @param data the parameter we want to find
     * @return rue if the data is in the AVL tree
     * false otherwise
     */
    private boolean contains(AVLNode<T> node, T data) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.getData()) < 0) {
            return contains(node.getLeft(), data);
        } else if (data.compareTo(node.getData()) > 0) {
            return contains(node.getRight(), data);
        } else {
            return true;
        }
    }

    /**
     * @see Interface
     */
    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    /**
     * @see Interface
     */
    @Override
    public List<T> preorder() {
        return preorder(root);
    }

    /**
     * Helper method for the preorder traversal
     *
     * @param node the current node
     * @return the list represent the order of traversal
     */
    private List<T> preorder(AVLNode<T> node) {
        List<T> preList = new ArrayList<>();

        if (node == null) {
            return preList;
        }

        List<T> left = preorder(node.getLeft());
        List<T> right = preorder(node.getRight());

        preList.add(node.getData());
        preList.addAll(left);
        preList.addAll(right);

        return preList;
    }

    @Override
    public List<T> postorder() {
        return postorder(root);
    }

    /**
     * Helper method for the postorder traversal
     *
     * @param node the current node
     * @return the list represent the order of traversal
     */
    private List<T> postorder(AVLNode<T> node) {
        List<T> postList = new ArrayList<>();

        if (node == null) {
            return postList;
        }

        List<T> left = postorder(node.getLeft());
        List<T> right = postorder(node.getRight());

        postList.addAll(left);
        postList.addAll(right);
        postList.add(node.getData());

        return postList;
    }

    @Override
    public List<T> inorder() {
        return inorder(root);
    }

    /**
     * Helper method for the inorder traversal
     *
     * @param node the current node
     * @return the list represent the order of traversal
     */
    private List<T> inorder(AVLNode<T> node) {
        List<T> inList = new ArrayList<>();

        if (node == null) {
            return inList;
        }

        List<T> left = inorder(node.getLeft());
        List<T> right = inorder(node.getRight());

        inList.addAll(left);
        inList.add(node.getData());
        inList.addAll(right);

        return inList;

    }

    @Override
    public List<T> levelorder() {
        List<T> levelList = new ArrayList<>();

        Queue<AVLNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            AVLNode<T> current = queue.poll();
            levelList.add(current.getData());

            if (current.getLeft() != null) {
                queue.offer(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.offer(current.getRight());
            }
        }

        return levelList;
    }

    /**
     * @see Interface
     */
    @Override
    public List<T> listLeavesDescending() {
        List<T> leaves = new ArrayList<>();
        return listLeavesDescending(root, leaves);
    }


    /**
     * Helper method for listing leaves in descending order
     *
     * @param node the current node
     * @param leaves the list storing leaves in descending order
     * @return the list of leaves in descending order
     */
    private List<T> listLeavesDescending(AVLNode<T> node, List<T> leaves) {
        if (node == null) {
            return leaves;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            leaves.add(node.getData());
        }

        listLeavesDescending(node.getRight(), leaves);
        listLeavesDescending(node.getLeft(), leaves);

        return leaves;
    }

    /**
     * @see Interface
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * @see Interface
     */
    @Override
    public int height() {
        if (root == null) {
            return -1;
        }
        return root.getHeight();
    }

    /**
     * @see Interface
     */
    @Override
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }
}