//Mani Movva (mmovva@calpoly.edu) and Anish Yakkala (ayakkala@calpoly.edu) Date: 04/05/19 Assignment: Project 1 

public class SortTimes {

    public static void main(String [] args){
        int N = 160000;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] arr3 = new int[N];

        for (N = 5000; N <= 160000; N=N*2){
            for (int t = 0; t < 5; t++){

                for (int i = 0; i < N; i++){
                    int n = (int)(Math.random()*N);
                    arr1[i] = n;
                    arr2[i] = n;
                    arr3[i] = n;
                }
                long startTime = System.nanoTime();
                Sorts.selectionSort(arr1, N);
                long endTime = System.nanoTime();
                long time1 = (endTime-startTime)/(1000000);

                startTime = System.nanoTime();
                Sorts.mergeSort(arr2, N);
                endTime = System.nanoTime();
                long time2 = (endTime-startTime)/(1000000);

                startTime = System.nanoTime();
                Sorts.quickSort(arr3, N);
                endTime = System.nanoTime();
                long time3 = (endTime-startTime)/(1000000);

                System.out.println("N=" + N+": T_ss="+ time1+", T_ms="+ time2+", T_qs="+ time3 );
            }
            System.out.println();
        }

    }

}
