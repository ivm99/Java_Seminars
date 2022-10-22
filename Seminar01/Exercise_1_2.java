// Реализовать алгоритм пирамидальной сортировки (HeapSort)

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class Exercise_1_2 {
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
    
    public static void main (String [] args) {
        int [] myArray = createArray();
        // int [] myArray = {15, 4, -5, 8, 12, 35, 27, 154, 18, -67, 100, 7, -647, 1, 3466};
        System.out.printf("Заданный массив: %s\n", Arrays.toString(myArray));
        int size = myArray.length; 
        int temp = 0;
        for (int i = 0; i < size-1; i++) {
            myArray = heapify(myArray, size-i);
            swap(myArray, 0, myArray.length-1-i);
        }
        if (myArray[0] > myArray [1]){
            temp = myArray[0];
            myArray[0] = myArray [1];
            myArray [1] = temp;
        }
        System.out.printf("Отсортированный массив: %s\n", Arrays.toString(myArray)); 
    }

    public static int[] heapify(int [] myArray, int size) {
        for (int i = ((size-2)/2); i >= 0; i--) {
            int right = 2*i+2;
            int left = 2*i+1;
            int max = i;
            if (right < myArray.length) {
                if (myArray[right] > myArray[i] && right < size) {
                    max = right;
                }    
                if (myArray[left] > myArray[max] && left < size){
                    max = left;
                }
                if (max != i){
                    swap(myArray, i, max);
                }
            } else {
                if (myArray[left] > myArray[i]){
                    max = left;
                }
                if (max != i){
                    swap(myArray, i, max);
                }
            }
        }
        return myArray;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
}
