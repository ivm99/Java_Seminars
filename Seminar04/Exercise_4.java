// Реализовать алгоритм быстрой сортировки

package Seminar04;

import java.util.Random;
import java.util.Scanner;

public class Exercise_4 {
    
    public static void main(String[] args) {
        
        int [] myArray = createArray();
        // int [] myArray = new int[] {16, -67, 100, -69, 94, -95, -83, -38, -35};
        printArr(myArray);
        quickSort(myArray, 0, myArray.length-1);
        printArr(myArray);
    }
    
    public static void quickSort(int [] arr, int start, int finish) {
        if (start < finish) {
            int pivot = PivotDefine(arr, start, finish);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, finish);
        }

    }

    public static int PivotDefine(int [] arr, int start, int finish) {
        
        int pivot = start;
        int i = start;
        int j = finish;
        while (i <= j) {
            while (arr[i] < arr[pivot]) {
                i += 1;
            }
            while (arr[j] > arr[pivot]) {
                j -=1;
            }
            if (i <= j) {
                swap(arr, i, j);
                i += 1;
                j -= 1;
            }
        }
        swap(arr, pivot, i-1);
        return i-1;
     }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr (int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length-1] + "]\n");
    }

    public static int[] createArray () {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите количество чисел в массиве: ");
        int size = iScanner.nextInt();
        int [] myArray = new int[size];
        for (int i = 0; i < size; i++) {
            myArray[i] = generateRandomIntRange(-100,100);
        }
        iScanner.close();
        return myArray;
    }

    public static int generateRandomIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
