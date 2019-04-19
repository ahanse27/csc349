import java.util.Arrays;

public class MatrixProduct {
    public static int[][]matrixProduct_DAC(int[][]A, int[][] B){
        int colA = A[0].length;
        int rowA = A.length;
        int colB = B[0].length;
        int rowB = B.length;
        int n = A.length;
        try {
            /* Check conditions for Divide and Conquer Matrix Multiplication
                - A is nxn matrix
                - B is nxn matrix
                - n is a power of 2
                If not throw IllegalArgumentException
             */
            if (colA != rowB || colA != rowA || colB != rowB || ((n & (n-1)) != 0)) {
                throw new IllegalArgumentException();
            }
            int[][] C = matrixProduct_DAC(A,1,1,B,1,1,n);
            return C;
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid Matrices");
            return new int[1][1];
        }
    }
    private static int[][] matrixProduct_DAC(int[][]A, int startrowA, int startcolA, int[][] B,
                                      int startrowB, int startcolB, int n){
        int[][] C = new int[n][n];
        if (n == 1){
            /* Base Case
             * Since we start indexing row and column at 1 we have to subtract
             * 1 to account for Java index starting at 0
             */
            C[0][0] = A[startrowA - 1][startcolA - 1] * B[startrowB - 1][startcolB - 1];
        }
        else{
            int halfway = n/2;
            int [][] C_one_one = sumMat(matrixProduct_DAC(A, startrowA, startcolA, B,
                                                       startrowB, startcolB, halfway),
                                        matrixProduct_DAC(A, startrowA, halfway + 1, B,
                                                     halfway + 1, startcolB, halfway));

            int [][] C_one_two = sumMat(matrixProduct_DAC(A, startrowA, startcolA, B,
                                                 startrowB,halfway + 1 , halfway),
                                        matrixProduct_DAC(A, startrowA, halfway + 1, B,
                                                halfway + 1, halfway + 1, halfway));

            int [][] C_two_one = sumMat(matrixProduct_DAC(A, halfway + 1, startcolA, B,
                                                        startrowB, startcolB, halfway),
                                        matrixProduct_DAC(A, halfway + 1, n/2 + 1, B,
                                                      halfway + 1, 1, halfway));

            int [][] C_two_two = sumMat(matrixProduct_DAC(A, halfway + 1, startcolA, B,
                                                    startrowB, halfway + 1, halfway),
                                        matrixProduct_DAC(A, halfway + 1, halfway + 1, B,
                                                halfway + 1, halfway + 1, halfway));

            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i][j] = C_one_one[i][j];
                }
            }
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i][j + halfway] = C_one_two[i][j];
                }
            }
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i + halfway][j] = C_two_one[i][j];
                }
            }
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i + halfway][j + halfway] = C_two_two[i][j];
                }
            }
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
        return sum;
    }
    public static  int[][]  matrixProduct_Strassen(int[][] A,int[][] B){
        return new int[1][1];
    }

}
