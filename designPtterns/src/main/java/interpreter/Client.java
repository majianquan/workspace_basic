package interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Client {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr();
        System.out.println(expStr);
        HashMap<String,Integer> var = getValue(expStr);
        System.out.println(var);
        Calculator cal = new Calculator(expStr);
        System.out.println("运算结果为: " + expStr + " = " + cal.run(var));
    }
    public static String getExpStr() throws IOException {
        System.out.println("请输入表达式: ");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }
    public static HashMap<String,Integer> getValue(String exprStr) throws IOException {
        HashMap<String,Integer> map = new HashMap<>();
        for (char ch : exprStr.toCharArray()) {
            if(ch != '+' && ch != '-') {
                if(!map.containsKey(String.valueOf(ch))) {
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch),Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
