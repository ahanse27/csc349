import java.util.Arrays;

public class Sorts {
    public static void selectionSort(int[] arr, int N){
        for (int i = 0; i < N; i++){
            int minIndex = i;
            for (int j = i; j < N; j++){
                if (arr[i] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void mergeSort(int[] arr, int N){
        if (arr.length > 1){
            int middle = arr.length / 2;
            int[] first = new int[middle];
            for (int i = 0; i < middle; i++){
                first[i] = arr[i];
            }
            int[] last = new int[N - middle];
            for (int i = 0; i < N - middle; i++){
                last[i] = arr[middle + i];
            }
            mergeSort(first,first.length);
            mergeSort(last, last.length);

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < middle &&  j < N - middle){
                if (first[i] <= last[j])
                {
                    arr[k] = first[i];
                    i = i + 1;
                }
                else
                {
                    arr[k] = last[j];
                    j = j + 1;
                }
                k = k + 1;
            }
            while (i < middle)
            {
                arr[k] = first[i];
                i = i + 1;
                k = k + 1;
            }

            while (j < N - middle)
            {
                arr[k] = last[j];
                j = j + 1;
                k = k + 1;
            }
        }
    }
}
