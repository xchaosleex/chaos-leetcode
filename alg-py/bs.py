def countNegatives(grid: list[list[int]]) -> int:
    count = 0
    for row in grid:
        if row[0] < 0:
            count += len(row)
            continue
        left = 0
        right = len(row) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if row[mid] < 0:
                right = mid - 1
            else:
                left = mid + 1
        count += len(row) - left
    return count


print(countNegatives(
    grid=[[4, 3, 2, -1], [3, 2, 1, -1], [1, 1, -1, -2], [-1, -1, -2, -3]]))
