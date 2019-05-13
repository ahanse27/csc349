//Mani Movva (mmovva@calpoly.edu) and Anish Yakkala (ayakkala@calpoly.edu) Date: 05/10/19 Assignment: Project 4

public class Tester {

    public static void main(String[] args) {
        ChangeMaker cm = new ChangeMaker();
        int[][] denoms = new int[][]{{100, 50, 25, 10, 5, 1},
                                {100, 50, 20, 15, 10, 5, 3, 2, 1},
                                {64, 32, 16, 8, 4, 2, 1},
                                {100, 50, 25, 10, 1},
                                {66, 35, 27, 18, 10, 1}};

        System.out.println("Testing change_DP and change_greedy algorithms");
        for (int i = 0; i < 5; i++){
            int[] denom = denoms[i];
            int matches = 0;
            for (int j = 1; j <= 200; j++){
                int[] dp = cm.change_DP(j,denom);
                int[] greedy = cm.change_greedy(j,denom);
                int sum_dp = 0;
                int sum_greedy = 0;
                for (int k = 0; k < dp.length;k++){
                    sum_dp += dp[k];
                    sum_greedy += greedy[k];
                }
                if (sum_dp == sum_greedy) matches++;
                else if (i == 0){
                    System.out.println(j);
                    System.exit(0);
                }
            }

            System.out.println("Testing set" + (i+1) + ": " + matches + " matches in 200 tests");
        }

    }

}