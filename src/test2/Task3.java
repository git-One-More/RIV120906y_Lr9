package test2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество чисел массива для суммы: ");
        int size = Task1.getInt(true);
        byte[] values = new byte[size];

        System.out.println("Введите каждое число типа byte: ");
        for(int i=0;i<size;i++)
            values[i] = getByte();

        System.out.print("Введённые числа: ");
        for(int i=0;i<size;i++)
            System.out.print(values[i] + " ");

        System.out.println();

        System.out.print("Сумма чисел: ");
        int sumInt = 0;
        boolean error = false;
        for(int i=0;i<size;i++)
        {
            try {
                sumInt += values[i];

                if(sumInt < Byte.MIN_VALUE || sumInt > Byte.MAX_VALUE)
                    throw new ClassCastException();
            } catch (ClassCastException e){
                System.out.print("вычисление значения за границами диапазона типа byte");
                error = true;
                break;
            }
        }

        if(!error) System.out.println(sumInt);
    }

    public static byte getByte() {
        Scanner in = new Scanner(System.in);
        boolean error;
        byte ret = 0;

        do {
            error = false;
            try {
                String input = in.nextLine();
                int inte = Integer.parseInt(input);

                if(inte < Byte.MIN_VALUE || inte > Byte.MAX_VALUE)
                    throw new ClassCastException();
                else
                    ret = (byte) inte;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка 1: Не верный формат числа");
                error = true;
            } catch (ClassCastException e) {
                System.out.println("Ошибка 2: Выходит за диапазон типа byte");
                error = true;
            }
        } while(error);

        return ret;
    }
}
