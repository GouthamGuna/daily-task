package algorithms

import "fmt"

func ALG_Runners() {
	fmt.Printf("\nRunning Algorithms ALG_Runners\n")

	//Bubbole Sorting
	arr := []int64{10, 22, 55, 20, 1, 4, 5, 2, 3, 12}
	bubbleSort(arr)
	fmt.Println("Sorted Array: ", arr)

	// Fibonacci
	fibonacci(1, 10)

	// Divisiable Sum Pair
	arr1 := []int32{1, 3, 2, 6, 1, 2}
	var arrPointer *[]int32 = &arr1

	fmt.Printf("Divisible Sum pairs  : %d\n", divisibleSumPairs(int32(6), int32(3), arrPointer))
}
