/*  Написать программу вычисления n-ого треугольного числа. url*/

import java.util.Scanner;


//  Excersise_1_1

public class Exercise_1_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число 'n' для получения треугольного числа: ");
        int n = iScanner.nextInt();
        int tn = (n*(n+1))/2;
        System.out.printf("n-ое треугольное число равно %s",tn);
        iScanner.close();
    }

}