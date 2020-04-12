import java.util.Scanner;

public class Main {

    public static int[][] field;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        field = new int[n][m];              //матрица состояний (в каждой точке (i, j) кол-во путей до нее от (0, 0))
        field[0][0] = 1;                    //начальная точка имеет значение 1, т.к. из точки в саму себя можно попасть лишь 1 способом

        for (int k = 0; k < m; k++) {  //
            int i = 0, j = k;           //
            while(j >= 0) {             //
                sum(i, j);              //
                i++;                    //
                j--;                    //
            }                           // последовательный обход матрицы и запуск ф-ции sum(i, j)
        }                               //
        for (int k = 1; k < n; k++) {   //
            int i = k, j = m-1;         //
            while(i < n) {              //
                sum(i, j);              //
                i++;                    //
                j--;                    //
            }                           //
        }                               //

        System.out.println(field[n-1][m-1]); // вывод ответа
    }

    static void sum(int i, int j) {
        try {                                       //
            field[i][j] += field[i-1][j-2];         // вычисление состояния в точке (i, j)
        } catch (IndexOutOfBoundsException e) {}    // блоки "try-catch" используются для случаев, 
        try {                                       // когда координаты i-1, i-2, j-1 или j-2
            field[i][j] += field[i-2][j-1];         // выходят за пределы матрицы
        } catch (IndexOutOfBoundsException e) {}    //
    }
}
