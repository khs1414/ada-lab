import java.util.Arrays;

class StressenMatrix {
    static int[][] multiplyarr(int[][] arr1, int[][] arr2, int dimension) {
        dimension = dimension / 2;
        int[][] arr = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                arr[i][j] = 0;
                for (int k = 0; k < dimension; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }

    static int[][] addarr(int[][] arr1, int[][] arr2, int dimension) {
        dimension = dimension / 2;
        int[][] arr = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                arr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr;
    }

    static int[][] diffarr(int[][] arr1, int[][] arr2, int dimension) {
        dimension = dimension / 2;
        int[][] arr = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                arr[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return arr;
    }

    static int[][] submatrix(int[][] arr_abs, int start_i, int stop_i, int start_j, int stop_j, int dimension) {
        dimension = dimension / 2;
        int[][] arr = new int[dimension][dimension];
        int x = 0;
        int y = 0;
        for (int i = start_i; i < stop_i; i++) {
            y = 0;
            for (int j = start_j; j < stop_j; j++) {
                arr[x][y] = arr_abs[i][j];
                y++;
            }
            x++;
        }
        return arr;
    }

    static void strassen(int[][] arr, int[][] final_matrix, int start_x, int start_y, int dimension) {
        dimension = dimension / 2;
        int x = start_x;
        int y = start_y;
        for (int i = 0; i <= dimension - 2; i++) {
            y = start_y;
            for (int j = 0; j <= dimension - 2; j++) {
                final_matrix[x][y] = arr[i][j];
                y++;
            }
            x++;
        }
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] arr1 = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 2, 2, 2, 2 } };

        int[][] arr2 = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 2, 2, 2, 2 } };

        int[][] a = submatrix(arr1, 0, N / 2, 0, N / 2, N);
        int[][] b = submatrix(arr1, 0, N / 2, N / 2, N, N);
        int[][] c = submatrix(arr1, N / 2, N, 0, N / 2, N);
        int[][] d = submatrix(arr1, N / 2, N, N / 2, N, N);
        int[][] e = submatrix(arr2, 0, N / 2, 0, N / 2, N);
        int[][] f = submatrix(arr2, 0, N / 2, N / 2, N, N);
        int[][] g = submatrix(arr2, N / 2, N, 0, N / 2, N);
        int[][] h = submatrix(arr2, N / 2, N, N / 2, N, N);

        int[][] p1 = multiplyarr(a, diffarr(f, h, N / 2), N / 2);
        int[][] p2 = multiplyarr(addarr(a, b, N / 2), h, N / 2);
        int[][] p3 = multiplyarr(addarr(c, d, N / 2), e, N / 2);
        int[][] p4 = multiplyarr(d, diffarr(g, e, N / 2), N / 2);
        int[][] p5 = multiplyarr(addarr(a, d, N / 2), addarr(e, h, N / 2), N / 2);
        int[][] p6 = multiplyarr(diffarr(b, d, N / 2), addarr(g, h, N / 2), N / 2);
        int[][] p7 = multiplyarr(diffarr(a, c, N / 2), addarr(e, f, N / 2), N / 2);
        System.out.println(Arrays.deepToString(h));

        int[][] sub1 = diffarr(addarr(p5, p4, N / 2), addarr(p2, p6, N / 2), N / 2);
        int[][] sub2 = addarr(p1, p2, N / 2);
        int[][] sub3 = addarr(p3, p4, N / 2);
        int[][] sub4 = diffarr(diffarr(addarr(p1, p5, N / 2), p3, N / 2), p7, N / 2);

        int[][] final_matrix = new int[N][N];
        strassen(sub1, final_matrix, 0, 0, N);
        strassen(sub2, final_matrix, 0, N / 2, N);
        strassen(sub3, final_matrix, N / 2, 0, N);
        strassen(sub4, final_matrix, N / 2, N / 2, N);

        System.out.println(Arrays.deepToString(final_matrix));

    }
}
