import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class MatrixWork{
    public static void main(String[] args)throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the file name");
        String filename = in.nextLine();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int counter = 0;
        while (sc.hasNextLine()){
            if (counter == 0){

            }
        }
    }
    public static int[][]matrixProduct(int[][]A, int[][]B) throws IllegalArgumentException {
       if (B.length != A[0].length){ //check that mat sizes are valid
            throw new IllegalArgumentException();
        }
    }

}
