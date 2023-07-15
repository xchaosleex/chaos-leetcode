package main

import (
	"fmt"
	"sort"
)

func topKFrequent(nums []int, k int) []int {
	// use map record nums frequency
	frequencyMap := make(map[int]int)
	for _, num := range nums {
		frequencyMap[num]++
	}
	// collect all unique nums
	elements := make([]int, 0, len(frequencyMap))
	for key := range frequencyMap {
		elements = append(elements, key)
	}
	// sort by frequency desc
	sort.Slice(elements, func(i, j int) bool {
		return frequencyMap[elements[i]] > frequencyMap[elements[j]]
	})
	// return top k frequency
	res := make([]int, k)
	copy(res, elements[:k])
	return res
}

func main() {
	nums := []int{1, 1, 1, 2, 2, 3}
	k := 2
	fmt.Println(topKFrequent(nums, k))
}
