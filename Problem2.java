//solution 1

// Time Complexity :O(2**n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : no(run time error- exceeding run time)
// Any problem you faced while coding this :no


// code along with comments explaining the approach:
//take, not take and check all possible cases(exhuastive)

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        return helper(capacity, val, wt, 0, 0);
    }
    static private int helper(int capacity, int val[], int wt[], int index, int profit){
        if(index== wt.length || capacity==0) return profit;
        //base
        int case1 =0;
        int case2 =0;
        //taken
        if(wt[index]<=capacity){
            case1 = helper(capacity-wt[index], val, wt, index+1, profit+val[index] );
        }
        //not taken
        case2 = helper(capacity, val, wt, index+1, profit);
        if(case1>case2) return case1;
        else return case2;
    }
}

//solution 2

// Time Complexity :O(n**2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// code along with comments explaining the approach:
// 1. in tabular dp i observed that we need just two rows so declared 2 1d arrays.
// 2. we update value only when capacity is greater than wt that we are dealing with.
// 3. if case 2 is true we update the value by taking max between the previous value or the value of current wt + previous value of capacity - current wt.  

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        if(val == null || wt == null || val.length == 0 || wt.length == 0) return 0;
        int n = val.length;
        int[] dp = new int[capacity+1];
        for (int i = 0; i < dp.length; i++) 
            dp[i] = 0;
        int[] temp = new int[capacity+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=capacity; j++){
                temp[j] = dp[j];
                if(j != 0 && wt[i]<=j) dp[j] = Math.max(temp[j], val[i] + temp[j-wt[i]]);
            }
        }
        return dp[capacity];
    }
}

