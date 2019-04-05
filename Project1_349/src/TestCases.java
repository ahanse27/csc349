import java.util.Arrays;

public class TestCases {
    public static void main(String[] args){
        int[] arr1 = {10,9,8};
        Sorts.selectionSort(arr1, 3);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1,1,1};
        Sorts.selectionSort(arr2, 3);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {10,9,8};
        Sorts.mergeSort(arr3, 3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1,1,1};
        Sorts.mergeSort(arr4, 3);
        System.out.println(Arrays.toString(arr4));
    }
}
