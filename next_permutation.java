class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        
        // Find the index of the first element that breaks descending order
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // Index i is the break point
                ind = i;
                break;
            }
        }
        
        // If the array is in descending order, reverse it to get the smallest permutation
        if (ind == -1) {
            reverseArray(nums, 0, nums.length - 1);
            return;
        }
        
        // Find the smallest element in the suffix that is larger than nums[ind]
        for (int i = nums.length - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                // Swap nums[i] and nums[ind]
                int tmp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = tmp;
                break;
            }
        }
        
        // Reverse the suffix to get the next permutation
        reverseArray(nums, ind + 1, nums.length - 1);
    }

    public void reverseArray(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start < 0 || end >= arr.length || start >= end) {
            return;
        }

        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move start and end indices towards the center
            start++;
            end--;
        }
    }
}
