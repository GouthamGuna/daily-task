package algorithms

func divisibleSumPairs(n int32, k int32, ar *[]int32) int32 {
	var count int32 = 0

	for i := 0; i < int(n); i++ {
		for j := i + 1; j < int(n); j++ {
			if ((*ar)[i] + (*ar)[j]) % k == 0 {
				count++
			}
		}
	}

	return count
}
