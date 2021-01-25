package singleton.demo7;

import java.util.ArrayList;
import java.util.Random;

public class Emperor {
    private static int maxNumOfEmperor = 2;
    private static ArrayList<Emperor> emperorList = new ArrayList();
    private static ArrayList<String> nameList = new ArrayList();
    private static int countNumOfEmperor = 0;
    private Emperor(){}
    private Emperor(String name) {
        nameList.add(name);
    }
    static {
        for (int i = 1; i <= maxNumOfEmperor; i++) {
            emperorList.add(new Emperor("皇帝" + i ));
        }
    }
    public static Emperor getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperorList.get(countNumOfEmperor);
    }
    public static void say() {
        System.out.println(nameList.get(countNumOfEmperor));
    }
}
