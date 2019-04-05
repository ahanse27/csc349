import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestCases {
    @Test
    public void TestSelectionSort1() {
        int[] arr = {4, 9, 8, 7, 4};
        Sorts.selectionSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[]{4, 4, 7, 8, 9}, arr);
    }
    @Test
    public void TestSelectionSort2() {
        int[] arr = {1, 1, 1};
        Sorts.selectionSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[]{1, 1, 1}, arr);
    }
    @Test
    public void TestSelectionSort3() {
        int[] arr = {};
        Sorts.selectionSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {}, arr);
    }
    @Test
    public void TestMergeSort1() {
        int[] arr = {4, 9, 8, 7, 4};
        Sorts.mergeSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[]{4, 4, 7, 8, 9}, arr);
    }
    @Test
    public void TestMergeSort2() {
        int[] arr = {1,1,1};
        Sorts.mergeSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {1,1,1}, arr);
    }
    @org.junit.jupiter.api.Test
    public void TestMergeSort3() {
        int[] arr = {};
        Sorts.mergeSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {}, arr);
    }

    @org.junit.jupiter.api.Test
    void testQuickSort1() {
        int[] arr = {4, 9, 8, 7, 5};
        Sorts.quickSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[]{4, 5, 7, 8, 9}, arr);
    }


}
