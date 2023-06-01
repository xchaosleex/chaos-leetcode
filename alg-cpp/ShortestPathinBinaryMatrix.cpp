#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution
{
public:
    int shortestPathBinaryMatrix(vector<vector<int>> &grid)
    {
        int n = grid.size();
        if (grid[0][0] || grid[n - 1][n - 1])
            return -1;
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {1, 1}};
        vector<vector<int>> visited(n, vector<int>(n, 0));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0] = 1;
        int pathLength = 0;

        while (!q.empty())
        {
            int qSize = q.size();
            pathLength++;
            while (qSize--)
            {
                auto cur = q.front();
                q.pop();
                int i = cur.first, j = cur.second;
                if (i == n - 1 && j == n - 1)
                    return pathLength;
                for (auto &d : dir)
                {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni < 0 || nj < 0 || ni > n || nj > n || grid[ni][nj] || visited[ni][nj])
                        continue;
                    visited[ni][nj] = 1;
                    q.push({ni, nj});
                }
            }
        }
        return -1;
    }
};

int main()
{
    vector<vector<int>> grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
    Solution s;
    int ans = s.shortestPathBinaryMatrix(grid);
    cout << ans << endl;
    return 0;
}