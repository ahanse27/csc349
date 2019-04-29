import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class GameProblem{
    public static void main(String[] args)throws FileNotFoundException{
        int[] matSpec = readFile();
        int[][] A = makeMat(matSpec);
        // System.out.println(Arrays.deepToString(matrix));
        game(A.length, A[0].length,A);

//        int[][] C = matrixProduct(matrices[0], matrices[1]);
//        for (int[] row: C) {
//            for (int val : row) {
//                System.out.print(val + ' ');
//            }
//            System.out.println();
//        }
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
            int val = sc.nextInt();
            matSpec[i] = val;
            i++;
        }
        return matSpec;
    }
    public static int[][] makeMat(int[] matSpec){
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
        int[] max =  {n-1,m-1};

        for (int j = m-2; j >= 0; j--){
            S[n-1][j] = Math.max(S[n-1][j+1],0) + A[n-1][j];
            if(S[n-1][j] == 0){
                R[n-1][j] = 'e';
            }
            else {
                R[n-1][j] = 'r';
            }
            if (S[n-1][j] > S[max[0]][max[1]]){
                    max[0] = n-1;
                    max[1] = j;
            }
        }
        for (int i = n-2; i >= 0; i--){
            S[i][m-1] = Math.max(S[i+1][m-1],0) + A[i][m-1];
            if(S[i][m-1] == 0){
                R[i][m-1] = 'e';
            }
            else {
                R[i][m-1] = 'r';
            }
            if (S[i][m-1] > S[max[0]][max[1]]){
                max[0] = i;
                max[1] = m-1;
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
                if (S[i][j] > S[max[0]][max[1]]){
                    max[0] = i;
                    max[1] = j;
                }
            }
        }
        System.out.println(S[max[0]][max[1]]);
        char instruction = R[max[0]][max[1]];
        System.out.printf(Arrays.toString(max), "to ");
//        while (instruction != "e"){
//            max =
//                System.out.print( grades[i][j]+ " " );
//            }
//        }

    }
}
