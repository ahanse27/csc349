import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class MatrixPrint{
    public static void main(String[] args)throws FileNotFoundException{
        int[] matSpec = readFile();
        int[][][] matrices = makeMat(matSpec);
        try {
            int[][] C = MatrixProduct.matrixProduct_DAC(matrices[0], matrices[1]);
            for (int[] row: C){
                for (int val : row){
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("Matrices are incompatible");
            return;
        }
    }
    public static int[] readFile() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filename = in.nextLine();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int[] matSpec = new int[1500];
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

