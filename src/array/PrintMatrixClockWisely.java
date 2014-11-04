package array;

/**
 * 剑指offer 面试题20：顺时针打印矩阵
 *
 * @author chenjun
 */
public class PrintMatrixClockWisely<T> {
    public void print(T[][] matrix, int rows, int columns) {
        if (matrix == null || rows <= 0 || columns <= 0)
            return;
        int start = 0;
        while (rows > 2 * start && columns > 2 * start) {
            printOneCircle(matrix, rows, columns, start);
            start++;
        }
    }

    private void printOneCircle(T[][] matrix, int rows, int columns, int start) {
        int endX = columns - start - 1;
        int endY = rows - start - 1;
        for (int i = start; i <= endX; i++)
            System.out.print(matrix[start][i] + " ");
        for (int i = start + 1; i <= endY; i++)
            System.out.print(matrix[i][endX] + " ");
        if (start < endY)
            for (int i = endX - 1; i >= start; i--)
                System.out.print(matrix[endY][i] + " ");
        if (start < endX)
            for (int i = endY - 1; i > start; i--)
                System.out.print(matrix[i][start] + " ");

    }

    public static void main(String[] args) {
        Integer[][] matrix = {{1}};
        PrintMatrixClockWisely<Integer> pmcw = new PrintMatrixClockWisely<>();
        pmcw.print(matrix, 1, 1);
    }
}
