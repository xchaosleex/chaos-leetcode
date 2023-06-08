/*
leetcode: 1351. Count Negative Numbers in a Sorted Matrix

Given a `m x n` matrix grid which is sorted in `non-increasing` order
both row-wise and column-wise, return the number of negative numbers in grid.
*/
class Solution
{
public:
    int countNegatives(vector<vector<int>> &grid)
    {
        int count = 0;
        for (auto &row : grid)
        {
            // first element is negative
            if (row[0] < 0)
            {
                count += row.size();
                continue;
            }
            // or binary search
            int left = 0, right = row.size() - 1;
            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            count += row.size() - left;
        }
        return count;
    }
};