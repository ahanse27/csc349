import java.util.Scanner;

public class ChangeMaker {

    public static int[] change_DP(int n, int[] d){  /* n is the amount and d is the array for the coin-values */

        int e = d.length;
        int [] A = new int[n]; // 1 to n
        int [] B = new int[e]; //count of coins (di-denomination) for the given n
        int [] C = new int[n]; // the remainder of our coins to compute through

        C[0] = 1;
        A[0] = e - 1;

        for (int j = 2; j <= n; j++){ //
            int minCoin = 500000; //max value of coin integer
            for (int i = 0; i < e; i++){ //going the length of di - 5 (100, 25, 10, 5, 1)
                int remainder = j - d[i];
                if(remainder == 0){
                    minCoin = 0;
                    C[j - 1] = 1;
                    A[j - 1] = i;
                }
                else if(remainder > 0){
                    int count = 1;
                    int added = C[remainder - 1];
                    if(count + added < minCoin){
                        minCoin = count + added;
                        C[j - 1] = minCoin;
                        A[j - 1] = i;
                    }
        
                }
            }
        }
        int next_coin = A[n-1];
        B[next_coin] = B[next_coin] + 1;
        int count_down = n - d[next_coin];
        while(count_down > 0){
            next_coin = A[count_down - 1];
            B[next_coin] = B[next_coin] + 1;
            count_down = count_down - d[next_coin];
         }
        return B;
    }

    public static int[] change_greedy(int n, int[] d){
        int e = d.length;
        int [] A = new int[n]; // 1 to n
        int [] B = new int[e]; //count of coins (di-denomination) for the given n
        int [] C = new int[n]; // the remainder of our coins to compute through

        C[0] = 1;
        A[0] = e - 1;



        return B;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the total number of coins and the set of coin values in decreasing order.\n");
        System.out.println("Separate each new number by a space");
        /*
          input should look like: 5 100 25 10 5 1
          k = 5 (#of coins), d = 100 25 10 5 1 (value of each coin)
         */
        int k = in.nextInt();
        int[] d = new int[k];
        for (int counter = 0; counter < k; counter++){
            d[counter] = in.nextInt();
        }
        int n;
        
        int loopcount = 0;
        while (loopcount < k){ //repeat while n's value is positive
            System.out.println("Enter the total positive value of change needed or 0 to quit.");
            n = in.nextInt();
            if(n == 0){
                System.out.println("Zero has been entered and the program has ended.");
                System.exit(0);        /* purposeful exit */
            }
            int [] ch = change_DP(n, d);
            int [] chg = change_greedy(n, d);
            loopcount++;
            /* printing for change_dp */
            System.out.println("DP algorithm results");
            System.out.println("Amount: " + n);          
            System.out.print("Optimal distribution: " );
            int distr = 0;
            for(int l = 0; l < d.length; l++){
                if(ch[l] > 0){
                    if(distr > 0){
                        System.out.print(" + " + ch[l] + "*" + d[l] + "c");
                    }
                    else{
                        System.out.print("" + ch[l] + "*" + d[l] + "c");
                    }
                }
                distr = distr + ch[l];
            }
            System.out.print("\n");
            System.out.println("Optimal coin count: " + distr);

            
            /* printing for change_greedy */
            System.out.println("Greedy algorithm results");
            System.out.println("Amount: " + n);          
            System.out.print("Optimal distribution: " );
            int distr2 = 0;
            for(int l = 0; l < d.length; l++){
                if(ch[l] > 0){
                    if(distr2> 0){
                        System.out.print(" + " + chg[l] + "*" + d[l] + "c");
                    }
                    else{
                        System.out.print("" + chg[l] + "*" + d[l] + "c");
                    }
                }
                distr2 = distr2 + chg[l];
            }
            System.out.print("\n");
            System.out.println("Optimal coin count: " + distr2);

        }

    }
}
