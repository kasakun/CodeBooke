import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.math.*;

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
        if (data == null) 
            throw new IllegalArgumentException("Input data is null!");
        
        return get(data, root);
    }

    /**
     * 
     * Helper method for get()
     * @param data
     * @param node current node
     * @return the data
     */
    private T get(T data, BSTNode<T> node) {
        if (node == null)
            throw new NoSuchElementException("No such element!");
        
        if (data.equals(node.getData())) {
            return node.getData();
        } else if (data.compareTo(node.getData())) {
            return get(data, node.getLeft());
        } else {
            return get(data, node.getRight());
        }   
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public boolean contains(T data) {
        if (data == null)
            throw new IllegalArgumentException("The input data is null!");
        return false;
    }

    /**
     * Helper method for contains
     * @param data input data
     * @param node current node
     * @return boolean tell if contains the node
     */
    private boolean contains(T data, BSTNode<T> node) {
        if (node == null) 
            return false;
        
        if (data.equals(node.getData())) {
            return true;
        } else if (data.compareTo(node.getData() < 0)) {
            return contains(data, node.getLeft());
        } else {
            return contains(data, node.getRight());
        }
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public List<T> preorder() {
        List<T> res = new ArrayList<>();
        return preorder(root, res);
    }

    /**
     * 
     * Helper method for preorder
     * @param node current node
     * @param input array list
     * @return result list
     */
    private List<T> preorder(BSTNode<T> node, List<T> res) {
        if (node == null) {
            return res;
        }

        res.add(node.getData());
        preorder(node.getLeft(), res);
        preorder(node.getRight(), res);
        return res;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public List<T> inorder() {
        List<T> res = new ArrayList<>();
        return inorder(root, res);
    }

    /**
     * Helper method for inorder
     * @param node current node
     * @param input array list
     * @return result list
     */
    private List<T> inorder(BSTNode<T> node, List<T> res) {
        if (node == null) {
            return res;
        }

        inorder(node.getLeft(), res);
        res.add(node.getData());
        inorder(node.getRight(), res);
        return res;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public List<T> postorder() {
        List<T> res = new ArrayList<>();
        return postorder(root, res);
    }

    /**
     * Helper method for postorder
     * @param node current node
     * @param input array list
     * @return result list
     */
    private List<T> postorder(BSTNode<T> node, List<T> res) {
        if (node == null) {
            return res;
        }

        postorder(node.getLeft(), res);
        postorder(node.getRight(), res);
        res.add(node.getData());

        return res;
    }
    
     /**
     * BFS
     * @see Interface
     */
    @Override
    public List<T> levelorder() {
        Queue<BSTNode<T>> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            BSTNode<T> node = queue.poll();
            res.add(node.getData());

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            } else {
                queue.offer(node.getRight());
            } 
        }
        return res;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public List<T> listLeavesDescending() {
        List<T> res = new ArrayList<>();
        return listLeavesDescending(root, res);
    }

    /**
     * Helper method for descending
     * @param node current node
     * @param res input list
     * @return list
     */
    private List<T> listLeavesDescending(BSTNode<T> node, List<T> res) {
        if (null == null) {
            return res;
        }

        if (node.getLeft() == null && node.getRight == null) {
            res.add(node.getData());
        }

        listLeavesDescending(node.getRight(), res);
        listLeavesDescending(node.getLeft(), res);
        return res;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public int height() {
        return height(root);
    }

    /**
     * Helper method for height
     * 
     * @param node current node
     * @return max height of two branches
     */
    private int height(BSTNode<T> node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    /**
     * 
     * @see Interface
     */
    @Override
    public BSTNode<T> getRoot() {
        return root;
    }
}