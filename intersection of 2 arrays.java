/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> mylist  = new ArrayList<Integer>();
        while(i<nums1.length&&j<nums2.length)
        {
            if(nums1[i]==nums2[j]&&mylist.contains(nums1[i])==false)
            {
                mylist.add(nums1[i]);
            }
            else if(nums1[i]>nums2[j])
            {
                j++;
            }
            else
            {
                i++;
            }
        }
        int[] ans=new int[mylist.size()];
        for(int k=0;k<mylist.size();k++)
        {
            ans[k]=mylist.get(k);
        }
        return ans;

        
    }
}
