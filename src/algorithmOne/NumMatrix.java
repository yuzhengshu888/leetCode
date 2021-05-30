package algorithmOne;

public class NumMatrix {
    int[][] sums;

    //法1:利用一维前缀和
//    public NumMatrix(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        sums = new int[n][m + 1];
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < m; i++) {
//                sums[j][i + 1] = sums[j][i] + matrix[j][i];
//            }
//        }
//    }
//
//    //(row1,col1),(row2,col2)
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int res = 0;
//        for (int i = row1; i <= row2; i++) {
//            res += sums[i][col2 + 1] - sums[i][col1];
//        }
//        return res;
//    }

    //法二:利用二维前缀和
    //设 f(x,y) 为从0-x,0-y的面积
    //有 f(x,y)  = f(x-1,y) + f(x,y-1) - f(x-1,y-1) + matrix(x,y)
    //   f(y,x)  =  f(y-1,x) + f(y,x-1) - f(y-1,x-1) + matrix(y,x)
    //   f(y+1,x+1)  =  f(y,x+1) + f(y+1,x) - f(y,x) + matrix(y+1,x+1)
    //已知 f(0,0) = matrix(0,0)
    // sumRegion(x1,y1,x2,y2) = f(x2,y2) -f(x1,y2) - f(x2,y1) + f(x1,y1)
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        sums = new int[n + 1][m + 1];
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                sums[y][x] = sums[y - 1][x] + sums[y][x - 1] - sums[y - 1][x - 1] + matrix[y - 1][x - 1];
            }
        }
    }

    //(row1,col1),(row2,col2)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numArray = new NumMatrix(matrix);
        System.out.println(numArray.sumRegion(0, 0, 0, 0));//3
        System.out.println(numArray.sumRegion(2, 1, 4, 3));//8
        System.out.println(numArray.sumRegion(1, 1, 2, 2));//11
        System.out.println(numArray.sumRegion(1, 2, 2, 4));//12
    }
}
