#include <vector>
/*
Leetcode: 1232. Check If It Is a Straight Line
Date: 2023-06-05
Description: You are given an array coordinates, coordinates[i] = [x, y],
where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.
*/
class Solution
{
public:
    bool checkStraightLine(vector<vector<int>> &coordinates)
    {
        int n = coordinates.size();
        // check if all the points have the same x-coordinate
        int x = coordinates[0][0];
        for (int i = 1; i < n; i++)
        {
            if (coordinates[i][0] != x)
                break;
            if (n = n - 1)
                return true;
        }
    }

    // calculate the slope between the first two points
    float slope = (float)(coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);

    // Iterate over the remaining points and calculate the slope bewtween each of them and the first point
    for (int i = 2; i < n; i++)
    {
        // check if x2-x1 = 0
        if (coordinates[i][0] - coordinates[i - 1][0] == 0)
            return false;
        float m = (float)(coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0]);
        if (m != slope)
            return false;
    }
    return true;
};