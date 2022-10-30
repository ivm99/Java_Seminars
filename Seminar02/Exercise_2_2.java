// Реализовать алгоритм сортировки вставками
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Exercise_2_2 {
    
    public static int[] createArray () {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите количество чисел в массиве: ");
        int size = iScanner.nextInt();
        int [] myArray = new int[size];
        for (int i = 0; i < size; i++) {
            myArray[i] = generateRandomIntIntRange(-100,100);
        }
        iScanner.close();
        return myArray;
    }

    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        int [] myArray = createArray();
        System.out.printf("Заданный массив: %s\n", Arrays.toString(myArray));
        for (int index = 1; index < myArray.length; index++) {
            int temp = myArray[index];
            for (int i = index-1; i >= 0; i--) {
                if (temp < myArray[i]) {
                    myArray[i+1] = myArray[i];
                    myArray[i] = temp;
                }
            }
            System.out.printf("Шаг сортировки %d: %s\n", index, Arrays.toString(myArray));
        }
        System.out.printf("Отсортированный массив: %s\n", Arrays.toString(myArray));    
    }
}
