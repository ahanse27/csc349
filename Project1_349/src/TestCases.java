import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestCases {
    @Test
    public void TestSelectionSort1() {
        int[] arr = {4, 9, 8, 7, 4};
        long val = Sorts1.selectionSort(arr, arr.length);
        System.out.println(val);
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
        int[] arr = {10,9,8,7};
        Sorts.selectionSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {7,8,9,10}, arr);
    }
    @Test
    public void TestMergeSort1() {
        int[] arr = {4, 9, 8, 7, 4};
        long vals = Sorts1.mergeSort(arr, arr.length);
        System.out.println(vals);
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
        long vals = Sorts1.quickSort(arr, arr.length);
        System.out.println(vals);
        Assertions.assertArrayEquals(new int[]{4, 5, 7, 8, 9}, arr);
    }
    @org.junit.jupiter.api.Test
    void testQuickSort2() {
        int[] arr = {6, 7, 8, 9, 10};
        long vals = Sorts1.quickSort(arr, arr.length);
        System.out.println(vals);
        Assertions.assertArrayEquals(new int[]{6, 7, 8, 9, 10}, arr);
    }


}
