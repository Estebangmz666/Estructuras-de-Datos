package estebangmz666.trees.red_black_tree;

/*BST with an aditional bit on each node, its color, may be black or red
 * Certain conditions about the color of the nodes guarantee that the depth on any leaf, is at most twice than any other leaf
 * Each node is a register with 3 fields, the value, the color and a pointer to the 2 children and the parent
 * If pointers are null, we´ll assume that those are pointers to external nodes (leafs)
 * Conditions:
 * 1. Each node is either red or black
 * 2. The root is black
 * 3. All leaves are black
 * 4. If a node is red, both its children are black (Cannot have 2 red nodes in a row)
 * 5. Every path from a node to its descendant leaves has the same number of black nodes
 * 6. New insertions are always red
 * 7. The longest path from the root to a leaf is at most twice as long as the shortest path
 * 
 * Insertion:
 * Case 1: The parent of the new node is black, no need to do anything
 * Case 2: The parent of the new node is the root, change the color of the root
 * Case 3: The parent of the new node is red and isn´t the root, there are 3 subcases:
 *   Case 3.1: The uncle of the new node is red, change the color of the parent, uncle and grandparent
 *   Case 3.2: The uncle of the new node is black and the new node is a left child; Or the uncle of the new node is at the opposite side and the new node is a right child. Do a right rotation and change the color
 *   Case 3.3: The uncle of the new node is black and the new node is a right child; Or the uncle of the new node is at the opposite side and the new node is a left child
 * 
*/

public class RedBlackTree {
    private static class Node {
        int value;
        boolean color;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
            this.color = true;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private Node root;
    private boolean RED = true;
    private boolean BLACK = false;
    public RedBlackTree() {
        this.root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            root.color = BLACK;
        } else {
            insertNode(root, newNode);
            fixInsert(newNode);
        }
    }

    private void insertNode(Node root, Node newNode) {
        if (newNode.value < root.value) {
            if (root.left == null) {
                root.left = newNode;
                newNode.parent = root;
            } else {
                insertNode(root.left, newNode);
            }
        } else if (newNode.value > root.value) {
            if (root.right == null) {
                root.right = newNode;
                newNode.parent = root;
            } else {
                insertNode(root.right, newNode);
            }
        }
    }

    private void fixInsert(Node newNode) {
        Node parent = null;
        Node grandParent = null;
        while (newNode != root && newNode.color == RED && newNode.parent.color == RED) {
            parent = newNode.parent;
            grandParent = parent.parent;
            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    newNode = grandParent;
                } else {
                    if (newNode == parent.right) {
                        rotateLeft(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateRight(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                }
            } else {
                Node uncle = grandParent.left;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    newNode = grandParent;
                } else {
                    if (newNode == parent.left) {
                        rotateRight(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateLeft(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    public void delete(int value) {
        Node nodeToDelete = searchNode(root, value);
        if (nodeToDelete != null) {
            deleteNode(nodeToDelete);
        }
    }

    private Node searchNode(Node root, int value) {
        if (root == null || root.value == value) {
            return root;
        }
        if (value < root.value) {
            return searchNode(root.left, value);
        } else {
            return searchNode(root.right, value);
        }
    }

    private void deleteNode(Node node) {
        Node replacement = null;
        Node child = null;
        if (node.left == null || node.right == null) {
            replacement = node;
        } else {
            replacement = getSuccessor(node);
        }
        if (replacement.left != null) {
            child = replacement.left;
        } else {
            child = replacement.right;
        }
        if (child != null) {
            child.parent = replacement.parent;
        }
        if (replacement.parent == null) {
            root = child;
        } else if (replacement == replacement.parent.left) {
            replacement.parent.left = child;
        } else {
            replacement.parent.right = child;
        }
        if (replacement != node) {
            node.value = replacement.value;
        }
        if (replacement.color == BLACK) {
            fixDelete(child);
        }
    }

    private Node getSuccessor(Node node) {
        if (node.right != null) {
            return getMinimum(node.right);
        }
        Node parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private Node getMinimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void fixDelete(Node node) {
        Node sibling;
        while (node != root && (node == null || node.color == BLACK)) {
            if (node == node.parent.left) {
                sibling = node.parent.right;
                if (sibling.color == RED) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateLeft(node.parent);
                    sibling = node.parent.right;
                }
                if ((sibling.left == null || sibling.left.color == BLACK) && (sibling.right == null || sibling.right.color == BLACK)) {
                    sibling.color = RED;
                    node = node.parent;
                } else {
                    if (sibling.right == null || sibling.right.color == BLACK) {
                        if (sibling.left != null) {
                            sibling.left.color = BLACK;
                        }
                        sibling.color = RED;
                        rotateRight(sibling);
                        sibling = node.parent.right;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    if (sibling.right != null) {
                        sibling.right.color = BLACK;
                    }
                    rotateLeft(node.parent);
                    node = root;
                }
            } else {
                sibling = node.parent.left;
                if (sibling.color == RED) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateRight(node.parent);
                    sibling = node.parent.left;
                }
                if ((sibling.right == null || sibling.right.color == BLACK) && (sibling.left == null || sibling.left.color == BLACK)) {
                    sibling.color = RED;
                    node = node.parent;
                } else {
                    if (sibling.left == null || sibling.left.color == BLACK) {
                        if (sibling.right != null) {
                            sibling.right.color = BLACK;
                        }
                        sibling.color = RED;
                        rotateLeft(sibling);
                        sibling = node.parent.left;
                    }
                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    if (sibling.left != null) {
                        sibling.left.color = BLACK;
                    }
                    rotateRight(node.parent);
                    node = root;
                }
            }
        }
        if (node != null) {
            node.color = BLACK;
        }
    }
}