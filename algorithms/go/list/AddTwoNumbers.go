// https://leetcode.com/problems/add-two-numbers/discuss/1447/Easy-solution-in-Go
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummyHead := new(ListNode)
	current := dummyHead
	carry := 0
	for nil != l1 || nil != l2 || 0 != carry {
		num1, num2 := 0, 0
		if nil != l1 {
			num1, l1 = l1.Val, l1.Next
		}
		if nil != l2 {
			num2, l2 = l2.Val, l2.Next
		}
		sum := num1 + num2 + carry
		carry = sum / 10
		current.Next = &ListNode{Val: sum % 10, Next: nil}
		current = current.Next
	}
	return dummyHead.Next
}

func main() {
	l1 := ListNode{Val: 4}
	l2 := ListNode{Val: 6}
	fmt.Println(*(addTwoNumbers(&l1, &l2)).Next)
}
