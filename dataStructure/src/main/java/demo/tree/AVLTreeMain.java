package demo.tree;

public class AVLTreeMain {
    public static void main(String[] args) {
        AVLTree<Integer, String> avl = new AVLTree<>();
        for (int i = 0; i < 100; i++) {
            avl.add(i,String.valueOf(i));
        }
    }
}
