import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;

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
        int[] arr = {};
        Sorts.selectionSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {}, arr);
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
    @org.junit.jupiter.api.Test
    public void TestQuickSort3() {
        int[] arr = {};
        Sorts.quickSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {}, arr);
    }
    @org.junit.jupiter.api.Test
    public void TestQuickSort4() {
        int[] arr = {1,1,1,1,1,1,1,1};
        Sorts.quickSort(arr, arr.length);
        Assertions.assertArrayEquals(new int[] {1,1,1,1,1,1,1,1}, arr);
    }

    @org.junit.jupiter.api.Test
    void testSelectionSortRand() {
        int N = 30;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int t = 0; t < 100; t++){
            System.out.print(t);
            System.out.println();
            for (int i = 0; i < N; i++){
                int n = (int)(Math.random()*N);
                arr1[i] = n;
                arr2[i] = n;
            }
            Sorts.selectionSort(arr1, arr1.length);

            Arrays.sort(arr2);
            for( int i = 0; i < arr2.length; i++){
                if(arr1[i] != arr2[i]) {
                    System.out.print("!");
                }
                System.out.print(arr1[i]);
            }
            System.out.println();
            for( int i = 0; i < arr2.length; i++){

                System.out.print(arr2[i]);
            }
            Assertions.assertArrayEquals(arr2, arr1);
        }

    }

    @org.junit.jupiter.api.Test
    void testMergeSortRand() {
        int N = 30;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int t = 0; t < 100; t++){
            System.out.print(t);
            System.out.println();
            for (int i = 0; i < N; i++){
                int n = (int)(Math.random()*N);
                arr1[i] = n;
                arr2[i] = n;
            }
            Sorts.mergeSort(arr1, arr1.length);

            Arrays.sort(arr2);
            for( int i = 0; i < arr2.length; i++){
                if(arr1[i] != arr2[i]) {
                    System.out.print("!");
                }
                System.out.print(arr1[i]);
            }
            System.out.println();
            for( int i = 0; i < arr2.length; i++){

                System.out.print(arr2[i]);
            }
            Assertions.assertArrayEquals(arr2, arr1);
        }

    }

    @org.junit.jupiter.api.Test
    void testQuickSortRand() {
        int N = 30;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int t = 0; t < 100; t++){
            for (int i = 0; i < N; i++){
                int n = (int)(Math.random()*N);
                arr1[i] = n;
                arr2[i] = n;
            }
            Sorts1.quickSort(arr1, arr1.length);
            Arrays.sort(arr2);

            Assertions.assertArrayEquals(arr2, arr1);
        }

    }

}
