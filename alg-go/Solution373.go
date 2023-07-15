package main

import (
	"container/heap"
)

type pair struct {
	Sum   int
	Index int
	Nums1 int
	Nums2 int
}

type PriorityQueue []*pair

func (pq PriorityQueue) Len() int {
	return len(pq)
}

func (pq PriorityQueue) Less(i, j int) bool {
    return pq[i].Sum < pq[j].Sum
}

func (pq PriorityQueue) Swap(i, j int) {
    pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x interface{}) {
    *pq = append(*pq, x.(*pair))
}

func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[0 : n-1]
    return item
}

func kSmallestPairs(nums1 []int, nums2 []int, k int) [][]int {

}
