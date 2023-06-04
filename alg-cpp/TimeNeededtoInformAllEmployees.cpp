#include <vector>
#include <unordered_map>

using namespace std;
/*
@Topic: Time Needed to Inform All Employees
@URL: https://leetcode.com/problems/time-needed-to-inform-all-employees/
@Date: 2023-06-03

A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee,
manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure. The head of the company
wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates,
and they will inform their subordinates, and so on until all employees know about the urgent news.
The i-th employee needs informTime[i] minutes to inform all of his direct subordinates
(i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
Return the number of minutes needed to inform all the employees about the urgent news.
*/
class Solution
{
    unordered_map<int, vector<int>> subordinates;
    vector<int> informTime;

    int dfs(int id)
    {
        int maxTime = 0;
        for (int subId : subordinates[id])
        {
            maxTime = max(maxTime, dfs(subId));
        }
        return maxTime + informTime[id];
    }

public:
    int numOfMinutes(int n, int headID, vector<int> &manager, vector<int> &informTime)
    {
        this->informTime = informTime;
        for (int i = 0; i < n; ++i)
        {
            if (manager[i] != -1)
            {
                subordinates[manager[i]].push_back(i);
            }
        }
        return dfs(headID);
    }
};
