package singleton.demo1;

public class Minister {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            // 获取到同一个对象
            Emperor instance = Emperor.getInstance();
            System.out.println(instance);
        }
    }
}
