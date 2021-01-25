package sparsearray;

public class SparseArrayText {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        // printArray(chessArr);
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = 0;
        int m = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArray[m][0] = i;
                    sparseArray[m][1] = j;
                    sparseArray[m][2] = chessArr[i][j];
                    m++;
                }
            }
        }

        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                chessArr2[i][j] = sparseArray[0][2];
            }

        }
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];

        }
        printArray(chessArr2);
    }

    public static void printArray(int[][] arr) {
        for (int[] temp : arr) {
            for (int item : temp) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }
}