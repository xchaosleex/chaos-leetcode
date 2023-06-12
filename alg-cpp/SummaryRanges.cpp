#include <vector>
#include <string>

/*
228. Summary Ranges
Easy
2.8K
1.5K
Companies
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
*/
using namespace std;

class Solution
{
public:
    vector<string> summaryRanges(vector<int> &nums)
    {
        vector<string> res;
        int n = nums.size();
        if (n == 0)
            return res;

        for (int i = 0; i < n; ++i)
        {
            int start = nums[i];
            while (i + 1 < n && static_cast<long long>(nums[i + 1]) - static_cast<long long>(nums[i]) == 1)
                i++;
            if (start != nums[i])
                res.push_back(to_string(start) + "->" + to_string(nums[i]));
            else
                res.push_back(to_string(start));
        }
        return res;
    }
};

/*
`static_cast` is a compile-time cast operator in C++. It is used to convert one type to another type. 
The conversion is checked at compile time to ensure it is valid and safe. 
It can perform conversions between types with some built-in semantic check.

Here's a very basic example:
```cpp
int i = 10;
double d = static_cast<double>(i);  // convert int to double
```
In this case, `static_cast` is used to convert an integer to a double.

In the code you posted, `static_cast<long long>(nums[i + 1])` is used to 
cast the integer `nums[i + 1]` to a `long long` type. This can be important in some scenarios 
where arithmetic operations (like subtraction in this case) can result in a value that is outside 
the range of the original type (int). It's a way of avoiding overflow errors.
*/