// Написать программу, показывающую последовательность действий для игры “Ханойская башня”

import java.util.Scanner;

/**
 * Excersize_2_1
 */
public class Exercise_2_1 {

    public static void main(String[] args) {
        
        int [] x = CreateArray(args);
        int [] y = new int [x.length];
        y[0] = -1;
        int [] z = new int [x.length];
        z[0] = -1;
        System.out.printf("Исходное состояние Ханойской башни:");
        System.out.println();
        Print_R(x, y, z);
        int count = 0;
        while (z[z.length-2] == 0) {
            if (x.length%2 == 0) {
                Step(x, y);
                count ++;
                System.out.printf("Шаг %d" + "\n", count);
                Print_R(x, y, z);
                if (z[z.length-2] != 0) break;
                Step(x, z);
                count ++;
                System.out.printf("Шаг %d" + "\n", count);
                Print_R(x, y, z);
                if (z[z.length-2] != 0) break;
            } else {
                Step(x, z);
                count ++;
                System.out.printf("Шаг %d" + "\n", count);
                Print_R(x, y, z);
                if (z[z.length-2] != 0) break;
                Step(x, y);
                count ++;
                System.out.printf("Шаг %d" + "\n", count);
                Print_R(x, y, z);
                if (z[z.length-2] != 0) break;
            }
                Step(y, z);
                count ++;
                System.out.printf("Шаг %d" + "\n", count);
                Print_R(x, y, z);
        }
        System.out.println("Конечное состояние Ханойской башни:");
        Print_R(x, y, z);
        System.out.printf("Задача решена за %d шаг(-а / -ов)",count);
    }
        
    public static void Swap(int [] x, int i, int [] y, int j) {
        if (y[j] == 0) {
            y[j] = x[i];
            x[i] = 0;
        } else {
            if (x[i] == 0) {
                x[i] = y[j];
                y[j] = 0;
            } else {
                if (y[j] > x[i]){
                y[j+1] = x[i];
                x[i] = 0;
                } else {
                    x[i+1] = y[j];
                    y[j] = 0;
                }
            }
            
        }
    }

public static void Step(int[] x, int[] y) {
    for (int i = 1; i < x.length; i++) {
        if (x[i] == 0 && x[i-1] != -1) {
            for (int j = 1; j < y.length; j++) {
                if (y[j] == 0 && y[j-1] == -1) {
                    Swap(x, i-1, y, j);
                    break;
                } else {
                    if (y[j] == 0 && y[j-1] != -1) {
                        Swap(x, i-1, y, j-1);
                        break;  
                    }
                }
            } 
            break;
        }
    }
}

public static int [] CreateArray(String[] args) {
    
    Scanner iScanner = new Scanner(System.in);
    System.out.printf("Введите количество элементов в Ханойской башне: ");
    int size = iScanner.nextInt();
    int [] myArray = new int [size+2];
    myArray[0] = -1;
    for (int i = 1; i <= size; i++) {
        myArray [i] = size +1 - i;
    }
    iScanner.close();
    return myArray;
}

public static void Print_R(int [] x, int [] y, int [] z) {
    String Str = "";
    for (int i = 1; i < x.length-1; i++) {
        Str = x[x.length - 1 - i] + "\t" + y[y.length - 1 - i] + "\t" + z[z.length - 1 - i] +"\n";
        System.out.print(Str);
    }
    System.out.println();
}
    
}


