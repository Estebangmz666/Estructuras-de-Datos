package estebangmz666.trees.binary_trees;

/*Data structures can be clasified as lineals and no lineals. Trees are no lineals. In trees, information is contained in
 * a node and each node can have a number of children. The root is the first node in the tree.
 * The AVL tree is a self-balancing binary search tree. In an AVL tree, the heights of the two child subtrees of any node differ by at most one. If they differ 
 * by more than one at any time, rebalancing is performed to restore this property.
 * Trees can be clasified as: binary trees and n-ary trees. In binary trees, each node has at most two children. In n-ary trees, each node can have n children.
 * Inorden: Left, Root, Right.
 * Preorden: Root, Left, Right.
 * Postorden: Left, Right, Root.
 */

public class BinaryTree<T extends Comparable<? super T>> {

    public static class Node<T>{
        T value;
        Node<T> leftChildren;
        Node<T> rightChildren;

        public Node(T value) {
            this.value = value;
            this.leftChildren = null;
            this.rightChildren = null;
        }
    }
    
    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }    

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }
        Comparable<? super T> cmp = current.value;
        if (cmp.compareTo(value) > 0) {
            current.leftChildren = insertRecursive(current.leftChildren, value);
        } else if (cmp.compareTo(value) < 0) {
            current.rightChildren = insertRecursive(current.rightChildren, value);
        }
        return current;
    }

    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }

    private void printInOrderRecursive(Node<T> node) {
        if (node != null) {
            printInOrderRecursive(node.leftChildren);
            System.out.print(node.value + " ");
            printInOrderRecursive(node.rightChildren);
        }
    }

    public void printPreOrder() {
        printPreOrderRecursive(root);
        System.out.println();
    }

    private void printPreOrderRecursive(Node<T> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreOrderRecursive(node.leftChildren);
            printPreOrderRecursive(node.rightChildren);
        }
    }

    public void printPostOrder() {
        printPostOrderRecursive(root);
        System.out.println();
    }

    private void printPostOrderRecursive(Node<T> node) {
        if (node != null) {
            printPostOrderRecursive(node.leftChildren);
            printPostOrderRecursive(node.rightChildren);
            System.out.print(node.value + " ");
        }
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node<T> node, T value) {
        if (node == null) {
            return false;
        }

        Comparable<? super T> cmp = (Comparable<? super T>) node.value;
        int compareResult = cmp.compareTo(value);

        if (compareResult == 0) {
            return true;
        } else if (compareResult > 0) {
            return containsRecursive(node.leftChildren, value);
        } else {
            return containsRecursive(node.rightChildren, value);
        }
    }

    public void addChildren(Node<T> parent, Node<T> left, Node<T> right) {
        parent.leftChildren = left;
        parent.rightChildren = right;
    }    
}