//Mani Movva (mmovva@calpoly.edu) and Anish Yakkala (ayakkala@calpoly.edu) Date: 05/10/19 Assignment: Project 3

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class FactoryProblem{
    public static void main(String[] args) throws FileNotFoundException {
        int[] instruc = readFile();
        int n = instruc[0];
        int[] e = new int[2];

        e[0] = instruc[1];
        e[1] = instruc[2];

        int[] x = new int[2];
        x[0] = instruc[3];
        x[1] = instruc[4];

        int[][] a = new int[2][n];
        int counter = 5;
        for (int i = 0; i < (n * 2); i++) {
            a[i / n][i % n] = instruc[5 + i];
            counter++;
        }

        int t_n = n - 1;
        int[][] t = new int[2][t_n];
        for (int i = 0; i < (t_n * 2); i++) {
            t[i / t_n][i % t_n] = instruc[counter + i];
        }
        int[][][] answers = solveChassis(e, x, a, t);
        int[][] F = answers[0];
        int[][] L = answers[1];
        int min = 0;
        int start = 1;
        if (F[0][a[0].length - 1] + x[0] < F[1][a[0].length - 1] + x[1]){
            min = F[0][a[0].length - 1] + x[0];
            start = 0;
        }
        else{
            min = F[1][a[0].length - 1] + x[1];
            start = 1;
        }
        System.out.println("Fastest time is: " + min +"\n");
        System.out.println("The optimal route is:");
        printRoute(L,L[0].length - 1, start);
    }

    private static void printRoute(int[][] L, int start_col, int start_row){
        if (start_col == 0){
            System.out.println("station " + 1 + ",line " + L[start_row][start_col]);
            System.out.println("station " + (start_col + 2) + ",line " + (start_row + 1));
        }
        else{
            if (L[start_row][start_col] == 1){
                printRoute(L, start_col - 1, 0);
                System.out.println("station " + (start_col + 2) + ",line " + (start_row + 1));
            }
            else{
                printRoute(L, start_col - 1, 1);
                System.out.println("station " + (start_col + 2) + ",line " + (start_row + 1));
            }
        }
    }

    private static int[][][] solveChassis(int[] e, int[] x, int[][]a, int[][]t){
        int[][] F = new int[2][a[0].length];
        int[][] L = new int[2][a[0].length - 1];
        F[0][0] = a[0][0] + e[0];
        F[1][0] = a[1][0] + e[1];
        for (int i = 1; i < a[0].length; i++){
            int top_val = F[0][i-1];
            int bot_val = F[1][i-1];
            if (top_val < bot_val + t[1][i-1]){
                F[0][i] = top_val + a[0][i];
                L[0][i - 1] = 1;
            }
            else{
                F[0][i] = bot_val + t[1][i-1] + a[0][i];
                L[0][i - 1] = 2;
            }
            if (top_val + t[0][i-1] < bot_val){
                F[1][i] = top_val + t[0][i-1] + a[1][i];
                L[1][i - 1] = 1;
            }
            else{
                F[1][i] = bot_val + a[1][i];
                L[1][i - 1] = 2;
            }
        }
        int[][][] answers = new int[2][2][a[0].length];
        answers[0] = F;
        answers[1] = L;
        return answers;
    }

    private static int[] readFile() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filename = in.nextLine();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int[] matSpec = new int[100];
        int i = 0;
        while (sc.hasNextLine()){
            if (sc.hasNextInt()) {
                matSpec[i] = sc.nextInt();
                i++;
            }
        }
        return matSpec;
    }
}