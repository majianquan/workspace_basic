package sparsearray;

/**
 * 演示稀疏数组
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        // 创建一个11*11的二维数组期棋盘
        int[][] chessArr = new int[11][11];
        // 设置黑白棋子 0-空白 1-黑子 2-白子
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 2;

        // 打印二维数组
//        pirntTwoArr(chessArr);

        // 二维数组转稀疏数组
        int[][] sparseArr = twoArrTransformSparse(chessArr);
        pirntTwoArr(sparseArr);
        // 稀疏数组第一列是多上行,多少列,默认数值
        // 打印稀疏数组
//        pirntTwoArr(sparseArr);

        // 稀疏数组恢复二维数组
        int[][] chessArr2 = sparseTransofrmTowArr(sparseArr);
        // 打印恢复后的二维数组
        pirntTwoArr(chessArr2);
    }

    private static int[][] sparseTransofrmTowArr(int[][] sparseArr) {
        int row = sparseArr[0][0];
        int col = sparseArr[0][1];
        int[][] result = new int[row][col];
        for (int i = 1; i < sparseArr.length; i++) {
            result[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return result;
    }

    private static int[][] twoArrTransformSparse(int[][] chessArr) {
        // 查看有多少个棋子
        int sum = getNumberOfChess(chessArr);
        int[][] result = new int[sum + 1][3];
        int row = 1;
        setFirstRowData(result);
        setOtherRowData(result, chessArr, row);
        return result;
    }

    private static void setOtherRowData(int[][] result, int[][] chessArr, int row) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    result[row][0] =i;
                    result[row][1] =j;
                    result[row][2] =chessArr[i][j];
                    row++;
                }
            }
        }
    }

    private static void setFirstRowData(int[][] result) {
        result[0][0] = 11;
        result[0][1] = 11;
        result[0][2] = 0;
    }

    private static int getNumberOfChess(int[][] chessArr) {
        int sum = 0;
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void pirntTwoArr(int[][] chessArr) {
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
