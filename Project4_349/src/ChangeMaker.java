//Mani Movva (mmovva@calpoly.edu) and Anish Yakkala (ayakkala@calpoly.edu) Date: 05/10/19 Assignment: Project 4

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;

public class ChangeMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the number of coin-denominations and the set of coin values:");
        int k = in.nextInt();
        int[] d = new int[k];
        int counter = 0;
        while (counter < k) {
            d[counter] = in.nextInt();
            counter++;
        }
        while (1 == 1) {
            System.out.println("\nEnter a positive amount to be changed (enter 0 to quit):");
            int n = in.nextInt();
            if (n == 0) {
                System.out.println("Thanks for playing. Good Bye.");
                System.exit(0);
            }
            int[] counts = change_DP(n, d);
            System.out.println("\nDP algorithm results");
            System.out.println("Amount: " + n);
            System.out.printf("Optimal distribution: ");
            int sum = 0;
            for (int i = 0; i < d.length; i++) {
                if (counts[i] > 0) {
                    if (sum > 0) {
                        System.out.printf(" + " + counts[i] + "*" + d[i] + "c");
                    } else {
                        System.out.printf("" + counts[i] + "*" + d[i] + "c");
                    }
                    sum = sum + counts[i];
                }
            }
            System.out.println("\nOptimal coin count: " + sum);
        }
    }

    public static int[] change_DP(int n, int[] d) {
        int[] C = new int[n];
        int[] A = new int[n];
        C[0] = d.length - 1;
        A[0] = d.length - 1;
        for (int i = 2; i <= n; i++){
            int min = 9999;
            for (int j = 0; j < d.length; j++){
               int count = i/d[j];
               int remainder = i % d[j];
               if (count > 0) {
                   int added = 0;
                   if (remainder != 0){
                       added = C[remainder];
                   }
                   if (count + added < min) {
                       min = count + added;
                       C[i - 1] = min;
                       A[i - 1] = j;
                    }
                }

            }
        }
        int[] counts = new int[d.length];
        int next_coin = A[n-1];
        counts[next_coin] = counts[next_coin] + 1;
        int count_down = n - d[next_coin];
        while(count_down > 0){
            next_coin = A[count_down - 1];
            counts[next_coin] = counts[next_coin] + 1;
            count_down = count_down - d[next_coin];
        }
        //System.out.println(Arrays.toString(counts));
        return counts;
    }


}
