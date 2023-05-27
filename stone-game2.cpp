#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int stoneGameII(vector<int> &piles)
    {
        const int n = piles.size();
        // dp[i][j] := max # of stones Alice can get w/ piles[i:] and M = j
        dp.resize(n, vector<int>(n));
        // suffixSum[i] := sum of piles[i:]
        suffixSum = piles;

        for (int i = n - 2; i >= 0; --i)
            suffixSum[i] += suffixSum[i + 1];

        return stoneGameII(0, 1);
    }
     
private:
    vector<vector<int>> dp;
    vector<int> suffixSum;

    int stoneGameII(int i, int M)
    {
        if (i + 2 * M >= dp.size())
            return suffixSum[i];
        if (dp[i][M])
            return dp[i][M];

        int opponent = suffixSum[i];

        for (int X = 1; X <= 2 * M; ++X)
            opponent = min(opponent, stoneGameII(i + X, max(M, X)));

        return dp[i][M] = suffixSum[i] - opponent;
    }
};

int main()
{
    Solution solution1 = Solution();
    // Test case 1
    vector<int> test1 = {2, 7, 9, 4, 4};
    cout << "Test case 1: \n"
         << solution1.stoneGameII(test1) << endl; // Expected output: 10

    Solution solution2 = Solution();
    // Test case 2
    vector<int> test2 = {1, 2, 3, 4, 5, 100};
    cout << "Test case 2: \n"
         << solution2.stoneGameII(test2) << endl; // Expected output: 104

    return 0;
}
