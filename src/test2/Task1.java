package test2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введите количество чисел: ");
        int size = getInt(true);
        int posCount = 0;
        int posSum = 0;
        int posAvg = 0;

        int[] values = new int[size];

        System.out.println("Введите каждое из чисел: ");
        for(int i=0;i<size;i++){
            values[i] = getInt(false);
            if(values[i] > 0)
            {
                posCount++;
                posSum += values[i];
            }
        }

        try {
            posAvg = posSum / posCount;
        } catch (ArithmeticException e) {
            System.out.println("Ошибка 4: Положительные элементы отсутствуют");
        }

        if(posAvg > 0) System.out.println("Среднее значение среди положительных элементов: " + posAvg);
    }

    public static int getInt(boolean onlyPositive) {
        Scanner in = new Scanner(System.in);
        boolean error;
        int ret = 0;

        do {
            error = false;
            try {
                String input = in.nextLine();

                if((input.length() - input.replace(",", "").length()) == 1 || (input.length() - input.replace(".", "").length()) == 1)
                    throw new ClassCastException("Необходимо целое число");

                ret = Integer.parseInt(input.trim());

                if (onlyPositive && ret <= 0)
                    throw new IllegalArgumentException("Необходимо положительное число больше нуля");
            } catch (ClassCastException e) {
                System.out.println("Ошибка 3:" + e.getMessage());
                error = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка 1: Не верный формат числа");
                error = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка 0: " + e.getMessage());
                error = true;
            }
        } while (error);

        return ret;
    }
}