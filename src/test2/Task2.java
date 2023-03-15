package test2;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();

        int x = random.nextInt(2, 10);
        int y = random.nextInt(2, 10);

        int[][] matrix = new int[x][y];

        for(int j=0;j<y;j++) System.out.print(j+1 + "\t\t");
        System.out.println();

        for(int i=0;i<x;i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = random.nextInt(-100, 100);
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Укажите номер столбца, который необходимо отобразить из матрицы размером  " + y + "x" + x + ":");
        int col = 0;

        boolean error = false;

        try {
            String input = in.nextLine();
            col = Integer.parseInt(input.trim());
            int check = matrix[0][col-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка 2: Нет столбца с таким номером");
            error = true;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка 1: Не верный формат числа");
            error = true;
        }

        if(!error)
        {
            System.out.println();
            System.out.println("Столбец " + col + ":");
            for(int i=0;i<x;i++) System.out.println(matrix[i][col-1]);
        }
    }
}
