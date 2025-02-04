//solution 1

// Time Complexity :O(n**2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// code along with comments explaining the approach:
// Used 2 for loop to traverse through the array. Outer loop for i that we are returning
// inner loop to find j fromm array after ith element such that element at i + element at j = target

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}

//.......................

//solution2
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// code along with comments explaining the approach:
// 1. use hasmap to store the elements as keys and index as the values.
// 2. now loop through the array and for every element we are accessing, for the value =target-element
// 3. find if that value exists in the hashmap as key, get index as j and make sure the index is not equal to i
// 4. return [i,j]

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i){
                return new int[] {i, map.get(target-nums[i])};
            }
        }
        return new int [] {};
    }
}