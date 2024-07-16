package algorithms

import "fmt"

func fib(x int64) int64 {
	if x <= 1 {
		return x
	}
	return fib(x-1) + fib(x-2)
}

func fibonacci(x int64, y int64) {
	for i := x; i < y; i++ {
		fmt.Printf("Fibonacci no : range : %d : %d\n", i, fib(i))
	}
}
