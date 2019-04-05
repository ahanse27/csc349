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
    public static void mergeSort(int[] list, int N){
        mergeSort(list, 0, N-1);
    }
    private static void mergeSort (int[] list,  int first,  int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(list, first, middle);
            mergeSort(list, middle + 1, last);
            mergeSortedHalves(list, first, middle , last);
        }
    }
    private static void mergeSortedHalves (int[]  arr, int left, int middle, int right){
        int[] temp = new int[right - left + 1];

        int index1 = left;
        int index2 = middle + 1;
        int index = 0;

        while (index1 < middle + 1 &&  index2 < right + 1){
            if (arr[index1] <= arr[index2])
            {
                temp[index] = arr[index1];
                index1 = index1 + 1;
            }
            else
            {
                temp[index] = arr[index2];
                index2 = index2 + 1;
            }
            index = index + 1;
        }

        while (index1 < middle + 1)
        {
            temp[index] = arr[index1];
            index1 = index1 + 1;
            index = index + 1;
        }

        while (index2 < right + 1)
        {
            temp[index] = arr[index2];
            index2 = index2 + 1;
            index = index + 1;
        }

        int k = 0;
        for (int i = left; i < right + 1; i++){
            arr[i] = temp[k];
            k = k + 1;
        }
    }

}
