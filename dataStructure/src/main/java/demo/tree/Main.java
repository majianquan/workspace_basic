package demo.tree;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,3,6,8,4,2};
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        for (int i = 0; i < arr.length; i++) {
            t.add(arr[i]);
        }
//        t.preOrder();
//        t.preOrderByStack();
//        t.removeMax();
        t.removeMin();
        t.levelOrder();
    }
}
