/*
Leetcode: 547. Number of Provinces

There are n cities. Some of them are connected, while some are not. 
If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the i-th city and the j-th city are directly connected, 
and isConnected[i][j] = 0 otherwise. Return the total number of provinces.
*/
class Solution
{
public:
    // This function performs a depth-first search (DFS) on the graph, starting at the given vertex.
    // The `isConnected` matrix represents the connections between the vertices in the graph.
    // The `visited` vector keeps track of which vertices have already been visited.
    void DFS(vector<vector<int>> &isConnected, vector<bool> &visited, int i)
    {
        // For each neighbor of the current vertex:
        for (int j = 0; j < isConnected.size(); ++j)
        {
            // If the neighbor is connected to the current vertex and has not been visited yet:
            if (isConnected[i][j] == 1 && !visited[j])
            {
                // Mark the neighbor as visited.
                visited[j] = true;
                // Recursively call DFS on the neighbor.
                DFS(isConnected, visited, j);
            }
        }
    }

    // This function finds the number of connected components in the graph.
    // A connected component is a group of vertices that are all connected to each other.
    int findCircleNum(vector<vector<int>> &isConnected)
    {
        // Initialize the number of provinces to 0.
        int provinces = 0;
        // Initialize the `visited` vector to all false.
        vector<bool> visited(isConnected.size(), false);
        // For each vertex in the graph:
        for (int i = 0; i < isConnected.size(); ++i)
        {
            // If the vertex has not been visited yet:
            if (!visited[i])
            {
                // Mark the vertex as visited.
                visited[i] = true;
                // Recursively call DFS on the vertex.
                DFS(isConnected, visited, i);
                // Increment the number of provinces by 1.
                provinces++;
            }
        }
        // Return the number of provinces.
        return provinces;
    }
};
