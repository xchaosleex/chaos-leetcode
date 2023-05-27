#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    string stoneGameIII(vector<int> &stoneValue)
    {
        int n = stoneValue.size();
        vector<int> dp(n + 1);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; --i)
        {
            dp[i] = INT_MIN;
            for (int k = 0, take = 0; k < 3 && i + k < n; ++k)
            {
                take += stoneValue[i + k];
                dp[i] = max(dp[i], take - dp[i + k + 1]);
            }
        }
        if (dp[0] > 0)
            return "Alice";
        else if (dp[0] < 0)
            return "Bob";
        else
            return "Tie";
    }
};

int main()
{
    Solution solution1 = Solution();
    // Test case 1
    vector<int> test1 = {2, 7, 9, 4, 4};
    cout << "Test case 1: \n"
         << solution1.stoneGameIII(test1) << endl; // Expected output: 10

    Solution solution2 = Solution();
    // Test case 2
    vector<int> test2 = {1, 2, 3, 4, 5, 100};
    cout << "Test case 2: \n"
         << solution2.stoneGameIII(test2) << endl; // Expected output: 104

    return 0;
}
