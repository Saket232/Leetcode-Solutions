Sorted + pair sum
→ Immediately signals Two Pointers (Opposite Direction)
Why It’s O(n)?
→ Each pointer moves at most n times.
Why is it guaranteed that moving pointers like this will never skip the correct answer?
→ Because the array is sorted, increasing the left pointer strictly increases the sum and decreasing the right pointer strictly decreases the sum. Therefore, we can safely discard impossible combinations
