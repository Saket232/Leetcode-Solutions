class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0; 
        int n = nums.length;
        Deque<Integer> temp = new LinkedList<>();  // Deque to store potential maximum elements for the current window
        int[] ans = new int[n - k + 1];  // Result array to store the maximum of each window
        int index = 0;  // Index to track position in the result array

        while (j < n) {
            // Step 1: Add the current element nums[j] to the deque in descending order
            // If the deque is empty, simply add the element
            if (temp.isEmpty()) {
                temp.add(nums[j]);
            } else {
                // Remove elements from the back of the deque while the new element is greater
                // This ensures the deque maintains a descending order
                while (temp.size() > 0 && nums[j] > temp.peekLast()) {
                    temp.removeLast();
                }
                // Add the current element to the back of the deque
                temp.add(nums[j]);
            }
            
            // Step 2: If the current window size is less than 'k', simply expand the window
            if (j - i + 1 < k) {
                j++;
            } 
            // Step 3: When the window reaches size 'k', we need to process the window
            else if (j - i + 1 == k) {
                // The maximum of the current window is at the front of the deque
                ans[index++] = temp.peek();

                // Step 4: Slide the window by moving 'i' and 'j'
                // Remove the element nums[i] from the deque if it is at the front
                int elementTobeRemoved = nums[i];
                if (!temp.isEmpty() && temp.peek() == elementTobeRemoved) {
                    temp.removeFirst();  // Remove the front element if it's no longer in the window
                }

                // Step 5: Slide the window forward
                i++;
                j++;
            }
        }
        return ans;  // Return the result array containing the maximums for each window
    }
}
