package algorithms

func divisiableBySum(arr []int, k int, l int) int {

	var count = 0

	for i := 0; i < l; i++ {
		for j := i + 1; j < l; j++ {
			if (arr[i] + arr[j]) % k == 0 {
				count++
			}
		}
	}

	return count
}
