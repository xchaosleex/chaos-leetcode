class Solution {
public:
    void DFS(vector<vector<int>>& isConnected, vector<bool>& visited, int i) {
        for (int j = 0; j < isConnected.size(); ++j) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                DFS(isConnected, visited, j);
            }
        }
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        int provinces = 0;
        vector<bool> visited(isConnected.size(), false);
        for (int i = 0; i < isConnected.size(); ++i) {
            if (!visited[i]) {
                DFS(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
};
