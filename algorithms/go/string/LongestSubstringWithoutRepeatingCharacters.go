package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
    maxLen, start := 0, 0
    m := make(map[rune]int)
    for pos, char := range s {
        if j,ok := m[char]; ok {
            start = max(start, j + 1)
        }
        maxLen = max(maxLen, pos - start + 1)
        m[char] = pos
    }
    return maxLen
}

func max(num1 int, num2 int) int {
    if num1 > num2 {
        return num1
    }
    return num2
}

func main() {
    fmt.Print(lengthOfLongestSubstring("abcabcbb"))
    fmt.Println(" <---> 3")
    fmt.Print(lengthOfLongestSubstring("bbbbb"))
    fmt.Println(" <---> 1")
    fmt.Print(lengthOfLongestSubstring("pwwkew"))
    fmt.Println(" <---> 3")
    fmt.Print(lengthOfLongestSubstring("asdqewrafsgdfarse"))
    fmt.Println(" <---> 9")
    fmt.Print(lengthOfLongestSubstring("afqihvbzhdgfuadbvudhgyfuadbschjadugfabcuewqhgfujbhvgadvudjsbvuweygcjbvgdaffefc"))
    fmt.Println(" <---> 11")
    // fmt.Println(max(2,3))
    // fmt.Println(max(4,3))
    // fmt.Println(max(3,3))
    // fmt.Println(max(123,3))
    // fmt.Println(max(2,123))

}
