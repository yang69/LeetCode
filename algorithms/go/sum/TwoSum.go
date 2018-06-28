// https://leetcode.com/problems/two-sum/discuss/540/12ms-easy-solution-in-Go
package main

import "fmt"

func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    for i, v := range nums {
        if j, ok := m[target-v]; ok {
            return []int{j, i}
        }
        m[v] = i
    }
    return []int{-1, -1}
}

func main() {
    fmt.Print(twoSum([]int{2, 7, 11, 15}, 9))
    fmt.Println(" <---> [0 1]")
    fmt.Print(twoSum([]int{2, 2}, 4))
    fmt.Println(" <---> [0 1]")
}
