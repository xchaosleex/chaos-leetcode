#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    bool stoneGame(vector<int> &piles)
    {
        int n = piles.size();
        vector<vector<int>> dp(n, vector<int>(n));

        for (int i = 0; i < n; i++)
        {
            dp[i][i] = piles[i];
        }
        for (int d = 1; d < n; d++)
        {
            for (int i = 0; i < n - d; i++)
            {
                dp[i][i + d] = max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
};

int main()
{
    Solution solution1 = Solution();
    // Test case 1
    vector<int> test1 = {5, 3, 4, 5};
    cout << "Test case 1: \n"
         << solution1.stoneGame(test1) << endl; // Expected output: true

    Solution solution2 = Solution();
    // Test case 2
    vector<int> test2 = {3, 7, 2, 3};
    cout << "Test case 2: \n"
         << solution2.stoneGame(test2) << endl; // Expected output: true

    return 0;
}
