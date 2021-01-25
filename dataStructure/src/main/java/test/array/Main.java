package test.array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.add(i,i);
        }
        System.out.println(array);
    }
}
