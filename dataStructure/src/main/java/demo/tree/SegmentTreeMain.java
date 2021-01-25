package demo.tree;

public class SegmentTreeMain {

    public static void main(String[] args) {
        Integer[] nums = {0,1,2,3,4,5,6,7,8,9,10};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(2,5));
    }
}
