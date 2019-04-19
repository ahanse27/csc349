import java.util.Arrays;

public class MatrixProduct {
    public static int[][]matrixProduct_DAC(int[][]A, int[][] B){
        int colA = A[0].length;
        int rowA = A.length;
        int colB = B[0].length;
        int rowB = B.length;
        int n = A.length;
        try {
            if (colA != rowB || colA != rowA || colB != rowB || ((n & (n-1)) == 0)) {
                throw new IllegalArgumentException();
            }
            int[][] C = matrixProduct_DAC(A,1,1,B,1,1,n);
            return C;
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid Matrices");
        }
        return new int[1][1];
    }
    private static int[][] matrixProduct_DAC(int[][]A, int startrowA, int startcolA, int[][] B,
                                      int startrowB, int startcolB, int n){
        int[][] C = new int[n][n];
        if (n == 1){
            C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
        }
        else{
            int [][] C_one_one = sumMat(matrixProduct_DAC(A, startrowA, startcolA, B,
                                                       startrowB, startcolB, n/2),
                                        matrixProduct_DAC(A, startrowA, n/2 + 1, B,
                                                     n/2 + 1, startcolB, n/2));

            int [][] C_one_two = sumMat(matrixProduct_DAC(A, startrowA, startcolA, B,
                                                 startrowB,n/2 + 1 , n/2),
                                        matrixProduct_DAC(A, startrowA, n/2 + 1, B,
                                                n/2 + 1, n/2 + 1, n/2));

            int [][] C_two_one = sumMat(matrixProduct_DAC(A, n/2 + 1, startcolA, B,
                                                        startrowB, startcolB, n/2),
                                        matrixProduct_DAC(A, n/2 + 1, n/2 + 1, B,
                                                      n/2 + 1, 1, n/2));

            int [][] C_two_two = sumMat(matrixProduct_DAC(A, n/2 + 1, startcolA, B,
                                                    startrowB, n/2 + 1, n/2),
                                        matrixProduct_DAC(A, n/2 + 1, n/2 + 1, B,
                                                n/2 + 1, n/2 + 1, n/2));
        }

        return C;
    }
    private static int[][] sumMat(int[][] matrix1, int[][] matrix2){
        int [][] sum = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1.length; j++){
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }
    public static  int[][]  matrixProduct_Strassen(int[][] A,int[][] B){
        return new int[1][1];
    }

}
