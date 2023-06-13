package main

import "fmt"

func main() {
    a, b := 1, 2

    for a <= 10 && b <= 10 {
        fmt.Println(a, b)
        a, b = a+1, b+1 // Increment a and b using assignment statements
    }
}

