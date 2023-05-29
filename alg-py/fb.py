def fibonacci(n):
    dp = [0] * (n+1)
    dp[0] = 0
    dp[1] = 1
    for i in range(2, n+1):
        dp[i] = dp[i-1]+dp[i-2]
    return dp[i]


def test_fibonacci():
    # Test Case 1: n = 0
    result = fibonacci(0)
    assert result == 0, f"Expected 0, but got {result}"

    # Test Case 2: n = 1
    result = fibonacci(1)
    assert result == 1, f"Expected 1, but got {result}"

    # Test Case 3: n = 5
    result = fibonacci(5)
    assert result == 5, f"Expected 5, but got {result}"

    # Test Case 4: n = 10
    result = fibonacci(10)
    assert result == 55, f"Expected 55, but got {result}"

    # Test Case 5: n = 15
    result = fibonacci(15)
    assert result == 610, f"Expected 610, but got {result}"

    # Test Case 6: n = 20
    result = fibonacci(20)
    assert result == 6765, f"Expected 6765, but got {result}"

    print("All test cases passed!")

test_fibonacci()
