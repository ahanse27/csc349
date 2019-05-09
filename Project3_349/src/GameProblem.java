//Mani Movva (mmovva@calpoly.edu) and Anish Yakkala (ayakkala@calpoly.edu) Date: 05/10/19 Assignment: Project 3

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class GameProblem{
    public static void main(String[] args)throws FileNotFoundException{
        int[] matSpec = readFile();
        int[][] A = makeMat(matSpec);
        game(A.length, A[0].length,A);
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
    private static int[][] makeMat(int[] matSpec){
        int bufferX = 0;
        int bufferY = 0;
        int nrow = matSpec[0];
        int ncol = matSpec[1];
        int idx = 2;

        int[][] matrixOne = new int[nrow][ncol];

        for(int i = 0; i < (nrow * ncol); i++) {
            if (bufferY < ncol) {
                matrixOne[bufferX][bufferY] = matSpec[idx];
                idx++;
                bufferY++;
            } else {
                bufferY = 0;
                bufferX++;

                matrixOne[bufferX][bufferY] = matSpec[idx];

                bufferY++;
                idx ++;
            }
        }
        return matrixOne;
    }

    public static void game(int n, int m, int[][] A){
        int[][] S = new int[n][m];
        char[][] R = new char[n][m];

        S[n-1][m-1] = A[n-1][m-1];
        R[n-1][m-1] = 'e';
        int[] max =  {n,m};

        for (int j = m-2; j >= 0; j--){
            S[n-1][j] = Math.max(S[n-1][j+1],0) + A[n-1][j];
            if(S[n-1][j] == 0){
                R[n-1][j] = 'e';
            }
            else {
                R[n-1][j] = 'r';
            }
            if (S[n-1][j] > S[max[0] - 1][max[1] - 1]){
                    max[0] = n-1 + 1;
                    max[1] = j + 1;
            }
        }
        for (int i = n-2; i >= 0; i--){
            S[i][m-1] = Math.max(S[i+1][m-1],0) + A[i][m-1];
            if(S[i+1][m-1] < 0){
                R[i][m-1] = 'e';
            }
            else {
                R[i][m-1] = 'd';
            }
            if (S[i][m-1] > S[max[0] - 1][max[1] - 1]){
                max[0] = i + 1;
                max[1] = m - 1 + 1;
            }
        }
        for (int i = n-2; i>=0; i--){
            for (int j = m-2; j>=0; j--){

                if(S[i+1][j] > S[i][j+1]){
                    S[i][j] = S[i+1][j] + A[i][j];
                    R[i][j] = 'd';
                }
                else{
                    S[i][j] = S[i][j+1] + A[i][j];
                    R[i][j] = 'r';
                }
                if (S[i][j] > S[max[0] - 1][max[1] - 1]){
                    max[0] = i + 1;
                    max[1] = j + 1;
                }
            }
        }

        System.out.println("Best score: " + (S[max[0] - 1][max[1] - 1]));
        char instruction = R[max[0] - 1][max[1] - 1];
        System.out.printf("Best route: ");
        if (instruction == 'e'){
            System.out.printf("[" + max[0] + "," + max[1] + "]" + " to ");
        }
        else {
            while (instruction != 'e') {
                System.out.printf("[" + max[0] + "," + max[1] + "]" + " to ");
                if (instruction == 'd') {
                    instruction = R[max[0] + 1 - 1][max[1] - 1];
                    max[0] = max[0] + 1;
                } else if (instruction == 'r') {
                    //System.out.println(Arrays.toString(max));
                    instruction = R[max[0] - 1][max[1] + 1 - 1];
                    max[1] = max[1] + 1;
                }
            }
        }
        System.out.println("exit");

    }
}
