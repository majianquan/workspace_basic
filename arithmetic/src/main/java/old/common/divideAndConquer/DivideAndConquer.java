package old.common.divideAndConquer;

/**
 * 分治算法演示 汉诺塔
 *
 */
public class DivideAndConquer {
	public static void main(String[] args) {
		hanoiTower(3,'A','B','C');
	}
	/**
	 * 汉诺塔的移动方法
	 * 使用分治算法实现
	 */
	public static void hanoiTower(int num, char a, char b,char c) {
		// 如果只有一个盘
		// 1)  A -> C
		if(num == 1) {
			System.out.println("第一个盘从" + a + " -> " + c);
		} else {
			// 如果我们有n>=2情况,我们总可以看做是两个盘, 1最下边的盘,2上面的所有盘
			// 1) 先把最上面的盘A -> B
			hanoiTower(num - 1, a,c,b);
			// 2) 然后把 最下面的盘 A -> C
			System.out.println("第" + num + "个盘从" + a + " -> " + c);
			// 3) 最后把 B上的所有盘移动到C B->C
			hanoiTower(num - 1, b,a,c);
		}
	}
}
