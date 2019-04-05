import java.util.Random;

public class SortTimes {

    public static void main(String [] args){
        int N = 160000;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] arr3 = new int[N];

        for (int i = 0; i < N; i++){
            int n = (int)(Math.random()*N);
            arr1[i] = n;
            arr2[i] = n;
            arr3[i] = n;
            System.out.print(arr1[i]);
        }

    }
}
