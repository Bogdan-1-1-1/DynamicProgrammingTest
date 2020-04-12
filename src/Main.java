import java.util.Scanner;

public class Main {

    public static int[][] field;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        field = new int[n][m];
        field[0][0] = 1;

        for (int k = 0; k < m; k++) {
            int i = 0, j = k;
            while(j >= 0) {
                sum(i, j);
                i++;
                j--;
            }
        }
        for (int k = 1; k < n; k++) {
            int i = k, j = m-1;
            while(i < n) {
                sum(i, j);
                i++;
                j--;
            }
        }

        System.out.println(field[n-1][m-1]);
    }

    static void sum(int i, int j) {
        try {
            field[i][j] += field[i-1][j-2];
        } catch (IndexOutOfBoundsException e) {}
        try {
            field[i][j] += field[i-2][j-1];
        } catch (IndexOutOfBoundsException e) {}
    }
}
