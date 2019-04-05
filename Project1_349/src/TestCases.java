import org.junit.jupiter.api.Test;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class TestCases {
    @Test
    public void TestSelectionSort1() {
        int[] arr = {4, 9, 8, 7};
        Sorts.selectionSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[]{4, 7, 8, 9}, arr);
    }
    @Test
    public void TestSelectionSort2() {
        int[] arr = {1, 1, 1};
        Sorts.selectionSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[]{1, 1, 1}, arr);
    }
    @Test
    public void TestMergeSort1() {
        int[] arr = {4, 9, 8, 7};
        Sorts.mergeSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[]{4, 7, 8, 9}, arr);
    }
    @Test
    public void TestMergeSort2() {
        int[] arr = {1,1,1};
        Sorts.mergeSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {1,1,1}, arr);
    }
}
