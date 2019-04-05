import java.util.Arrays;

public class Sorts {
    public static long selectionSort(int[] arr, int N){
        int comparisons = 0;
        for (int i = 0; i < N; i++){
            int minIndex = i;
            for (int j = i; j < N; j++){
                comparisons ++;
                if (arr[i] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return comparisons;
    }
    public static long mergeSort(int[] list, int N){
        int[] comparisons = {0};
        mergeSort(list, 0, N-1,comparisons);
        return comparisons[0];
    }
    private static void mergeSort (int[] list,  int first,  int last, int[] comparisons) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(list, first, middle, comparisons);
            mergeSort(list, middle + 1, last, comparisons);
            mergeSortedHalves(list, first, middle , last, comparisons);
        }
    }
    private static void mergeSortedHalves (int[]  arr, int left, int middle, int right, int[] comparisons){
        int[] temp = new int[right - left + 1];

        int index1 = left;
        int index2 = middle + 1;
        int index = 0;

        while (index1 < middle + 1 &&  index2 < right + 1){
            comparisons[0] = comparisons[0] + 1;
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

    public static long quickSort (int[] arr, int N){
        int[] comparisons = {0};
        if (arr.length > 1){
            quickSort(arr, 0, N-1, comparisons);
        }
        return comparisons[0];
    }

    private static void quickSort (int[] arr, int first, int last, int[] comparisons) {
        if (first < last){
            setPivotToEnd(arr,first,last, comparisons);
            int pivotIndex = splitList(arr,first,last,comparisons);
            quickSort(arr,first,pivotIndex-1, comparisons);
            quickSort(arr,pivotIndex+1,last, comparisons);
        }
    }

    private static void setPivotToEnd(int[] arr, int left, int right, int[] comparisons){
        int center = (left + right)/2;
        int temp;
        comparisons[0] = comparisons[0] + 1;
        if (arr[left] > arr[center]){
            temp = arr[center];
            arr[center] = arr[left];
            arr[left] = temp;
        }
        comparisons[0] = comparisons[0] + 1;
        if (arr[left] > arr[right]){
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        comparisons[0] = comparisons[0] + 1;
        if (arr[right] > arr[center]){
            temp = arr[right];
            arr[right] = arr[center];
            arr[center] = temp;
        }
        //Chooses a pivot in arr[left..right] and place it at the end of the segment
        //Precondition: none
        //Postcondition: arr[right] is the pivot.s
    }




    private static int splitList (int[] arr, int left, int right, int[] comparisons){
        //Rearranges the list by placing the pivot so that it is preceded by smaller
        //values and followed by greater values. Returns pivot’s index.
        //Precondition: arr[right] contains the pivot
        //Postcondition: the pivot is properly placed and its index is returned.
        // Elements in the list are arranged so that arr[i]<pivot for all arr[i]
        // located to the left of pivot, and arr[i]>pivot for all arr[i] located to
        // the right of the pivot.

        int indexL = left;
        int indexR = right-1;
        int pivot = arr[right];
        int temp;

        while (indexL < indexR) {
            while( arr[indexL] < pivot) {
                comparisons[0] = comparisons[0] + 1;
                indexL++;
            }
            while( indexR > indexL && arr[indexR] > pivot){
                comparisons[0] = comparisons[0] + 1;
                indexR--;
            }
            if (indexL < indexR) {
                temp = arr[indexL];
                arr[indexL] = arr[indexR];
                arr[indexR] = temp;
                indexL++;
                indexR--;
            }
        }
        temp = arr[indexL];
        arr[indexL] = arr[right];
        arr[right] = temp;
        return indexL;
    }


}
