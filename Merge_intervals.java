/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> mylist = new ArrayList<>();

        for(int i=0;i<intervals.length;i++)
        {
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(mylist.size()!=0&&end<=mylist.get(mylist.size()-1).get(1))
            {
                continue;
            }
            for(int j=i+1;j<intervals.length;j++)
            {
            if(intervals[j][0]<=end)
            {
                end=Math.max(end,intervals[j][1]);
            }
            else
            {
                break;
            }

            }
            mylist.add(Arrays.asList(start, end));
            
        }
        int[][] ans = new int[mylist.size()][2];
        int j = 0;

        for (int i=0;i<mylist.size();i++) {
            ans[i][0] = mylist.get(i).get(0);
            ans[i][1] = mylist.get(i).get(1);
            
        }

        return ans;
        
    }
}
