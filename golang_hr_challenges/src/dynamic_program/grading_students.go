package dynamicprogram

func gradingStudents(grades []int32) []int32 {

	if len(grades) == 0 {
		panic("Invalid grades")
	}

	var roundedGrades []int32

	for _, grade := range grades {

		if grade < 38 {
			roundedGrades = append(roundedGrades, grade)
		} else {
			remainder := ((grade / 5) + 1) * 5

			if remainder-grade < 3 {
				roundedGrades = append(roundedGrades, remainder)
			} else {
				roundedGrades = append(roundedGrades, grade)
			}
		}
	}

	return roundedGrades
}
