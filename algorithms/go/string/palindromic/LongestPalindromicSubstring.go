package main

import "fmt"

func longestPalindrome(s string) string {
    start, end := 0, 0
    for i := 0; i < len(s); i++ {
        len1 := expandAroundCenter(s, i, i)
        len2 := expandAroundCenter(s, i, i+1)
        length := max(len1, len2)
        if length > (end - start) {
            start = i - (length-1)/2
            end = i + length/2 + 1
        }
    }
    return s[start:end]
}

func max(a int, b int) int {
    if a > b {
        return a
    }
    return b
}

func expandAroundCenter(s string, left int, right int) int {
    l := left
    r := right
    for l >= 0 && r < len(s) && s[l] == s[r] {
        l--
        r++
    }
    return r - l - 1
}

func main() {
    fmt.Print(longestPalindrome("babad"));
    fmt.Println(" <---> bab")
}
