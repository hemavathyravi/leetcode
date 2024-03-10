/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int midfound=-1;
        int mid;
        int low=0,high=nums.length-1;
        int[] ret = {-1,-1};
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target)
            {
                midfound=mid;
                break;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        if(midfound==-1)
        {
            return ret;
        }
        int lastindex=-1,firstindex=-1;
        for(int i=midfound;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                lastindex=i;
            }
            else{
                break;
            }
        }
        for(int i=midfound;i>=0;i--)
        {
            if(nums[i]==target)
            {
                firstindex=i;
            }
            else{
                break;
            }
        }
        int[] ans={firstindex,lastindex};
        return ans;

        
    }
}
