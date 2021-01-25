package old.common.dynamic;

public class KnapsackProblem {
	public static void main(String[] args) {
		int[] w = {1, 4, 3}; // 物品的重量
		int[] val = {1500, 3000, 2000}; // 物品的价值
		int m = 4; // 背包的容量
		int n = val.length; // 物品的个数

		// 创建二维数组
		// v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大值
		int[][] v = new int[n + 1][m + 1];

		// 为了记录放入商品的情况,我们定义一个二维数组
		int[][] path = new int[n + 1][m + 1];

		// 初始化第一列
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0;
		}
		// 初始化第一行
		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0;
		}
		// 根据前面的公式进行动态规划处理
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				// 因为i是从1开始的,因此我们原来公式中的w[i]修改成w[i-1]
				if(w[i - 1] > j) {
					v[i][j] = v[i - 1][j];
				} else {
					// v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i - 1]]);
					// 为了激励商品存放到背包的情况,我们不能简单使用上面的公司,需要使用if else 来处理
					if(v[i-1][j] > (val[i-1]+v[i-1][j-w[i - 1]])) {
						v[i][j] = v[i-1][j];
					} else {
						v[i][j] = val[i-1]+v[i-1][j-w[i - 1]];
						// 把当前情况记录下来
						path[i][j] = 1;
					}
				}
			}
		}
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[i].length; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
		// 输出最后我们放入了那些商品
		// 遍历path,这样输出会把所有的情况都得到,其实我们只需要最后的放入
//		for (int i = 0; i < path.length; i++) {
//			for (int j = 0; j < path[i].length; j++) {
//				if(path[i][j] == 1) {
//					System.out.printf("第%d个商品放到背包\n",i);
//				}
//			}
//		}
		int i = path.length - 1;
		int j = path[0].length - 1;
		while (i > 0 && j > 0) { // 从path的最后开始找
			if(path[i][j] == 1) {
				System.out.printf("第%d个商品放到背包\n",i);
				j -= w[i-1];
			}
			i--;
		}
	}
}
