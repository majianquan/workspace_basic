package demo.array;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>(20);
        for (int i = 0; i < 10; i++) {
            arrayList.addLast(i+ "a");
        }
        arrayList.add(1,"100");
        arrayList.addFirst("200");
        arrayList.removeFirst();
        arrayList.removeElement("4a");
        arrayList.removeElement("1a");
        arrayList.removeElement("2a");
        arrayList.removeElement("3a");
        arrayList.removeElement("5a");
        System.out.println(arrayList);
    }
}
