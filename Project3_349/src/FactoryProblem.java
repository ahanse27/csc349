//Mani Movva (mmovva@calpoly.edu) and Anish Yakkala (ayakkala@calpoly.edu) Date: 05/10/19 Assignment: Project 3

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class FactoryProblem{
    public static void main(String[] args) throws FileNotFoundException{
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
        for (int i = 0; i < (n * 2); i++){
           a[i / n][i % n] = instruc[5 + i];
           counter++;
        }

        int t_n = n - 1;
        int[][] t = new int[2][t_n];
        for (int i = 0; i < (t_n * 2); i++){
           t[i / t_n][i % t_n] = instruc[counter + i];
        }
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(t));
    }
    public static int[] readFile() throws FileNotFoundException{
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