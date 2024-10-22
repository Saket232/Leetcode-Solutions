For s = "ADOBECODEBANC" and t = "ABC":
​
* We need to find the smallest window in s that contains all characters in t.
* The map for t would be: A -> 1, B -> 1, C -> 1.
* As we move j, we start expanding the window, and when the window contains all characters (count == 0), we try to shrink it by moving i while still maintaining the condition that the window contains all characters in t.
* The smallest valid window is "BANC", and that is returned as the result.
​
**Time Complexity:**
The time complexity is O(n + m), where n is the length of s and m is the length of t. This is because each character is processed at most twice, once when expanding the window and once when shrinking it.