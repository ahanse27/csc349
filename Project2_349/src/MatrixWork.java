import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class MatrixWork{
    public static void main(String[] args)throws FileNotFoundException{
        int[] matSpec = readFile();
        int[][][] matrices = makeMat(matSpec);
        int[][] C = matrixProduct(matrices[0],matrices[1]);
        for (int[] row: C){
            for (int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static int[][]matrixProduct(int[][]A, int[][]B) throws IllegalArgumentException {
       if (B.length != A[0].length){ //check that mat sizes are valid
            throw new IllegalArgumentException();
        }
       int[][] multi = new int[A.length][B[0].length];
       int i = 0;
       int j = 0;
       boolean done = false;
       while (!done){
           if (i == A.length){
               i = 0;
           }
           else if (j == B[0].length){
               j = 0;
               i++;
           }
           int val = 0;
           for (int idx = 0; idx < A[0].length; idx ++){
               val = val + (A[i][idx] * B[idx][j]);
           }
           multi[i][j] = val;
           j++;
           if ((j == B[0].length) && (i + 1 == A.length)){
               done = true;
           }
        }

       return multi;
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
    public static int[][][] makeMat(int[] matSpec){
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
        bufferX = 0;
        bufferY = 0;
        nrow = matSpec[idx];
        idx++;
        ncol = matSpec[idx];
        idx++;

        int[][] matrixTwo = new int[nrow][ncol];

        for(int i = 0; i < (nrow * ncol); i++) {
            if (bufferY < ncol) {
                matrixTwo[bufferX][bufferY] = matSpec[idx];
                idx++;
                bufferY++;
            } else {
                bufferY = 0;
                if (bufferX < nrow) {
                    bufferX++;
                    matrixTwo[bufferX][bufferY] = matSpec[idx];
                    bufferY++;
                    idx ++;
                } else {
                    bufferX = 0;
                }
            }
        }
        int[][][] matrices = new int[2][matrixOne.length * matrixOne[0].length][matrixTwo.length * matrixTwo[0].length];
        matrices[0] = matrixOne;
        matrices[1] = matrixTwo;
        return matrices;
    }

}
