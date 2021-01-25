package demo.linkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        Integer first = list.getFirst();
        System.out.println("first: " + first);
        Integer last = list.getLast();
        System.out.println("last: " + last);
        list.update(8,18);
        list.remove(2);
        System.out.println(list);

    }
}
