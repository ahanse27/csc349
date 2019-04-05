public class SortCounts {


    public static void main(String [] args){
        int N = 128000;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] arr3 = new int[N];
        long comparisons1 = 0;
        long comparisons2 = 0;
        long comparisons3 = 0;


        for (N = 100; N <= 12800; N=N*2){
            for (int t = 0; t < 100; t++) {

                for (int i = 0; i < N; i++) {
                    int n = (int) (Math.random() * N);
                    arr1[i] = n;
                    arr2[i] = n;
                    arr3[i] = n;
                }

                comparisons1 += Sorts.selectionSort(arr1, N);

                comparisons2 += Sorts.mergeSort(arr2, N);

                comparisons3 += Sorts.quickSort(arr2, N);


            }
            System.out.println("N=" + N+": C_ss="+ (comparisons1/100) +", C_ms="+ (comparisons2/100)+", C_qs="+ (comparisons3/100) );
            comparisons1 = 0;
            comparisons2 = 0;
            comparisons3 = 0;
        }

    }

}
