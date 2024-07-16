package algorithms

import "fmt"

func ALG_Runners() {
	fmt.Printf("\nRunning Algorithms ALG_Runners\n")

	arr := []int64{10, 22, 55, 20, 1, 4, 5, 2, 3, 12}
	bubbleSort(arr)
	fmt.Println("Sorted Array: ", arr)

	fibonacci(1, 10)
}
