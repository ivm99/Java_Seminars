// Реализовать волновой алгоритм.

package Seminar03;

import java.util.Arrays;

public class Exercise_3 {
    public static void main(String[] args) {

        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1,  0,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1 },
                { -1,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0, -1 },
                { -1,  0, -1,  0,  0, -1,  0, -1,  0,  0,  0, -1 },
                { -1,  0,  0, -1, -1, -1,  0, -1,  0, -1,  0, -1 },
                { -1,  0,  0,  0, -1, -1, -1, -1, -1,  0,  0, -1 },
                { -1,  0, -1, -1, -1, -1, -1,  0, -1,  0,  0, -1 },
                { -1,  0,  0,  0, -1, -1, -1,  0, -1,  0,  0, -1 },
                { -1,  0,  0,  0, -1,  0,  0,  0,  0, -1,  0, -1 },
                { -1,  0,  0,  0,  0, -1,  0,  0,  0,  0,  0, -1 },
                { -1,  0, -1,  0,  0,  0,  0,  0, -1,  0,  0, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };
        int[] start = { 2, 8 };
        int[] st = start;
        int[] finish1 = { 5, 9 };
        int[] finish2 = { 9, 3 };
        int[][] points = new int[71][2];
        points[0] = start;
        System.out.println("Исходный лабиринт");
        DrawMap(map, start, finish1, finish2);
        System.out.println("Координаты старта и финиша");
        System.out.print("Start: " + Arrays.toString(start) + "\n");
        System.out.print("Finish1: " + Arrays.toString(finish1) + "\n");
        System.out.print("Finish2: " + Arrays.toString(finish2) + "\n");
        map[start[0]][start[1]] = 1;
        while (start[0] != 0 && start[1] != 0) {
            start = Step(map, points);
        }
        System.out.println();
        System.out.print("Заполненный лабиринт \n");
        DrawMap(map, st, finish1, finish2); 
        System.out.print("кратчайший путь до Finish1: " + (map[finish1[0]][finish1[1]]-1) + " шагов\n");
        int [][] path1 = DrawPath(map, finish1, map[finish1[0]][finish1[1]]);
        DrawMap2(map, st, finish1, finish2, path1);
        System.out.print("кратчайший путь до Finish2: " + (map[finish2[0]][finish2[1]]-1) + " шагов\n");
        int [][] path2 = DrawPath(map, finish2, map[finish2[0]][finish2[1]]);
        DrawMap2(map, st, finish1, finish2, path2);
    }


    public static int[] Step(int [][] map, int [][] points) {
        int [] start = points[0];
        int i = start[0];
        int j = start[1];
        int count = 0;
        for (int m = 0; m < points.length; m++) {
            count += 1;
            if (points[count][0] == 0 && points[count][1] == 0 ) break;
        }
        if (map[i-1][j] == 0) {
            map[i-1][j] = map[i][j] + 1;
            points[count][0] = i-1;
            points[count][1] = j;
            count += 1;
        } 
        if (map[i][j+1] == 0) {
            map[i][j+1] = map[i][j] + 1;
            points[count][0] = i;
            points[count][1] = j+1;
            count += 1;
        } 
        if (map[i+1][j] == 0) {
            map[i+1][j] = map[i][j] + 1;
            points[count][0] = i+1;
            points[count][1] = j;
            count += 1;
        } 
        if (map[i][j-1] == 0) {
            map[i][j-1] = map[i][j] + 1;
            points[count][0] = i;
            points[count][1] = j-1;
            count += 1;
        } 
        for (int t = 0; t < points.length-1; t++) {
            points[t] = points[t+1];
        }
        start = points[0];           
        return start;
    }
            


    public static void DrawMap(int[][] map, int[] start, int[] finish1, int[] finish2) {
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == start[0] && j == start[1]) {
                    System.out.print("S");
                } else {
                    if ((i == finish1[0] && j == finish1[1]) || (i == finish2[0] && j == finish2[1])) {
                        System.out.print("F");
                    } else {
                        if (map[i][j] == 0) {
                            System.out.print("░");
                        } else {
                            if (map[i][j] == -1) {
                                System.out.print("█");
                            } else {
                                System.out.print(map[i][j]);
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void DrawMap2(int[][] map, int[] st, int[] finish1, int[] finish2, int [][] path) {
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int a = 0;
                if (i == st[0] && j == st[1]) {
                    System.out.print("S");
                } else {
                    if ((i == finish1[0] && j == finish1[1]) || (i == finish2[0] && j == finish2[1])) {
                        System.out.print("F");
                    } else {
                        if (map[i][j] == -1) {
                            System.out.print("█");
                        } else {  
                                for (int g = 0; g < path.length; g++) {
                                    if (i == path[g][0] && j == path[g][1]) {
                                        System.out.print("*");
                                        a = 1;
                                    }
                                } 
                                if (a == 0) {
                                    System.out.print("░");
                                }
                        }
                    }
                }
            }  
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] DrawPath(int[][] map, int[] finish, int finishValue) {     
        int i = finish[0];
        int j = finish[1];
        int k = 0;
        int [][] path = new int [25][2];
        while (finishValue > 1) {
            if (map[i-1][j] == finishValue - 1) {
            path[k][0] = i-1;
            i -=1;
            path[k][1] = j;
            k += 1;
            finishValue -=1;
            } else {
                if (map[i][j+1] == finishValue - 1) {
                    path[k][0] = i;
                    path[k][1] = j+1;
                    j +=1;
                    k += 1;
                    finishValue -=1;
                } else {
                    if (map[i+1][j] == finishValue - 1) {
                        path[k][0] = i+1;
                        i +=1;
                        path[k][1] = j;
                        k += 1;
                        finishValue -=1;
                    } else {
                        if (map[i][j-1] == finishValue - 1) {
                            path[k][0] = i;
                            path[k][1] = j-1;
                            j -= 1;
                            k += 1;
                            finishValue -=1;
                        }
                    }
                    
                }
            }
        }
        // for (int s = 0; s < path.length; s++) {
        //     for (int n = 0; n < path[s].length; n++) {
        //         System.out.print(path[s][n] + " ");
        //     }
        //     System.out.print("|");
        // }
        return path;
    }
}
