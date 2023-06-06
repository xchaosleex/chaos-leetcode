#include <vector>

/*
Leetcode: 1502. Can Make Arithmetic Progression From Sequence

A sequence of numbers is called an arithmetic progression
if the difference between any two consecutive elements is the same.

Given an array of numbers arr, return true if the array can be rearranged to
form an arithmetic progression. Otherwise, return false.
*/
class Solution
{
public:
    bool canMakeArithmeticProgression(vector<int> &arr)
    {
        sort(arr.begin(), arr.end()); // sort the arr in ascending

        int diff = arr[1] - arr[0]; // calculate the difference between the first two elements

        for (int i = 2; i < arr.size(); ++i) // for each element in the arr
        {
            // if the difference between any two consecutive elements is not the same, return false.
            if (arr[i] - arr[i - 1] != diff)
            {
                return false;
            }
        }
        return true;
    }
};