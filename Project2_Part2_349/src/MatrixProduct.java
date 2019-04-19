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
        // Solve A * B = C through blocking
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
            // Solve for first quadrant of C
            int [][] C_one_one = sumMat(matrixProduct_DAC(A, startrowA, startcolA, B,
                                                       startrowB, startcolB, halfway),
                                        matrixProduct_DAC(A, startrowA, startcolA + halfway , B,
                                                     startrowB + halfway , startcolB, halfway));
            // Solve for second quadrant of C
            int [][] C_one_two = sumMat(matrixProduct_DAC(A, startrowA, startcolA, B,
                                                 startrowB,startcolB + halfway  , halfway),
                                        matrixProduct_DAC(A, startrowA, startcolA + halfway , B,
                                                startrowB + halfway , startcolB + halfway, halfway));
            // Solve for third quadrant of C
            int [][] C_two_one = sumMat(matrixProduct_DAC(A, startrowA + halfway , startcolA, B,
                                                        startrowB, startcolB, halfway),
                                        matrixProduct_DAC(A, startrowA + halfway , startcolA+ halfway, B,
                                                      startrowB + halfway , startcolB, halfway));
            // Solve for fourth quadrant of C
            int [][] C_two_two = sumMat(matrixProduct_DAC(A, startrowA + halfway , startcolA, B,
                                                    startrowB, startcolB + halfway , halfway),
                                        matrixProduct_DAC(A, startrowA + halfway , startcolA + halfway , B,
                                                startrowB + halfway , startcolB + halfway , halfway));
            // Fill C with first quadrant
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i][j] = C_one_one[i][j];
                }
            }
            // Fill C with second quadrant
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i][j + halfway] = C_one_two[i][j];
                }
            }
            // Fill C with third quadrant
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i + halfway][j] = C_two_one[i][j];
                }
            }
            // Fill C with fourth quadrant
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
    private static int[][] strassenSub(int[][] matrix1,int startRow1, int startCol1, int[][] matrix2,
                                  int startRow2, int startCol2, int n){
        int [][] diff = new int[n][n];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                diff[i][j] = (matrix1[i + startRow1 - 1][j + startCol1 - 1]
                            - matrix2[i + startRow2 - 1][j + startCol2 - 1]);
            }
        }
        return diff;
    }
    private static int[][] strassenAdd(int[][] matrix1,int startRow1, int startCol1, int[][] matrix2,
                                       int startRow2, int startCol2, int n){
        int [][] sum = new int[n][n];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum[i][j] = (matrix1[i + startRow1 - 1][j + startCol1 - 1]
                        + matrix2[i + startRow2 - 1][j + startCol2 - 1]);
            }
        }
        return sum;
    }
    public static  int[][]  matrixProduct_Strassen(int[][] A,int[][] B){
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
            int[][] C = matrixProduct_Strassen(A,1,1,B,1,1,n);
            return C;
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid Matrices");
            return new int[1][1];
        }
    }
    private static  int[][]  matrixProduct_Strassen(int[][] A, int startrowA, int startcolA,
                                                    int[][] B, int startrowB, int startcolB, int n){
        // Solve A * B = C through blocking
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
            // 1,1 -> startrowA, startcolA
            // 1,2 -> startrowA, startcolA + halfway
            // 2,1 -> startrowB + halfway , startcolB
            // 2,2 -> startrowB + halfway , startcolB + halfway
            int[][] S_1 = strassenSub(B,startrowB, startcolB + halfway,
                    B, startrowB + halfway , startcolB + halfway,
                    halfway);
            int[][] S_2 = strassenAdd(A,startrowA, startcolA,
                    A, startrowA , startcolA + halfway,
                    halfway);
            int[][] S_3 = strassenAdd(A,startrowA + halfway, startcolA,
                    A, startrowA + halfway , startcolA + halfway,
                    halfway);
            int[][] S_4 = strassenSub(B,startrowB + halfway , startcolB,
                    B, startrowB, startcolB,
                    halfway);
            int[][] S_5 = strassenAdd(A,startrowA, startcolA,
                    A, startrowA + halfway , startcolA + halfway,
                    halfway);
            int[][] S_6 = strassenAdd(B,startrowB, startcolB,
                    B, startrowB + halfway , startcolB + halfway,
                    halfway);
            int[][] S_7 = strassenSub(A,startrowA, startcolA + halfway,
                    A, startrowA + halfway , startcolA + halfway,
                    halfway);
            int[][] S_8 = strassenAdd(B,startrowB + halfway, startcolB,
                    B, startrowB + halfway , startcolB + halfway,
                    halfway);
            int[][] S_9 = strassenSub(A,startrowA, startcolA,
                    A, startrowA + halfway , startcolA,
                    halfway);
            int[][] S_10 = strassenAdd(B,startrowB, startcolB,
                    B, startrowB, startcolB + halfway,
                    halfway);
            int[][] P_1 = matrixProduct_Strassen(A, startrowA, startcolA, S_1, 1, 1, halfway);
            int[][] P_2 = matrixProduct_Strassen(S_2, 1, 1, B, startrowB + halfway,
                                        startcolB + halfway, halfway);
            int[][] P_3 = matrixProduct_Strassen(S_3, 1, 1, B, startrowB, startcolB, halfway);
            int[][] P_4 = matrixProduct_Strassen(A, startrowA + halfway, startcolA + halfway,
                    S_4,1,1,halfway);
            int[][] P_5 = matrixProduct_Strassen(S_5, 1, 1, S_6, 1, 1, halfway);
            int[][] P_6 = matrixProduct_Strassen(S_7, 1, 1, S_8, 1, 1, halfway);
            int[][] P_7 = matrixProduct_Strassen(S_9, 1 ,1, S_10, 1, 1, halfway);
            // Solve for first quadrant of C
            int[][] C_one_one = strassenAdd(strassenSub(
                    strassenAdd(P_5, 1, 1,
                            P_4, 1, 1, halfway),1, 1,
                    P_2, 1 ,1, halfway),1 ,1,
                    P_6, 1, 1, halfway);
            // Solve for fourth quadrant of C
            int[][] C_two_two = strassenSub(strassenSub(
                    strassenAdd(P_5, 1, 1,
                            P_1, 1, 1, halfway),1, 1,
                            P_3, 1 ,1, halfway),1 ,1,
                                P_7, 1, 1, halfway);
            // Solve for third quadrant of C
            int [][] C_one_two = strassenAdd(P_1, 1, 1,
                                            P_2, 1 ,1, halfway);
            // Solve for fourth quadrant of C
            int [][] C_two_one = strassenAdd(P_3, 1 , 1,
                                            P_4, 1 ,1,
                                            halfway);
            // Fill C with first quadrant
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i][j] = C_one_one[i][j];
                }
            }
            // Fill C with second quadrant
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i][j + halfway] = C_one_two[i][j];
                }
            }
            // Fill C with third quadrant
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i + halfway][j] = C_two_one[i][j];
                }
            }
            // Fill C with fourth quadrant
            for (int i = 0; i < halfway; i++){
                for (int j = 0; j < halfway; j++){
                    C[i + halfway][j + halfway] = C_two_two[i][j];
                }
            }
        }
        return C;
    }

}
