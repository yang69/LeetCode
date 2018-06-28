package main

import (
    "math"
    "fmt"
)

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    var a []int
    var b []int
    // 确保a是长度较小的那个数组
    if len(nums1) < len(nums2) {
        a, b = nums1, nums2
    } else {
        a, b = nums2, nums1
    }

    // 对a进行二分查找
    m := len(a)
    n := len(b)
    lo := 0
    hi := m
    for lo < hi {
        i := lo + (hi-lo)/2
        j := (m+n+1)/2 - i
        if 0 == i || n == j || a[i-1] <= b[j] {
            lo = i
        } else {
            hi = i - 1
        }
        if m == i || 0 == j || b[j-1] <= a[i] {
            hi = i
        } else {
            lo = i +1
        }
    }

    j := (m+n+1)/2 - lo
    var leftMax = math.MinInt32
    var rightMin = math.MaxInt32
    if lo > 0 {
        leftMax = a[lo-1]
    }
    if j > 0 {
        leftMax = max(leftMax, b[j-1])
    }
    if lo < m {
        rightMin = a[lo]
    }
    if j < n {
        rightMin = min(rightMin, b[j])
    }
    if (m+n) % 2 == 0 {
        return float64(leftMax + rightMin)/2
    }
    return float64(leftMax)
}

func max(a int, b int) int {
    if a > b {
        return a
    }
    return b
}

func min(a int, b int) int {
    if a < b {
        return a
    }
    return b
}

func main() {
    fmt.Print(findMedianSortedArrays([]int{1,3}, []int{2}))
    fmt.Println(" <---> 2")
    fmt.Print(findMedianSortedArrays([]int{1,2}, []int{3,4}))
    fmt.Println(" <---> 2.5")
    fmt.Print(findMedianSortedArrays([]int{3,4,5}, []int{1,2}))
    fmt.Println(" <---> 3")
}
