import java.util.Arrays;

public class TestCases {
    public static void main(String[] args){
        int[] arr1 = {4,9,8,7};
        Sorts.selectionSort(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1,1,1};
        Sorts.selectionSort(arr2, arr2.length);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {4,9,8,7};
        Sorts.mergeSort(arr3, arr3.length);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1,1,1};
        Sorts.mergeSort(arr4, arr4.length);
        System.out.println(Arrays.toString(arr4));
    }
}
