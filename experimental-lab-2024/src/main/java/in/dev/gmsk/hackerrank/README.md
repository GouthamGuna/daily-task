# Problem, Solution, Reference in Hackerrank

 Number of lines in a jumba in the kangaroo problem solution.

 ```
public static String kangaroo(int x1, int v1, int x2, int v2) {
    if (x1 > x2 && v1 < v2 && (x1 - x2) % (v2 - v1) == 0) {
        return "YES";
    } else if (x1 < x2 && v1 > v2 && (x2 - x1) % (v1 - v2) == 0) {
        return "YES";
    } else if (x1 == x2 && v1 == v2) {
        return "YES";
    } else {
        return "NO";
    }
}
```

 * [Apples And Oranges](https://github.com/Mohammed-Benotmane/Hackerrank-Solution/blob/master/Easy/Apple%20ans%20Orange.java)

 * [Go Basics Skill Test](https://github.com/davidandradeduarte/go-basics-hackerrank/)
