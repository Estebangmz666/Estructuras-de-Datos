package estebangmz666.trees.binary_trees;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        var n30 = new BinaryTree.Node<>(30);

        var n25 = new BinaryTree.Node<>(25);
        var n40 = new BinaryTree.Node<>(40);

        var n20 = new BinaryTree.Node<>(20);
        var n27 = new BinaryTree.Node<>(27);
        var n50 = new BinaryTree.Node<>(50);

        var n15 = new BinaryTree.Node<>(15);
        var n22 = new BinaryTree.Node<>(22);
        var n26 = new BinaryTree.Node<>(26);
        var n29 = new BinaryTree.Node<>(29);
        var n45 = new BinaryTree.Node<>(45);
        var n60 = new BinaryTree.Node<>(60);

        var n7 = new BinaryTree.Node<>(7);
        var n21 = new BinaryTree.Node<>(21);
        var n23 = new BinaryTree.Node<>(23);
        var n28 = new BinaryTree.Node<>(28);
        var n41 = new BinaryTree.Node<>(41);
        var n55 = new BinaryTree.Node<>(55);
        var n75 = new BinaryTree.Node<>(75);

        var n5 = new BinaryTree.Node<>(5);
        var n10 = new BinaryTree.Node<>(10);
        var n24 = new BinaryTree.Node<>(24);

        var n8 = new BinaryTree.Node<>(8);
        var n12 = new BinaryTree.Node<>(12);

        tree.setRoot(n30);

        tree.addChildren(n30, n25, n40);
        tree.addChildren(n25, n20, n27);
        tree.addChildren(n40, null, n50);
        tree.addChildren(n20, n15, n22);
        tree.addChildren(n27, n26, n29);
        tree.addChildren(n50, n45, n60);
        tree.addChildren(n15, n7, null);
        tree.addChildren(n22, n21, n23);
        tree.addChildren(n26, null, null);
        tree.addChildren(n29, n28, null);
        tree.addChildren(n45, n41, null);
        tree.addChildren(n60, n55, n75);
        tree.addChildren(n7, n5, n10);
        tree.addChildren(n10, n8, n12);
        tree.addChildren(n23, null, n24);

        System.out.println("In-order:");
        tree.printInOrder();
        System.out.println("\nPre-order:");
        tree.printPreOrder();
        System.out.println("\nPost-order:");
        tree.printPostOrder();
    }
}