package algorithms

import "fmt"

func ALG_Runners() {
	fmt.Printf("\nRunning Algorithms ALG_Runners\n")

	arr := []int64{10, 22, 55, 20, 1, 4, 5, 2, 3, 12}
	bubbleSort(arr)
	fmt.Println("Sorted Array: ", arr)

	fibonacci(1, 10)

	arr1 := []int{1, 3, 2, 6, 1, 2}

	fmt.Printf("Divisible Sum pairs  : %d\n", divisiableBySum(arr1, 3, len(arr1)))
}
