#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

class Solution
{
public:
    int minCost(int n, vector<int> &cuts)
    {
        int size = cuts.size();
        vector<int> newCuts(size + 2);
        for (int i = 0; i < size; ++i)
        {
            newCuts[i + 1] = cuts[i];
        }
        newCuts[0] = 0;
        newCuts[size + 1] = n;
        sort(newCuts.begin(), newCuts.end());

        vector<vector<int>> dp(size + 2, vector<int>(size + 2, 0));
        for (int len = 2; len < size + 2; ++len)
        {
            for (int i = 0; i + len < size + 2; ++i)
            {
                int j = i + len;
                dp[i][j] = INT_MAX;
                for (int k = i + 1; k < j; ++k)
                {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);
                }
                dp[i][j] += newCuts[j] - newCuts[i];
            }
        }
        return dp[0][size + 1];
    }
};

int main()
{
    Solution solution1 = Solution();
    // Test case 1
    vector<int> test1 = {5, 6, 1, 4, 2};
    cout << "Test case 1: \n"
         << solution1.minCost(9, test1) << endl; // Expected output: true

    Solution solution2 = Solution();
    // Test case 2
    vector<int> test2 = {1, 3, 4, 5};
    cout << "Test case 2: \n"
         << solution2.minCost(7, test2) << endl; // Expected output: true

    return 0;
}